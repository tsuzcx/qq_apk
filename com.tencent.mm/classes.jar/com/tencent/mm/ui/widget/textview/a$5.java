package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.widget.TextView;

final class a$5
  implements View.OnAttachStateChangeListener
{
  a$5(a parama) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    paramView = this.wsy;
    paramView.lh.getViewTreeObserver().removeOnScrollChangedListener(paramView.wsj);
    paramView.lh.getViewTreeObserver().removeOnPreDrawListener(paramView.qS);
    paramView.cKJ();
    paramView.cKI();
    paramView.wsk = null;
    paramView.wsl = null;
    paramView.wsp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.5
 * JD-Core Version:    0.7.0.1
 */