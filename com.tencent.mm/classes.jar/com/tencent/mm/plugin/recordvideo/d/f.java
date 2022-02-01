package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-recordvideo_release"})
public final class f
{
  public static final f xXh;
  
  static
  {
    AppMethodBeat.i(75856);
    xXh = new f();
    AppMethodBeat.o(75856);
  }
  
  public static void dKi()
  {
    AppMethodBeat.i(75854);
    ae.i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
    g.yxI.n(986L, 9L, 1L);
    AppMethodBeat.o(75854);
  }
  
  public static void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75855);
    ae.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + paramBoolean + ", bitrate:" + paramInt1 + ", fps:" + paramInt2);
    if (paramBoolean)
    {
      g.yxI.n(986L, 56L, 1L);
      g.yxI.n(986L, 60L, paramInt1);
      g.yxI.n(986L, 63L, paramInt2);
      AppMethodBeat.o(75855);
      return;
    }
    g.yxI.n(986L, 57L, 1L);
    g.yxI.n(986L, 66L, paramInt1);
    g.yxI.n(986L, 69L, paramInt2);
    AppMethodBeat.o(75855);
  }
  
  public static void qd(boolean paramBoolean)
  {
    AppMethodBeat.i(75853);
    ae.i("MicroMsg.StoryRemuxIDKeyStat", "markRemuxProcessType, isForeground:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      g.yxI.n(986L, 5L, 1L);
      AppMethodBeat.o(75853);
      return;
    }
    g.yxI.n(986L, 6L, 1L);
    AppMethodBeat.o(75853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.f
 * JD-Core Version:    0.7.0.1
 */