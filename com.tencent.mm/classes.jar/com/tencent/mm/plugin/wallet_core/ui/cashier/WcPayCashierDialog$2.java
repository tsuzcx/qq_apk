package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WcPayCashierDialog$2
  implements View.OnClickListener
{
  WcPayCashierDialog$2(WcPayCashierDialog paramWcPayCashierDialog, dlu paramdlu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71337);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    ad.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { this.Dlk.FsR.url });
    if ((this.Dlk.FsR.type == 13) && (this.Dlk.FsR.Hoy != null) && ("fetchfavordialog".equals(this.Dlk.FsR.url)))
    {
      paramView = new b(WcPayCashierDialog.n(this.Dlj));
      if ((this.Dlk.FsR.Hoy.GbO.size() > 0) && (((dwa)this.Dlk.FsR.Hoy.GbO.get(0)).HIw != null))
      {
        localObject1 = ((dwa)this.Dlk.FsR.Hoy.GbO.get(0)).HIw.GKG;
        Object localObject2 = this.Dlk.FsR.Hoy.GbM.FsP;
        if (localObject2 != null) {
          g.a(paramView.lCL, (dmo)localObject2, null);
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (dlu)((Iterator)localObject1).next();
            View localView = View.inflate(paramView.getContext(), 2131496056, null);
            TextView localTextView1 = (TextView)localView.findViewById(2131307058);
            TextView localTextView2 = (TextView)localView.findViewById(2131307056);
            if ((((dlu)localObject2).HAk != null) && (((dlu)localObject2).HAk.size() > 0))
            {
              g.a(localTextView1, (dmo)((dlu)localObject2).HAk.get(0), null);
              if (((dlu)localObject2).HAk.size() >= 2) {
                g.a(localTextView2, (dmo)((dlu)localObject2).HAk.get(1), null);
              }
            }
            paramView.Dlr.addView(localView);
          }
        }
      }
      paramView.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71336);
          WcPayCashierDialog.2.this.Dlj.show();
          AppMethodBeat.o(71336);
        }
      });
      paramView.show();
      this.Dlj.hide();
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.2
 * JD-Core Version:    0.7.0.1
 */