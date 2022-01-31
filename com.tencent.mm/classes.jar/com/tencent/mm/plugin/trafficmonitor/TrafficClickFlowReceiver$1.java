package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;

final class TrafficClickFlowReceiver$1
  implements m
{
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114762);
    TrafficClickFlowReceiver.I(13, paramLong);
    AppMethodBeat.o(114762);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(114761);
    TrafficClickFlowReceiver.I(13, paramLong);
    AppMethodBeat.o(114761);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(114765);
    TrafficClickFlowReceiver.I(12, paramLong);
    AppMethodBeat.o(114765);
  }
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(114766);
    TrafficClickFlowReceiver.I(11, paramLong);
    AppMethodBeat.o(114766);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(114764);
    TrafficClickFlowReceiver.I(13, paramLong);
    AppMethodBeat.o(114764);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(114763);
    TrafficClickFlowReceiver.I(13, paramLong);
    AppMethodBeat.o(114763);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(114760);
    TrafficClickFlowReceiver.I(11, paramLong);
    AppMethodBeat.o(114760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.1
 * JD-Core Version:    0.7.0.1
 */