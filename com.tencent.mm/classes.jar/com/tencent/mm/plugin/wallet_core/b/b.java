package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.an;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public a HPw;
  
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
            localObject = this.activity.getString(2131767744);
            AppMethodBeat.o(69865);
            return localObject;
          }
          Object localObject = this.activity.getString(2131767646);
          AppMethodBeat.o(69865);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
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
        Authen HFI;
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(69868);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousq;
              if (paramAnonymousString.HPz == null)
              {
                b.a(b.this).putString("kreq_token", paramAnonymousString.getToken());
                if (b.this.c(this.activity, b.b(b.this)))
                {
                  Log.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                  this.Ruz.b(new ad(null, 12), false);
                }
              }
              for (;;)
              {
                AppMethodBeat.o(69868);
                return true;
                Log.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                b.this.a(this.activity, 0, b.c(b.this));
                continue;
                Log.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                h.c(this.activity, paramAnonymousString.HPz.dQx, "", paramAnonymousString.HPz.IaV, paramAnonymousString.HPz.IaU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69866);
                    Log.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard dialog lOk");
                    b.2.this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(b.2.this.HFI, "1", ""), true, 1);
                    u.xV(1);
                    AppMethodBeat.o(69866);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69867);
                    Log.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                    u.xV(0);
                    AppMethodBeat.o(69867);
                  }
                });
              }
            }
            if ((paramAnonymousq instanceof ad))
            {
              Log.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
              b.this.a(this.activity, 0, b.d(b.this));
              AppMethodBeat.o(69868);
              return true;
            }
          }
          AppMethodBeat.o(69868);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69869);
          b.this.K(new Object[] { "onNext", paramAnonymousVarArgs });
          Log.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
          this.HFI = ((Authen)paramAnonymousVarArgs[0]);
          this.HFI.cSx = b.this.fPO();
          this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.HFI, "", ""), true, 1);
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
          String str = this.activity.getString(2131768356);
          AppMethodBeat.o(69872);
          return str;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(69870);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              Log.i("MicroMsg.BindCardProcess", "verify code success!");
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousq;
              b.e(b.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(69870);
              return true;
            }
            if (!(paramAnonymousq instanceof com.tencent.mm.plugin.wallet_core.c.v)) {
              break label114;
            }
            b.this.a(this.Ruz);
            if (((com.tencent.mm.plugin.wallet_core.c.v)paramAnonymousq).HPA != null) {
              b.f(b.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.c.v)paramAnonymousq).HPA);
            }
          }
          label114:
          while (!(paramAnonymousq instanceof m))
          {
            AppMethodBeat.o(69870);
            return false;
          }
          AppMethodBeat.o(69870);
          return true;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69871);
          b.this.K(new Object[] { "WalletVerifyCodeUI onNext", paramAnonymousVarArgs });
          Log.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
          paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.v)paramAnonymousVarArgs[1];
          if (t.fQI().fRk())
          {
            paramAnonymousVarArgs.flag = "2";
            if (!"realname_verify_process".equals(b.this.dKC())) {
              break label129;
            }
            String str = b.g(b.this).getString("key_realname_sessionid");
            this.Ruz.a(new com.tencent.mm.plugin.wallet_core.c.v(paramAnonymousVarArgs, b.this.dQL.getInt("entry_scene", -1), str), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(69871);
            return true;
            paramAnonymousVarArgs.flag = "1";
            break;
            label129:
            this.Ruz.a(new com.tencent.mm.plugin.wallet_core.c.v(paramAnonymousVarArgs), true, 1);
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(69873);
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.wallet_core.b.a.b))
          {
            b.this.a(this.Ruz);
            if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousq).HPA != null) {
              b.h(b.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousq).HPA);
            }
          }
          while (!(paramAnonymousq instanceof m))
          {
            AppMethodBeat.o(69873);
            return false;
          }
          AppMethodBeat.o(69873);
          return true;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69874);
          paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.v)paramAnonymousVarArgs[0];
          b.i(b.this).getString("verify_card_flag", "0");
          if ("realname_verify_process".equals(b.this.dKC()))
          {
            String str = b.j(b.this).getString("key_realname_sessionid");
            RealNameBundle localRealNameBundle = (RealNameBundle)b.k(b.this).getParcelable("realname_verify_process_bundle");
            this.Ruz.b(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs, b.this.dQL.getInt("entry_scene", -1), str, localRealNameBundle), true);
          }
          for (;;)
          {
            AppMethodBeat.o(69874);
            return false;
            this.Ruz.b(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs), true);
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
    K(new Object[] { "start", paramActivity, paramBundle });
    Log.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
    if (paramBundle != null)
    {
      ab.mg(6, paramBundle.getInt("key_bind_scene"));
      z.aqh(paramBundle.getInt("key_bind_scene"));
      if (!t.fQI().fRk()) {
        break label134;
      }
      boolean bool = paramBundle.getBoolean("key_bind_card_can_pass_pwd", false);
      String str = paramBundle.getString("key_bind_card_user_token", null);
      if ((!bool) || (Util.isNullOrNil(str))) {
        break label123;
      }
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(69875);
      return this;
      ab.mg(6, 0);
      z.aqh(0);
      break;
      label123:
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    label134:
    if (paramBundle != null) {
      f.jV(paramBundle.getInt("key_bind_scene", 0), 1);
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
    K(new Object[] { "forward", paramActivity, Integer.valueOf(paramInt), paramBundle });
    Log.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
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
      if (!fTp())
      {
        Log.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      if (!t.fQI().fRk())
      {
        Log.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      Log.i("MicroMsg.BindCardProcess", "bind bank card success!!");
      paramBundle.putBoolean("intent_bind_end", true);
      h.cD(paramActivity, paramActivity.getString(2131767480));
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    BindCardOrder localBindCardOrder;
    String str1;
    String str2;
    String str3;
    int i;
    if (((paramActivity instanceof WalletVerifyCodeUI)) && (t.fQI().fRk()))
    {
      Log.i("MicroMsg.BindCardProcess", "end process after verify!");
      paramInt = this.dQL.getInt("key_bind_scene", -1);
      localBindCardOrder = (BindCardOrder)this.dQL.getParcelable("key_bindcard_value_result");
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.dQL.getString("key_bind_card_type");
        str2 = this.dQL.getString("key_bind_card_show1");
        str3 = this.dQL.getString("key_bind_card_show2");
        paramInt = this.dQL.getInt("key_bind_scene");
        i = this.dQL.getInt("realname_scene");
        Log.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.dDj = str1;
        localBindCardOrder.HWv = str2;
        localBindCardOrder.HWw = str3;
        localBindCardOrder.HWy = paramInt;
        localBindCardOrder.HWz = i;
        b(paramActivity, WalletBindCardResultUI.class, paramBundle);
        AppMethodBeat.o(69876);
        return;
      }
      paramBundle.putBoolean("intent_bind_end", true);
      h.cD(paramActivity, paramActivity.getString(2131767480));
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69876);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      Log.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
      f.jV(this.dQL.getInt("key_bind_scene", 0), 7);
      paramBundle.putBoolean("intent_bind_end", true);
      h.cD(paramActivity, paramActivity.getString(2131767480));
      localBindCardOrder = (BindCardOrder)this.dQL.getParcelable("key_bindcard_value_result");
      paramInt = this.dQL.getInt("key_bind_scene", -1);
      if ((localBindCardOrder != null) && (paramInt == 15))
      {
        str1 = this.dQL.getString("key_bind_card_type");
        str2 = this.dQL.getString("key_bind_card_show1");
        str3 = this.dQL.getString("key_bind_card_show2");
        paramInt = this.dQL.getInt("key_bind_scene");
        i = this.dQL.getInt("realname_scene");
        Log.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i) });
        localBindCardOrder.dDj = str1;
        localBindCardOrder.HWv = str2;
        localBindCardOrder.HWw = str3;
        localBindCardOrder.HWy = paramInt;
        localBindCardOrder.HWz = i;
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
    Log.i("MicroMsg.BindCardProcess", "super forward!");
    super.a(paramActivity, 0, paramBundle);
    AppMethodBeat.o(69876);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(69878);
    Log.d("MicroMsg.BindCardProcess", "do set user exinfo");
    parami.a(new m(this.dQL.getString("key_country_code", ""), this.dQL.getString("key_province_code", ""), this.dQL.getString("key_city_code", ""), (Profession)this.dQL.getParcelable("key_profession"), this.dQL.getString("key_country_iso")), false, 1);
    AppMethodBeat.o(69878);
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(69879);
    K(new Object[] { "end", paramActivity, paramBundle });
    Log.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
    z.hhs();
    hgM();
    boolean bool = paramBundle.getBoolean("intent_bind_end", false);
    Object localObject = this.dQL;
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
          if (this.HPw != null)
          {
            paramActivity = this.HPw;
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
    if (t.fQI().fRk())
    {
      if (((paramActivity instanceof WalletCardElementUI)) && (fTp()))
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
  
  public String dKC()
  {
    return "BindCardProcess";
  }
  
  public final int fPO()
  {
    AppMethodBeat.i(69881);
    if (!fTp())
    {
      if (t.fQI().fRk())
      {
        AppMethodBeat.o(69881);
        return 2;
      }
      AppMethodBeat.o(69881);
      return 1;
    }
    if (t.fQI().fRk())
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