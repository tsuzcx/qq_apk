package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e.b;

public final class g
  extends n
  implements k, com.tencent.soter.a.f.e
{
  private f callback;
  private com.tencent.mm.network.q hRG;
  private b<e.b> tsD = null;
  
  public final void a(b<e.b> paramb)
  {
    this.tsD = paramb;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(130821);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(130821);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130823);
    ae.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
    com.tencent.mm.kernel.g.ajj().a(this, 0);
    AppMethodBeat.o(130823);
  }
  
  public final int getType()
  {
    return 627;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130822);
    ae.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
      if (this.tsD != null)
      {
        this.tsD.ex(new e.b(true));
        AppMethodBeat.o(130822);
      }
    }
    else
    {
      ae.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
      if (this.tsD != null) {
        this.tsD.ex(new e.b(false));
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.g
 * JD-Core Version:    0.7.0.1
 */