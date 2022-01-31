package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends b
{
  private int aYY = 0;
  private boolean inQ = false;
  private String mActivityName = null;
  private int mMode;
  private String qrt = null;
  private boolean qru = false;
  private int qrv = -1;
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_input_realname_finish_confirm;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    A(new Object[] { "start", paramActivity, paramBundle });
    if (this.kke == null) {
      this.kke = new Bundle();
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = this.kke;
    }
    if (localBundle != null)
    {
      this.mMode = localBundle.getInt("real_name_verify_mode", 0);
      label69:
      this.qrv = this.mMode;
      localBundle.putBoolean("key_is_realname_verify_process", true);
      this.qrt = localBundle.getString("realname_verify_process_jump_plugin", "");
      this.mActivityName = localBundle.getString("realname_verify_process_jump_activity", "");
      if (localBundle.getInt("realname_verify_process_allow_idverify", 0) != 1) {
        break label206;
      }
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      this.qru = bool;
      y.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[] { Boolean.valueOf(this.qru), this.qrt, this.mActivityName });
      switch (this.mMode)
      {
      default: 
        return this;
        this.mMode = 0;
        break label69;
      }
    }
    localBundle.putBoolean("key_need_bind_response", true);
    v.IX(10);
    super.a(paramActivity, localBundle);
    return this;
    v.IX(10);
    b(paramActivity, SwitchRealnameVerifyModeUI.class, localBundle);
    return this;
    b(paramActivity, WalletRealNameVerifyUI.class, localBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      if (this.mMode == 2) {
        return new a.2(this, paramMMActivity, parami);
      }
      return super.a(paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletRealNameVerifyUI)) {
      return new a.3(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    A(new Object[] { "forward", paramActivity, "actionCode:" + paramInt, paramBundle });
    int i = this.kke.getInt("real_name_verify_mode", this.mMode);
    if (this.mMode != i) {
      this.mMode = i;
    }
    if (this.mMode == 2)
    {
      if ((paramActivity instanceof WalletRealNameVerifyUI)) {
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      }
      do
      {
        return;
        if ((paramActivity instanceof WalletSetPasswordUI))
        {
          b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
          return;
        }
      } while (((paramActivity instanceof WalletPwdConfirmUI)) || (!(paramActivity instanceof SwitchRealnameVerifyModeUI)));
      b(paramActivity, WalletRealNameVerifyUI.class, paramBundle);
      this.mMode = 2;
      return;
    }
    if (this.mMode == 1)
    {
      if ((paramActivity instanceof SwitchRealnameVerifyModeUI))
      {
        if (o.bVs().bVN())
        {
          b(paramActivity, WalletCheckPwdUI.class, paramBundle);
          return;
        }
        b(paramActivity, WalletBankcardIdUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletCheckPwdUI))
      {
        b(paramActivity, WalletBankcardIdUI.class, paramBundle);
        return;
      }
      super.a(paramActivity, paramInt, paramBundle);
      return;
    }
    if ((paramActivity instanceof WalletRealNameVerifyUI))
    {
      b(paramActivity, WalletBankcardIdUI.class, paramBundle);
      this.mMode = 1;
      return;
    }
    super.a(paramActivity, paramInt, paramBundle);
  }
  
  public final String aTh()
  {
    return "realname_verify_process";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    A(new Object[] { "back", paramActivity, Integer.valueOf(paramInt) });
    v.cMD();
    if ((paramActivity instanceof SwitchRealnameVerifyModeUI)) {
      if (paramInt == 0) {
        b(paramActivity, this.kke);
      }
    }
    for (;;)
    {
      if ((paramActivity instanceof WalletPwdConfirmUI)) {
        a(paramActivity, WalletSetPasswordUI.class, paramInt);
      }
      return;
      if (((paramActivity instanceof WalletRealNameVerifyUI)) || ((paramActivity instanceof WalletBankcardIdUI)))
      {
        if (this.qrv != 0) {
          b(paramActivity, this.kke);
        }
      }
      else if ((paramActivity instanceof WalletCheckPwdUI)) {
        b(paramActivity, this.kke);
      }
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    A(new Object[] { "end", paramActivity, paramBundle });
    v.cMD();
    if (paramBundle == null) {
      paramBundle = this.kke;
    }
    for (;;)
    {
      Object localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      if (this.mMode == 1)
      {
        cMq();
        if (((Bundle)localObject).getBoolean("intent_bind_end", false))
        {
          this.aYY = -1;
          if (((Bundle)localObject).containsKey("intent_bind_end")) {
            ((Bundle)localObject).remove("intent_bind_end");
          }
          if (((Bundle)localObject).containsKey("key_is_bind_reg_process")) {
            ((Bundle)localObject).remove("key_is_bind_reg_process");
          }
          ((Bundle)localObject).putInt("realname_verify_process_ret", this.aYY);
          paramBundle = new Intent();
          paramBundle.putExtras((Bundle)localObject);
          if (this.aYY == -1) {
            Toast.makeText(paramActivity, paramActivity.getString(a.i.realname_verify_succ), 0).show();
          }
          localObject = new tk();
          if (this.aYY != -1) {
            break label241;
          }
          ((tk)localObject).ccZ.scene = 17;
        }
      }
      for (;;)
      {
        ((tk)localObject).bFJ = new a.1(this, (tk)localObject, paramBundle, paramActivity);
        ((tk)localObject).bFJ.run();
        return;
        this.aYY = 0;
        break;
        if (((Bundle)localObject).containsKey("realname_verify_process_ret"))
        {
          this.aYY = ((Bundle)localObject).getInt("realname_verify_process_ret", -1);
          break;
        }
        this.aYY = 0;
        break;
        label241:
        if (this.aYY == 0) {
          ((tk)localObject).ccZ.scene = 18;
        } else {
          ((tk)localObject).ccZ.scene = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a
 * JD-Core Version:    0.7.0.1
 */