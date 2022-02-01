package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class r
{
  private long EJD;
  protected ConcurrentLinkedDeque<a> EJE;
  protected HashMap<String, a> EJF;
  
  public r()
  {
    AppMethodBeat.i(141154);
    this.EJD = System.currentTimeMillis();
    this.EJE = new ConcurrentLinkedDeque();
    this.EJF = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.EJE.add(new a(paramString1, paramLong, paramString2));
    i(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void i(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(186429);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.EJF.get(paramString1) == null) {
        this.EJF.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.EJF.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(186429);
  }
  
  public final long aLo(String paramString)
  {
    AppMethodBeat.i(186430);
    if ((this.EJF == null) || (this.EJF.isEmpty()))
    {
      AppMethodBeat.o(186430);
      return 0L;
    }
    if (this.EJF.get(paramString) != null)
    {
      long l = ((a)this.EJF.get(paramString)).time;
      AppMethodBeat.o(186430);
      return l;
    }
    AppMethodBeat.o(186430);
    return 0L;
  }
  
  public final void bL(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    h(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long bM(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.EJE == null) || (this.EJE.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.EJE.iterator();
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
    return this.EJD;
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
 * Qualified Name:     com.tencent.mm.pluginsdk.r
 * JD-Core Version:    0.7.0.1
 */