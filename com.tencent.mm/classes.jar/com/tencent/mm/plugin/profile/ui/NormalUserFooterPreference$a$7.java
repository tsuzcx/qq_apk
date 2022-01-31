package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$a$7
  implements DialogInterface.OnClickListener
{
  NormalUserFooterPreference$a$7(NormalUserFooterPreference.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(this.mYE.mYC).field_username });
    this.mYE.isDeleteCancel = true;
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(this.mYE.mYC).field_username);
    paramDialogInterface.addFlags(67108864);
    d.e(this.mYE.mYC.mContext, ".ui.chatting.ChattingUI", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.7
 * JD-Core Version:    0.7.0.1
 */