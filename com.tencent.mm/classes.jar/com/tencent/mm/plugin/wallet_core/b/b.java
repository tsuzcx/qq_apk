package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends a
{
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46476);
    G(new Object[] { "start", paramActivity, paramBundle });
    ab.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      z.id(6, paramBundle.getInt("key_bind_scene"));
      x.RT(paramBundle.getInt("key_bind_scene"));
    }
    while (t.cTN().cUl())
    {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      AppMethodBeat.o(46476);
      return this;
      z.id(6, 0);
      x.RT(0);
    }
    if (paramBundle != null) {
      d.gz(paramBundle.getInt("key_bind_scene", 0), 1);
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_is_import_bind", false)))
    {
      b(paramActivity, WalletCardImportUI.class, paramBundle);
      AppMethodBeat.o(46476);
      return this;
    }
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(46476);
    return paramActivity;
  }
  
  public g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(46478);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new b.1(this, paramMMActivity, parami);
      AppMethodBeat.o(46478);
      return paramMMActivity;
    }
    if (((paramMMActivity instanceof WalletCardElementUI)) || ((paramMMActivity instanceof WalletCardImportUI)))
    {
      paramMMActivity = new b.2(this, paramMMActivity, parami);
      AppMethodBeat.o(46478);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new b.3(this, paramMMActivity, parami);
      AppMethodBeat.o(46478);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new b.4(this, paramMMActivity, parami);
      AppMethodBeat.o(46478);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(46478);
    return paramMMActivity;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(46477);
    G(new Object[] { "forward", paramActivity, Integer.valueOf(paramInt), paramBundle });
    ab.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean("key_is_import_bind", false))
      {
        b(paramActivity, WalletCardImportUI.class, paramBundle);
        AppMethodBeat.o(46477);
        return;
      }
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      AppMethodBeat.o(46477);
      return;
    }
    if (((paramActivity instanceof WalletCardElementUI)) || ((paramActivity instanceof WalletCardImportUI)))
    {
      if (!cWe())
      {
        ab.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(46477);
        return;
      }
      if (!t.cTN().cUl())
      {
        ab.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        AppMethodBeat.o(46477);
        return;
      }
      ab.i("MicroMsg.BindCardProcess", "bind bank card success!!");
      paramBundle.putBoolean("intent_bind_end", true);
      com.tencent.mm.ui.base.h.bO(paramActivity, paramActivity.getString(2131304851));
      b(paramActivity, paramBundle);
      AppMethodBeat.o(46477);
      return;
    }
    BindCardOrder localBindCardOrder;
    String str1;
    String str2;
    String str3;
    int i;
    if (((paramActivity instanceof WalletVerifyCodeUI)) && (t.cTN().cUl()))
    {
      ab.i("MicroMsg.BindCardProcess", "end process after verify!");
      paramInt = this.mEJ.getInt("key_bind_scene", -1);
      localBindCardOrder = (BindCardOrder)this.mEJ.getParcelable("key_bindcard_value_result");
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.mEJ.getString("key_bind_card_type");
        str2 = this.mEJ.getString("key_bind_card_show1");
        str3 = this.mEJ.getString("key_bind_card_show2");
        paramInt = this.mEJ.getInt("key_bind_scene");
        i = this.mEJ.getInt("realname_scene");
        ab.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.poq = str1;
        localBindCardOrder.ugG = str2;
        localBindCardOrder.ugH = str3;
        localBindCardOrder.ugJ = paramInt;
        localBindCardOrder.ugK = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        AppMethodBeat.o(46477);
        return;
      }
      paramBundle.putBoolean("intent_bind_end", true);
      com.tencent.mm.ui.base.h.bO(paramActivity, paramActivity.getString(2131304851));
      b(paramActivity, paramBundle);
      AppMethodBeat.o(46477);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      ab.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
      d.gz(this.mEJ.getInt("key_bind_scene", 0), 7);
      paramBundle.putBoolean("intent_bind_end", true);
      com.tencent.mm.ui.base.h.bO(paramActivity, paramActivity.getString(2131304851));
      localBindCardOrder = (BindCardOrder)this.mEJ.getParcelable("key_bindcard_value_result");
      paramInt = this.mEJ.getInt("key_bind_scene", -1);
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.mEJ.getString("key_bind_card_type");
        str2 = this.mEJ.getString("key_bind_card_show1");
        str3 = this.mEJ.getString("key_bind_card_show2");
        paramInt = this.mEJ.getInt("key_bind_scene");
        i = this.mEJ.getInt("realname_scene");
        ab.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.poq = str1;
        localBindCardOrder.ugG = str2;
        localBindCardOrder.ugH = str3;
        localBindCardOrder.ugJ = paramInt;
        localBindCardOrder.ugK = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        AppMethodBeat.o(46477);
        return;
      }
      b(paramActivity, paramBundle);
      AppMethodBeat.o(46477);
      return;
    }
    if ((paramActivity instanceof WalletBindCardResultUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(46477);
      return;
    }
    ab.i("MicroMsg.BindCardProcess", "super forward!");
    super.a(paramActivity, 0, paramBundle);
    AppMethodBeat.o(46477);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(46479);
    ab.d("MicroMsg.BindCardProcess", "do set user exinfo");
    parami.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.h(this.mEJ.getString("key_country_code", ""), this.mEJ.getString("key_province_code", ""), this.mEJ.getString("key_city_code", ""), (Profession)this.mEJ.getParcelable("key_profession"), this.mEJ.getString("key_country_iso")), false, 1);
    AppMethodBeat.o(46479);
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46480);
    G(new Object[] { "end", paramActivity, paramBundle });
    ab.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
    x.dSs();
    dRS();
    if ((paramBundle != null) && (paramBundle.getBoolean("key_need_bind_response", false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      a(paramActivity, "wallet", ".bind.ui.WalletBindUI", -1, localIntent, false);
      AppMethodBeat.o(46480);
      return;
    }
    d(paramActivity, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(46480);
  }
  
  public String bzC()
  {
    return "BindCardProcess";
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46481);
    if (t.cTN().cUl())
    {
      if (((paramActivity instanceof WalletCardElementUI)) && (cWe()))
      {
        AppMethodBeat.o(46481);
        return true;
      }
      if ((paramActivity instanceof WalletVerifyCodeUI))
      {
        AppMethodBeat.o(46481);
        return true;
      }
      AppMethodBeat.o(46481);
      return false;
    }
    boolean bool = paramActivity instanceof WalletPwdConfirmUI;
    AppMethodBeat.o(46481);
    return bool;
  }
  
  public final int cSV()
  {
    AppMethodBeat.i(142389);
    if (!cWe())
    {
      if (t.cTN().cUl())
      {
        AppMethodBeat.o(142389);
        return 2;
      }
      AppMethodBeat.o(142389);
      return 1;
    }
    if (t.cTN().cUl())
    {
      AppMethodBeat.o(142389);
      return 5;
    }
    AppMethodBeat.o(142389);
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b
 * JD-Core Version:    0.7.0.1
 */