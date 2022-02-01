package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class e
{
  private static CopyOnWriteArrayList<a> ZHU;
  
  static
  {
    AppMethodBeat.i(222222);
    ZHU = new CopyOnWriteArrayList();
    AppMethodBeat.o(222222);
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(222217);
      if ((ZHU != null) && (!ZHU.contains(parama)))
      {
        ZHU.add(parama);
        g.i("TPGlobalEventNofication", "add onNetStatus change listener: " + parama + ", mListeners: " + ZHU.size());
      }
      AppMethodBeat.o(222217);
      return;
    }
    finally {}
  }
  
  public static void b(a parama)
  {
    try
    {
      AppMethodBeat.i(222219);
      if (ZHU != null)
      {
        ZHU.remove(parama);
        g.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + parama + ", mListeners: " + ZHU.size());
      }
      AppMethodBeat.o(222219);
      return;
    }
    finally {}
  }
  
  public static void g(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(222220);
      Iterator localIterator = ZHU.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).d(paramInt1, paramInt2, paramInt3, paramObject);
      }
      AppMethodBeat.o(222220);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.e
 * JD-Core Version:    0.7.0.1
 */