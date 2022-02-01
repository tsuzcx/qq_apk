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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;
import java.util.Map;

public class b
  extends s
{
  private b Iud;
  private int Iue = 0;
  private boolean Iuf = false;
  private a Iug;
  
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
    Object localObject4 = e.IcT.a(paramOrders);
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.HXK))
          {
            localObject1 = ((d)localObject4).cG(paramFavorPayInfo.HXI, false);
            localObject2 = (d.a)((d)localObject4).cF((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((d.a)localObject2).IcR == null) || (Util.isNullOrNil(((d.a)localObject2).IcR.HEJ))) {
              break label485;
            }
            paramFavorPayInfo.HXI = ((d.a)localObject2).IcR.HEJ;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((d)localObject4).fSz();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.HZd.get(0);
        localObject3 = new StringBuilder();
        if (!Util.isNullOrNil(paramFavorPayInfo.AOa)) {
          break label547;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.HZd.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.dDO;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label648;
        }
        localObject4 = ((d)localObject4).aVJ(((FavorPayInfo)localObject2).HXI);
        if ((localObject4 == null) || (((j)localObject4).HEK <= 0.0D)) {
          break label574;
        }
        d = ((j)localObject4).HEs;
        localObject3 = f.d(paramOrders.dDO, paramOrders.AOl);
        localObject1 = f.d(((j)localObject4).HEs, paramOrders.AOl);
        paramFavorPayInfo = paramContext.getString(2131768139, new Object[] { f.formatMoney2f(((j)localObject4).HEK) });
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
        ((b)localObject4).Ijo = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).c(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).aVR(str2);
        ((b)localObject4).d((String)localObject1, d);
        ((b)localObject4).aVT((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label635;
        }
        ((b)localObject4).IiZ.setVisibility(0);
        ((b)localObject4).IiZ.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).Iuf = paramBoolean;
        ((s)localObject4).Ija.setEncrType(-10);
        ((b)localObject4).Iud = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(72140);
        return localObject4;
        label485:
        paramFavorPayInfo.HXI = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.HZe == null) {
          break;
        }
        localObject1 = ((d)localObject4).aVM(((d)localObject4).aVN(paramOrders.HZe.HEt));
        break;
        Log.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label547:
        paramFavorPayInfo = paramFavorPayInfo.AOa + "\n";
        break label189;
        label574:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(2131768195);
          bool = true;
          localObject1 = str1;
          break label329;
        }
        localObject1 = f.d(paramOrders.dDO, paramOrders.AOl);
        bool = false;
        break label329;
        str1 = paramBankcard.field_desc;
        break label337;
        label635:
        ((b)localObject4).IiZ.setVisibility(8);
      }
      label648:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void bh(Context paramContext)
  {
    AppMethodBeat.i(258007);
    hO(paramContext);
    super.hP(paramContext);
    if (this.Ijp != null) {
      this.Ijp.setVisibility(8);
    }
    AppMethodBeat.o(258007);
  }
  
  public final void fTe()
  {
    AppMethodBeat.i(72141);
    if (this.Ijl != null) {
      this.Ijl.onClick(this, 0);
    }
    dismiss();
    if (this.Iud != null)
    {
      if (this.Iuf)
      {
        if (this.Iue == 0)
        {
          Context localContext = getContext();
          Object localObject = new a(this.Ija.getText(), this.Ijo, this.HGf, this.Ijm, this.XY, this.IjH, this.Iud);
          b local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b(localContext)
            {
              public final int fTi()
              {
                AppMethodBeat.i(72137);
                int j = 3;
                int i = j;
                if (this.Iuh.Iuj != null)
                {
                  i = j;
                  if (this.Iuh.Iuj.field_bankcardClientType == 1)
                  {
                    Log.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                    i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.Iuh.Iuj).IcC;
                  }
                }
                if (i == 4)
                {
                  Log.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                  AppMethodBeat.o(72137);
                  return 2131495905;
                }
                AppMethodBeat.o(72137);
                return 2131495906;
              }
            };
            local1.Iue = 1;
            local1.Iuf = true;
            local1.Iug = ((a)localObject);
            if (local1.Iug != null)
            {
              local1.c(local1.Iug.Iun);
              local1.setOnCancelListener(local1.Iug.Iun);
              local1.setCancelable(true);
              if (local1.Iug.Iuj != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.Iug.Iuj.field_desc)
          {
            local1.d((String)localObject, 0.0D);
            local1.ys(false);
            local1.a(local1.Iug.IjH);
            local1.Iud = local1.Iug.Ium;
            local1.Ija.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(72141);
            return;
            AppMethodBeat.o(72141);
            return;
          }
        }
        if (this.Iue == 1)
        {
          this.Iud.a(this.Iug.Iui, this.Ija.getText(), this.Iug.Iuk);
          AppMethodBeat.o(72141);
          return;
        }
        Log.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(72141);
        return;
      }
      this.Iud.a(this.Ija.getText(), "", this.HGf);
    }
    AppMethodBeat.o(72141);
  }
  
  public final void hP(Context paramContext)
  {
    AppMethodBeat.i(258351);
    super.hP(paramContext);
    AppMethodBeat.o(258351);
  }
  
  final class a
  {
    public s.a IjH;
    public String Iui;
    public Bankcard Iuj;
    public FavorPayInfo Iuk;
    public boolean Iul;
    public b.b Ium;
    public DialogInterface.OnCancelListener Iun;
    
    public a(String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, s.a parama, b.b paramb)
    {
      this.Iui = paramString;
      this.Iuj = paramBankcard;
      this.Iuk = paramFavorPayInfo;
      this.Iul = paramBoolean;
      this.Iun = paramOnCancelListener;
      this.IjH = parama;
      this.Ium = paramb;
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