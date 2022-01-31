package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(1567);
    this.tgw.iTR.dOW();
    this.tgw.tge.setVisibility(8);
    this.tgw.tgc.setVisibility(0);
    AppMethodBeat.o(1567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.2
 * JD-Core Version:    0.7.0.1
 */