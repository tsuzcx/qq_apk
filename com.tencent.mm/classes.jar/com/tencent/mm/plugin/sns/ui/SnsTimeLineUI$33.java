package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

final class SnsTimeLineUI$33
  implements Runnable
{
  SnsTimeLineUI$33(SnsTimeLineUI paramSnsTimeLineUI)
  {
    AppMethodBeat.i(176326);
    AppMethodBeat.o(176326);
  }
  
  public final void run()
  {
    AppMethodBeat.i(99317);
    h.e(this.ACN, this.ACN.getString(2131761704), "", this.ACN.getString(2131761705), this.ACN.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(99307);
        paramAnonymousDialogInterface = new ro();
        a.IvT.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(99307);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(99308);
        paramAnonymousDialogInterface = new nq();
        a.IvT.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(99308);
      }
    });
    AppMethodBeat.o(99317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.33
 * JD-Core Version:    0.7.0.1
 */