package org.extra.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements ScreenBroadcastReceiver.a
{
  public static List<WeakReference<ScreenBroadcastReceiver.a>> rEV;
  public final Object abLs;
  public ScreenBroadcastReceiver abLt;
  
  static
  {
    AppMethodBeat.i(194783);
    rEV = new ArrayList();
    AppMethodBeat.o(194783);
  }
  
  public a()
  {
    AppMethodBeat.i(194769);
    this.abLs = new Object();
    this.abLt = null;
    AppMethodBeat.o(194769);
  }
  
  public static a iVd()
  {
    AppMethodBeat.i(194770);
    a locala = a.iVf();
    AppMethodBeat.o(194770);
    return locala;
  }
  
  public final void iVe()
  {
    AppMethodBeat.i(194775);
    Object localObject3;
    synchronized (this.abLs)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = rEV.iterator();
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
      rEV.remove(localObject3);
    }
    AppMethodBeat.o(194775);
  }
  
  public final void onScreenOff()
  {
    AppMethodBeat.i(194778);
    iVe();
    for (;;)
    {
      int i;
      synchronized (this.abLs)
      {
        i = rEV.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)rEV.get(i)).get();
          if (locala != null) {
            locala.onScreenOff();
          }
        }
        else
        {
          AppMethodBeat.o(194778);
          return;
        }
      }
      i -= 1;
    }
  }
  
  public final void onScreenOn()
  {
    AppMethodBeat.i(194780);
    iVe();
    for (;;)
    {
      int i;
      synchronized (this.abLs)
      {
        i = rEV.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)rEV.get(i)).get();
          if (locala != null) {
            locala.onScreenOn();
          }
        }
        else
        {
          AppMethodBeat.o(194780);
          return;
        }
      }
      i -= 1;
    }
  }
  
  static final class a
  {
    private static final a abLu;
    
    static
    {
      AppMethodBeat.i(194765);
      abLu = new a();
      AppMethodBeat.o(194765);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.tools.a
 * JD-Core Version:    0.7.0.1
 */