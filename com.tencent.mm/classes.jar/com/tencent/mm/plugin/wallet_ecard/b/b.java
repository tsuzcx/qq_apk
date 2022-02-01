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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_ecard.a.c;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b
  extends com.tencent.mm.wallet_core.d
{
  private int dJE()
  {
    AppMethodBeat.i(71742);
    int i = this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq);
    AppMethodBeat.o(71742);
    return i;
  }
  
  private String fUl()
  {
    AppMethodBeat.i(71741);
    String str = this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips);
    AppMethodBeat.o(71741);
    return str;
  }
  
  private void i(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71737);
    Log.printInfoStack("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(dJE()) });
    if (dJE() == 3)
    {
      paramBundle.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, 3);
      paramBundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipw, this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipw, ""));
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
    Log.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(dJE()) });
    AppMethodBeat.o(71735);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71736);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, false))
      {
        Log.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.dQL.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, true);
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
      if (this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu, com.tencent.mm.plugin.wallet_ecard.a.a.IpL) == com.tencent.mm.plugin.wallet_ecard.a.a.IpL)
      {
        if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF))
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
        bool1 = paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpG, false);
        boolean bool2 = paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF);
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
          if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF))
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
        bool1 = paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, false);
        this.dQL.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, bool1);
        String str = this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipr);
        paramInt = dJE();
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
        if (paramBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF))
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
  
  public final String dKC()
  {
    return "OpenECardProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71738);
    if (paramInt == 100)
    {
      Log.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = dJE();
      String str1 = fUl();
      String str2 = (String)this.dQL.get("key_pwd1");
      this.dQL.clear();
      this.dQL.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, paramInt);
      this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, str1);
      this.dQL.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(71738);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu) == com.tencent.mm.plugin.wallet_ecard.a.a.IpL)
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
    extends com.tencent.mm.wallet_core.d.g
  {
    public a(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71707);
      if ((paramq instanceof y))
      {
        paramq = (y)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new Bundle();
          if ((paramq.HQf != null) && (paramq.HQf.HXj))
          {
            paramString = b.I(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA);
            str = b.J(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB);
            paramq = paramq.HQf.dDj;
            b.K(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpC, paramq);
            this.Ruz.addSceneEndListener(1985);
            paramString = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), paramString, str, paramq, b.n(b.this), false, 0, "");
            this.Ruz.b(paramString, true);
          }
        }
      }
      while (!(paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
        for (;;)
        {
          String str;
          AppMethodBeat.o(71707);
          return false;
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpG, true);
          b.this.a(this.activity, 0, paramString);
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      this.Ruz.removeSceneEndListener(1985);
      paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramq.IpS.pTZ == 0)
        {
          paramString = new Bundle();
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpG, false);
          if ((paramq.IpS.KPy != null) && (!Util.isNullOrNil(paramq.IpS.KPy.title)))
          {
            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.L(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, paramq.IpS.KPy.toByteArray());
          b.this.a(this.activity, 0, paramString);
          AppMethodBeat.o(71707);
          return true;
        }
        catch (IOException paramq)
        {
          Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramq, "", new Object[0]);
          continue;
        }
        Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
        paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, paramq.IpS.KPw);
        paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, paramq.IpS.MAW);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpS.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpS.pTZ, paramq.IpS.pUa)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpS.pUa, paramq.qwn, paramString });
          h.c(this.activity, paramString, "", false);
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
      b.G(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA, str);
      b.H(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB, paramVarArgs);
      paramVarArgs = new y("", str, null);
      this.Ruz.b(paramVarArgs, true);
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
      Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71712);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71711);
      if ((paramq instanceof e))
      {
        this.Ruz.removeSceneEndListener(1958);
        paramq = (e)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.IpW.pTZ == 0)
          {
            paramString = new Bundle();
            Log.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramq.IpW.KPv, Boolean.valueOf(paramq.IpW.MAR) });
            b.d(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, paramq.IpW.KPv);
            if (paramq.IpW.MAR) {
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, true);
            }
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71711);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpW.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpW.pTZ, paramq.IpW.pUa)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpW.pUa, paramq.qwn, paramString });
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
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
      int i = b.a(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq);
      this.Ruz.addSceneEndListener(1958);
      e locale = new e(b.b(b.this), paramVarArgs, i, null);
      this.Ruz.b(locale, true);
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
      Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71719);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71718);
      if ((paramq instanceof e))
      {
        this.Ruz.removeSceneEndListener(1958);
        paramq = (e)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.IpW.pTZ == 0)
          {
            paramString = new Bundle();
            Log.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramq.IpW.KPv });
            b.f(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, paramq.IpW.KPv);
            Log.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramq.token, Boolean.valueOf(paramq.IpW.MAQ), Boolean.valueOf(paramq.IpW.MAR) });
            if (!Util.isNullOrNil(paramq.token)) {
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, paramq.IpW.MAQ);
            }
            if (paramq.IpW.MAR) {
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, true);
            }
            paramString.putInt("key_ecard_proxy_action", 1);
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71718);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpW.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpW.pTZ, paramq.IpW.pUa)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpW.pUa, paramq.qwn, paramString });
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
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.Ruz.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.IpS.pTZ == 0)
          {
            b.g(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu, com.tencent.mm.plugin.wallet_ecard.a.a.IpL);
            b.h(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipx, paramq.IpT);
            b.i(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipy, paramq.IpU);
            b.j(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipz, paramq.IpV);
            paramString = new Bundle();
            if (paramq.IpS.KPy != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.k(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, paramq.IpS.KPy.toByteArray());
            paramString.putInt("key_ecard_proxy_action", 2);
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71718);
            return true;
          }
          catch (IOException paramq)
          {
            Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramq, "", new Object[0]);
            continue;
          }
          Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, paramq.IpS.KPw);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, paramq.IpS.MAW);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpS.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpS.pTZ, paramq.IpS.pUa)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpS.pUa, paramq.qwn, paramString });
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
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
        Log.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
        i = ((Integer)paramVarArgs[1]).intValue();
        paramVarArgs = (String)paramVarArgs[2];
        this.Ruz.addSceneEndListener(1958);
        paramVarArgs = new e(b.b(b.this), null, i, paramVarArgs);
        this.Ruz.b(paramVarArgs, true);
      }
      for (;;)
      {
        AppMethodBeat.o(71717);
        return true;
        Log.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
        i = ((Integer)paramVarArgs[1]).intValue();
        this.Ruz.addSceneEndListener(1985);
        paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), i);
        this.Ruz.b(paramVarArgs, true);
      }
    }
  }
  
  final class d
    extends com.tencent.mm.wallet_core.d.g
  {
    com.tencent.mm.ui.widget.a.d kvo;
    
    public d(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    final void a(cdf paramcdf, TextView paramTextView)
    {
      AppMethodBeat.i(71724);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((paramcdf.MiY != null) && (!Util.isNullOrNil(paramcdf.MiY.desc)))
      {
        localSpannableStringBuilder.append(paramcdf.MiY.desc);
        if (!Util.isNullOrNil(paramcdf.MiY.ixw)) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wallet_core.utils.g.cI(paramcdf.MiY.ixw, false)), 0, localSpannableStringBuilder.length(), 18);
        }
      }
      if ((paramcdf.MiZ != null) && (!Util.isNullOrNil(paramcdf.MiZ.desc)))
      {
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(paramcdf.MiZ.desc);
        localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(paramcdf.MiZ.ixw, new q.a()
        {
          public final void dF(View paramAnonymousView)
          {
            AppMethodBeat.i(71720);
            Log.d("MicroMsg.OpenECardProcess", "click span");
            b.d.this.kvo.dismiss();
            if ((b.d.this.activity instanceof WalletECardBindCardListUI)) {
              ((WalletECardBindCardListUI)b.d.this.activity).fUm();
            }
            AppMethodBeat.o(71720);
          }
        }), i, localSpannableStringBuilder.length(), 18);
      }
      paramTextView.setText(localSpannableStringBuilder);
      AppMethodBeat.o(71724);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71725);
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.Ruz.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.IpS.pTZ == 0) {
            if (paramq.IpS.MAY != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "show input alert");
              paramString = paramq.IpS.MAY;
              if (this.kvo == null)
              {
                View localView = View.inflate(this.activity, 2131493871, null);
                final EditText localEditText = (EditText)localView.findViewById(2131300115);
                final TextView localTextView = (TextView)localView.findViewById(2131300116);
                localTextView.setClickable(true);
                localTextView.setOnTouchListener(new o(this.activity));
                if (!Util.isNullOrNil(paramString.MiX)) {
                  localEditText.setHint(paramq.IpS.MAY.MiX);
                }
                d.a locala = new d.a(this.activity);
                locala.bon(paramq.IpS.MAY.MiW);
                locala.aoQ(4);
                locala.hs(localView);
                if (!Util.isNullOrNil(paramString.Mjb)) {
                  locala.bou(paramString.Mjb);
                }
                if (!Util.isNullOrNil(paramString.Mja)) {
                  locala.bov(paramString.Mja);
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
                      b.d.this.Ruz.addSceneEndListener(1985);
                      cvo localcvo = (cvo)((com.tencent.mm.ak.d)paramq.getReqResp()).iLK.iLR;
                      b.o(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.IpN, 2);
                      paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), localcvo.KPv, localcvo.MAS, paramAnonymousDialogInterface, localcvo.dDj, b.n(b.this), true, 2, localcvo.MAV);
                      b.d.this.Ruz.a(paramAnonymousDialogInterface, true, 1);
                      AppMethodBeat.o(71721);
                      return;
                    }
                    paramAnonymousDialogInterface = new cdf();
                    paramAnonymousDialogInterface.MiY = new agx();
                    paramAnonymousDialogInterface.MiY.desc = b.d.this.activity.getString(2131758436);
                    paramAnonymousDialogInterface.MiY.ixw = "#FA5151";
                    paramAnonymousDialogInterface.MiZ = new agx();
                    paramAnonymousDialogInterface.MiZ.desc = b.d.this.activity.getString(2131758435);
                    paramAnonymousDialogInterface.MiZ.ixw = "#0C4F8E";
                    b.d.this.a(paramAnonymousDialogInterface, localTextView);
                    AppMethodBeat.o(71721);
                  }
                });
                locala.Dk(false);
                locala.a(new DialogInterface.OnDismissListener()
                {
                  public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(71722);
                    Log.i("MicroMsg.OpenECardProcess", "dismiss alert");
                    b.d.this.kvo = null;
                    AppMethodBeat.o(71722);
                  }
                });
                this.kvo = locala.hbn();
                a(paramString, localTextView);
                this.kvo.show();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71725);
          return true;
          a(paramString, (TextView)this.kvo.findViewById(2131300116));
          continue;
          b.p(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu, com.tencent.mm.plugin.wallet_ecard.a.a.IpL);
          b.q(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipx, paramq.IpT);
          b.r(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipy, paramq.IpU);
          b.s(b.this).putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipz, paramq.IpV);
          paramString = new Bundle();
          if (paramq.IpS.KPy != null)
          {
            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
          }
          for (;;)
          {
            try
            {
              b.t(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, paramq.IpS.KPy.toByteArray());
              b.this.a(this.activity, 0, paramString);
            }
            catch (IOException paramq)
            {
              Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramq, "", new Object[0]);
              continue;
            }
            Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
            paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
            paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, paramq.IpS.KPw);
            paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, paramq.IpS.MAW);
          }
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpS.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpS.pTZ, paramq.IpS.pUa)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpS.pUa, paramq.qwn, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
      paramVarArgs = (je)paramVarArgs[0];
      String str1 = b.l(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, "");
      if (paramVarArgs == null)
      {
        Log.w("MicroMsg.OpenECardProcess", "empty bank item");
        AppMethodBeat.o(71723);
        return false;
      }
      this.Ruz.addSceneEndListener(1985);
      String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.ynT, paramVarArgs.qcN, paramVarArgs.KNH });
      b.m(b.this).putInt(com.tencent.mm.plugin.wallet_ecard.a.a.IpN, 1);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), str1, paramVarArgs.KNI, paramVarArgs.HQc, paramVarArgs.dDj, b.n(b.this), true, 1, str2);
      this.Ruz.a(paramVarArgs, true, 1);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71727);
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.Ruz.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.IpS.pTZ == 0)
          {
            paramString = new Bundle();
            if (paramq.IpS.KPy != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.O(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, paramq.IpS.KPy.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71727);
            return true;
          }
          catch (IOException paramq)
          {
            Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramq, "", new Object[0]);
            continue;
          }
          Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, paramq.IpS.KPw);
          paramString.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, paramq.IpS.MAW);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpS.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpS.pTZ, paramq.IpS.pUa)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpS.pUa, paramq.qwn, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
      paramVarArgs = ((ElementQuery)paramVarArgs[0]).dDj;
      String str1 = b.M(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA);
      String str2 = b.N(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB);
      this.Ruz.addSceneEndListener(1985);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), str1, str2, paramVarArgs, b.n(b.this), false, 0, "");
      this.Ruz.b(paramVarArgs, true);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71729);
      if ((paramq instanceof ai))
      {
        Log.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Object localObject = (ai)paramq;
        Bundle localBundle = new Bundle();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((ai)localObject).HuV;
          if ((paramString.efB != null) && ((this.activity instanceof WalletOpenLqbProxyUI)))
          {
            paramq = (WalletOpenLqbProxyUI)this.activity;
            localObject = paramString.efB;
            if (paramq.Iqy != null) {
              paramq.Iqy.a((ckj)localObject, null);
            }
          }
          if (paramString.pTZ == 0)
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
          if (paramString.efB == null)
          {
            Log.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.pUa });
            Toast.makeText(this.activity, paramString.pUa, 1).show();
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
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
      this.Ruz.addSceneEndListener(2996);
      paramVarArgs = new ai(b.b(b.this), paramVarArgs);
      this.Ruz.b(paramVarArgs, true);
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
    
    public final boolean B(Object... paramVarArgs)
    {
      AppMethodBeat.i(71731);
      int i = b.u(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu);
      paramVarArgs = b.e(b.this);
      int j = b.v(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.IpN);
      Log.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      String str1;
      String str2;
      String str3;
      if (i == com.tencent.mm.plugin.wallet_ecard.a.a.IpL)
      {
        str1 = b.w(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipx);
        str2 = b.x(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipy);
        str3 = b.y(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipz);
      }
      for (paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), true, true, j, "");; paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), false, true, j, ""))
      {
        this.Ruz.addSceneEndListener(1985);
        this.Ruz.b(paramVarArgs, true);
        AppMethodBeat.o(71731);
        return true;
        str1 = b.z(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA);
        str2 = b.A(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB);
        str3 = b.B(b.this).getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpC);
      }
    }
    
    public final CharSequence getTips(int paramInt)
    {
      AppMethodBeat.i(71730);
      String str = this.activity.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.IpE);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(71733);
      if ((paramq instanceof c))
      {
        this.Ruz.removeSceneEndListener(1986);
        paramq = (c)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramq.IpR.pTZ != 0) {
            break label155;
          }
          paramString = new Bundle();
          if (paramq.IpR.KPy != null) {
            Log.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramq.IpR.KPy.title });
          }
        }
        for (;;)
        {
          try
          {
            b.F(b.this).putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, paramq.IpR.KPy.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71733);
            return true;
          }
          catch (IOException paramq)
          {
            Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramq, "", new Object[0]);
            continue;
          }
          label155:
          if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpR.KPx))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpR.pUa, paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.Ruz.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.IpS.pTZ == 0) {
            this.activity.getIntent().putExtra(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, paramq.IpS.KPw);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71733);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.IpS.KPx)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.dDN, paramq.qwn, paramq.IpS.pTZ, paramq.IpS.pUa)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramq.IpS.pUa, paramq.qwn, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
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
      int i = b.E(b.this).getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq);
      String str2 = this.activity.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.IpD);
      paramVarArgs = new c(b.b(b.this), str1, paramVarArgs, str2, i);
      this.Ruz.addSceneEndListener(1986);
      this.Ruz.a(paramVarArgs, true, 3);
      AppMethodBeat.o(71732);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */