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
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b
  extends com.tencent.mm.wallet_core.d
{
  private int cGP()
  {
    AppMethodBeat.i(71742);
    int i = this.dmf.getInt(a.BOg);
    AppMethodBeat.o(71742);
    return i;
  }
  
  private String euQ()
  {
    AppMethodBeat.i(71741);
    String str = this.dmf.getString(a.BOi);
    AppMethodBeat.o(71741);
    return str;
  }
  
  private void h(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71737);
    ac.m("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(cGP()) });
    if (cGP() == 3)
    {
      paramBundle.putInt(a.BOg, 3);
      paramBundle.putString(a.BOm, this.dmf.getString(a.BOm, ""));
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
    ac.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(cGP()) });
    AppMethodBeat.o(71735);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71736);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(a.BOy, false))
      {
        ac.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.dmf.putBoolean(a.BOy, true);
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
      if (this.dmf.getInt(a.BOk, a.BOB) == a.BOB)
      {
        if (paramBundle.getBoolean(a.BOv))
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
        bool1 = paramBundle.getBoolean(a.BOw, false);
        boolean bool2 = paramBundle.getBoolean(a.BOv);
        ac.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
          if (paramBundle.getBoolean(a.BOv))
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
        bool1 = paramBundle.getBoolean(a.BOj, false);
        this.dmf.putBoolean(a.BOj, bool1);
        String str = this.dmf.getString(a.BOh);
        paramInt = cGP();
        int i = paramBundle.getInt("key_ecard_proxy_action", 1);
        ac.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bs.isNullOrNil(str)), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i == 1)
        {
          if (!bs.isNullOrNil(str))
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
        if (paramBundle.getBoolean(a.BOv))
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
    ac.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[] { paramActivity });
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
  
  public final String cHN()
  {
    return "OpenECardProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71738);
    if (paramInt == 100)
    {
      ac.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = cGP();
      String str1 = euQ();
      String str2 = (String)this.dmf.get("key_pwd1");
      this.dmf.clear();
      this.dmf.putInt(a.BOg, paramInt);
      this.dmf.putString(a.BOi, str1);
      this.dmf.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(71738);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.dmf.getInt(a.BOk) == a.BOB)
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
    ac.d("MicroMsg.OpenECardProcess", "intercept");
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
          if ((paramn.BoT != null) && (paramn.BoT.BvW))
          {
            paramString = b.I(b.this).getString(a.BOq);
            str = b.J(b.this).getString(a.BOr);
            paramn = paramn.BoT.cZz;
            b.K(b.this).putString(a.BOs, paramn);
            this.JFQ.addSceneEndListener(1985);
            paramString = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), paramString, str, paramn, b.n(b.this), false, 0, "");
            this.JFQ.b(paramString, true);
          }
        }
      }
      while (!(paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
        for (;;)
        {
          String str;
          AppMethodBeat.o(71707);
          return false;
          paramString.putBoolean(a.BOw, true);
          b.this.a(this.activity, 0, paramString);
          continue;
          ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      this.JFQ.removeSceneEndListener(1985);
      paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramn.BOI.nWx == 0)
        {
          paramString = new Bundle();
          paramString.putBoolean(a.BOw, false);
          if ((paramn.BOI.DXW != null) && (!bs.isNullOrNil(paramn.BOI.DXW.title)))
          {
            ac.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.BOv, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.L(b.this).putByteArray(a.BOz, paramn.BOI.DXW.toByteArray());
          b.this.a(this.activity, 0, paramString);
          AppMethodBeat.o(71707);
          return true;
        }
        catch (IOException paramn)
        {
          ac.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
          continue;
        }
        ac.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(a.BOv, true);
        paramString.putString(a.BOt, paramn.BOI.DXU);
        paramString.putString(a.BOu, paramn.BOI.FoM);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOI.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOI.nWx, paramn.BOI.nWy)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOI.nWy, paramn.oxf, paramString });
          h.c(this.activity, paramString, "", false);
          continue;
          ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
    }
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71706);
      String str = (String)paramVarArgs[0];
      paramVarArgs = (String)paramVarArgs[1];
      b.G(b.this).putString(a.BOq, str);
      b.H(b.this).putString(a.BOr, paramVarArgs);
      paramVarArgs = new y("", str, null);
      this.JFQ.b(paramVarArgs, true);
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
      ac.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        this.JFQ.removeSceneEndListener(1958);
        paramn = (e)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.BOM.nWx == 0)
          {
            paramString = new Bundle();
            ac.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramn.BOM.DXT, Boolean.valueOf(paramn.BOM.FoH) });
            b.d(b.this).putString(a.BOi, paramn.BOM.DXT);
            if (paramn.BOM.FoH) {
              paramString.putBoolean(a.BOy, true);
            }
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71711);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOM.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOM.nWx, paramn.BOM.nWy)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOM.nWy, paramn.oxf, paramString });
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
            ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71710);
      paramVarArgs = (String)paramVarArgs[0];
      int i = b.a(b.this).getInt(a.BOg);
      this.JFQ.addSceneEndListener(1958);
      e locale = new e(b.b(b.this), paramVarArgs, i, null);
      this.JFQ.b(locale, true);
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
      ac.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        this.JFQ.removeSceneEndListener(1958);
        paramn = (e)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.BOM.nWx == 0)
          {
            paramString = new Bundle();
            ac.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramn.BOM.DXT });
            b.f(b.this).putString(a.BOi, paramn.BOM.DXT);
            ac.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramn.token, Boolean.valueOf(paramn.BOM.FoG), Boolean.valueOf(paramn.BOM.FoH) });
            if (!bs.isNullOrNil(paramn.token)) {
              paramString.putBoolean(a.BOj, paramn.BOM.FoG);
            }
            if (paramn.BOM.FoH) {
              paramString.putBoolean(a.BOy, true);
            }
            paramString.putInt("key_ecard_proxy_action", 1);
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71718);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOM.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOM.nWx, paramn.BOM.nWy)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOM.nWy, paramn.oxf, paramString });
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
            ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
        this.JFQ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.BOI.nWx == 0)
          {
            b.g(b.this).putInt(a.BOk, a.BOB);
            b.h(b.this).putString(a.BOn, paramn.BOJ);
            b.i(b.this).putString(a.BOo, paramn.BOK);
            b.j(b.this).putString(a.BOp, paramn.BOL);
            paramString = new Bundle();
            if (paramn.BOI.DXW != null)
            {
              ac.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.BOv, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.k(b.this).putByteArray(a.BOz, paramn.BOI.DXW.toByteArray());
            paramString.putInt("key_ecard_proxy_action", 2);
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71718);
            return true;
          }
          catch (IOException paramn)
          {
            ac.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          ac.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.BOv, true);
          paramString.putString(a.BOt, paramn.BOI.DXU);
          paramString.putString(a.BOu, paramn.BOI.FoM);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOI.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOI.nWx, paramn.BOI.nWy)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOI.nWy, paramn.oxf, paramString });
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
            ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71717);
      int i;
      if (((Integer)paramVarArgs[0]).intValue() == 1)
      {
        ac.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
        i = ((Integer)paramVarArgs[1]).intValue();
        paramVarArgs = (String)paramVarArgs[2];
        this.JFQ.addSceneEndListener(1958);
        paramVarArgs = new e(b.b(b.this), null, i, paramVarArgs);
        this.JFQ.b(paramVarArgs, true);
      }
      for (;;)
      {
        AppMethodBeat.o(71717);
        return true;
        ac.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
        i = ((Integer)paramVarArgs[1]).intValue();
        this.JFQ.addSceneEndListener(1985);
        paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), i);
        this.JFQ.b(paramVarArgs, true);
      }
    }
  }
  
  final class d
    extends com.tencent.mm.wallet_core.d.g
  {
    com.tencent.mm.ui.widget.a.d jaW;
    
    public d(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    final void a(blk paramblk, TextView paramTextView)
    {
      AppMethodBeat.i(71724);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((paramblk.FaV != null) && (!bs.isNullOrNil(paramblk.FaV.desc)))
      {
        localSpannableStringBuilder.append(paramblk.FaV.desc);
        if (!bs.isNullOrNil(paramblk.FaV.hiu)) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wallet_core.utils.g.cd(paramblk.FaV.hiu, false)), 0, localSpannableStringBuilder.length(), 18);
        }
      }
      if ((paramblk.FaW != null) && (!bs.isNullOrNil(paramblk.FaW.desc)))
      {
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(paramblk.FaW.desc);
        localSpannableStringBuilder.setSpan(new q(paramblk.FaW.hiu, new q.a()
        {
          public final void dK(View paramAnonymousView)
          {
            AppMethodBeat.i(71720);
            ac.d("MicroMsg.OpenECardProcess", "click span");
            b.d.this.jaW.dismiss();
            if ((b.d.this.activity instanceof WalletECardBindCardListUI)) {
              ((WalletECardBindCardListUI)b.d.this.activity).euR();
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
        this.JFQ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.BOI.nWx == 0) {
            if (paramn.BOI.FoN != null)
            {
              ac.i("MicroMsg.OpenECardProcess", "show input alert");
              paramString = paramn.BOI.FoN;
              if (this.jaW == null)
              {
                View localView = View.inflate(this.activity, 2131493736, null);
                final EditText localEditText = (EditText)localView.findViewById(2131299482);
                final TextView localTextView = (TextView)localView.findViewById(2131299483);
                localTextView.setClickable(true);
                localTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this.activity));
                if (!bs.isNullOrNil(paramString.FaU)) {
                  localEditText.setHint(paramn.BOI.FoN.FaU);
                }
                d.a locala = new d.a(this.activity);
                locala.aRH(paramn.BOI.FoN.FaT);
                locala.acH(4);
                locala.gH(localView);
                if (!bs.isNullOrNil(paramString.FaY)) {
                  locala.aRO(paramString.FaY);
                }
                if (!bs.isNullOrNil(paramString.FaX)) {
                  locala.aRP(paramString.FaX);
                }
                locala.a(false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(71721);
                    ac.i("MicroMsg.OpenECardProcess", "click verify btn");
                    paramAnonymousDialogInterface = localEditText.getText().toString();
                    if (paramAnonymousDialogInterface.length() == 11)
                    {
                      b.d.this.JFQ.addSceneEndListener(1985);
                      bzw localbzw = (bzw)((com.tencent.mm.ak.b)paramn.getReqResp()).hvr.hvw;
                      b.o(b.this).putInt(a.BOD, 2);
                      paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), localbzw.DXT, localbzw.FoI, paramAnonymousDialogInterface, localbzw.cZz, b.n(b.this), true, 2, localbzw.FoL);
                      b.d.this.JFQ.a(paramAnonymousDialogInterface, true, 1);
                      AppMethodBeat.o(71721);
                      return;
                    }
                    paramAnonymousDialogInterface = new blk();
                    paramAnonymousDialogInterface.FaV = new ack();
                    paramAnonymousDialogInterface.FaV.desc = b.d.this.activity.getString(2131758163);
                    paramAnonymousDialogInterface.FaV.hiu = "#FA5151";
                    paramAnonymousDialogInterface.FaW = new ack();
                    paramAnonymousDialogInterface.FaW.desc = b.d.this.activity.getString(2131758162);
                    paramAnonymousDialogInterface.FaW.hiu = "#0C4F8E";
                    b.d.this.a(paramAnonymousDialogInterface, localTextView);
                    AppMethodBeat.o(71721);
                  }
                });
                locala.yf(false);
                locala.a(new DialogInterface.OnDismissListener()
                {
                  public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(71722);
                    ac.i("MicroMsg.OpenECardProcess", "dismiss alert");
                    b.d.this.jaW = null;
                    AppMethodBeat.o(71722);
                  }
                });
                this.jaW = locala.fvp();
                a(paramString, localTextView);
                this.jaW.show();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71725);
          return true;
          a(paramString, (TextView)this.jaW.findViewById(2131299483));
          continue;
          b.p(b.this).putInt(a.BOk, a.BOB);
          b.q(b.this).putString(a.BOn, paramn.BOJ);
          b.r(b.this).putString(a.BOo, paramn.BOK);
          b.s(b.this).putString(a.BOp, paramn.BOL);
          paramString = new Bundle();
          if (paramn.BOI.DXW != null)
          {
            ac.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.BOv, false);
          }
          for (;;)
          {
            try
            {
              b.t(b.this).putByteArray(a.BOz, paramn.BOI.DXW.toByteArray());
              b.this.a(this.activity, 0, paramString);
            }
            catch (IOException paramn)
            {
              ac.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
              continue;
            }
            ac.i("MicroMsg.OpenECardProcess", "need verfiy sms");
            paramString.putBoolean(a.BOv, true);
            paramString.putString(a.BOt, paramn.BOI.DXU);
            paramString.putString(a.BOu, paramn.BOI.FoM);
          }
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOI.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOI.nWx, paramn.BOI.nWy)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOI.nWy, paramn.oxf, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71725);
      return false;
    }
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71723);
      paramVarArgs = (ik)paramVarArgs[0];
      String str1 = b.l(b.this).getString(a.BOi, "");
      if (paramVarArgs == null)
      {
        ac.w("MicroMsg.OpenECardProcess", "empty bank item");
        AppMethodBeat.o(71723);
        return false;
      }
      this.JFQ.addSceneEndListener(1985);
      String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.tGS, paramVarArgs.ofd, paramVarArgs.DWh });
      b.m(b.this).putInt(a.BOD, 1);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), str1, paramVarArgs.DWi, paramVarArgs.BoQ, paramVarArgs.cZz, b.n(b.this), true, 1, str2);
      this.JFQ.a(paramVarArgs, true, 1);
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
        this.JFQ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.BOI.nWx == 0)
          {
            paramString = new Bundle();
            if (paramn.BOI.DXW != null)
            {
              ac.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.BOv, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.O(b.this).putByteArray(a.BOz, paramn.BOI.DXW.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71727);
            return true;
          }
          catch (IOException paramn)
          {
            ac.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          ac.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.BOv, true);
          paramString.putString(a.BOt, paramn.BOI.DXU);
          paramString.putString(a.BOu, paramn.BOI.FoM);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOI.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOI.nWx, paramn.BOI.nWy)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOI.nWy, paramn.oxf, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71727);
      return false;
    }
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71726);
      paramVarArgs = ((ElementQuery)paramVarArgs[0]).cZz;
      String str1 = b.M(b.this).getString(a.BOq);
      String str2 = b.N(b.this).getString(a.BOr);
      this.JFQ.addSceneEndListener(1985);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), str1, str2, paramVarArgs, b.n(b.this), false, 0, "");
      this.JFQ.b(paramVarArgs, true);
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
        ac.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        ag localag = (ag)paramn;
        Bundle localBundle = new Bundle();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = localag.AYo;
          if (paramString.nWx == 0)
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
          ac.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.nWy });
          Toast.makeText(this.activity, paramString.nWy, 1).show();
          continue;
          ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      AppMethodBeat.o(71729);
      return false;
    }
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71728);
      ((Integer)paramVarArgs[0]).intValue();
      paramVarArgs = (String)paramVarArgs[1];
      this.JFQ.addSceneEndListener(2996);
      paramVarArgs = new ag(b.b(b.this), paramVarArgs);
      this.JFQ.b(paramVarArgs, true);
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
      int i = b.u(b.this).getInt(a.BOk);
      paramVarArgs = b.e(b.this);
      int j = b.v(b.this).getInt(a.BOD);
      ac.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      String str1;
      String str2;
      String str3;
      if (i == a.BOB)
      {
        str1 = b.w(b.this).getString(a.BOn);
        str2 = b.x(b.this).getString(a.BOo);
        str3 = b.y(b.this).getString(a.BOp);
      }
      for (paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), true, true, j, "");; paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), false, true, j, ""))
      {
        this.JFQ.addSceneEndListener(1985);
        this.JFQ.b(paramVarArgs, true);
        AppMethodBeat.o(71731);
        return true;
        str1 = b.z(b.this).getString(a.BOq);
        str2 = b.A(b.this).getString(a.BOr);
        str3 = b.B(b.this).getString(a.BOs);
      }
    }
    
    public final CharSequence getTips(int paramInt)
    {
      AppMethodBeat.i(71730);
      String str = this.activity.getIntent().getStringExtra(a.BOu);
      AppMethodBeat.o(71730);
      return str;
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71734);
      ac.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      b.this.b(this.activity, new Bundle());
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(71734);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(71733);
      if ((paramn instanceof c))
      {
        this.JFQ.removeSceneEndListener(1986);
        paramn = (c)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramn.BOH.nWx != 0) {
            break label155;
          }
          paramString = new Bundle();
          if (paramn.BOH.DXW != null) {
            ac.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramn.BOH.DXW.title });
          }
        }
        for (;;)
        {
          try
          {
            b.F(b.this).putByteArray(a.BOz, paramn.BOH.DXW.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71733);
            return true;
          }
          catch (IOException paramn)
          {
            ac.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          label155:
          if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOH.DXV))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOH.nWy, paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.JFQ.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.BOI.nWx == 0) {
            this.activity.getIntent().putExtra(a.BOt, paramn.BOI.DXU);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71733);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.BOI.DXV)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dae, paramn.oxf, paramn.BOI.nWx, paramn.BOI.nWy)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.BOI.nWy, paramn.oxf, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ac.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      AppMethodBeat.o(71733);
      return false;
    }
    
    public final boolean s(Object... paramVarArgs)
    {
      AppMethodBeat.i(71732);
      b.C(b.this).getString("key_pwd1");
      paramVarArgs = b.D(b.this).getString("key_verify_code");
      String str1 = b.e(b.this);
      int i = b.E(b.this).getInt(a.BOg);
      String str2 = this.activity.getIntent().getStringExtra(a.BOt);
      paramVarArgs = new c(b.b(b.this), str1, paramVarArgs, str2, i);
      this.JFQ.addSceneEndListener(1986);
      this.JFQ.a(paramVarArgs, true, 3);
      AppMethodBeat.o(71732);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */