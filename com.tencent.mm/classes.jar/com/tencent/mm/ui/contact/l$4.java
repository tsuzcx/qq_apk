package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class l$4
  implements View.OnClickListener
{
  l$4(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37834);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
    c.b(l.d(this.afdX), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
    a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l.4
 * JD-Core Version:    0.7.0.1
 */