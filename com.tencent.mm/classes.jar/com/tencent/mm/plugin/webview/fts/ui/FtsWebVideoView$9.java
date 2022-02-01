package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;

final class FtsWebVideoView$9
  implements View.OnClickListener
{
  FtsWebVideoView$9(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(78047);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.WCO.start(true);
    FtsWebVideoView.c(this.WCO).cvy();
    a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(78047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.9
 * JD-Core Version:    0.7.0.1
 */