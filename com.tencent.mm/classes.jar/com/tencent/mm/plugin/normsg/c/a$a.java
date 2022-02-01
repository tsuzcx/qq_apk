package com.tencent.mm.plugin.normsg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;

public final class a$a<T>
  extends HashSet<T>
{
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(149014);
    if (contains(paramT))
    {
      paramT = new UnsupportedOperationException();
      AppMethodBeat.o(149014);
      throw paramT;
    }
    boolean bool = super.add(paramT);
    AppMethodBeat.o(149014);
    return bool;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    AppMethodBeat.i(149015);
    paramCollection = new UnsupportedOperationException();
    AppMethodBeat.o(149015);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(149016);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(149016);
    throw localUnsupportedOperationException;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(149017);
    paramObject = new UnsupportedOperationException();
    AppMethodBeat.o(149017);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(149018);
    paramCollection = new UnsupportedOperationException();
    AppMethodBeat.o(149018);
    throw paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.a
 * JD-Core Version:    0.7.0.1
 */