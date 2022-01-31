package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class h$a
  implements Runnable
{
  private h$a(h paramh) {}
  
  public final void run()
  {
    if (this.riL.riI == null) {
      return;
    }
    File[] arrayOfFile = new File(this.riL.riI).getParentFile().listFiles(new h.a.1(this));
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      y.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfFile[i].delete()) });
      i += 1;
    }
    this.riL.riI = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h.a
 * JD-Core Version:    0.7.0.1
 */