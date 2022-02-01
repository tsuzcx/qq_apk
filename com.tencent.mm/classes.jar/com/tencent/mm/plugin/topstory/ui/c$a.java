package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

final class c$a
  implements Runnable
{
  String GjZ;
  
  public c$a(String paramString)
  {
    this.GjZ = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(125869);
    Object localObject = new o(b.aKJ() + "topstory/trace.info");
    if ((((o)localObject).exists()) && (((o)localObject).length() > 2048L)) {
      ((o)localObject).delete();
    }
    if (!((o)localObject).heq().exists()) {
      ((o)localObject).heq().mkdirs();
    }
    this.GjZ = ("Trace:\n" + f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.GjZ);
    localObject = aa.z(((o)localObject).her());
    byte[] arrayOfByte = this.GjZ.getBytes();
    s.e((String)localObject, arrayOfByte, arrayOfByte.length);
    AppMethodBeat.o(125869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.a
 * JD-Core Version:    0.7.0.1
 */