package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class s
{
  public long XNW;
  protected ConcurrentLinkedDeque<a> XNX;
  protected HashMap<String, a> XNY;
  
  public s()
  {
    AppMethodBeat.i(141154);
    this.XNW = System.currentTimeMillis();
    this.XNX = new ConcurrentLinkedDeque();
    this.XNY = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void k(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.XNX.add(new a(paramString1, paramLong, paramString2));
    l(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void l(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(244505);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.XNY.get(paramString1) == null) {
        this.XNY.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.XNY.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(244505);
  }
  
  public final void cf(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    k(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long cg(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.XNX == null) || (this.XNX.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.XNX.iterator();
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
 * Qualified Name:     com.tencent.mm.pluginsdk.s
 * JD-Core Version:    0.7.0.1
 */