package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.hellhoundlib.b.b;
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
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    h.e(this.qeM, this.qeM.getString(2131765149), this.qeM.getString(2131765146), this.qeM.getString(2131765148), this.qeM.getString(2131765150), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(73090);
        e.o(a.9.this.qeM, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
        com.tencent.mm.sdk.b.a.IbL.l(new yg());
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
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(73092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.9
 * JD-Core Version:    0.7.0.1
 */