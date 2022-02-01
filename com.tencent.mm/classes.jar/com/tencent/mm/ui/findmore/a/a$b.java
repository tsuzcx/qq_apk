package com.tencent.mm.ui.findmore.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class a$b
  implements Runnable
{
  a$b(boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(288802);
    if (!this.XHs) {
      Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot notify but enableShowNearByEntranceRedDot = false ,remove NearByEntrance ShowInfo");
    }
    AppMethodBeat.o(288802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.findmore.a.a.b
 * JD-Core Version:    0.7.0.1
 */