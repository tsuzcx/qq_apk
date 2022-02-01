package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public class g
  extends e
{
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72159);
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI))
    {
      paramMMActivity = new a(paramMMActivity, parami, this.fKb)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(72154);
          if (paramAnonymousInt == 0)
          {
            localObject = this.activity.getString(a.i.wallet_check_pwd_modify_pwd_tip_payu);
            AppMethodBeat.o(72154);
            return localObject;
          }
          Object localObject = super.getTips(paramAnonymousInt);
          AppMethodBeat.o(72154);
          return localObject;
        }
      };
      AppMethodBeat.o(72159);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(72155);
          if ((paramAnonymousq instanceof b))
          {
            Log.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              g.a(g.this).putInt("key_errcode_payu", 0);
              com.tencent.mm.wallet_core.a.b(this.activity, g.this.fKb, 0);
              AppMethodBeat.o(72155);
              return true;
            }
          }
          AppMethodBeat.o(72155);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72156);
          Object localObject = (w)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = g.b(g.this).getString("key_pwd1");
          localObject = ((w)localObject).mVf;
          this.YVX.b(new b(paramAnonymousVarArgs, (String)localObject), true);
          AppMethodBeat.o(72156);
          return true;
        }
      };
      AppMethodBeat.o(72159);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72159);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72157);
    b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(72157);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72158);
    if ((paramActivity instanceof WalletPayUCheckPwdUI))
    {
      b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(72158);
      return;
    }
    super.a(paramActivity, paramInt, paramBundle);
    AppMethodBeat.o(72158);
  }
  
  public final String epb()
  {
    return "PayUModifyPasswordProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */