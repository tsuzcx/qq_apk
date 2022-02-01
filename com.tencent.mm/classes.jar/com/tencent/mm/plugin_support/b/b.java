package com.tencent.mm.plugin_support.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.a.g;

public final class b
  implements a
{
  public final boolean isBusy()
  {
    AppMethodBeat.i(231233);
    boolean bool1 = g.isDownloading();
    boolean bool2 = e.getTBSInstalling();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(231233);
      return true;
    }
    AppMethodBeat.o(231233);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin_support.b.b
 * JD-Core Version:    0.7.0.1
 */