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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.c;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.dez;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b
  extends com.tencent.mm.wallet_core.d
{
  private int eoe()
  {
    AppMethodBeat.i(71742);
    int i = this.fKb.getInt(a.PhY);
    AppMethodBeat.o(71742);
    return i;
  }
  
  private String gMR()
  {
    AppMethodBeat.i(71741);
    String str = this.fKb.getString(a.Pia);
    AppMethodBeat.o(71741);
    return str;
  }
  
  private void i(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(71737);
    Log.printInfoStack("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[] { Integer.valueOf(eoe()) });
    if (eoe() == 3)
    {
      paramBundle.putInt(a.PhY, 3);
      paramBundle.putString(a.Pie, this.fKb.getString(a.Pie, ""));
      b(paramActivity, WalletOpenLqbProxyUI.class, paramBundle);
      AppMethodBeat.o(71737);
      return;
    }
    b(paramActivity, WalletECardFinishUI.class, null);
    AppMethodBeat.o(71737);
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
      paramMMActivity = new b.f(this, paramMMActivity, parami);
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
    Log.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[] { Integer.valueOf(eoe()) });
    AppMethodBeat.o(71735);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(71736);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      if (paramBundle.getBoolean(a.Piq, false))
      {
        Log.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
        this.fKb.putBoolean(a.Piq, true);
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
      if (this.fKb.getInt(a.Pic, a.Pit) == a.Pit)
      {
        if (paramBundle.getBoolean(a.Pin))
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
        bool1 = paramBundle.getBoolean(a.Pio, false);
        boolean bool2 = paramBundle.getBoolean(a.Pin);
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
          if (paramBundle.getBoolean(a.Pin))
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
        bool1 = paramBundle.getBoolean(a.Pib, false);
        this.fKb.putBoolean(a.Pib, bool1);
        String str = this.fKb.getString(a.PhZ);
        paramInt = eoe();
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
        if (paramBundle.getBoolean(a.Pin))
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
  
  public final String epb()
  {
    return "OpenECardProcess";
  }
  
  public final void h(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(71738);
    if (paramInt == 100)
    {
      Log.i("MicroMsg.OpenECardProcess", "back to card list");
      paramInt = eoe();
      String str1 = gMR();
      String str2 = (String)this.fKb.get("key_pwd1");
      this.fKb.clear();
      this.fKb.putInt(a.PhY, paramInt);
      this.fKb.putString(a.Pia, str1);
      this.fKb.putString("key_pwd1", str2);
      a(paramActivity, WalletECardBindCardListUI.class, 0);
      AppMethodBeat.o(71738);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (this.fKb.getInt(a.Pic) == a.Pit)
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71707);
      if ((paramq instanceof z))
      {
        paramq = (z)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new Bundle();
          if ((paramq.OIo != null) && (paramq.OIo.OPj))
          {
            paramString = b.I(b.this).getString(a.Pii);
            str = b.J(b.this).getString(a.Pij);
            paramq = paramq.OIo.fvP;
            b.K(b.this).putString(a.Pik, paramq);
            this.YVX.addSceneEndListener(1985);
            paramString = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), paramString, str, paramq, b.n(b.this), false, 0, "");
            this.YVX.b(paramString, true);
          }
        }
      }
      while (!(paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
        for (;;)
        {
          String str;
          AppMethodBeat.o(71707);
          return false;
          paramString.putBoolean(a.Pio, true);
          b.this.a(this.activity, 0, paramString);
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
      this.YVX.removeSceneEndListener(1985);
      paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramq.PiA.tqa == 0)
        {
          paramString = new Bundle();
          paramString.putBoolean(a.Pio, false);
          if ((paramq.PiA.RQw != null) && (!Util.isNullOrNil(paramq.PiA.RQw.title)))
          {
            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.Pin, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.L(b.this).putByteArray(a.Pir, paramq.PiA.RQw.toByteArray());
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
        paramString.putBoolean(a.Pin, true);
        paramString.putString(a.Pil, paramq.PiA.RQu);
        paramString.putString(a.Pim, paramq.PiA.TME);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiA.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiA.tqa, paramq.PiA.tqb)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiA.tqb, paramq.tVo, paramString });
          h.c(this.activity, paramString, "", false);
          continue;
          Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
          h.c(this.activity, paramString, "", false);
        }
      }
    }
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71706);
      String str = (String)paramVarArgs[0];
      paramVarArgs = (String)paramVarArgs[1];
      b.G(b.this).putString(a.Pii, str);
      b.H(b.this).putString(a.Pij, paramVarArgs);
      paramVarArgs = new z("", str, null);
      this.YVX.b(paramVarArgs, true);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71711);
      if ((paramq instanceof e))
      {
        this.YVX.removeSceneEndListener(1958);
        paramq = (e)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.PiE.tqa == 0)
          {
            paramString = new Bundle();
            Log.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramq.PiE.RQt, Boolean.valueOf(paramq.PiE.TMz) });
            b.d(b.this).putString(a.Pia, paramq.PiE.RQt);
            if (paramq.PiE.TMz) {
              paramString.putBoolean(a.Piq, true);
            }
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71711);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiE.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiE.tqa, paramq.PiE.tqb)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiE.tqb, paramq.tVo, paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
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
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
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
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71710);
      paramVarArgs = (String)paramVarArgs[0];
      int i = b.a(b.this).getInt(a.PhY);
      this.YVX.addSceneEndListener(1958);
      e locale = new e(b.b(b.this), paramVarArgs, i, null);
      this.YVX.b(locale, true);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71718);
      if ((paramq instanceof e))
      {
        this.YVX.removeSceneEndListener(1958);
        paramq = (e)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.PiE.tqa == 0)
          {
            paramString = new Bundle();
            Log.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramq.PiE.RQt });
            b.f(b.this).putString(a.Pia, paramq.PiE.RQt);
            Log.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramq.token, Boolean.valueOf(paramq.PiE.TMy), Boolean.valueOf(paramq.PiE.TMz) });
            if (!Util.isNullOrNil(paramq.token)) {
              paramString.putBoolean(a.Pib, paramq.PiE.TMy);
            }
            if (paramq.PiE.TMz) {
              paramString.putBoolean(a.Piq, true);
            }
            paramString.putInt("key_ecard_proxy_action", 1);
            b.this.a(this.activity, 0, paramString);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71718);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiE.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiE.tqa, paramq.PiE.tqb)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiE.tqb, paramq.tVo, paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71713);
                b.this.b(b.c.a(b.c.this), null);
                AppMethodBeat.o(71713);
              }
            });
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
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
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.YVX.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.PiA.tqa == 0)
          {
            b.g(b.this).putInt(a.Pic, a.Pit);
            b.h(b.this).putString(a.Pif, paramq.PiB);
            b.i(b.this).putString(a.Pig, paramq.PiC);
            b.j(b.this).putString(a.Pih, paramq.PiD);
            paramString = new Bundle();
            if (paramq.PiA.RQw != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.Pin, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.k(b.this).putByteArray(a.Pir, paramq.PiA.RQw.toByteArray());
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
          paramString.putBoolean(a.Pin, true);
          paramString.putString(a.Pil, paramq.PiA.RQu);
          paramString.putString(a.Pim, paramq.PiA.TME);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiA.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiA.tqa, paramq.PiA.tqb)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiA.tqb, paramq.tVo, paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(71715);
                b.this.b(b.c.c(b.c.this), null);
                AppMethodBeat.o(71715);
              }
            });
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
            h.a(this.activity, paramString, "", false, new DialogInterface.OnClickListener()
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
    
    public final boolean r(Object... paramVarArgs)
    {
      AppMethodBeat.i(71717);
      int i;
      if (((Integer)paramVarArgs[0]).intValue() == 1)
      {
        Log.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
        i = ((Integer)paramVarArgs[1]).intValue();
        paramVarArgs = (String)paramVarArgs[2];
        this.YVX.addSceneEndListener(1958);
        paramVarArgs = new e(b.b(b.this), null, i, paramVarArgs);
        this.YVX.b(paramVarArgs, true);
      }
      for (;;)
      {
        AppMethodBeat.o(71717);
        return true;
        Log.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
        i = ((Integer)paramVarArgs[1]).intValue();
        this.YVX.addSceneEndListener(1985);
        paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), i);
        this.YVX.b(paramVarArgs, true);
      }
    }
  }
  
  final class d
    extends g
  {
    private com.tencent.mm.ui.widget.a.d nnz;
    
    public d(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    private void a(clz paramclz, TextView paramTextView)
    {
      AppMethodBeat.i(71724);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((paramclz.TtN != null) && (!Util.isNullOrNil(paramclz.TtN.desc)))
      {
        localSpannableStringBuilder.append(paramclz.TtN.desc);
        if (!Util.isNullOrNil(paramclz.TtN.lmL)) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(k.cW(paramclz.TtN.lmL, false)), 0, localSpannableStringBuilder.length(), 18);
        }
      }
      if ((paramclz.TtO != null) && (!Util.isNullOrNil(paramclz.TtO.desc)))
      {
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(paramclz.TtO.desc);
        localSpannableStringBuilder.setSpan(new r(paramclz.TtO.lmL, new r.a()
        {
          public final void ed(View paramAnonymousView)
          {
            AppMethodBeat.i(71720);
            Log.d("MicroMsg.OpenECardProcess", "click span");
            b.d.a(b.d.this).dismiss();
            if ((b.d.b(b.d.this) instanceof WalletECardBindCardListUI)) {
              ((WalletECardBindCardListUI)b.d.c(b.d.this)).gMS();
            }
            AppMethodBeat.o(71720);
          }
        }), i, localSpannableStringBuilder.length(), 18);
      }
      paramTextView.setText(localSpannableStringBuilder);
      AppMethodBeat.o(71724);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
    {
      AppMethodBeat.i(71725);
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.YVX.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.PiA.tqa == 0) {
            if (paramq.PiA.TMF != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "show input alert");
              paramString = paramq.PiA.TMF;
              if (this.nnz == null)
              {
                View localView = View.inflate(this.activity, a.g.ecard_mobile_verify_alert, null);
                final EditText localEditText = (EditText)localView.findViewById(a.f.emva_et);
                final TextView localTextView = (TextView)localView.findViewById(a.f.emva_tips);
                localTextView.setClickable(true);
                localTextView.setOnTouchListener(new o(this.activity));
                if (!Util.isNullOrNil(paramString.TtM)) {
                  localEditText.setHint(paramq.PiA.TMF.TtM);
                }
                d.a locala = new d.a(this.activity);
                locala.bBc(paramq.PiA.TMF.TtL);
                locala.aye(4);
                locala.iI(localView);
                if (!Util.isNullOrNil(paramString.TtQ)) {
                  locala.bBj(paramString.TtQ);
                }
                if (!Util.isNullOrNil(paramString.TtP)) {
                  locala.bBk(paramString.TtP);
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
                      dey localdey = (dey)d.b.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBR);
                      b.o(b.this).putInt(a.Piv, 2);
                      paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), localdey.RQt, localdey.TMA, paramAnonymousDialogInterface, localdey.fvP, b.n(b.this), true, 2, localdey.TMD);
                      b.d.e(b.d.this).a(paramAnonymousDialogInterface, true, 1);
                      AppMethodBeat.o(71721);
                      return;
                    }
                    paramAnonymousDialogInterface = new clz();
                    paramAnonymousDialogInterface.TtN = new ahi();
                    paramAnonymousDialogInterface.TtN.desc = b.d.f(b.d.this).getString(a.i.ecard_bind_card_verify_mobile_format_error);
                    paramAnonymousDialogInterface.TtN.lmL = "#FA5151";
                    paramAnonymousDialogInterface.TtO = new ahi();
                    paramAnonymousDialogInterface.TtO.desc = b.d.g(b.d.this).getString(a.i.ecard_bind_card_verify_mobile_bind_card);
                    paramAnonymousDialogInterface.TtO.lmL = "#0C4F8E";
                    b.d.a(b.d.this, paramAnonymousDialogInterface, localTextView);
                    AppMethodBeat.o(71721);
                  }
                });
                locala.HG(false);
                locala.a(new DialogInterface.OnDismissListener()
                {
                  public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(71722);
                    Log.i("MicroMsg.OpenECardProcess", "dismiss alert");
                    b.d.h(b.d.this);
                    AppMethodBeat.o(71722);
                  }
                });
                this.nnz = locala.icu();
                a(paramString, localTextView);
                this.nnz.show();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71725);
          return true;
          a(paramString, (TextView)this.nnz.findViewById(a.f.emva_tips));
          continue;
          b.p(b.this).putInt(a.Pic, a.Pit);
          b.q(b.this).putString(a.Pif, paramq.PiB);
          b.r(b.this).putString(a.Pig, paramq.PiC);
          b.s(b.this).putString(a.Pih, paramq.PiD);
          paramString = new Bundle();
          if (paramq.PiA.RQw != null)
          {
            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.Pin, false);
          }
          for (;;)
          {
            try
            {
              b.t(b.this).putByteArray(a.Pir, paramq.PiA.RQw.toByteArray());
              b.this.a(this.activity, 0, paramString);
            }
            catch (IOException paramq)
            {
              Log.printErrStackTrace("MicroMsg.OpenECardProcess", paramq, "", new Object[0]);
              continue;
            }
            Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
            paramString.putBoolean(a.Pin, true);
            paramString.putString(a.Pil, paramq.PiA.RQu);
            paramString.putString(a.Pim, paramq.PiA.TME);
          }
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiA.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiA.tqa, paramq.PiA.tqb)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiA.tqb, paramq.tVo, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
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
      paramVarArgs = (it)paramVarArgs[0];
      String str1 = b.l(b.this).getString(a.Pia, "");
      if (paramVarArgs == null)
      {
        Log.w("MicroMsg.OpenECardProcess", "empty bank item");
        AppMethodBeat.o(71723);
        return false;
      }
      this.YVX.addSceneEndListener(1985);
      String str2 = String.format("%s %s(%s)", new Object[] { paramVarArgs.DNV, paramVarArgs.tyK, paramVarArgs.ROB });
      b.m(b.this).putInt(a.Piv, 1);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), str1, paramVarArgs.ROC, paramVarArgs.OIl, paramVarArgs.fvP, b.n(b.this), true, 1, str2);
      this.YVX.a(paramVarArgs, true, 1);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71727);
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.YVX.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.PiA.tqa == 0)
          {
            paramString = new Bundle();
            if (paramq.PiA.RQw != null)
            {
              Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
              paramString.putBoolean(a.Pin, false);
            }
          }
        }
        for (;;)
        {
          try
          {
            b.O(b.this).putByteArray(a.Pir, paramq.PiA.RQw.toByteArray());
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
          paramString.putBoolean(a.Pin, true);
          paramString.putString(a.Pil, paramq.PiA.RQu);
          paramString.putString(a.Pim, paramq.PiA.TME);
          continue;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiA.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiA.tqa, paramq.PiA.tqb)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiA.tqb, paramq.tVo, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
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
      paramVarArgs = ((ElementQuery)paramVarArgs[0]).fvP;
      String str1 = b.M(b.this).getString(a.Pii);
      String str2 = b.N(b.this).getString(a.Pij);
      this.YVX.addSceneEndListener(1985);
      paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), str1, str2, paramVarArgs, b.n(b.this), false, 0, "");
      this.YVX.b(paramVarArgs, true);
      AppMethodBeat.o(71726);
      return true;
    }
  }
  
  final class g
    extends g
  {
    public g(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean B(Object... paramVarArgs)
    {
      AppMethodBeat.i(71731);
      int i = b.u(b.this).getInt(a.Pic);
      paramVarArgs = b.e(b.this);
      int j = b.v(b.this).getInt(a.Piv);
      Log.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      String str1;
      String str2;
      String str3;
      if (i == a.Pit)
      {
        str1 = b.w(b.this).getString(a.Pif);
        str2 = b.x(b.this).getString(a.Pig);
        str3 = b.y(b.this).getString(a.Pih);
      }
      for (paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), true, true, j, "");; paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), paramVarArgs, str1, str2, str3, b.n(b.this), false, true, j, ""))
      {
        this.YVX.addSceneEndListener(1985);
        this.YVX.b(paramVarArgs, true);
        AppMethodBeat.o(71731);
        return true;
        str1 = b.z(b.this).getString(a.Pii);
        str2 = b.A(b.this).getString(a.Pij);
        str3 = b.B(b.this).getString(a.Pik);
      }
    }
    
    public final CharSequence getTips(int paramInt)
    {
      AppMethodBeat.i(71730);
      String str = this.activity.getIntent().getStringExtra(a.Pim);
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
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71733);
      if ((paramq instanceof c))
      {
        this.YVX.removeSceneEndListener(1986);
        paramq = (c)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramq.Piz.tqa != 0) {
            break label155;
          }
          paramString = new Bundle();
          if (paramq.Piz.RQw != null) {
            Log.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramq.Piz.RQw.title });
          }
        }
        for (;;)
        {
          try
          {
            b.F(b.this).putByteArray(a.Pir, paramq.Piz.RQw.toByteArray());
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
          if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.Piz.RQv))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.Piz.tqb, paramString });
            h.c(this.activity, paramString, "", false);
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_ecard.a.d))
      {
        this.YVX.removeSceneEndListener(1985);
        paramq = (com.tencent.mm.plugin.wallet_ecard.a.d)paramq;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramq.PiA.tqa == 0) {
            this.activity.getIntent().putExtra(a.Pil, paramq.PiA.RQu);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(71733);
          return true;
          if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq.PiA.RQv)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.activity, paramq, paramq.fwx, paramq.tVo, paramq.PiA.tqa, paramq.PiA.tqb)))
          {
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramq.PiA.tqb, paramq.tVo, paramString });
            h.c(this.activity, paramString, "", false);
            continue;
            Log.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramq });
            paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(this.activity, new String[] { paramString });
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
      int i = b.E(b.this).getInt(a.PhY);
      String str2 = this.activity.getIntent().getStringExtra(a.Pil);
      paramVarArgs = new c(b.b(b.this), str1, paramVarArgs, str2, i);
      this.YVX.addSceneEndListener(1986);
      this.YVX.a(paramVarArgs, true, 3);
      AppMethodBeat.o(71732);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b
 * JD-Core Version:    0.7.0.1
 */