package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;

public class b
  extends com.tencent.mm.wallet_core.e
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72250);
    if ((paramMMActivity instanceof WalletWXCreditChangeAmountUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72242);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wxcredit.a.e))
            {
              b.a(b.this).putString("kreq_token", ((com.tencent.mm.plugin.wxcredit.a.e)paramAnonymousp).token);
              AppMethodBeat.o(72242);
              return false;
            }
            if ((paramAnonymousp instanceof c))
            {
              b.b(b.this).putDouble("key_credit_amount", ((c)paramAnonymousp).XHw);
              b.this.a(this.activity, 0, b.c(b.this));
              AppMethodBeat.o(72242);
              return true;
            }
          }
          AppMethodBeat.o(72242);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72243);
          paramAnonymousVarArgs = (Bankcard)b.d(b.this).getParcelable("key_bankcard");
          this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.e(paramAnonymousVarArgs.field_bindSerial), true, 1);
          AppMethodBeat.o(72243);
          return true;
        }
      };
      AppMethodBeat.o(72250);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72244);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            b.this.a(this.activity, 0, b.e(b.this));
            this.activity.finish();
            AppMethodBeat.o(72244);
            return true;
          }
          AppMethodBeat.o(72244);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72245);
          b.f(b.this).putString("key_pwd1", (String)paramAnonymousVarArgs[0]);
          this.agTR.a(new x((String)paramAnonymousVarArgs[0], 5, ""), true, 1);
          AppMethodBeat.o(72245);
          return true;
        }
      };
      AppMethodBeat.o(72250);
      return paramMMActivity;
    }
    AppMethodBeat.o(72250);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72246);
    Log.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(72246);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72247);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      b(paramActivity, WalletWXCreditChangeAmountUI.class, paramBundle);
      AppMethodBeat.o(72247);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditChangeAmountUI))
    {
      b(paramActivity, WalletWXCreditChangeAmountResultUI.class, paramBundle);
      AppMethodBeat.o(72247);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditChangeAmountResultUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(72247);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72249);
    g(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
    AppMethodBeat.o(72249);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "WXCreditChangeAmountProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72248);
    Z(paramActivity);
    AppMethodBeat.o(72248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b
 * JD-Core Version:    0.7.0.1
 */