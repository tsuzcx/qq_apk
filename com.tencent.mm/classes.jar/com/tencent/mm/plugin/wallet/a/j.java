package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tf;
import com.tencent.mm.h.a.tf.a;
import com.tencent.mm.h.a.tf.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class j
  extends c<tf>
{
  public j()
  {
    this.udX = tf.class.getName().hashCode();
  }
  
  private static void a(tf paramtf, f paramf)
  {
    y.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    g.DQ();
    g.DO().dJT.a(1767, paramf);
    paramtf = paramtf.ccO;
    y.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramtf.appId, paramtf.nonceStr, paramtf.bIK, paramtf.ccQ, paramtf.ccR, paramtf.signType, paramtf.url });
    paramtf = new a(paramtf.appId, paramtf.nonceStr, paramtf.bIK, paramtf.ccQ, paramtf.ccR, paramtf.signType, paramtf.url);
    g.DQ();
    g.DO().dJT.a(paramtf, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */