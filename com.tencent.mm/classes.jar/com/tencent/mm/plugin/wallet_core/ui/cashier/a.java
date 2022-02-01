package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends i
{
  Orders Ivh;
  Bankcard OBu;
  com.tencent.mm.plugin.wallet_core.utils.a OuA;
  FavorPayInfo OxY;
  private ImageView Pdk;
  ViewGroup Pdl;
  TextView Pdm;
  List<WcPayCashierBankcardItemLayout> Pdn;
  int Pdo;
  boolean Pdp;
  int Pdq;
  boolean Pdr;
  a Pds;
  WcPayCashierDialog.b Pdt;
  private Context mContext;
  PayInfo mPayInfo;
  private ViewGroup qoE;
  
  public a(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71314);
    this.Pdn = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.Ivh = new Orders();
    this.Pdr = true;
    this.Pdt = new WcPayCashierDialog.b()
    {
      public final void gLX()
      {
        AppMethodBeat.i(71307);
        Log.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
        a.this.dismiss();
        AppMethodBeat.o(71307);
      }
    };
    this.mContext = paramContext;
    this.qoE = ((ViewGroup)View.inflate(getContext(), a.g.wc_pay_cashier_bankcard_dialog, null));
    this.Pdk = ((ImageView)this.qoE.findViewById(a.f.wpcb_close_iv));
    this.Pdl = ((ViewGroup)this.qoE.findViewById(a.f.wpcb_bankcard_layout));
    this.Pdm = ((TextView)this.qoE.findViewById(a.f.wpcb_hint_tv));
    paramContext = this.Pdk;
    int i = WcPayCashierDialog.PdD;
    int j = WcPayCashierDialog.PdD;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    this.Pdk.setOnClickListener(new a.4(this));
    setContentView(this.qoE);
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71308);
        if (a.a(a.this) != null) {
          a.a(a.this).onCancel();
        }
        AppMethodBeat.o(71308);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71309);
        a.b(a.this).destory();
        AppMethodBeat.o(71309);
      }
    });
    this.OuA = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71314);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(71316);
    WcPayCashierDialog.b localb = this.Pdt;
    paramWcPayCashierDialog.Peq.remove(localb);
    AppMethodBeat.o(71316);
  }
  
  final LinkedList<String> gLW()
  {
    AppMethodBeat.i(71318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.Ivh != null) && (this.Ivh.ORe != null) && (this.Ivh.ORe.Owx != null))
    {
      Object localObject = this.Ivh.ORe.Owx.OvT;
      if (localObject != null)
      {
        localObject = ((n)localObject).OwJ.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((o)((Iterator)localObject).next()).Ila);
        }
        AppMethodBeat.o(71318);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(71318);
    return localLinkedList;
  }
  
  final LinkedList<String> i(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71317);
    LinkedList localLinkedList = new LinkedList();
    if ((this.Ivh != null) && (this.Ivh.ORe != null) && (this.Ivh.ORe.Owx != null))
    {
      Iterator localIterator = this.Ivh.ORe.Owx.OvS.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.GGC.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.Owd.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).Ila);
          }
          AppMethodBeat.o(71317);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(71317);
    return localLinkedList;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71315);
    super.onCreate(paramBundle);
    if (this.mPayInfo == null)
    {
      Log.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
      dismiss();
    }
    ab.ny(7, 0);
    AppMethodBeat.o(71315);
  }
  
  public static abstract interface a
  {
    public abstract void gFG();
    
    public abstract void k(Bankcard paramBankcard);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */