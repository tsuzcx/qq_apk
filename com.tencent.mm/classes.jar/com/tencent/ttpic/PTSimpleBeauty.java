package com.tencent.ttpic;

import com.tencent.filter.h;
import com.tencent.ttpic.config.SimpleBeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.SimpleBeautyParam;
import com.tencent.ttpic.filter.SimpleBeautyTransformList;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.SimpleBeautyRealUtil;

public class PTSimpleBeauty
{
  private h mBeautyFrame = new h();
  private PTFilter mCopyFilter = PTFilter.createCopyFilter();
  private h mInputFrame = new h();
  private SimpleBeautyParam mSimpleBeautyParam = new SimpleBeautyParam(true);
  private SimpleBeautyTransformList mSimpleBeautyTransformList = new SimpleBeautyTransformList();
  
  public void destroy()
  {
    this.mSimpleBeautyTransformList.clear();
    this.mCopyFilter.destroy();
    this.mBeautyFrame.clear();
    this.mInputFrame.clear();
  }
  
  public int init()
  {
    this.mSimpleBeautyTransformList.initial();
    this.mCopyFilter.init();
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, PTFaceAttr paramPTFaceAttr, int paramInt4)
  {
    if (paramPTFaceAttr == null) {
      return -1300;
    }
    this.mInputFrame.a(paramInt1, paramInt2, paramInt3, 0.0D);
    this.mSimpleBeautyTransformList.process(this.mInputFrame, paramInt4, paramPTFaceAttr.getAllFacePoints(), paramPTFaceAttr.getAllFaceAngles(), null, null, null, null, paramPTFaceAttr.getFaceScale());
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public void setBeautyParam(SimpleBeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    if ((this.mSimpleBeautyTransformList != null) && (this.mSimpleBeautyParam != null)) {
      this.mSimpleBeautyTransformList.setBeautyParam(paramTYPE.value, SimpleBeautyRealUtil.getDistortParam(this.mSimpleBeautyParam.getDistortList(paramTYPE.value), paramInt, paramTYPE.value));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.PTSimpleBeauty
 * JD-Core Version:    0.7.0.1
 */