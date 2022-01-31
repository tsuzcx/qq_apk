package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.roomsdk.a.b;
import java.util.LinkedList;

final class e$12
  implements DialogInterface.OnClickListener
{
  e$12(e parame, LinkedList paramLinkedList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = b.YK(this.vpa.byx.getTalkerUserName()).a(this.vpa.byx.getTalkerUserName(), this.voM, this.egz);
    paramDialogInterface.b(new e.12.1(this));
    paramDialogInterface.c(new e.12.2(this));
    Activity localActivity = this.vpa.byx.vtz.getContext();
    this.vpa.byx.vtz.getMMResources().getString(R.l.app_tip);
    paramDialogInterface.a(localActivity, this.vpa.byx.vtz.getMMResources().getString(R.l.room_del_member), true, new e.12.3(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.e.12
 * JD-Core Version:    0.7.0.1
 */