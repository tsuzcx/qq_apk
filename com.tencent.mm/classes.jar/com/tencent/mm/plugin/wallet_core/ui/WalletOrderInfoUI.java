package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

@a(3)
public class WalletOrderInfoUI
  extends WalletBaseUI
{
  private String MyF;
  protected az.b.a VRk;
  private Orders VmL;
  
  public WalletOrderInfoUI()
  {
    AppMethodBeat.i(71094);
    this.VRk = new WalletOrderInfoUI.1(this);
    AppMethodBeat.o(71094);
  }
  
  private void e(Orders paramOrders)
  {
    AppMethodBeat.i(71100);
    Log.printInfoStack("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[] { Integer.valueOf(paramOrders.VHh) });
    if (paramOrders.VHh == 1) {
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
  
  protected static String i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
        Log.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
        paramString2 = paramString1.replace("%7Breqkey%7D", paramString2).replace("%7Btransid%7D", paramString3).replace("%7Bphone%7D", paramString4).replace("%7Bremark%7D", paramString5);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        Log.printErrStackTrace("MicroMsg.WalletOrderInfoUI", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(71102);
      return paramString1;
      if ((paramString1.indexOf("{reqkey}") > 0) || (paramString1.indexOf("{transid}") > 0) || (paramString1.indexOf("{phone}") > 0) || (paramString1.indexOf("{remark}") > 0))
      {
        Log.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
        paramString2 = paramString1.replace("{reqkey}", paramString2).replace("{transid}", paramString3).replace("{phone}", paramString4).replace("{remark}", paramString5);
        paramString1 = paramString2;
      }
      else
      {
        Log.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
        paramString2 = paramString1 + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[] { paramString2, paramString3, paramString4, paramString5 });
        paramString1 = paramString2;
      }
    }
  }
  
  protected void au(au paramau)
  {
    AppMethodBeat.i(71101);
    if ((paramau != null) && ((int)paramau.maN != 0))
    {
      String str = paramau.aSU();
      Log.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + str + " username: " + paramau.field_username);
      if ((this.VmL.VGX != null) && (this.VmL.VGX.size() > 0))
      {
        paramau = this.VmL.VGX.iterator();
        while (paramau.hasNext()) {
          ((Orders.Commodity)paramau.next()).hzv = str;
        }
      }
    }
    AppMethodBeat.o(71101);
  }
  
  protected void bhi(String paramString)
  {
    AppMethodBeat.i(71098);
    doSceneProgress(new af(paramString));
    AppMethodBeat.o(71098);
  }
  
  protected boolean gNb()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return a.g.transparent_layout;
  }
  
  protected void hG(String paramString, int paramInt)
  {
    AppMethodBeat.i(71099);
    doSceneProgress(new af(paramString, paramInt));
    AppMethodBeat.o(71099);
  }
  
  protected Orders ikP()
  {
    AppMethodBeat.i(71097);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71097);
    return localOrders;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71095);
    super.onCreate(paramBundle);
    if (gNb())
    {
      this.VmL = ikP();
      this.MyF = getInput().getString("key_trans_id");
      int i = getInput().getInt("key_pay_type", -1);
      Log.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[] { this.MyF });
      if (this.MyF != null)
      {
        if (i == -1)
        {
          bhi(this.MyF);
          AppMethodBeat.o(71095);
          return;
        }
        hG(this.MyF, i);
        AppMethodBeat.o(71095);
        return;
      }
      if (this.VmL != null) {
        e(this.VmL);
      }
    }
    AppMethodBeat.o(71095);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71096);
    super.onDestroy();
    if ((this.VmL != null) && (!Util.isNullOrNil(this.VmL.username))) {
      az.a.okP.Jq(this.VmL.username);
    }
    AppMethodBeat.o(71096);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71103);
    if (((paramp instanceof af)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.VmL = ((af)paramp).Vyn;
      if (this.VmL != null) {
        if ((this.VmL.VGX != null) && (this.VmL.VGX.size() != 0))
        {
          paramString = (Orders.Commodity)this.VmL.VGX.get(0);
          this.MyF = paramString.hAU;
          Log.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + paramString.toString());
          h.baF();
          paramp = ((n)h.ax(n.class)).bzA().JE(paramString.hzv);
          if ((paramp != null) && ((int)paramp.maN != 0)) {
            au(paramp);
          }
        }
        else
        {
          e(this.VmL);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71103);
        return true;
        az.a.okP.a(paramString.hzv, "", this.VRk);
        break;
        Log.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
        k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */