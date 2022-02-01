package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c
{
  private static ConcurrentLinkedQueue<WeakReference<a>> XFF;
  
  static
  {
    AppMethodBeat.i(110644);
    XFF = new ConcurrentLinkedQueue();
    AppMethodBeat.o(110644);
  }
  
  public static <T extends Parcelable> void a(T paramT, a parama)
  {
    AppMethodBeat.i(110643);
    if (MMApplicationContext.isMainProcess())
    {
      Iterator localIterator = XFF.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).notify(paramT);
        }
      }
    }
    ToolsProcessIPCService.a(paramT, b.class, new f()
    {
      public final void onCallback(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110638);
        if (c.this != null) {
          c.this.gtj();
        }
        AppMethodBeat.o(110638);
      }
    });
    AppMethodBeat.o(110643);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(110640);
    XFF.add(new WeakReference(parama));
    AppMethodBeat.o(110640);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(110641);
    Iterator localIterator = XFF.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == parama) {
        XFF.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(110641);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(110642);
    XFF.clear();
    AppMethodBeat.o(110642);
  }
  
  public static abstract interface a
  {
    public abstract void gtj();
  }
  
  static class b
    implements d
  {
    public void invoke(Object paramObject, f paramf)
    {
      AppMethodBeat.i(110639);
      Iterator localIterator = c.bCd().iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).notify(paramObject);
        }
      }
      paramf.onCallback(null);
      AppMethodBeat.o(110639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.c
 * JD-Core Version:    0.7.0.1
 */