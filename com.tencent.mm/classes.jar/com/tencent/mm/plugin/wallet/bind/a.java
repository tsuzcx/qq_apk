package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.pd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a
  extends com.tencent.mm.wallet_core.d
{
  public g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(69060);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        private String fwv = null;
        
        public final boolean A(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69052);
          Object localObject = (Bankcard)a.a(a.this).getParcelable("key_bankcard");
          if ((localObject != null) && (((Bankcard)localObject).field_bankcardState == 1))
          {
            paramAnonymousVarArgs = this.YVX;
            String str = ((Bankcard)localObject).field_bankcardType;
            localObject = ((Bankcard)localObject).field_bindSerial;
            if (a.b(a.this).getInt("scene", -1) == 2) {}
            for (bool = true;; bool = false)
            {
              paramAnonymousVarArgs.a(new com.tencent.mm.plugin.wallet.bind.a.d(str, (String)localObject, bool), true, 1);
              a.c(a.this).putBoolean("key_is_expired_bankcard", true);
              AppMethodBeat.o(69052);
              return true;
            }
          }
          a.this.fKb.putInt("key_process_result_code", 1);
          boolean bool = super.A(paramAnonymousVarArgs);
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
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(69051);
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.wallet.bind.a.d))
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              a.this.fKb.putInt("key_process_result_code", -1);
              if (a.this.c(this.activity, null)) {
                this.YVX.a(new ae(this.fwv, 14), true, 1);
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
            a.this.fKb.putInt("key_process_result_code", 1);
          }
          AppMethodBeat.o(69051);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69053);
          Object localObject = (Bankcard)a.d(a.this).getParcelable("key_bankcard");
          String str1 = (String)paramAnonymousVarArgs[0];
          this.fwv = ((String)paramAnonymousVarArgs[1]);
          if (localObject != null)
          {
            paramAnonymousVarArgs = this.YVX;
            String str2 = ((Bankcard)localObject).field_bankcardType;
            localObject = ((Bankcard)localObject).field_bindSerial;
            if (a.e(a.this).getInt("scene", -1) == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousVarArgs.a(new com.tencent.mm.plugin.wallet.bind.a.d(str2, (String)localObject, str1, bool), true, 1);
              AppMethodBeat.o(69053);
              return true;
            }
          }
          a.this.fKb.putInt("key_process_result_code", 1);
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
  
  public final com.tencent.mm.wallet_core.d a(Activity paramActivity, Bundle paramBundle)
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
    if (this.fKb.getInt("scene", -1) == 1)
    {
      int i = paramBundle.getInt("key_process_result_code", 0);
      a(paramActivity, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", i, false);
      if (i == -1)
      {
        paramActivity = new pd();
        paramActivity.fNX.scene = 2;
        EventCenter.instance.publish(paramActivity);
      }
      AppMethodBeat.o(69059);
      return;
    }
    if (this.fKb.getInt("scene", -1) == 2)
    {
      h(paramActivity, "wallet", ".balance.ui.WalletBalanceManagerUI");
      AppMethodBeat.o(69059);
      return;
    }
    boolean bool = ((b)h.ae(b.class)).a(b.a.vHh, true);
    Log.i("MicroMsg.ProcessManager", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      h(paramActivity, "mall", ".ui.MallIndexUIv2");
      AppMethodBeat.o(69059);
      return;
    }
    h(paramActivity, "mall", ".ui.MallIndexUI");
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
  
  public final String epb()
  {
    return "UnbindProcess";
  }
  
  public final void h(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(69058);
    Q(paramActivity);
    AppMethodBeat.o(69058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a
 * JD-Core Version:    0.7.0.1
 */