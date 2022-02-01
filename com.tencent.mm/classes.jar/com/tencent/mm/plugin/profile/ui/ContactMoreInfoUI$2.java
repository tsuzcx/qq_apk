package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;

final class ContactMoreInfoUI$2
  implements View.OnClickListener
{
  ContactMoreInfoUI$2(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27027);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.wQZ.wQY);
    paramView.putExtra("geta8key_username", u.aAm());
    d.b(this.wQZ, "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.2
 * JD-Core Version:    0.7.0.1
 */