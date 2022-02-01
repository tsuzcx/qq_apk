package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.pe;
import com.tencent.mm.f.a.tk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.base.h;

final class ChattingUI$1
  implements Runnable
{
  ChattingUI$1(ChattingUI paramChattingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34692);
    h.c(this.WCP, this.WCP.getString(R.l.notification_need_resend_dialog_prompt), "", this.WCP.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.WCP.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34690);
        paramAnonymousDialogInterface = new tk();
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(34690);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34691);
        paramAnonymousDialogInterface = new pe();
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(34691);
      }
    });
    AppMethodBeat.o(34692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI.1
 * JD-Core Version:    0.7.0.1
 */