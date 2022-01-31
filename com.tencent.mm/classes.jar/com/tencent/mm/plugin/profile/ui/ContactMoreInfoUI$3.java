package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;

final class ContactMoreInfoUI$3
  implements View.OnClickListener
{
  ContactMoreInfoUI$3(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(ContactMoreInfoUI.a(this.mWt))) {
      ContactMoreInfoUI.a(this.mWt, ContactMoreInfoUI.b(this.mWt).cCN);
    }
    if (!bk.bl(ContactMoreInfoUI.a(this.mWt)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", ContactMoreInfoUI.a(this.mWt));
      paramView.putExtra("geta8key_username", q.Gj());
      d.b(this.mWt, "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.3
 * JD-Core Version:    0.7.0.1
 */