package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  private void cRL()
  {
    AppMethodBeat.i(45865);
    ab.i("MicroMsg.PayProcess", "directToNext()");
    boolean bool = this.tVh.mEJ.getBoolean("key_balance_change_phone_need_confirm_phone", false);
    Authen localAuthen = (Authen)this.tVh.mEJ.getParcelable("key_authen");
    Orders localOrders = (Orders)this.tVh.mEJ.getParcelable("key_orders");
    Object localObject = (Bankcard)this.tVh.mEJ.getParcelable("key_bankcard");
    ElementQuery localElementQuery = t.cTV().afh(((Bankcard)localObject).field_bankcardType);
    this.tVh.mEJ.putParcelable("elemt_query", localElementQuery);
    if (!bool)
    {
      localAuthen.ubQ = "";
      localAuthen.poq = ((Bankcard)localObject).field_bankcardType;
      localAuthen.por = ((Bankcard)localObject).field_bindSerial;
      localObject = ((Bankcard)localObject).field_mobile;
      this.tVh.mEJ.putString("key_mobile", (String)localObject);
      if ((localElementQuery == null) || (localElementQuery.uhr) || (localElementQuery.uhs))
      {
        ab.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
        this.tVh.a(this.hwZ, 0, this.tVh.mEJ);
        AppMethodBeat.o(45865);
        return;
      }
      this.AXB.a(a.b(localAuthen, localOrders, this.tVh.mEJ.getBoolean("key_isbalance", false)), true);
      AppMethodBeat.o(45865);
      return;
    }
    localAuthen.poq = ((Bankcard)localObject).field_bankcardType;
    localAuthen.por = ((Bankcard)localObject).field_bindSerial;
    this.tVh.a(this.hwZ, 0, this.tVh.mEJ);
    AppMethodBeat.o(45865);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45863);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.c)))
    {
      ab.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
      this.tVh.a(this.hwZ, 0, this.tVh.mEJ);
      AppMethodBeat.o(45863);
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof w)))
    {
      ab.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
      cRL();
    }
    AppMethodBeat.o(45863);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45864);
    ab.i("MicroMsg.PayProcess", "onNext for select bank card");
    this.tVh.mEJ.putInt("key_err_code", 0);
    paramVarArgs = (Bankcard)this.tVh.mEJ.getParcelable("key_bankcard");
    if (paramVarArgs != null) {
      if (t.cTV().afh(paramVarArgs.field_bankcardType) != null) {
        cRL();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(45864);
      return false;
      this.AXB.a(new w("", "", null), true, 1);
      continue;
      ab.i("MicroMsg.PayProcess", "directToBindNew()");
      this.tVh.mEJ.putInt("key_pay_flag", 2);
      this.tVh.a(this.hwZ, 0, this.tVh.mEJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.2
 * JD-Core Version:    0.7.0.1
 */