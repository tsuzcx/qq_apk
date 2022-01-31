package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.ui.base.h;

final class EnterpriseConversationUI$a$6
  implements DialogInterface.OnClickListener
{
  EnterpriseConversationUI$a$6(EnterpriseConversationUI.a parama, String paramString, Context paramContext) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new c(this.dAA, true);
    au.Dk().a(1394, this.vSW);
    au.Dk().a(paramDialogInterface, 0);
    EnterpriseConversationUI.a locala = this.vSW;
    Context localContext = this.val$context;
    this.val$context.getString(R.l.app_tip);
    EnterpriseConversationUI.a.a(locala, h.b(localContext, this.val$context.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        au.Dk().c(paramDialogInterface);
        au.Dk().b(1394, EnterpriseConversationUI.a.6.this.vSW);
      }
    }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.6
 * JD-Core Version:    0.7.0.1
 */