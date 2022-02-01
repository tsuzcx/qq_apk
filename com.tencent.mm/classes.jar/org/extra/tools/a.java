package org.extra.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements ScreenBroadcastReceiver.a
{
  public static List<WeakReference<ScreenBroadcastReceiver.a>> uQh;
  public final Object ajYl;
  public ScreenBroadcastReceiver ajYm;
  
  static
  {
    AppMethodBeat.i(187321);
    uQh = new ArrayList();
    AppMethodBeat.o(187321);
  }
  
  public a()
  {
    AppMethodBeat.i(187299);
    this.ajYl = new Object();
    this.ajYm = null;
    AppMethodBeat.o(187299);
  }
  
  public static a kJB()
  {
    AppMethodBeat.i(187312);
    a locala = a.kJD();
    AppMethodBeat.o(187312);
    return locala;
  }
  
  public final void kJC()
  {
    AppMethodBeat.i(187333);
    Object localObject3;
    synchronized (this.ajYl)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = uQh.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
        if (localWeakReference.get() == null) {
          localArrayList.add(localWeakReference);
        }
      }
    }
    Iterator localIterator = localObject2.iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (WeakReference)localIterator.next();
      uQh.remove(localObject3);
    }
    AppMethodBeat.o(187333);
  }
  
  public final void onScreenOff()
  {
    AppMethodBeat.i(187339);
    kJC();
    for (;;)
    {
      int i;
      synchronized (this.ajYl)
      {
        i = uQh.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)uQh.get(i)).get();
          if (locala != null) {
            locala.onScreenOff();
          }
        }
        else
        {
          AppMethodBeat.o(187339);
          return;
        }
      }
      i -= 1;
    }
  }
  
  public final void onScreenOn()
  {
    AppMethodBeat.i(187348);
    kJC();
    for (;;)
    {
      int i;
      synchronized (this.ajYl)
      {
        i = uQh.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)uQh.get(i)).get();
          if (locala != null) {
            locala.onScreenOn();
          }
        }
        else
        {
          AppMethodBeat.o(187348);
          return;
        }
      }
      i -= 1;
    }
  }
  
  static final class a
  {
    private static final a ajYn;
    
    static
    {
      AppMethodBeat.i(187303);
      ajYn = new a();
      AppMethodBeat.o(187303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.extra.tools.a
 * JD-Core Version:    0.7.0.1
 */