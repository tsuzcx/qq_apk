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
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.dql;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class g
{
  private static CharSequence a(final Context paramContext, final dgy paramdgy, a parama)
  {
    AppMethodBeat.i(71666);
    SpannableString localSpannableString = new SpannableString(paramdgy.text);
    int i = 1;
    int j = 1;
    long l2;
    long l1;
    if (aj.DT()) {
      if (paramdgy.FQd == null)
      {
        l2 = -1L;
        paramdgy.FQd = new adk();
        if ((paramdgy.FQa == Long.parseLong("ff000000", 16)) || (paramdgy.FQa == 0L))
        {
          l2 = Long.parseLong("CCFFFFFF", 16);
          l1 = l2;
          i = j;
          if (l2 == -1L)
          {
            l2 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdgy.FQd.EvZ, paramdgy.FQd.Ewa);
            l1 = l2;
            i = j;
            if (l2 == -1L)
            {
              l1 = aj.gy((int)paramdgy.FQa);
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
      Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)paramdgy.size), ColorStateList.valueOf(i));
      localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      if (!bs.isNullOrNil(paramdgy.FQb)) {
        ((WcPayTextApppearanceSpan)localObject).BNN = e.cl(paramContext, paramdgy.FQb);
      }
      localObject = null;
      if (paramdgy.FQc == 1) {
        localObject = new StrikethroughSpan();
      }
      for (;;)
      {
        if (localObject != null) {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
        }
        if ((paramdgy.DNL != null) && (paramdgy.DNL.type != 0))
        {
          paramdgy = paramdgy.DNL;
          ac.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramdgy.type) });
          localSpannableString.setSpan(new q(new q.a()
          {
            public final void dK(View paramAnonymousView)
            {
              AppMethodBeat.i(71651);
              if (this.BNO != null)
              {
                g.a(paramContext, paramdgy, null);
                this.BNO.a(paramdgy);
                AppMethodBeat.o(71651);
                return;
              }
              g.a(paramContext, paramdgy, null);
              AppMethodBeat.o(71651);
            }
          }), 0, localSpannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return localSpannableString;
        if (paramdgy.FQa == Long.parseLong("78000000", 16))
        {
          l2 = Long.parseLong("80FFFFFF", 16);
          break;
        }
        paramdgy.FQd.EvZ = paramdgy.FQa;
        paramdgy.FQd.Ewa = -1L;
        break;
        l1 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramdgy.FQd.EvZ, paramdgy.FQd.Ewa);
        i = j;
        break label159;
        l1 = paramdgy.FQa;
        j = (int)l1;
        break label164;
        if (paramdgy.FQc == 2) {
          localObject = new UnderlineSpan();
        }
      }
    }
  }
  
  public static CharSequence a(Context paramContext, dhb paramdhb, a parama)
  {
    AppMethodBeat.i(71665);
    if ((paramdhb == null) || (paramdhb.FQj == null) || (paramdhb.FQj.isEmpty()))
    {
      AppMethodBeat.o(71665);
      return "";
    }
    int j = paramdhb.FQj.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (dgy)paramdhb.FQj.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(71665);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, dhb paramdhb)
  {
    AppMethodBeat.i(71671);
    paramContext = a(paramContext, paramdhb, null).toString();
    AppMethodBeat.o(71671);
    return paramContext;
  }
  
  public static void a(Context paramContext, crj paramcrj, Bundle paramBundle)
  {
    int i = 1000;
    AppMethodBeat.i(71667);
    if (paramcrj == null)
    {
      AppMethodBeat.o(71667);
      return;
    }
    ac.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(paramcrj.type), paramcrj.url });
    if (paramcrj.type == 1)
    {
      e.n(paramContext, paramcrj.url, true);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcrj.type == 2)
    {
      if (paramcrj.FEf == null)
      {
        ac.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(71667);
        return;
      }
      if (paramBundle != null) {
        i = paramBundle.getInt("key_tiny_app_scene", 1000);
      }
      e.v(paramcrj.FEf.username, paramcrj.FEf.path, paramcrj.FEf.version, i);
      AppMethodBeat.o(71667);
      return;
    }
    if (paramcrj.type != 3) {
      if (paramcrj.type == 4)
      {
        if (paramcrj.url.equals("balance"))
        {
          d.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcrj.url.equals("bankCard"))
        {
          paramcrj = new Intent();
          paramcrj.putExtra("intent_finish_self", true);
          d.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", paramcrj, 65281);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcrj.url.equals("qmfCard"))
        {
          d.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcrj.url.equals("paySecurity"))
        {
          paramcrj = new Intent();
          paramcrj.putExtra("wallet_lock_jsapi_scene", 1);
          d.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramcrj, 65282);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcrj.url.equals("lqt"))
        {
          paramcrj = new Intent();
          paramcrj.putExtra("key_account_type", 1);
          d.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramcrj, 65286);
          AppMethodBeat.o(71667);
          return;
        }
        if (paramcrj.url.equals("realname"))
        {
          paramcrj = new Bundle();
          paramcrj.putInt("real_name_verify_mode", 0);
          paramcrj.putInt("entry_scene", 0);
          if (paramBundle != null) {
            paramcrj.putAll(paramBundle);
          }
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramcrj);
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcrj.type == 5)
      {
        if (paramcrj.url.equals("wxpay://lqp/balanceQuotaState"))
        {
          d.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(71667);
        }
      }
      else if (paramcrj.type == 13)
      {
        if (paramcrj.FEj != null) {
          AppMethodBeat.o(71667);
        }
      }
      else
      {
        ac.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(paramcrj.type), paramcrj.url });
      }
    }
    AppMethodBeat.o(71667);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, dql paramdql)
  {
    AppMethodBeat.i(71668);
    if (paramdql == null)
    {
      AppMethodBeat.o(71668);
      return;
    }
    a(paramMarginLayoutParams, paramdql.FXM);
    a(paramView, paramdql.FEc);
    AppMethodBeat.o(71668);
  }
  
  public static void a(View paramView, ccn paramccn)
  {
    AppMethodBeat.i(71669);
    if (paramccn == null)
    {
      AppMethodBeat.o(71669);
      return;
    }
    int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)paramccn.top);
    int j = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)paramccn.bottom);
    paramView.setPadding(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)paramccn.left), i, com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)paramccn.right), j);
    AppMethodBeat.o(71669);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, btl parambtl)
  {
    AppMethodBeat.i(71670);
    if (parambtl == null)
    {
      AppMethodBeat.o(71670);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)parambtl.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)parambtl.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)parambtl.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)parambtl.right);
    AppMethodBeat.o(71670);
  }
  
  public static void a(TextView paramTextView, dhb paramdhb, a parama)
  {
    AppMethodBeat.i(71660);
    if (a(paramdhb))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new n(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramdhb, parama));
    AppMethodBeat.o(71660);
  }
  
  public static void a(CdnImageView paramCdnImageView, bld parambld)
  {
    AppMethodBeat.i(71662);
    a(paramCdnImageView, parambld, -1, 0, 0, true);
    AppMethodBeat.o(71662);
  }
  
  public static void a(CdnImageView paramCdnImageView, bld parambld, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(71664);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)parambld.width);
    int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)parambld.height);
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
        paramCdnImageView.r(parambld.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(71664);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, bld parambld, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(71663);
    a(paramCdnImageView, parambld, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(71663);
  }
  
  private static boolean a(dhb paramdhb)
  {
    AppMethodBeat.i(71661);
    if ((paramdhb.FQj == null) || (paramdhb.FQj.isEmpty()))
    {
      AppMethodBeat.o(71661);
      return false;
    }
    paramdhb = paramdhb.FQj.iterator();
    while (paramdhb.hasNext()) {
      if (((dgy)paramdhb.next()).DNL != null)
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
  
  public static int cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(162279);
    adk localadk = new adk();
    if (paramString == null)
    {
      AppMethodBeat.o(162279);
      return 0;
    }
    int i;
    if (!aj.DT())
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(162279);
      return i;
    }
    for (;;)
    {
      try
      {
        if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTx, 1) == 0)
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
              localadk.EvZ = l;
              localadk.Ewa = -1L;
              l = -1L;
              continue;
            }
          }
          else
          {
            localadk.EvZ = l;
            localadk.Ewa = -1L;
            l = -1L;
            continue;
          }
          l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(localadk.EvZ, localadk.Ewa);
          if (l != -1L)
          {
            i = argbColor(l);
            AppMethodBeat.o(162279);
            return i;
          }
          i = aj.gy(Color.parseColor(paramString));
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
    public abstract void a(crj paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */