package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import org.json.JSONException;
import org.json.JSONObject;

final class q$8
  implements Runnable
{
  q$8(q paramq, ma paramma) {}
  
  public final void run()
  {
    AppMethodBeat.i(47600);
    ab.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
    ma.b localb = this.val$fpevent.cCb;
    if (localb == null)
    {
      this.utp.pVo.utc = 0;
      ab.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
      AppMethodBeat.o(47600);
      return;
    }
    int j = localb.errCode;
    ab.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(j), localb.errMsg });
    int i;
    if (j == 0)
    {
      ab.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.cCf });
      if (this.utp.pVo == null) {
        i = 0;
      }
      for (;;)
      {
        Object localObject1;
        if (this.utp.pVo == null)
        {
          localObject1 = "";
          ad.e(i, (String)localObject1, 22, "");
          this.utp.pVo.utc = 1;
          this.utp.pVo.cwl = localb.cwl;
          this.utp.pVo.cwm = localb.cwm;
        }
        try
        {
          localObject1 = new JSONObject(((l)g.E(l.class)).byW());
          ((JSONObject)localObject1).put("soter_type", t.cTN().cUr());
          this.utp.pVo.cCf = ((JSONObject)localObject1).toString();
          this.utp.pVo.cwj = localb.cwj;
          localObject1 = this.utp.pVo;
          ((PayInfo)localObject1).utd += 1;
          this.utp.usV.setText("");
          this.utp.cVU();
          h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
          com.tencent.mm.plugin.soter.d.a.Fu(0);
          AppMethodBeat.o(47600);
          return;
          i = this.utp.pVo.cCD;
          continue;
          localObject1 = this.utp.pVo.cnI;
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
    ab.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
    Object localObject2;
    label434:
    int k;
    boolean bool1;
    if (this.utp.pVo == null)
    {
      i = 0;
      if (this.utp.pVo != null) {
        break label849;
      }
      localObject2 = "";
      ad.e(i, (String)localObject2, 23, "");
      this.utp.pVo.utc = 0;
      this.utp.usU.setVisibility(0);
      this.utp.usV.setTextColor(this.utp.getContext().getResources().getColor(2131690391));
      this.utp.usV.setText(2131305070);
      i = (int)(System.currentTimeMillis() / 1000L);
      k = i - q.g(this.utp);
      if (k > 1)
      {
        q.a(this.utp, i);
        q.h(this.utp);
        localObject2 = this.utp.pVo;
        ((PayInfo)localObject2).utd += 1;
      }
      h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if ((j != 2) && (j != 10308)) {
        break label864;
      }
      bool1 = true;
      label636:
      if (localb.cCg != 2) {
        break label870;
      }
    }
    label849:
    label864:
    label870:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(q.i(this.utp)), Integer.valueOf(j), Boolean.valueOf(bool2) });
      if (((!bool2) && ((q.i(this.utp) >= 3) || (k <= 1))) || (bool1)) {
        break label876;
      }
      ab.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
      if (q.j(this.utp) == null) {
        q.a(this.utp, com.tencent.mm.ui.c.a.eY(this.utp.getContext()));
      }
      this.utp.upK.setVisibility(8);
      this.utp.usV.setVisibility(4);
      q.j(this.utp).reset();
      q.j(this.utp).setAnimationListener(new q.8.1(this));
      this.utp.usV.startAnimation(q.j(this.utp));
      com.tencent.mm.plugin.soter.d.a.Fu(1);
      AppMethodBeat.o(47600);
      return;
      i = this.utp.pVo.cCD;
      break;
      localObject2 = this.utp.pVo.cnI;
      break label434;
      bool1 = false;
      break label636;
    }
    label876:
    if ((q.i(this.utp) >= 3) || (bool1))
    {
      ab.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
      q.cVY();
      this.utp.usW = 0;
      q.k(this.utp);
      this.utp.usT.setVisibility(8);
      this.utp.usU.setVisibility(8);
      this.utp.usV.setVisibility(0);
      this.utp.usV.setText(2131305071);
      this.utp.usV.setTextColor(this.utp.getContext().getResources().getColor(2131690665));
      this.utp.usz.setText(2131305532);
      this.utp.usE.setVisibility(0);
      if (!this.utp.mKBLayout.isShown()) {
        this.utp.mKBLayout.setVisibility(0);
      }
      com.tencent.mm.plugin.soter.d.a.Fu(2);
      q.nR(true);
    }
    AppMethodBeat.o(47600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.8
 * JD-Core Version:    0.7.0.1
 */