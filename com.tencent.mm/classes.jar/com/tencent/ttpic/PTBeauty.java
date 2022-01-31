package com.tencent.ttpic;

import com.tencent.filter.h;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.BeautyRealUtil;

public class PTBeauty
{
  private static final boolean HAS_BEAUTY = true;
  private h mBeautyFrame = new h();
  private BeautyParam mBeautyParam = new BeautyParam(true);
  private BeautyTransformList mBeautyTransformList = new BeautyTransformList();
  private PTFilter mCopyFilter = PTFilter.createCopyFilter();
  private h mInputFrame = new h();
  
  public void destroy()
  {
    this.mBeautyTransformList.clear();
    this.mCopyFilter.destroy();
    this.mBeautyFrame.clear();
    this.mInputFrame.clear();
  }
  
  public int init()
  {
    this.mBeautyTransformList.initial();
    this.mCopyFilter.init();
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, PTFaceAttr paramPTFaceAttr, int paramInt4)
  {
    if (paramPTFaceAttr == null)
    {
      this.mCopyFilter.processTexture(paramInt1, paramInt2, paramInt3, paramInt4);
      return -1;
    }
    this.mCopyFilter.processTextureToFrame(paramInt1, paramInt2, paramInt3, this.mInputFrame);
    paramPTFaceAttr = this.mBeautyTransformList.process(this.mInputFrame, paramPTFaceAttr.getAllFacePoints(), paramPTFaceAttr.getAllFaceAngles(), null, null, null, null, paramPTFaceAttr.getFaceScale());
    this.mCopyFilter.processTexture(paramPTFaceAttr.texture[0], paramInt2, paramInt3, paramInt4);
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public void setBeautyParam(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    if ((this.mBeautyTransformList != null) && (this.mBeautyParam != null)) {
      this.mBeautyTransformList.setBeautyParam(paramTYPE.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(paramTYPE.value), paramInt, paramTYPE.value));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.PTBeauty
 * JD-Core Version:    0.7.0.1
 */