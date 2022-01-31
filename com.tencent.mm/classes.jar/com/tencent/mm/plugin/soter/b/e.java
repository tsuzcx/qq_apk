package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.f.e.b;

public final class e
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private com.tencent.soter.a.f.b<e.b> klO = null;
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.klO = paramb;
  }
  
  public final void aTg()
  {
    y.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
    if (this.dmL != null) {
      this.dmL.onSceneEnd(4, -1, "", this);
    }
    if (this.klO != null) {
      this.klO.cr(new e.b(false));
    }
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.klO != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.klO.cr(new e.b(true));
      }
    }
    else {
      return;
    }
    this.klO.cr(new e.b(false));
  }
  
  public final void execute()
  {
    g.Dk().a(this, 0);
  }
  
  public final int getType()
  {
    return 1185;
  }
  
  public final void rl(int paramInt)
  {
    y.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(4, -1, "", this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.e
 * JD-Core Version:    0.7.0.1
 */