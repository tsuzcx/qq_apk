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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class g
{
  private static CharSequence a(final Context paramContext, final dbm paramdbm, a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramdbm.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (ai.Eq()) {
      if (paramdbm.Etb == null)
      {
        l2 = -1L;
        paramdbm.Etb = new acl();
        if ((paramdbm.EsY == Long.parseLong("ff000000", 16)) || (paramdbm.EsY == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdbm.Etb.DcS, paramdbm.Etb.DcT);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = ai.gO((int)paramdbm.EsY);
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
      Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)paramdbm.size), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!bt.isNullOrNil(paramdbm.EsZ)) {
        ((WcPayTextApppearanceSpan)localObject).Avt = e.cl(paramContext, paramdbm.EsZ);
      }
      localObject = null;
      if (paramdbm.Eta == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramdbm.Cvq != null) && (paramdbm.Cvq.type != 0))
        {
          paramdbm = paramdbm.Cvq;
          ad.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramdbm.type) });
          localSpannableString.setSpan(new q(new q.a()
          {
            public final void dI(View paramAnonymousView)
            {
              AppMethodBeat.i(71651);
              if (this.Avu != null)
              {
                g.a(paramContext, paramdbm, null);
                this.Avu.a(paramdbm);
                AppMethodBeat.o(71651);
                return;
              }
              g.a(paramContext, paramdbm, null);
              AppMethodBeat.o(71651);
            }
          }), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramdbm.EsY == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramdbm.Etb.DcS = paramdbm.EsY;
        paramdbm.Etb.DcT = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdbm.Etb.DcS, paramdbm.Etb.DcT);
        i = j;
        break label159;
        l1 = paramdbm.EsY;
        j = (int)l1;
        break label164;
        if (paramdbm.Eta == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, dbp paramdbp, a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramdbp == null) || (paramdbp.Eth == null) || (paramdbp.Eth.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramdbp.Eth.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (dbm)paramdbp.Eth.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, dbp paramdbp)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramdbp, null).toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, cmc paramcmc, Bundle paramBundle)
  {
    int i = 1000;
    AppMethodBeat.i(71667);
    if (paramcmc == null)
    {
      AppMethodBeat.o(71667);
      return;
    }
    ad.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(paramcmc.type), paramcmc.url });
    if (paramcmc.type == 1)
    {
      e.o(paramContext, paramcmc.url, true);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcmc.type == 2)
    {
      if (paramcmc.Ehg == null)
      {
        ad.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(71667);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      e.v(paramcmc.Ehg.username, paramcmc.Ehg.path, paramcmc.Ehg.version, i);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcmc.type != 3) {
      if (paramcmc.type == 4)
      {
        if (paramcmc.url.equals("balance"))
        {
          d.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcmc.url.equals("bankCard"))
        {
          paramcmc = new Intent();
          paramcmc.putExtra("intent_finish_self", true);
          d.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", paramcmc, 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcmc.url.equals("qmfCard"))
        {
          d.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcmc.url.equals("paySecurity"))
        {
          paramcmc = new Intent();
          paramcmc.putExtra("wallet_lock_jsapi_scene", 1);
          d.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramcmc, 65282);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcmc.url.equals("lqt"))
        {
          paramcmc = new Intent();
          paramcmc.putExtra("key_account_type", 1);
          d.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramcmc, 65286);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcmc.url.equals("realname"))
        {
          paramcmc = new Bundle();
          paramcmc.putInt("real_name_verify_mode", 0);
          paramcmc.putInt("entry_scene", 0);
          if (paramBundle != null) {
            paramcmc.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramcmc);
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcmc.type == 5)
      {
        if (paramcmc.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          d.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcmc.type == 13)
      {
        if (paramcmc.Ehk != null) {
          AppMethodBeat.o(71667);
        }
      }
      else
      {
        ad.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(paramcmc.type), paramcmc.url });
      }
    }
    AppMethodBeat.o(71667);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, dku paramdku)
  {
    AppMethodBeat.i(71668);
    if (paramdku == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramdku.EAy);
    a(paramView, paramdku.Ehd);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, bxs parambxs)
  {
    AppMethodBeat.i(71669);
    if (parambxs == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambxs.top);
    int j = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambxs.bottom);
    paramView.setPadding(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambxs.left), i, com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambxs.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, bov parambov)
  {
    AppMethodBeat.i(71670);
    if (parambov == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambov.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambov.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambov.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambov.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, dbp paramdbp, a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramdbp))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new n(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramdbp, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, bhl parambhl)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, parambhl, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, bhl parambhl, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambhl.width);
    int i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)parambhl.height);
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
        paramCdnImageView.r(parambhl.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, bhl parambhl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, parambhl, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(dbp paramdbp)
  {
    AppMethodBeat.i(71661);
    if ((paramdbp.Eth == null) || (paramdbp.Eth.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramdbp = paramdbp.Eth.iterator();
    while (paramdbp.hasNext()) {
      if (((dbm)paramdbp.next()).Cvq != null)
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
  
  public static int bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    acl localacl = new acl();
    if (paramString == null)
    {
      AppMethodBeat.o(162279);
      return 0;
    }
    int i;
    if (!ai.Eq())
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(162279);
      return i;
    }
    for (;;)
    {
      try
      {
        if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppM, 1) == 0)
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
              localacl.DcS = l;
              localacl.DcT = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localacl.DcS = l;
            localacl.DcT = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localacl.DcS, localacl.DcT);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = ai.gO(Color.parseColor(paramString));
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
    public abstract void a(cmc paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */