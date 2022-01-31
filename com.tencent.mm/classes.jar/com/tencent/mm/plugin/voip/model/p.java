package com.tencent.mm.plugin.voip.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceOnCreate", "", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"})
public final class p
{
  public static final p twZ;
  
  static
  {
    AppMethodBeat.i(140282);
    twZ = new p();
    AppMethodBeat.o(140282);
  }
  
  public static void cMA()
  {
    AppMethodBeat.i(140275);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
    h.qsU.j(1081L, 0L, 1L);
    AppMethodBeat.o(140275);
  }
  
  public static void cMB()
  {
    AppMethodBeat.i(140276);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
    h.qsU.j(1081L, 1L, 1L);
    AppMethodBeat.o(140276);
  }
  
  public static void cMC()
  {
    AppMethodBeat.i(140277);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
    h.qsU.j(1081L, 2L, 1L);
    AppMethodBeat.o(140277);
  }
  
  public static void cMD()
  {
    AppMethodBeat.i(140278);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
    h.qsU.j(1081L, 3L, 1L);
    AppMethodBeat.o(140278);
  }
  
  public static void cME()
  {
    AppMethodBeat.i(140279);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
    h.qsU.j(1081L, 4L, 1L);
    AppMethodBeat.o(140279);
  }
  
  public static void cMF()
  {
    AppMethodBeat.i(140280);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
    h.qsU.j(1081L, 5L, 1L);
    AppMethodBeat.o(140280);
  }
  
  public static void cMG()
  {
    AppMethodBeat.i(140281);
    ab.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
    h.qsU.j(1081L, 6L, 1L);
    AppMethodBeat.o(140281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */