package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class ac$4
  implements n.d
{
  ac$4(ac paramac, LinkedList paramLinkedList, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      ((com.tencent.mm.ui.chatting.b.b.e)this.vrD.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).aE(this.vrF);
      return;
    }
    paramMenuItem = b.YK(this.vrD.byx.pSb.field_username).C(this.vrG, this.vrD.byx.pSb.field_username);
    Activity localActivity = this.vrD.byx.vtz.getContext();
    this.vrD.byx.vtz.getMMResources().getString(R.l.app_tip);
    paramMenuItem.a(localActivity, this.vrD.byx.vtz.getMMResources().getString(R.l.room_delete_member_canceling), true, new ac.4.1(this, paramMenuItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ac.4
 * JD-Core Version:    0.7.0.1
 */