package com.tencent.mm.plugin_support.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;

public final class b
  implements a
{
  public final boolean isBusy()
  {
    AppMethodBeat.i(246442);
    boolean bool1 = f.isDownloading();
    boolean bool2 = d.getTBSInstalling();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(246442);
      return true;
    }
    AppMethodBeat.o(246442);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin_support.b.b
 * JD-Core Version:    0.7.0.1
 */