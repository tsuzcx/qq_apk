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
  private long wSX;
  private HashMap<Integer, Long> wSY;
  
  public b()
  {
    AppMethodBeat.i(125118);
    this.wSY = new HashMap();
    this.mID = 463;
    this.mInterval = 300000L;
    AppMethodBeat.o(125118);
  }
  
  private void an(int paramInt, long paramLong)
  {
    AppMethodBeat.i(125120);
    Long localLong = (Long)this.wSY.get(Integer.valueOf(paramInt));
    long l = paramLong;
    if (localLong != null) {
      l = paramLong + localLong.longValue();
    }
    this.wSY.put(Integer.valueOf(paramInt), Long.valueOf(l));
    AppMethodBeat.o(125120);
  }
  
  public final void j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(125119);
    try
    {
      an(paramInt1, paramLong);
      an(paramInt2, 1L);
      paramLong = System.currentTimeMillis();
      if (paramLong - this.wSX > this.mInterval)
      {
        Iterator localIterator = this.wSY.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          e.wTc.idkeyStat(this.mID, ((Integer)localEntry.getKey()).intValue(), ((Long)localEntry.getValue()).longValue(), false);
        }
        this.wSX = paramLong;
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