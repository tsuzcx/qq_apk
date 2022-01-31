package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.fts.a.e;

final class ContactMoreInfoUI$5
  implements View.OnClickListener
{
  ContactMoreInfoUI$5(ContactMoreInfoUI paramContactMoreInfoUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23409);
    e.wr(this.euv);
    if (this.euv > 0)
    {
      paramView = new Intent(this.pzo, CommonChatroomInfoUI.class);
      paramView.putExtra("Select_Talker_Name", ContactMoreInfoUI.b(this.pzo).field_username);
      this.pzo.startActivity(paramView);
    }
    AppMethodBeat.o(23409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.5
 * JD-Core Version:    0.7.0.1
 */