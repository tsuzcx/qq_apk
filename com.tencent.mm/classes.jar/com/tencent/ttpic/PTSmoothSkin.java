package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.FaceBeautysRealAutoFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.CameraFilterParam;
import java.util.Map;

public class PTSmoothSkin
{
  private static final boolean HAS_SMOOTH = true;
  private int mBeautyLevel;
  private CameraFilterParam mBeautyParam = new CameraFilterParam();
  protected BaseFilter mFilter = new FaceBeautysRealAutoFilter();
  protected h mFilterFrame = new h();
  
  public PTSmoothSkin()
  {
    setBeautyLevel(1);
  }
  
  public void destroy()
  {
    if (this.mFilter != null) {
      this.mFilter.ClearGLSL();
    }
    if (this.mFilterFrame != null) {
      this.mFilterFrame.clear();
    }
  }
  
  public int getBeautyLevel()
  {
    return this.mBeautyLevel;
  }
  
  public int init()
  {
    if (this.mFilter == null) {
      return -1100;
    }
    this.mFilter.ApplyGLSLFilter(true, 1.0F, 1.0F);
    GlUtil.debugCheckGlError(this.mFilter);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, 0.0D, this.mFilterFrame);
    GlUtil.debugCheckGlError(this.mFilter);
    return 0;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    this.mBeautyLevel = paramInt;
    Map localMap = this.mBeautyParam.getSmoothMap(paramInt);
    this.mFilter.setParameterDic(localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.PTSmoothSkin
 * JD-Core Version:    0.7.0.1
 */