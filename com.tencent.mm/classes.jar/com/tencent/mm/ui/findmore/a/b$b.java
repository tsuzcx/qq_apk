package com.tencent.mm.ui.findmore.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class b$b
  implements Runnable
{
  b$b(boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(288220);
    if (!this.XHx) {
      Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot notify but enableShowNearByEntranceRedDot = false ,remove NearByEntrance ShowInfo");
    }
    AppMethodBeat.o(288220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.findmore.a.b.b
 * JD-Core Version:    0.7.0.1
 */