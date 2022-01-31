package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

public class WalletMixOrderInfoProxyUI
  extends WalletOrderInfoNewUI
{
  private String prepayId = null;
  private Orders qmc;
  
  protected final Orders bWG()
  {
    return this.qmc;
  }
  
  protected final void bWx() {}
  
  public final void done()
  {
    Object localObject1 = this.qDU.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!bk.bl((String)localObject2))
      {
        y.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", new Object[] { localObject2 });
        g.DQ();
        g.DO().dJT.a(new com.tencent.mm.wallet_core.c.p((String)localObject2), 0);
      }
    }
    if (!bk.bl(this.prepayId))
    {
      localObject1 = new tp();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_pay_end", true);
      ((tp)localObject1).cdQ.intent = ((Intent)localObject2);
      ((tp)localObject1).cdQ.bMX = this.prepayId;
      ((tp)localObject1).cdQ.result = -1;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    setResult(-1);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.qmc = ((Orders)getIntent().getParcelableExtra("key_orders"));
    this.prepayId = getIntent().getStringExtra("prepayId");
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoProxyUI
 * JD-Core Version:    0.7.0.1
 */