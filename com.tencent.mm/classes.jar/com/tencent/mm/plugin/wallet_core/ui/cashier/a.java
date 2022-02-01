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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  com.tencent.mm.plugin.wallet_core.utils.a CWV;
  private ImageView DBG;
  ViewGroup DBH;
  TextView DBI;
  List<WcPayCashierBankcardItemLayout> DBJ;
  int DBK;
  boolean DBL;
  int DBM;
  boolean DBN;
  a DBO;
  WcPayCashierDialog.b DBP;
  FavorPayInfo Dar;
  Bankcard DdG;
  private Context mContext;
  PayInfo mPayInfo;
  private ViewGroup mcI;
  Orders yvS;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71314);
    this.DBJ = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.yvS = new Orders();
    this.DBN = true;
    this.DBP = new WcPayCashierDialog.b()
    {
      public final void eLK()
      {
        AppMethodBeat.i(71307);
        ae.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
        a.this.dismiss();
        AppMethodBeat.o(71307);
      }
    };
    this.mContext = paramContext;
    this.mcI = ((ViewGroup)View.inflate(getContext(), 2131496052, null));
    this.DBG = ((ImageView)this.mcI.findViewById(2131307025));
    this.DBH = ((ViewGroup)this.mcI.findViewById(2131307022));
    this.DBI = ((TextView)this.mcI.findViewById(2131307027));
    paramContext = this.DBG;
    int i = WcPayCashierDialog.DBZ;
    int j = WcPayCashierDialog.DBZ;
    bu.n(paramContext, i, i, j, j);
    this.DBG.setOnClickListener(new a.4(this));
    setContentView(this.mcI);
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
    this.CWV = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71314);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(71316);
    WcPayCashierDialog.b localb = this.DBP;
    paramWcPayCashierDialog.DCM.remove(localb);
    AppMethodBeat.o(71316);
  }
  
  final LinkedList<String> eLJ()
  {
    AppMethodBeat.i(71318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.yvS != null) && (this.yvS.DpQ != null) && (this.yvS.DpQ.CYQ != null))
    {
      Object localObject = this.yvS.DpQ.CYQ.CYm;
      if (localObject != null)
      {
        localObject = ((n)localObject).CZc.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((o)((Iterator)localObject).next()).ynr);
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
    if ((this.yvS != null) && (this.yvS.DpQ != null) && (this.yvS.DpQ.CYQ != null))
    {
      Iterator localIterator = this.yvS.DpQ.CYQ.CYl.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.wRt.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.CYw.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).ynr);
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
      ae.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
      dismiss();
    }
    ab.kI(7, 0);
    AppMethodBeat.o(71315);
  }
  
  public static abstract interface a
  {
    public abstract void eFU();
    
    public abstract void i(Bankcard paramBankcard);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */