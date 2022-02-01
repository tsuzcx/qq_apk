package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.Log;

public abstract class e
{
  f GsO;
  a GsP;
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  int type;
  
  static boolean KL(long paramLong)
  {
    if (TrafficClickFlowReceiver.KI(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.KJ(paramLong);
      Log.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void fAh();
  
  final void fAj()
  {
    g.fAk();
    int i = g.fAn();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.fAi();
      g.fAk();
      g.fAm();
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */