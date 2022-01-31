package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class h$a
  implements Runnable
{
  private h$a(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(7009);
    if (this.uYl.uYi == null)
    {
      AppMethodBeat.o(7009);
      return;
    }
    File[] arrayOfFile = new File(this.uYl.uYi).getParentFile().listFiles(new h.a.1(this));
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        ab.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfFile[i].delete()) });
        i += 1;
      }
    }
    this.uYl.uYi = null;
    AppMethodBeat.o(7009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h.a
 * JD-Core Version:    0.7.0.1
 */