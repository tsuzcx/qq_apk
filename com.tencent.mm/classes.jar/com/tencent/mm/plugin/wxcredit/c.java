package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;

public class c
  extends d
{
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72257);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean A(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(72251);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            c.this.a(this.activity, 0, c.a(c.this));
            this.activity.finish();
            AppMethodBeat.o(72251);
            return true;
          }
          AppMethodBeat.o(72251);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72252);
          c.b(c.this).putString("key_pwd1", (String)paramAnonymousVarArgs[0]);
          this.Ruz.a(new w((String)paramAnonymousVarArgs[0], 5, ""), true, 1);
          AppMethodBeat.o(72252);
          return true;
        }
      };
      AppMethodBeat.o(72257);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72257);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72253);
    Log.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditCheckPwdProcess");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(72253);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72254);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      f.p(paramActivity, paramBundle.getString("key_url"), false);
      AppMethodBeat.o(72254);
      return;
    }
    b(paramActivity, paramBundle);
    AppMethodBeat.o(72254);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72256);
    boolean bool = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sad, true);
    Log.i("MicroMsg.WXCreditChangeAmountProcess", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      e(paramActivity, "mall", ".ui.MallIndexUIv2");
      AppMethodBeat.o(72256);
      return;
    }
    e(paramActivity, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(72256);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String dKC()
  {
    return "WXCreditCheckPwdProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72255);
    P(paramActivity);
    AppMethodBeat.o(72255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.c
 * JD-Core Version:    0.7.0.1
 */