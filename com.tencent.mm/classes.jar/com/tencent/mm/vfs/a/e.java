package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class e<T>
  implements Iterable<T>
{
  private static final a<?> YFR;
  private final List<Iterable<? extends T>> YFQ;
  
  static
  {
    AppMethodBeat.i(237072);
    YFR = new a((byte)0);
    AppMethodBeat.o(237072);
  }
  
  private e(List<Iterable<? extends T>> paramList)
  {
    this.YFQ = paramList;
  }
  
  @SafeVarargs
  public e(Iterable<? extends T>... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
    AppMethodBeat.i(237068);
    AppMethodBeat.o(237068);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(237070);
    b localb = new b(this.YFQ.iterator(), YFR);
    AppMethodBeat.o(237070);
    return localb;
  }
  
  static final class a<T>
    implements a.a<Iterable<? extends T>, T>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.e
 * JD-Core Version:    0.7.0.1
 */