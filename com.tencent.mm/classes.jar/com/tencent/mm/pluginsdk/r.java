package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class r
{
  private long JTa;
  protected ConcurrentLinkedDeque<a> JTb;
  protected HashMap<String, a> JTc;
  
  public r()
  {
    AppMethodBeat.i(141154);
    this.JTa = System.currentTimeMillis();
    this.JTb = new ConcurrentLinkedDeque();
    this.JTc = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void i(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.JTb.add(new a(paramString1, paramLong, paramString2));
    j(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void j(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(205086);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.JTc.get(paramString1) == null) {
        this.JTc.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.JTc.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(205086);
  }
  
  public final void bN(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    i(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long bO(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.JTb == null) || (this.JTb.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.JTb.iterator();
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
  
  public final long bdg(String paramString)
  {
    AppMethodBeat.i(205087);
    if ((this.JTc == null) || (this.JTc.isEmpty()))
    {
      AppMethodBeat.o(205087);
      return 0L;
    }
    if (this.JTc.get(paramString) != null)
    {
      long l = ((a)this.JTc.get(paramString)).time;
      AppMethodBeat.o(205087);
      return l;
    }
    AppMethodBeat.o(205087);
    return 0L;
  }
  
  public final long getStartTime()
  {
    return this.JTa;
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