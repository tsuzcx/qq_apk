package com.tencent.mm.plugin_support.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;

public final class d
  implements a
{
  public final boolean isBusy()
  {
    AppMethodBeat.i(231236);
    boolean bool = XWebCoreContentProvider.isBusy();
    AppMethodBeat.o(231236);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin_support.b.d
 * JD-Core Version:    0.7.0.1
 */