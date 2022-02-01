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
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b
  extends com.tencent.mm.wallet_core.d
{
  private int cPe()
  {
    AppMethodBeat.i(71742);
    int i = this.dxT.getInt(a.Doy);
    AppMethodBeat.o(71742);
    return i;
  }
  
  private String eIW()
  {
    AppMethodBeat.i(71741);
    String str = this.dxT.getString(a.DoA);
    AppMethodBeat.o(71741);
    return str;
  }
  
  private void h(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71737);
    ad.m("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(cPe()) });
    if (cPe() == 3)
    {
      paramBundle.putInt(a.Doy, 3);
      paramBundle.putString(a.DoE, this.dxT.getString(a.DoE, ""));
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
    ad.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(cPe()) });
    AppMethodBeat.o(71735);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71736);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(a.DoQ, false))
      {
        ad.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.dxT.putBoolean(a.DoQ, true);
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
      if (this.dxT.getInt(a.DoC, a.DoT) == a.DoT)
      {
        if (paramBundle.getBoolean(a.DoN))
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
        bool1 = paramBundle.getBoolean(a.DoO, false);
        boolean bool2 = paramBundle.getBoolean(a.DoN);
        ad.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
          if (paramBundle.getBoolean(a.DoN))
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
        bool1 = paramBundle.getBoolean(a.DoB, false);
        this.dxT.putBoolean(a.DoB, bool1);
        String str = this.dxT.getString(a.Doz);
        paramInt = cPe();
        int i = paramBundle.getInt("key_ecard_proxy_action", 1);
        ad.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bt.isNullOrNil(str)), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i == 1)
        {
          if (!bt.isNullOrNil(str))
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
        if (paramBundle.getBoolean(a.DoN))
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
    ad.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[] { paramActivity });
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
  
  public final String cQc()
  {
    return "OpenECardProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71738);
    if (paramInt == 100)
    {
      ad.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = cPe();
      String str1 = eIW();
      String str2 = (String)this.dxT.get("key_pwd1");
      this.dxT.clear();
      this.dxT.putInt(a.Doy, paramInt);
      this.dxT.putString(a.DoA, str1);
      this.dxT.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(71738);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.dxT.getInt(a.DoC) == a.DoT)
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
    ad.d("MicroMsg.OpenECardProcess", "intercept");
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71707);
      if ((paramn instanceof y))
      {
        paramn = (y)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new Bundle();
          if ((paramn.CPi != null) && (paramn.CPi.CWm))
          {
            paramString = b.I(b.this).getString(a.DoI);
            str = b.J(b.this).getString(a.DoJ);
            paramn = paramn.CPi.dkR;
            b.K(b.this).putString(a.DoK, paramn);
            this.LyU.addSceneEndListener(1985);
            paramString = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), paramString, str, paramn, b.n(b.this), false, 0, "");
            this.LyU.b(paramString, true);
          }
        }
      }
      while (!(paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
        for (;;)
        {
          String str;
          AppMethodBeat.o(71707);
          return false;
          paramString.putBoolean(a.DoO, true);
          b.this.a(this.activity, 0, paramString);
          continue;
          ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      this.LyU.removeSceneEndListener(1985);
      paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramn.Dpa.ozR == 0)
        {
          paramString = new Bundle();
          paramString.putBoolean(a.DoO, false);
          if ((paramn.Dpa.FDs != null) && (!bt.isNullOrNil(paramn.Dpa.FDs.title)))
          {
            ad.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.DoN, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.L(b.this).putByteArray(a.DoR, paramn.Dpa.FDs.toByteArray());
          b.this.a(this.activity, 0, paramString);
          AppMethodBeat.o(71707);
          return true;
        }
        catch (IOException paramn)
        {
          ad.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
          continue;
        }
        ad.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(a.DoN, true);
        paramString.putString(a.DoL, paramn.Dpa.FDq);
        paramString.putString(a.DoM, paramn.Dpa.GYy);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpa.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpa.ozR, paramn.Dpa.ozS)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpa.ozS, paramn.paA, paramString });
          h.c(this.activity, paramString, "", false);
          continue;
          ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
      b.G(b.this).putString(a.DoI, str);
      b.H(b.this).putString(a.DoJ, paramVarArgs);
      paramVarArgs = new y("", str, null);
      this.LyU.b(paramVarArgs, true);
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
      ad.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71712);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71711);
      if ((paramn instanceof e))
      {
        this.LyU.removeSceneEndListener(1958);
        paramn = (e)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.Dpe.ozR == 0)
          {
            paramString = new Bundle();
            ad.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramn.Dpe.FDp, Boolean.valueOf(paramn.Dpe.GYt) });
            b.d(b.this).putString(a.DoA, paramn.Dpe.FDp);
            if (paramn.Dpe.GYt) {
              paramString.putBoolean(a.DoQ, true);
            }
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71711);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpe.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpe.ozR, paramn.Dpe.ozS)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpe.ozS, paramn.paA, paramString });
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
            ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
      int i = b.a(b.this).getInt(a.Doy);
      this.LyU.addSceneEndListener(1958);
      e locale = new e(b.b(b.this), paramVarArgs, i, null);
      this.LyU.b(locale, true);
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
      ad.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramIntent = new Bundle();
      paramIntent.putInt("key_process_result_code", 0);
      b.this.b(this.activity, paramIntent);
      AppMethodBeat.o(71719);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71718);
      if ((paramn instanceof e))
      {
        this.LyU.removeSceneEndListener(1958);
        paramn = (e)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.Dpe.ozR == 0)
          {
            paramString = new Bundle();
            ad.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramn.Dpe.FDp });
            b.f(b.this).putString(a.DoA, paramn.Dpe.FDp);
            ad.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramn.token, Boolean.valueOf(paramn.Dpe.GYs), Boolean.valueOf(paramn.Dpe.GYt) });
            if (!bt.isNullOrNil(paramn.token)) {
              paramString.putBoolean(a.DoB, paramn.Dpe.GYs);
            }
            if (paramn.Dpe.GYt) {
              paramString.putBoolean(a.DoQ, true);
            }
            paramString.putInt("key_ecard_proxy_action", 1);
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71718);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpe.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpe.ozR, paramn.Dpe.ozS)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpe.ozS, paramn.paA, paramString });
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
            ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
        this.LyU.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.Dpa.ozR == 0)
          {
            b.g(b.this).putInt(a.DoC, a.DoT);
            b.h(b.this).putString(a.DoF, paramn.Dpb);
            b.i(b.this).putString(a.DoG, paramn.Dpc);
            b.j(b.this).putString(a.DoH, paramn.Dpd);
            paramString = new Bundle();
            if (paramn.Dpa.FDs != null)
            {
              ad.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.DoN, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.k(b.this).putByteArray(a.DoR, paramn.Dpa.FDs.toByteArray());
            paramString.putInt("key_ecard_proxy_action", 2);
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71718);
            return true;
          }
          catch (IOException paramn)
          {
            ad.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          ad.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.DoN, true);
          paramString.putString(a.DoL, paramn.Dpa.FDq);
          paramString.putString(a.DoM, paramn.Dpa.GYy);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpa.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpa.ozR, paramn.Dpa.ozS)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpa.ozS, paramn.paA, paramString });
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
            ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
        ad.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
        i = ((Integer)paramVarArgs[1]).intValue();
        paramVarArgs = (String)paramVarArgs[2];
        this.LyU.addSceneEndListener(1958);
        paramVarArgs = new e(b.b(b.this), null, i, paramVarArgs);
        this.LyU.b(paramVarArgs, true);
      }
      for (;;)
      {
        AppMethodBeat.o(71717);
        return true;
        ad.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
        i = ((Integer)paramVarArgs[1]).intValue();
        this.LyU.addSceneEndListener(1985);
        paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), i);
        this.LyU.b(paramVarArgs, true);
      }
    }
  }
  
  final class d
    extends com.tencent.mm.wallet_core.d.g
  {
    com.tencent.mm.ui.widget.a.d juf;
    
    public d(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    final void a(bpu parambpu, TextView paramTextView)
    {
      AppMethodBeat.i(71724);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((parambpu.GKu != null) && (!bt.isNullOrNil(parambpu.GKu.desc)))
      {
        localSpannableStringBuilder.append(parambpu.GKu.desc);
        if (!bt.isNullOrNil(parambpu.GKu.hAD)) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wallet_core.utils.g.cl(parambpu.GKu.hAD, false)), 0, localSpannableStringBuilder.length(), 18);
        }
      }
      if ((parambpu.GKv != null) && (!bt.isNullOrNil(parambpu.GKv.desc)))
      {
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(parambpu.GKv.desc);
        localSpannableStringBuilder.setSpan(new q(parambpu.GKv.hAD, new q.a()
        {
          public final void dN(View paramAnonymousView)
          {
            AppMethodBeat.i(71720);
            ad.d("MicroMsg.OpenECardProcess", "click span");
            b.d.this.juf.dismiss();
            if ((b.d.this.activity instanceof WalletECardBindCardListUI)) {
              ((WalletECardBindCardListUI)b.d.this.activity).eIX();
            }
            AppMethodBeat.o(71720);
          }
        }), i, localSpannableStringBuilder.length(), 18);
      }
      paramTextView.setText(localSpannableStringBuilder);
      AppMethodBeat.o(71724);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71725);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LyU.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.Dpa.ozR == 0) {
            if (paramn.Dpa.GYz != null)
            {
              ad.i("MicroMsg.OpenECardProcess", "show input alert");
              paramString = paramn.Dpa.GYz;
              if (this.juf == null)
              {
                View localView = View.inflate(this.activity, 2131493736, null);
                final EditText localEditText = (EditText)localView.findViewById(2131299482);
                final TextView localTextView = (TextView)localView.findViewById(2131299483);
                localTextView.setClickable(true);
                localTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this.activity));
                if (!bt.isNullOrNil(paramString.GKt)) {
                  localEditText.setHint(paramn.Dpa.GYz.GKt);
                }
                d.a locala = new d.a(this.activity);
                locala.aXF(paramn.Dpa.GYz.GKs);
                locala.afg(4);
                locala.gY(localView);
                if (!bt.isNullOrNil(paramString.GKx)) {
                  locala.aXM(paramString.GKx);
                }
                if (!bt.isNullOrNil(paramString.GKw)) {
                  locala.aXN(paramString.GKw);
                }
                locala.a(false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(71721);
                    ad.i("MicroMsg.OpenECardProcess", "click verify btn");
                    paramAnonymousDialogInterface = localEditText.getText().toString();
                    if (paramAnonymousDialogInterface.length() == 11)
                    {
                      b.d.this.LyU.addSceneEndListener(1985);
                      cen localcen = (cen)((com.tencent.mm.al.b)paramn.getReqResp()).hNK.hNQ;
                      b.o(b.this).putInt(a.DoV, 2);
                      paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), localcen.FDp, localcen.GYu, paramAnonymousDialogInterface, localcen.dkR, b.n(b.this), true, 2, localcen.GYx);
                      b.d.this.LyU.a(paramAnonymousDialogInterface, true, 1);
                      AppMethodBeat.o(71721);
                      return;
                    }
                    paramAnonymousDialogInterface = new bpu();
                    paramAnonymousDialogInterface.GKu = new aek();
                    paramAnonymousDialogInterface.GKu.desc = b.d.this.activity.getString(2131758163);
                    paramAnonymousDialogInterface.GKu.hAD = "#FA5151";
                    paramAnonymousDialogInterface.GKv = new aek();
                    paramAnonymousDialogInterface.GKv.desc = b.d.this.activity.getString(2131758162);
                    paramAnonymousDialogInterface.GKv.hAD = "#0C4F8E";
                    b.d.this.a(paramAnonymousDialogInterface, localTextView);
                    AppMethodBeat.o(71721);
                  }
                });
                locala.yR(false);
                locala.a(new DialogInterface.OnDismissListener()
                {
                  public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(71722);
                    ad.i("MicroMsg.OpenECardProcess", "dismiss alert");
                    b.d.this.juf = null;
                    AppMethodBeat.o(71722);
                  }
                });
                this.juf = locala.fMb();
                a(paramString, localTextView);
                this.juf.show();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71725);
          return true;
          a(paramString, (TextView)this.juf.findViewById(2131299483));
          continue;
          b.p(b.this).putInt(a.DoC, a.DoT);
          b.q(b.this).putString(a.DoF, paramn.Dpb);
          b.r(b.this).putString(a.DoG, paramn.Dpc);
          b.s(b.this).putString(a.DoH, paramn.Dpd);
          paramString = new Bundle();
          if (paramn.Dpa.FDs != null)
          {
            ad.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.DoN, false);
          }
          for (;;)
          {
            try
            {
              b.t(b.this).putByteArray(a.DoR, paramn.Dpa.FDs.toByteArray());
              b.this.a(this.activity, 0, paramString);
            }
            catch (IOException paramn)
            {
              ad.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
              continue;
            }
            ad.i("MicroMsg.OpenECardProcess", "need verfiy sms");
            paramString.putBoolean(a.DoN, true);
            paramString.putString(a.DoL, paramn.Dpa.FDq);
            paramString.putString(a.DoM, paramn.Dpa.GYy);
          }
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpa.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpa.ozR, paramn.Dpa.ozS)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpa.ozS, paramn.paA, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
      paramVarArgs = (ir)paramVarArgs[0];
      String str1 = b.l(b.this).getString(a.DoA, "");
      if (paramVarArgs == null)
      {
        ad.w("MicroMsg.OpenECardProcess", "empty bank item");
        AppMethodBeat.o(71723);
        return false;
      }
      this.LyU.addSceneEndListener(1985);
      String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.uJF, paramVarArgs.oIx, paramVarArgs.FBD });
      b.m(b.this).putInt(a.DoV, 1);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), str1, paramVarArgs.FBE, paramVarArgs.CPf, paramVarArgs.dkR, b.n(b.this), true, 1, str2);
      this.LyU.a(paramVarArgs, true, 1);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71727);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LyU.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.Dpa.ozR == 0)
          {
            paramString = new Bundle();
            if (paramn.Dpa.FDs != null)
            {
              ad.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.DoN, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.O(b.this).putByteArray(a.DoR, paramn.Dpa.FDs.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71727);
            return true;
          }
          catch (IOException paramn)
          {
            ad.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          ad.i("MicroMsg.OpenECardProcess", "need verfiy sms");
          paramString.putBoolean(a.DoN, true);
          paramString.putString(a.DoL, paramn.Dpa.FDq);
          paramString.putString(a.DoM, paramn.Dpa.GYy);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpa.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpa.ozR, paramn.Dpa.ozS)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpa.ozS, paramn.paA, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
      paramVarArgs = ((ElementQuery)paramVarArgs[0]).dkR;
      String str1 = b.M(b.this).getString(a.DoI);
      String str2 = b.N(b.this).getString(a.DoJ);
      this.LyU.addSceneEndListener(1985);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), str1, str2, paramVarArgs, b.n(b.this), false, 0, "");
      this.LyU.b(paramVarArgs, true);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71729);
      if ((paramn instanceof ag))
      {
        ad.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        ag localag = (ag)paramn;
        Bundle localBundle = new Bundle();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = localag.Cyx;
          if (paramString.ozR == 0)
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
          ad.i("MicroMsg.OpenECardProcess", "toast: %s", new Object[] { paramString.ozS });
          Toast.makeText(this.activity, paramString.ozS, 1).show();
          continue;
          ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
      this.LyU.addSceneEndListener(2996);
      paramVarArgs = new ag(b.b(b.this), paramVarArgs);
      this.LyU.b(paramVarArgs, true);
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
      int i = b.u(b.this).getInt(a.DoC);
      paramVarArgs = b.e(b.this);
      int j = b.v(b.this).getInt(a.DoV);
      ad.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      String str1;
      String str2;
      String str3;
      if (i == a.DoT)
      {
        str1 = b.w(b.this).getString(a.DoF);
        str2 = b.x(b.this).getString(a.DoG);
        str3 = b.y(b.this).getString(a.DoH);
      }
      for (paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), true, true, j, "");; paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), false, true, j, ""))
      {
        this.LyU.addSceneEndListener(1985);
        this.LyU.b(paramVarArgs, true);
        AppMethodBeat.o(71731);
        return true;
        str1 = b.z(b.this).getString(a.DoI);
        str2 = b.A(b.this).getString(a.DoJ);
        str3 = b.B(b.this).getString(a.DoK);
      }
    }
    
    public final CharSequence getTips(int paramInt)
    {
      AppMethodBeat.i(71730);
      String str = this.activity.getIntent().getStringExtra(a.DoM);
      AppMethodBeat.o(71730);
      return str;
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(71734);
      ad.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      b.this.b(this.activity, new Bundle());
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(71734);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(71733);
      if ((paramn instanceof c))
      {
        this.LyU.removeSceneEndListener(1986);
        paramn = (c)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramn.DoZ.ozR != 0) {
            break label155;
          }
          paramString = new Bundle();
          if (paramn.DoZ.FDs != null) {
            ad.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramn.DoZ.FDs.title });
          }
        }
        for (;;)
        {
          try
          {
            b.F(b.this).putByteArray(a.DoR, paramn.DoZ.FDs.toByteArray());
            b.this.a(this.activity, 0, paramString);
            AppMethodBeat.o(71733);
            return true;
          }
          catch (IOException paramn)
          {
            ad.printErrStackTrace("MicroMsg.OpenECardProcess", paramn, "", new Object[0]);
            continue;
          }
          label155:
          if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.DoZ.FDr))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.DoZ.ozS, paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.LyU.removeSceneEndListener(1985);
        paramn = (com.tencent.mm.plugin.wallet_ecard.a.d)paramn;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramn.Dpa.ozR == 0) {
            this.activity.getIntent().putExtra(a.DoL, paramn.Dpa.FDq);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71733);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn.Dpa.FDr)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramn, paramn.dlw, paramn.paA, paramn.Dpa.ozR, paramn.Dpa.ozS)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, new String[] { paramn.Dpa.ozS, paramn.paA, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            ad.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramn });
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
      int i = b.E(b.this).getInt(a.Doy);
      String str2 = this.activity.getIntent().getStringExtra(a.DoL);
      paramVarArgs = new c(b.b(b.this), str1, paramVarArgs, str2, i);
      this.LyU.addSceneEndListener(1986);
      this.LyU.a(paramVarArgs, true, 3);
      AppMethodBeat.o(71732);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */