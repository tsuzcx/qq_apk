package org.extra.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements ScreenBroadcastReceiver.a
{
  public static List<WeakReference<ScreenBroadcastReceiver.a>> opg;
  public final Object UhX;
  public ScreenBroadcastReceiver UhY;
  
  static
  {
    AppMethodBeat.i(236820);
    opg = new ArrayList();
    AppMethodBeat.o(236820);
  }
  
  public a()
  {
    AppMethodBeat.i(236815);
    this.UhX = new Object();
    this.UhY = null;
    AppMethodBeat.o(236815);
  }
  
  public static a hPU()
  {
    AppMethodBeat.i(236816);
    a locala = a.hPW();
    AppMethodBeat.o(236816);
    return locala;
  }
  
  public final void hPV()
  {
    AppMethodBeat.i(236817);
    Object localObject3;
    synchronized (this.UhX)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = opg.iterator();
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
      opg.remove(localObject3);
    }
    AppMethodBeat.o(236817);
  }
  
  public final void onScreenOff()
  {
    AppMethodBeat.i(236818);
    hPV();
    for (;;)
    {
      int i;
      synchronized (this.UhX)
      {
        i = opg.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)opg.get(i)).get();
          if (locala != null) {
            locala.onScreenOff();
          }
        }
        else
        {
          AppMethodBeat.o(236818);
          return;
        }
      }
      i -= 1;
    }
  }
  
  public final void onScreenOn()
  {
    AppMethodBeat.i(236819);
    hPV();
    for (;;)
    {
      int i;
      synchronized (this.UhX)
      {
        i = opg.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)opg.get(i)).get();
          if (locala != null) {
            locala.onScreenOn();
          }
        }
        else
        {
          AppMethodBeat.o(236819);
          return;
        }
      }
      i -= 1;
    }
  }
  
  static final class a
  {
    private static final a UhZ;
    
    static
    {
      AppMethodBeat.i(236814);
      UhZ = new a();
      AppMethodBeat.o(236814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.extra.tools.a
 * JD-Core Version:    0.7.0.1
 */