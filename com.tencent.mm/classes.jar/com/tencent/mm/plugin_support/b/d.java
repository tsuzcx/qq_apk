package com.tencent.mm.plugin_support.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;

public final class d
  implements a
{
  public final boolean isBusy()
  {
    AppMethodBeat.i(246446);
    boolean bool = XWebCoreContentProvider.isBusy();
    AppMethodBeat.o(246446);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin_support.b.d
 * JD-Core Version:    0.7.0.1
 */