package com.tencent.mm.plugin.wepkg.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class c$b
  implements com.tencent.mm.ipcinvoker.a
{
  public final void a(Object paramObject, com.tencent.mm.ipcinvoker.c paramc)
  {
    AppMethodBeat.i(63468);
    Iterator localIterator = c.dkz().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).cm(paramObject);
      }
    }
    paramc.ad(null);
    AppMethodBeat.o(63468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.c.b
 * JD-Core Version:    0.7.0.1
 */