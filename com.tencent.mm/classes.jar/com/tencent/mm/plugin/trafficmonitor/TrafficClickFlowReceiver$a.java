package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class TrafficClickFlowReceiver$a
{
  public long time;
  public String tos;
  
  public final String toString()
  {
    AppMethodBeat.i(114767);
    String str = "ClickObject{ui='" + this.tos + '\'' + ", time=" + this.time + '}';
    AppMethodBeat.o(114767);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.a
 * JD-Core Version:    0.7.0.1
 */