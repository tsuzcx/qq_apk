package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginVideoEditor$b
  implements h.b
{
  public static final b xto;
  
  static
  {
    AppMethodBeat.i(75042);
    xto = new b();
    AppMethodBeat.o(75042);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(75041);
    Object localObject = d.xuk;
    localObject = d.czG();
    AppMethodBeat.o(75041);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor.b
 * JD-Core Version:    0.7.0.1
 */