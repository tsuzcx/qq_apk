package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e.b;

public final class g
  extends m
  implements k, com.tencent.soter.a.f.e
{
  private f dmL;
  private q edR;
  private b<e.b> klO = null;
  
  protected final int Ka()
  {
    return 3;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
      if (this.klO != null) {
        this.klO.cr(new e.b(true));
      }
    }
    do
    {
      return;
      y.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
    } while (this.klO == null);
    this.klO.cr(new e.b(false));
  }
  
  public final void a(b<e.b> paramb)
  {
    this.klO = paramb;
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final void execute()
  {
    y.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
    com.tencent.mm.kernel.g.Dk().a(this, 0);
  }
  
  public final int getType()
  {
    return 627;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.g
 * JD-Core Version:    0.7.0.1
 */