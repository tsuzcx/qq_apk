package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/model/VoipForegroundIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markForegroundServiceCallInAccountUninit", "", "markForegroundServiceDestroyByKilled", "markForegroundServiceOnCreate", "markForegroundServiceOnDestroy", "markForegroundServiceOnStartCommand", "markForegroundServiceReCalled", "markForegroundServiceStopCall", "markUseStartForegroundService", "markUseStartService", "markVoipForegroundServiceStartCalled", "plugin-voip_release"})
public final class q
{
  public static final q Cup;
  
  static
  {
    AppMethodBeat.i(115937);
    Cup = new q();
    AppMethodBeat.o(115937);
  }
  
  public static void eAk()
  {
    AppMethodBeat.i(115927);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markVoipForegroundServiceCalled");
    g.yxI.n(1081L, 0L, 1L);
    AppMethodBeat.o(115927);
  }
  
  public static void eAl()
  {
    AppMethodBeat.i(115928);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartService");
    g.yxI.n(1081L, 1L, 1L);
    AppMethodBeat.o(115928);
  }
  
  public static void eAm()
  {
    AppMethodBeat.i(115929);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markUseStartForegroundService");
    g.yxI.n(1081L, 2L, 1L);
    AppMethodBeat.o(115929);
  }
  
  public static void eAn()
  {
    AppMethodBeat.i(115930);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnCreate");
    g.yxI.n(1081L, 3L, 1L);
    AppMethodBeat.o(115930);
  }
  
  public static void eAo()
  {
    AppMethodBeat.i(115931);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnStartCommand");
    g.yxI.n(1081L, 4L, 1L);
    AppMethodBeat.o(115931);
  }
  
  public static void eAp()
  {
    AppMethodBeat.i(115932);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceOnDestroy");
    g.yxI.n(1081L, 5L, 1L);
    AppMethodBeat.o(115932);
  }
  
  public static void eAq()
  {
    AppMethodBeat.i(115933);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceStopCall");
    g.yxI.n(1081L, 6L, 1L);
    AppMethodBeat.o(115933);
  }
  
  public static void eAr()
  {
    AppMethodBeat.i(115934);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceDestroyByKilled");
    g.yxI.n(1081L, 7L, 1L);
    AppMethodBeat.o(115934);
  }
  
  public static void eAs()
  {
    AppMethodBeat.i(115935);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceReCalled");
    g.yxI.n(1081L, 8L, 1L);
    AppMethodBeat.o(115935);
  }
  
  public static void eAt()
  {
    AppMethodBeat.i(115936);
    ae.i("MicroMsg.VoipForegroundIDKeyStat", "markForegroundServiceCallInAccountUninit");
    g.yxI.n(1081L, 9L, 1L);
    AppMethodBeat.o(115936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */