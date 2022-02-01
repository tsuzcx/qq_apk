package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "startKey", "", "(I)V", "checkRes", "", "editExist", "editNotExist", "finishDownload", "initExist", "initNotExist", "report", "key", "unzipFail", "unzipSuccess", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements b
{
  public static final a NRU;
  private final int NRN;
  
  static
  {
    AppMethodBeat.i(279652);
    NRU = new a((byte)0);
    AppMethodBeat.o(279652);
  }
  
  public h(int paramInt)
  {
    this.NRN = paramInt;
  }
  
  private static void rG(int paramInt)
  {
    AppMethodBeat.i(279649);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1388, paramInt);
    AppMethodBeat.o(279649);
  }
  
  public final void bIJ()
  {
    AppMethodBeat.i(279671);
    rG(this.NRN + 4);
    AppMethodBeat.o(279671);
  }
  
  public final void gJA()
  {
    AppMethodBeat.i(279666);
    rG(this.NRN + 3);
    AppMethodBeat.o(279666);
  }
  
  public final void gJB()
  {
    AppMethodBeat.i(279677);
    rG(this.NRN + 5);
    AppMethodBeat.o(279677);
  }
  
  public final void gJC()
  {
    AppMethodBeat.i(279682);
    rG(this.NRN + 6);
    AppMethodBeat.o(279682);
  }
  
  public final void gJD()
  {
    AppMethodBeat.i(279686);
    rG(this.NRN + 7);
    AppMethodBeat.o(279686);
  }
  
  public final void gJx()
  {
    AppMethodBeat.i(279653);
    rG(this.NRN);
    AppMethodBeat.o(279653);
  }
  
  public final void gJy()
  {
    AppMethodBeat.i(279655);
    rG(this.NRN + 1);
    AppMethodBeat.o(279655);
  }
  
  public final void gJz()
  {
    AppMethodBeat.i(279663);
    rG(this.NRN + 2);
    AppMethodBeat.o(279663);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport$Companion;", "", "()V", "ID", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.h
 * JD-Core Version:    0.7.0.1
 */