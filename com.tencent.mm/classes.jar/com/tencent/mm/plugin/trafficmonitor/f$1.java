package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;

final class f$1
  implements e
{
  public final void b(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260692);
    f.access$002(true);
    Log.i("MicroMsg.TrafficInspector", "onFloatBallInfoClicked");
    AppMethodBeat.o(260692);
  }
  
  public final void c(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260698);
    f.access$002(true);
    Log.i("MicroMsg.TrafficInspector", "onFloatBallInfoRemoved");
    AppMethodBeat.o(260698);
  }
  
  public final boolean coy()
  {
    AppMethodBeat.i(260710);
    Log.i("MicroMsg.TrafficInspector", "onAddMessageFloatBall");
    AppMethodBeat.o(260710);
    return false;
  }
  
  public final void d(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260706);
    Log.i("MicroMsg.TrafficInspector", "onFloatBallInfoExposed");
    AppMethodBeat.o(260706);
  }
  
  public final void g(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260684);
    f.access$002(true);
    Log.i("MicroMsg.TrafficInspector", "onFloatBallInfoAdded");
    AppMethodBeat.o(260684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f.1
 * JD-Core Version:    0.7.0.1
 */