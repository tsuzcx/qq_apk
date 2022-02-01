package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

final class SnsTimeLineUI$32
  implements Runnable
{
  SnsTimeLineUI$32(SnsTimeLineUI paramSnsTimeLineUI)
  {
    AppMethodBeat.i(99315);
    AppMethodBeat.o(99315);
  }
  
  public final void run()
  {
    AppMethodBeat.i(179247);
    h.d(this.xHe, this.xHe.getString(2131761704), "", this.xHe.getString(2131761705), this.xHe.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(179245);
        paramAnonymousDialogInterface = new qt();
        a.ESL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(179245);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(179246);
        paramAnonymousDialogInterface = new my();
        a.ESL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(179246);
      }
    });
    AppMethodBeat.o(179247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.32
 * JD-Core Version:    0.7.0.1
 */