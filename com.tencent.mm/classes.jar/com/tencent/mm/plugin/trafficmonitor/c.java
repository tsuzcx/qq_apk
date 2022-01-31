package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.ab;

public abstract class c
{
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  int id;
  long interval;
  d tot;
  c.a tou;
  int type;
  
  static boolean ne(long paramLong)
  {
    if (TrafficClickFlowReceiver.nb(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.nc(paramLong);
      ab.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  abstract void cKM();
  
  final void cKO()
  {
    e.cKP();
    int i = e.cKS();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.cKN();
      e.cKP();
      e.cKR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */