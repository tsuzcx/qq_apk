package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseSOSWebViewUI$12
  implements View.OnClickListener
{
  BaseSOSWebViewUI$12(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80535);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.Jnm.fzm();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(80535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.12
 * JD-Core Version:    0.7.0.1
 */