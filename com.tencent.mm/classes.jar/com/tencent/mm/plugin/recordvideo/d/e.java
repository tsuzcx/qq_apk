package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-recordvideo_release"})
public final class e
{
  public static final e HUH;
  
  static
  {
    AppMethodBeat.i(75852);
    HUH = new e();
    AppMethodBeat.o(75852);
  }
  
  public static void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(75849);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessRetryTimes, times:" + paramInt + ", isCaptureVideo:" + paramBoolean);
    h.IzE.p(1005L, 41L, 1L);
    if (paramInt <= 1)
    {
      if (paramBoolean)
      {
        h.IzE.p(1005L, 42L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      h.IzE.p(1005L, 43L, 1L);
      AppMethodBeat.o(75849);
      return;
    }
    if (paramInt == 2)
    {
      if (paramBoolean)
      {
        h.IzE.p(1005L, 45L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      h.IzE.p(1005L, 46L, 1L);
      AppMethodBeat.o(75849);
      return;
    }
    if (paramInt == 3)
    {
      if (paramBoolean)
      {
        h.IzE.p(1005L, 48L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      h.IzE.p(1005L, 49L, 1L);
    }
    AppMethodBeat.o(75849);
  }
  
  public static void fxw()
  {
    AppMethodBeat.i(75851);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    h.IzE.p(1005L, 8L, 1L);
    AppMethodBeat.o(75851);
  }
  
  public static void l(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(75848);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessCost, isCaptureVideo:" + paramBoolean + ", time:" + paramLong);
    h.IzE.p(1005L, 31L, paramLong);
    if (paramBoolean)
    {
      h.IzE.p(1005L, 32L, paramLong);
      AppMethodBeat.o(75848);
      return;
    }
    h.IzE.p(1005L, 33L, paramLong);
    AppMethodBeat.o(75848);
  }
  
  public static void wF(boolean paramBoolean)
  {
    AppMethodBeat.i(75844);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStartUniq, isCaptureVideo:".concat(String.valueOf(paramBoolean)));
    h.IzE.p(1005L, 101L, 1L);
    if (paramBoolean)
    {
      h.IzE.p(1005L, 102L, 1L);
      AppMethodBeat.o(75844);
      return;
    }
    h.IzE.p(1005L, 103L, 1L);
    AppMethodBeat.o(75844);
  }
  
  public static void wG(boolean paramBoolean)
  {
    AppMethodBeat.i(75845);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(paramBoolean)));
    h.IzE.p(1005L, 1L, 1L);
    if (paramBoolean)
    {
      h.IzE.p(1005L, 2L, 1L);
      AppMethodBeat.o(75845);
      return;
    }
    h.IzE.p(1005L, 3L, 1L);
    AppMethodBeat.o(75845);
  }
  
  public static void wH(boolean paramBoolean)
  {
    AppMethodBeat.i(75846);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSucess");
    h.IzE.p(1005L, 11L, 1L);
    if (paramBoolean)
    {
      h.IzE.p(1005L, 12L, 1L);
      AppMethodBeat.o(75846);
      return;
    }
    h.IzE.p(1005L, 13L, 1L);
    AppMethodBeat.o(75846);
  }
  
  public static void wI(boolean paramBoolean)
  {
    AppMethodBeat.i(75847);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markFail");
    h.IzE.p(1005L, 21L, 1L);
    if (paramBoolean)
    {
      h.IzE.p(1005L, 22L, 1L);
      AppMethodBeat.o(75847);
      return;
    }
    h.IzE.p(1005L, 23L, 1L);
    AppMethodBeat.o(75847);
  }
  
  public static void wJ(boolean paramBoolean)
  {
    AppMethodBeat.i(75850);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixVideoNotExist");
    if (paramBoolean)
    {
      h.IzE.p(1005L, 5L, 1L);
      AppMethodBeat.o(75850);
      return;
    }
    h.IzE.p(1005L, 6L, 1L);
    AppMethodBeat.o(75850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.e
 * JD-Core Version:    0.7.0.1
 */