package com.tencent.mm.plugin.scanner.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$attachScrollTabView$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onScroll", "", "currentIndex", "", "offsetX", "", "offsetY", "onScrollStateChanged", "state", "plugin-scan_release"})
public final class b$c
  implements d
{
  public final void cp(int paramInt) {}
  
  public final void s(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(52432);
    ac.d("MicroMsg.ScanScrollTabController", "alvinluo onScroll currentIndex: %d, offsetX: %f, offsetY: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat), Float.valueOf(0.0F) });
    AppMethodBeat.o(52432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b.c
 * JD-Core Version:    0.7.0.1
 */