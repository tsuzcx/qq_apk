package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private Orders BhZ;
  private String prepayId = null;
  
  public final void done()
  {
    AppMethodBeat.i(70974);
    Object localObject1 = this.BGg.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!bs.isNullOrNil((String)localObject2))
      {
        ac.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        g.agS();
        g.agQ().ghe.a(new t((String)localObject2), 0);
      }
    }
    if (!bs.isNullOrNil(this.prepayId))
    {
      localObject1 = new xv();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((Intent)localObject2).putExtra("is_jsapi_close_page", this.BhZ.Bye);
      ((xv)localObject1).dBk.intent = ((Intent)localObject2);
      ((xv)localObject1).dBk.dac = this.prepayId;
      ((xv)localObject1).dBk.result = -1;
      ((xv)localObject1).dBk.dBn = 1;
      a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(70974);
  }
  
  protected final void etl() {}
  
  protected final Orders etz()
  {
    return this.BhZ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70973);
    this.BhZ = ((Orders)getIntent().getParcelableExtra("key_orders"));
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