package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;
import java.util.Map;

public class b
  extends q
{
  private b.b uDo;
  private int uDp = 0;
  private boolean uDq = false;
  private b.a uDr;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public static b a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, b.b paramb, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean)
  {
    AppMethodBeat.i(48499);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(48499);
      return null;
    }
    Object localObject4 = c.umO.a(paramOrders);
    Object localObject1;
    Object localObject2;
    label153:
    Object localObject3;
    label189:
    String str2;
    String str1;
    double d;
    boolean bool;
    if (localObject4 != null) {
      if (paramFavorPayInfo != null)
      {
        localObject1 = paramFavorPayInfo;
        if (paramBankcard != null)
        {
          localObject1 = paramFavorPayInfo;
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.uhW))
          {
            localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject4).bJ(paramFavorPayInfo.uhU, false);
            localObject2 = (com.tencent.mm.plugin.wallet_core.ui.b.a)((com.tencent.mm.plugin.wallet_core.ui.b)localObject4).bI((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((com.tencent.mm.plugin.wallet_core.ui.b.a)localObject2).umL == null) || (bo.isNullOrNil(((com.tencent.mm.plugin.wallet_core.ui.b.a)localObject2).umL.tUv))) {
              break label485;
            }
            paramFavorPayInfo.uhU = ((com.tencent.mm.plugin.wallet_core.ui.b.a)localObject2).umL.tUv;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject4).cVp();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.ujl.get(0);
        localObject3 = new StringBuilder();
        if (!bo.isNullOrNil(paramFavorPayInfo.ppe)) {
          break label547;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.ujl.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.cnL;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label648;
        }
        localObject4 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject4).afD(((FavorPayInfo)localObject2).uhU);
        if ((localObject4 == null) || (((j)localObject4).tUw <= 0.0D)) {
          break label574;
        }
        d = ((j)localObject4).tUe;
        localObject3 = e.e(paramOrders.cnL, paramOrders.ppp);
        localObject1 = e.e(((j)localObject4).tUe, paramOrders.ppp);
        paramFavorPayInfo = paramContext.getString(2131305472, new Object[] { e.E(((j)localObject4).tUw) });
        bool = true;
      }
    }
    for (;;)
    {
      label329:
      if (paramBankcard == null)
      {
        str1 = "";
        label337:
        localObject4 = new b(paramContext);
        ((b)localObject4).usS = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).b(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).afL(str2);
        ((b)localObject4).f((String)localObject1, d);
        ((b)localObject4).afN((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label635;
        }
        ((b)localObject4).usD.setVisibility(0);
        ((b)localObject4).usD.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).uDq = paramBoolean;
        ((q)localObject4).usE.setEncrType(-10);
        ((b)localObject4).uDo = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(48499);
        return localObject4;
        label485:
        paramFavorPayInfo.uhU = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.ujm == null) {
          break;
        }
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.b)localObject4).afG(((com.tencent.mm.plugin.wallet_core.ui.b)localObject4).afH(paramOrders.ujm.tUf));
        break;
        ab.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label547:
        paramFavorPayInfo = paramFavorPayInfo.ppe + "\n";
        break label189;
        label574:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(2131305527);
          bool = true;
          localObject1 = str1;
          break label329;
        }
        localObject1 = e.e(paramOrders.cnL, paramOrders.ppp);
        bool = false;
        break label329;
        str1 = paramBankcard.field_desc;
        break label337;
        label635:
        ((b)localObject4).usD.setVisibility(8);
      }
      label648:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void aA(Context paramContext)
  {
    AppMethodBeat.i(156473);
    fr(paramContext);
    super.fs(paramContext);
    if (this.usT != null) {
      this.usT.setVisibility(8);
    }
    AppMethodBeat.o(156473);
  }
  
  public final void cVU()
  {
    AppMethodBeat.i(48500);
    if (this.usP != null) {
      this.usP.onClick(this, 0);
    }
    dismiss();
    if (this.uDo != null)
    {
      if (this.uDq)
      {
        if (this.uDp == 0)
        {
          Context localContext = getContext();
          Object localObject = new b.a(this, this.usE.getText(), this.usS, this.tVQ, this.usQ, this.NW, this.utl, this.uDo);
          b.1 local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b.1(localContext, (b.a)localObject);
            local1.uDp = 1;
            local1.uDq = true;
            local1.uDr = ((b.a)localObject);
            if (local1.uDr != null)
            {
              local1.b(local1.uDr.uDy);
              local1.setOnCancelListener(local1.uDr.uDy);
              local1.setCancelable(true);
              if (local1.uDr.uDu != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.uDr.uDu.field_desc)
          {
            local1.f((String)localObject, 0.0D);
            local1.nQ(false);
            local1.a(local1.uDr.utl);
            local1.uDo = local1.uDr.uDx;
            local1.usE.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(48500);
            return;
            AppMethodBeat.o(48500);
            return;
          }
        }
        if (this.uDp == 1)
        {
          this.uDo.a(this.uDr.uDt, this.usE.getText(), this.uDr.uDv);
          AppMethodBeat.o(48500);
          return;
        }
        ab.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(48500);
        return;
      }
      this.uDo.a(this.usE.getText(), "", this.tVQ);
    }
    AppMethodBeat.o(48500);
  }
  
  public final void fs(Context paramContext)
  {
    AppMethodBeat.i(156742);
    super.fs(paramContext);
    AppMethodBeat.o(156742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b
 * JD-Core Version:    0.7.0.1
 */