package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;

public abstract class e
  extends com.tencent.mm.wallet_core.e
{
  public g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI)) {
      new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72149);
          if ((paramAnonymousp instanceof d))
          {
            Log.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              e.a(e.this).putInt("key_errcode_payu", 0);
              a.b(this.activity, e.this.hPH, 0);
              AppMethodBeat.o(72149);
              return true;
            }
          }
          AppMethodBeat.o(72149);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72150);
          Object localObject = (w)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = e.b(e.this).getString("payu_reference");
          localObject = ((w)localObject).pRM;
          this.agTR.b(new d(paramAnonymousVarArgs, (String)localObject), true);
          AppMethodBeat.o(72150);
          return true;
        }
      };
    }
    return super.a(paramMMActivity, parami);
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletPayUSetPasswordUI)) {
      b(paramActivity, WalletPayUPwdConfirmUI.class, paramBundle);
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    if (this.hPH.getInt("key_errcode_payu", -1) == 0) {
      aa.makeText(paramActivity, a.i.wallet_order_info_result_success, 0).show();
    }
    for (;;)
    {
      boolean bool = ((c)h.ax(c.class)).a(c.a.yXg, true);
      Log.i("MicroMsg.PayUBaseChangePwdProcess", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      g(paramActivity, "mall", ".ui.MallIndexUIv2");
      return;
      aa.makeText(paramActivity, a.i.wallet_err_wording_comm_failed, 0).show();
    }
    g(paramActivity, "mall", ".ui.MallIndexUI");
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof WalletPayUPwdConfirmUI)) {
      a(paramActivity, WalletPayUSetPasswordUI.class, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.e
 * JD-Core Version:    0.7.0.1
 */