package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class s
{
  private LinkedList<s.a> vJE;
  
  public s()
  {
    AppMethodBeat.i(105834);
    this.vJE = new LinkedList();
    AppMethodBeat.o(105834);
  }
  
  private void d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(105836);
    this.vJE.add(new s.a(this, paramString1, paramLong, paramString2));
    AppMethodBeat.o(105836);
  }
  
  public final void aX(String paramString, long paramLong)
  {
    AppMethodBeat.i(105835);
    d(paramString, paramLong, "");
    AppMethodBeat.o(105835);
  }
  
  public final long alb(String paramString)
  {
    AppMethodBeat.i(105837);
    Iterator localIterator = this.vJE.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
      if (locala.key.equals(paramString))
      {
        long l = locala.time;
        AppMethodBeat.o(105837);
        return l;
      }
    }
    AppMethodBeat.o(105837);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.s
 * JD-Core Version:    0.7.0.1
 */