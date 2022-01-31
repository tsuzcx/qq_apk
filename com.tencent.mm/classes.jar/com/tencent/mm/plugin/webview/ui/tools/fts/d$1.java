package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

final class d$1
  implements ViewTreeObserver.OnPreDrawListener
{
  d$1(d paramd, View paramView) {}
  
  public final boolean onPreDraw()
  {
    this.rvG.getViewTreeObserver().removeOnPreDrawListener(this);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rvG.getLayoutParams();
    this.rvK.rvj = (localLayoutParams.leftMargin - this.rvK.mvy);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.1
 * JD-Core Version:    0.7.0.1
 */