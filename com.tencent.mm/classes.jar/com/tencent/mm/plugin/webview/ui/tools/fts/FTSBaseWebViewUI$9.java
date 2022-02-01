package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSBaseWebViewUI$9
  implements View.OnLongClickListener
{
  FTSBaseWebViewUI$9(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(211230);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(211230);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */