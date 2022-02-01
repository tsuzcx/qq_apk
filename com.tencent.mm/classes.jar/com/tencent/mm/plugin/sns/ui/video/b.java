package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
{
  private static volatile b AAT;
  public Set<a> AAU;
  
  private b()
  {
    AppMethodBeat.i(176434);
    this.AAU = new HashSet();
    AppMethodBeat.o(176434);
  }
  
  public static b eeD()
  {
    AppMethodBeat.i(176435);
    if (AAT == null) {}
    try
    {
      if (AAT == null) {
        AAT = new b();
      }
      b localb = AAT;
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
    this.AAU.add(parama);
    Iterator localIterator = this.AAU.iterator();
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
    Iterator localIterator = this.AAU.iterator();
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