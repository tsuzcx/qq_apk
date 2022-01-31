package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$a$7
  implements DialogInterface.OnClickListener
{
  NormalUserFooterPreference$a$7(NormalUserFooterPreference.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23681);
    h.qsU.e(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(this.pCf.pCe).field_username });
    this.pCf.isDeleteCancel = true;
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(this.pCf.pCe).field_username);
    paramDialogInterface.addFlags(67108864);
    d.f(this.pCf.pCe.mContext, ".ui.chatting.ChattingUI", paramDialogInterface);
    AppMethodBeat.o(23681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.7
 * JD-Core Version:    0.7.0.1
 */