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
    AppMethodBeat.i(208172);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.EgM.finish();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(208172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.8
 * JD-Core Version:    0.7.0.1
 */