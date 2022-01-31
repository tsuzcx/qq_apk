package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class HighlightRectSideView$1
  implements ap.a
{
  HighlightRectSideView$1(HighlightRectSideView paramHighlightRectSideView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(81023);
    HighlightRectSideView.a(this.qxk);
    this.qxk.invalidate();
    AppMethodBeat.o(81023);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView.1
 * JD-Core Version:    0.7.0.1
 */