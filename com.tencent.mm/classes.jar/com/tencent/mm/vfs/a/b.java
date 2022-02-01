package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class b<S, T>
  implements Iterator<T>
{
  private final a.a<S, ? extends T> ReQ;
  private final Iterator<? extends S> ReR;
  private Iterator<? extends T> ReS;
  private T ReT;
  private boolean ReU;
  
  public b(Iterator<? extends S> paramIterator, a.a<S, ? extends T> parama)
  {
    AppMethodBeat.i(187770);
    this.ReR = paramIterator;
    this.ReQ = parama;
    this.ReS = Collections.emptyList().iterator();
    AppMethodBeat.o(187770);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(187771);
    if (this.ReU)
    {
      AppMethodBeat.o(187771);
      return true;
    }
    if (this.ReS == null)
    {
      AppMethodBeat.o(187771);
      return false;
    }
    if (!this.ReS.hasNext())
    {
      this.ReT = null;
      this.ReS = null;
      if (this.ReR.hasNext())
      {
        Object localObject = this.ReQ.eq(this.ReR.next());
        if (localObject != null) {}
        for (localObject = ((Iterable)localObject).iterator();; localObject = Collections.emptyList().iterator())
        {
          this.ReS = ((Iterator)localObject);
          break;
        }
      }
      AppMethodBeat.o(187771);
      return false;
    }
    this.ReT = this.ReS.next();
    this.ReU = true;
    AppMethodBeat.o(187771);
    return true;
  }
  
  public final T next()
  {
    AppMethodBeat.i(187772);
    if ((!this.ReU) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(187772);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ReT;
    this.ReT = null;
    this.ReU = false;
    AppMethodBeat.o(187772);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.b
 * JD-Core Version:    0.7.0.1
 */