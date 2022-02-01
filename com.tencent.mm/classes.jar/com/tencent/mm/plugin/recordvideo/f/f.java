package com.tencent.mm.plugin.recordvideo.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f NRA;
  
  static
  {
    AppMethodBeat.i(75856);
    NRA = new f();
    AppMethodBeat.o(75856);
  }
  
  public static void Bk(boolean paramBoolean)
  {
    AppMethodBeat.i(75853);
    Log.i("MicroMsg.StoryRemuxIDKeyStat", s.X("markRemuxProcessType, isForeground:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      h.OAn.p(986L, 5L, 1L);
      AppMethodBeat.o(75853);
      return;
    }
    h.OAn.p(986L, 6L, 1L);
    AppMethodBeat.o(75853);
  }
  
  public static void gJm()
  {
    AppMethodBeat.i(75854);
    Log.i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
    h.OAn.p(986L, 9L, 1L);
    AppMethodBeat.o(75854);
  }
  
  public static void q(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75855);
    Log.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + paramBoolean + ", bitrate:" + paramInt1 + ", fps:" + paramInt2);
    if (paramBoolean)
    {
      h.OAn.p(986L, 56L, 1L);
      h.OAn.p(986L, 60L, paramInt1);
      h.OAn.p(986L, 63L, paramInt2);
      AppMethodBeat.o(75855);
      return;
    }
    h.OAn.p(986L, 57L, 1L);
    h.OAn.p(986L, 66L, paramInt1);
    h.OAn.p(986L, 69L, paramInt2);
    AppMethodBeat.o(75855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.f.f
 * JD-Core Version:    0.7.0.1
 */