package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Date;

public final class u
  extends c<ti>
  implements f
{
  private String brs = null;
  private ti qyD;
  
  public u()
  {
    this.udX = ti.class.getName().hashCode();
  }
  
  private void bVB()
  {
    d locald = o.bVw();
    r localr = new r();
    localr.field_bulletin_scene = this.brs;
    if (!locald.b(localr, new String[0])) {
      y.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.qyD.bFJ.run();
      this.qyD = null;
      return;
      this.qyD.ccV.ccW = localr.field_bulletin_scene;
      this.qyD.ccV.content = localr.field_bulletin_content;
      this.qyD.ccV.url = localr.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    g.DQ();
    g.DO().dJT.b(385, this);
    g.DQ();
    g.DP().Dz().c(ac.a.urB, Long.valueOf(new Date().getTime()));
    bVB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */