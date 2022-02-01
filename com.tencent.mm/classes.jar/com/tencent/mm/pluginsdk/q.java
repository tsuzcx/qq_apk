package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class q
{
  private long DfH;
  protected ConcurrentLinkedDeque<a> DfI;
  protected HashMap<String, a> DfJ;
  
  public q()
  {
    AppMethodBeat.i(141154);
    this.DfH = System.currentTimeMillis();
    this.DfI = new ConcurrentLinkedDeque();
    this.DfJ = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.DfI.add(new a(paramString1, paramLong, paramString2));
    i(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void i(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(197172);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.DfJ.get(paramString1) == null) {
        this.DfJ.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.DfJ.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(197172);
  }
  
  public final long aFO(String paramString)
  {
    AppMethodBeat.i(197173);
    if ((this.DfJ == null) || (this.DfJ.isEmpty()))
    {
      AppMethodBeat.o(197173);
      return 0L;
    }
    if (this.DfJ.get(paramString) != null)
    {
      long l = ((a)this.DfJ.get(paramString)).time;
      AppMethodBeat.o(197173);
      return l;
    }
    AppMethodBeat.o(197173);
    return 0L;
  }
  
  public final void bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    h(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long bJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.DfI == null) || (this.DfI.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.DfI.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.key.equals(paramString))
      {
        paramLong = locala.time;
        AppMethodBeat.o(141157);
        return paramLong;
      }
    }
    AppMethodBeat.o(141157);
    return paramLong;
  }
  
  public final long getStartTime()
  {
    return this.DfH;
  }
  
  public final class a
  {
    public String detail;
    public String key;
    public long time;
    
    a(String paramString1, long paramLong, String paramString2)
    {
      this.key = paramString1;
      this.time = paramLong;
      this.detail = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.q
 * JD-Core Version:    0.7.0.1
 */