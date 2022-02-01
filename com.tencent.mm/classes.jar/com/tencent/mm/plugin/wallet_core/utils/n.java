package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.fnf;
import com.tencent.mm.protocal.protobuf.fyc;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.ui.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class n
{
  private static CharSequence a(final Context paramContext, final fml paramfml, a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramfml.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (aw.isDarkMode()) {
      if (paramfml.abMI == null)
      {
        l2 = -1L;
        paramfml.abMI = new alg();
        if ((paramfml.ayn == Long.parseLong("ff000000", 16)) || (paramfml.ayn == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramfml.abMI.Zss, paramfml.abMI.Zst);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = aw.mx((int)paramfml.ayn);
              i = 0;
            }
          }
          label163:
          j = (int)l1;
          label168:
          if ((i == 0) || ((0xFF000000 & l1) != 0L)) {
            break label570;
          }
        }
      }
    }
    label570:
    for (i = (int)(l1 | 0xFF000000);; i = j)
    {
      float f2 = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
      float f1;
      if (!aw.bc(f2, com.tencent.mm.cd.a.mi(MMApplicationContext.getContext())))
      {
        f1 = f2;
        if (!aw.bc(f2, com.tencent.mm.cd.a.mj(MMApplicationContext.getContext()))) {}
      }
      else
      {
        f1 = com.tencent.mm.cd.a.mh(MMApplicationContext.getContext());
      }
      Object localObject = new WcPayTextApppearanceSpan((int)(f1 * com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramfml.size)), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!Util.isNullOrNil(paramfml.mAD)) {
        ((WcPayTextApppearanceSpan)localObject).VYs = com.tencent.mm.wallet_core.ui.i.df(paramContext, paramfml.mAD);
      }
      if ((paramfml != null) && (paramfml.abMJ > 0)) {
        ((WcPayTextApppearanceSpan)localObject).VYt = paramfml.abMJ;
      }
      localObject = null;
      if (paramfml.abMH == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramfml.YCV != null) && (paramfml.YCV.type != 0))
        {
          paramfml = paramfml.YCV;
          Log.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramfml.type) });
          localSpannableString.setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(7, new s.a()
          {
            public final void eS(View paramAnonymousView)
            {
              AppMethodBeat.i(71651);
              if ((n.this != null) && (!n.this.fZK()))
              {
                n.a(paramContext, paramfml, null);
                n.this.a(paramfml);
                AppMethodBeat.o(71651);
                return;
              }
              n.a(paramContext, paramfml, null);
              AppMethodBeat.o(71651);
            }
          }), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramfml.ayn == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramfml.abMI.Zss = paramfml.ayn;
        paramfml.abMI.Zst = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramfml.abMI.Zss, paramfml.abMI.Zst);
        i = j;
        break label163;
        l1 = paramfml.ayn;
        j = (int)l1;
        break label168;
        if (paramfml.abMH == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, fmp paramfmp, a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramfmp == null) || (paramfmp.abMT == null) || (paramfmp.abMT.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramfmp.abMT.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (fml)paramfmp.abMT.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, fmp paramfmp)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramfmp, null);
    if (paramContext == null)
    {
      AppMethodBeat.o(71671);
      return "";
    }
    paramContext = paramContext.toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, etg parametg, Bundle paramBundle)
  {
    AppMethodBeat.i(71667);
    a(paramContext, parametg, paramBundle, null, null);
    AppMethodBeat.o(71667);
  }
  
  public static void a(Context paramContext, etg parametg, Bundle paramBundle, com.tencent.mm.plugin.appbrand.api.i parami, b paramb)
  {
    int i = 1000;
    AppMethodBeat.i(301455);
    if (parametg == null)
    {
      AppMethodBeat.o(301455);
      return;
    }
    Log.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(parametg.type), parametg.url });
    if (parametg.type == 1)
    {
      com.tencent.mm.wallet_core.ui.i.o(paramContext, parametg.url, true);
      AppMethodBeat.o(301455);
      return;
    }
    if (parametg.type == 2)
    {
      if (parametg.abwC == null)
      {
        Log.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(301455);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      if (parami != null)
      {
        com.tencent.mm.wallet_core.ui.i.a(parametg.abwC.username, parametg.abwC.path, parametg.abwC.version, i, parami);
        AppMethodBeat.o(301455);
        return;
      }
      com.tencent.mm.wallet_core.ui.i.y(parametg.abwC.username, parametg.abwC.path, parametg.abwC.version, i);
      AppMethodBeat.o(301455);
      return;
    }
    if (parametg.type != 3) {
      if (parametg.type == 4)
      {
        if (parametg.url.equals("balance"))
        {
          com.tencent.mm.br.c.g(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(301455);
          return;
        }
        if (parametg.url.equals("bankCard"))
        {
          parametg = new Intent();
          parametg.putExtra("intent_finish_self", true);
          com.tencent.mm.br.c.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", parametg, 65281);
          AppMethodBeat.o(301455);
          return;
        }
        if (parametg.url.equals("qmfCard"))
        {
          com.tencent.mm.br.c.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(301455);
          return;
        }
        if (parametg.url.equals("paySecurity"))
        {
          parametg = new Intent();
          parametg.putExtra("wallet_lock_jsapi_scene", 1);
          com.tencent.mm.br.c.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", parametg, 65282);
          AppMethodBeat.o(301455);
          return;
        }
        if (parametg.url.equals("lqt"))
        {
          parametg = new Intent();
          parametg.putExtra("key_account_type", 1);
          com.tencent.mm.br.c.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", parametg, 65286);
          AppMethodBeat.o(301455);
          return;
        }
        if (parametg.url.equals("realname"))
        {
          parametg = new Bundle();
          parametg.putInt("real_name_verify_mode", 0);
          parametg.putInt("entry_scene", 0);
          if (paramBundle != null) {
            parametg.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, parametg, new e.a()
          {
            public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
            {
              int j = 1;
              AppMethodBeat.i(301457);
              int i;
              if (n.this != null)
              {
                i = 1;
                if (paramAnonymousInt != -1) {
                  break label68;
                }
              }
              label68:
              for (paramAnonymousInt = j;; paramAnonymousInt = 0)
              {
                if ((paramAnonymousInt & i) != 0)
                {
                  paramAnonymousBundle = new Bundle();
                  paramAnonymousBundle.putInt("callbackEventType", 2);
                  n.this.aG(paramAnonymousBundle);
                }
                AppMethodBeat.o(301457);
                return null;
                i = 0;
                break;
              }
            }
          });
          AppMethodBeat.o(301455);
          return;
        }
        if (parametg.url.equals("paySettingsUseCase"))
        {
          paramContext = ITransmitKvData.create();
          parametg = new StringBuilder();
          h.baC();
          paramContext.putString("modifyPwd.sessionId", b.aZs() + "_" + com.tencent.mm.wallet_core.ui.i.jPu());
          paramContext.putBool("resetPwd.bResetPwdFromPayManage", true);
          paramContext.putInt("resetPwd.realnameScene", 0);
          paramContext.putInt("resetPwd.payScene", 0);
          ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("paySettingsUseCase", paramContext, new UseCaseCallback()
          {
            public final void call(ITransmitKvData paramAnonymousITransmitKvData)
            {
              AppMethodBeat.i(301459);
              if ((paramAnonymousITransmitKvData != null) && (n.this != null) && (paramAnonymousITransmitKvData.getInt("pay.settings.refreshentrance") == 1))
              {
                paramAnonymousITransmitKvData = new Bundle();
                paramAnonymousITransmitKvData.putInt("callbackEventType", 1);
                n.this.aG(paramAnonymousITransmitKvData);
              }
              AppMethodBeat.o(301459);
            }
          });
          AppMethodBeat.o(301455);
        }
      }
      else if (parametg.type == 5)
      {
        if (parametg.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          com.tencent.mm.br.c.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(301455);
        }
      }
      else if (parametg.type == 13)
      {
        if (parametg.abwG != null) {
          AppMethodBeat.o(301455);
        }
      }
      else
      {
        Log.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(parametg.type), parametg.url });
      }
    }
    AppMethodBeat.o(301455);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, fyc paramfyc)
  {
    AppMethodBeat.i(71668);
    if (paramfyc == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramfyc.abVX);
    a(paramView, paramfyc.abwz);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, eab parameab)
  {
    AppMethodBeat.i(71669);
    if (parameab == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)parameab.top);
    int j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)parameab.bottom);
    paramView.setPadding(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)parameab.left), i, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)parameab.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, dmj paramdmj)
  {
    AppMethodBeat.i(71670);
    if (paramdmj == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdmj.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdmj.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdmj.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdmj.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, fmp paramfmp, a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramfmp))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramfmp, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, dbk paramdbk)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, paramdbk, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, dbk paramdbk, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdbk.width);
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdbk.height);
    if (paramInt2 > 0) {}
    for (;;)
    {
      if (paramInt3 > 0) {}
      for (;;)
      {
        ViewGroup.LayoutParams localLayoutParams = paramCdnImageView.getLayoutParams();
        if ((localLayoutParams != null) && (paramInt2 > 0) && (paramInt3 > 0))
        {
          localLayoutParams.width = paramInt2;
          localLayoutParams.height = paramInt3;
        }
        if ((aw.isDarkMode()) && (!Util.isNullOrNil(paramdbk.aaGR)))
        {
          paramCdnImageView.w(paramdbk.aaGR, paramInt2, paramInt3, paramInt1);
          AppMethodBeat.o(71664);
          return;
        }
        paramCdnImageView.w(paramdbk.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, dbk paramdbk, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, paramdbk, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(fmp paramfmp)
  {
    AppMethodBeat.i(71661);
    if ((paramfmp.abMT == null) || (paramfmp.abMT.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramfmp = paramfmp.abMT.iterator();
    while (paramfmp.hasNext()) {
      if (((fml)paramfmp.next()).YCV != null)
      {
        AppMethodBeat.o(71661);
        return true;
      }
    }
    AppMethodBeat.o(71661);
    return false;
  }
  
  public static int argbColor(long paramLong)
  {
    AppMethodBeat.i(162280);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(162280);
    return i;
  }
  
  public static int dE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    alg localalg = new alg();
    if (paramString == null)
    {
      AppMethodBeat.o(162279);
      return 0;
    }
    int i;
    if (!aw.isDarkMode())
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(162279);
      return i;
    }
    for (;;)
    {
      try
      {
        if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUP, 1) == 0)
        {
          i = Color.parseColor(paramString);
          AppMethodBeat.o(162279);
          return i;
        }
        if (paramString.startsWith("#"))
        {
          String str1 = paramString.substring(1);
          long l = Long.parseLong(str1, 16);
          if (paramBoolean)
          {
            if ((l == Long.parseLong("ff000000", 16)) || (l == 0L))
            {
              l = Long.parseLong("CCFFFFFF", 16);
              if (l != -1L)
              {
                i = argbColor(l);
                AppMethodBeat.o(162279);
                return i;
              }
            }
            else
            {
              if (l == Long.parseLong("78000000", 16))
              {
                l = Long.parseLong("80FFFFFF", 16);
                continue;
              }
              if ((l == Long.parseLong("909090", 16)) || (l == Long.parseLong("ff909090", 16)))
              {
                l = Long.parseLong("4DFFFFFF", 16);
                continue;
              }
              localalg.Zss = l;
              localalg.Zst = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localalg.Zss = l;
            localalg.Zst = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localalg.Zss, localalg.Zst);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = aw.mx(Color.parseColor(paramString));
          AppMethodBeat.o(162279);
          return i;
        }
      }
      catch (Exception localException)
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(162279);
        return i;
      }
      String str2 = paramString;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(etg paramVarArgs);
    
    public abstract boolean fZK();
  }
  
  public static abstract interface b
  {
    public abstract void aG(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.n
 * JD-Core Version:    0.7.0.1
 */