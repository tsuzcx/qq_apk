package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.ac;

public abstract class e
{
  f AiY;
  a AiZ;
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  int type;
  
  static boolean yI(long paramLong)
  {
    if (TrafficClickFlowReceiver.yF(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.yG(paramLong);
      ac.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void eeQ();
  
  final void eeS()
  {
    g.eeT();
    int i = g.eeW();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.eeR();
      g.eeT();
      g.eeV();
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */