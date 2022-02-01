package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SDKOAuthUI$15
  implements View.OnClickListener
{
  SDKOAuthUI$15(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(79747);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent(this.Qcn, CreateAvatarUI.class);
    paramView.putExtra("0", SDKOAuthUI.a(this.Qcn));
    paramView.putExtra("default_fileid", SDKOAuthUI.m(this.Qcn));
    this.Qcn.startActivityForResult(paramView, 6);
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(79747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.15
 * JD-Core Version:    0.7.0.1
 */