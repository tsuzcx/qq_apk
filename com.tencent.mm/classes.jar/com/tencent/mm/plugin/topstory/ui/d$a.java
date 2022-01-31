package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.pluginsdk.f.h;
import java.io.File;

final class d$a
  implements Runnable
{
  String pDM;
  
  public d$a(String paramString)
  {
    this.pDM = paramString;
  }
  
  public final void run()
  {
    File localFile = new File(com.tencent.mm.compatible.util.e.bkH + "topstory/trace.info");
    if ((localFile.exists()) && (localFile.length() > 2048L)) {
      localFile.delete();
    }
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    this.pDM = ("Trace:\n" + h.g("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.pDM);
    com.tencent.mm.a.e.e(localFile.getAbsolutePath(), this.pDM.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.a
 * JD-Core Version:    0.7.0.1
 */