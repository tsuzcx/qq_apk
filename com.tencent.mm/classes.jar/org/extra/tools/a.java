package org.extra.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements ScreenBroadcastReceiver.a
{
  public static List<WeakReference<ScreenBroadcastReceiver.a>> ndS;
  public final Object OsZ;
  public ScreenBroadcastReceiver Ota;
  
  static
  {
    AppMethodBeat.i(216855);
    ndS = new ArrayList();
    AppMethodBeat.o(216855);
  }
  
  public a()
  {
    AppMethodBeat.i(216850);
    this.OsZ = new Object();
    this.Ota = null;
    AppMethodBeat.o(216850);
  }
  
  public static a gCQ()
  {
    AppMethodBeat.i(216851);
    a locala = a.gCS();
    AppMethodBeat.o(216851);
    return locala;
  }
  
  public final void gCR()
  {
    AppMethodBeat.i(216852);
    Object localObject3;
    synchronized (this.OsZ)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = ndS.iterator();
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
      ndS.remove(localObject3);
    }
    AppMethodBeat.o(216852);
  }
  
  public final void onScreenOff()
  {
    AppMethodBeat.i(216853);
    gCR();
    for (;;)
    {
      int i;
      synchronized (this.OsZ)
      {
        i = ndS.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)ndS.get(i)).get();
          if (locala != null) {
            locala.onScreenOff();
          }
        }
        else
        {
          AppMethodBeat.o(216853);
          return;
        }
      }
      i -= 1;
    }
  }
  
  public final void onScreenOn()
  {
    AppMethodBeat.i(216854);
    gCR();
    for (;;)
    {
      int i;
      synchronized (this.OsZ)
      {
        i = ndS.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)ndS.get(i)).get();
          if (locala != null) {
            locala.onScreenOn();
          }
        }
        else
        {
          AppMethodBeat.o(216854);
          return;
        }
      }
      i -= 1;
    }
  }
  
  static final class a
  {
    private static final a Otb;
    
    static
    {
      AppMethodBeat.i(216849);
      Otb = new a();
      AppMethodBeat.o(216849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.tools.a
 * JD-Core Version:    0.7.0.1
 */