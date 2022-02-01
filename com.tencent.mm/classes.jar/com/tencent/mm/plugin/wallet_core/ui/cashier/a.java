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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.model.c;
import com.tencent.mm.plugin.wallet.model.d;
import com.tencent.mm.plugin.wallet.model.h;
import com.tencent.mm.plugin.wallet.model.l;
import com.tencent.mm.plugin.wallet.model.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.ui.widget.a.i
{
  Bankcard MAF;
  Orders OsJ;
  private ImageView VTR;
  ViewGroup VTS;
  TextView VTT;
  List<WcPayCashierBankcardItemLayout> VTU;
  int VTV;
  boolean VTW;
  int VTX;
  boolean VTY;
  a VTZ;
  WcPayCashierDialog.b VUa;
  com.tencent.mm.plugin.wallet_core.utils.b VjO;
  FavorPayInfo Vnj;
  private Context mContext;
  PayInfo mPayInfo;
  private ViewGroup tth;
  
  public a(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71314);
    this.VTU = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.OsJ = new Orders();
    this.VTY = true;
    this.VUa = new WcPayCashierDialog.b()
    {
      public final void iln()
      {
        AppMethodBeat.i(71307);
        Log.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
        a.this.dismiss();
        AppMethodBeat.o(71307);
      }
    };
    this.mContext = paramContext;
    this.tth = ((ViewGroup)View.inflate(getContext(), a.g.wc_pay_cashier_bankcard_dialog, null));
    this.VTR = ((ImageView)this.tth.findViewById(a.f.wpcb_close_iv));
    this.VTS = ((ViewGroup)this.tth.findViewById(a.f.wpcb_bankcard_layout));
    this.VTT = ((TextView)this.tth.findViewById(a.f.wpcb_hint_tv));
    paramContext = this.VTR;
    int i = WcPayCashierDialog.VUk;
    int j = WcPayCashierDialog.VUk;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    this.VTR.setOnClickListener(new a.4(this));
    setContentView(this.tth);
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
    this.VjO = new com.tencent.mm.plugin.wallet_core.utils.b();
    AppMethodBeat.o(71314);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(71316);
    WcPayCashierDialog.b localb = this.VUa;
    paramWcPayCashierDialog.VUY.remove(localb);
    AppMethodBeat.o(71316);
  }
  
  final LinkedList<String> ilm()
  {
    AppMethodBeat.i(71318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.OsJ != null) && (this.OsJ.VGY != null) && (this.OsJ.VGY.VlI != null))
    {
      Object localObject = this.OsJ.VGY.VlI.Vle;
      if (localObject != null)
      {
        localObject = ((l)localObject).VlU.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((m)((Iterator)localObject).next()).OhO);
        }
        AppMethodBeat.o(71318);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(71318);
    return localLinkedList;
  }
  
  final LinkedList<String> j(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71317);
    LinkedList localLinkedList = new LinkedList();
    if ((this.OsJ != null) && (this.OsJ.VGY != null) && (this.OsJ.VGY.VlI != null))
    {
      Iterator localIterator = this.OsJ.VGY.VlI.Vld.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.MDt.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.Vlo.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).OhO);
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
    ac.pu(7, 0);
    AppMethodBeat.o(71315);
  }
  
  public static abstract interface a
  {
    public abstract void ieE();
    
    public abstract void l(Bankcard paramBankcard);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */