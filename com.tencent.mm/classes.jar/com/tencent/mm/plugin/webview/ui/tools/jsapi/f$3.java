package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class f$3
  implements FilenameFilter
{
  f$3(f paramf, String paramString) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(9022);
    if (!paramString.equals(this.vpm))
    {
      AppMethodBeat.o(9022);
      return true;
    }
    AppMethodBeat.o(9022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.3
 * JD-Core Version:    0.7.0.1
 */