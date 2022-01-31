package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryCaptureIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCpuCrop", "", "markGpuCrop", "markGpuCropFailed", "markOnCreate", "markOnDestroy", "plugin-story_release"})
public final class d
{
  public static final d sEm;
  
  static
  {
    AppMethodBeat.i(109799);
    sEm = new d();
    AppMethodBeat.o(109799);
  }
  
  public static void cCH()
  {
    AppMethodBeat.i(109797);
    ab.i("MicroMsg.StoryCaptureIDKeyStat", "markOnCreate");
    h.qsU.j(985L, 0L, 1L);
    AppMethodBeat.o(109797);
  }
  
  public static void cCI()
  {
    AppMethodBeat.i(109798);
    ab.i("MicroMsg.StoryCaptureIDKeyStat", "markOnDestroy");
    h.qsU.j(985L, 1L, 1L);
    AppMethodBeat.o(109798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.d
 * JD-Core Version:    0.7.0.1
 */