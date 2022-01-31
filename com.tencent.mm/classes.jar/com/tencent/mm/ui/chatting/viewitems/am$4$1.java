package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.cdu;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class am$4$1
  implements DialogInterface.OnClickListener
{
  am$4$1(am.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    au.Dk().a(331, am.a(this.vGH.vGE, new am.4.1.1(this)));
    paramDialogInterface = new LinkedList();
    Object localObject = new cdu();
    ((cdu)localObject).swT = this.vGH.vGG.pvH;
    paramDialogInterface.add(localObject);
    paramDialogInterface = new com.tencent.mm.plugin.subapp.c.a(paramDialogInterface, paramDialogInterface.size());
    au.Dk().a(paramDialogInterface, 0);
    localObject = this.vGH.vGE;
    Activity localActivity = am.a(this.vGH.vGE).vtz.getContext();
    am.a(this.vGH.vGE).vtz.getMMResources().getString(R.l.app_tip);
    am.a((am)localObject, h.b(localActivity, am.a(this.vGH.vGE).vtz.getMMResources().getString(R.l.chatting_item_voice_reminder_delting), true, new am.4.1.2(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.4.1
 * JD-Core Version:    0.7.0.1
 */