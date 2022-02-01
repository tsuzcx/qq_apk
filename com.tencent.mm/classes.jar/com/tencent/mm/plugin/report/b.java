package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private int OyW;
  private long OyX;
  private HashMap<Integer, Long> OyY;
  private long mInterval;
  
  public b()
  {
    AppMethodBeat.i(125118);
    this.OyY = new HashMap();
    this.OyW = 463;
    this.mInterval = 300000L;
    AppMethodBeat.o(125118);
  }
  
  private void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(125120);
    Long localLong = (Long)this.OyY.get(Integer.valueOf(paramInt));
    long l = paramLong;
    if (localLong != null) {
      l = paramLong + localLong.longValue();
    }
    this.OyY.put(Integer.valueOf(paramInt), Long.valueOf(l));
    AppMethodBeat.o(125120);
  }
  
  public final void u(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(125119);
    try
    {
      aS(paramInt1, paramLong);
      aS(paramInt2, 1L);
      paramLong = System.currentTimeMillis();
      if (paramLong - this.OyX > this.mInterval)
      {
        Iterator localIterator = this.OyY.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          f.Ozc.idkeyStat(this.OyW, ((Integer)localEntry.getKey()).intValue(), ((Long)localEntry.getValue()).longValue(), false);
        }
        this.OyX = paramLong;
      }
    }
    finally
    {
      AppMethodBeat.o(125119);
    }
    AppMethodBeat.o(125119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b
 * JD-Core Version:    0.7.0.1
 */