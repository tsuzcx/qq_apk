package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;

final class FtsWebVideoView$3
  implements View.OnClickListener
{
  FtsWebVideoView$3(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(78038);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    FtsWebVideoView.v(this.WCO);
    FtsWebVideoView.c(this.WCO).cvy();
    a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(78038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.3
 * JD-Core Version:    0.7.0.1
 */