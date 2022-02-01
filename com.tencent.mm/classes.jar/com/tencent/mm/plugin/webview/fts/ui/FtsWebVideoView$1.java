package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FtsWebVideoView$1
  implements View.OnClickListener
{
  FtsWebVideoView$1(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(78036);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.WCO.pause();
    a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(78036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.1
 * JD-Core Version:    0.7.0.1
 */