package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceCallInAccountUninit", "", "markForegroundServiceDestroyByKilled", "markForegroundServiceOnCreate", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceReCalled", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"})
public final class q
{
  public static final q zld;
  
  static
  {
    AppMethodBeat.i(115937);
    zld = new q();
    AppMethodBeat.o(115937);
  }
  
  public static void dTG()
  {
    AppMethodBeat.i(115927);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
    h.vKh.m(1081L, 0L, 1L);
    AppMethodBeat.o(115927);
  }
  
  public static void dTH()
  {
    AppMethodBeat.i(115928);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
    h.vKh.m(1081L, 1L, 1L);
    AppMethodBeat.o(115928);
  }
  
  public static void dTI()
  {
    AppMethodBeat.i(115929);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
    h.vKh.m(1081L, 2L, 1L);
    AppMethodBeat.o(115929);
  }
  
  public static void dTJ()
  {
    AppMethodBeat.i(115930);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
    h.vKh.m(1081L, 3L, 1L);
    AppMethodBeat.o(115930);
  }
  
  public static void dTK()
  {
    AppMethodBeat.i(115931);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
    h.vKh.m(1081L, 4L, 1L);
    AppMethodBeat.o(115931);
  }
  
  public static void dTL()
  {
    AppMethodBeat.i(115932);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
    h.vKh.m(1081L, 5L, 1L);
    AppMethodBeat.o(115932);
  }
  
  public static void dTM()
  {
    AppMethodBeat.i(115933);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
    h.vKh.m(1081L, 6L, 1L);
    AppMethodBeat.o(115933);
  }
  
  public static void dTN()
  {
    AppMethodBeat.i(115934);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceDestroyByKilled");
    h.vKh.m(1081L, 7L, 1L);
    AppMethodBeat.o(115934);
  }
  
  public static void dTO()
  {
    AppMethodBeat.i(115935);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceReCalled");
    h.vKh.m(1081L, 8L, 1L);
    AppMethodBeat.o(115935);
  }
  
  public static void dTP()
  {
    AppMethodBeat.i(115936);
    ad.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceCallInAccountUninit");
    h.vKh.m(1081L, 9L, 1L);
    AppMethodBeat.o(115936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */