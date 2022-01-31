package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class WcPayCashierDialog$7
  implements a
{
  WcPayCashierDialog$7(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onAuthCancel()
  {
    AppMethodBeat.i(142545);
    WcPayCashierDialog.F(this.uvD);
    WcPayCashierDialog.C(this.uvD).setVisibility(0);
    AppMethodBeat.o(142545);
  }
  
  public final void onAuthFail(int paramInt)
  {
    AppMethodBeat.i(142544);
    ab.i("MicroMsg.WcPayCashierDialog", "face id auth fail: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uvD.mPayInfo.utd) });
    WcPayCashierDialog.F(this.uvD);
    WcPayCashierDialog.C(this.uvD).setVisibility(0);
    WcPayCashierDialog.l(this.uvD);
    WcPayCashierDialog.E(this.uvD).setText(2131305071);
    WcPayCashierDialog.E(this.uvD).setVisibility(0);
    PayInfo localPayInfo = this.uvD.mPayInfo;
    localPayInfo.utd += 1;
    AppMethodBeat.o(142544);
  }
  
  public final void onAuthSuccess(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142543);
    ab.i("MicroMsg.WcPayCashierDialog", "face id auth success");
    if (WcPayCashierDialog.A(this.uvD))
    {
      AppMethodBeat.o(142543);
      return;
    }
    this.uvD.mPayInfo.utc = 1;
    this.uvD.mPayInfo.cwl = "";
    this.uvD.mPayInfo.cwm = "";
    try
    {
      JSONObject localJSONObject = new JSONObject(((l)g.E(l.class)).byW());
      localJSONObject.put("soter_type", t.cTN().cUr());
      this.uvD.mPayInfo.cCf = localJSONObject.toString();
      this.uvD.mPayInfo.cwj = paramInt1;
      this.uvD.mPayInfo.utd = paramInt2;
      WcPayCashierDialog.a(this.uvD, "", this.uvD.tVQ);
      AppMethodBeat.o(142543);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.7
 * JD-Core Version:    0.7.0.1
 */