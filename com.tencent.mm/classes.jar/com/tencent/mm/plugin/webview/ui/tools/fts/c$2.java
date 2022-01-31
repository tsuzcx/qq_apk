package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class c$2
  implements ViewTreeObserver.OnPreDrawListener
{
  c$2(c paramc, View paramView) {}
  
  public final boolean onPreDraw()
  {
    this.rvI.getViewTreeObserver().removeOnPreDrawListener(this);
    this.rvJ.rvi = ((int)this.rvI.getX());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c.2
 * JD-Core Version:    0.7.0.1
 */