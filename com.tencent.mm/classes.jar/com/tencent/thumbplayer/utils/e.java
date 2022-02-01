package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class e
{
  private static CopyOnWriteArrayList<a> Sfj;
  
  static
  {
    AppMethodBeat.i(189633);
    Sfj = new CopyOnWriteArrayList();
    AppMethodBeat.o(189633);
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(189630);
      if ((Sfj != null) && (!Sfj.contains(parama)))
      {
        Sfj.add(parama);
        g.i("TPGlobalEventNofication", "add onNetStatus change listener: " + parama + ", mListeners: " + Sfj.size());
      }
      AppMethodBeat.o(189630);
      return;
    }
    finally {}
  }
  
  public static void b(a parama)
  {
    try
    {
      AppMethodBeat.i(189631);
      if (Sfj != null)
      {
        Sfj.remove(parama);
        g.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + parama + ", mListeners: " + Sfj.size());
      }
      AppMethodBeat.o(189631);
      return;
    }
    finally {}
  }
  
  public static void g(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(189632);
      Iterator localIterator = Sfj.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).d(paramInt1, paramInt2, paramInt3, paramObject);
      }
      AppMethodBeat.o(189632);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.e
 * JD-Core Version:    0.7.0.1
 */