package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ak;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b
  extends com.tencent.mm.wallet_core.e
{
  private int fth()
  {
    AppMethodBeat.i(71742);
    int i = this.hPH.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYM);
    AppMethodBeat.o(71742);
    return i;
  }
  
  private void i(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71737);
    Log.printInfoStack("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(fth()) });
    if (fth() == 3)
    {
      paramBundle.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYM, 3);
      paramBundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYS, this.hPH.getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYS, ""));
      b(paramActivity, WalletOpenLqbProxyUI.class, paramBundle);
      AppMethodBeat.o(71737);
      return;
    }
    b(paramActivity, WalletECardFinishUI.class, null);
    AppMethodBeat.o(71737);
  }
  
  private String img()
  {
    AppMethodBeat.i(71741);
    String str = this.hPH.getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYO);
    AppMethodBeat.o(71741);
    return str;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(71743);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new b(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletECardBindCardListUI))
    {
      paramMMActivity = new d(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletECardCheckOtherCardUI))
    {
      paramMMActivity = new a(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletECardElementInputUI))
    {
      paramMMActivity = new e(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletOpenECardProxyUI))
    {
      paramMMActivity = new c(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletOpenLqbProxyUI))
    {
      paramMMActivity = new f(paramMMActivity, parami);
      AppMethodBeat.o(71743);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(71743);
    return paramMMActivity;
  }
  
  public final com.tencent.mm.wallet_core.e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71735);
    b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
    Log.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(fth()) });
    AppMethodBeat.o(71735);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71736);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZe, false))
      {
        Log.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.hPH.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZe, true);
        b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
        paramActivity.finish();
        AppMethodBeat.o(71736);
        return;
      }
      b(paramActivity, WalletECardBindCardListUI.class, null);
      AppMethodBeat.o(71736);
      return;
    }
    if ((paramActivity instanceof WalletECardBindCardListUI))
    {
      if (this.hPH.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYQ, com.tencent.mm.plugin.wallet_ecard.a.a.VZh) == com.tencent.mm.plugin.wallet_ecard.a.a.VZh)
      {
        if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb))
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(71736);
          return;
        }
        i(paramActivity, paramBundle);
        AppMethodBeat.o(71736);
        return;
      }
      b(paramActivity, WalletECardCheckOtherCardUI.class, null);
      AppMethodBeat.o(71736);
      return;
    }
    if (!(paramActivity instanceof WalletVerifyCodeUI))
    {
      boolean bool1;
      if ((paramActivity instanceof WalletECardCheckOtherCardUI))
      {
        bool1 = paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZc, false);
        boolean bool2 = paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb);
        Log.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (bool1)
        {
          b(paramActivity, WalletECardElementInputUI.class, null);
          AppMethodBeat.o(71736);
          return;
        }
        if (bool2)
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(71736);
        }
      }
      else
      {
        if ((paramActivity instanceof WalletECardElementInputUI))
        {
          if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb))
          {
            paramBundle.putBoolean("key_need_confirm_finish", true);
            a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
            AppMethodBeat.o(71736);
            return;
          }
          i(paramActivity, paramBundle);
          AppMethodBeat.o(71736);
          return;
        }
        if (!(paramActivity instanceof WalletOpenECardProxyUI)) {
          break label522;
        }
        bool1 = paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VYP, false);
        this.hPH.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VYP, bool1);
        String str = this.hPH.getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYN);
        paramInt = fth();
        int i = paramBundle.getInt("key_ecard_proxy_action", 1);
        Log.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(Util.isNullOrNil(str)), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i == 1)
        {
          if (!Util.isNullOrNil(str))
          {
            if (bool1)
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(71736);
              return;
            }
            if (paramInt != 3) {
              break label522;
            }
            b(paramActivity, WalletECardBindCardListUI.class, null);
            AppMethodBeat.o(71736);
            return;
          }
          a(paramActivity, WalletCheckPwdUI.class, paramBundle, 1);
          AppMethodBeat.o(71736);
          return;
        }
        if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb))
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(71736);
          return;
        }
      }
    }
    i(paramActivity, paramBundle);
    label522:
    AppMethodBeat.o(71736);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(71739);
    Log.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[] { paramActivity });
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramActivity, WalletOpenECardProxyUI.class);
    paramBundle.putExtras(localBundle);
    if (localBundle.containsKey("key_process_result_code")) {
      i = localBundle.getInt("key_process_result_code", 0);
    }
    a(paramActivity, WalletOpenECardProxyUI.class, i, paramBundle, true);
    AppMethodBeat.o(71739);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "OpenECardProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71738);
    if (paramInt == 100)
    {
      Log.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = fth();
      String str1 = img();
      String str2 = (String)this.hPH.get("key_pwd1");
      this.hPH.clear();
      this.hPH.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYM, paramInt);
      this.hPH.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYO, str1);
      this.hPH.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(71738);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.hPH.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYQ) == com.tencent.mm.plugin.wallet_ecard.a.a.VZh)
      {
        a(paramActivity, WalletECardBindCardListUI.class, 0);
        AppMethodBeat.o(71738);
        return;
      }
      a(paramActivity, WalletECardCheckOtherCardUI.class, 0);
    }
    AppMethodBeat.o(71738);
  }
  
  public final boolean j(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71740);
    Log.d("MicroMsg.OpenECardProcess", "intercept");
    paramBundle.putInt("key_process_result_code", 0);
    boolean bool = super.j(paramActivity, paramBundle);
    AppMethodBeat.o(71740);
    return bool;
  }
  
  final class a
    extends g
  {
    public a(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71707);
      if ((paramp instanceof z))
      {
        paramp = (z)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new Bundle();
          if ((paramp.Vya != null) && (paramp.Vya.VFd))
          {
            paramString = b.I(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYW);
            str = b.J(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYX);
            paramp = paramp.Vya.hAk;
            b.K(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYY, paramp);
            this.agTR.addSceneEndListener(1985);
            paramString = new d(b.b(b.this), b.e(b.this), paramString, str, paramp, b.n(b.this), false, 0, "");
            this.agTR.b(paramString, true);
          }
        }
      }
      while (!(paramp instanceof d)) {
        for (;;)
        {
          String str;
          AppMethodBeat.o(71707);
          return false;
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZc, true);
          b.this.a(this.activity, 0, paramString);
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
          k.c(this.activity, paramString, "", false);
        }
      }
      this.agTR.removeSceneEndListener(1985);
      paramp = (d)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramp.VZo.wuz == 0)
        {
          paramString = new Bundle();
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZc, false);
          if ((paramp.VZo.YNM != null) && (!Util.isNullOrNil(paramp.VZo.YNM.title)))
          {
            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.L(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.VZf, paramp.VZo.YNM.toByteArray());
          b.this.a(this.activity, 0, paramString);
          AppMethodBeat.o(71707);
          return true;
        }
        catch (IOException paramp)
        {
          Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramp, "", new Object[0]);
          continue;
        }
        Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, true);
        paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYZ, paramp.VZo.YNK);
        paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VZa, paramp.VZo.abcN);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZo.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZo.wuz, paramp.VZo.wuA)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZo.wuA, paramp.wYI, paramString });
          k.c(this.activity, paramString, "", false);
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
          k.c(this.activity, paramString, "", false);
        }
      }
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71706);
      String str = (String)paramVarArgs[0];
      paramVarArgs = (String)paramVarArgs[1];
      b.G(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYW, str);
      b.H(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYX, paramVarArgs);
      paramVarArgs = new z("", str, null);
      this.agTR.b(paramVarArgs, true);
      AppMethodBeat.o(71706);
      return true;
    }
  }
  
  final class b
    extends g
  {
    public b(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71712);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71712);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71711);
      if ((paramp instanceof com.tencent.mm.plugin.wallet_ecard.a.e))
      {
        this.agTR.removeSceneEndListener(1958);
        paramp = (com.tencent.mm.plugin.wallet_ecard.a.e)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramp.VZs.wuz == 0)
          {
            paramString = new Bundle();
            Log.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramp.VZs.YNJ, Boolean.valueOf(paramp.VZs.abcI) });
            b.d(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYO, paramp.VZs.YNJ);
            if (paramp.VZs.abcI) {
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZe, true);
            }
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71711);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZs.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZs.wuz, paramp.VZs.wuA)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZs.wuA, paramp.wYI, paramString });
            k.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71708);
                b.this.b(b.b.a(b.b.this), null);
                b.b.b(b.b.this).finish();
                AppMethodBeat.o(71708);
              }
            });
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71709);
                b.this.b(b.b.c(b.b.this), null);
                b.b.d(b.b.this).finish();
                AppMethodBeat.o(71709);
              }
            });
          }
        }
      }
      AppMethodBeat.o(71711);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71710);
      paramVarArgs = (String)paramVarArgs[0];
      int i = b.a(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYM);
      this.agTR.addSceneEndListener(1958);
      com.tencent.mm.plugin.wallet_ecard.a.e locale = new com.tencent.mm.plugin.wallet_ecard.a.e(b.b(b.this), paramVarArgs, i, null);
      this.agTR.b(locale, true);
      b.c(b.this).putString("key_pwd1", paramVarArgs);
      AppMethodBeat.o(71710);
      return true;
    }
  }
  
  final class c
    extends g
  {
    public c(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71719);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71719);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71718);
      if ((paramp instanceof com.tencent.mm.plugin.wallet_ecard.a.e))
      {
        this.agTR.removeSceneEndListener(1958);
        paramp = (com.tencent.mm.plugin.wallet_ecard.a.e)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramp.VZs.wuz == 0)
          {
            paramString = new Bundle();
            Log.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramp.VZs.YNJ });
            b.f(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYO, paramp.VZs.YNJ);
            Log.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramp.token, Boolean.valueOf(paramp.VZs.abcH), Boolean.valueOf(paramp.VZs.abcI) });
            if (!Util.isNullOrNil(paramp.token)) {
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VYP, paramp.VZs.abcH);
            }
            if (paramp.VZs.abcI) {
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZe, true);
            }
            paramString.putInt("key_ecard_proxy_action", 1);
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71718);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZs.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZs.wuz, paramp.VZs.wuA)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZs.wuA, paramp.wYI, paramString });
            k.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71713);
                b.this.b(b.c.a(b.c.this), null);
                AppMethodBeat.o(71713);
              }
            });
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71714);
                b.this.b(b.c.b(b.c.this), null);
                AppMethodBeat.o(71714);
              }
            });
          }
        }
      }
      if ((paramp instanceof d))
      {
        this.agTR.removeSceneEndListener(1985);
        paramp = (d)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramp.VZo.wuz == 0)
          {
            b.g(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYQ, com.tencent.mm.plugin.wallet_ecard.a.a.VZh);
            b.h(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYT, paramp.VZp);
            b.i(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYU, paramp.VZq);
            b.j(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYV, paramp.VZr);
            paramString = new Bundle();
            if (paramp.VZo.YNM != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.k(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.VZf, paramp.VZo.YNM.toByteArray());
            paramString.putInt("key_ecard_proxy_action", 2);
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71718);
            return true;
          }
          catch (IOException paramp)
          {
            Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramp, "", new Object[0]);
            continue;
          }
          Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, true);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYZ, paramp.VZo.YNK);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VZa, paramp.VZo.abcN);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZo.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZo.wuz, paramp.VZo.wuA)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZo.wuA, paramp.wYI, paramString });
            k.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71715);
                b.this.b(b.c.c(b.c.this), null);
                AppMethodBeat.o(71715);
              }
            });
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71716);
                b.this.b(b.c.d(b.c.this), null);
                AppMethodBeat.o(71716);
              }
            });
          }
        }
      }
      AppMethodBeat.o(71718);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71717);
      int i;
      if (((Integer)paramVarArgs[0]).intValue() == 1)
      {
        Log.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
        i = ((Integer)paramVarArgs[1]).intValue();
        paramVarArgs = (String)paramVarArgs[2];
        this.agTR.addSceneEndListener(1958);
        paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.e(b.b(b.this), null, i, paramVarArgs);
        this.agTR.b(paramVarArgs, true);
      }
      for (;;)
      {
        AppMethodBeat.o(71717);
        return true;
        Log.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
        i = ((Integer)paramVarArgs[1]).intValue();
        this.agTR.addSceneEndListener(1985);
        paramVarArgs = new d(b.b(b.this), b.e(b.this), i);
        this.agTR.b(paramVarArgs, true);
      }
    }
  }
  
  final class d
    extends g
  {
    private com.tencent.mm.ui.widget.a.e qkG;
    
    public d(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    private void a(dck paramdck, TextView paramTextView)
    {
      AppMethodBeat.i(71724);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((paramdck.aaIl != null) && (!Util.isNullOrNil(paramdck.aaIl.desc)))
      {
        localSpannableStringBuilder.append(paramdck.aaIl.desc);
        if (!Util.isNullOrNil(paramdck.aaIl.nRQ)) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(n.dE(paramdck.aaIl.nRQ, false)), 0, localSpannableStringBuilder.length(), 18);
        }
      }
      if ((paramdck.aaIm != null) && (!Util.isNullOrNil(paramdck.aaIm.desc)))
      {
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(paramdck.aaIm.desc);
        localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(paramdck.aaIm.nRQ, new s.a()
        {
          public final void eS(View paramAnonymousView)
          {
            AppMethodBeat.i(71720);
            Log.d("MicroMsg.OpenECardProcess", "click span");
            b.d.a(b.d.this).dismiss();
            if ((b.d.b(b.d.this) instanceof WalletECardBindCardListUI)) {
              ((WalletECardBindCardListUI)b.d.c(b.d.this)).imh();
            }
            AppMethodBeat.o(71720);
          }
        }), i, localSpannableStringBuilder.length(), 18);
      }
      paramTextView.setText(localSpannableStringBuilder);
      AppMethodBeat.o(71724);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
    {
      AppMethodBeat.i(71725);
      if ((paramp instanceof d))
      {
        this.agTR.removeSceneEndListener(1985);
        paramp = (d)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramp.VZo.wuz == 0) {
            if (paramp.VZo.abcO != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "show input alert");
              paramString = paramp.VZo.abcO;
              if (this.qkG == null)
              {
                View localView = View.inflate(this.activity, a.g.ecard_mobile_verify_alert, null);
                final EditText localEditText = (EditText)localView.findViewById(a.f.emva_et);
                final TextView localTextView = (TextView)localView.findViewById(a.f.emva_tips);
                localTextView.setClickable(true);
                localTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this.activity));
                if (!Util.isNullOrNil(paramString.aaIk)) {
                  localEditText.setHint(paramp.VZo.abcO.aaIk);
                }
                e.a locala = new e.a(this.activity);
                locala.bDv(paramp.VZo.abcO.aaIj);
                locala.aEM(4);
                locala.md(localView);
                if (!Util.isNullOrNil(paramString.aaIo)) {
                  locala.bDC(paramString.aaIo);
                }
                if (!Util.isNullOrNil(paramString.aaIn)) {
                  locala.bDD(paramString.aaIn);
                }
                locala.a(false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(71721);
                    Log.i("MicroMsg.OpenECardProcess", "click verify btn");
                    paramAnonymousDialogInterface = localEditText.getText().toString();
                    if (paramAnonymousDialogInterface.length() == 11)
                    {
                      b.d.d(b.d.this).addSceneEndListener(1985);
                      dwx localdwx = (dwx)c.b.b(((com.tencent.mm.am.c)paramp.getReqResp()).otB);
                      b.o(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.VZj, 2);
                      paramAnonymousDialogInterface = new d(b.b(b.this), localdwx.YNJ, localdwx.abcJ, paramAnonymousDialogInterface, localdwx.hAk, b.n(b.this), true, 2, localdwx.abcM);
                      b.d.e(b.d.this).a(paramAnonymousDialogInterface, true, 1);
                      AppMethodBeat.o(71721);
                      return;
                    }
                    paramAnonymousDialogInterface = new dck();
                    paramAnonymousDialogInterface.aaIl = new ajx();
                    paramAnonymousDialogInterface.aaIl.desc = b.d.f(b.d.this).getString(a.i.ecard_bind_card_verify_mobile_format_error);
                    paramAnonymousDialogInterface.aaIl.nRQ = "#FA5151";
                    paramAnonymousDialogInterface.aaIm = new ajx();
                    paramAnonymousDialogInterface.aaIm.desc = b.d.g(b.d.this).getString(a.i.ecard_bind_card_verify_mobile_bind_card);
                    paramAnonymousDialogInterface.aaIm.nRQ = "#0C4F8E";
                    b.d.a(b.d.this, paramAnonymousDialogInterface, localTextView);
                    AppMethodBeat.o(71721);
                  }
                });
                locala.NC(false);
                locala.c(new DialogInterface.OnDismissListener()
                {
                  public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(71722);
                    Log.i("MicroMsg.OpenECardProcess", "dismiss alert");
                    b.d.h(b.d.this);
                    AppMethodBeat.o(71722);
                  }
                });
                this.qkG = locala.jHH();
                a(paramString, localTextView);
                this.qkG.show();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71725);
          return true;
          a(paramString, (TextView)this.qkG.findViewById(a.f.emva_tips));
          continue;
          b.p(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYQ, com.tencent.mm.plugin.wallet_ecard.a.a.VZh);
          b.q(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYT, paramp.VZp);
          b.r(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYU, paramp.VZq);
          b.s(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYV, paramp.VZr);
          paramString = new Bundle();
          if (paramp.VZo.YNM != null)
          {
            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, false);
          }
          for (;;)
          {
            try
            {
              b.t(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.VZf, paramp.VZo.YNM.toByteArray());
              b.this.a(this.activity, 0, paramString);
            }
            catch (IOException paramp)
            {
              Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramp, "", new Object[0]);
              continue;
            }
            Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
            paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, true);
            paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYZ, paramp.VZo.YNK);
            paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VZa, paramp.VZo.abcN);
          }
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZo.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZo.wuz, paramp.VZo.wuA)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZo.wuA, paramp.wYI, paramString });
            k.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71725);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71723);
      paramVarArgs = (jp)paramVarArgs[0];
      String str1 = b.l(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYO, "");
      if (paramVarArgs == null)
      {
        Log.w("MicroMsg.OpenECardProcess", "empty bank item");
        AppMethodBeat.o(71723);
        return false;
      }
      this.agTR.addSceneEndListener(1985);
      String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.JFk, paramVarArgs.wDh, paramVarArgs.YLP });
      b.m(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.VZj, 1);
      paramVarArgs = new d(b.b(b.this), str1, paramVarArgs.YLQ, paramVarArgs.VxX, paramVarArgs.hAk, b.n(b.this), true, 1, str2);
      this.agTR.a(paramVarArgs, true, 1);
      AppMethodBeat.o(71723);
      return true;
    }
  }
  
  final class e
    extends g
  {
    public e(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71727);
      if ((paramp instanceof d))
      {
        this.agTR.removeSceneEndListener(1985);
        paramp = (d)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramp.VZo.wuz == 0)
          {
            paramString = new Bundle();
            if (paramp.VZo.YNM != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.O(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.VZf, paramp.VZo.YNM.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71727);
            return true;
          }
          catch (IOException paramp)
          {
            Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramp, "", new Object[0]);
            continue;
          }
          Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.VZb, true);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VYZ, paramp.VZo.YNK);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.VZa, paramp.VZo.abcN);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZo.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZo.wuz, paramp.VZo.wuA)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZo.wuA, paramp.wYI, paramString });
            k.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71727);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71726);
      paramVarArgs = ((ElementQuery)paramVarArgs[0]).hAk;
      String str1 = b.M(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYW);
      String str2 = b.N(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYX);
      this.agTR.addSceneEndListener(1985);
      paramVarArgs = new d(b.b(b.this), b.e(b.this), str1, str2, paramVarArgs, b.n(b.this), false, 0, "");
      this.agTR.b(paramVarArgs, true);
      AppMethodBeat.o(71726);
      return true;
    }
  }
  
  final class f
    extends g
  {
    public f(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71729);
      if ((paramp instanceof ak))
      {
        Log.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Object localObject = (ak)paramp;
        Bundle localBundle = new Bundle();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((ak)localObject).Vbo;
          if ((paramString.ifY != null) && ((this.activity instanceof WalletOpenLqbProxyUI)))
          {
            paramp = (WalletOpenLqbProxyUI)this.activity;
            localObject = paramString.ifY;
            if (paramp.VZV != null) {
              paramp.VZV.a((dkf)localObject, null);
            }
          }
          if (paramString.wuz == 0)
          {
            b.P(b.this).putBoolean("key_goto_lqt_detail", true);
            localBundle.putInt("key_process_result_code", -1);
          }
        }
        for (;;)
        {
          b.this.b(this.activity, localBundle);
          AppMethodBeat.o(71729);
          return true;
          if (paramString.ifY == null)
          {
            Log.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.wuA });
            Toast.makeText(this.activity, paramString.wuA, 1).show();
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71729);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71728);
      ((Integer)paramVarArgs[0]).intValue();
      paramVarArgs = (String)paramVarArgs[1];
      this.agTR.addSceneEndListener(2996);
      paramVarArgs = new ak(b.b(b.this), paramVarArgs);
      this.agTR.b(paramVarArgs, true);
      AppMethodBeat.o(71728);
      return false;
    }
  }
  
  final class g
    extends g
  {
    public g(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean E(Object... paramVarArgs)
    {
      AppMethodBeat.i(71731);
      int i = b.u(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYQ);
      paramVarArgs = b.e(b.this);
      int j = b.v(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VZj);
      Log.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      String str1;
      String str2;
      String str3;
      if (i == com.tencent.mm.plugin.wallet_ecard.a.a.VZh)
      {
        str1 = b.w(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYT);
        str2 = b.x(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYU);
        str3 = b.y(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYV);
      }
      for (paramVarArgs = new d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), true, true, j, "");; paramVarArgs = new d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), false, true, j, ""))
      {
        this.agTR.addSceneEndListener(1985);
        this.agTR.b(paramVarArgs, true);
        AppMethodBeat.o(71731);
        return true;
        str1 = b.z(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYW);
        str2 = b.A(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYX);
        str3 = b.B(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.VYY);
      }
    }
    
    public final CharSequence getTips(int paramInt)
    {
      AppMethodBeat.i(71730);
      String str = this.activity.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.VZa);
      AppMethodBeat.o(71730);
      return str;
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71734);
      Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      b.this.b(this.activity, new Bundle());
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(71734);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71733);
      if ((paramp instanceof com.tencent.mm.plugin.wallet_ecard.a.c))
      {
        this.agTR.removeSceneEndListener(1986);
        paramp = (com.tencent.mm.plugin.wallet_ecard.a.c)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramp.VZn.wuz != 0) {
            break label155;
          }
          paramString = new Bundle();
          if (paramp.VZn.YNM != null) {
            Log.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramp.VZn.YNM.title });
          }
        }
        for (;;)
        {
          try
          {
            b.F(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.VZf, paramp.VZn.YNM.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71733);
            return true;
          }
          catch (IOException paramp)
          {
            Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramp, "", new Object[0]);
            continue;
          }
          label155:
          if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZn.YNL))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZn.wuA, paramString });
            k.c(this.activity, paramString, "", false);
          }
        }
      }
      if ((paramp instanceof d))
      {
        this.agTR.removeSceneEndListener(1985);
        paramp = (d)paramp;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramp.VZo.wuz == 0) {
            this.activity.getIntent().putExtra(com.tencent.mm.plugin.wallet_ecard.a.a.VYZ, paramp.VZo.YNK);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71733);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp.VZo.YNL)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramp, paramp.hAV, paramp.wYI, paramp.VZo.wuz, paramp.VZo.wuA)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramp.VZo.wuA, paramp.wYI, paramString });
            k.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramp });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            k.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71733);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      AppMethodBeat.i(71732);
      b.C(b.this).getString("key_pwd1");
      paramVarArgs = b.D(b.this).getString("key_verify_code");
      String str1 = b.e(b.this);
      int i = b.E(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYM);
      String str2 = this.activity.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.VYZ);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.c(b.b(b.this), str1, paramVarArgs, str2, i);
      this.agTR.addSceneEndListener(1986);
      this.agTR.a(paramVarArgs, true, 3);
      AppMethodBeat.o(71732);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */