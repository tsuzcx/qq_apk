package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSBaseWebViewUI$8
  implements View.OnClickListener
{
  FTSBaseWebViewUI$8(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211229);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.JnQ.finish();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(211229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.8
 * JD-Core Version:    0.7.0.1
 */