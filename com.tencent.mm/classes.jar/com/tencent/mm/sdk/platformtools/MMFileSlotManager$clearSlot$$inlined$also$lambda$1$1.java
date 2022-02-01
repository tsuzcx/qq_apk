package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$clearSlot$3$1$1", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$$special$$inlined$batchRun$1$lambda$1"})
final class MMFileSlotManager$clearSlot$$inlined$also$lambda$1$1
  implements Runnable
{
  MMFileSlotManager$clearSlot$$inlined$also$lambda$1$1(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(175890);
    Iterator localIterator = ((Iterable)this.$toClear).iterator();
    while (localIterator.hasNext()) {
      s.deleteDir((String)localIterator.next());
    }
    AppMethodBeat.o(175890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMFileSlotManager.clearSlot..inlined.also.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */