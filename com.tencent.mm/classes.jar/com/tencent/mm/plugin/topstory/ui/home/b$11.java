package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;

final class b$11
  implements View.OnClickListener
{
  b$11(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125941);
    long l = System.currentTimeMillis();
    if (l - this.AaU.AaH < 300L) {}
    try
    {
      if ((this.AaU.AaA != null) && (this.AaU.AaA.getView() != null)) {
        this.AaU.AaA.getView().scrollTo(this.AaU.AaA.getView().getScrollX(), 0);
      }
      label75:
      this.AaU.AaH = l;
      AppMethodBeat.o(125941);
      return;
    }
    catch (Throwable paramView)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.11
 * JD-Core Version:    0.7.0.1
 */