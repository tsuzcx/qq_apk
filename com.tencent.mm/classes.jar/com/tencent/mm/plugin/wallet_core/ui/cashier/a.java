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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends i
{
  private ImageView Arq;
  ViewGroup Arr;
  TextView Ars;
  List<WcPayCashierBankcardItemLayout> Art;
  int Aru;
  boolean Arv;
  int Arw;
  boolean Arx;
  a Ary;
  WcPayCashierDialog.b Arz;
  private ViewGroup kWT;
  private Context mContext;
  PayInfo mPayInfo;
  Orders vIq;
  com.tencent.mm.plugin.wallet_core.utils.a zMG;
  FavorPayInfo zQd;
  Bankcard zTp;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71314);
    this.Art = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.vIq = new Orders();
    this.Arx = true;
    this.Arz = new WcPayCashierDialog.b()
    {
      public final void eeB()
      {
        AppMethodBeat.i(71307);
        ad.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
        a.this.dismiss();
        AppMethodBeat.o(71307);
      }
    };
    this.mContext = paramContext;
    this.kWT = ((ViewGroup)View.inflate(getContext(), 2131496052, null));
    this.Arq = ((ImageView)this.kWT.findViewById(2131307025));
    this.Arr = ((ViewGroup)this.kWT.findViewById(2131307022));
    this.Ars = ((TextView)this.kWT.findViewById(2131307027));
    paramContext = this.Arq;
    int i = WcPayCashierDialog.ArJ;
    int j = WcPayCashierDialog.ArJ;
    bt.n(paramContext, i, i, j, j);
    this.Arq.setOnClickListener(new a.4(this));
    setContentView(this.kWT);
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
    this.zMG = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71314);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(71316);
    WcPayCashierDialog.b localb = this.Arz;
    paramWcPayCashierDialog.Asw.remove(localb);
    AppMethodBeat.o(71316);
  }
  
  final LinkedList<String> eeA()
  {
    AppMethodBeat.i(71318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.vIq != null) && (this.vIq.Afy != null) && (this.vIq.Afy.zOC != null))
    {
      Object localObject = this.vIq.Afy.zOC.zNY;
      if (localObject != null)
      {
        localObject = ((n)localObject).zOO.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((o)((Iterator)localObject).next()).vzN);
        }
        AppMethodBeat.o(71318);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(71318);
    return localLinkedList;
  }
  
  final LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71317);
    LinkedList localLinkedList = new LinkedList();
    if ((this.vIq != null) && (this.vIq.Afy != null) && (this.vIq.Afy.zOC != null))
    {
      Iterator localIterator = this.vIq.Afy.zOC.zNX.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.uns.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.zOi.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).vzN);
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
      ad.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
      dismiss();
    }
    ab.jZ(7, 0);
    AppMethodBeat.o(71315);
  }
  
  public static abstract interface a
  {
    public abstract void dYS();
    
    public abstract void i(Bankcard paramBankcard);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */