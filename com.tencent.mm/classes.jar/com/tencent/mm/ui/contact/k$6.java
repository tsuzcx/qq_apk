package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class k$6
  implements View.OnClickListener
{
  k$6(k paramk) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
    au.Hx();
    c.Dz().o(143618, Integer.valueOf(0));
    d.b(k.d(this.vLo), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.6
 * JD-Core Version:    0.7.0.1
 */