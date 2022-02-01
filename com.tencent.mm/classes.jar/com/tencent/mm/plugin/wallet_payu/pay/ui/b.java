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
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.plugin.wallet_core.ui.e.a;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.t;
import com.tencent.mm.plugin.wallet_core.ui.t.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;
import java.util.Map;

public class b
  extends t
{
  private b PmN;
  private int PmO = 0;
  private boolean PmP = false;
  private a PmQ;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public static b a(Context paramContext, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, b paramb, View.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean)
  {
    AppMethodBeat.i(72140);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(72140);
      return null;
    }
    Object localObject4 = f.OVk.a(paramOrders);
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.OPK))
          {
            localObject1 = ((e)localObject4).cU(paramFavorPayInfo.OPI, false);
            localObject2 = (e.a)((e)localObject4).cT((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((e.a)localObject2).OVi == null) || (Util.isNullOrNil(((e.a)localObject2).OVi.OwC))) {
              break label486;
            }
            paramFavorPayInfo.OPI = ((e.a)localObject2).OVi.OwC;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((e)localObject4).gLg();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.ORd.get(0);
        localObject3 = new StringBuilder();
        if (!Util.isNullOrNil(paramFavorPayInfo.GHo)) {
          break label548;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.ORd.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.fwy;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label649;
        }
        localObject4 = ((e)localObject4).bhs(((FavorPayInfo)localObject2).OPI);
        if ((localObject4 == null) || (((j)localObject4).OwD <= 0.0D)) {
          break label575;
        }
        d = ((j)localObject4).Owl;
        localObject3 = g.d(paramOrders.fwy, paramOrders.GHz);
        localObject1 = g.d(((j)localObject4).Owl, paramOrders.GHz);
        paramFavorPayInfo = paramContext.getString(a.i.wallet_pay_favor, new Object[] { g.formatMoney2f(((j)localObject4).OwD) });
        bool = true;
      }
    }
    for (;;)
    {
      label330:
      if (paramBankcard == null)
      {
        str1 = "";
        label338:
        localObject4 = new b(paramContext);
        ((b)localObject4).PbE = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).c(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).bhA(str2);
        ((b)localObject4).e((String)localObject1, d);
        ((b)localObject4).bhC((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label636;
        }
        ((b)localObject4).Pbp.setVisibility(0);
        ((b)localObject4).Pbp.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).PmP = paramBoolean;
        ((t)localObject4).Pbq.setEncrType(-10);
        ((b)localObject4).PmN = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(72140);
        return localObject4;
        label486:
        paramFavorPayInfo.OPI = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.ORe == null) {
          break;
        }
        localObject1 = ((e)localObject4).bhv(((e)localObject4).bhw(paramOrders.ORe.Owm));
        break;
        Log.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label548:
        paramFavorPayInfo = paramFavorPayInfo.GHo + "\n";
        break label189;
        label575:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(a.i.wallet_pwd_dialog_more_favors);
          bool = true;
          localObject1 = str1;
          break label330;
        }
        localObject1 = g.d(paramOrders.fwy, paramOrders.GHz);
        bool = false;
        break label330;
        str1 = paramBankcard.field_desc;
        break label338;
        label636:
        ((b)localObject4).Pbp.setVisibility(8);
      }
      label649:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void bv(Context paramContext)
  {
    AppMethodBeat.i(292660);
    iT(paramContext);
    super.iU(paramContext);
    if (this.PbF != null) {
      this.PbF.setVisibility(8);
    }
    AppMethodBeat.o(292660);
  }
  
  public final void gLK()
  {
    AppMethodBeat.i(72141);
    if (this.PbB != null) {
      this.PbB.onClick(this, 0);
    }
    dismiss();
    if (this.PmN != null)
    {
      if (this.PmP)
      {
        if (this.PmO == 0)
        {
          Context localContext = getContext();
          Object localObject = new a(this.Pbq.getText(), this.PbE, this.OxY, this.PbC, this.fs, this.PbY, this.PmN);
          b local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b(localContext)
            {
              public final int gLO()
              {
                AppMethodBeat.i(72137);
                int j = 3;
                int i = j;
                if (this.PmR.PmT != null)
                {
                  i = j;
                  if (this.PmR.PmT.field_bankcardClientType == 1)
                  {
                    Log.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                    i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.PmR.PmT).OUO;
                  }
                }
                if (i == 4)
                {
                  Log.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                  i = a.g.payu_full_cvv_4_dialog;
                  AppMethodBeat.o(72137);
                  return i;
                }
                i = a.g.payu_full_cvv_dialog;
                AppMethodBeat.o(72137);
                return i;
              }
            };
            local1.PmO = 1;
            local1.PmP = true;
            local1.PmQ = ((a)localObject);
            if (local1.PmQ != null)
            {
              local1.c(local1.PmQ.PmX);
              local1.setOnCancelListener(local1.PmQ.PmX);
              local1.setCancelable(true);
              if (local1.PmQ.PmT != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.PmQ.PmT.field_desc)
          {
            local1.e((String)localObject, 0.0D);
            local1.Cn(false);
            local1.a(local1.PmQ.PbY);
            local1.PmN = local1.PmQ.PmW;
            local1.Pbq.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(72141);
            return;
            AppMethodBeat.o(72141);
            return;
          }
        }
        if (this.PmO == 1)
        {
          this.PmN.a(this.PmQ.PmS, this.Pbq.getText(), this.PmQ.PmU);
          AppMethodBeat.o(72141);
          return;
        }
        Log.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(72141);
        return;
      }
      this.PmN.a(this.Pbq.getText(), "", this.OxY);
    }
    AppMethodBeat.o(72141);
  }
  
  public final void iU(Context paramContext)
  {
    AppMethodBeat.i(293268);
    super.iU(paramContext);
    AppMethodBeat.o(293268);
  }
  
  final class a
  {
    public t.a PbY;
    public String PmS;
    public Bankcard PmT;
    public FavorPayInfo PmU;
    public boolean PmV;
    public b.b PmW;
    public DialogInterface.OnCancelListener PmX;
    
    public a(String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, t.a parama, b.b paramb)
    {
      this.PmS = paramString;
      this.PmT = paramBankcard;
      this.PmU = paramFavorPayInfo;
      this.PmV = paramBoolean;
      this.PmX = paramOnCancelListener;
      this.PbY = parama;
      this.PmW = paramb;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, FavorPayInfo paramFavorPayInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b
 * JD-Core Version:    0.7.0.1
 */