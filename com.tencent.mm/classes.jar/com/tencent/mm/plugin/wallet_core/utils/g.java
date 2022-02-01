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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehu;
import com.tencent.mm.protocal.protobuf.erg;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class g
{
  private static CharSequence a(final Context paramContext, final ehc paramehc, a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramehc.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (ao.isDarkMode()) {
      if (paramehc.NgN == null)
      {
        l2 = -1L;
        paramehc.NgN = new aib();
        if ((paramehc.NgL == Long.parseLong("ff000000", 16)) || (paramehc.NgL == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramehc.NgN.LrI, paramehc.NgN.LrJ);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = ao.hT((int)paramehc.NgL);
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
      Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramehc.size), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!Util.isNullOrNil(paramehc.CeI)) {
        ((WcPayTextApppearanceSpan)localObject).IoX = f.cK(paramContext, paramehc.CeI);
      }
      localObject = null;
      if (paramehc.NgM == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramehc.KEP != null) && (paramehc.KEP.type != 0))
        {
          paramehc = paramehc.KEP;
          Log.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramehc.type) });
          localSpannableString.setSpan(new q(new q.a()
          {
            public final void dF(View paramAnonymousView)
            {
              AppMethodBeat.i(71651);
              if (this.IoY != null)
              {
                g.a(paramContext, paramehc, null);
                this.IoY.a(paramehc);
                AppMethodBeat.o(71651);
                return;
              }
              g.a(paramContext, paramehc, null);
              AppMethodBeat.o(71651);
            }
          }), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramehc.NgL == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramehc.NgN.LrI = paramehc.NgL;
        paramehc.NgN.LrJ = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramehc.NgN.LrI, paramehc.NgN.LrJ);
        i = j;
        break label159;
        l1 = paramehc.NgL;
        j = (int)l1;
        break label164;
        if (paramehc.NgM == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, ehf paramehf, a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramehf == null) || (paramehf.NgT == null) || (paramehf.NgT.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramehf.NgT.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (ehc)paramehf.NgT.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, ehf paramehf)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramehf, null).toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, dqe paramdqe, Bundle paramBundle)
  {
    int i = 1000;
    AppMethodBeat.i(71667);
    if (paramdqe == null)
    {
      AppMethodBeat.o(71667);
      return;
    }
    Log.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(paramdqe.type), paramdqe.url });
    if (paramdqe.type == 1)
    {
      f.o(paramContext, paramdqe.url, true);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramdqe.type == 2)
    {
      if (paramdqe.MTh == null)
      {
        Log.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(71667);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      f.u(paramdqe.MTh.username, paramdqe.MTh.path, paramdqe.MTh.version, i);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramdqe.type != 3) {
      if (paramdqe.type == 4)
      {
        if (paramdqe.url.equals("balance"))
        {
          c.d(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramdqe.url.equals("bankCard"))
        {
          paramdqe = new Intent();
          paramdqe.putExtra("intent_finish_self", true);
          c.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", paramdqe, 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramdqe.url.equals("qmfCard"))
        {
          c.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramdqe.url.equals("paySecurity"))
        {
          paramdqe = new Intent();
          paramdqe.putExtra("wallet_lock_jsapi_scene", 1);
          c.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramdqe, 65282);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramdqe.url.equals("lqt"))
        {
          paramdqe = new Intent();
          paramdqe.putExtra("key_account_type", 1);
          c.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramdqe, 65286);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramdqe.url.equals("realname"))
        {
          paramdqe = new Bundle();
          paramdqe.putInt("real_name_verify_mode", 0);
          paramdqe.putInt("entry_scene", 0);
          if (paramBundle != null) {
            paramdqe.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramdqe);
          AppMethodBeat.o(71667);
        }
      }
      else if (paramdqe.type == 5)
      {
        if (paramdqe.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          c.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(71667);
        }
      }
      else if (paramdqe.type == 13)
      {
        if (paramdqe.MTl != null) {
          AppMethodBeat.o(71667);
        }
      }
      else
      {
        Log.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(paramdqe.type), paramdqe.url });
      }
    }
    AppMethodBeat.o(71667);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, erg paramerg)
  {
    AppMethodBeat.i(71668);
    if (paramerg == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramerg.NoS);
    a(paramView, paramerg.MTe);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, cyf paramcyf)
  {
    AppMethodBeat.i(71669);
    if (paramcyf == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcyf.top);
    int j = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcyf.bottom);
    paramView.setPadding(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcyf.left), i, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcyf.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, cml paramcml)
  {
    AppMethodBeat.i(71670);
    if (paramcml == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcml.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcml.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcml.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramcml.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, ehf paramehf, a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramehf))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new o(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramehf, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, ccy paramccy)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, paramccy, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, ccy paramccy, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramccy.width);
    int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)paramccy.height);
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
        paramCdnImageView.s(paramccy.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, ccy paramccy, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, paramccy, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(ehf paramehf)
  {
    AppMethodBeat.i(71661);
    if ((paramehf.NgT == null) || (paramehf.NgT.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramehf = paramehf.NgT.iterator();
    while (paramehf.hasNext()) {
      if (((ehc)paramehf.next()).KEP != null)
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
  
  public static int cI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    aib localaib = new aib();
    if (paramString == null)
    {
      AppMethodBeat.o(162279);
      return 0;
    }
    int i;
    if (!ao.isDarkMode())
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(162279);
      return i;
    }
    for (;;)
    {
      try
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYt, 1) == 0)
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
              localaib.LrI = l;
              localaib.LrJ = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localaib.LrI = l;
            localaib.LrJ = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localaib.LrI, localaib.LrJ);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = ao.hT(Color.parseColor(paramString));
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
    public abstract void a(dqe paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */