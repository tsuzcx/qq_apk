package com.tencent.mm.plugin.report;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private int mID = 463;
  private long mInterval = 300000L;
  private long nED;
  private HashMap<Integer, Long> nEE = new HashMap();
  
  private void I(int paramInt, long paramLong)
  {
    Long localLong = (Long)this.nEE.get(Integer.valueOf(paramInt));
    long l = paramLong;
    if (localLong != null) {
      l = paramLong + localLong.longValue();
    }
    this.nEE.put(Integer.valueOf(paramInt), Long.valueOf(l));
  }
  
  public final void g(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      I(paramInt1, paramLong);
      I(paramInt2, 1L);
      paramLong = System.currentTimeMillis();
      if (paramLong - this.nED > this.mInterval)
      {
        Iterator localIterator = this.nEE.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          f.nEG.a(this.mID, ((Integer)localEntry.getKey()).intValue(), ((Long)localEntry.getValue()).longValue(), false);
        }
        this.nED = paramLong;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b
 * JD-Core Version:    0.7.0.1
 */