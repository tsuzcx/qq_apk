package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.qp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a
  extends e
{
  public g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(69060);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        private String hAT = null;
        
        public final boolean D(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69052);
          Object localObject = (Bankcard)a.a(a.this).getParcelable("key_bankcard");
          if ((localObject != null) && (((Bankcard)localObject).field_bankcardState == 1))
          {
            paramAnonymousVarArgs = this.agTR;
            String str = ((Bankcard)localObject).field_bankcardType;
            localObject = ((Bankcard)localObject).field_bindSerial;
            if (a.b(a.this).getInt("scene", -1) == 2) {}
            for (bool = true;; bool = false)
            {
              paramAnonymousVarArgs.a(new d(str, (String)localObject, bool), true, 1);
              a.c(a.this).putBoolean("key_is_expired_bankcard", true);
              AppMethodBeat.o(69052);
              return true;
            }
          }
          a.this.hPH.putInt("key_process_result_code", 1);
          boolean bool = super.D(paramAnonymousVarArgs);
          AppMethodBeat.o(69052);
          return bool;
        }
        
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69054);
          switch (paramAnonymousInt)
          {
          default: 
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(69054);
            return localObject;
          }
          Object localObject = this.activity.getString(a.i.wallet_index_ui_unbind_bankcard_title);
          AppMethodBeat.o(69054);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(69051);
          if ((paramAnonymousp instanceof d))
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              a.this.hPH.putInt("key_process_result_code", -1);
              if (a.this.c(this.activity, null)) {
                this.agTR.a(new ae(this.hAT, 14), true, 1);
              }
              for (;;)
              {
                AppMethodBeat.o(69051);
                return true;
                a.this.a(this.activity, 0, null);
                if ((this.activity instanceof WalletBaseUI)) {
                  ((WalletBaseUI)this.activity).cleanUiData(0);
                }
                this.activity.finish();
              }
            }
            a.this.hPH.putInt("key_process_result_code", 1);
          }
          AppMethodBeat.o(69051);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69053);
          Object localObject = (Bankcard)a.d(a.this).getParcelable("key_bankcard");
          String str1 = (String)paramAnonymousVarArgs[0];
          this.hAT = ((String)paramAnonymousVarArgs[1]);
          if (localObject != null)
          {
            paramAnonymousVarArgs = this.agTR;
            String str2 = ((Bankcard)localObject).field_bankcardType;
            localObject = ((Bankcard)localObject).field_bindSerial;
            if (a.e(a.this).getInt("scene", -1) == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousVarArgs.a(new d(str2, (String)localObject, str1, bool), true, 1);
              AppMethodBeat.o(69053);
              return true;
            }
          }
          a.this.hPH.putInt("key_process_result_code", 1);
          AppMethodBeat.o(69053);
          return false;
        }
      };
      AppMethodBeat.o(69060);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(69060);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69055);
    Log.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
    if (paramBundle.getBoolean("key_is_show_detail", true)) {
      e(paramActivity, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(69055);
      return this;
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69057);
    if ((paramActivity instanceof WalletBankcardDetailUI))
    {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      AppMethodBeat.o(69057);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(69057);
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69059);
    if (this.hPH.getInt("scene", -1) == 1)
    {
      int i = paramBundle.getInt("key_process_result_code", 0);
      a(paramActivity, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", i, false);
      if (i == -1)
      {
        paramActivity = new qp();
        paramActivity.hTP.scene = 2;
        paramActivity.publish();
      }
      AppMethodBeat.o(69059);
      return;
    }
    if (this.hPH.getInt("scene", -1) == 2)
    {
      g(paramActivity, "wallet", ".balance.ui.WalletBalanceManagerUI");
      AppMethodBeat.o(69059);
      return;
    }
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXg, true);
    Log.i("MicroMsg.ProcessManager", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      g(paramActivity, "mall", ".ui.MallIndexUIv2");
      AppMethodBeat.o(69059);
      return;
    }
    g(paramActivity, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(69059);
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return (paramActivity instanceof WalletCheckPwdUI);
  }
  
  protected void e(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69056);
    b(paramActivity, WalletBankcardDetailUI.class, paramBundle);
    AppMethodBeat.o(69056);
  }
  
  public final String fud()
  {
    return "UnbindProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(69058);
    Z(paramActivity);
    AppMethodBeat.o(69058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a
 * JD-Core Version:    0.7.0.1
 */