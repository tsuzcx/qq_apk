package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;

final class ContactMoreInfoUI$2
  implements View.OnClickListener
{
  ContactMoreInfoUI$2(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.mWt.mWs);
    paramView.putExtra("geta8key_username", q.Gj());
    d.b(this.mWt, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.2
 * JD-Core Version:    0.7.0.1
 */