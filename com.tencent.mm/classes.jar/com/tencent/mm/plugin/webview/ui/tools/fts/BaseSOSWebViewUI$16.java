package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseSOSWebViewUI$16
  implements View.OnLongClickListener
{
  BaseSOSWebViewUI$16(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(211209);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(211209);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.16
 * JD-Core Version:    0.7.0.1
 */