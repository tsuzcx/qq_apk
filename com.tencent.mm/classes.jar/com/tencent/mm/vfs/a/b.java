package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class b<S, T>
  implements Iterator<T>
{
  private final a.a<S, ? extends T> agBs;
  private final Iterator<? extends S> agBt;
  private Iterator<? extends T> agBu;
  private T agBv;
  private boolean agBw;
  
  public b(Iterator<? extends S> paramIterator, a.a<S, ? extends T> parama)
  {
    AppMethodBeat.i(238530);
    this.agBt = paramIterator;
    this.agBs = parama;
    this.agBu = Collections.emptyList().iterator();
    AppMethodBeat.o(238530);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(238537);
    if (this.agBw)
    {
      AppMethodBeat.o(238537);
      return true;
    }
    if (this.agBu == null)
    {
      AppMethodBeat.o(238537);
      return false;
    }
    if (!this.agBu.hasNext())
    {
      this.agBv = null;
      this.agBu = null;
      if (this.agBt.hasNext())
      {
        Object localObject = this.agBs.gU(this.agBt.next());
        if (localObject != null) {}
        for (localObject = ((Iterable)localObject).iterator();; localObject = Collections.emptyList().iterator())
        {
          this.agBu = ((Iterator)localObject);
          break;
        }
      }
      AppMethodBeat.o(238537);
      return false;
    }
    this.agBv = this.agBu.next();
    this.agBw = true;
    AppMethodBeat.o(238537);
    return true;
  }
  
  public final T next()
  {
    AppMethodBeat.i(238541);
    if ((!this.agBw) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(238541);
      throw ((Throwable)localObject);
    }
    Object localObject = this.agBv;
    this.agBv = null;
    this.agBw = false;
    AppMethodBeat.o(238541);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.b
 * JD-Core Version:    0.7.0.1
 */