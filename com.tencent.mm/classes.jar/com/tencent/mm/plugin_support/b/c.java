package com.tencent.mm.plugin_support.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.w;

public final class c
  implements a
{
  public final boolean isBusy()
  {
    AppMethodBeat.i(246418);
    boolean bool = w.isBusy();
    AppMethodBeat.o(246418);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin_support.b.c
 * JD-Core Version:    0.7.0.1
 */