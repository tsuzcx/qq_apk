package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

final class d$a
  implements Runnable
{
  String BrV;
  
  public d$a(String paramString)
  {
    this.BrV = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(125869);
    Object localObject = new e(b.arU() + "topstory/trace.info");
    if ((((e)localObject).exists()) && (((e)localObject).length() > 2048L)) {
      ((e)localObject).delete();
    }
    if (!((e)localObject).fOJ().exists()) {
      ((e)localObject).fOJ().mkdirs();
    }
    this.BrV = ("Trace:\n" + com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.BrV);
    localObject = q.B(((e)localObject).fOK());
    byte[] arrayOfByte = this.BrV.getBytes();
    com.tencent.mm.vfs.i.e((String)localObject, arrayOfByte, arrayOfByte.length);
    AppMethodBeat.o(125869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.a
 * JD-Core Version:    0.7.0.1
 */