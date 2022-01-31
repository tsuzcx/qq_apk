package com.tencent.mm.plugin.wepkg.event;

import com.tencent.mm.ipcinvoker.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class b$b
  implements com.tencent.mm.ipcinvoker.a
{
  public final void a(Object paramObject, c paramc)
  {
    Iterator localIterator = b.cjV().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bI(paramObject);
    }
    paramc.U(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.b.b
 * JD-Core Version:    0.7.0.1
 */