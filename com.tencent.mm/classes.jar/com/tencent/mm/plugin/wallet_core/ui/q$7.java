package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
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

final class q$7
  implements a
{
  q$7(q paramq) {}
  
  public final void onAuthCancel()
  {
    AppMethodBeat.i(47595);
    this.utp.iCk.setVisibility(0);
    AppMethodBeat.o(47595);
  }
  
  public final void onAuthFail(int paramInt)
  {
    AppMethodBeat.i(47594);
    ab.i("MicroMsg.WalletPwdDialog", "face id auth fail: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.utp.pVo.utd) });
    this.utp.iCk.setVisibility(0);
    this.utp.usT.setVisibility(8);
    q.d(this.utp);
    PayInfo localPayInfo = this.utp.pVo;
    localPayInfo.utd += 1;
    AppMethodBeat.o(47594);
  }
  
  public final void onAuthSuccess(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47593);
    ab.i("MicroMsg.WalletPwdDialog", "face id auth success");
    this.utp.pVo.utc = 1;
    this.utp.pVo.cwl = "";
    this.utp.pVo.cwm = "";
    try
    {
      JSONObject localJSONObject = new JSONObject(((l)g.E(l.class)).byW());
      localJSONObject.put("soter_type", t.cTN().cUr());
      this.utp.pVo.cCf = localJSONObject.toString();
      this.utp.pVo.cwj = paramInt1;
      this.utp.pVo.utd = paramInt2;
      this.utp.cVU();
      AppMethodBeat.o(47593);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletPwdDialog", localJSONException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.7
 * JD-Core Version:    0.7.0.1
 */