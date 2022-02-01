package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class b<S, T>
  implements Iterator<T>
{
  private final a.a<S, ? extends T> LIO;
  private final Iterator<? extends S> LIP;
  private Iterator<? extends T> LIQ;
  private T LIR;
  private boolean LIS;
  
  public b(Iterator<? extends S> paramIterator, a.a<S, ? extends T> parama)
  {
    AppMethodBeat.i(193456);
    this.LIP = paramIterator;
    this.LIO = parama;
    this.LIQ = Collections.emptyList().iterator();
    AppMethodBeat.o(193456);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(193457);
    if (this.LIS)
    {
      AppMethodBeat.o(193457);
      return true;
    }
    if (this.LIQ == null)
    {
      AppMethodBeat.o(193457);
      return false;
    }
    if (!this.LIQ.hasNext())
    {
      this.LIR = null;
      this.LIQ = null;
      if (this.LIP.hasNext())
      {
        Object localObject = this.LIO.em(this.LIP.next());
        if (localObject != null) {}
        for (localObject = ((Iterable)localObject).iterator();; localObject = Collections.emptyList().iterator())
        {
          this.LIQ = ((Iterator)localObject);
          break;
        }
      }
      AppMethodBeat.o(193457);
      return false;
    }
    this.LIR = this.LIQ.next();
    this.LIS = true;
    AppMethodBeat.o(193457);
    return true;
  }
  
  public final T next()
  {
    AppMethodBeat.i(193458);
    if ((!this.LIS) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(193458);
      throw ((Throwable)localObject);
    }
    Object localObject = this.LIR;
    this.LIR = null;
    this.LIS = false;
    AppMethodBeat.o(193458);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.b
 * JD-Core Version:    0.7.0.1
 */