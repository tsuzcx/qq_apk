package com.tencent.ttpic.util;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.util.a;
import java.util.ArrayList;
import java.util.List;

public class FrameUtil
{
  private static final h EMPTY_FRAME;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(50270);
    TAG = FrameUtil.class.getSimpleName();
    EMPTY_FRAME = new h();
    AppMethodBeat.o(50270);
  }
  
  public static void clearFrame(h paramh, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50267);
    if (paramh == null)
    {
      AppMethodBeat.o(50267);
      return;
    }
    paramh.a(-1, paramInt1, paramInt2, 0.0D);
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    GLES20.glClear(16384);
    AppMethodBeat.o(50267);
  }
  
  public static void clearTailFrame(BaseFilter paramBaseFilter, h paramh)
  {
    AppMethodBeat.i(50265);
    int i = getLength(paramBaseFilter);
    while ((i > 0) && (paramh != null))
    {
      paramh = paramh.btf;
      i -= 1;
    }
    if (paramh != null) {
      paramh.clear();
    }
    AppMethodBeat.o(50265);
  }
  
  public static List<BaseFilter> filterChain2List(BaseFilter paramBaseFilter)
  {
    AppMethodBeat.i(50268);
    ArrayList localArrayList = new ArrayList();
    while (paramBaseFilter != null)
    {
      BaseFilter localBaseFilter = paramBaseFilter.getmNextFilter();
      paramBaseFilter.setNextFilter(null, null);
      localArrayList.add(paramBaseFilter);
      paramBaseFilter = localBaseFilter;
    }
    AppMethodBeat.o(50268);
    return localArrayList;
  }
  
  public static void filterList2Chain(List<BaseFilter> paramList)
  {
    AppMethodBeat.i(50269);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(50269);
      return;
    }
    BaseFilter localBaseFilter = (BaseFilter)paramList.get(0);
    int i = 1;
    while (i < paramList.size())
    {
      localBaseFilter.setNextFilter((BaseFilter)paramList.get(i), null);
      localBaseFilter = (BaseFilter)paramList.get(i);
      i += 1;
    }
    AppMethodBeat.o(50269);
  }
  
  public static h getLastRenderFrame(h paramh)
  {
    AppMethodBeat.i(50263);
    if (!isValid(paramh))
    {
      paramh = EMPTY_FRAME;
      AppMethodBeat.o(50263);
      return paramh;
    }
    h localh1 = paramh;
    while (isValid(paramh))
    {
      h localh2 = paramh.btf;
      localh1 = paramh;
      paramh = localh2;
    }
    AppMethodBeat.o(50263);
    return localh1;
  }
  
  public static int getLength(BaseFilter paramBaseFilter)
  {
    AppMethodBeat.i(50260);
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    AppMethodBeat.o(50260);
    return i;
  }
  
  public static int getLength(h paramh)
  {
    int i = 0;
    while ((paramh != null) && (paramh.texture[0] > 0))
    {
      i += 1;
      paramh = paramh.btf;
    }
    return i;
  }
  
  public static h getSecondLastRenderFrame(h paramh)
  {
    AppMethodBeat.i(50262);
    if ((!isValid(paramh)) || (!isValid(paramh.btf)))
    {
      paramh = EMPTY_FRAME;
      AppMethodBeat.o(50262);
      return paramh;
    }
    h localh1 = paramh;
    while ((isValid(paramh)) && (isValid(paramh.btf)))
    {
      h localh2 = paramh.btf;
      localh1 = paramh;
      paramh = localh2;
    }
    AppMethodBeat.o(50262);
    return localh1;
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
    AppMethodBeat.i(50261);
    int i = 0;
    while (paramBaseFilter != null)
    {
      new StringBuilder("[FILTER] ").append(i).append(" ").append(paramBaseFilter);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
      i += 1;
    }
    AppMethodBeat.o(50261);
  }
  
  public static h renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, h paramh1, h paramh2)
  {
    AppMethodBeat.i(50264);
    if (paramh1.texture[0] == paramInt1) {}
    for (;;)
    {
      paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh2);
      AppMethodBeat.o(50264);
      return paramh2;
      paramh2 = paramh1;
    }
  }
  
  public static h rotateCorrect(h paramh1, int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, h paramh2)
  {
    AppMethodBeat.i(50266);
    if (paramInt3 == 0)
    {
      AppMethodBeat.o(50266);
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
      a.benchStart("[VideoFilterList] mRotationFilter before");
      paramBaseFilter.nativeSetRotationAndFlip(i, 0, 0);
      paramBaseFilter.RenderProcess(paramh1.texture[0], paramInt1, paramInt3, -1, 0.0D, paramh2);
      a.axk("[VideoFilterList] mRotationFilter before");
      AppMethodBeat.o(50266);
      return paramh2;
      paramInt3 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameUtil
 * JD-Core Version:    0.7.0.1
 */