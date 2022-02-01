package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-recordvideo_release"})
public final class e
{
  public static final e vpB;
  
  static
  {
    AppMethodBeat.i(75856);
    vpB = new e();
    AppMethodBeat.o(75856);
  }
  
  public static void diE()
  {
    AppMethodBeat.i(75854);
    ad.i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
    h.vKh.m(986L, 9L, 1L);
    AppMethodBeat.o(75854);
  }
  
  public static void g(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75855);
    ad.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + paramBoolean + ", bitrate:" + paramInt1 + ", fps:" + paramInt2);
    if (paramBoolean)
    {
      h.vKh.m(986L, 56L, 1L);
      h.vKh.m(986L, 60L, paramInt1);
      h.vKh.m(986L, 63L, paramInt2);
      AppMethodBeat.o(75855);
      return;
    }
    h.vKh.m(986L, 57L, 1L);
    h.vKh.m(986L, 66L, paramInt1);
    h.vKh.m(986L, 69L, paramInt2);
    AppMethodBeat.o(75855);
  }
  
  public static void oB(boolean paramBoolean)
  {
    AppMethodBeat.i(75853);
    ad.i("MicroMsg.StoryRemuxIDKeyStat", "markRemuxProcessType, isForeground:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      h.vKh.m(986L, 5L, 1L);
      AppMethodBeat.o(75853);
      return;
    }
    h.vKh.m(986L, 6L, 1L);
    AppMethodBeat.o(75853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.e
 * JD-Core Version:    0.7.0.1
 */