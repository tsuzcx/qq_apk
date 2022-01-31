package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.f.e.b;

public final class f
  extends m
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private com.tencent.soter.a.f.b<e.b> klO = null;
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
      if (this.klO != null) {
        this.klO.cr(new e.b(true));
      }
    }
    do
    {
      return;
      y.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
    } while (this.klO == null);
    this.klO.cr(new e.b(false));
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.klO = paramb;
  }
  
  public final void execute()
  {
    y.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
    g.Dk().a(this, 0);
  }
  
  public final int getType()
  {
    return 619;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.f
 * JD-Core Version:    0.7.0.1
 */