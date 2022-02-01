package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private int Iyr;
  private long Iys;
  private HashMap<Integer, Long> Iyt;
  private long mInterval;
  
  public b()
  {
    AppMethodBeat.i(125118);
    this.Iyt = new HashMap();
    this.Iyr = 463;
    this.mInterval = 300000L;
    AppMethodBeat.o(125118);
  }
  
  private void aL(int paramInt, long paramLong)
  {
    AppMethodBeat.i(125120);
    Long localLong = (Long)this.Iyt.get(Integer.valueOf(paramInt));
    long l = paramLong;
    if (localLong != null) {
      l = paramLong + localLong.longValue();
    }
    this.Iyt.put(Integer.valueOf(paramInt), Long.valueOf(l));
    AppMethodBeat.o(125120);
  }
  
  public final void r(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(125119);
    try
    {
      aL(paramInt1, paramLong);
      aL(paramInt2, 1L);
      paramLong = System.currentTimeMillis();
      if (paramLong - this.Iys > this.mInterval)
      {
        Iterator localIterator = this.Iyt.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          f.Iyx.idkeyStat(this.Iyr, ((Integer)localEntry.getKey()).intValue(), ((Long)localEntry.getValue()).longValue(), false);
        }
        this.Iys = paramLong;
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