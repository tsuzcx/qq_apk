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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ImageView BJK;
  ViewGroup BJL;
  TextView BJM;
  List<WcPayCashierBankcardItemLayout> BJN;
  int BJO;
  boolean BJP;
  int BJQ;
  boolean BJR;
  a BJS;
  WcPayCashierDialog.b BJT;
  com.tencent.mm.plugin.wallet_core.utils.a Bfa;
  FavorPayInfo Bix;
  Bankcard BlJ;
  private ViewGroup lyD;
  private Context mContext;
  PayInfo mPayInfo;
  Orders wSu;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71314);
    this.BJN = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.wSu = new Orders();
    this.BJR = true;
    this.BJT = new WcPayCashierDialog.b()
    {
      public final void etW()
      {
        AppMethodBeat.i(71307);
        ac.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
        a.this.dismiss();
        AppMethodBeat.o(71307);
      }
    };
    this.mContext = paramContext;
    this.lyD = ((ViewGroup)View.inflate(getContext(), 2131496052, null));
    this.BJK = ((ImageView)this.lyD.findViewById(2131307025));
    this.BJL = ((ViewGroup)this.lyD.findViewById(2131307022));
    this.BJM = ((TextView)this.lyD.findViewById(2131307027));
    paramContext = this.BJK;
    int i = WcPayCashierDialog.BKd;
    int j = WcPayCashierDialog.BKd;
    bs.n(paramContext, i, i, j, j);
    this.BJK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71310);
        a.this.cancel();
        AppMethodBeat.o(71310);
      }
    });
    setContentView(this.lyD);
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
    this.Bfa = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71314);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(71316);
    WcPayCashierDialog.b localb = this.BJT;
    paramWcPayCashierDialog.BKQ.remove(localb);
    AppMethodBeat.o(71316);
  }
  
  final LinkedList<String> etV()
  {
    AppMethodBeat.i(71318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.wSu != null) && (this.wSu.BxS != null) && (this.wSu.BxS.BgW != null))
    {
      Object localObject = this.wSu.BxS.BgW.Bgs;
      if (localObject != null)
      {
        localObject = ((n)localObject).Bhi.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((o)((Iterator)localObject).next()).wJS);
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
    if ((this.wSu != null) && (this.wSu.BxS != null) && (this.wSu.BxS.BgW != null))
    {
      Iterator localIterator = this.wSu.BxS.BgW.Bgr.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.vwo.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.BgC.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).wJS);
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
      ac.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
      dismiss();
    }
    ab.km(7, 0);
    AppMethodBeat.o(71315);
  }
  
  public static abstract interface a
  {
    public abstract void eoo();
    
    public abstract void i(Bankcard paramBankcard);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */