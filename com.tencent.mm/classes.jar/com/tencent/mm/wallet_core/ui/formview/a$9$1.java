package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.wallet_core.ui.e;

final class a$9$1
  implements DialogInterface.OnClickListener
{
  a$9$1(a.9 param9) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49364);
    e.m(this.AYQ.lHl, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
    a.ymk.l(new vb());
    AppMethodBeat.o(49364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.9.1
 * JD-Core Version:    0.7.0.1
 */