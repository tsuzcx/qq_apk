package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class q
{
  private long BNx;
  protected ConcurrentLinkedDeque<a> BNy;
  protected HashMap<String, a> BNz;
  
  public q()
  {
    AppMethodBeat.i(141154);
    this.BNx = System.currentTimeMillis();
    this.BNy = new ConcurrentLinkedDeque();
    this.BNz = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void g(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.BNy.add(new a(paramString1, paramLong, paramString2));
    h(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(190966);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.BNz.get(paramString1) == null) {
        this.BNz.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.BNz.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(190966);
  }
  
  public final long aAw(String paramString)
  {
    AppMethodBeat.i(190967);
    if ((this.BNz == null) || (this.BNz.isEmpty()))
    {
      AppMethodBeat.o(190967);
      return 0L;
    }
    if (this.BNz.get(paramString) != null)
    {
      long l = ((a)this.BNz.get(paramString)).time;
      AppMethodBeat.o(190967);
      return l;
    }
    AppMethodBeat.o(190967);
    return 0L;
  }
  
  public final void bG(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    g(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long bH(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.BNy == null) || (this.BNy.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.BNy.iterator();
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
    return this.BNx;
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