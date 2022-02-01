package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

final class p$9
  implements Runnable
{
  p$9(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(38733);
    h.d(this.IGv.dgE, this.IGv.dgE.getString(2131761704), "", this.IGv.dgE.getString(2131761705), this.IGv.dgE.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38731);
        paramAnonymousDialogInterface = new rb();
        a.GpY.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(38731);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38732);
        paramAnonymousDialogInterface = new ng();
        a.GpY.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(38732);
      }
    });
    AppMethodBeat.o(38733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.9
 * JD-Core Version:    0.7.0.1
 */