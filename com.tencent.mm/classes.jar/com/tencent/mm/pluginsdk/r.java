package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class r
{
  private long Fcb;
  protected ConcurrentLinkedDeque<a> Fcc;
  protected HashMap<String, a> Fcd;
  
  public r()
  {
    AppMethodBeat.i(141154);
    this.Fcb = System.currentTimeMillis();
    this.Fcc = new ConcurrentLinkedDeque();
    this.Fcd = new HashMap();
    AppMethodBeat.o(141154);
  }
  
  private void h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(141156);
    this.Fcc.add(new a(paramString1, paramLong, paramString2));
    i(paramString1, paramLong, paramString2);
    AppMethodBeat.o(141156);
  }
  
  private void i(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(193682);
    if ((paramString1.equals("onPageStarted")) || (paramString1.equals("onPageFinished")) || (paramString1.equals("getA8KeyStart")) || (paramString1.equals("getA8KeyEnd")) || (paramString1.equals("firstScreenTimestamp")) || (paramString1.equals("firstScreenTime")))
    {
      if (this.Fcd.get(paramString1) == null) {
        this.Fcd.put(paramString1, new a(paramString1, paramLong, paramString2));
      }
      ((a)this.Fcd.get(paramString1)).time = paramLong;
    }
    AppMethodBeat.o(193682);
  }
  
  public final long aMK(String paramString)
  {
    AppMethodBeat.i(193683);
    if ((this.Fcd == null) || (this.Fcd.isEmpty()))
    {
      AppMethodBeat.o(193683);
      return 0L;
    }
    if (this.Fcd.get(paramString) != null)
    {
      long l = ((a)this.Fcd.get(paramString)).time;
      AppMethodBeat.o(193683);
      return l;
    }
    AppMethodBeat.o(193683);
    return 0L;
  }
  
  public final void bM(String paramString, long paramLong)
  {
    AppMethodBeat.i(141155);
    h(paramString, paramLong, "");
    AppMethodBeat.o(141155);
  }
  
  public final long bN(String paramString, long paramLong)
  {
    AppMethodBeat.i(141157);
    if ((this.Fcc == null) || (this.Fcc.isEmpty()))
    {
      AppMethodBeat.o(141157);
      return paramLong;
    }
    Iterator localIterator = this.Fcc.iterator();
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
    return this.Fcb;
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