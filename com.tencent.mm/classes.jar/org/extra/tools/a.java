package org.extra.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements ScreenBroadcastReceiver.a
{
  public static List<WeakReference<ScreenBroadcastReceiver.a>> mYL;
  public final Object NVU;
  public ScreenBroadcastReceiver NVV;
  
  static
  {
    AppMethodBeat.i(220101);
    mYL = new ArrayList();
    AppMethodBeat.o(220101);
  }
  
  public a()
  {
    AppMethodBeat.i(220096);
    this.NVU = new Object();
    this.NVV = null;
    AppMethodBeat.o(220096);
  }
  
  public static a gyo()
  {
    AppMethodBeat.i(220097);
    a locala = a.gyq();
    AppMethodBeat.o(220097);
    return locala;
  }
  
  public final void gyp()
  {
    AppMethodBeat.i(220098);
    Object localObject3;
    synchronized (this.NVU)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = mYL.iterator();
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
      mYL.remove(localObject3);
    }
    AppMethodBeat.o(220098);
  }
  
  public final void onScreenOff()
  {
    AppMethodBeat.i(220099);
    gyp();
    for (;;)
    {
      int i;
      synchronized (this.NVU)
      {
        i = mYL.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)mYL.get(i)).get();
          if (locala != null) {
            locala.onScreenOff();
          }
        }
        else
        {
          AppMethodBeat.o(220099);
          return;
        }
      }
      i -= 1;
    }
  }
  
  public final void onScreenOn()
  {
    AppMethodBeat.i(220100);
    gyp();
    for (;;)
    {
      int i;
      synchronized (this.NVU)
      {
        i = mYL.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.a locala = (ScreenBroadcastReceiver.a)((WeakReference)mYL.get(i)).get();
          if (locala != null) {
            locala.onScreenOn();
          }
        }
        else
        {
          AppMethodBeat.o(220100);
          return;
        }
      }
      i -= 1;
    }
  }
  
  static final class a
  {
    private static final a NVW;
    
    static
    {
      AppMethodBeat.i(220095);
      NVW = new a();
      AppMethodBeat.o(220095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.tools.a
 * JD-Core Version:    0.7.0.1
 */