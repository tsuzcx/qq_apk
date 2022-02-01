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
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.d.a;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;
import java.util.Map;

public class b
  extends s
{
  private b DKN;
  private int DKO = 0;
  private boolean DKP = false;
  private a DKQ;
  
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
    Object localObject4 = e.DtH.a(paramOrders);
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.Dos))
          {
            localObject1 = ((d)localObject4).cn(paramFavorPayInfo.Doq, false);
            localObject2 = (d.a)((d)localObject4).cm((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((d.a)localObject2).DtF == null) || (bu.isNullOrNil(((d.a)localObject2).DtF.CYV))) {
              break label485;
            }
            paramFavorPayInfo.Doq = ((d.a)localObject2).DtF.CYV;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((d)localObject4).eKU();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.DpP.get(0);
        localObject3 = new StringBuilder();
        if (!bu.isNullOrNil(paramFavorPayInfo.wSf)) {
          break label547;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.DpP.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.dmz;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label648;
        }
        localObject4 = ((d)localObject4).aGi(((FavorPayInfo)localObject2).Doq);
        if ((localObject4 == null) || (((j)localObject4).CYW <= 0.0D)) {
          break label574;
        }
        d = ((j)localObject4).CYE;
        localObject3 = f.d(paramOrders.dmz, paramOrders.wSq);
        localObject1 = f.d(((j)localObject4).CYE, paramOrders.wSq);
        paramFavorPayInfo = paramContext.getString(2131765686, new Object[] { f.C(((j)localObject4).CYW) });
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
        ((b)localObject4).DAc = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).b(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).aGq(str2);
        ((b)localObject4).d((String)localObject1, d);
        ((b)localObject4).aGs((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label635;
        }
        ((b)localObject4).DzN.setVisibility(0);
        ((b)localObject4).DzN.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).DKP = paramBoolean;
        ((s)localObject4).DzO.setEncrType(-10);
        ((b)localObject4).DKN = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(72140);
        return localObject4;
        label485:
        paramFavorPayInfo.Doq = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.DpQ == null) {
          break;
        }
        localObject1 = ((d)localObject4).aGl(((d)localObject4).aGm(paramOrders.DpQ.CYF));
        break;
        ae.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label547:
        paramFavorPayInfo = paramFavorPayInfo.wSf + "\n";
        break label189;
        label574:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(2131765742);
          bool = true;
          localObject1 = str1;
          break label329;
        }
        localObject1 = f.d(paramOrders.dmz, paramOrders.wSq);
        bool = false;
        break label329;
        str1 = paramBankcard.field_desc;
        break label337;
        label635:
        ((b)localObject4).DzN.setVisibility(8);
      }
      label648:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void aN(Context paramContext)
  {
    AppMethodBeat.i(190247);
    gS(paramContext);
    super.gT(paramContext);
    if (this.DAd != null) {
      this.DAd.setVisibility(8);
    }
    AppMethodBeat.o(190247);
  }
  
  public final void eLz()
  {
    AppMethodBeat.i(72141);
    if (this.DzZ != null) {
      this.DzZ.onClick(this, 0);
    }
    dismiss();
    if (this.DKN != null)
    {
      if (this.DKP)
      {
        if (this.DKO == 0)
        {
          Context localContext = getContext();
          Object localObject = new a(this.DzO.getText(), this.DAc, this.Dar, this.DAa, this.XL, this.DAv, this.DKN);
          b local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b(localContext)
            {
              public final int cvT()
              {
                AppMethodBeat.i(72137);
                int j = 3;
                int i = j;
                if (this.DKR.DKT != null)
                {
                  i = j;
                  if (this.DKR.DKT.field_bankcardClientType == 1)
                  {
                    ae.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                    i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.DKR.DKT).Dtr;
                  }
                }
                if (i == 4)
                {
                  ae.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                  AppMethodBeat.o(72137);
                  return 2131495068;
                }
                AppMethodBeat.o(72137);
                return 2131495069;
              }
            };
            local1.DKO = 1;
            local1.DKP = true;
            local1.DKQ = ((a)localObject);
            if (local1.DKQ != null)
            {
              local1.b(local1.DKQ.DKX);
              local1.setOnCancelListener(local1.DKQ.DKX);
              local1.setCancelable(true);
              if (local1.DKQ.DKT != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.DKQ.DKT.field_desc)
          {
            local1.d((String)localObject, 0.0D);
            local1.uE(false);
            local1.a(local1.DKQ.DAv);
            local1.DKN = local1.DKQ.DKW;
            local1.DzO.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(72141);
            return;
            AppMethodBeat.o(72141);
            return;
          }
        }
        if (this.DKO == 1)
        {
          this.DKN.a(this.DKQ.DKS, this.DzO.getText(), this.DKQ.DKU);
          AppMethodBeat.o(72141);
          return;
        }
        ae.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(72141);
        return;
      }
      this.DKN.a(this.DzO.getText(), "", this.Dar);
    }
    AppMethodBeat.o(72141);
  }
  
  public final void gT(Context paramContext)
  {
    AppMethodBeat.i(224238);
    super.gT(paramContext);
    AppMethodBeat.o(224238);
  }
  
  final class a
  {
    public s.a DAv;
    public String DKS;
    public Bankcard DKT;
    public FavorPayInfo DKU;
    public boolean DKV;
    public b.b DKW;
    public DialogInterface.OnCancelListener DKX;
    
    public a(String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, s.a parama, b.b paramb)
    {
      this.DKS = paramString;
      this.DKT = paramBankcard;
      this.DKU = paramFavorPayInfo;
      this.DKV = paramBoolean;
      this.DKX = paramOnCancelListener;
      this.DAv = parama;
      this.DKW = paramb;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, FavorPayInfo paramFavorPayInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b
 * JD-Core Version:    0.7.0.1
 */