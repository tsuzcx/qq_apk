package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

final class d$a
  implements Runnable
{
  String BJu;
  
  public d$a(String paramString)
  {
    this.BJu = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(125869);
    Object localObject = new k(b.asj() + "topstory/trace.info");
    if ((((k)localObject).exists()) && (((k)localObject).length() > 2048L)) {
      ((k)localObject).delete();
    }
    if (!((k)localObject).fTg().exists()) {
      ((k)localObject).fTg().mkdirs();
    }
    this.BJu = ("Trace:\n" + i.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.BJu);
    localObject = w.B(((k)localObject).fTh());
    byte[] arrayOfByte = this.BJu.getBytes();
    o.e((String)localObject, arrayOfByte, arrayOfByte.length);
    AppMethodBeat.o(125869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.a
 * JD-Core Version:    0.7.0.1
 */