package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c
{
  private static ConcurrentLinkedQueue<WeakReference<a>> vFG;
  
  static
  {
    AppMethodBeat.i(63473);
    vFG = new ConcurrentLinkedQueue();
    AppMethodBeat.o(63473);
  }
  
  public static <T extends Parcelable> void a(T paramT, c.a parama)
  {
    AppMethodBeat.i(63472);
    ToolsProcessIPCService.a(paramT, c.b.class, new c.1(parama));
    AppMethodBeat.o(63472);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(63469);
    vFG.add(new WeakReference(parama));
    AppMethodBeat.o(63469);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(63470);
    Iterator localIterator = vFG.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == parama) {
        vFG.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(63470);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(63471);
    vFG.clear();
    AppMethodBeat.o(63471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.c
 * JD-Core Version:    0.7.0.1
 */