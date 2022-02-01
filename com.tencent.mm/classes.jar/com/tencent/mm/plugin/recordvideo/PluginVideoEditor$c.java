package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.provider.a;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginVideoEditor$c
  implements h.b
{
  public static final c HFz;
  
  static
  {
    AppMethodBeat.i(75044);
    HFz = new c();
    AppMethodBeat.o(75044);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(75043);
    Object localObject = a.HIE;
    localObject = a.dqy();
    AppMethodBeat.o(75043);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor.c
 * JD-Core Version:    0.7.0.1
 */