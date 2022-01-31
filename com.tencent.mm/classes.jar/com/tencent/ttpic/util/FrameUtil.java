package com.tencent.ttpic.util;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.VideoFilterBase;

public class FrameUtil
{
  private static final h EMPTY_FRAME = new h();
  private static final String TAG = FrameUtil.class.getSimpleName();
  
  public static void clearFrame(h paramh, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    if (paramh == null) {
      return;
    }
    paramh.a(-1, paramInt1, paramInt2, 0.0D);
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    GLES20.glClear(16384);
  }
  
  public static h getLastRenderFrame(h paramh)
  {
    h localh1;
    if (!isValid(paramh)) {
      localh1 = EMPTY_FRAME;
    }
    for (;;)
    {
      return localh1;
      localh1 = paramh;
      while (isValid(paramh))
      {
        h localh2 = paramh.bcD;
        localh1 = paramh;
        paramh = localh2;
      }
    }
  }
  
  public static int getLength(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    return i;
  }
  
  public static int getLength(h paramh)
  {
    int i = 0;
    while ((paramh != null) && (paramh.texture[0] > 0))
    {
      i += 1;
      paramh = paramh.bcD;
    }
    return i;
  }
  
  public static h getSecondLastRenderFrame(h paramh)
  {
    Object localObject;
    if ((!isValid(paramh)) || (!isValid(paramh.bcD)))
    {
      localObject = EMPTY_FRAME;
      return localObject;
    }
    h localh = paramh;
    for (;;)
    {
      localObject = localh;
      if (!isValid(paramh)) {
        break;
      }
      localObject = localh;
      if (!isValid(paramh.bcD)) {
        break;
      }
      localObject = paramh.bcD;
      localh = paramh;
      paramh = (h)localObject;
    }
  }
  
  public static boolean isValid(h paramh)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramh != null)
    {
      bool1 = bool2;
      if (paramh.texture[0] != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void printFilterList(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      new StringBuilder("[FILTER] ").append(i).append(" ").append(paramBaseFilter);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
      i += 1;
    }
  }
  
  public static h renderProcessByCopy(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, BaseFilter paramBaseFilter, h paramh1, h paramh2)
  {
    if (paramh1.texture[0] == paramInt1) {}
    for (;;)
    {
      paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh2);
      paramVideoFilterBase.OnDrawFrameGLSL();
      paramVideoFilterBase.renderTexture(paramInt1, paramInt2, paramInt3);
      return paramh2;
      paramh2 = paramh1;
    }
  }
  
  public static h renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, h paramh1, h paramh2)
  {
    if (paramh1.texture[0] == paramInt1) {}
    for (;;)
    {
      paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh2);
      return paramh2;
      paramh2 = paramh1;
    }
  }
  
  public static h renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, h paramh1, h paramh2)
  {
    if (paramh1.texture[0] == paramInt1) {}
    for (;;)
    {
      paramVideoFilterBase.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh2);
      return paramh2;
      paramh2 = paramh1;
    }
  }
  
  public static h rotateCorrect(h paramh1, int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, h paramh2)
  {
    if (paramInt3 == 0) {
      return paramh1;
    }
    int i = (paramInt3 + 360) % 360;
    if ((i == 90) || (i == 270))
    {
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      BenchUtil.benchStart("[VideoFilterList] mRotationFilter before");
      paramBaseFilter.nativeSetRotationAndFlip(i, 0, 0);
      paramBaseFilter.RenderProcess(paramh1.texture[0], paramInt1, paramInt3, -1, 0.0D, paramh2);
      BenchUtil.benchEnd("[VideoFilterList] mRotationFilter before");
      return paramh2;
      paramInt3 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameUtil
 * JD-Core Version:    0.7.0.1
 */