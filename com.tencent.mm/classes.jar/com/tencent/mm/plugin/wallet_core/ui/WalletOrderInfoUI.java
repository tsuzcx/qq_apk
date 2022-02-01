package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

@a(3)
public class WalletOrderInfoUI
  extends WalletBaseUI
{
  private Orders CZT;
  protected au.b.a Dze;
  private String wNH;
  
  public WalletOrderInfoUI()
  {
    AppMethodBeat.i(71094);
    this.Dze = new WalletOrderInfoUI.1(this);
    AppMethodBeat.o(71094);
  }
  
  protected static String e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(71102);
    for (;;)
    {
      try
      {
        paramString5 = URLEncoder.encode(URLEncoder.encode(paramString5, "utf-8"), "utf-8");
        if ((paramString1.indexOf("%7Breqkey%7D") <= 0) && (paramString1.indexOf("%7Btransid%7D") <= 0) && (paramString1.indexOf("%7Bphone%7D") <= 0) && (paramString1.indexOf("%7Bremark%7D") <= 0)) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
        paramString2 = paramString1.replace("%7Breqkey%7D", paramString2).replace("%7Btransid%7D", paramString3).replace("%7Bphone%7D", paramString4).replace("%7Bremark%7D", paramString5);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WalletOrderInfoUI", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(71102);
      return paramString1;
      if ((paramString1.indexOf("{reqkey}") > 0) || (paramString1.indexOf("{transid}") > 0) || (paramString1.indexOf("{phone}") > 0) || (paramString1.indexOf("{remark}") > 0))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
        paramString2 = paramString1.replace("{reqkey}", paramString2).replace("{transid}", paramString3).replace("{phone}", paramString4).replace("{remark}", paramString5);
        paramString1 = paramString2;
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
        paramString2 = paramString1 + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[] { paramString2, paramString3, paramString4, paramString5 });
        paramString1 = paramString2;
      }
    }
  }
  
  private void e(Orders paramOrders)
  {
    AppMethodBeat.i(71100);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[] { Integer.valueOf(paramOrders.DpZ) });
    if (paramOrders.DpZ == 1) {
      getProcess().b(this, WalletOrderInfoNewUI.class, getInput());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(71100);
      return;
      getProcess().b(this, WalletOrderInfoOldUI.class, getInput());
    }
  }
  
  protected void aGp(String paramString)
  {
    AppMethodBeat.i(71098);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(paramString));
    AppMethodBeat.o(71098);
  }
  
  protected void ag(an paraman)
  {
    AppMethodBeat.i(71101);
    if ((paraman != null) && ((int)paraman.ght != 0))
    {
      String str = paraman.adF();
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + str + " username: " + paraman.field_username);
      if ((this.CZT.DpP != null) && (this.CZT.DpP.size() > 0))
      {
        paraman = this.CZT.DpP.iterator();
        while (paraman.hasNext()) {
          ((Orders.Commodity)paraman.next()).wSr = str;
        }
      }
    }
    AppMethodBeat.o(71101);
  }
  
  protected boolean dNn()
  {
    return true;
  }
  
  protected Orders eLn()
  {
    AppMethodBeat.i(71097);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71097);
    return localOrders;
  }
  
  protected void fx(String paramString, int paramInt)
  {
    AppMethodBeat.i(71099);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(paramString, paramInt));
    AppMethodBeat.o(71099);
  }
  
  public int getLayoutId()
  {
    return 2131495807;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71095);
    super.onCreate(paramBundle);
    if (dNn())
    {
      this.CZT = eLn();
      this.wNH = getInput().getString("key_trans_id");
      int i = getInput().getInt("key_pay_type", -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[] { this.wNH });
      if (this.wNH != null)
      {
        if (i == -1)
        {
          aGp(this.wNH);
          AppMethodBeat.o(71095);
          return;
        }
        fx(this.wNH, i);
        AppMethodBeat.o(71095);
        return;
      }
      if (this.CZT != null) {
        e(this.CZT);
      }
    }
    AppMethodBeat.o(71095);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71096);
    super.onDestroy();
    if ((this.CZT != null) && (!bu.isNullOrNil(this.CZT.username))) {
      au.a.hIG.Bt(this.CZT.username);
    }
    AppMethodBeat.o(71096);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71103);
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ae)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.CZT = ((com.tencent.mm.plugin.wallet_core.c.ae)paramn).DgZ;
      if (this.CZT != null) {
        if ((this.CZT.DpP != null) && (this.CZT.DpP.size() != 0))
        {
          paramString = (Orders.Commodity)this.CZT.DpP.get(0);
          this.wNH = paramString.dmx;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + paramString.toString());
          g.ajS();
          paramn = ((l)g.ab(l.class)).azF().BH(paramString.wSr);
          if ((paramn != null) && ((int)paramn.ght != 0)) {
            ag(paramn);
          }
        }
        else
        {
          e(this.CZT);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71103);
        return true;
        au.a.hIG.a(paramString.wSr, "", this.Dze);
        break;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
        h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71093);
            WalletOrderInfoUI.this.finish();
            AppMethodBeat.o(71093);
          }
        });
      }
    }
    AppMethodBeat.o(71103);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */