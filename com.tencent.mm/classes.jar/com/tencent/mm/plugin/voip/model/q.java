package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceCallInAccountUninit", "", "markForegroundServiceDestroyByKilled", "markForegroundServiceOnCreate", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceReCalled", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"})
public final class q
{
  public static final q NOm;
  
  static
  {
    AppMethodBeat.i(115937);
    NOm = new q();
    AppMethodBeat.o(115937);
  }
  
  public static void gzo()
  {
    AppMethodBeat.i(115927);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
    h.IzE.p(1081L, 0L, 1L);
    AppMethodBeat.o(115927);
  }
  
  public static void gzp()
  {
    AppMethodBeat.i(115928);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
    h.IzE.p(1081L, 1L, 1L);
    AppMethodBeat.o(115928);
  }
  
  public static void gzq()
  {
    AppMethodBeat.i(115929);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
    h.IzE.p(1081L, 2L, 1L);
    AppMethodBeat.o(115929);
  }
  
  public static void gzr()
  {
    AppMethodBeat.i(115930);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
    h.IzE.p(1081L, 3L, 1L);
    AppMethodBeat.o(115930);
  }
  
  public static void gzs()
  {
    AppMethodBeat.i(115931);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
    h.IzE.p(1081L, 4L, 1L);
    AppMethodBeat.o(115931);
  }
  
  public static void gzt()
  {
    AppMethodBeat.i(115932);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
    h.IzE.p(1081L, 5L, 1L);
    AppMethodBeat.o(115932);
  }
  
  public static void gzu()
  {
    AppMethodBeat.i(115933);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
    h.IzE.p(1081L, 6L, 1L);
    AppMethodBeat.o(115933);
  }
  
  public static void gzv()
  {
    AppMethodBeat.i(115934);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceDestroyByKilled");
    h.IzE.p(1081L, 7L, 1L);
    AppMethodBeat.o(115934);
  }
  
  public static void gzw()
  {
    AppMethodBeat.i(115935);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceReCalled");
    h.IzE.p(1081L, 8L, 1L);
    AppMethodBeat.o(115935);
  }
  
  public static void gzx()
  {
    AppMethodBeat.i(115936);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceCallInAccountUninit");
    h.IzE.p(1081L, 9L, 1L);
    AppMethodBeat.o(115936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */