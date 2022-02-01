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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class g
{
  private static CharSequence a(final Context paramContext, final dml paramdml, a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramdml.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (al.isDarkMode()) {
      if (paramdml.HAH == null)
      {
        l2 = -1L;
        paramdml.HAH = new afl();
        if ((paramdml.HAF == Long.parseLong("ff000000", 16)) || (paramdml.HAF == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdml.HAH.Gdv, paramdml.HAH.Gdw);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = al.gD((int)paramdml.HAF);
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
      Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)paramdml.size), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!bt.isNullOrNil(paramdml.xNN)) {
        ((WcPayTextApppearanceSpan)localObject).Dof = e.cq(paramContext, paramdml.xNN);
      }
      localObject = null;
      if (paramdml.HAG == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramdml.FsR != null) && (paramdml.FsR.type != 0))
        {
          paramdml = paramdml.FsR;
          ad.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramdml.type) });
          localSpannableString.setSpan(new q(new q.a()
          {
            public final void dN(View paramAnonymousView)
            {
              AppMethodBeat.i(71651);
              if (this.Dog != null)
              {
                g.a(paramContext, paramdml, null);
                this.Dog.a(paramdml);
                AppMethodBeat.o(71651);
                return;
              }
              g.a(paramContext, paramdml, null);
              AppMethodBeat.o(71651);
            }
          }), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramdml.HAF == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramdml.HAH.Gdv = paramdml.HAF;
        paramdml.HAH.Gdw = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdml.HAH.Gdv, paramdml.HAH.Gdw);
        i = j;
        break label159;
        l1 = paramdml.HAF;
        j = (int)l1;
        break label164;
        if (paramdml.HAG == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, dmo paramdmo, a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramdmo == null) || (paramdmo.HAN == null) || (paramdmo.HAN.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramdmo.HAN.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (dml)paramdmo.HAN.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, dmo paramdmo)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramdmo, null).toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, cwq paramcwq, Bundle paramBundle)
  {
    int i = 1000;
    AppMethodBeat.i(71667);
    if (paramcwq == null)
    {
      AppMethodBeat.o(71667);
      return;
    }
    ad.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(paramcwq.type), paramcwq.url });
    if (paramcwq.type == 1)
    {
      e.n(paramContext, paramcwq.url, true);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcwq.type == 2)
    {
      if (paramcwq.Hou == null)
      {
        ad.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(71667);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      e.v(paramcwq.Hou.username, paramcwq.Hou.path, paramcwq.Hou.version, i);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcwq.type != 3) {
      if (paramcwq.type == 4)
      {
        if (paramcwq.url.equals("balance"))
        {
          d.c(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcwq.url.equals("bankCard"))
        {
          paramcwq = new Intent();
          paramcwq.putExtra("intent_finish_self", true);
          d.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", paramcwq, 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcwq.url.equals("qmfCard"))
        {
          d.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcwq.url.equals("paySecurity"))
        {
          paramcwq = new Intent();
          paramcwq.putExtra("wallet_lock_jsapi_scene", 1);
          d.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramcwq, 65282);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcwq.url.equals("lqt"))
        {
          paramcwq = new Intent();
          paramcwq.putExtra("key_account_type", 1);
          d.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramcwq, 65286);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcwq.url.equals("realname"))
        {
          paramcwq = new Bundle();
          paramcwq.putInt("real_name_verify_mode", 0);
          paramcwq.putInt("entry_scene", 0);
          if (paramBundle != null) {
            paramcwq.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramcwq);
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcwq.type == 5)
      {
        if (paramcwq.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          d.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcwq.type == 13)
      {
        if (paramcwq.Hoy != null) {
          AppMethodBeat.o(71667);
        }
      }
      else
      {
        ad.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(paramcwq.type), paramcwq.url });
      }
    }
    AppMethodBeat.o(71667);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, dwf paramdwf)
  {
    AppMethodBeat.i(71668);
    if (paramdwf == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramdwf.HII);
    a(paramView, paramdwf.Hor);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, che paramche)
  {
    AppMethodBeat.i(71669);
    if (paramche == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)paramche.top);
    int j = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)paramche.bottom);
    paramView.setPadding(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)paramche.left), i, com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)paramche.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, bxz parambxz)
  {
    AppMethodBeat.i(71670);
    if (parambxz == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)parambxz.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)parambxz.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)parambxz.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)parambxz.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, dmo paramdmo, a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramdmo))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new n(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramdmo, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, bpn parambpn)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, parambpn, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, bpn parambpn, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)parambpn.width);
    int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)parambpn.height);
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
        paramCdnImageView.r(parambpn.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, bpn parambpn, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, parambpn, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(dmo paramdmo)
  {
    AppMethodBeat.i(71661);
    if ((paramdmo.HAN == null) || (paramdmo.HAN.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramdmo = paramdmo.HAN.iterator();
    while (paramdmo.hasNext()) {
      if (((dml)paramdmo.next()).FsR != null)
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
  
  public static int cl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    afl localafl = new afl();
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
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyd, 1) == 0)
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
              localafl.Gdv = l;
              localafl.Gdw = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localafl.Gdv = l;
            localafl.Gdw = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localafl.Gdv, localafl.Gdw);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = al.gD(Color.parseColor(paramString));
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
    public abstract void a(cwq paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */