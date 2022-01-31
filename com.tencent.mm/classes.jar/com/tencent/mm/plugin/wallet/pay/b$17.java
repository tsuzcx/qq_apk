package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$17
  extends g
{
  b$17(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  private void bTP()
  {
    y.i("MicroMsg.PayProcess", "directToNext()");
    boolean bool = this.qlV.kke.getBoolean("key_balance_change_phone_need_confirm_phone", false);
    Authen localAuthen = (Authen)this.qlV.kke.getParcelable("key_authen");
    Orders localOrders = (Orders)this.qlV.kke.getParcelable("key_orders");
    Object localObject = (Bankcard)this.qlV.kke.getParcelable("key_bankcard");
    ElementQuery localElementQuery = o.bVA().Qp(((Bankcard)localObject).field_bankcardType);
    this.qlV.kke.putParcelable("elemt_query", localElementQuery);
    if (!bool)
    {
      localAuthen.qqU = "";
      localAuthen.mOb = ((Bankcard)localObject).field_bankcardType;
      localAuthen.mOc = ((Bankcard)localObject).field_bindSerial;
      localObject = ((Bankcard)localObject).field_mobile;
      this.qlV.kke.putString("key_mobile", (String)localObject);
      if ((localElementQuery == null) || (localElementQuery.quZ) || (localElementQuery.qva))
      {
        y.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
        this.qlV.a(this.gfb, 0, this.qlV.kke);
        return;
      }
      this.wBd.a(a.b(localAuthen, localOrders, this.qlV.kke.getBoolean("key_isbalance", false)), true);
      return;
    }
    localAuthen.mOb = ((Bankcard)localObject).field_bankcardType;
    localAuthen.mOc = ((Bankcard)localObject).field_bindSerial;
    this.qlV.a(this.gfb, 0, this.qlV.kke);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.c)))
    {
      y.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
      this.qlV.a(this.gfb, 0, this.qlV.kke);
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramInt1 != 0);
        bool1 = bool2;
      } while (paramInt2 != 0);
      bool1 = bool2;
    } while (!(paramm instanceof t));
    y.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
    bTP();
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    y.i("MicroMsg.PayProcess", "onNext for select bank card");
    this.qlV.kke.putInt("key_err_code", 0);
    paramVarArgs = (Bankcard)this.qlV.kke.getParcelable("key_bankcard");
    if (paramVarArgs != null)
    {
      if (o.bVA().Qp(paramVarArgs.field_bankcardType) != null)
      {
        bTP();
        return false;
      }
      this.wBd.a(new t("", "", null), true, 1);
      return false;
    }
    y.i("MicroMsg.PayProcess", "directToBindNew()");
    this.qlV.kke.putInt("key_pay_flag", 2);
    this.qlV.a(this.gfb, 0, this.qlV.kke);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.17
 * JD-Core Version:    0.7.0.1
 */