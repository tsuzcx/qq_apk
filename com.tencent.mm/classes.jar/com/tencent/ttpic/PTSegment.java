package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.FabbyManager;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.view.f;

public class PTSegment
{
  private static final int SEG_HEIGHT = 16;
  private static final int SEG_WIDTH = 16;
  private FabbyStrokeFilter fabbyBgExtractFilter;
  private ExpFilter mExpFilter;
  private int mSegmentTex;
  private int mbgTex;
  private Bitmap mbp;
  private h segmentMaskFrame = new h();
  private h segmentOutFrame = new h();
  
  public void destroy()
  {
    if (this.mExpFilter != null) {
      this.mExpFilter.clearGLSLSelf();
    }
    if (this.fabbyBgExtractFilter != null) {
      this.fabbyBgExtractFilter.clearGLSLSelf();
    }
    if (this.segmentMaskFrame != null) {
      this.segmentMaskFrame.clear();
    }
    if (this.segmentOutFrame != null) {
      this.segmentOutFrame.clear();
    }
    if (this.mbp != null) {
      this.mbp.recycle();
    }
    GLES20.glDeleteTextures(1, new int[] { this.mSegmentTex }, 0);
  }
  
  public void init()
  {
    int[] arrayOfInt = new int[2];
    GLES20.glGenTextures(2, arrayOfInt, 0);
    this.mSegmentTex = arrayOfInt[0];
    this.mbgTex = arrayOfInt[1];
    this.mExpFilter = new ExpFilter();
    this.mExpFilter.ApplyGLSLFilter();
    this.fabbyBgExtractFilter = new FabbyStrokeFilter();
    this.fabbyBgExtractFilter.ApplyGLSLFilter();
  }
  
  public int segTexture(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if (this.mbp == null)
    {
      this.mbp = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      this.mbp.eraseColor(Color.argb(0, 255, 255, 255));
    }
    GlUtil.loadTexture(this.mbgTex, this.mbp);
    Bitmap localBitmap1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    f.a(paramInt1, paramInt2, paramInt3, localBitmap1);
    localBitmap1 = Bitmap.createScaledBitmap(localBitmap1, 256, 256, false);
    Bitmap localBitmap2 = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
    FabbyManager.getInstance().segmentOnBitmap(localBitmap1, localBitmap2, 256, 256, 16, 16);
    GlUtil.loadTexture(this.mSegmentTex, localBitmap2);
    this.mExpFilter.updateParam(paramInt2, paramInt3, 16, 16);
    this.mExpFilter.RenderProcess(this.mSegmentTex, paramInt2, paramInt3, -1, 0.0D, this.segmentMaskFrame);
    VideoFilterUtil.setBlendMode(true);
    this.fabbyBgExtractFilter.setmMaskTex(this.segmentMaskFrame.texture[0]);
    this.fabbyBgExtractFilter.setStepX(1.0F / paramInt2);
    this.fabbyBgExtractFilter.setStepY(1.0F / paramInt3);
    this.fabbyBgExtractFilter.setStrokeGapInPixel(0.0F);
    this.fabbyBgExtractFilter.setStrokeWidthInPixel(Math.min(paramInt2, paramInt3) * paramFloat);
    this.fabbyBgExtractFilter.setStrokeColor(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
    this.fabbyBgExtractFilter.RenderProcess(paramInt1, paramInt2, paramInt3, this.mbgTex, 0.0D, this.segmentOutFrame);
    VideoFilterUtil.setBlendMode(false);
    return this.segmentOutFrame.texture[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.PTSegment
 * JD-Core Version:    0.7.0.1
 */