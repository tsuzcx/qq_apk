package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cxv;

final class SDKOAuthUI$10
  implements View.OnClickListener
{
  SDKOAuthUI$10(SDKOAuthUI paramSDKOAuthUI, cxv paramcxv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(79742);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    SDKOAuthUI.a(this.Eab, this.Eac);
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(79742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.10
 * JD-Core Version:    0.7.0.1
 */