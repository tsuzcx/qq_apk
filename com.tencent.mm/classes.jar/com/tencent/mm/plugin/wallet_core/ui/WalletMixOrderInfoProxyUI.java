package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.t;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private Orders VmL;
  private String prepayId = null;
  
  public final void done()
  {
    AppMethodBeat.i(70974);
    Object localObject1 = this.VPH.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!Util.isNullOrNil((String)localObject2))
      {
        Log.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        h.baF();
        h.baD().mCm.a(new t((String)localObject2), 0);
      }
    }
    if (!Util.isNullOrNil(this.prepayId))
    {
      localObject1 = new ade();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((Intent)localObject2).putExtra("is_jsapi_close_page", this.VmL.VHk);
      ((ade)localObject1).ihj.intent = ((Intent)localObject2);
      ((ade)localObject1).ihj.hAT = this.prepayId;
      ((ade)localObject1).ihj.result = -1;
      ((ade)localObject1).ihj.ihm = 1;
      ((ade)localObject1).publish();
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(70974);
  }
  
  protected final void ikB() {}
  
  protected final Orders ikP()
  {
    return this.VmL;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70973);
    this.VmL = ((Orders)getIntent().getParcelableExtra("key_orders"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoProxyUI
 * JD-Core Version:    0.7.0.1
 */