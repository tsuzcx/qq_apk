package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;
import org.json.JSONException;
import org.json.JSONObject;

final class WcPayCashierDialog$6
  implements WcPayCashierFingerprintDialog.b
{
  WcPayCashierDialog$6(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void a(ma.b paramb)
  {
    AppMethodBeat.i(142539);
    ab.i("MicroMsg.WcPayCashierDialog", "verify succeeded: %s", new Object[] { Boolean.valueOf(WcPayCashierDialog.A(this.uvD)) });
    if (WcPayCashierDialog.A(this.uvD))
    {
      AppMethodBeat.o(142539);
      return;
    }
    int i;
    if (this.uvD.mPayInfo == null) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (this.uvD.mPayInfo == null)
      {
        localObject = "";
        ad.e(i, (String)localObject, 22, "");
        this.uvD.mPayInfo.utc = 1;
        this.uvD.mPayInfo.cwl = paramb.cwl;
        this.uvD.mPayInfo.cwm = paramb.cwm;
      }
      try
      {
        localObject = new JSONObject(((l)g.E(l.class)).byW());
        ((JSONObject)localObject).put("soter_type", t.cTN().cUr());
        this.uvD.mPayInfo.cCf = ((JSONObject)localObject).toString();
        this.uvD.mPayInfo.cwj = paramb.cwj;
        this.uvD.mPayInfo.utd = WcPayCashierDialog.B(this.uvD).cWC();
        WcPayCashierDialog.C(this.uvD).setVisibility(0);
        WcPayCashierDialog.D(this.uvD);
        WcPayCashierDialog.a(this.uvD, "", this.uvD.tVQ);
        AppMethodBeat.o(142539);
        return;
        i = this.uvD.mPayInfo.cCD;
        continue;
        localObject = this.uvD.mPayInfo.cnI;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WcPayCashierDialog", localJSONException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void cWA()
  {
    int i = 0;
    AppMethodBeat.i(142541);
    ab.i("MicroMsg.WcPayCashierDialog", "verify canceled");
    WcPayCashierDialog.F(this.uvD);
    WcPayCashierDialog.C(this.uvD).setVisibility(0);
    WcPayCashierDialog.D(this.uvD);
    if (this.uvD.mPayInfo == null) {
      if (this.uvD.mPayInfo != null) {
        break label93;
      }
    }
    label93:
    for (String str = "";; str = this.uvD.mPayInfo.cnI)
    {
      ad.e(i, str, 24, "");
      AppMethodBeat.o(142541);
      return;
      i = this.uvD.mPayInfo.cCD;
      break;
    }
  }
  
  public final void cWB()
  {
    AppMethodBeat.i(142542);
    ab.i("MicroMsg.WcPayCashierDialog", "switch pay way");
    WcPayCashierDialog.F(this.uvD);
    WcPayCashierDialog.C(this.uvD).setVisibility(0);
    WcPayCashierDialog.D(this.uvD);
    WcPayCashierDialog.m(this.uvD);
    AppMethodBeat.o(142542);
  }
  
  public final void cWz()
  {
    int j = 0;
    AppMethodBeat.i(142540);
    ab.i("MicroMsg.WcPayCashierDialog", "verify failed");
    WcPayCashierDialog.l(this.uvD);
    WcPayCashierDialog.E(this.uvD).setText(2131305071);
    WcPayCashierDialog.E(this.uvD).setVisibility(0);
    this.uvD.mPayInfo.utc = 0;
    this.uvD.mPayInfo.utd = WcPayCashierDialog.B(this.uvD).cWC();
    WcPayCashierDialog.C(this.uvD).setVisibility(0);
    WcPayCashierDialog.D(this.uvD);
    int i;
    if (this.uvD.mPayInfo == null)
    {
      i = 0;
      if (this.uvD.mPayInfo != null) {
        break label182;
      }
      str = "";
      label119:
      ad.e(i, str, 23, "");
      if (this.uvD.mPayInfo != null) {
        break label196;
      }
      i = j;
      label140:
      if (this.uvD.mPayInfo != null) {
        break label210;
      }
    }
    label182:
    label196:
    label210:
    for (String str = "";; str = this.uvD.mPayInfo.cnI)
    {
      ad.e(i, str, 25, "");
      AppMethodBeat.o(142540);
      return;
      i = this.uvD.mPayInfo.cCD;
      break;
      str = this.uvD.mPayInfo.cnI;
      break label119;
      i = this.uvD.mPayInfo.cCD;
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.6
 * JD-Core Version:    0.7.0.1
 */