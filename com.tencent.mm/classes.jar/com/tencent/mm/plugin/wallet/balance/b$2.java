package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.k;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)))
    {
      paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
      b.b(this.qfj).putString("kreq_token", paramString.token);
      b.c(this.qfj).putParcelable("key_authen", paramString.qmd);
      paramm = b.d(this.qfj);
      if (!paramString.qmb) {
        bool = true;
      }
      paramm.putBoolean("key_need_verify_sms", bool);
      paramString = paramString.mKP;
      if (paramString != null) {
        b.e(this.qfj).putParcelable("key_realname_guide_helper", paramString);
      }
      a.j(this.gfb, b.f(this.qfj));
      this.gfb.finish();
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    Bankcard localBankcard = (Bankcard)b.g(this.qfj).getParcelable("key_bankcard");
    Object localObject = (String)paramVarArgs[0];
    b.h(this.qfj).putString("key_pwd1", (String)localObject);
    b.i(this.qfj).putString("key_mobile", localBankcard.field_mobile);
    localObject = new Authen();
    ((Authen)localObject).bcw = 3;
    ((Authen)localObject).qsI = ((String)paramVarArgs[0]);
    ((Authen)localObject).mOc = localBankcard.field_bindSerial;
    ((Authen)localObject).mOb = localBankcard.field_bankcardType;
    ((Authen)localObject).nqa = ((PayInfo)b.j(this.qfj).getParcelable("key_pay_info"));
    ((Authen)localObject).qsQ = localBankcard.field_arrive_type;
    this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.a.b((Authen)localObject, (Orders)b.k(this.qfj).getParcelable("key_orders")), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.2
 * JD-Core Version:    0.7.0.1
 */