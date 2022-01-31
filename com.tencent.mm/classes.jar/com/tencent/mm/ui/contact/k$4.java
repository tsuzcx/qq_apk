package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;

final class k$4
  implements View.OnClickListener
{
  k$4(k paramk) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
    d.b(k.d(this.vLo), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.4
 * JD-Core Version:    0.7.0.1
 */