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
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.c;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b
  extends com.tencent.mm.wallet_core.d
{
  private int cRJ()
  {
    AppMethodBeat.i(71742);
    int i = this.dyY.getInt(a.DGe);
    AppMethodBeat.o(71742);
    return i;
  }
  
  private String eME()
  {
    AppMethodBeat.i(71741);
    String str = this.dyY.getString(a.DGg);
    AppMethodBeat.o(71741);
    return str;
  }
  
  private void h(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71737);
    ae.m("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(cRJ()) });
    if (cRJ() == 3)
    {
      paramBundle.putInt(a.DGe, 3);
      paramBundle.putString(a.DGk, this.dyY.getString(a.DGk, ""));
      b(paramActivity, WalletOpenLqbProxyUI.class, paramBundle);
      AppMethodBeat.o(71737);
      return;
    }
    b(paramActivity, WalletECardFinishUI.class, null);
    AppMethodBeat.o(71737);
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
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
  
  public final com.tencent.mm.wallet_core.d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71735);
    b(paramActivity, WalletOpenECardProxyUI.class, paramBundle);
    ae.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(cRJ()) });
    AppMethodBeat.o(71735);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71736);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(a.DGw, false))
      {
        ae.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.dyY.putBoolean(a.DGw, true);
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
      if (this.dyY.getInt(a.DGi, a.DGz) == a.DGz)
      {
        if (paramBundle.getBoolean(a.DGt))
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(71736);
          return;
        }
        h(paramActivity, paramBundle);
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
        bool1 = paramBundle.getBoolean(a.DGu, false);
        boolean bool2 = paramBundle.getBoolean(a.DGt);
        ae.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
          if (paramBundle.getBoolean(a.DGt))
          {
            paramBundle.putBoolean("key_need_confirm_finish", true);
            a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
            AppMethodBeat.o(71736);
            return;
          }
          h(paramActivity, paramBundle);
          AppMethodBeat.o(71736);
          return;
        }
        if (!(paramActivity instanceof WalletOpenECardProxyUI)) {
          break label522;
        }
        bool1 = paramBundle.getBoolean(a.DGh, false);
        this.dyY.putBoolean(a.DGh, bool1);
        String str = this.dyY.getString(a.DGf);
        paramInt = cRJ();
        int i = paramBundle.getInt("key_ecard_proxy_action", 1);
        ae.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bu.isNullOrNil(str)), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i == 1)
        {
          if (!bu.isNullOrNil(str))
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
        if (paramBundle.getBoolean(a.DGt))
        {
          paramBundle.putBoolean("key_need_confirm_finish", true);
          a(paramActivity, WalletVerifyCodeUI.class, null, paramBundle);
          AppMethodBeat.o(71736);
          return;
        }
      }
    }
    h(paramActivity, paramBundle);
    label522:
    AppMethodBeat.o(71736);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(71739);
    ae.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[] { paramActivity });
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
  
  public final String cSH()
  {
    return "OpenECardProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71738);
    if (paramInt == 100)
    {
      ae.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = cRJ();
      String str1 = eME();
      String str2 = (String)this.dyY.get("key_pwd1");
      this.dyY.clear();
      this.dyY.putInt(a.DGe, paramInt);
      this.dyY.putString(a.DGg, str1);
      this.dyY.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(71738);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.dyY.getInt(a.DGi) == a.DGz)
      {
        a(paramActivity, WalletECardBindCardListUI.class, 0);
        AppMethodBeat.o(71738);
        return;
      }
      a(paramActivity, WalletECardCheckOtherCardUI.class, 0);
    }
    AppMethodBeat.o(71738);
  }
  
  public final boolean i(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71740);
    ae.d("MicroMsg.OpenECardProcess", "intercept");
    paramBundle.putInt("key_process_result_code", 0);
    boolean bool = super.i(paramActivity, paramBundle);
    AppMethodBeat.o(71740);
    return bool;
  }
  
  final class a
    extends com.tencent.mm.wallet_core.d.g
  {
    public a(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71707);
      if ((paramn instanceof y))
      {
        paramn = (y)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new Bundle();
          if ((paramn.DgM != null) && (paramn.DgM.DnR))
          {
            paramString = b.I(b.this).getString(a.DGo);
            str = b.J(b.this).getString(a.DGp);
            paramn = paramn.DgM.dlT;
            b.K(b.this).putString(a.DGq, paramn);
            this.LVJ.addSceneEndListener(1985);
            paramString = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), paramString, str, paramn, b.n(b.this), false, 0, "");
            this.LVJ.b(paramString, true);
          }
        }
      }
      while (!(paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
        for (;;)
        {
          String str;
          AppMethodBeat.o(71707);
          return false;
          paramString.putBoolean(a.DGu, true);
          b.this.a(this.activity, 0, paramString);
          continue;
          ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      this.LVJ.removeSceneEndListener(1985);
      paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramn.DGG.oGt == 0)
        {
          paramString = new Bundle();
          paramString.putBoolean(a.DGu, false);
          if ((paramn.DGG.FVN != null) && (!bu.isNullOrNil(paramn.DGG.FVN.title)))
          {
            ae.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.DGt, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.L(b.this).putByteArray(a.DGx, paramn.DGG.FVN.toByteArray());
          b.this.a(this.activity, 0, paramString);
          AppMethodBeat.o(71707);
          return true;
        }
        catch (IOException paramn)
        {
          ae.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
          continue;
        }
        ae.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(a.DGt, true);
        paramString.putString(a.DGr, paramn.DGG.FVL);
        paramString.putString(a.DGs, paramn.DGG.HrZ);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGG.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGG.oGt, paramn.DGG.oGu)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGG.oGu, paramn.phe, paramString });
          h.c(this.activity, paramString, "", false);
          continue;
          ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71706);
      String str = (String)paramVarArgs[0];
      paramVarArgs = (String)paramVarArgs[1];
      b.G(b.this).putString(a.DGo, str);
      b.H(b.this).putString(a.DGp, paramVarArgs);
      paramVarArgs = new y("", str, null);
      this.LVJ.b(paramVarArgs, true);
      AppMethodBeat.o(71706);
      return true;
    }
  }
  
  final class b
    extends com.tencent.mm.wallet_core.d.g
  {
    public b(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71712);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      ae.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71712);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71711);
      if ((paramn instanceof e))
      {
        this.LVJ.removeSceneEndListener(1958);
        paramn = (e)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.DGK.oGt == 0)
          {
            paramString = new Bundle();
            ae.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramn.DGK.FVK, Boolean.valueOf(paramn.DGK.HrU) });
            b.d(b.this).putString(a.DGg, paramn.DGK.FVK);
            if (paramn.DGK.HrU) {
              paramString.putBoolean(a.DGw, true);
            }
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71711);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGK.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGK.oGt, paramn.DGK.oGu)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGK.oGu, paramn.phe, paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71708);
                b.this.b(b.b.this.activity, null);
                b.b.this.activity.finish();
                AppMethodBeat.o(71708);
              }
            });
            continue;
            ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71709);
                b.this.b(b.b.this.activity, null);
                b.b.this.activity.finish();
                AppMethodBeat.o(71709);
              }
            });
          }
        }
      }
      AppMethodBeat.o(71711);
      return false;
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71710);
      paramVarArgs = (String)paramVarArgs[0];
      int i = b.a(b.this).getInt(a.DGe);
      this.LVJ.addSceneEndListener(1958);
      e locale = new e(b.b(b.this), paramVarArgs, i, null);
      this.LVJ.b(locale, true);
      b.c(b.this).putString("key_pwd1", paramVarArgs);
      AppMethodBeat.o(71710);
      return true;
    }
  }
  
  final class c
    extends com.tencent.mm.wallet_core.d.g
  {
    public c(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71719);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      ae.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71719);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71718);
      if ((paramn instanceof e))
      {
        this.LVJ.removeSceneEndListener(1958);
        paramn = (e)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.DGK.oGt == 0)
          {
            paramString = new Bundle();
            ae.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramn.DGK.FVK });
            b.f(b.this).putString(a.DGg, paramn.DGK.FVK);
            ae.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramn.token, Boolean.valueOf(paramn.DGK.HrT), Boolean.valueOf(paramn.DGK.HrU) });
            if (!bu.isNullOrNil(paramn.token)) {
              paramString.putBoolean(a.DGh, paramn.DGK.HrT);
            }
            if (paramn.DGK.HrU) {
              paramString.putBoolean(a.DGw, true);
            }
            paramString.putInt("key_ecard_proxy_action", 1);
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71718);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGK.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGK.oGt, paramn.DGK.oGu)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGK.oGu, paramn.phe, paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71713);
                b.this.b(b.c.this.activity, null);
                AppMethodBeat.o(71713);
              }
            });
            continue;
            ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71714);
                b.this.b(b.c.this.activity, null);
                AppMethodBeat.o(71714);
              }
            });
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LVJ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.DGG.oGt == 0)
          {
            b.g(b.this).putInt(a.DGi, a.DGz);
            b.h(b.this).putString(a.DGl, paramn.DGH);
            b.i(b.this).putString(a.DGm, paramn.DGI);
            b.j(b.this).putString(a.DGn, paramn.DGJ);
            paramString = new Bundle();
            if (paramn.DGG.FVN != null)
            {
              ae.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.DGt, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.k(b.this).putByteArray(a.DGx, paramn.DGG.FVN.toByteArray());
            paramString.putInt("key_ecard_proxy_action", 2);
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71718);
            return true;
          }
          catch (IOException paramn)
          {
            ae.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          ae.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.DGt, true);
          paramString.putString(a.DGr, paramn.DGG.FVL);
          paramString.putString(a.DGs, paramn.DGG.HrZ);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGG.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGG.oGt, paramn.DGG.oGu)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGG.oGu, paramn.phe, paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71715);
                b.this.b(b.c.this.activity, null);
                AppMethodBeat.o(71715);
              }
            });
            continue;
            ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71716);
                b.this.b(b.c.this.activity, null);
                AppMethodBeat.o(71716);
              }
            });
          }
        }
      }
      AppMethodBeat.o(71718);
      return false;
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71717);
      int i;
      if (((Integer)paramVarArgs[0]).intValue() == 1)
      {
        ae.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
        i = ((Integer)paramVarArgs[1]).intValue();
        paramVarArgs = (String)paramVarArgs[2];
        this.LVJ.addSceneEndListener(1958);
        paramVarArgs = new e(b.b(b.this), null, i, paramVarArgs);
        this.LVJ.b(paramVarArgs, true);
      }
      for (;;)
      {
        AppMethodBeat.o(71717);
        return true;
        ae.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
        i = ((Integer)paramVarArgs[1]).intValue();
        this.LVJ.addSceneEndListener(1985);
        paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), i);
        this.LVJ.b(paramVarArgs, true);
      }
    }
  }
  
  final class d
    extends com.tencent.mm.wallet_core.d.g
  {
    com.tencent.mm.ui.widget.a.d jxa;
    
    public d(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    final void a(bqn parambqn, TextView paramTextView)
    {
      AppMethodBeat.i(71724);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((parambqn.HdV != null) && (!bu.isNullOrNil(parambqn.HdV.desc)))
      {
        localSpannableStringBuilder.append(parambqn.HdV.desc);
        if (!bu.isNullOrNil(parambqn.HdV.hDr)) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wallet_core.utils.g.cp(parambqn.HdV.hDr, false)), 0, localSpannableStringBuilder.length(), 18);
        }
      }
      if ((parambqn.HdW != null) && (!bu.isNullOrNil(parambqn.HdW.desc)))
      {
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(parambqn.HdW.desc);
        localSpannableStringBuilder.setSpan(new q(parambqn.HdW.hDr, new q.a()
        {
          public final void dN(View paramAnonymousView)
          {
            AppMethodBeat.i(71720);
            ae.d("MicroMsg.OpenECardProcess", "click span");
            b.d.this.jxa.dismiss();
            if ((b.d.this.activity instanceof WalletECardBindCardListUI)) {
              ((WalletECardBindCardListUI)b.d.this.activity).eMF();
            }
            AppMethodBeat.o(71720);
          }
        }), i, localSpannableStringBuilder.length(), 18);
      }
      paramTextView.setText(localSpannableStringBuilder);
      AppMethodBeat.o(71724);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71725);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LVJ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.DGG.oGt == 0) {
            if (paramn.DGG.Hsa != null)
            {
              ae.i("MicroMsg.OpenECardProcess", "show input alert");
              paramString = paramn.DGG.Hsa;
              if (this.jxa == null)
              {
                View localView = View.inflate(this.activity, 2131493736, null);
                final EditText localEditText = (EditText)localView.findViewById(2131299482);
                final TextView localTextView = (TextView)localView.findViewById(2131299483);
                localTextView.setClickable(true);
                localTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this.activity));
                if (!bu.isNullOrNil(paramString.HdU)) {
                  localEditText.setHint(paramn.DGG.Hsa.HdU);
                }
                d.a locala = new d.a(this.activity);
                locala.aZh(paramn.DGG.Hsa.HdT);
                locala.afP(4);
                locala.hd(localView);
                if (!bu.isNullOrNil(paramString.HdY)) {
                  locala.aZo(paramString.HdY);
                }
                if (!bu.isNullOrNil(paramString.HdX)) {
                  locala.aZp(paramString.HdX);
                }
                locala.a(false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(71721);
                    ae.i("MicroMsg.OpenECardProcess", "click verify btn");
                    paramAnonymousDialogInterface = localEditText.getText().toString();
                    if (paramAnonymousDialogInterface.length() == 11)
                    {
                      b.d.this.LVJ.addSceneEndListener(1985);
                      cfh localcfh = (cfh)((com.tencent.mm.ak.b)paramn.getReqResp()).hQD.hQJ;
                      b.o(b.this).putInt(a.DGB, 2);
                      paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), localcfh.FVK, localcfh.HrV, paramAnonymousDialogInterface, localcfh.dlT, b.n(b.this), true, 2, localcfh.HrY);
                      b.d.this.LVJ.a(paramAnonymousDialogInterface, true, 1);
                      AppMethodBeat.o(71721);
                      return;
                    }
                    paramAnonymousDialogInterface = new bqn();
                    paramAnonymousDialogInterface.HdV = new aet();
                    paramAnonymousDialogInterface.HdV.desc = b.d.this.activity.getString(2131758163);
                    paramAnonymousDialogInterface.HdV.hDr = "#FA5151";
                    paramAnonymousDialogInterface.HdW = new aet();
                    paramAnonymousDialogInterface.HdW.desc = b.d.this.activity.getString(2131758162);
                    paramAnonymousDialogInterface.HdW.hDr = "#0C4F8E";
                    b.d.this.a(paramAnonymousDialogInterface, localTextView);
                    AppMethodBeat.o(71721);
                  }
                });
                locala.zf(false);
                locala.a(new DialogInterface.OnDismissListener()
                {
                  public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(71722);
                    ae.i("MicroMsg.OpenECardProcess", "dismiss alert");
                    b.d.this.jxa = null;
                    AppMethodBeat.o(71722);
                  }
                });
                this.jxa = locala.fQv();
                a(paramString, localTextView);
                this.jxa.show();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71725);
          return true;
          a(paramString, (TextView)this.jxa.findViewById(2131299483));
          continue;
          b.p(b.this).putInt(a.DGi, a.DGz);
          b.q(b.this).putString(a.DGl, paramn.DGH);
          b.r(b.this).putString(a.DGm, paramn.DGI);
          b.s(b.this).putString(a.DGn, paramn.DGJ);
          paramString = new Bundle();
          if (paramn.DGG.FVN != null)
          {
            ae.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.DGt, false);
          }
          for (;;)
          {
            try
            {
              b.t(b.this).putByteArray(a.DGx, paramn.DGG.FVN.toByteArray());
              b.this.a(this.activity, 0, paramString);
            }
            catch (IOException paramn)
            {
              ae.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
              continue;
            }
            ae.i("MicroMsg.OpenECardProcess", "need verfiy sms");
            paramString.putBoolean(a.DGt, true);
            paramString.putString(a.DGr, paramn.DGG.FVL);
            paramString.putString(a.DGs, paramn.DGG.HrZ);
          }
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGG.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGG.oGt, paramn.DGG.oGu)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGG.oGu, paramn.phe, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71725);
      return false;
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71723);
      paramVarArgs = (ir)paramVarArgs[0];
      String str1 = b.l(b.this).getString(a.DGg, "");
      if (paramVarArgs == null)
      {
        ae.w("MicroMsg.OpenECardProcess", "empty bank item");
        AppMethodBeat.o(71723);
        return false;
      }
      this.LVJ.addSceneEndListener(1985);
      String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.uVs, paramVarArgs.oOZ, paramVarArgs.FTY });
      b.m(b.this).putInt(a.DGB, 1);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), str1, paramVarArgs.FTZ, paramVarArgs.DgJ, paramVarArgs.dlT, b.n(b.this), true, 1, str2);
      this.LVJ.a(paramVarArgs, true, 1);
      AppMethodBeat.o(71723);
      return true;
    }
  }
  
  final class e
    extends com.tencent.mm.wallet_core.d.g
  {
    public e(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71727);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LVJ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.DGG.oGt == 0)
          {
            paramString = new Bundle();
            if (paramn.DGG.FVN != null)
            {
              ae.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.DGt, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.O(b.this).putByteArray(a.DGx, paramn.DGG.FVN.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71727);
            return true;
          }
          catch (IOException paramn)
          {
            ae.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          ae.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.DGt, true);
          paramString.putString(a.DGr, paramn.DGG.FVL);
          paramString.putString(a.DGs, paramn.DGG.HrZ);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGG.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGG.oGt, paramn.DGG.oGu)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGG.oGu, paramn.phe, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71727);
      return false;
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71726);
      paramVarArgs = ((ElementQuery)paramVarArgs[0]).dlT;
      String str1 = b.M(b.this).getString(a.DGo);
      String str2 = b.N(b.this).getString(a.DGp);
      this.LVJ.addSceneEndListener(1985);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), str1, str2, paramVarArgs, b.n(b.this), false, 0, "");
      this.LVJ.b(paramVarArgs, true);
      AppMethodBeat.o(71726);
      return true;
    }
  }
  
  final class f
    extends com.tencent.mm.wallet_core.d.g
  {
    public f(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71729);
      if ((paramn instanceof ag))
      {
        ae.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        ag localag = (ag)paramn;
        Bundle localBundle = new Bundle();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = localag.CQc;
          if (paramString.oGt == 0)
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
          ae.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.oGu });
          Toast.makeText(this.activity, paramString.oGu, 1).show();
          continue;
          ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      AppMethodBeat.o(71729);
      return false;
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71728);
      ((Integer)paramVarArgs[0]).intValue();
      paramVarArgs = (String)paramVarArgs[1];
      this.LVJ.addSceneEndListener(2996);
      paramVarArgs = new ag(b.b(b.this), paramVarArgs);
      this.LVJ.b(paramVarArgs, true);
      AppMethodBeat.o(71728);
      return false;
    }
  }
  
  final class g
    extends com.tencent.mm.wallet_core.d.g
  {
    public g(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean A(Object... paramVarArgs)
    {
      AppMethodBeat.i(71731);
      int i = b.u(b.this).getInt(a.DGi);
      paramVarArgs = b.e(b.this);
      int j = b.v(b.this).getInt(a.DGB);
      ae.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      String str1;
      String str2;
      String str3;
      if (i == a.DGz)
      {
        str1 = b.w(b.this).getString(a.DGl);
        str2 = b.x(b.this).getString(a.DGm);
        str3 = b.y(b.this).getString(a.DGn);
      }
      for (paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), true, true, j, "");; paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), false, true, j, ""))
      {
        this.LVJ.addSceneEndListener(1985);
        this.LVJ.b(paramVarArgs, true);
        AppMethodBeat.o(71731);
        return true;
        str1 = b.z(b.this).getString(a.DGo);
        str2 = b.A(b.this).getString(a.DGp);
        str3 = b.B(b.this).getString(a.DGq);
      }
    }
    
    public final CharSequence getTips(int paramInt)
    {
      AppMethodBeat.i(71730);
      String str = this.activity.getIntent().getStringExtra(a.DGs);
      AppMethodBeat.o(71730);
      return str;
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71734);
      ae.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      b.this.b(this.activity, new Bundle());
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(71734);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71733);
      if ((paramn instanceof c))
      {
        this.LVJ.removeSceneEndListener(1986);
        paramn = (c)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramn.DGF.oGt != 0) {
            break label155;
          }
          paramString = new Bundle();
          if (paramn.DGF.FVN != null) {
            ae.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramn.DGF.FVN.title });
          }
        }
        for (;;)
        {
          try
          {
            b.F(b.this).putByteArray(a.DGx, paramn.DGF.FVN.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71733);
            return true;
          }
          catch (IOException paramn)
          {
            ae.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          label155:
          if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGF.FVM))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGF.oGu, paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LVJ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.DGG.oGt == 0) {
            this.activity.getIntent().putExtra(a.DGr, paramn.DGG.FVL);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71733);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DGG.FVM)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dmy, paramn.phe, paramn.DGG.oGt, paramn.DGG.oGu)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DGG.oGu, paramn.phe, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ae.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71733);
      return false;
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71732);
      b.C(b.this).getString("key_pwd1");
      paramVarArgs = b.D(b.this).getString("key_verify_code");
      String str1 = b.e(b.this);
      int i = b.E(b.this).getInt(a.DGe);
      String str2 = this.activity.getIntent().getStringExtra(a.DGr);
      paramVarArgs = new c(b.b(b.this), str1, paramVarArgs, str2, i);
      this.LVJ.addSceneEndListener(1986);
      this.LVJ.a(paramVarArgs, true, 3);
      AppMethodBeat.o(71732);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */