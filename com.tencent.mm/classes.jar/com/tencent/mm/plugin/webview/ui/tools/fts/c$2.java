package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements ViewTreeObserver.OnPreDrawListener
{
  c$2(c paramc, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(8588);
    this.vlY.getViewTreeObserver().removeOnPreDrawListener(this);
    this.vlZ.vlx = ((int)this.vlY.getX());
    AppMethodBeat.o(8588);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c.2
 * JD-Core Version:    0.7.0.1
 */