package com.tencent.mm.plugin.scanner.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$attachScrollTabView$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onScroll", "", "currentIndex", "", "offsetX", "", "offsetY", "onScrollStateChanged", "state", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$c
  implements d
{
  public final void onScrollStateChanged(int paramInt) {}
  
  public final void y(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(52432);
    Log.d("MicroMsg.ScanScrollTabController", "alvinluo onScroll currentIndex: %d, offsetX: %f, offsetY: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat), Float.valueOf(0.0F) });
    AppMethodBeat.o(52432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b.c
 * JD-Core Version:    0.7.0.1
 */