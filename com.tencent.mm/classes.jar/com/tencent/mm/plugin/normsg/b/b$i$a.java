package com.tencent.mm.plugin.normsg.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$i$a<T>
  extends SparseArray<T>
{
  private b$i$a(b.i parami) {}
  
  public final void clear()
  {
    AppMethodBeat.i(10413);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(10413);
    throw localUnsupportedOperationException;
  }
  
  public final void put(int paramInt, T paramT)
  {
    AppMethodBeat.i(10414);
    if (get(paramInt) != null)
    {
      paramT = new UnsupportedOperationException();
      AppMethodBeat.o(10414);
      throw paramT;
    }
    super.put(paramInt, paramT);
    AppMethodBeat.o(10414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.i.a
 * JD-Core Version:    0.7.0.1
 */