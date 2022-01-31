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
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.view.f;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class LipsCosFilter
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LipsCosFragment.dat");
  float[] cords = new float[8];
  private BaseFilter mCropFilter = null;
  private h mCropFrame = new h();
  byte[] mData = null;
  private BaseFilter mFilter = null;
  private h mFrame = new h();
  private int mHeight = 0;
  private Bitmap mLut;
  private float mScale = 1.0F;
  private int mTex = 0;
  private int mType = 1;
  private int mWidth = 0;
  
  public static Bitmap getBitmapFromAsset(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = BitmapFactory.decodeStream(paramContext.open(paramString));
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
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
    this.mFilter = new BaseFilter(FRAGMENT_SHADER);
    this.mFilter.addParam(new m.i("type", this.mType));
    this.mFilter.addParam(new m.k("inputImageTexture2", this.mLut, 33986, true));
    this.mFilter.addParam(new m.f("adjustAlpha", 1.0F));
    this.mFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
  }
  
  public void clear()
  {
    this.mFilter.ClearGLSL();
    this.mFilter = null;
    this.mCropFrame.clear();
    this.mFrame.clear();
  }
  
  public void setCosAlpha(float paramFloat)
  {
    this.mFilter.addParam(new m.f("adjustAlpha", paramFloat));
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mFilter != null) {
      this.mFilter.setRenderMode(paramInt);
    }
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
    for (;;)
    {
      int n;
      int j;
      int m;
      try
      {
        initData(paramh.width, paramh.height);
        n = 2147483647;
        j = -2147483648;
        int k = 65;
        i = -2147483648;
        m = 2147483647;
        if (k <= 82)
        {
          n = (int)Math.min(n, ((PointF)paramList.get(k)).x);
          j = (int)Math.max(j, ((PointF)paramList.get(k)).x);
          m = (int)Math.min(m, ((PointF)paramList.get(k)).y);
          i = (int)Math.max(i, ((PointF)paramList.get(k)).y);
          k += 1;
          continue;
        }
        k = j - n + 1;
        n -= (int)(k * 0.3D);
        m -= (int)(k * 0.25D);
        j = (int)(k * 0.3D) + j;
        k = (int)(k * 0.25D) + i;
        float f1 = paramInt1 * this.mScale;
        float f2 = paramInt2;
        f2 = this.mScale * f2;
        if ((n >= f1) || (j < 0) || (m >= f2) || (k < 0)) {
          return paramh;
        }
        if (n >= 0) {
          break label719;
        }
        paramInt1 = 0;
        if (j < f1) {
          break label713;
        }
        paramInt2 = (int)f1 - 1;
        if (m < 0)
        {
          i = 0;
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
          GlUtil.saveTextureToRgbaBuffer(paramh.texture[0], k, i, paramInt2, j, this.mData, paramh.bcC[0]);
          paramArrayOfFloat = (int[][])Array.newInstance(Integer.TYPE, new int[] { 83, 2 });
          paramInt1 = 0;
          if (paramInt1 < paramArrayOfFloat.length)
          {
            paramArrayOfFloat[paramInt1][0] = ((int)(((PointF)paramList.get(paramInt1)).x / this.mScale - k));
            paramArrayOfFloat[paramInt1][1] = ((int)(((PointF)paramList.get(paramInt1)).y / this.mScale - i));
            paramInt1 += 1;
            continue;
          }
          CosmeticsHandle.a(this.mData, paramArrayOfFloat, paramInt2, j);
          this.mTex = GlUtil.createImageTexture(ByteBuffer.wrap(this.mData), paramInt2, j, 6408);
          GLES20.glBindFramebuffer(36160, paramh.bcC[0]);
          GLES20.glViewport(0, 0, paramh.width, paramh.height);
          paramInt1 = 0;
          if (paramInt1 < 8)
          {
            this.cords[paramInt1] = (this.cords[paramInt1] * 2.0F - 1.0F);
            paramInt1 += 1;
            continue;
          }
          this.mFilter.setPositions(this.cords);
          this.mFilter.OnDrawFrameGLSL();
          this.mFilter.renderTexture(this.mTex, paramInt2, j);
          f.Ku(this.mTex);
          return paramh;
        }
      }
      catch (OutOfMemoryError paramList)
      {
        return paramh;
      }
      int i = m;
      continue;
      label713:
      paramInt2 = j;
      continue;
      label719:
      paramInt1 = n;
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