package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class e<T>
  implements Iterable<T>
{
  private static final a<?> agBz;
  private final List<Iterable<? extends T>> agBy;
  
  static
  {
    AppMethodBeat.i(238525);
    agBz = new a((byte)0);
    AppMethodBeat.o(238525);
  }
  
  public e(List<Iterable<? extends T>> paramList)
  {
    this.agBy = paramList;
  }
  
  @SafeVarargs
  public e(Iterable<? extends T>... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
    AppMethodBeat.i(238518);
    AppMethodBeat.o(238518);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(238532);
    b localb = new b(this.agBy.iterator(), agBz);
    AppMethodBeat.o(238532);
    return localb;
  }
  
  static final class a<T>
    implements a.a<Iterable<? extends T>, T>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.e
 * JD-Core Version:    0.7.0.1
 */