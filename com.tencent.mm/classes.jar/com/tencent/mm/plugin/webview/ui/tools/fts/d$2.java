package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements ViewTreeObserver.OnPreDrawListener
{
  d$2(d paramd, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(8599);
    this.vlY.getViewTreeObserver().removeOnPreDrawListener(this);
    this.vma.vlx = 0;
    AppMethodBeat.o(8599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.2
 * JD-Core Version:    0.7.0.1
 */