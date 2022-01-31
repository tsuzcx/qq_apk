package com.tencent.ttpic;

import android.graphics.Bitmap;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.VideoBlendFilter2;
import com.tencent.ttpic.gles.GlUtil;

public class PTBlendFilter
{
  private PTFilter mCopyFilter = PTFilter.createCopyFilter();
  protected VideoBlendFilter2 mFilter = new VideoBlendFilter2();
  private Bitmap mWatermarkBitmap;
  private int mWatermarkHeight;
  private int mWatermarkWidth;
  private int mWatermarkX;
  private int mWatermarkY;
  
  public void destroy()
  {
    this.mFilter.clearGLSLSelf();
    this.mCopyFilter.destroy();
  }
  
  public int init()
  {
    this.mFilter.ApplyGLSLFilter();
    this.mCopyFilter.init();
    GlUtil.debugCheckGlError(this);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mFilter.setWatermarkPosition(this.mWatermarkX, this.mWatermarkY, this.mWatermarkWidth, this.mWatermarkHeight, paramInt2, paramInt3);
    h localh = this.mFilter.renderWatermark(paramInt1, paramInt2, paramInt3);
    this.mCopyFilter.processTexture(localh.texture[0], paramInt2, paramInt3, paramInt4);
    GlUtil.debugCheckGlError(this.mFilter);
    return 0;
  }
  
  public void setWatermarkBitmap(Bitmap paramBitmap)
  {
    this.mWatermarkBitmap = paramBitmap;
    this.mFilter.setWatermarkBitmap(this.mWatermarkBitmap);
  }
  
  public void setWatermarkPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWatermarkX = paramInt1;
    this.mWatermarkY = paramInt2;
    this.mWatermarkWidth = paramInt3;
    this.mWatermarkHeight = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.PTBlendFilter
 * JD-Core Version:    0.7.0.1
 */