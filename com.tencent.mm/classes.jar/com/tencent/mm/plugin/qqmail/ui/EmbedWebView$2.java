package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmbedWebView$2
  implements Runnable
{
  EmbedWebView$2(EmbedWebView paramEmbedWebView) {}
  
  public final void run()
  {
    AppMethodBeat.i(68279);
    View localView = (View)this.pML.getParent();
    if (localView == null)
    {
      AppMethodBeat.o(68279);
      return;
    }
    localView = (View)localView.getParent();
    if ((localView != null) && ((localView instanceof ScrollView)))
    {
      EmbedWebView.a(this.pML);
      localView.setOnTouchListener(new EmbedWebView.2.1(this));
    }
    AppMethodBeat.o(68279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView.2
 * JD-Core Version:    0.7.0.1
 */