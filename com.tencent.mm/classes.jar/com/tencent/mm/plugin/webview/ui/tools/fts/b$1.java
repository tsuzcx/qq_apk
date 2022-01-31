package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements ViewTreeObserver.OnPreDrawListener
{
  b$1(b paramb, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(8573);
    this.vlW.getViewTreeObserver().removeOnPreDrawListener(this);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.vlW.getLayoutParams();
    this.vlX.vly = (localLayoutParams.leftMargin - this.vlX.oVq);
    AppMethodBeat.o(8573);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b.1
 * JD-Core Version:    0.7.0.1
 */