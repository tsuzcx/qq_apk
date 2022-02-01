package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d
  extends a
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(71992);
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(71986);
          if (paramAnonymousInt == 0)
          {
            localObject = this.activity.getString(2131765209);
            AppMethodBeat.o(71986);
            return localObject;
          }
          Object localObject = super.getTips(paramAnonymousInt);
          AppMethodBeat.o(71986);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(71987);
          if ((paramAnonymousn instanceof c)) {
            if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 == 0))
            {
              paramAnonymousString = (c)paramAnonymousn;
              d.a(d.this).putString("payu_reference", paramAnonymousString.token);
              if (bs.isNullOrNil(paramAnonymousString.token)) {
                break label118;
              }
              ac.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
              paramAnonymousString = (Bankcard)d.b(d.this).getParcelable("key_bankcard");
              if (paramAnonymousString != null) {
                this.JFQ.b(new b(paramAnonymousString.field_bindSerial, d.c(d.this).getString("payu_reference")), true);
              }
            }
          }
          label118:
          while (!(paramAnonymousn instanceof b)) {
            for (;;)
            {
              AppMethodBeat.o(71987);
              return false;
              ac.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
            }
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            d.d(d.this).putInt("key_errcode_payu", 0);
            d.this.b(this.activity, d.e(d.this));
          }
          AppMethodBeat.o(71987);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(71988);
          d.f(d.this).putString("key_pwd1", (String)paramAnonymousVarArgs[0]);
          this.JFQ.b(new c(d.g(d.this).getString("key_pwd1")), true);
          AppMethodBeat.o(71988);
          return true;
        }
      };
      AppMethodBeat.o(71992);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(71992);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71991);
    if ((paramActivity instanceof WalletBankcardDetailUI))
    {
      b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
      AppMethodBeat.o(71991);
      return;
    }
    if ((paramActivity instanceof WalletPayUCheckPwdUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(71991);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71990);
    if (this.dmf.getInt("key_errcode_payu", -1) == 0) {
      t.makeText(paramActivity, 2131765569, 0).show();
    }
    for (;;)
    {
      e(paramActivity, "mall", ".ui.MallIndexUI");
      AppMethodBeat.o(71990);
      return;
      t.makeText(paramActivity, 2131765252, 0).show();
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71989);
    b(paramActivity, WalletPayUBankcardDetailUI.class, paramBundle);
    AppMethodBeat.o(71989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.d
 * JD-Core Version:    0.7.0.1
 */