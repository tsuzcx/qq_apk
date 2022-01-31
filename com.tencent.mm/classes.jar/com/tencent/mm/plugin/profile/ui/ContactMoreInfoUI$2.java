package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;

final class ContactMoreInfoUI$2
  implements View.OnClickListener
{
  ContactMoreInfoUI$2(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23407);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.pzo.pzn);
    paramView.putExtra("geta8key_username", r.Zn());
    d.b(this.pzo, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(23407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.2
 * JD-Core Version:    0.7.0.1
 */