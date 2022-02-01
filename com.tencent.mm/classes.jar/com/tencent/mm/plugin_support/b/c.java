package com.tencent.mm.plugin_support.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ao;

public final class c
  implements a
{
  public final boolean isBusy()
  {
    AppMethodBeat.i(231235);
    boolean bool = ao.isBusy();
    AppMethodBeat.o(231235);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin_support.b.c
 * JD-Core Version:    0.7.0.1
 */