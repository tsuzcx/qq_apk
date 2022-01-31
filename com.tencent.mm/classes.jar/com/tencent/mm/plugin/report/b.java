package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private int mID;
  private long mInterval;
  private long qrF;
  private HashMap<Integer, Long> qrG;
  
  public b()
  {
    AppMethodBeat.i(115098);
    this.qrG = new HashMap();
    this.mID = 463;
    this.mInterval = 300000L;
    AppMethodBeat.o(115098);
  }
  
  private void Y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(115100);
    Long localLong = (Long)this.qrG.get(Integer.valueOf(paramInt));
    long l = paramLong;
    if (localLong != null) {
      l = paramLong + localLong.longValue();
    }
    this.qrG.put(Integer.valueOf(paramInt), Long.valueOf(l));
    AppMethodBeat.o(115100);
  }
  
  public final void h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115099);
    try
    {
      Y(paramInt1, paramLong);
      Y(paramInt2, 1L);
      paramLong = System.currentTimeMillis();
      if (paramLong - this.qrF > this.mInterval)
      {
        Iterator localIterator = this.qrG.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          e.qrI.idkeyStat(this.mID, ((Integer)localEntry.getKey()).intValue(), ((Long)localEntry.getValue()).longValue(), false);
        }
        this.qrF = paramLong;
      }
    }
    finally
    {
      AppMethodBeat.o(115099);
    }
    AppMethodBeat.o(115099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b
 * JD-Core Version:    0.7.0.1
 */