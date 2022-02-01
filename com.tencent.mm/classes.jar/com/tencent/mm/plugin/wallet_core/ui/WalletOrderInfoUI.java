package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  protected ar.b.a BHi;
  private Orders BhZ;
  private String vsE;
  
  public WalletOrderInfoUI()
  {
    AppMethodBeat.i(71094);
    this.BHi = new WalletOrderInfoUI.1(this);
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
        ac.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
        paramString2 = paramString1.replace("%7Breqkey%7D", paramString2).replace("%7Btransid%7D", paramString3).replace("%7Bphone%7D", paramString4).replace("%7Bremark%7D", paramString5);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        ac.printErrStackTrace("MicroMsg.WalletOrderInfoUI", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(71102);
      return paramString1;
      if ((paramString1.indexOf("{reqkey}") > 0) || (paramString1.indexOf("{transid}") > 0) || (paramString1.indexOf("{phone}") > 0) || (paramString1.indexOf("{remark}") > 0))
      {
        ac.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
        paramString2 = paramString1.replace("{reqkey}", paramString2).replace("{transid}", paramString3).replace("{phone}", paramString4).replace("{remark}", paramString5);
        paramString1 = paramString2;
      }
      else
      {
        ac.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
        paramString2 = paramString1 + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[] { paramString2, paramString3, paramString4, paramString5 });
        paramString1 = paramString2;
      }
    }
  }
  
  private void e(Orders paramOrders)
  {
    AppMethodBeat.i(71100);
    ac.m("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[] { Integer.valueOf(paramOrders.Byb) });
    if (paramOrders.Byb == 1) {
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
  
  protected void Z(ai paramai)
  {
    AppMethodBeat.i(71101);
    if ((paramai != null) && ((int)paramai.fLJ != 0))
    {
      String str = paramai.aaR();
      ac.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + str + " username: " + paramai.field_username);
      if ((this.BhZ.BxR != null) && (this.BhZ.BxR.size() > 0))
      {
        paramai = this.BhZ.BxR.iterator();
        while (paramai.hasNext()) {
          ((Orders.Commodity)paramai.next()).vxm = str;
        }
      }
    }
    AppMethodBeat.o(71101);
  }
  
  protected void azL(String paramString)
  {
    AppMethodBeat.i(71098);
    doSceneProgress(new ae(paramString));
    AppMethodBeat.o(71098);
  }
  
  protected boolean dyD()
  {
    return true;
  }
  
  protected void eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(71099);
    doSceneProgress(new ae(paramString, paramInt));
    AppMethodBeat.o(71099);
  }
  
  protected Orders etz()
  {
    AppMethodBeat.i(71097);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71097);
    return localOrders;
  }
  
  public int getLayoutId()
  {
    return 2131495807;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71095);
    super.onCreate(paramBundle);
    if (dyD())
    {
      this.BhZ = etz();
      this.vsE = getInput().getString("key_trans_id");
      int i = getInput().getInt("key_pay_type", -1);
      ac.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[] { this.vsE });
      if (this.vsE != null)
      {
        if (i == -1)
        {
          azL(this.vsE);
          AppMethodBeat.o(71095);
          return;
        }
        eV(this.vsE, i);
        AppMethodBeat.o(71095);
        return;
      }
      if (this.BhZ != null) {
        e(this.BhZ);
      }
    }
    AppMethodBeat.o(71095);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71096);
    super.onDestroy();
    if ((this.BhZ != null) && (!bs.isNullOrNil(this.BhZ.username))) {
      ar.a.hnw.yd(this.BhZ.username);
    }
    AppMethodBeat.o(71096);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71103);
    if (((paramn instanceof ae)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.BhZ = ((ae)paramn).Bpf;
      if (this.BhZ != null) {
        if ((this.BhZ.BxR != null) && (this.BhZ.BxR.size() != 0))
        {
          paramString = (Orders.Commodity)this.BhZ.BxR.get(0);
          this.vsE = paramString.dad;
          ac.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + paramString.toString());
          g.agS();
          paramn = ((k)g.ab(k.class)).awB().aNt(paramString.vxm);
          if ((paramn != null) && ((int)paramn.fLJ != 0)) {
            Z(paramn);
          }
        }
        else
        {
          e(this.BhZ);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71103);
        return true;
        ar.a.hnw.a(paramString.vxm, "", this.BHi);
        break;
        ac.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
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