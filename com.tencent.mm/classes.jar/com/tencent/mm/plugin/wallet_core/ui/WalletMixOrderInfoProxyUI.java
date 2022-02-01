package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private Orders CIn;
  private String prepayId = null;
  
  public final void done()
  {
    AppMethodBeat.i(70974);
    Object localObject1 = this.Dgy.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!bt.isNullOrNil((String)localObject2))
      {
        ad.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        g.ajD();
        g.ajB().gAO.a(new t((String)localObject2), 0);
      }
    }
    if (!bt.isNullOrNil(this.prepayId))
    {
      localObject1 = new yp();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((Intent)localObject2).putExtra("is_jsapi_close_page", this.CIn.CYx);
      ((yp)localObject1).dNx.intent = ((Intent)localObject2);
      ((yp)localObject1).dNx.dlu = this.prepayId;
      ((yp)localObject1).dNx.result = -1;
      ((yp)localObject1).dNx.dNA = 1;
      a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(70974);
  }
  
  protected final Orders eHF()
  {
    return this.CIn;
  }
  
  protected final void eHr() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70973);
    this.CIn = ((Orders)getIntent().getParcelableExtra("key_orders"));
    this.prepayId = getIntent().getStringExtra("prepayId");
    super.onCreate(paramBundle);
    AppMethodBeat.o(70973);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoProxyUI
 * JD-Core Version:    0.7.0.1
 */