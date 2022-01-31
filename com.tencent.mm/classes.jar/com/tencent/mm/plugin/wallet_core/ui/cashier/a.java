package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends i
{
  private ViewGroup iux;
  private Context mContext;
  PayInfo mPayInfo;
  Orders qrf;
  com.tencent.mm.plugin.wallet_core.utils.a tSy;
  FavorPayInfo tVQ;
  Bankcard tYY;
  int uuA;
  boolean uuB;
  int uuC;
  boolean uuD;
  a.a uuE;
  WcPayCashierDialog.b uuF;
  private ImageView uuw;
  ViewGroup uux;
  TextView uuy;
  List<WcPayCashierBankcardItemLayout> uuz;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(47743);
    this.uuz = new ArrayList();
    this.mPayInfo = new PayInfo();
    this.qrf = new Orders();
    this.uuD = true;
    this.uuF = new a.1(this);
    this.mContext = paramContext;
    this.iux = ((ViewGroup)View.inflate(getContext(), 2130971275, null));
    this.uuw = ((ImageView)this.iux.findViewById(2131829436));
    this.uux = ((ViewGroup)this.iux.findViewById(2131829438));
    this.uuy = ((TextView)this.iux.findViewById(2131829437));
    paramContext = this.uuw;
    int i = WcPayCashierDialog.uuP;
    int j = WcPayCashierDialog.uuP;
    bo.n(paramContext, i, i, j, j);
    this.uuw.setOnClickListener(new a.4(this));
    setContentView(this.iux);
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new a.2(this));
    setOnDismissListener(new a.3(this));
    this.tSy = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(47743);
  }
  
  public final void a(WcPayCashierDialog paramWcPayCashierDialog)
  {
    AppMethodBeat.i(47745);
    WcPayCashierDialog.b localb = this.uuF;
    paramWcPayCashierDialog.uvC.remove(localb);
    AppMethodBeat.o(47745);
  }
  
  final LinkedList<String> cWf()
  {
    AppMethodBeat.i(47747);
    LinkedList localLinkedList = new LinkedList();
    if ((this.qrf != null) && (this.qrf.ujm != null) && (this.qrf.ujm.tUq != null))
    {
      Object localObject = this.qrf.ujm.tUq.tTM;
      if (localObject != null)
      {
        localObject = ((n)localObject).tUD.iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(((o)((Iterator)localObject).next()).qiO);
        }
        AppMethodBeat.o(47747);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(47747);
    return localLinkedList;
  }
  
  final LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(47746);
    LinkedList localLinkedList = new LinkedList();
    if ((this.qrf != null) && (this.qrf.ujm != null) && (this.qrf.ujm.tUq != null))
    {
      Iterator localIterator = this.qrf.ujm.tUq.tTL.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.por.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.tTW.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).qiO);
          }
          AppMethodBeat.o(47746);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(47746);
    return localLinkedList;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47744);
    super.onCreate(paramBundle);
    if (this.mPayInfo == null)
    {
      ab.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
      dismiss();
    }
    z.id(7, 0);
    AppMethodBeat.o(47744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a
 * JD-Core Version:    0.7.0.1
 */