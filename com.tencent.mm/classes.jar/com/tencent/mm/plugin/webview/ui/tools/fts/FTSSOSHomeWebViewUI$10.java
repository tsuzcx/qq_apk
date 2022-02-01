package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSSOSHomeWebViewUI$10
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$10(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80628);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.Jos.ggF();
    this.Jos.ggR();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSHomeWebViewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(80628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.10
 * JD-Core Version:    0.7.0.1
 */