package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;

final class e$1
  implements DialogInterface.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.mXe;
    paramDialogInterface.isDeleteCancel = false;
    Context localContext = paramDialogInterface.context;
    paramDialogInterface.context.getString(R.l.app_tip);
    paramDialogInterface.tipDialog = h.b(localContext, paramDialogInterface.context.getString(R.l.app_waiting), true, new e.2(paramDialogInterface));
    bd.a("fmessage", new e.3(paramDialogInterface));
    au.Hx();
    c.FB().abu("fmessage");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e.1
 * JD-Core Version:    0.7.0.1
 */