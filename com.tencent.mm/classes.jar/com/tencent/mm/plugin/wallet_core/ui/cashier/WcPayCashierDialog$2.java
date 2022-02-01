package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.fbm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WcPayCashierDialog$2
  implements View.OnClickListener
{
  WcPayCashierDialog$2(WcPayCashierDialog paramWcPayCashierDialog, eqh parameqh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71337);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    Log.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { this.Pes.RGh.url });
    if ((this.Pes.RGh.type == 13) && (this.Pes.RGh.Uft != null) && ("fetchfavordialog".equals(this.Pes.RGh.url)))
    {
      paramView = new b(WcPayCashierDialog.n(this.Per));
      if ((this.Pes.RGh.Uft.Sru.size() > 0) && (((fbm)this.Pes.RGh.Uft.Sru.get(0)).UBD != null))
      {
        localObject1 = ((fbm)this.Pes.RGh.Uft.Sru.get(0)).UBD.Tue;
        Object localObject2 = this.Pes.RGh.Uft.Srs.RGf;
        if (localObject2 != null) {
          k.a(paramView.pPT, (erh)localObject2, null);
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (eqh)((Iterator)localObject1).next();
            View localView = View.inflate(paramView.getContext(), a.g.wc_pay_cashier_fetch_favor_cell_item, null);
            TextView localTextView1 = (TextView)localView.findViewById(a.f.wpfc_title_tv);
            TextView localTextView2 = (TextView)localView.findViewById(a.f.wpfc_desc_tv);
            if ((((eqh)localObject2).UsK != null) && (((eqh)localObject2).UsK.size() > 0))
            {
              k.a(localTextView1, (erh)((eqh)localObject2).UsK.get(0), null);
              if (((eqh)localObject2).UsK.size() >= 2) {
                k.a(localTextView2, (erh)((eqh)localObject2).UsK.get(1), null);
              }
            }
            paramView.Pez.addView(localView);
          }
        }
      }
      paramView.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71336);
          WcPayCashierDialog.2.this.Per.show();
          AppMethodBeat.o(71336);
        }
      });
      paramView.show();
      this.Per.hide();
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.2
 * JD-Core Version:    0.7.0.1
 */