package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.Log;

public abstract class e
{
  f NfA;
  a NfB;
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  int type;
  
  static boolean Si(long paramLong)
  {
    if (TrafficClickFlowReceiver.Sf(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.Sg(paramLong);
      Log.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void gsi();
  
  final void gsk()
  {
    g.gsl();
    int i = g.gso();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.gsj();
      g.gsl();
      g.gsn();
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */