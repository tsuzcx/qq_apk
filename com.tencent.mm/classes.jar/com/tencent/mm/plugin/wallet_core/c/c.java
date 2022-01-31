package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.or;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  public LinkedList<String> qqx;
  
  public c(LinkedList<String> paramLinkedList)
  {
    y.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aca();
    ((b.a)localObject).ecI = new acb();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((b.a)localObject).ecG = 1650;
    this.dmK = ((b.a)localObject).Kt();
    this.dmK.ecZ = true;
    localObject = (aca)this.dmK.ecE.ecN;
    ((aca)localObject).tba = paramLinkedList;
    ((aca)localObject).sHl = i.bVj();
    if (!com.tencent.mm.pluginsdk.wallet.f.cow()) {
      ((aca)localObject).sLl = com.tencent.mm.pluginsdk.wallet.f.cox();
    }
    com.tencent.mm.wallet_core.ui.e.Jc(42);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (acb)((b)paramq).ecF.ecN;
      y.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { paramq.tbb });
      this.qqx = paramq.qqx;
      paramArrayOfByte = this.qqx;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        y.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        g.DQ();
        g.DP().Dz().c(ac.a.usm, bk.aM(paramq.tbb, ""));
        g.DQ();
        g.DP().Dz().c(ac.a.usn, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      or localor = new or();
      localor.bYj.bYl = paramArrayOfByte;
      a.udP.m(localor);
      break;
      com.tencent.mm.wallet_core.ui.e.Jc(43);
    }
  }
  
  public final int getType()
  {
    return 1650;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */