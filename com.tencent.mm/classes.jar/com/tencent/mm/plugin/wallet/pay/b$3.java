package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$3
  extends b.a
{
  b$3(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      y.i("MicroMsg.PayProcess", "finish auth");
      paramString = ((com.tencent.mm.plugin.wallet.pay.a.a.b)paramm).qmd;
      Orders localOrders = ((com.tencent.mm.plugin.wallet.pay.a.a.b)paramm).qmc;
      this.qlV.kke.putParcelable("key_authen", paramString);
      this.qlV.kke.putParcelable("key_orders", localOrders);
      this.qlV.kke.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pay.a.a.b)paramm).token);
      this.qlV.kke.putBoolean("key_is_return_from_switch_phone", true);
      this.qlV.kke.putInt("key_err_code", 0);
      paramm = (Bankcard)this.qlV.kke.getParcelable("key_bankcard");
      paramm.field_bankcardType = paramString.mOb;
      paramm.field_bindSerial = paramString.mOc;
      this.qlV.a(this.gfb, 0, this.qlV.kke);
      this.qlV.E(this.gfb);
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    y.i("MicroMsg.PayProcess", "start do authen");
    paramVarArgs = (ft)paramVarArgs[0];
    Authen localAuthen = (Authen)this.qlV.kke.getParcelable("key_authen");
    Object localObject = new Bankcard();
    ((Bankcard)localObject).field_bindSerial = paramVarArgs.mOc;
    ((Bankcard)localObject).field_mobile = paramVarArgs.qqU;
    ((Bankcard)localObject).field_desc = paramVarArgs.lnT;
    ((Bankcard)localObject).field_bankcardType = localAuthen.mOb;
    y.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", new Object[] { localAuthen.mOb, paramVarArgs.mOc, localAuthen.mOc });
    this.qlV.kke.putString("key_mobile", ((Bankcard)localObject).field_mobile);
    this.qlV.kke.putParcelable("key_bankcard", (Parcelable)localObject);
    localObject = (Orders)this.qlV.kke.getParcelable("key_orders");
    localAuthen.qsV = paramVarArgs.szN;
    localAuthen.qsW = paramVarArgs.mOc;
    localAuthen.qsX = paramVarArgs.mOb;
    localAuthen.qsY = "1";
    paramVarArgs = a.a(localAuthen, (Orders)localObject, false);
    if (paramVarArgs != null) {
      this.wBd.a(paramVarArgs, true, 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.3
 * JD-Core Version:    0.7.0.1
 */