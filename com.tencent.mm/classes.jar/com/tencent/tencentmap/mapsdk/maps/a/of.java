package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class of
  implements ny
{
  private LinkedList<ny> a;
  private volatile boolean b;
  private final ReentrantLock c;
  
  public of()
  {
    AppMethodBeat.i(149597);
    this.c = new ReentrantLock();
    AppMethodBeat.o(149597);
  }
  
  private static void a(Collection<ny> paramCollection)
  {
    AppMethodBeat.i(149599);
    if (paramCollection == null)
    {
      AppMethodBeat.o(149599);
      return;
    }
    ny localny = null;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = localny;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label78;
      }
      localny = (ny)localIterator.next();
      try
      {
        localny.b();
      }
      catch (Throwable localThrowable)
      {
        if (paramCollection != null) {
          break label88;
        }
      }
    }
    paramCollection = new ArrayList();
    label78:
    label88:
    for (;;)
    {
      paramCollection.add(localThrowable);
      break;
      oa.a(paramCollection);
      AppMethodBeat.o(149599);
      return;
    }
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final void b()
  {
    AppMethodBeat.i(149598);
    if (!this.b) {
      this.c.lock();
    }
    try
    {
      boolean bool = this.b;
      if (bool) {
        return;
      }
      this.b = true;
      LinkedList localLinkedList = this.a;
      this.a = null;
      this.c.unlock();
      a(localLinkedList);
      AppMethodBeat.o(149598);
      return;
    }
    finally
    {
      this.c.unlock();
      AppMethodBeat.o(149598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.of
 * JD-Core Version:    0.7.0.1
 */