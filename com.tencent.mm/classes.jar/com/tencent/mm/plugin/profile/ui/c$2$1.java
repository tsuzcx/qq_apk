package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.ui.MMActivity;

final class c$2$1
  implements DialogInterface.OnClickListener
{
  c$2$1(c.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.mWZ.mWY;
    String str = paramDialogInterface.dnp.field_username;
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().Hz(str);
    au.Hx();
    com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.c(str, ((cs)localObject).field_msgSvrId));
    paramDialogInterface.isDeleteCancel = false;
    localObject = paramDialogInterface.bER;
    paramDialogInterface.bER.getString(R.l.app_tip);
    paramDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, paramDialogInterface.bER.getString(R.l.app_waiting), true, new c.9(paramDialogInterface));
    bd.a(str, new c.10(paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.2.1
 * JD-Core Version:    0.7.0.1
 */