package com.tencent.threadpool.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class h
{
  private static ConcurrentHashMap<String, g> evG;
  
  static
  {
    AppMethodBeat.i(183313);
    evG = new ConcurrentHashMap();
    AppMethodBeat.o(183313);
  }
  
  public static void release()
  {
    AppMethodBeat.i(183312);
    Iterator localIterator = evG.values().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).ayG();
    }
    AppMethodBeat.o(183312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.threadpool.e.h
 * JD-Core Version:    0.7.0.1
 */