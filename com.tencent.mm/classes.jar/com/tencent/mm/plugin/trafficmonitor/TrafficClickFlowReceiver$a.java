package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class TrafficClickFlowReceiver$a
{
  public String GsN;
  public long time;
  
  public final String toString()
  {
    AppMethodBeat.i(123909);
    String str = "ClickObject{ui='" + this.GsN + '\'' + ", time=" + this.time + '}';
    AppMethodBeat.o(123909);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.a
 * JD-Core Version:    0.7.0.1
 */