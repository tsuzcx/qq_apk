package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceCallInAccountUninit", "", "markForegroundServiceDestroyByKilled", "markForegroundServiceOnCreate", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceReCalled", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q UBj;
  
  static
  {
    AppMethodBeat.i(115937);
    UBj = new q();
    AppMethodBeat.o(115937);
  }
  
  public static void hXk()
  {
    AppMethodBeat.i(115927);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
    h.OAn.p(1081L, 0L, 1L);
    AppMethodBeat.o(115927);
  }
  
  public static void hXl()
  {
    AppMethodBeat.i(115928);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
    h.OAn.p(1081L, 1L, 1L);
    AppMethodBeat.o(115928);
  }
  
  public static void hXm()
  {
    AppMethodBeat.i(115929);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
    h.OAn.p(1081L, 2L, 1L);
    AppMethodBeat.o(115929);
  }
  
  public static void hXn()
  {
    AppMethodBeat.i(115930);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
    h.OAn.p(1081L, 3L, 1L);
    AppMethodBeat.o(115930);
  }
  
  public static void hXo()
  {
    AppMethodBeat.i(115931);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
    h.OAn.p(1081L, 4L, 1L);
    AppMethodBeat.o(115931);
  }
  
  public static void hXp()
  {
    AppMethodBeat.i(115932);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
    h.OAn.p(1081L, 5L, 1L);
    AppMethodBeat.o(115932);
  }
  
  public static void hXq()
  {
    AppMethodBeat.i(115933);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
    h.OAn.p(1081L, 6L, 1L);
    AppMethodBeat.o(115933);
  }
  
  public static void hXr()
  {
    AppMethodBeat.i(115935);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceReCalled");
    h.OAn.p(1081L, 8L, 1L);
    AppMethodBeat.o(115935);
  }
  
  public static void hXs()
  {
    AppMethodBeat.i(115936);
    Log.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceCallInAccountUninit");
    h.OAn.p(1081L, 9L, 1L);
    AppMethodBeat.o(115936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */