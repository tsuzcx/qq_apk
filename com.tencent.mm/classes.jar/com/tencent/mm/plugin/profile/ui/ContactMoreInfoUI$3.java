package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bo;

final class ContactMoreInfoUI$3
  implements View.OnClickListener
{
  ContactMoreInfoUI$3(ContactMoreInfoUI paramContactMoreInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23408);
    if (bo.isNullOrNil(ContactMoreInfoUI.a(this.pzo))) {
      ContactMoreInfoUI.a(this.pzo, ContactMoreInfoUI.b(this.pzo).dqX);
    }
    if (!bo.isNullOrNil(ContactMoreInfoUI.a(this.pzo)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", ContactMoreInfoUI.a(this.pzo));
      paramView.putExtra("geta8key_username", r.Zn());
      d.b(this.pzo, "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(23408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.3
 * JD-Core Version:    0.7.0.1
 */