package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

final class d$a
  implements Runnable
{
  String yMs;
  
  public d$a(String paramString)
  {
    this.yMs = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(125869);
    Object localObject = new e(b.aih() + "topstory/trace.info");
    if ((((e)localObject).exists()) && (((e)localObject).length() > 2048L)) {
      ((e)localObject).delete();
    }
    if (!((e)localObject).fhT().exists()) {
      ((e)localObject).fhT().mkdirs();
    }
    this.yMs = ("Trace:\n" + h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.yMs);
    localObject = q.B(((e)localObject).fhU());
    byte[] arrayOfByte = this.yMs.getBytes();
    i.e((String)localObject, arrayOfByte, arrayOfByte.length);
    AppMethodBeat.o(125869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.a
 * JD-Core Version:    0.7.0.1
 */