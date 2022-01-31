package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements ViewTreeObserver.OnPreDrawListener
{
  d$1(d paramd, View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(8598);
    this.vlW.getViewTreeObserver().removeOnPreDrawListener(this);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.vlW.getLayoutParams();
    this.vma.vly = (localLayoutParams.leftMargin - this.vma.oVq);
    AppMethodBeat.o(8598);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.1
 * JD-Core Version:    0.7.0.1
 */