package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends a
{
  public com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    A(new Object[] { "start", paramActivity, paramBundle });
    y.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      w.fT(6, paramBundle.getInt("key_bind_scene"));
      v.IX(paramBundle.getInt("key_bind_scene"));
    }
    while (o.bVs().bVN())
    {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      return this;
      w.fT(6, 0);
      v.IX(0);
    }
    if (paramBundle != null) {
      com.tencent.mm.plugin.wallet_core.e.c.ev(paramBundle.getInt("key_bind_scene", 0), 1);
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_is_import_bind", false)))
    {
      b(paramActivity, WalletCardImportUI.class, paramBundle);
      return this;
    }
    return super.a(paramActivity, paramBundle);
  }
  
  public g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new b.1(this, paramMMActivity, parami);
    }
    if (((paramMMActivity instanceof WalletCardElementUI)) || ((paramMMActivity instanceof WalletCardImportUI))) {
      return new b.2(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      return new b.3(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new b.4(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    A(new Object[] { "forward", paramActivity, Integer.valueOf(paramInt), paramBundle });
    y.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean("key_is_import_bind", false))
      {
        b(paramActivity, WalletCardImportUI.class, paramBundle);
        return;
      }
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      return;
    }
    if (((paramActivity instanceof WalletCardElementUI)) || ((paramActivity instanceof WalletCardImportUI)))
    {
      if (!bXd())
      {
        y.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        return;
      }
      if (!o.bVs().bVN())
      {
        y.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        return;
      }
      y.i("MicroMsg.BindCardProcess", "bind bank card success!!");
      paramBundle.putBoolean("intent_bind_end", true);
      com.tencent.mm.ui.base.h.bC(paramActivity, paramActivity.getString(a.i.wallet_bank_card_bind_success_tips));
      b(paramActivity, paramBundle);
      return;
    }
    BindCardOrder localBindCardOrder;
    String str1;
    String str2;
    String str3;
    int i;
    if (((paramActivity instanceof WalletVerifyCodeUI)) && (o.bVs().bVN()))
    {
      y.i("MicroMsg.BindCardProcess", "end process after verify!");
      paramInt = this.kke.getInt("key_bind_scene", -1);
      localBindCardOrder = (BindCardOrder)this.kke.getParcelable("key_bindcard_value_result");
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.kke.getString("key_bind_card_type");
        str2 = this.kke.getString("key_bind_card_show1");
        str3 = this.kke.getString("key_bind_card_show2");
        paramInt = this.kke.getInt("key_bind_scene");
        i = this.kke.getInt("realname_scene");
        y.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.mOb = str1;
        localBindCardOrder.qum = str2;
        localBindCardOrder.qun = str3;
        localBindCardOrder.qup = paramInt;
        localBindCardOrder.quq = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        return;
      }
      b(paramActivity, paramBundle);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      y.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
      com.tencent.mm.plugin.wallet_core.e.c.ev(this.kke.getInt("key_bind_scene", 0), 7);
      paramBundle.putBoolean("intent_bind_end", true);
      com.tencent.mm.ui.base.h.bC(paramActivity, paramActivity.getString(a.i.wallet_bank_card_bind_success_tips));
      localBindCardOrder = (BindCardOrder)this.kke.getParcelable("key_bindcard_value_result");
      paramInt = this.kke.getInt("key_bind_scene", -1);
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.kke.getString("key_bind_card_type");
        str2 = this.kke.getString("key_bind_card_show1");
        str3 = this.kke.getString("key_bind_card_show2");
        paramInt = this.kke.getInt("key_bind_scene");
        i = this.kke.getInt("realname_scene");
        y.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.mOb = str1;
        localBindCardOrder.qum = str2;
        localBindCardOrder.qun = str3;
        localBindCardOrder.qup = paramInt;
        localBindCardOrder.quq = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        return;
      }
      b(paramActivity, paramBundle);
      return;
    }
    if ((paramActivity instanceof WalletBindCardResultUI))
    {
      b(paramActivity, paramBundle);
      return;
    }
    y.i("MicroMsg.BindCardProcess", "super forward!");
    super.a(paramActivity, 0, paramBundle);
  }
  
  public final void a(i parami)
  {
    y.d("MicroMsg.BindCardProcess", "do set user exinfo");
    parami.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.h(this.kke.getString("key_country_code", ""), this.kke.getString("key_province_code", ""), this.kke.getString("key_city_code", ""), (Profession)this.kke.getParcelable("key_profession")), false, 1);
  }
  
  public String aTh()
  {
    return "BindCardProcess";
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    A(new Object[] { "end", paramActivity, paramBundle });
    y.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
    v.cMD();
    cMq();
    if ((paramBundle != null) && (paramBundle.getBoolean("key_need_bind_response", false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      a(paramActivity, "wallet", ".bind.ui.WalletBindUI", -1, localIntent, false);
      return;
    }
    d(paramActivity, "mall", ".ui.MallIndexUI");
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    if (o.bVs().bVN())
    {
      if (((paramActivity instanceof WalletCardElementUI)) && (bXd())) {}
      while ((paramActivity instanceof WalletVerifyCodeUI)) {
        return true;
      }
      return false;
    }
    return paramActivity instanceof WalletPwdConfirmUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b
 * JD-Core Version:    0.7.0.1
 */