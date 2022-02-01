package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.u;

final class ContactMoreInfoUI$2
  implements View.OnClickListener
{
  ContactMoreInfoUI$2(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27027);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.vJQ.vJP);
    paramView.putExtra("geta8key_username", u.axw());
    d.b(this.vJQ, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(27027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.2
 * JD-Core Version:    0.7.0.1
 */