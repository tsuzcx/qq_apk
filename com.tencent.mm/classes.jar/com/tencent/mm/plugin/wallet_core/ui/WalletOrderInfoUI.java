package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private Orders CIn;
  protected as.b.a DhA;
  private String wxW;
  
  public WalletOrderInfoUI()
  {
    AppMethodBeat.i(71094);
    this.DhA = new WalletOrderInfoUI.1(this);
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
        ad.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
        paramString2 = paramString1.replace("%7Breqkey%7D", paramString2).replace("%7Btransid%7D", paramString3).replace("%7Bphone%7D", paramString4).replace("%7Bremark%7D", paramString5);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        ad.printErrStackTrace("MicroMsg.WalletOrderInfoUI", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(71102);
      return paramString1;
      if ((paramString1.indexOf("{reqkey}") > 0) || (paramString1.indexOf("{transid}") > 0) || (paramString1.indexOf("{phone}") > 0) || (paramString1.indexOf("{remark}") > 0))
      {
        ad.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
        paramString2 = paramString1.replace("{reqkey}", paramString2).replace("{transid}", paramString3).replace("{phone}", paramString4).replace("{remark}", paramString5);
        paramString1 = paramString2;
      }
      else
      {
        ad.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
        paramString2 = paramString1 + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[] { paramString2, paramString3, paramString4, paramString5 });
        paramString1 = paramString2;
      }
    }
  }
  
  private void e(Orders paramOrders)
  {
    AppMethodBeat.i(71100);
    ad.m("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[] { Integer.valueOf(paramOrders.CYu) });
    if (paramOrders.CYu == 1) {
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
  
  protected void Z(am paramam)
  {
    AppMethodBeat.i(71101);
    if ((paramam != null) && ((int)paramam.gfj != 0))
    {
      String str = paramam.adu();
      ad.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + str + " username: " + paramam.field_username);
      if ((this.CIn.CYk != null) && (this.CIn.CYk.size() > 0))
      {
        paramam = this.CIn.CYk.iterator();
        while (paramam.hasNext()) {
          ((Orders.Commodity)paramam.next()).wCG = str;
        }
      }
    }
    AppMethodBeat.o(71101);
  }
  
  protected void aEV(String paramString)
  {
    AppMethodBeat.i(71098);
    doSceneProgress(new ae(paramString));
    AppMethodBeat.o(71098);
  }
  
  protected boolean dJV()
  {
    return true;
  }
  
  protected Orders eHF()
  {
    AppMethodBeat.i(71097);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71097);
    return localOrders;
  }
  
  protected void fo(String paramString, int paramInt)
  {
    AppMethodBeat.i(71099);
    doSceneProgress(new ae(paramString, paramInt));
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
    if (dJV())
    {
      this.CIn = eHF();
      this.wxW = getInput().getString("key_trans_id");
      int i = getInput().getInt("key_pay_type", -1);
      ad.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[] { this.wxW });
      if (this.wxW != null)
      {
        if (i == -1)
        {
          aEV(this.wxW);
          AppMethodBeat.o(71095);
          return;
        }
        fo(this.wxW, i);
        AppMethodBeat.o(71095);
        return;
      }
      if (this.CIn != null) {
        e(this.CIn);
      }
    }
    AppMethodBeat.o(71095);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71096);
    super.onDestroy();
    if ((this.CIn != null) && (!bt.isNullOrNil(this.CIn.username))) {
      as.a.hFO.AJ(this.CIn.username);
    }
    AppMethodBeat.o(71096);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71103);
    if (((paramn instanceof ae)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.CIn = ((ae)paramn).CPv;
      if (this.CIn != null) {
        if ((this.CIn.CYk != null) && (this.CIn.CYk.size() != 0))
        {
          paramString = (Orders.Commodity)this.CIn.CYk.get(0);
          this.wxW = paramString.dlv;
          ad.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + paramString.toString());
          g.ajD();
          paramn = ((l)g.ab(l.class)).azp().Bf(paramString.wCG);
          if ((paramn != null) && ((int)paramn.gfj != 0)) {
            Z(paramn);
          }
        }
        else
        {
          e(this.CIn);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71103);
        return true;
        as.a.hFO.a(paramString.wCG, "", this.DhA);
        break;
        ad.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */