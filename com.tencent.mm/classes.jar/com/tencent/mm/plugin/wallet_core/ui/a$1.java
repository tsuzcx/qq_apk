package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(214219);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214218);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
        ((l)g.af(l.class)).eiy().aEE("gh_f0a92aa7146c");
        AppMethodBeat.o(214218);
      }
    });
    a.xV(9);
    AppMethodBeat.o(214219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a.1
 * JD-Core Version:    0.7.0.1
 */