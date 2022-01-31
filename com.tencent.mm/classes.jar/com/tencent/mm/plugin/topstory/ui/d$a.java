package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f.h;
import java.io.File;

final class d$a
  implements Runnable
{
  String tfJ;
  
  public d$a(String paramString)
  {
    this.tfJ = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(1532);
    File localFile = new File(com.tencent.mm.compatible.util.e.eQz + "topstory/trace.info");
    if ((localFile.exists()) && (localFile.length() > 2048L)) {
      localFile.delete();
    }
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    this.tfJ = ("Trace:\n" + h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.tfJ);
    com.tencent.mm.a.e.e(localFile.getAbsolutePath(), this.tfJ.getBytes());
    AppMethodBeat.o(1532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.a
 * JD-Core Version:    0.7.0.1
 */