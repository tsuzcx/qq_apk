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
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends i
{
  Orders CwO;
  com.tencent.mm.plugin.wallet_core.utils.a HCH;
  FavorPayInfo HGf;
  Bankcard HJA;
  private ImageView IkS;
  ViewGroup IkT;
  TextView IkU;
  List<WcPayCashierBankcardItemLayout> IkV;
  int IkW;
  boolean IkX;
  int IkY;
  boolean IkZ;
  a Ila;
  WcPayCashierDialog.b Ilb;
  private Context mContext;
  PayInfo mPayInfo;
  private ViewGroup nmW;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(71314);
    this.IkV = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.CwO = new Orders();
    this.IkZ = true;
    this.Ilb = new WcPayCashierDialog.b()
    {
      public final void fTr()
      {
        AppMethodBeat.i(71307);
        Log.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
        a.this.dismiss();
        AppMethodBeat.o(71307);
      }
    };
    this.mContext = paramContext;
    this.nmW = ((ViewGroup)View.inflate(getContext(), 2131497032, null));
    this.IkS = ((ImageView)this.nmW.findViewById(2131310549));
    this.IkT = ((ViewGroup)this.nmW.findViewById(2131310546));
    this.IkU = ((TextView)this.nmW.findViewById(2131310551));
    paramContext = this.IkS;
    int i = WcPayCashierDialog.Ill;
    int j = WcPayCashierDialog.Ill;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    this.IkS.setOnClickListener(new a.4(this));
    setContentView(this.nmW);
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
    this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71314);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(71316);
    WcPayCashierDialog.b localb = this.Ilb;
    paramWcPayCashierDialog.IlY.remove(localb);
    AppMethodBeat.o(71316);
  }
  
  final LinkedList<String> fTq()
  {
    AppMethodBeat.i(71318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.CwO != null) && (this.CwO.HZe != null) && (this.CwO.HZe.HEE != null))
    {
      Object localObject = this.CwO.HZe.HEE.HEa;
      if (localObject != null)
      {
        localObject = ((n)localObject).HEQ.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((o)((Iterator)localObject).next()).Coh);
        }
        AppMethodBeat.o(71318);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(71318);
    return localLinkedList;
  }
  
  final LinkedList<String> h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71317);
    LinkedList localLinkedList = new LinkedList();
    if ((this.CwO != null) && (this.CwO.HZe != null) && (this.CwO.HZe.HEE != null))
    {
      Iterator localIterator = this.CwO.HZe.HEE.HDZ.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.ANo.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.HEk.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).Coh);
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
    ab.mg(7, 0);
    AppMethodBeat.o(71315);
  }
  
  public static abstract interface a
  {
    public abstract void fNc();
    
    public abstract void j(Bankcard paramBankcard);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */