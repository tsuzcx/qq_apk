package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends com.tencent.mm.ui.base.i
{
  private View iCk;
  private LayoutInflater mInflater;
  private b tWD;
  private MaxListView uqo;
  private TextView uqp;
  private l.a uqq;
  private l.b uqr;
  
  private l(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(47384);
    this.mInflater = LayoutInflater.from(paramContext);
    this.iCk = LayoutInflater.from(paramContext).inflate(2130971173, null);
    this.uqo = ((MaxListView)this.iCk.findViewById(2131829124));
    this.uqp = ((TextView)this.iCk.findViewById(2131829123));
    this.uqq = new l.a(this);
    this.uqo.setAdapter(this.uqq);
    this.iCk.findViewById(2131829125).setOnClickListener(new l.1(this));
    AppMethodBeat.o(47384);
  }
  
  public static l a(Context paramContext, Orders paramOrders, String paramString, l.b paramb, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47387);
    l locall = new l(paramContext);
    locall.setOnCancelListener(paramOnCancelListener);
    locall.setCancelable(true);
    locall.setCanceledOnTouchOutside(false);
    locall.tWD = c.umO.a(paramOrders);
    if (locall.tWD == null)
    {
      ab.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      locall.dismiss();
    }
    Object localObject2;
    int i;
    for (;;)
    {
      locall.uqr = paramb;
      locall.show();
      com.tencent.mm.ui.base.h.a(paramContext, locall);
      AppMethodBeat.o(47387);
      return locall;
      paramOrders = locall.uqq;
      localObject2 = paramOrders.uqs.tWD.umI;
      paramOnCancelListener = paramOrders.uqs.tWD.afH(paramString);
      paramOrders.uqu = paramOrders.uqs.tWD.cVp();
      paramOrders.uqv = paramOrders.uqs.tWD.afD(paramOnCancelListener);
      paramOrders.uqt = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.uqu.size()) {
          if (((t)paramOrders.uqu.get(i)).tVc == 0) {
            break label273;
          }
        }
        label273:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.uqt = i;
          paramString = new LinkedList();
          if (paramOrders.uqu == null) {
            break label288;
          }
          i = 0;
          while (i < paramOrders.uqu.size())
          {
            paramString.add(((t)paramOrders.uqu.get(i)).tTZ);
            i += 1;
          }
        }
        i += 1;
      }
      label288:
      ab.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
      i = 0;
      label298:
      if (i != 0) {
        break label669;
      }
      ab.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
      locall.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).tUg != null))
    {
      i = 0;
      while (i < ((com.tencent.mm.plugin.wallet.a.h)localObject2).tUg.size())
      {
        localObject1 = ((t)((com.tencent.mm.plugin.wallet.a.h)localObject2).tUg.get(i)).tTZ;
        if (!paramString.contains(localObject1)) {
          localLinkedList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = new LinkedList();
    label450:
    String str;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).tUh != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).tUh.tUt != null))
    {
      localObject2 = ((com.tencent.mm.plugin.wallet.a.h)localObject2).tUh.tUt;
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label563;
      }
      str = ((j)((List)localObject2).get(i)).tUv;
      j = 0;
      label482:
      if (j >= localLinkedList.size()) {
        break label700;
      }
      if (!str.contains((CharSequence)localLinkedList.get(j))) {}
    }
    label563:
    label700:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((List)localObject1).add(str);
      }
      i += 1;
      break label450;
      j += 1;
      break label482;
      ab.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
      i = 0;
      break label298;
      localLinkedList = new LinkedList();
      if ((!bo.isNullOrNil(paramOnCancelListener)) && (!paramOnCancelListener.equals("0")))
      {
        paramOnCancelListener = paramOnCancelListener.split("-");
        if (paramOnCancelListener != null)
        {
          i = 0;
          while (i < paramOnCancelListener.length)
          {
            localLinkedList.add(paramOnCancelListener[i]);
            i += 1;
          }
        }
        ab.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
        i = 0;
        break label298;
      }
      paramOrders.uqw.d(paramString, localLinkedList, (List)localObject1);
      i = 1;
      break label298;
      locall.uqp.setText(2131305065);
      locall.uqo.setOnItemClickListener(new l.2(locall));
      break;
    }
  }
  
  private void cVG()
  {
    AppMethodBeat.i(47389);
    ab.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.uqq != null)
    {
      Object localObject = this.uqq.uqw;
      localObject = ((r)localObject).a(((r)localObject).uiz, -1);
      localObject = this.tWD.afG((String)localObject);
      this.uqr.a((FavorPayInfo)localObject);
    }
    AppMethodBeat.o(47389);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(47386);
    try
    {
      super.dismiss();
      AppMethodBeat.o(47386);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(47386);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47385);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    AppMethodBeat.o(47385);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47390);
    if (paramInt == 4) {
      cVG();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47390);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(47388);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(47388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l
 * JD-Core Version:    0.7.0.1
 */