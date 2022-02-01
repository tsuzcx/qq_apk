package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
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
            localObject = this.activity.getString(a.i.wallet_check_pwd_unbind_bankcard_tip_payu);
            AppMethodBeat.o(71986);
            return localObject;
          }
          Object localObject = super.getTips(paramAnonymousInt);
          AppMethodBeat.o(71986);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(71987);
          if ((paramAnonymousq instanceof c)) {
            if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 == 0))
            {
              paramAnonymousString = (c)paramAnonymousq;
              d.a(d.this).putString("payu_reference", paramAnonymousString.token);
              if (Util.isNullOrNil(paramAnonymousString.token)) {
                break label118;
              }
              Log.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
              paramAnonymousString = (Bankcard)d.b(d.this).getParcelable("key_bankcard");
              if (paramAnonymousString != null) {
                this.YVX.b(new b(paramAnonymousString.field_bindSerial, d.c(d.this).getString("payu_reference")), true);
              }
            }
          }
          label118:
          while (!(paramAnonymousq instanceof b)) {
            for (;;)
            {
              AppMethodBeat.o(71987);
              return false;
              Log.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
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
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(71988);
          d.f(d.this).putString("key_pwd1", (String)paramAnonymousVarArgs[0]);
          this.YVX.b(new c(d.g(d.this).getString("key_pwd1")), true);
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
    if (this.fKb.getInt("key_errcode_payu", -1) == 0) {
      w.makeText(paramActivity, a.i.wallet_order_info_result_success, 0).show();
    }
    for (;;)
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true);
      Log.i("MicroMsg.PayUUnbindProcess", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      h(paramActivity, "mall", ".ui.MallIndexUIv2");
      AppMethodBeat.o(71990);
      return;
      w.makeText(paramActivity, a.i.wallet_err_wording_comm_failed, 0).show();
    }
    h(paramActivity, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(71990);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, Bundle paramBundle)
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