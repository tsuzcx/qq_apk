package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

final class k$4
  implements View.OnClickListener
{
  k$4(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33715);
    ab.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
    d.b(k.d(this.AcQ), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
    AppMethodBeat.o(33715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.4
 * JD-Core Version:    0.7.0.1
 */