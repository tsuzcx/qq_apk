package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.n;
import org.json.JSONArray;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    AppMethodBeat.i(45201);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)))
    {
      paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
      b.b(this.tLW).putString("kreq_token", paramString.getToken());
      b.c(this.tLW).putParcelable("key_authen", paramString.tVs);
      paramm = b.d(this.tLW);
      if (!paramString.tVq) {
        bool = true;
      }
      paramm.putBoolean("key_need_verify_sms", bool);
      paramm = paramString.plg;
      if (paramm != null) {
        b.e(this.tLW).putParcelable("key_realname_guide_helper", paramm);
      }
      if (paramString.tVz != null) {
        b.f(this.tLW).putString("key_fetch_result_show_info", paramString.tVz.toString());
      }
      a.j(this.hwZ, b.g(this.tLW));
      this.hwZ.finish();
      AppMethodBeat.o(45201);
      return true;
    }
    AppMethodBeat.o(45201);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45202);
    Bankcard localBankcard = (Bankcard)b.h(this.tLW).getParcelable("key_bankcard");
    Object localObject = (String)paramVarArgs[0];
    b.i(this.tLW).putString("key_pwd1", (String)localObject);
    b.j(this.tLW).putString("key_mobile", localBankcard.field_mobile);
    localObject = new Authen();
    ((Authen)localObject).bsY = 3;
    ((Authen)localObject).ueW = ((String)paramVarArgs[0]);
    ((Authen)localObject).por = localBankcard.field_bindSerial;
    ((Authen)localObject).poq = localBankcard.field_bankcardType;
    ((Authen)localObject).pVo = ((PayInfo)b.k(this.tLW).getParcelable("key_pay_info"));
    ((Authen)localObject).ufd = localBankcard.field_arrive_type;
    this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.a.b((Authen)localObject, (Orders)b.l(this.tLW).getParcelable("key_orders")), true, 1);
    AppMethodBeat.o(45202);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.2
 * JD-Core Version:    0.7.0.1
 */