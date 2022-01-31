package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;

public final class a$a<T>
  extends HashSet<T>
{
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(10361);
    if (contains(paramT))
    {
      paramT = new UnsupportedOperationException();
      AppMethodBeat.o(10361);
      throw paramT;
    }
    boolean bool = super.add(paramT);
    AppMethodBeat.o(10361);
    return bool;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    AppMethodBeat.i(10362);
    paramCollection = new UnsupportedOperationException();
    AppMethodBeat.o(10362);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(10363);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(10363);
    throw localUnsupportedOperationException;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(10364);
    paramObject = new UnsupportedOperationException();
    AppMethodBeat.o(10364);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(10365);
    paramCollection = new UnsupportedOperationException();
    AppMethodBeat.o(10365);
    throw paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a.a
 * JD-Core Version:    0.7.0.1
 */