package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.ui.MMActivity;

final class c$2$1
  implements DialogInterface.OnClickListener
{
  c$2$1(c.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23457);
    paramDialogInterface = this.pzU.pzT;
    String str = paramDialogInterface.contact.field_username;
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().Tl(str);
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new d(str, ((dd)localObject).field_msgSvrId));
    paramDialogInterface.isDeleteCancel = false;
    localObject = paramDialogInterface.cmc;
    paramDialogInterface.cmc.getString(2131297087);
    paramDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, paramDialogInterface.cmc.getString(2131297112), true, new c.9(paramDialogInterface));
    bf.a(str, new c.10(paramDialogInterface));
    AppMethodBeat.o(23457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.2.1
 * JD-Core Version:    0.7.0.1
 */