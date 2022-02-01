package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private Orders HFH;
  private String prepayId = null;
  
  public final void done()
  {
    AppMethodBeat.i(70974);
    Object localObject1 = this.Ihn.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!Util.isNullOrNil((String)localObject2))
      {
        Log.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        g.aAi();
        g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t((String)localObject2), 0);
      }
    }
    if (!Util.isNullOrNil(this.prepayId))
    {
      localObject1 = new aaa();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((Intent)localObject2).putExtra("is_jsapi_close_page", this.HFH.HZq);
      ((aaa)localObject1).egJ.intent = ((Intent)localObject2);
      ((aaa)localObject1).egJ.dDL = this.prepayId;
      ((aaa)localObject1).egJ.result = -1;
      ((aaa)localObject1).egJ.egM = 1;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(70974);
  }
  
  protected final void fSE() {}
  
  protected final Orders fSS()
  {
    return this.HFH;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70973);
    this.HFH = ((Orders)getIntent().getParcelableExtra("key_orders"));
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