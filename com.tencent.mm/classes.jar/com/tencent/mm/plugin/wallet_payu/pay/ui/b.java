package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.a;
import com.tencent.mm.plugin.wallet_core.ui.a.a;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;
import java.util.Map;

public class b
  extends o
{
  private b.b qOh;
  private int qOi = 0;
  private boolean qOj = false;
  private b.a qOk;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public static b a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, b.b paramb, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    Object localObject4 = com.tencent.mm.plugin.wallet_core.ui.b.qAd.a(paramOrders);
    Object localObject1;
    Object localObject2;
    label150:
    Object localObject3;
    label186:
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.qvE))
          {
            localObject1 = ((a)localObject4).bk(paramFavorPayInfo.qvC, false);
            localObject2 = (a.a)((a)localObject4).bj((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((a.a)localObject2).qAa == null) || (bk.bl(((a.a)localObject2).qAa.qlk))) {
              break label483;
            }
            paramFavorPayInfo.qvC = ((a.a)localObject2).qAa.qlk;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((a)localObject4).bWr();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.qwN.get(0);
        localObject3 = new StringBuilder();
        if (!bk.bl(paramFavorPayInfo.mOO)) {
          break label545;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.qwN.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.nCq;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label646;
        }
        localObject4 = ((a)localObject4).QF(((FavorPayInfo)localObject2).qvC);
        if ((localObject4 == null) || (((com.tencent.mm.plugin.wallet.a.h)localObject4).qll <= 0.0D)) {
          break label572;
        }
        bool = true;
        d = ((com.tencent.mm.plugin.wallet.a.h)localObject4).qkV;
        localObject3 = e.d(paramOrders.nCq, paramOrders.mOZ);
        localObject1 = e.d(((com.tencent.mm.plugin.wallet.a.h)localObject4).qkV, paramOrders.mOZ);
        paramFavorPayInfo = paramContext.getString(a.i.wallet_pay_favor, new Object[] { e.A(((com.tencent.mm.plugin.wallet.a.h)localObject4).qll) });
      }
    }
    for (;;)
    {
      label327:
      if (paramBankcard == null)
      {
        str1 = "";
        label335:
        localObject4 = new b(paramContext);
        ((b)localObject4).qFM = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).bWW();
        ((b)localObject4).a(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).QN(str2);
        ((b)localObject4).d((String)localObject1, d);
        ((b)localObject4).QP((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label633;
        }
        ((b)localObject4).qFx.setVisibility(0);
        ((b)localObject4).qFx.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).qOj = paramBoolean;
        ((o)localObject4).qFy.setEncrType(-10);
        ((b)localObject4).qOh = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        return localObject4;
        label483:
        paramFavorPayInfo.qvC = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.qwO == null) {
          break;
        }
        localObject1 = ((a)localObject4).QI(((a)localObject4).QJ(paramOrders.qwO.qkW));
        break;
        y.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label150;
        label545:
        paramFavorPayInfo = paramFavorPayInfo.mOO + "\n";
        break label186;
        label572:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_more_favors);
          bool = true;
          localObject1 = str1;
          break label327;
        }
        localObject1 = e.d(paramOrders.nCq, paramOrders.mOZ);
        bool = false;
        break label327;
        str1 = paramBankcard.field_desc;
        break label335;
        label633:
        ((b)localObject4).qFx.setVisibility(8);
      }
      label646:
      bool = false;
      localObject1 = str1;
    }
  }
  
  protected final void bWR()
  {
    if (this.qFJ != null) {
      this.qFJ.onClick(this, 0);
    }
    dismiss();
    Context localContext;
    b.1 local1;
    if (this.qOh != null)
    {
      if (!this.qOj) {
        break label296;
      }
      if (this.qOi != 0) {
        break label247;
      }
      localContext = getContext();
      localObject = new b.a(this, this.qFy.getText(), this.qFM, this.qmA, this.qFK, this.Oi, this.qGg, this.qOh);
      if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
      {
        local1 = new b.1(localContext, (b.a)localObject);
        local1.qOi = 1;
        local1.qOj = true;
        local1.qOk = ((b.a)localObject);
        if (local1.qOk != null)
        {
          local1.bWW();
          local1.a(local1.qOk.qOr);
          local1.setOnCancelListener(local1.qOk.qOr);
          local1.setCancelable(true);
          if (local1.qOk.qOn != null) {
            break label233;
          }
        }
      }
    }
    label233:
    for (Object localObject = "";; localObject = local1.qOk.qOn.field_desc)
    {
      local1.d((String)localObject, 0.0D);
      local1.kJ(false);
      local1.qGg = local1.qOk.qGg;
      local1.qOh = local1.qOk.qOq;
      local1.qFy.setEncrType(30);
      local1.show();
      com.tencent.mm.ui.base.h.a(localContext, local1);
      return;
    }
    label247:
    if (this.qOi == 1)
    {
      this.qOh.a(this.qOk.qOm, this.qFy.getText(), this.qOk.qOo);
      return;
    }
    y.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
    return;
    label296:
    this.qOh.a(this.qFy.getText(), "", this.qmA);
  }
  
  protected final void ca(Context paramContext)
  {
    et(paramContext);
    super.eu(paramContext);
    if (this.qFN != null) {
      this.qFN.setVisibility(8);
    }
  }
  
  protected final void eu(Context paramContext)
  {
    super.eu(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b
 * JD-Core Version:    0.7.0.1
 */