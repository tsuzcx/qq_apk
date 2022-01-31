package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.fts.a.e;

final class ContactMoreInfoUI$5
  implements View.OnClickListener
{
  ContactMoreInfoUI$5(ContactMoreInfoUI paramContactMoreInfoUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    e.rw(this.dAU);
    if (this.dAU > 0)
    {
      paramView = new Intent(this.mWt, CommonChatroomInfoUI.class);
      paramView.putExtra("Select_Talker_Name", ContactMoreInfoUI.b(this.mWt).field_username);
      this.mWt.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI.5
 * JD-Core Version:    0.7.0.1
 */