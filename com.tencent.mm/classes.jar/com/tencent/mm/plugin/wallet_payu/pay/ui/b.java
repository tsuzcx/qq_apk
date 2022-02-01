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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import java.util.List;
import java.util.Map;

public class b
  extends s
{
  private b BSP;
  private int BSQ = 0;
  private boolean BSR = false;
  private a BSS;
  
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
    Object localObject4 = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(paramOrders);
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
          if (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.Bwx))
          {
            localObject1 = ((d)localObject4).cb(paramFavorPayInfo.Bwv, false);
            localObject2 = (d.a)((d)localObject4).ca((String)localObject1, true).get(paramBankcard.field_bankcardType);
            if ((localObject2 == null) || (((d.a)localObject2).BBJ == null) || (bs.isNullOrNil(((d.a)localObject2).BBJ.Bhb))) {
              break label485;
            }
            paramFavorPayInfo.Bwv = ((d.a)localObject2).BBJ.Bhb;
            localObject1 = paramFavorPayInfo;
          }
        }
        paramFavorPayInfo = ((d)localObject4).etg();
        localObject2 = localObject1;
        localObject1 = paramFavorPayInfo;
        paramFavorPayInfo = (Orders.Commodity)paramOrders.BxR.get(0);
        localObject3 = new StringBuilder();
        if (!bs.isNullOrNil(paramFavorPayInfo.vxa)) {
          break label547;
        }
        paramFavorPayInfo = "";
        str2 = paramFavorPayInfo + ((Orders.Commodity)paramOrders.BxR.get(0)).desc;
        str1 = null;
        localObject3 = null;
        paramFavorPayInfo = null;
        d = paramOrders.daf;
        if ((localObject4 == null) || (localObject2 == null)) {
          break label648;
        }
        localObject4 = ((d)localObject4).azE(((FavorPayInfo)localObject2).Bwv);
        if ((localObject4 == null) || (((j)localObject4).Bhc <= 0.0D)) {
          break label574;
        }
        d = ((j)localObject4).BgK;
        localObject3 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.daf, paramOrders.vxl);
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(((j)localObject4).BgK, paramOrders.vxl);
        paramFavorPayInfo = paramContext.getString(2131765686, new Object[] { com.tencent.mm.wallet_core.ui.e.C(((j)localObject4).Bhc) });
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
        ((b)localObject4).BIg = paramBankcard;
        ((b)localObject4).a(paramContext, paramOrders, (FavorPayInfo)localObject2, paramBankcard);
        ((b)localObject4).b(paramOnCancelListener);
        ((b)localObject4).setOnCancelListener(paramOnCancelListener);
        ((b)localObject4).setCancelable(true);
        ((b)localObject4).azM(str2);
        ((b)localObject4).d((String)localObject1, d);
        ((b)localObject4).azO((String)localObject3);
        ((b)localObject4).a(str1, paramOnClickListener, bool);
        if (TextUtils.isEmpty(paramFavorPayInfo)) {
          break label635;
        }
        ((b)localObject4).BHR.setVisibility(0);
        ((b)localObject4).BHR.setText(paramFavorPayInfo);
      }
      for (;;)
      {
        ((b)localObject4).BSR = paramBoolean;
        ((s)localObject4).BHS.setEncrType(-10);
        ((b)localObject4).BSP = paramb;
        ((b)localObject4).show();
        com.tencent.mm.ui.base.h.a(paramContext, (Dialog)localObject4);
        AppMethodBeat.o(72140);
        return localObject4;
        label485:
        paramFavorPayInfo.Bwv = ((String)localObject1);
        localObject1 = paramFavorPayInfo;
        break;
        localObject1 = paramFavorPayInfo;
        if (paramOrders.BxS == null) {
          break;
        }
        localObject1 = ((d)localObject4).azH(((d)localObject4).azI(paramOrders.BxS.BgL));
        break;
        ac.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
        localObject1 = null;
        localObject2 = paramFavorPayInfo;
        break label153;
        label547:
        paramFavorPayInfo = paramFavorPayInfo.vxa + "\n";
        break label189;
        label574:
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramFavorPayInfo = paramContext.getString(2131765742);
          bool = true;
          localObject1 = str1;
          break label329;
        }
        localObject1 = com.tencent.mm.wallet_core.ui.e.d(paramOrders.daf, paramOrders.vxl);
        bool = false;
        break label329;
        str1 = paramBankcard.field_desc;
        break label337;
        label635:
        ((b)localObject4).BHR.setVisibility(8);
      }
      label648:
      bool = false;
      localObject1 = str1;
    }
  }
  
  public final void aM(Context paramContext)
  {
    AppMethodBeat.i(207321);
    gI(paramContext);
    super.gJ(paramContext);
    if (this.BIh != null) {
      this.BIh.setVisibility(8);
    }
    AppMethodBeat.o(207321);
  }
  
  public final void etL()
  {
    AppMethodBeat.i(72141);
    if (this.BId != null) {
      this.BId.onClick(this, 0);
    }
    dismiss();
    if (this.BSP != null)
    {
      if (this.BSR)
      {
        if (this.BSQ == 0)
        {
          Context localContext = getContext();
          Object localObject = new a(this.BHS.getText(), this.BIg, this.Bix, this.BIe, this.VW, this.BIz, this.BSP);
          b local1;
          if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))
          {
            local1 = new b(localContext)
            {
              public final int coN()
              {
                AppMethodBeat.i(72137);
                int j = 3;
                int i = j;
                if (this.BST.BSV != null)
                {
                  i = j;
                  if (this.BST.BSV.field_bankcardClientType == 1)
                  {
                    ac.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                    i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.BST.BSV).BBv;
                  }
                }
                if (i == 4)
                {
                  ac.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                  AppMethodBeat.o(72137);
                  return 2131495068;
                }
                AppMethodBeat.o(72137);
                return 2131495069;
              }
            };
            local1.BSQ = 1;
            local1.BSR = true;
            local1.BSS = ((a)localObject);
            if (local1.BSS != null)
            {
              local1.b(local1.BSS.BSZ);
              local1.setOnCancelListener(local1.BSS.BSZ);
              local1.setCancelable(true);
              if (local1.BSS.BSV != null) {
                break label248;
              }
            }
          }
          label248:
          for (localObject = "";; localObject = local1.BSS.BSV.field_desc)
          {
            local1.d((String)localObject, 0.0D);
            local1.tM(false);
            local1.a(local1.BSS.BIz);
            local1.BSP = local1.BSS.BSY;
            local1.BHS.setEncrType(30);
            local1.show();
            com.tencent.mm.ui.base.h.a(localContext, local1);
            AppMethodBeat.o(72141);
            return;
            AppMethodBeat.o(72141);
            return;
          }
        }
        if (this.BSQ == 1)
        {
          this.BSP.a(this.BSS.BSU, this.BHS.getText(), this.BSS.BSW);
          AppMethodBeat.o(72141);
          return;
        }
        ac.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        AppMethodBeat.o(72141);
        return;
      }
      this.BSP.a(this.BHS.getText(), "", this.Bix);
    }
    AppMethodBeat.o(72141);
  }
  
  public final void gJ(Context paramContext)
  {
    AppMethodBeat.i(210296);
    super.gJ(paramContext);
    AppMethodBeat.o(210296);
  }
  
  final class a
  {
    public s.a BIz;
    public String BSU;
    public Bankcard BSV;
    public FavorPayInfo BSW;
    public boolean BSX;
    public b.b BSY;
    public DialogInterface.OnCancelListener BSZ;
    
    public a(String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, s.a parama, b.b paramb)
    {
      this.BSU = paramString;
      this.BSV = paramBankcard;
      this.BSW = paramFavorPayInfo;
      this.BSX = paramBoolean;
      this.BSZ = paramOnCancelListener;
      this.BIz = parama;
      this.BSY = paramb;
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