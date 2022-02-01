package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-recordvideo_release"})
public final class d
{
  public static final d vpA;
  
  static
  {
    AppMethodBeat.i(75852);
    vpA = new d();
    AppMethodBeat.o(75852);
  }
  
  public static void am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(75849);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessRetryTimes, times:" + paramInt + ", isCaptureVideo:" + paramBoolean);
    h.vKh.m(1005L, 41L, 1L);
    if (paramInt <= 1)
    {
      if (paramBoolean)
      {
        h.vKh.m(1005L, 42L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      h.vKh.m(1005L, 43L, 1L);
      AppMethodBeat.o(75849);
      return;
    }
    if (paramInt == 2)
    {
      if (paramBoolean)
      {
        h.vKh.m(1005L, 45L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      h.vKh.m(1005L, 46L, 1L);
      AppMethodBeat.o(75849);
      return;
    }
    if (paramInt == 3)
    {
      if (paramBoolean)
      {
        h.vKh.m(1005L, 48L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      h.vKh.m(1005L, 49L, 1L);
    }
    AppMethodBeat.o(75849);
  }
  
  public static void diD()
  {
    AppMethodBeat.i(75851);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    h.vKh.m(1005L, 8L, 1L);
    AppMethodBeat.o(75851);
  }
  
  public static void h(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(75848);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessCost, isCaptureVideo:" + paramBoolean + ", time:" + paramLong);
    h.vKh.m(1005L, 31L, paramLong);
    if (paramBoolean)
    {
      h.vKh.m(1005L, 32L, paramLong);
      AppMethodBeat.o(75848);
      return;
    }
    h.vKh.m(1005L, 33L, paramLong);
    AppMethodBeat.o(75848);
  }
  
  public static void oA(boolean paramBoolean)
  {
    AppMethodBeat.i(75850);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixVideoNotExist");
    if (paramBoolean)
    {
      h.vKh.m(1005L, 5L, 1L);
      AppMethodBeat.o(75850);
      return;
    }
    h.vKh.m(1005L, 6L, 1L);
    AppMethodBeat.o(75850);
  }
  
  public static void ow(boolean paramBoolean)
  {
    AppMethodBeat.i(75844);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStartUniq, isCaptureVideo:".concat(String.valueOf(paramBoolean)));
    h.vKh.m(1005L, 101L, 1L);
    if (paramBoolean)
    {
      h.vKh.m(1005L, 102L, 1L);
      AppMethodBeat.o(75844);
      return;
    }
    h.vKh.m(1005L, 103L, 1L);
    AppMethodBeat.o(75844);
  }
  
  public static void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(75845);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(paramBoolean)));
    h.vKh.m(1005L, 1L, 1L);
    if (paramBoolean)
    {
      h.vKh.m(1005L, 2L, 1L);
      AppMethodBeat.o(75845);
      return;
    }
    h.vKh.m(1005L, 3L, 1L);
    AppMethodBeat.o(75845);
  }
  
  public static void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(75846);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSucess");
    h.vKh.m(1005L, 11L, 1L);
    if (paramBoolean)
    {
      h.vKh.m(1005L, 12L, 1L);
      AppMethodBeat.o(75846);
      return;
    }
    h.vKh.m(1005L, 13L, 1L);
    AppMethodBeat.o(75846);
  }
  
  public static void oz(boolean paramBoolean)
  {
    AppMethodBeat.i(75847);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markFail");
    h.vKh.m(1005L, 21L, 1L);
    if (paramBoolean)
    {
      h.vKh.m(1005L, 22L, 1L);
      AppMethodBeat.o(75847);
      return;
    }
    h.vKh.m(1005L, 23L, 1L);
    AppMethodBeat.o(75847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.d
 * JD-Core Version:    0.7.0.1
 */