package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.view.g;

public class PTSegment
{
  private int SEG_HEIGHT;
  private int SEG_WIDTH;
  private FabbyStrokeFilter fabbyBgExtractFilter;
  private ExpFilter mExpFilter;
  private int mSegmentTex;
  private int mbgTex;
  private Bitmap mbp;
  private h segmentMaskFrame;
  private h segmentOutFrame;
  
  public PTSegment()
  {
    AppMethodBeat.i(81593);
    this.segmentMaskFrame = new h();
    this.segmentOutFrame = new h();
    this.SEG_WIDTH = 16;
    this.SEG_HEIGHT = 16;
    AppMethodBeat.o(81593);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(81596);
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
    AppMethodBeat.o(81596);
  }
  
  public void init()
  {
    AppMethodBeat.i(81594);
    int[] arrayOfInt = new int[2];
    GLES20.glGenTextures(2, arrayOfInt, 0);
    this.mSegmentTex = arrayOfInt[0];
    this.mbgTex = arrayOfInt[1];
    this.mExpFilter = new ExpFilter();
    this.mExpFilter.ApplyGLSLFilter();
    this.fabbyBgExtractFilter = new FabbyStrokeFilter();
    this.fabbyBgExtractFilter.ApplyGLSLFilter();
    AppMethodBeat.o(81594);
  }
  
  public h segTexture(PTFaceAttr paramPTFaceAttr, h paramh, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81595);
    if ((paramPTFaceAttr.getFaceCount() != 0) && (FabbyManager.getInstance().IsInitSuccess()))
    {
      if (this.mbp == null)
      {
        this.mbp = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.mbp.eraseColor(Color.argb(0, 255, 255, 255));
      }
      GlUtil.loadTexture(this.mbgTex, this.mbp);
      paramPTFaceAttr = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      g.a(paramh.texture[0], paramInt1, paramInt2, paramPTFaceAttr);
      paramPTFaceAttr = Bitmap.createScaledBitmap(paramPTFaceAttr, this.SEG_WIDTH * 16, this.SEG_HEIGHT * 16, false);
      Bitmap localBitmap = Bitmap.createBitmap(this.SEG_WIDTH, this.SEG_HEIGHT, Bitmap.Config.ARGB_8888);
      FabbyManager.getInstance().segmentOnBitmap(paramPTFaceAttr, localBitmap, this.SEG_WIDTH * 16, this.SEG_HEIGHT * 16, this.SEG_WIDTH, this.SEG_HEIGHT);
      GlUtil.loadTexture(this.mSegmentTex, localBitmap);
      this.mExpFilter.updateParam(paramInt1, paramInt2, this.SEG_WIDTH, this.SEG_HEIGHT);
      this.mExpFilter.RenderProcess(this.mSegmentTex, paramInt1, paramInt2, -1, 0.0D, this.segmentMaskFrame);
      this.fabbyBgExtractFilter.setRenderMode(1);
      this.fabbyBgExtractFilter.setmMaskTex(this.segmentMaskFrame.texture[0]);
      this.fabbyBgExtractFilter.setStepX(1.0F / paramInt1);
      this.fabbyBgExtractFilter.setStepY(1.0F / paramInt2);
      this.fabbyBgExtractFilter.setStrokeGapInPixel(0.0F);
      this.fabbyBgExtractFilter.setStrokeWidthInPixel(Math.min(paramInt1, paramInt2) * paramFloat);
      this.fabbyBgExtractFilter.setStrokeColor(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
      this.fabbyBgExtractFilter.RenderProcess(paramh.texture[0], paramInt1, paramInt2, this.mbgTex, 0.0D, this.segmentOutFrame);
      this.fabbyBgExtractFilter.setRenderMode(0);
      paramPTFaceAttr = this.segmentOutFrame;
      AppMethodBeat.o(81595);
      return paramPTFaceAttr;
    }
    AppMethodBeat.o(81595);
    return paramh;
  }
  
  public void setWidth_Height(int paramInt1, int paramInt2)
  {
    this.SEG_WIDTH = paramInt1;
    this.SEG_HEIGHT = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.PTSegment
 * JD-Core Version:    0.7.0.1
 */