package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

final class l$6
  implements View.OnClickListener
{
  l$6(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37836);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
    bh.bCz();
    com.tencent.mm.model.c.ban().B(143618, Integer.valueOf(0));
    com.tencent.mm.br.c.b(l.d(this.afdX), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
    a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l.6
 * JD-Core Version:    0.7.0.1
 */