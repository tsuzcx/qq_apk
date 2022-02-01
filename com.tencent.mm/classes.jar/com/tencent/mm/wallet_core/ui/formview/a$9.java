package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aay;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.g;

final class a$9
  implements View.OnClickListener
{
  a$9(MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73092);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    h.c(this.vhU, this.vhU.getString(a.i.wallet_card_name_illustraction_new_detail), this.vhU.getString(a.i.wallet_card_name_illustraction), this.vhU.getString(a.i.wallet_card_name_illustraction_new_chnage_name), this.vhU.getString(a.i.wallet_card_name_illustraction_new_i_know), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(73090);
        g.p(a.9.this.vhU, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
        EventCenter.instance.publish(new aay());
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
    a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(73092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.9
 * JD-Core Version:    0.7.0.1
 */