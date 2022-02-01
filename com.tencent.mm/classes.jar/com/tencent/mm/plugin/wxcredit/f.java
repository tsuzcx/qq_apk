package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;

public class f
  extends e
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72295);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72289);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof com.tencent.mm.plugin.wxcredit.a.f)))
          {
            f.this.a(this.activity, 0, f.a(f.this));
            AppMethodBeat.o(72289);
            return true;
          }
          AppMethodBeat.o(72289);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72290);
          if (!f.b(f.this).getBoolean("key_is_show_detail", true))
          {
            paramAnonymousVarArgs = (Bankcard)f.c(f.this).getParcelable("key_bankcard");
            this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.f(paramAnonymousVarArgs.field_bankcardType, paramAnonymousVarArgs.field_bindSerial, f.d(f.this).getString("key_pwd1")), true, 1);
            AppMethodBeat.o(72290);
            return true;
          }
          AppMethodBeat.o(72290);
          return false;
        }
      };
      AppMethodBeat.o(72295);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72295);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72291);
    Log.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
    if (paramBundle.getBoolean("key_is_show_detail", true)) {
      a(paramActivity, "wallet", ".bind.ui.WalletBankcardDetailUI", paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(72291);
      return this;
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72292);
    if (paramActivity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI"))
    {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      AppMethodBeat.o(72292);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(72292);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72294);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXg, true);
    Log.i("MicroMsg.ProcessManager", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      g(paramActivity, "mall", ".ui.MallIndexUIv2");
      AppMethodBeat.o(72294);
      return;
    }
    g(paramActivity, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(72294);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "WXCreditUnbindProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72293);
    Z(paramActivity);
    AppMethodBeat.o(72293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.f
 * JD-Core Version:    0.7.0.1
 */