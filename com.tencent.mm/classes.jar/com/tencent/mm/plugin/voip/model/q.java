package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceCallInAccountUninit", "", "markForegroundServiceDestroyByKilled", "markForegroundServiceOnCreate", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceReCalled", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"})
public final class q
{
  public static final q ADO;
  
  static
  {
    AppMethodBeat.i(115937);
    ADO = new q();
    AppMethodBeat.o(115937);
  }
  
  public static void eiS()
  {
    AppMethodBeat.i(115927);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
    h.wUl.n(1081L, 0L, 1L);
    AppMethodBeat.o(115927);
  }
  
  public static void eiT()
  {
    AppMethodBeat.i(115928);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
    h.wUl.n(1081L, 1L, 1L);
    AppMethodBeat.o(115928);
  }
  
  public static void eiU()
  {
    AppMethodBeat.i(115929);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
    h.wUl.n(1081L, 2L, 1L);
    AppMethodBeat.o(115929);
  }
  
  public static void eiV()
  {
    AppMethodBeat.i(115930);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
    h.wUl.n(1081L, 3L, 1L);
    AppMethodBeat.o(115930);
  }
  
  public static void eiW()
  {
    AppMethodBeat.i(115931);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
    h.wUl.n(1081L, 4L, 1L);
    AppMethodBeat.o(115931);
  }
  
  public static void eiX()
  {
    AppMethodBeat.i(115932);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
    h.wUl.n(1081L, 5L, 1L);
    AppMethodBeat.o(115932);
  }
  
  public static void eiY()
  {
    AppMethodBeat.i(115933);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
    h.wUl.n(1081L, 6L, 1L);
    AppMethodBeat.o(115933);
  }
  
  public static void eiZ()
  {
    AppMethodBeat.i(115934);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceDestroyByKilled");
    h.wUl.n(1081L, 7L, 1L);
    AppMethodBeat.o(115934);
  }
  
  public static void eja()
  {
    AppMethodBeat.i(115935);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceReCalled");
    h.wUl.n(1081L, 8L, 1L);
    AppMethodBeat.o(115935);
  }
  
  public static void ejb()
  {
    AppMethodBeat.i(115936);
    ac.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceCallInAccountUninit");
    h.wUl.n(1081L, 9L, 1L);
    AppMethodBeat.o(115936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */