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
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.erw;
import com.tencent.mm.protocal.protobuf.fbr;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class k
{
  private static CharSequence a(final Context paramContext, final ere paramere, a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramere.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (ar.isDarkMode()) {
      if (paramere.Utr == null)
      {
        l2 = -1L;
        paramere.Utr = new aim();
        if ((paramere.Utp == Long.parseLong("ff000000", 16)) || (paramere.Utp == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramere.Utr.Stf, paramere.Utr.Stg);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = ar.iV((int)paramere.Utp);
              i = 0;
            }
          }
          label159:
          j = (int)l1;
          label164:
          if ((i == 0) || ((0xFF000000 & l1) != 0L)) {
            break label512;
          }
        }
      }
    }
    label512:
    for (i = (int)(l1 | 0xFF000000);; i = j)
    {
      Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramere.size), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!Util.isNullOrNil(paramere.IbE)) {
        ((WcPayTextApppearanceSpan)localObject).PhE = g.cV(paramContext, paramere.IbE);
      }
      if ((paramere != null) && (paramere.Uts > 0)) {
        ((WcPayTextApppearanceSpan)localObject).PhF = paramere.Uts;
      }
      localObject = null;
      if (paramere.Utq == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramere.RGh != null) && (paramere.RGh.type != 0))
        {
          paramere = paramere.RGh;
          Log.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramere.type) });
          localSpannableString.setSpan(new r(7, new r.a()
          {
            public final void ed(View paramAnonymousView)
            {
              AppMethodBeat.i(71651);
              if (this.PhG != null)
              {
                k.a(paramContext, paramere, null);
                this.PhG.a(paramere);
                AppMethodBeat.o(71651);
                return;
              }
              k.a(paramContext, paramere, null);
              AppMethodBeat.o(71651);
            }
          }), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramere.Utp == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramere.Utr.Stf = paramere.Utp;
        paramere.Utr.Stg = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramere.Utr.Stf, paramere.Utr.Stg);
        i = j;
        break label159;
        l1 = paramere.Utp;
        j = (int)l1;
        break label164;
        if (paramere.Utq == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, erh paramerh, a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramerh == null) || (paramerh.Uty == null) || (paramerh.Uty.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramerh.Uty.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (ere)paramerh.Uty.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, erh paramerh)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramerh, null).toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, eaa parameaa, Bundle paramBundle)
  {
    AppMethodBeat.i(293344);
    a(paramContext, parameaa, paramBundle, null, null);
    AppMethodBeat.o(293344);
  }
  
  public static void a(Context paramContext, eaa parameaa, Bundle paramBundle, i parami, k.b paramb)
  {
    int i = 1000;
    AppMethodBeat.i(293345);
    if (parameaa == null)
    {
      AppMethodBeat.o(293345);
      return;
    }
    Log.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(parameaa.type), parameaa.url });
    if (parameaa.type == 1)
    {
      g.o(paramContext, parameaa.url, true);
      AppMethodBeat.o(293345);
      return;
    }
    if (parameaa.type == 2)
    {
      if (parameaa.Ufp == null)
      {
        Log.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(293345);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      if (parami != null)
      {
        g.a(parameaa.Ufp.username, parameaa.Ufp.path, parameaa.Ufp.version, i, parami);
        AppMethodBeat.o(293345);
        return;
      }
      g.v(parameaa.Ufp.username, parameaa.Ufp.path, parameaa.Ufp.version, i);
      AppMethodBeat.o(293345);
      return;
    }
    if (parameaa.type != 3) {
      if (parameaa.type == 4)
      {
        if (parameaa.url.equals("balance"))
        {
          c.f(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(293345);
          return;
        }
        if (parameaa.url.equals("bankCard"))
        {
          parameaa = new Intent();
          parameaa.putExtra("intent_finish_self", true);
          c.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", parameaa, 65281);
          AppMethodBeat.o(293345);
          return;
        }
        if (parameaa.url.equals("qmfCard"))
        {
          c.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(293345);
          return;
        }
        if (parameaa.url.equals("paySecurity"))
        {
          parameaa = new Intent();
          parameaa.putExtra("wallet_lock_jsapi_scene", 1);
          c.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", parameaa, 65282);
          AppMethodBeat.o(293345);
          return;
        }
        if (parameaa.url.equals("lqt"))
        {
          parameaa = new Intent();
          parameaa.putExtra("key_account_type", 1);
          c.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", parameaa, 65286);
          AppMethodBeat.o(293345);
          return;
        }
        if (parameaa.url.equals("realname"))
        {
          parameaa = new Bundle();
          parameaa.putInt("real_name_verify_mode", 0);
          parameaa.putInt("entry_scene", 0);
          if (paramBundle != null) {
            parameaa.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, parameaa);
          AppMethodBeat.o(293345);
          return;
        }
        if (parameaa.url.equals("paySettingsUseCase"))
        {
          paramContext = ITransmitKvData.create();
          parameaa = new StringBuilder();
          h.aHE();
          paramContext.putString("modifyPwd.sessionId", com.tencent.mm.kernel.b.aGq() + "_" + g.ijw());
          paramContext.putBool("resetPwd.bResetPwdFromPayManage", true);
          paramContext.putInt("resetPwd.realnameScene", 0);
          paramContext.putInt("resetPwd.payScene", 0);
          ((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("paySettingsUseCase", paramContext, new UseCaseCallback()
          {
            public final void call(ITransmitKvData paramAnonymousITransmitKvData)
            {
              AppMethodBeat.i(293282);
              if ((paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("pay.settings.refreshentrance") == 1))
              {
                paramAnonymousITransmitKvData = new Bundle();
                paramAnonymousITransmitKvData.putInt("callbackEventType", 1);
                this.Odh.bu(paramAnonymousITransmitKvData);
              }
              AppMethodBeat.o(293282);
            }
          });
          AppMethodBeat.o(293345);
        }
      }
      else if (parameaa.type == 5)
      {
        if (parameaa.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          c.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(293345);
        }
      }
      else if (parameaa.type == 13)
      {
        if (parameaa.Uft != null) {
          AppMethodBeat.o(293345);
        }
      }
      else
      {
        Log.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(parameaa.type), parameaa.url });
      }
    }
    AppMethodBeat.o(293345);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, fbr paramfbr)
  {
    AppMethodBeat.i(71668);
    if (paramfbr == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramfbr.UBO);
    a(paramView, paramfbr.Ufm);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, dhr paramdhr)
  {
    AppMethodBeat.i(71669);
    if (paramdhr == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdhr.top);
    int j = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdhr.bottom);
    paramView.setPadding(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdhr.left), i, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramdhr.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, cvd paramcvd)
  {
    AppMethodBeat.i(71670);
    if (paramcvd == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcvd.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcvd.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcvd.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcvd.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, erh paramerh, a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramerh))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new o(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramerh, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, clc paramclc)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, paramclc, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, clc paramclc, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramclc.width);
    int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramclc.height);
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
        if ((ar.isDarkMode()) && (!Util.isNullOrNil(paramclc.TsG)))
        {
          paramCdnImageView.w(paramclc.TsG, paramInt2, paramInt3, paramInt1);
          AppMethodBeat.o(71664);
          return;
        }
        paramCdnImageView.w(paramclc.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, clc paramclc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, paramclc, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(erh paramerh)
  {
    AppMethodBeat.i(71661);
    if ((paramerh.Uty == null) || (paramerh.Uty.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramerh = paramerh.Uty.iterator();
    while (paramerh.hasNext()) {
      if (((ere)paramerh.next()).RGh != null)
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
  
  public static int cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    aim localaim = new aim();
    if (paramString == null)
    {
      AppMethodBeat.o(162279);
      return 0;
    }
    int i;
    if (!ar.isDarkMode())
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(162279);
      return i;
    }
    for (;;)
    {
      try
      {
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFr, 1) == 0)
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
              localaim.Stf = l;
              localaim.Stg = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localaim.Stf = l;
            localaim.Stg = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localaim.Stf, localaim.Stg);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = ar.iV(Color.parseColor(paramString));
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
    public abstract void a(eaa paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.k
 * JD-Core Version:    0.7.0.1
 */