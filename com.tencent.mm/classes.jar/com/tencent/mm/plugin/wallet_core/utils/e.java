package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class e
{
  private static CharSequence a(Context paramContext, cju paramcju, a parama)
  {
    AppMethodBeat.i(48031);
    SpannableString localSpannableString = new SpannableString(paramcju.text);
    int i = (int)paramcju.xTK;
    if ((paramcju.xTK & 0xFF000000) == 0L) {
      i = (int)(paramcju.xTK | 0xFF000000);
    }
    Object localObject = new WcPayTextApppearanceSpan(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)paramcju.size), ColorStateList.valueOf(i));
    localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
    if (!bo.isNullOrNil(paramcju.xTL)) {
      ((WcPayTextApppearanceSpan)localObject).uyn = com.tencent.mm.wallet_core.ui.e.bS(paramContext, paramcju.xTL);
    }
    localObject = null;
    if (paramcju.xTM == 1) {
      localObject = new StrikethroughSpan();
    }
    for (;;)
    {
      if (localObject != null) {
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 17);
      }
      if ((paramcju.wna != null) && (paramcju.wna.type != 0))
      {
        paramcju = paramcju.wna;
        ab.i("MicroMsg.WcPayViewEngineRender", "route type: %s", new Object[] { Integer.valueOf(paramcju.type) });
        localSpannableString.setSpan(new o(new e.1(parama, paramcju, paramContext)), 0, localSpannableString.length(), 17);
      }
      AppMethodBeat.o(48031);
      return localSpannableString;
      if (paramcju.xTM == 2) {
        localObject = new UnderlineSpan();
      }
    }
  }
  
  public static CharSequence a(Context paramContext, cjw paramcjw, a parama)
  {
    AppMethodBeat.i(48030);
    if ((paramcjw == null) || (paramcjw.xTN == null) || (paramcjw.xTN.isEmpty()))
    {
      AppMethodBeat.o(48030);
      return "";
    }
    int j = paramcjw.xTN.size();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append(a(paramContext, (cju)paramcjw.xTN.get(i), parama));
      i += 1;
    }
    AppMethodBeat.o(48030);
    return localSpannableStringBuilder;
  }
  
  public static String a(Context paramContext, cjw paramcjw)
  {
    AppMethodBeat.i(48036);
    paramContext = a(paramContext, paramcjw, null).toString();
    AppMethodBeat.o(48036);
    return paramContext;
  }
  
  public static void a(Context paramContext, bvz parambvz)
  {
    AppMethodBeat.i(48032);
    if (parambvz == null)
    {
      AppMethodBeat.o(48032);
      return;
    }
    ab.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", new Object[] { Integer.valueOf(parambvz.type), parambvz.url });
    if (parambvz.type == 1)
    {
      com.tencent.mm.wallet_core.ui.e.m(paramContext, parambvz.url, true);
      AppMethodBeat.o(48032);
      return;
    }
    if (parambvz.type == 2)
    {
      if (parambvz.xJx == null)
      {
        ab.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
        AppMethodBeat.o(48032);
        return;
      }
      com.tencent.mm.wallet_core.ui.e.q(parambvz.xJx.username, parambvz.xJx.path, parambvz.xJx.version, 1000);
      AppMethodBeat.o(48032);
      return;
    }
    if (parambvz.type != 3) {
      if (parambvz.type == 4)
      {
        if (parambvz.url.equals("balance"))
        {
          d.c(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
          AppMethodBeat.o(48032);
          return;
        }
        if (parambvz.url.equals("bankCard"))
        {
          parambvz = new Intent();
          parambvz.putExtra("intent_finish_self", true);
          d.b(paramContext, "wallet", ".bind.ui.WalletBankcardManageUI", parambvz, 65281);
          AppMethodBeat.o(48032);
          return;
        }
        if (parambvz.url.equals("qmfCard"))
        {
          d.b(paramContext, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
          AppMethodBeat.o(48032);
          return;
        }
        if (parambvz.url.equals("paySecurity"))
        {
          parambvz = new Intent();
          parambvz.putExtra("wallet_lock_jsapi_scene", 1);
          d.b(paramContext, "wallet", ".pwd.ui.WalletSecuritySettingUI", parambvz, 65282);
          AppMethodBeat.o(48032);
          return;
        }
        if (parambvz.url.equals("lqt"))
        {
          parambvz = new Intent();
          parambvz.putExtra("key_account_type", 1);
          d.b(paramContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", parambvz, 65286);
          AppMethodBeat.o(48032);
          return;
        }
        if (parambvz.url.equals("realname"))
        {
          parambvz = new Bundle();
          parambvz.putInt("real_name_verify_mode", 0);
          parambvz.putInt("entry_scene", 0);
          Assert.assertTrue("context must be activity", paramContext instanceof Activity);
          com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, parambvz);
          AppMethodBeat.o(48032);
        }
      }
      else if (parambvz.type == 5)
      {
        if (parambvz.url.equals("balanceQuotaState"))
        {
          d.b(paramContext, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
          AppMethodBeat.o(48032);
        }
      }
      else if (parambvz.type == 13)
      {
        if (parambvz.xJB != null) {
          AppMethodBeat.o(48032);
        }
      }
      else
      {
        ab.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", new Object[] { Integer.valueOf(parambvz.type), parambvz.url });
      }
    }
    AppMethodBeat.o(48032);
  }
  
  public static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, cra paramcra)
  {
    AppMethodBeat.i(48033);
    if (paramcra == null)
    {
      AppMethodBeat.o(48033);
      return;
    }
    a(paramMarginLayoutParams, paramcra.xZE);
    a(paramView, paramcra.xJu);
    AppMethodBeat.o(48033);
  }
  
  public static void a(View paramView, bkd parambkd)
  {
    AppMethodBeat.i(48034);
    if (parambkd == null)
    {
      AppMethodBeat.o(48034);
      return;
    }
    int i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambkd.top);
    int j = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambkd.bottom);
    paramView.setPadding(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambkd.left), i, com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambkd.right), j);
    AppMethodBeat.o(48034);
  }
  
  private static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, bck parambck)
  {
    AppMethodBeat.i(48035);
    if (parambck == null)
    {
      AppMethodBeat.o(48035);
      return;
    }
    paramMarginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambck.top);
    paramMarginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambck.bottom);
    paramMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambck.left);
    paramMarginLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)parambck.right);
    AppMethodBeat.o(48035);
  }
  
  public static void a(TextView paramTextView, cjw paramcjw, a parama)
  {
    AppMethodBeat.i(48025);
    if (a(paramcjw))
    {
      paramTextView.setClickable(true);
      paramTextView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(paramTextView.getContext()));
    }
    paramTextView.setText(a(paramTextView.getContext(), paramcjw, parama));
    AppMethodBeat.o(48025);
  }
  
  public static void a(CdnImageView paramCdnImageView, awf paramawf)
  {
    AppMethodBeat.i(48027);
    a(paramCdnImageView, paramawf, -1, 0, 0, true);
    AppMethodBeat.o(48027);
  }
  
  public static void a(CdnImageView paramCdnImageView, awf paramawf, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(48029);
    paramCdnImageView.setUseSdcardCache(paramBoolean);
    int j = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)paramawf.width);
    int i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)paramawf.height);
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
        paramCdnImageView.o(paramawf.url, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(48029);
        return;
        paramInt3 = i;
      }
      paramInt2 = j;
    }
  }
  
  public static void a(CdnImageView paramCdnImageView, awf paramawf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(48028);
    a(paramCdnImageView, paramawf, paramInt, 0, 0, paramBoolean);
    AppMethodBeat.o(48028);
  }
  
  private static boolean a(cjw paramcjw)
  {
    AppMethodBeat.i(48026);
    if ((paramcjw.xTN == null) || (paramcjw.xTN.isEmpty()))
    {
      AppMethodBeat.o(48026);
      return false;
    }
    paramcjw = paramcjw.xTN.iterator();
    while (paramcjw.hasNext()) {
      if (((cju)paramcjw.next()).wna != null)
      {
        AppMethodBeat.o(48026);
        return true;
      }
    }
    AppMethodBeat.o(48026);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(bvz paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e
 * JD-Core Version:    0.7.0.1
 */