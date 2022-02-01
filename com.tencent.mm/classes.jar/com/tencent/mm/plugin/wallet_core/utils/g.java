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
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class g
{
  private static CharSequence a(Context paramContext, dni paramdni, g.a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramdni.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (al.isDarkMode()) {
      if (paramdni.HUu == null)
      {
        l2 = -1L;
        paramdni.HUu = new afu();
        if ((paramdni.HUs == Long.parseLong("ff000000", 16)) || (paramdni.HUs == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdni.HUu.Gwc, paramdni.HUu.Gwd);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = al.gE((int)paramdni.HUs);
              i = 0;
            }
          }
          label159:
          j = (int)l1;
          label164:
          if ((i == 0) || ((0xFF000000 & l1) != 0L)) {
            break label490;
          }
        }
      }
    }
    label490:
    for (i = (int)(l1 | 0xFF000000);; i = j)
    {
      Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)paramdni.size), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!bu.isNullOrNil(paramdni.ydG)) {
        ((WcPayTextApppearanceSpan)localObject).DFL = f.cr(paramContext, paramdni.ydG);
      }
      localObject = null;
      if (paramdni.HUt == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramdni.FLp != null) && (paramdni.FLp.type != 0))
        {
          paramdni = paramdni.FLp;
          ae.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramdni.type) });
          localSpannableString.setSpan(new q(new g.1(parama, paramdni, paramContext)), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramdni.HUs == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramdni.HUu.Gwc = paramdni.HUs;
        paramdni.HUu.Gwd = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdni.HUu.Gwc, paramdni.HUu.Gwd);
        i = j;
        break label159;
        l1 = paramdni.HUs;
        j = (int)l1;
        break label164;
        if (paramdni.HUt == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, dnl paramdnl, g.a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramdnl == null) || (paramdnl.HUA == null) || (paramdnl.HUA.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramdnl.HUA.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (dni)paramdnl.HUA.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, dnl paramdnl)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramdnl, null).toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, cxk paramcxk, Bundle paramBundle)
  {
    int i = 1000;
    AppMethodBeat.i(71667);
    if (paramcxk == null)
    {
      AppMethodBeat.o(71667);
      return;
    }
    ae.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(paramcxk.type), paramcxk.url });
    if (paramcxk.type == 1)
    {
      f.o(paramContext, paramcxk.url, true);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcxk.type == 2)
    {
      if (paramcxk.HHW == null)
      {
        ae.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(71667);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      f.u(paramcxk.HHW.username, paramcxk.HHW.path, paramcxk.HHW.version, i);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcxk.type != 3) {
      if (paramcxk.type == 4)
      {
        if (paramcxk.url.equals("balance"))
        {
          d.c(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcxk.url.equals("bankCard"))
        {
          paramcxk = new Intent();
          paramcxk.putExtra("intent_finish_self", true);
          d.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", paramcxk, 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcxk.url.equals("qmfCard"))
        {
          d.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcxk.url.equals("paySecurity"))
        {
          paramcxk = new Intent();
          paramcxk.putExtra("wallet_lock_jsapi_scene", 1);
          d.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramcxk, 65282);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcxk.url.equals("lqt"))
        {
          paramcxk = new Intent();
          paramcxk.putExtra("key_account_type", 1);
          d.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramcxk, 65286);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcxk.url.equals("realname"))
        {
          paramcxk = new Bundle();
          paramcxk.putInt("real_name_verify_mode", 0);
          paramcxk.putInt("entry_scene", 0);
          if (paramBundle != null) {
            paramcxk.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramcxk);
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcxk.type == 5)
      {
        if (paramcxk.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          d.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcxk.type == 13)
      {
        if (paramcxk.HIa != null) {
          AppMethodBeat.o(71667);
        }
      }
      else
      {
        ae.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(paramcxk.type), paramcxk.url });
      }
    }
    AppMethodBeat.o(71667);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, dxa paramdxa)
  {
    AppMethodBeat.i(71668);
    if (paramdxa == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramdxa.Icu);
    a(paramView, paramdxa.HHT);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, chy paramchy)
  {
    AppMethodBeat.i(71669);
    if (paramchy == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)paramchy.top);
    int j = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)paramchy.bottom);
    paramView.setPadding(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)paramchy.left), i, com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)paramchy.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, byt parambyt)
  {
    AppMethodBeat.i(71670);
    if (parambyt == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)parambyt.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)parambyt.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)parambyt.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)parambyt.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, dnl paramdnl, g.a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramdnl))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new n(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramdnl, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, bqg parambqg)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, parambqg, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, bqg parambqg, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)parambqg.width);
    int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)parambqg.height);
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
        paramCdnImageView.r(parambqg.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, bqg parambqg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, parambqg, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(dnl paramdnl)
  {
    AppMethodBeat.i(71661);
    if ((paramdnl.HUA == null) || (paramdnl.HUA.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramdnl = paramdnl.HUA.iterator();
    while (paramdnl.hasNext()) {
      if (((dni)paramdnl.next()).FLp != null)
      {
        AppMethodBeat.o(71661);
        return true;
      }
    }
    AppMethodBeat.o(71661);
    return false;
  }
  
  private static int argbColor(long paramLong)
  {
    AppMethodBeat.i(162280);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(162280);
    return i;
  }
  
  public static int cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    afu localafu = new afu();
    if (paramString == null)
    {
      AppMethodBeat.o(162279);
      return 0;
    }
    int i;
    if (!al.isDarkMode())
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(162279);
      return i;
    }
    for (;;)
    {
      try
      {
        if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFj, 1) == 0)
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
              localafu.Gwc = l;
              localafu.Gwd = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localafu.Gwc = l;
            localafu.Gwd = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localafu.Gwc, localafu.Gwd);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = al.gE(Color.parseColor(paramString));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */