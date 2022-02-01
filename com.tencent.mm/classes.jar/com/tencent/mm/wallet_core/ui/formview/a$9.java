package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;

final class a$9
  implements View.OnClickListener
{
  a$9(MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73092);
    h.d(this.oXW, this.oXW.getString(2131765149), this.oXW.getString(2131765146), this.oXW.getString(2131765148), this.oXW.getString(2131765150), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(73090);
        e.p(a.9.this.oXW, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
        a.ESL.l(new xb());
        AppMethodBeat.o(73090);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(73091);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(73091);
      }
    });
    AppMethodBeat.o(73092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.9
 * JD-Core Version:    0.7.0.1
 */