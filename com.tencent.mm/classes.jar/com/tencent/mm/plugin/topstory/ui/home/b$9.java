package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;

final class b$9
  implements View.OnClickListener
{
  b$9(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1587);
    long l = System.currentTimeMillis();
    if (l - this.tgw.tgj < 300L) {}
    try
    {
      if ((this.tgw.tgc != null) && (this.tgw.tgc.getView() != null)) {
        this.tgw.tgc.getView().scrollTo(this.tgw.tgc.getView().getScrollX(), 0);
      }
      label76:
      this.tgw.tgj = l;
      AppMethodBeat.o(1587);
      return;
    }
    catch (Throwable paramView)
    {
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.9
 * JD-Core Version:    0.7.0.1
 */