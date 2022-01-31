package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoUI
  extends WalletBaseUI
{
  private String plc;
  private Orders tVr;
  protected ao.b.a urT;
  
  public WalletOrderInfoUI()
  {
    AppMethodBeat.i(47525);
    this.urT = new WalletOrderInfoUI.1(this);
    AppMethodBeat.o(47525);
  }
  
  protected static String e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(47533);
    for (;;)
    {
      try
      {
        paramString5 = URLEncoder.encode(URLEncoder.encode(paramString5, "utf-8"), "utf-8");
        if ((paramString1.indexOf("%7Breqkey%7D") <= 0) && (paramString1.indexOf("%7Btransid%7D") <= 0) && (paramString1.indexOf("%7Bphone%7D") <= 0) && (paramString1.indexOf("%7Bremark%7D") <= 0)) {
          continue;
        }
        ab.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
        paramString2 = paramString1.replace("%7Breqkey%7D", paramString2).replace("%7Btransid%7D", paramString3).replace("%7Bphone%7D", paramString4).replace("%7Bremark%7D", paramString5);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        ab.printErrStackTrace("MicroMsg.WalletOrderInfoUI", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47533);
      return paramString1;
      if ((paramString1.indexOf("{reqkey}") > 0) || (paramString1.indexOf("{transid}") > 0) || (paramString1.indexOf("{phone}") > 0) || (paramString1.indexOf("{remark}") > 0))
      {
        ab.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
        paramString2 = paramString1.replace("{reqkey}", paramString2).replace("{transid}", paramString3).replace("{phone}", paramString4).replace("{remark}", paramString5);
        paramString1 = paramString2;
      }
      else
      {
        ab.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
        paramString2 = paramString1 + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[] { paramString2, paramString3, paramString4, paramString5 });
        paramString1 = paramString2;
      }
    }
  }
  
  private void e(Orders paramOrders)
  {
    AppMethodBeat.i(47531);
    ab.b("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[] { Integer.valueOf(paramOrders.ujv) });
    if (paramOrders.ujv == 1) {
      getProcess().b(this, WalletOrderInfoNewUI.class, getInput());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(47531);
      return;
      getProcess().b(this, WalletOrderInfoOldUI.class, getInput());
    }
  }
  
  protected void R(ad paramad)
  {
    AppMethodBeat.i(47532);
    if ((paramad != null) && ((int)paramad.euF != 0))
    {
      String str = paramad.Oe();
      ab.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + str + " username: " + paramad.field_username);
      if ((this.tVr.ujl != null) && (this.tVr.ujl.size() > 0))
      {
        paramad = this.tVr.ujl.iterator();
        while (paramad.hasNext()) {
          ((Orders.Commodity)paramad.next()).ppq = str;
        }
      }
    }
    AppMethodBeat.o(47532);
  }
  
  protected void afK(String paramString)
  {
    AppMethodBeat.i(47529);
    doSceneProgress(new ac(paramString));
    AppMethodBeat.o(47529);
  }
  
  protected Orders cVH()
  {
    AppMethodBeat.i(47528);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(47528);
    return localOrders;
  }
  
  protected boolean chF()
  {
    return true;
  }
  
  protected void dF(String paramString, int paramInt)
  {
    AppMethodBeat.i(47530);
    doSceneProgress(new ac(paramString, paramInt));
    AppMethodBeat.o(47530);
  }
  
  public int getLayoutId()
  {
    return 2130971042;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47526);
    super.onCreate(paramBundle);
    if (chF())
    {
      this.tVr = cVH();
      this.plc = getInput().getString("key_trans_id");
      int i = getInput().getInt("key_pay_type", -1);
      ab.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[] { this.plc });
      if (this.plc != null)
      {
        if (i == -1)
        {
          afK(this.plc);
          AppMethodBeat.o(47526);
          return;
        }
        dF(this.plc, i);
        AppMethodBeat.o(47526);
        return;
      }
      if (this.tVr != null) {
        e(this.tVr);
      }
    }
    AppMethodBeat.o(47526);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47527);
    super.onDestroy();
    if ((this.tVr != null) && (!bo.isNullOrNil(this.tVr.username))) {
      ao.a.flI.pl(this.tVr.username);
    }
    AppMethodBeat.o(47527);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47534);
    if (((paramm instanceof ac)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.tVr = ((ac)paramm).ucc;
      if (this.tVr != null) {
        if ((this.tVr.ujl != null) && (this.tVr.ujl.size() != 0))
        {
          paramString = (Orders.Commodity)this.tVr.ujl.get(0);
          this.plc = paramString.cnJ;
          ab.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + paramString.toString());
          g.RM();
          paramm = ((j)g.E(j.class)).YA().arw(paramString.ppq);
          if ((paramm != null) && ((int)paramm.euF != 0)) {
            R(paramm);
          }
        }
        else
        {
          e(this.tVr);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(47534);
        return true;
        ao.a.flI.a(paramString.ppq, "", this.urT);
        break;
        ab.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
        h.a(getContext(), 2131305336, 0, new WalletOrderInfoUI.2(this));
      }
    }
    AppMethodBeat.o(47534);
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