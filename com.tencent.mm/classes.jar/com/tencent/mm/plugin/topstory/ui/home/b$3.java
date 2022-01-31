package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    try
    {
      if ((this.pEb.pDU != null) && (this.pEb.pDU.getView() != null)) {
        this.pEb.pDU.getView().scrollTo(this.pEb.pDU.getView().getScrollX(), 0);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.3
 * JD-Core Version:    0.7.0.1
 */