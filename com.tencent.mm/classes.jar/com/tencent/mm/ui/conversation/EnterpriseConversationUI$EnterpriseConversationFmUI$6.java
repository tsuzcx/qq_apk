package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.profile.b.d;
import com.tencent.mm.ui.base.h;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$6
  implements DialogInterface.OnClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$6(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI, String paramString, Context paramContext) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34423);
    paramDialogInterface = new d(this.euc, true);
    aw.Rc().a(1394, this.AkO);
    aw.Rc().a(paramDialogInterface, 0);
    EnterpriseConversationUI.EnterpriseConversationFmUI localEnterpriseConversationFmUI = this.AkO;
    Context localContext = this.val$context;
    this.val$context.getString(2131297087);
    EnterpriseConversationUI.EnterpriseConversationFmUI.a(localEnterpriseConversationFmUI, h.b(localContext, this.val$context.getString(2131297112), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(34422);
        aw.Rc().a(paramDialogInterface);
        aw.Rc().b(1394, EnterpriseConversationUI.EnterpriseConversationFmUI.6.this.AkO);
        AppMethodBeat.o(34422);
      }
    }));
    AppMethodBeat.o(34423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.6
 * JD-Core Version:    0.7.0.1
 */