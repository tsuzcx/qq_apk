package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WcPayCashierDialog$2
  implements View.OnClickListener
{
  WcPayCashierDialog$2(WcPayCashierDialog paramWcPayCashierDialog, dgh paramdgh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71337);
    ac.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { this.BKS.DNL.url });
    if ((this.BKS.DNL.type == 13) && (this.BKS.DNL.FEj != null) && ("fetchfavordialog".equals(this.BKS.DNL.url)))
    {
      paramView = new b(WcPayCashierDialog.n(this.BKR));
      if ((this.BKS.DNL.FEj.Euu.size() > 0) && (((dqi)this.BKS.DNL.FEj.Euu.get(0)).FXH != null))
      {
        Object localObject1 = ((dqi)this.BKS.DNL.FEj.Euu.get(0)).FXH.Fbh;
        Object localObject2 = this.BKS.DNL.FEj.Eus.DNJ;
        if (localObject2 != null) {
          g.a(paramView.lfN, (dhb)localObject2, null);
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (dgh)((Iterator)localObject1).next();
            View localView = View.inflate(paramView.getContext(), 2131496056, null);
            TextView localTextView1 = (TextView)localView.findViewById(2131307058);
            TextView localTextView2 = (TextView)localView.findViewById(2131307056);
            if ((((dgh)localObject2).FPF != null) && (((dgh)localObject2).FPF.size() > 0))
            {
              g.a(localTextView1, (dhb)((dgh)localObject2).FPF.get(0), null);
              if (((dgh)localObject2).FPF.size() >= 2) {
                g.a(localTextView2, (dhb)((dgh)localObject2).FPF.get(1), null);
              }
            }
            paramView.BKZ.addView(localView);
          }
        }
      }
      paramView.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71336);
          WcPayCashierDialog.2.this.BKR.show();
          AppMethodBeat.o(71336);
        }
      });
      paramView.show();
      this.BKR.hide();
    }
    AppMethodBeat.o(71337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.2
 * JD-Core Version:    0.7.0.1
 */