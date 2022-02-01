package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
{
  private static volatile b ziT;
  public Set<a> ziU;
  
  private b()
  {
    AppMethodBeat.i(176434);
    this.ziU = new HashSet();
    AppMethodBeat.o(176434);
  }
  
  public static b dSj()
  {
    AppMethodBeat.i(176435);
    if (ziT == null) {}
    try
    {
      if (ziT == null) {
        ziT = new b();
      }
      b localb = ziT;
      AppMethodBeat.o(176435);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(176435);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(176436);
    this.ziU.add(parama);
    Iterator localIterator = this.ziU.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != parama) {
        locala.pause();
      }
    }
    AppMethodBeat.o(176436);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176437);
    Iterator localIterator = this.ziU.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).pause();
    }
    AppMethodBeat.o(176437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.b
 * JD-Core Version:    0.7.0.1
 */