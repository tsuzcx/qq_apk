package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class e
{
  private static CopyOnWriteArrayList<a> ahMX;
  
  static
  {
    AppMethodBeat.i(227149);
    ahMX = new CopyOnWriteArrayList();
    AppMethodBeat.o(227149);
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(227110);
      if ((ahMX != null) && (!ahMX.contains(parama)))
      {
        ahMX.add(parama);
        g.i("TPGlobalEventNofication", "add onNetStatus change listener: " + parama + ", mListeners: " + ahMX.size());
      }
      AppMethodBeat.o(227110);
      return;
    }
    finally {}
  }
  
  public static void b(a parama)
  {
    try
    {
      AppMethodBeat.i(227127);
      if (ahMX != null)
      {
        ahMX.remove(parama);
        g.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + parama + ", mListeners: " + ahMX.size());
      }
      AppMethodBeat.o(227127);
      return;
    }
    finally {}
  }
  
  public static void g(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(227139);
      Iterator localIterator = ahMX.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).d(paramInt1, paramInt2, paramInt3, paramObject);
      }
      AppMethodBeat.o(227139);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.e
 * JD-Core Version:    0.7.0.1
 */