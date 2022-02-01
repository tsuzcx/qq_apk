package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class b<S, T>
  implements Iterator<T>
{
  private final a.a<S, ? extends T> YFK;
  private final Iterator<? extends S> YFL;
  private Iterator<? extends T> YFM;
  private T YFN;
  private boolean YFO;
  
  public b(Iterator<? extends S> paramIterator, a.a<S, ? extends T> parama)
  {
    AppMethodBeat.i(237039);
    this.YFL = paramIterator;
    this.YFK = parama;
    this.YFM = Collections.emptyList().iterator();
    AppMethodBeat.o(237039);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(237040);
    if (this.YFO)
    {
      AppMethodBeat.o(237040);
      return true;
    }
    if (this.YFM == null)
    {
      AppMethodBeat.o(237040);
      return false;
    }
    if (!this.YFM.hasNext())
    {
      this.YFN = null;
      this.YFM = null;
      if (this.YFL.hasNext())
      {
        Object localObject = this.YFK.ew(this.YFL.next());
        if (localObject != null) {}
        for (localObject = ((Iterable)localObject).iterator();; localObject = Collections.emptyList().iterator())
        {
          this.YFM = ((Iterator)localObject);
          break;
        }
      }
      AppMethodBeat.o(237040);
      return false;
    }
    this.YFN = this.YFM.next();
    this.YFO = true;
    AppMethodBeat.o(237040);
    return true;
  }
  
  public final T next()
  {
    AppMethodBeat.i(237041);
    if ((!this.YFO) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(237041);
      throw ((Throwable)localObject);
    }
    Object localObject = this.YFN;
    this.YFN = null;
    this.YFO = false;
    AppMethodBeat.o(237041);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.b
 * JD-Core Version:    0.7.0.1
 */