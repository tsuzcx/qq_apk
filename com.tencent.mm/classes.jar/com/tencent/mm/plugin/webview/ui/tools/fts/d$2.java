package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class d$2
  implements ViewTreeObserver.OnPreDrawListener
{
  d$2(d paramd, View paramView) {}
  
  public final boolean onPreDraw()
  {
    this.rvI.getViewTreeObserver().removeOnPreDrawListener(this);
    this.rvK.rvi = 0;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d.2
 * JD-Core Version:    0.7.0.1
 */