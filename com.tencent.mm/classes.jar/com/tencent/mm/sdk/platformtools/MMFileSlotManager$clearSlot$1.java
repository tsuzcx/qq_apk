package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
final class MMFileSlotManager$clearSlot$1
  implements w
{
  MMFileSlotManager$clearSlot$1(long paramLong) {}
  
  public final boolean accept(o paramo, String paramString)
  {
    AppMethodBeat.i(215484);
    p.h(paramString, "name");
    boolean bool = p.j(paramString, String.valueOf(this.$slotId));
    AppMethodBeat.o(215484);
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMFileSlotManager.clearSlot.1
 * JD-Core Version:    0.7.0.1
 */