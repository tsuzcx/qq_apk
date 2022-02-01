package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends a
{
  public a zVP;
  
  public g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(69877);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69865);
          switch (paramAnonymousInt)
          {
          default: 
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(69865);
            return localObject;
          case 1: 
            localObject = this.activity.getString(2131765301);
            AppMethodBeat.o(69865);
            return localObject;
          }
          Object localObject = this.activity.getString(2131765203);
          AppMethodBeat.o(69865);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(69877);
      return paramMMActivity;
    }
    if (((paramMMActivity instanceof WalletCardElementUI)) || ((paramMMActivity instanceof WalletCardImportUI)))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        Authen zPG;
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69868);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousn;
              if (paramAnonymousString.zVS == null)
              {
                b.a(b.this).putString("kreq_token", paramAnonymousString.getToken());
                if (b.this.c(this.activity, b.b(b.this)))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                  this.Ieo.b(new com.tencent.mm.plugin.wallet_core.c.ad(null, 12), false);
                }
              }
              for (;;)
              {
                AppMethodBeat.o(69868);
                return true;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                b.this.a(this.activity, 0, b.c(b.this));
                continue;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                h.d(this.activity, paramAnonymousString.zVS.doh, "", paramAnonymousString.zVS.Ahr, paramAnonymousString.zVS.Ahq, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69866);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard dialog lOk");
                    b.2.this.Ieo.a(new com.tencent.mm.plugin.wallet_core.b.a.a(b.2.this.zPG, "1", ""), true, 1);
                    t.sw(1);
                    AppMethodBeat.o(69866);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69867);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                    t.sw(0);
                    AppMethodBeat.o(69867);
                  }
                });
              }
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
              b.this.a(this.activity, 0, b.d(b.this));
              AppMethodBeat.o(69868);
              return true;
            }
          }
          AppMethodBeat.o(69868);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69869);
          b.this.H(new Object[] { "onNext", paramAnonymousVarArgs });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
          this.zPG = ((Authen)paramAnonymousVarArgs[0]);
          this.zPG.dtM = b.this.ebi();
          this.Ieo.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.zPG, "", ""), true, 1);
          AppMethodBeat.o(69869);
          return true;
        }
      };
      AppMethodBeat.o(69877);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69872);
          String str = this.activity.getString(2131765903);
          AppMethodBeat.o(69872);
          return str;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69870);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "verify code success!");
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousn;
              b.e(b.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(69870);
              return true;
            }
            if (!(paramAnonymousn instanceof v)) {
              break label114;
            }
            b.this.a(this.Ieo);
            if (((v)paramAnonymousn).zVT != null) {
              b.f(b.this).putParcelable("key_bindcard_value_result", ((v)paramAnonymousn).zVT);
            }
          }
          label114:
          while (!(paramAnonymousn instanceof m))
          {
            AppMethodBeat.o(69870);
            return false;
          }
          AppMethodBeat.o(69870);
          return true;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69871);
          b.this.H(new Object[] { "WalletVerifyCodeUI onNext", paramAnonymousVarArgs });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          if (s.ecc().ecF())
          {
            paramAnonymousVarArgs.flag = "2";
            if (!"realname_verify_process".equals(b.this.cuB())) {
              break label129;
            }
            String str = b.g(b.this).getString("key_realname_sessionid");
            this.Ieo.a(new v(paramAnonymousVarArgs, b.this.dow.getInt("entry_scene", -1), str), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(69871);
            return true;
            paramAnonymousVarArgs.flag = "1";
            break;
            label129:
            this.Ieo.a(new v(paramAnonymousVarArgs), true, 1);
          }
        }
      };
      AppMethodBeat.o(69877);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69873);
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.b.a.b))
          {
            b.this.a(this.Ieo);
            if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).zVT != null) {
              b.h(b.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).zVT);
            }
          }
          while (!(paramAnonymousn instanceof m))
          {
            AppMethodBeat.o(69873);
            return false;
          }
          AppMethodBeat.o(69873);
          return true;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69874);
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[0];
          b.i(b.this).getString("verify_card_flag", "0");
          if ("realname_verify_process".equals(b.this.cuB()))
          {
            String str = b.j(b.this).getString("key_realname_sessionid");
            RealNameBundle localRealNameBundle = (RealNameBundle)b.k(b.this).getParcelable("realname_verify_process_bundle");
            this.Ieo.b(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs, b.this.dow.getInt("entry_scene", -1), str, localRealNameBundle), true);
          }
          for (;;)
          {
            AppMethodBeat.o(69874);
            return false;
            this.Ieo.b(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs), true);
          }
        }
      };
      AppMethodBeat.o(69877);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(69877);
    return paramMMActivity;
  }
  
  public d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69875);
    H(new Object[] { "start", paramActivity, paramBundle });
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      ab.jZ(6, paramBundle.getInt("key_bind_scene"));
      z.abt(paramBundle.getInt("key_bind_scene"));
      if (!s.ecc().ecF()) {
        break label134;
      }
      boolean bool = paramBundle.getBoolean("key_bind_card_can_pass_pwd", false);
      String str = paramBundle.getString("key_bind_card_user_token", null);
      if ((!bool) || (bt.isNullOrNil(str))) {
        break label123;
      }
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(69875);
      return this;
      ab.jZ(6, 0);
      z.abt(0);
      break;
      label123:
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    label134:
    if (paramBundle != null) {
      f.ij(paramBundle.getInt("key_bind_scene", 0), 1);
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_is_import_bind", false)))
    {
      b(paramActivity, WalletCardImportUI.class, paramBundle);
      AppMethodBeat.o(69875);
      return this;
    }
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(69875);
    return paramActivity;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69876);
    H(new Object[] { "forward", paramActivity, Integer.valueOf(paramInt), paramBundle });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean("key_is_import_bind", false))
      {
        b(paramActivity, WalletCardImportUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    if (((paramActivity instanceof WalletCardElementUI)) || ((paramActivity instanceof WalletCardImportUI)))
    {
      if (!eez())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      if (!s.ecc().ecF())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "bind bank card success!!");
      paramBundle.putBoolean("intent_bind_end", true);
      h.cf(paramActivity, paramActivity.getString(2131765037));
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    BindCardOrder localBindCardOrder;
    String str1;
    String str2;
    String str3;
    int i;
    if (((paramActivity instanceof WalletVerifyCodeUI)) && (s.ecc().ecF()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "end process after verify!");
      paramInt = this.dow.getInt("key_bind_scene", -1);
      localBindCardOrder = (BindCardOrder)this.dow.getParcelable("key_bindcard_value_result");
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.dow.getString("key_bind_card_type");
        str2 = this.dow.getString("key_bind_card_show1");
        str3 = this.dow.getString("key_bind_card_show2");
        paramInt = this.dow.getInt("key_bind_scene");
        i = this.dow.getInt("realname_scene");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.dca = str1;
        localBindCardOrder.AcO = str2;
        localBindCardOrder.AcP = str3;
        localBindCardOrder.AcR = paramInt;
        localBindCardOrder.AcS = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      paramBundle.putBoolean("intent_bind_end", true);
      h.cf(paramActivity, paramActivity.getString(2131765037));
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
      f.ij(this.dow.getInt("key_bind_scene", 0), 7);
      paramBundle.putBoolean("intent_bind_end", true);
      h.cf(paramActivity, paramActivity.getString(2131765037));
      localBindCardOrder = (BindCardOrder)this.dow.getParcelable("key_bindcard_value_result");
      paramInt = this.dow.getInt("key_bind_scene", -1);
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.dow.getString("key_bind_card_type");
        str2 = this.dow.getString("key_bind_card_show1");
        str3 = this.dow.getString("key_bind_card_show2");
        paramInt = this.dow.getInt("key_bind_scene");
        i = this.dow.getInt("realname_scene");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.dca = str1;
        localBindCardOrder.AcO = str2;
        localBindCardOrder.AcP = str3;
        localBindCardOrder.AcR = paramInt;
        localBindCardOrder.AcS = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    if ((paramActivity instanceof WalletBindCardResultUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "super forward!");
    super.a(paramActivity, 0, paramBundle);
    AppMethodBeat.o(69876);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(69878);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BindCardProcess", "do set user exinfo");
    parami.a(new m(this.dow.getString("key_country_code", ""), this.dow.getString("key_province_code", ""), this.dow.getString("key_city_code", ""), (Profession)this.dow.getParcelable("key_profession"), this.dow.getString("key_country_iso")), false, 1);
    AppMethodBeat.o(69878);
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(69879);
    H(new Object[] { "end", paramActivity, paramBundle });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
    z.fjZ();
    fju();
    boolean bool = paramBundle.getBoolean("intent_bind_end", false);
    Object localObject = this.dow;
    Intent localIntent;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("is_from_new_cashier", false)))
    {
      localObject = ((Bundle)localObject).getString("start_activity_class", "");
      try
      {
        localObject = Class.forName((String)localObject);
        if (localObject != null)
        {
          c(paramActivity, (Class)localObject);
          if (this.zVP != null)
          {
            paramActivity = this.zVP;
            if (bool == true) {
              paramActivity.run(i);
            }
          }
          else
          {
            AppMethodBeat.o(69879);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localIntent = null;
          continue;
          i = 0;
        }
      }
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_need_bind_response", false)))
    {
      localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      a(paramActivity, "wallet", ".bind.ui.WalletBindUI", -1, localIntent, false);
      AppMethodBeat.o(69879);
      return;
    }
    e(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
    AppMethodBeat.o(69879);
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69880);
    if (s.ecc().ecF())
    {
      if (((paramActivity instanceof WalletCardElementUI)) && (eez()))
      {
        AppMethodBeat.o(69880);
        return true;
      }
      if ((paramActivity instanceof WalletVerifyCodeUI))
      {
        AppMethodBeat.o(69880);
        return true;
      }
      AppMethodBeat.o(69880);
      return false;
    }
    boolean bool = paramActivity instanceof WalletPwdConfirmUI;
    AppMethodBeat.o(69880);
    return bool;
  }
  
  public String cuB()
  {
    return "BindCardProcess";
  }
  
  public final int ebi()
  {
    AppMethodBeat.i(69881);
    if (!eez())
    {
      if (s.ecc().ecF())
      {
        AppMethodBeat.o(69881);
        return 2;
      }
      AppMethodBeat.o(69881);
      return 1;
    }
    if (s.ecc().ecF())
    {
      AppMethodBeat.o(69881);
      return 5;
    }
    AppMethodBeat.o(69881);
    return 4;
  }
  
  public static abstract interface a
  {
    public abstract void run(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b
 * JD-Core Version:    0.7.0.1
 */