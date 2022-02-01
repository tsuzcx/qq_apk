package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.provider.a;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginVideoEditor$c
  implements h.b
{
  public static final c xJm;
  
  static
  {
    AppMethodBeat.i(75044);
    xJm = new c();
    AppMethodBeat.o(75044);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(75043);
    Object localObject = a.xMm;
    localObject = a.cBk();
    AppMethodBeat.o(75043);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor.c
 * JD-Core Version:    0.7.0.1
 */