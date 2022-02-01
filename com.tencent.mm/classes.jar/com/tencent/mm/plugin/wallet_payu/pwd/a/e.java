package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public abstract class e
  extends com.tencent.mm.wallet_core.d
{
  public g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI)) {
      new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72149);
          if ((paramAnonymousn instanceof d))
          {
            ad.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              e.this.dow.putInt("key_errcode_payu", 0);
              a.b(this.activity, e.this.dow, 0);
              AppMethodBeat.o(72149);
              return true;
            }
          }
          AppMethodBeat.o(72149);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72150);
          Object localObject = (u)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = e.this.dow.getString("payu_reference");
          localObject = ((u)localObject).ijt;
          this.Ieo.b(new d(paramAnonymousVarArgs, (String)localObject), true);
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
    if (this.dow.getInt("key_errcode_payu", -1) == 0) {
      t.makeText(paramActivity, 2131765569, 0).show();
    }
    for (;;)
    {
      e(paramActivity, "mall", ".ui.MallIndexUI");
      return;
      t.makeText(paramActivity, 2131765252, 0).show();
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void g(Activity paramActivity, int paramInt)
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