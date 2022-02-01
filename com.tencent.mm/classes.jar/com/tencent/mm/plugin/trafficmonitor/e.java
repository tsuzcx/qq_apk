package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.ae;

public abstract class e
{
  f BSi;
  a BSj;
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  int type;
  
  static boolean BE(long paramLong)
  {
    if (TrafficClickFlowReceiver.BB(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.BC(paramLong);
      ae.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void euO();
  
  final void euQ()
  {
    g.euR();
    int i = g.euU();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.euP();
      g.euR();
      g.euT();
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */