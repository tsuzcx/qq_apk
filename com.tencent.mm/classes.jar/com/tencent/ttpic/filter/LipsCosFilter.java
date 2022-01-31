package com.tencent.ttpic.filter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.microrapid.opencv.CosmeticsHandle;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.view.g;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class LipsCosFilter
{
  public static final String FRAGMENT_SHADER;
  float[] cords;
  int[][] fPoints;
  private BaseFilter mCropFilter;
  private h mCropFrame;
  byte[] mData;
  private BaseFilter mFilter;
  private h mFrame;
  private int mHeight;
  private Bitmap mLut;
  private float mScale;
  private int mTex;
  private int mType;
  private int mWidth;
  
  static
  {
    AppMethodBeat.i(82649);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LipsCosFragment.dat");
    if (FeatureManager.isSegmentationReady()) {
      try
      {
        FeatureManager.loadLibrary("algo_rithm_jni");
        AppMethodBeat.o(82649);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        LogUtils.e(localUnsatisfiedLinkError);
        AppMethodBeat.o(82649);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        LogUtils.e(localRuntimeException);
        AppMethodBeat.o(82649);
        return;
      }
      catch (Exception localException)
      {
        LogUtils.e(localException);
      }
    }
    AppMethodBeat.o(82649);
  }
  
  public LipsCosFilter()
  {
    AppMethodBeat.i(82642);
    this.mCropFilter = null;
    this.mFilter = null;
    this.mType = 1;
    this.mScale = 1.0F;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mCropFrame = new h();
    this.mFrame = new h();
    this.mTex = 0;
    this.cords = new float[8];
    this.mData = null;
    this.fPoints = ((int[][])Array.newInstance(Integer.TYPE, new int[] { 83, 2 }));
    AppMethodBeat.o(82642);
  }
  
  public static Bitmap getBitmapFromAsset(Context paramContext, String paramString)
  {
    AppMethodBeat.i(82647);
    AssetManager localAssetManager = paramContext.getAssets();
    paramContext = null;
    try
    {
      paramString = BitmapFactory.decodeStream(localAssetManager.open(paramString));
      paramContext = paramString;
    }
    catch (IOException paramString)
    {
      label23:
      break label23;
    }
    AppMethodBeat.o(82647);
    return paramContext;
  }
  
  private void initData(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.mData == null) || (this.mData.length < paramInt1 * paramInt2 * 4)) {
        this.mData = new byte[paramInt1 * paramInt2 * 4];
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82643);
    this.mFilter = new BaseFilter(FRAGMENT_SHADER);
    this.mFilter.addParam(new m.i("type", this.mType));
    this.mFilter.addParam(new m.k("inputImageTexture2", this.mLut, 33986, true));
    this.mFilter.addParam(new m.f("adjustAlpha", 1.0F));
    this.mFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    AppMethodBeat.o(82643);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82644);
    this.mFilter.ClearGLSL();
    this.mFilter = null;
    this.mCropFrame.clear();
    this.mFrame.clear();
    AppMethodBeat.o(82644);
  }
  
  public void setCosAlpha(float paramFloat)
  {
    AppMethodBeat.i(82646);
    this.mFilter.addParam(new m.f("adjustAlpha", paramFloat));
    AppMethodBeat.o(82646);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82648);
    if (this.mFilter != null) {
      this.mFilter.setRenderMode(paramInt);
    }
    AppMethodBeat.o(82648);
  }
  
  public void setTypeAndLut(int paramInt, Bitmap paramBitmap)
  {
    this.mType = paramInt;
    this.mLut = paramBitmap;
    if (this.mLut == null) {
      this.mType = 0;
    }
  }
  
  public h updateAndRender(h paramh, int paramInt1, int paramInt2, List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap)
  {
    AppMethodBeat.i(82645);
    int n;
    int i;
    int m;
    try
    {
      initData(paramh.width, paramh.height);
      n = 2147483647;
      j = -2147483648;
      k = 65;
      i = -2147483648;
      m = 2147483647;
      while (k <= 82)
      {
        n = (int)Math.min(n, ((PointF)paramList.get(k)).x);
        j = (int)Math.max(j, ((PointF)paramList.get(k)).x);
        m = (int)Math.min(m, ((PointF)paramList.get(k)).y);
        i = (int)Math.max(i, ((PointF)paramList.get(k)).y);
        k += 1;
      }
      k = j - n + 1;
    }
    catch (OutOfMemoryError paramList)
    {
      AppMethodBeat.o(82645);
      return paramh;
    }
    n -= (int)(k * 0.3D);
    m -= (int)(k * 0.25D);
    int j = (int)(k * 0.3D) + j;
    int k = (int)(k * 0.25D) + i;
    float f1 = paramInt1 * this.mScale;
    float f2 = paramInt2;
    f2 = this.mScale * f2;
    if ((n >= f1) || (j < 0) || (m >= f2) || (k < 0))
    {
      AppMethodBeat.o(82645);
      return paramh;
    }
    if (n < 0) {}
    for (paramInt1 = 0;; paramInt1 = n)
    {
      if (j >= f1) {}
      for (paramInt2 = (int)f1 - 1;; paramInt2 = j)
      {
        if (m < 0) {}
        for (i = 0;; i = m)
        {
          j = k;
          if (k >= f2) {
            j = (int)f2 - 1;
          }
          this.cords[0] = (paramInt1 / f1);
          this.cords[1] = (i / f2);
          this.cords[2] = (paramInt1 / f1);
          this.cords[3] = (j / f2);
          this.cords[4] = (paramInt2 / f1);
          this.cords[5] = (j / f2);
          this.cords[6] = (paramInt2 / f1);
          this.cords[7] = (i / f2);
          paramInt2 = (int)((paramInt2 - paramInt1) / this.mScale);
          j = (int)((j - i) / this.mScale);
          k = (int)(paramInt1 / this.mScale);
          i = (int)(i / this.mScale);
          GlUtil.saveTextureToRgbaBuffer(paramh.texture[0], k, i, paramInt2, j, this.mData, paramh.bte[0]);
          paramInt1 = 0;
          while (paramInt1 < this.fPoints.length)
          {
            this.fPoints[paramInt1][0] = ((int)(((PointF)paramList.get(paramInt1)).x / this.mScale - k));
            this.fPoints[paramInt1][1] = ((int)(((PointF)paramList.get(paramInt1)).y / this.mScale - i));
            paramInt1 += 1;
          }
          CosmeticsHandle.a(this.mData, this.fPoints, paramInt2, j);
          this.mTex = GlUtil.createImageTexture(ByteBuffer.wrap(this.mData), paramInt2, j, 6408);
          GLES20.glBindFramebuffer(36160, paramh.bte[0]);
          GLES20.glViewport(0, 0, paramh.width, paramh.height);
          paramInt1 = 0;
          while (paramInt1 < 8)
          {
            paramList = this.cords;
            paramList[paramInt1] = (paramList[paramInt1] * 2.0F - 1.0F);
            paramInt1 += 1;
          }
          this.mFilter.setPositions(this.cords);
          this.mFilter.OnDrawFrameGLSL();
          this.mFilter.renderTexture(this.mTex, paramInt2, j);
          g.Tn(this.mTex);
          AppMethodBeat.o(82645);
          return paramh;
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mScale = ((float)paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.LipsCosFilter
 * JD-Core Version:    0.7.0.1
 */