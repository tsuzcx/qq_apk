package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.y;

public abstract class c
{
  private final String TAG = "MicroMsg.TrafficInspector";
  int currentIndex;
  long dFf;
  int id;
  d pKf;
  c.a pKg;
  int type;
  
  abstract void bOQ();
  
  final long i(long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = TrafficClickFlowReceiver.P(paramLong1 - this.dFf, paramLong1);
    y.i("MicroMsg.TrafficInspector", "downloadDuration : %d", new Object[] { Long.valueOf(l2) });
    long l1 = paramLong2;
    if (l2 > 0L)
    {
      l1 = paramLong2;
      if (TrafficClickFlowReceiver.gH(paramLong1 - this.dFf))
      {
        l1 = paramLong2 - l2 / 1000L * paramLong3;
        y.i("MicroMsg.TrafficInspector", "hasDownload and it is normal");
      }
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.c
 * JD-Core Version:    0.7.0.1
 */