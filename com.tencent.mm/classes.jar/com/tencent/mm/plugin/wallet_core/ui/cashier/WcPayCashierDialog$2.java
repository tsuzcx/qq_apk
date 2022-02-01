package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WcPayCashierDialog$2
  implements View.OnClickListener
{
  WcPayCashierDialog$2(WcPayCashierDialog paramWcPayCashierDialog, dav paramdav) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71337);
    ad.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { this.Asy.Cvq.url });
    if ((this.Asy.Cvq.type == 13) && (this.Asy.Cvq.Ehk != null) && ("fetchfavordialog".equals(this.Asy.Cvq.url)))
    {
      paramView = new b(WcPayCashierDialog.n(this.Asx));
      if ((this.Asy.Cvq.Ehk.Dbr.size() > 0) && (((dkr)this.Asy.Cvq.Ehk.Dbr.get(0)).EAt != null))
      {
        Object localObject1 = ((dkr)this.Asy.Cvq.Ehk.Dbr.get(0)).EAt.DFN;
        Object localObject2 = this.Asy.Cvq.Ehk.Dbp.Cvo;
        if (localObject2 != null) {
          g.a(paramView.kEu, (dbp)localObject2, null);
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (dav)((Iterator)localObject1).next();
            View localView = View.inflate(paramView.getContext(), 2131496056, null);
            TextView localTextView1 = (TextView)localView.findViewById(2131307058);
            TextView localTextView2 = (TextView)localView.findViewById(2131307056);
            if ((((dav)localObject2).EsD != null) && (((dav)localObject2).EsD.size() > 0))
            {
              g.a(localTextView1, (dbp)((dav)localObject2).EsD.get(0), null);
              if (((dav)localObject2).EsD.size() >= 2) {
                g.a(localTextView2, (dbp)((dav)localObject2).EsD.get(1), null);
              }
            }
            paramView.AsF.addView(localView);
          }
        }
      }
      paramView.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71336);
          WcPayCashierDialog.2.this.Asx.show();
          AppMethodBeat.o(71336);
        }
      });
      paramView.show();
      this.Asx.hide();
    }
    AppMethodBeat.o(71337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.2
 * JD-Core Version:    0.7.0.1
 */