package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
{
  private final String TAG = "MicroMsg.TrafficInspector";
  g TRI;
  a TRJ;
  int currentIndex;
  int id;
  long interval;
  int type;
  
  static boolean wr(long paramLong)
  {
    if (TrafficClickFlowReceiver.ws(paramLong))
    {
      boolean bool = TrafficClickFlowReceiver.wt(paramLong);
      Log.i("MicroMsg.TrafficInspector", "hasDownload");
      return bool;
    }
    return false;
  }
  
  final void hPj()
  {
    h.hPo();
    int i = h.hPr();
    if (this.id == i)
    {
      TrafficClickFlowReceiver.hPn();
      h.hPo();
      h.hPq();
    }
  }
  
  static abstract interface a
  {
    public abstract void inspected(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.a
 * JD-Core Version:    0.7.0.1
 */