package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class e<T>
  implements Iterable<T>
{
  private static final a<?> ReX;
  private final List<Iterable<? extends T>> ReW;
  
  static
  {
    AppMethodBeat.i(187778);
    ReX = new a((byte)0);
    AppMethodBeat.o(187778);
  }
  
  private e(List<Iterable<? extends T>> paramList)
  {
    this.ReW = paramList;
  }
  
  @SafeVarargs
  public e(Iterable<? extends T>... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
    AppMethodBeat.i(187776);
    AppMethodBeat.o(187776);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(187777);
    b localb = new b(this.ReW.iterator(), ReX);
    AppMethodBeat.o(187777);
    return localb;
  }
  
  static final class a<T>
    implements a.a<Iterable<? extends T>, T>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.e
 * JD-Core Version:    0.7.0.1
 */