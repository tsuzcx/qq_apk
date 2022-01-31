package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.ScrollView;

final class EmbedWebView$2
  implements Runnable
{
  EmbedWebView$2(EmbedWebView paramEmbedWebView) {}
  
  public final void run()
  {
    View localView = (View)this.nhy.getParent();
    if (localView == null) {}
    do
    {
      return;
      localView = (View)localView.getParent();
    } while ((localView == null) || (!(localView instanceof ScrollView)));
    EmbedWebView.a(this.nhy);
    localView.setOnTouchListener(new EmbedWebView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView.2
 * JD-Core Version:    0.7.0.1
 */