package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.pe;
import com.tencent.mm.f.a.tk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.base.h;

final class q$9
  implements Runnable
{
  q$9(q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(38733);
    h.c(this.XEn.fDf, this.XEn.fDf.getString(R.l.notification_need_resend_dialog_prompt), "", this.XEn.fDf.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.XEn.fDf.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38731);
        paramAnonymousDialogInterface = new tk();
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(38731);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38732);
        paramAnonymousDialogInterface = new pe();
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(38732);
      }
    });
    AppMethodBeat.o(38733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.q.9
 * JD-Core Version:    0.7.0.1
 */