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
  private b AAt;
  private int AAu = 0;
  private boolean AAv = false;
  private a AAw;
  
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
    Object localObject4 = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(paramOrders);
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.Aed))
          {
            localObject1 = ((d)localObject4).bU(paramFavorPayInfo.Aeb, false);
            localObject2 = (d.a)((d)localObject4).bT((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((d.a)localObject2).Ajn == null) || (bt.isNullOrNil(((d.a)localObject2).Ajn.zOH))) {
              break label485;
            }
            paramFavorPayInfo.Aeb = ((d.a)localObject2).Ajn.zOH;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((d)localObject4).edL();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.Afx.get(0);
        localObject3 = new StringBuilder();
        if (!bt.isNullOrNil(paramFavorPayInfo.uoe)) {
          break label547;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.Afx.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.dcH;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label648;
        }
        localObject4 = ((d)localObject4).aum(((FavorPayInfo)localObject2).Aeb);
        if ((localObject4 == null) || (((j)localObject4).zOI <= 0.0D)) {
          break label574;
        }
        d = ((j)localObject4).zOq;
        localObject3 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dcH, paramOrders.uop);
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject4).zOq, paramOrders.uop);
        paramFavorPayInfo = paramContext.getString(2131765686, new Object[] { com.tencent.mm.wallet_core.ui.e.D(((j)localObject4).zOI) });
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
        ((b)localObject4).ApM = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).b(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).auv(str2);
        ((b)localObject4).d((String)localObject1, d);
        ((b)localObject4).aux((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label635;
        }
        ((b)localObject4).Apx.setVisibility(0);
        ((b)localObject4).Apx.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).AAv = paramBoolean;
        ((s)localObject4).Apy.setEncrType(-10);
        ((b)localObject4).AAt = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(72140);
        return localObject4;
        label485:
        paramFavorPayInfo.Aeb = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.Afy == null) {
          break;
        }
        localObject1 = ((d)localObject4).aup(((d)localObject4).auq(paramOrders.Afy.zOr));
        break;
        ad.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label547:
        paramFavorPayInfo = paramFavorPayInfo.uoe + "\n";
        break label189;
        label574:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(2131765742);
          bool = true;
          localObject1 = str1;
          break label329;
        }
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.dcH, paramOrders.uop);
        bool = false;
        break label329;
        str1 = paramBankcard.field_desc;
        break label337;
        label635:
        ((b)localObject4).Apx.setVisibility(8);
      }
      label648:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void aL(Context paramContext)
  {
    AppMethodBeat.i(196945);
    gw(paramContext);
    super.gx(paramContext);
    if (this.ApN != null) {
      this.ApN.setVisibility(8);
    }
    AppMethodBeat.o(196945);
  }
  
  public final void eeq()
  {
    AppMethodBeat.i(72141);
    if (this.ApJ != null) {
      this.ApJ.onClick(this, 0);
    }
    dismiss();
    if (this.AAt != null)
    {
      if (this.AAv)
      {
        if (this.AAu == 0)
        {
          Context localContext = getContext();
          Object localObject = new a(this.Apy.getText(), this.ApM, this.zQd, this.ApK, this.Vb, this.Aqf, this.AAt);
          b local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b(localContext)
            {
              public final int chg()
              {
                AppMethodBeat.i(72137);
                int j = 3;
                int i = j;
                if (this.AAx.AAz != null)
                {
                  i = j;
                  if (this.AAx.AAz.field_bankcardClientType == 1)
                  {
                    ad.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                    i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.AAx.AAz).Aja;
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
            local1.AAu = 1;
            local1.AAv = true;
            local1.AAw = ((a)localObject);
            if (local1.AAw != null)
            {
              local1.b(local1.AAw.AAE);
              local1.setOnCancelListener(local1.AAw.AAE);
              local1.setCancelable(true);
              if (local1.AAw.AAz != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.AAw.AAz.field_desc)
          {
            local1.d((String)localObject, 0.0D);
            local1.sL(false);
            local1.a(local1.AAw.Aqf);
            local1.AAt = local1.AAw.AAD;
            local1.Apy.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(72141);
            return;
            AppMethodBeat.o(72141);
            return;
          }
        }
        if (this.AAu == 1)
        {
          this.AAt.a(this.AAw.AAy, this.Apy.getText(), this.AAw.AAA);
          AppMethodBeat.o(72141);
          return;
        }
        ad.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(72141);
        return;
      }
      this.AAt.a(this.Apy.getText(), "", this.zQd);
    }
    AppMethodBeat.o(72141);
  }
  
  public final void gx(Context paramContext)
  {
    AppMethodBeat.i(201272);
    super.gx(paramContext);
    AppMethodBeat.o(201272);
  }
  
  final class a
  {
    public FavorPayInfo AAA;
    public boolean AAB;
    public b.b AAD;
    public DialogInterface.OnCancelListener AAE;
    public String AAy;
    public Bankcard AAz;
    public s.a Aqf;
    
    public a(String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, s.a parama, b.b paramb)
    {
      this.AAy = paramString;
      this.AAz = paramBankcard;
      this.AAA = paramFavorPayInfo;
      this.AAB = paramBoolean;
      this.AAE = paramOnCancelListener;
      this.Aqf = parama;
      this.AAD = paramb;
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