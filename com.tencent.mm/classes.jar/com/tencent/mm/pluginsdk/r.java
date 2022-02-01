package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class r
{
  private long QSf;
  protected ConcurrentLinkedDeque<a> QSg;
  protected HashMap<String, a> QSh;
  
  public r()
  {
    AppMethodBeat.i(141154);
    this.QSf = System.currentTimeMillis();
    this.QSg = new ConcurrentLinkedDeque();
    this.QSh = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void i(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.QSg.add(new a(paramString1, paramLong, paramString2));
    j(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void j(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(216234);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.QSh.get(paramString1) == null) {
        this.QSh.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.QSh.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(216234);
  }
  
  public final void bU(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    i(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.QSg == null) || (this.QSg.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.QSg.iterator();
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
    return this.QSf;
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