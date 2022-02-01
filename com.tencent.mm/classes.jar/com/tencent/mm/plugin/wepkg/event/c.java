package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c
{
  private static ConcurrentLinkedQueue<WeakReference<a>> JMO;
  
  static
  {
    AppMethodBeat.i(110644);
    JMO = new ConcurrentLinkedQueue();
    AppMethodBeat.o(110644);
  }
  
  public static <T extends Parcelable> void a(T paramT, c.a parama)
  {
    AppMethodBeat.i(110643);
    if (MMApplicationContext.isMainProcess())
    {
      Iterator localIterator = JMO.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).dt(paramT);
        }
      }
    }
    ToolsProcessIPCService.a(paramT, b.class, new c.1(parama));
    AppMethodBeat.o(110643);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(110640);
    JMO.add(new WeakReference(parama));
    AppMethodBeat.o(110640);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(110641);
    Iterator localIterator = JMO.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == parama) {
        JMO.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(110641);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(110642);
    JMO.clear();
    AppMethodBeat.o(110642);
  }
  
  static class b
    implements b
  {
    public void invoke(Object paramObject, d paramd)
    {
      AppMethodBeat.i(110639);
      Iterator localIterator = c.aVh().iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).dt(paramObject);
        }
      }
      paramd.bn(null);
      AppMethodBeat.o(110639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.c
 * JD-Core Version:    0.7.0.1
 */