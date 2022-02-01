package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.ui.base.h;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama, Context paramContext, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66794);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    h.e(this.val$context, this.val$context.getString(2131762443), this.val$context.getString(2131755873), this.val$context.getString(2131762519), this.val$context.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66793);
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.putExtra("transaction_id", a.3.this.wRY.dmx);
        paramAnonymousDialogInterface.putExtra("receiver_name", a.3.this.wRY.wSF);
        paramAnonymousDialogInterface.putExtra("resend_msg_from_flag", 1);
        d.b(a.3.this.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramAnonymousDialogInterface);
        AppMethodBeat.o(66793);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.3
 * JD-Core Version:    0.7.0.1
 */