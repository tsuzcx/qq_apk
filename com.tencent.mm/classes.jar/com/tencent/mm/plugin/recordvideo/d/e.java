package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-recordvideo_release"})
public final class e
{
  public static final e xXg;
  
  static
  {
    AppMethodBeat.i(75852);
    xXg = new e();
    AppMethodBeat.o(75852);
  }
  
  public static void ax(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(75849);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessRetryTimes, times:" + paramInt + ", isCaptureVideo:" + paramBoolean);
    g.yxI.n(1005L, 41L, 1L);
    if (paramInt <= 1)
    {
      if (paramBoolean)
      {
        g.yxI.n(1005L, 42L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      g.yxI.n(1005L, 43L, 1L);
      AppMethodBeat.o(75849);
      return;
    }
    if (paramInt == 2)
    {
      if (paramBoolean)
      {
        g.yxI.n(1005L, 45L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      g.yxI.n(1005L, 46L, 1L);
      AppMethodBeat.o(75849);
      return;
    }
    if (paramInt == 3)
    {
      if (paramBoolean)
      {
        g.yxI.n(1005L, 48L, 1L);
        AppMethodBeat.o(75849);
        return;
      }
      g.yxI.n(1005L, 49L, 1L);
    }
    AppMethodBeat.o(75849);
  }
  
  public static void dKh()
  {
    AppMethodBeat.i(75851);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    g.yxI.n(1005L, 8L, 1L);
    AppMethodBeat.o(75851);
  }
  
  public static void h(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(75848);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSuccessCost, isCaptureVideo:" + paramBoolean + ", time:" + paramLong);
    g.yxI.n(1005L, 31L, paramLong);
    if (paramBoolean)
    {
      g.yxI.n(1005L, 32L, paramLong);
      AppMethodBeat.o(75848);
      return;
    }
    g.yxI.n(1005L, 33L, paramLong);
    AppMethodBeat.o(75848);
  }
  
  public static void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(75844);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStartUniq, isCaptureVideo:".concat(String.valueOf(paramBoolean)));
    g.yxI.n(1005L, 101L, 1L);
    if (paramBoolean)
    {
      g.yxI.n(1005L, 102L, 1L);
      AppMethodBeat.o(75844);
      return;
    }
    g.yxI.n(1005L, 103L, 1L);
    AppMethodBeat.o(75844);
  }
  
  public static void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(75845);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markRemuxStart, isCaptureVideo:".concat(String.valueOf(paramBoolean)));
    g.yxI.n(1005L, 1L, 1L);
    if (paramBoolean)
    {
      g.yxI.n(1005L, 2L, 1L);
      AppMethodBeat.o(75845);
      return;
    }
    g.yxI.n(1005L, 3L, 1L);
    AppMethodBeat.o(75845);
  }
  
  public static void qa(boolean paramBoolean)
  {
    AppMethodBeat.i(75846);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markSucess");
    g.yxI.n(1005L, 11L, 1L);
    if (paramBoolean)
    {
      g.yxI.n(1005L, 12L, 1L);
      AppMethodBeat.o(75846);
      return;
    }
    g.yxI.n(1005L, 13L, 1L);
    AppMethodBeat.o(75846);
  }
  
  public static void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(75847);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markFail");
    g.yxI.n(1005L, 21L, 1L);
    if (paramBoolean)
    {
      g.yxI.n(1005L, 22L, 1L);
      AppMethodBeat.o(75847);
      return;
    }
    g.yxI.n(1005L, 23L, 1L);
    AppMethodBeat.o(75847);
  }
  
  public static void qc(boolean paramBoolean)
  {
    AppMethodBeat.i(75850);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixVideoNotExist");
    if (paramBoolean)
    {
      g.yxI.n(1005L, 5L, 1L);
      AppMethodBeat.o(75850);
      return;
    }
    g.yxI.n(1005L, 6L, 1L);
    AppMethodBeat.o(75850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.e
 * JD-Core Version:    0.7.0.1
 */