package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;

final class ContactMoreInfoUI$3
  implements View.OnClickListener
{
  ContactMoreInfoUI$3(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27028);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (Util.isNullOrNil(ContactMoreInfoUI.a(this.BeD))) {
      ContactMoreInfoUI.a(this.BeD, ContactMoreInfoUI.b(this.BeD).fuV);
    }
    if (!Util.isNullOrNil(ContactMoreInfoUI.a(this.BeD)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", ContactMoreInfoUI.a(this.BeD));
      paramView.putExtra("geta8key_username", z.aTY());
      c.b(this.BeD, "webview", ".ui.tools.WebViewUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactMoreInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.3
 * JD-Core Version:    0.7.0.1
 */