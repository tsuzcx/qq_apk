package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e.b;

public final class g
  extends n
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.network.q gVZ;
  private b<e.b> rcO = null;
  
  public final void a(b<e.b> paramb)
  {
    this.rcO = paramb;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(130821);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(130821);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130823);
    ad.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
    com.tencent.mm.kernel.g.aeS().a(this, 0);
    AppMethodBeat.o(130823);
  }
  
  public final int getType()
  {
    return 627;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130822);
    ad.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
      if (this.rcO != null)
      {
        this.rcO.eq(new e.b(true));
        AppMethodBeat.o(130822);
      }
    }
    else
    {
      ad.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
      if (this.rcO != null) {
        this.rcO.eq(new e.b(false));
      }
    }
    AppMethodBeat.o(130822);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.g
 * JD-Core Version:    0.7.0.1
 */