package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private Orders CZT;
  private String prepayId = null;
  
  public final void done()
  {
    AppMethodBeat.i(70974);
    Object localObject1 = this.Dyc.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!bu.isNullOrNil((String)localObject2))
      {
        ae.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        g.ajS();
        g.ajQ().gDv.a(new t((String)localObject2), 0);
      }
    }
    if (!bu.isNullOrNil(this.prepayId))
    {
      localObject1 = new yv();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((Intent)localObject2).putExtra("is_jsapi_close_page", this.CZT.Dqc);
      ((yv)localObject1).dON.intent = ((Intent)localObject2);
      ((yv)localObject1).dON.dmw = this.prepayId;
      ((yv)localObject1).dON.result = -1;
      ((yv)localObject1).dON.dOQ = 1;
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(70974);
  }
  
  protected final void eKZ() {}
  
  protected final Orders eLn()
  {
    return this.CZT;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70973);
    this.CZT = ((Orders)getIntent().getParcelableExtra("key_orders"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoProxyUI
 * JD-Core Version:    0.7.0.1
 */