package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class e<T>
  extends a<Iterable<? extends T>, T>
{
  private static final a<?> LIU;
  
  static
  {
    AppMethodBeat.i(193463);
    LIU = new a((byte)0);
    AppMethodBeat.o(193463);
  }
  
  private e(List<Iterable<? extends T>> paramList)
  {
    super(paramList, LIU);
  }
  
  public e(Iterable<? extends T>... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
    AppMethodBeat.i(193462);
    AppMethodBeat.o(193462);
  }
  
  static final class a<T>
    implements a.a<Iterable<? extends T>, T>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.e
 * JD-Core Version:    0.7.0.1
 */