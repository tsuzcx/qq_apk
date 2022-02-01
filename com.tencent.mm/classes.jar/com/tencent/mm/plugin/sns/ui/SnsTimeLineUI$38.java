package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qr;
import com.tencent.mm.autogen.a.va;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.ui.base.k;

final class SnsTimeLineUI$38
  implements Runnable
{
  SnsTimeLineUI$38(SnsTimeLineUI paramSnsTimeLineUI)
  {
    AppMethodBeat.i(176326);
    AppMethodBeat.o(176326);
  }
  
  public final void run()
  {
    AppMethodBeat.i(99317);
    k.b(this.RAo, this.RAo.getString(b.j.notification_need_resend_dialog_prompt), "", this.RAo.getString(b.j.notification_need_resend_dialog_prompt_resend_now), this.RAo.getString(b.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(99307);
        new va().publish();
        AppMethodBeat.o(99307);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(179246);
        new qr().publish();
        AppMethodBeat.o(179246);
      }
    });
    AppMethodBeat.o(99317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.38
 * JD-Core Version:    0.7.0.1
 */