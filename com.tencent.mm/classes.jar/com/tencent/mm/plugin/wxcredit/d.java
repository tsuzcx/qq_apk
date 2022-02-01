package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;

public class d
  extends e
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72266);
    if ((paramMMActivity instanceof WalletWXCreditDetailUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean D(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72258);
          paramAnonymousVarArgs = (Bankcard)paramAnonymousVarArgs[0];
          this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.d(paramAnonymousVarArgs.field_bindSerial, paramAnonymousVarArgs.field_bankcardType), true, 1);
          AppMethodBeat.o(72258);
          return true;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(72266);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean D(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72261);
          paramAnonymousVarArgs = (Bankcard)paramAnonymousVarArgs[0];
          this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.d(paramAnonymousVarArgs.field_bindSerial, paramAnonymousVarArgs.field_bankcardType), true, 1);
          AppMethodBeat.o(72261);
          return true;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72259);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof f)) {
              this.agTR.b(new ae(), true);
            }
            for (;;)
            {
              AppMethodBeat.o(72259);
              return true;
              if ((paramAnonymousp instanceof ae)) {
                d.this.b(this.activity, d.a(d.this));
              }
            }
          }
          AppMethodBeat.o(72259);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72260);
          Bankcard localBankcard = (Bankcard)d.b(d.this).getParcelable("key_bankcard");
          this.agTR.a(new f(localBankcard.field_bankcardType, localBankcard.field_bindSerial, (String)paramAnonymousVarArgs[0]), true, 1);
          AppMethodBeat.o(72260);
          return true;
        }
      };
      AppMethodBeat.o(72266);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72266);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72262);
    Log.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
    b(paramActivity, WalletWXCreditDetailUI.class, paramBundle);
    AppMethodBeat.o(72262);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72263);
    if (paramInt == 1)
    {
      b(paramActivity, WalletWXCreditErrDetailUI.class, paramBundle);
      paramActivity.finish();
      AppMethodBeat.o(72263);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditDetailUI))
    {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      AppMethodBeat.o(72263);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(72263);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditErrDetailUI)) {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    AppMethodBeat.o(72263);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72265);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXg, true);
    Log.i("MicroMsg.WXCreditManagerProcess", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      g(paramActivity, "mall", ".ui.MallIndexUIv2");
      AppMethodBeat.o(72265);
      return;
    }
    g(paramActivity, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(72265);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "WXCreditManagerProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72264);
    Z(paramActivity);
    AppMethodBeat.o(72264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.d
 * JD-Core Version:    0.7.0.1
 */