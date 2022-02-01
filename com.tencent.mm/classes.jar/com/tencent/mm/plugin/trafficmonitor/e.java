package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.ad;

public abstract class e
{
  f BAK;
  a BAL;
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  int type;
  
  static boolean Bg(long paramLong)
  {
    if (TrafficClickFlowReceiver.Bd(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.Be(paramLong);
      ad.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void erh();
  
  final void erj()
  {
    g.erk();
    int i = g.ern();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.eri();
      g.erk();
      g.erm();
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */