package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.r;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private String prepayId = null;
  private Orders tVr;
  
  protected final Orders cVH()
  {
    return this.tVr;
  }
  
  protected final void cVu() {}
  
  public final void done()
  {
    AppMethodBeat.i(47410);
    Object localObject1 = this.uqP.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!bo.isNullOrNil((String)localObject2))
      {
        ab.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        g.RM();
        g.RK().eHt.a(new r((String)localObject2), 0);
      }
    }
    if (!bo.isNullOrNil(this.prepayId))
    {
      localObject1 = new vk();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((Intent)localObject2).putExtra("is_jsapi_close_page", this.tVr.ujy);
      ((vk)localObject1).cMA.intent = ((Intent)localObject2);
      ((vk)localObject1).cMA.cnI = this.prepayId;
      ((vk)localObject1).cMA.result = -1;
      ((vk)localObject1).cMA.cMD = 1;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(47410);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47409);
    this.tVr = ((Orders)getIntent().getParcelableExtra("key_orders"));
    this.prepayId = getIntent().getStringExtra("prepayId");
    super.onCreate(paramBundle);
    AppMethodBeat.o(47409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoProxyUI
 * JD-Core Version:    0.7.0.1
 */