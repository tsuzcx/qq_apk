package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.ad;

public abstract class e
{
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  int type;
  f yVj;
  a yVk;
  
  static boolean uf(long paramLong)
  {
    if (TrafficClickFlowReceiver.uc(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.ud(paramLong);
      ad.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void dQr();
  
  final void dQt()
  {
    g.dQu();
    int i = g.dQx();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.dQs();
      g.dQu();
      g.dQw();
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.e
 * JD-Core Version:    0.7.0.1
 */