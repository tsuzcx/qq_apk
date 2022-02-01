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
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;
import java.util.Map;

public class b
  extends s
{
  private b Dti;
  private int Dtj = 0;
  private boolean Dtk = false;
  private a Dtl;
  
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
    Object localObject4 = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(paramOrders);
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.CWN))
          {
            localObject1 = ((d)localObject4).cj(paramFavorPayInfo.CWL, false);
            localObject2 = (d.a)((d)localObject4).ci((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((d.a)localObject2).Dcb == null) || (bt.isNullOrNil(((d.a)localObject2).Dcb.CHp))) {
              break label485;
            }
            paramFavorPayInfo.CWL = ((d.a)localObject2).Dcb.CHp;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((d)localObject4).eHm();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.CYk.get(0);
        localObject3 = new StringBuilder();
        if (!bt.isNullOrNil(paramFavorPayInfo.wCu)) {
          break label547;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.CYk.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.dlx;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label648;
        }
        localObject4 = ((d)localObject4).aEO(((FavorPayInfo)localObject2).CWL);
        if ((localObject4 == null) || (((j)localObject4).CHq <= 0.0D)) {
          break label574;
        }
        d = ((j)localObject4).CGY;
        localObject3 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dlx, paramOrders.wCF);
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject4).CGY, paramOrders.wCF);
        paramFavorPayInfo = paramContext.getString(2131765686, new Object[] { com.tencent.mm.wallet_core.ui.e.C(((j)localObject4).CHq) });
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
        ((b)localObject4).Diy = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).b(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).aEW(str2);
        ((b)localObject4).d((String)localObject1, d);
        ((b)localObject4).aEY((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label635;
        }
        ((b)localObject4).Dij.setVisibility(0);
        ((b)localObject4).Dij.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).Dtk = paramBoolean;
        ((s)localObject4).Dik.setEncrType(-10);
        ((b)localObject4).Dti = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(72140);
        return localObject4;
        label485:
        paramFavorPayInfo.CWL = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.CYl == null) {
          break;
        }
        localObject1 = ((d)localObject4).aER(((d)localObject4).aES(paramOrders.CYl.CGZ));
        break;
        ad.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label547:
        paramFavorPayInfo = paramFavorPayInfo.wCu + "\n";
        break label189;
        label574:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(2131765742);
          bool = true;
          localObject1 = str1;
          break label329;
        }
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dlx, paramOrders.wCF);
        bool = false;
        break label329;
        str1 = paramBankcard.field_desc;
        break label337;
        label635:
        ((b)localObject4).Dij.setVisibility(8);
      }
      label648:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void aM(Context paramContext)
  {
    AppMethodBeat.i(199363);
    gN(paramContext);
    super.gO(paramContext);
    if (this.Diz != null) {
      this.Diz.setVisibility(8);
    }
    AppMethodBeat.o(199363);
  }
  
  public final void eHR()
  {
    AppMethodBeat.i(72141);
    if (this.Div != null) {
      this.Div.onClick(this, 0);
    }
    dismiss();
    if (this.Dti != null)
    {
      if (this.Dtk)
      {
        if (this.Dtj == 0)
        {
          Context localContext = getContext();
          Object localObject = new a(this.Dik.getText(), this.Diy, this.CIL, this.Diw, this.XL, this.DiR, this.Dti);
          b local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b(localContext)
            {
              public final int cus()
              {
                AppMethodBeat.i(72137);
                int j = 3;
                int i = j;
                if (this.Dtm.Dto != null)
                {
                  i = j;
                  if (this.Dtm.Dto.field_bankcardClientType == 1)
                  {
                    ad.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                    i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.Dtm.Dto).DbN;
                  }
                }
                if (i == 4)
                {
                  ad.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                  AppMethodBeat.o(72137);
                  return 2131495068;
                }
                AppMethodBeat.o(72137);
                return 2131495069;
              }
            };
            local1.Dtj = 1;
            local1.Dtk = true;
            local1.Dtl = ((a)localObject);
            if (local1.Dtl != null)
            {
              local1.b(local1.Dtl.Dts);
              local1.setOnCancelListener(local1.Dtl.Dts);
              local1.setCancelable(true);
              if (local1.Dtl.Dto != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.Dtl.Dto.field_desc)
          {
            local1.d((String)localObject, 0.0D);
            local1.uw(false);
            local1.a(local1.Dtl.DiR);
            local1.Dti = local1.Dtl.Dtr;
            local1.Dik.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(72141);
            return;
            AppMethodBeat.o(72141);
            return;
          }
        }
        if (this.Dtj == 1)
        {
          this.Dti.a(this.Dtl.Dtn, this.Dik.getText(), this.Dtl.Dtp);
          AppMethodBeat.o(72141);
          return;
        }
        ad.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(72141);
        return;
      }
      this.Dti.a(this.Dik.getText(), "", this.CIL);
    }
    AppMethodBeat.o(72141);
  }
  
  public final void gO(Context paramContext)
  {
    AppMethodBeat.i(221336);
    super.gO(paramContext);
    AppMethodBeat.o(221336);
  }
  
  final class a
  {
    public s.a DiR;
    public String Dtn;
    public Bankcard Dto;
    public FavorPayInfo Dtp;
    public boolean Dtq;
    public b.b Dtr;
    public DialogInterface.OnCancelListener Dts;
    
    public a(String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, s.a parama, b.b paramb)
    {
      this.Dtn = paramString;
      this.Dto = paramBankcard;
      this.Dtp = paramFavorPayInfo;
      this.Dtq = paramBoolean;
      this.Dts = paramOnCancelListener;
      this.DiR = parama;
      this.Dtr = paramb;
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