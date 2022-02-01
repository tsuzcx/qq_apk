package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c
{
  private static ConcurrentLinkedQueue<WeakReference<a>> BIt;
  
  static
  {
    AppMethodBeat.i(110644);
    BIt = new ConcurrentLinkedQueue();
    AppMethodBeat.o(110644);
  }
  
  public static <T extends Parcelable> void a(T paramT, a parama)
  {
    AppMethodBeat.i(110643);
    ToolsProcessIPCService.a(paramT, b.class, new d()
    {
      public final void bf(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110638);
        if (this.BIu != null) {
          this.BIu.cWw();
        }
        AppMethodBeat.o(110638);
      }
    });
    AppMethodBeat.o(110643);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(110640);
    BIt.add(new WeakReference(parama));
    AppMethodBeat.o(110640);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(110641);
    Iterator localIterator = BIt.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == parama) {
        BIt.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(110641);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(110642);
    BIt.clear();
    AppMethodBeat.o(110642);
  }
  
  public static abstract interface a
  {
    public abstract void cWw();
  }
  
  static class b
    implements b
  {
    public void invoke(Object paramObject, d paramd)
    {
      AppMethodBeat.i(110639);
      Iterator localIterator = c.etI().iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).dH(paramObject);
        }
      }
      paramd.bf(null);
      AppMethodBeat.o(110639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.c
 * JD-Core Version:    0.7.0.1
 */