package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class TrafficClickFlowReceiver$c
{
  public long endTime;
  public long startTime;
  public String tos;
  
  public final String toString()
  {
    AppMethodBeat.i(114769);
    String str = "UIObject{ui='" + this.tos + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    AppMethodBeat.o(114769);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.c
 * JD-Core Version:    0.7.0.1
 */