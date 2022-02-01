package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.soter.a.f.e.b;

public final class f
  extends n
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  private com.tencent.soter.a.f.b<e.b> tsD = null;
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.tsD = paramb;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(130817);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(130817);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130819);
    ae.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
    g.ajj().a(this, 0);
    AppMethodBeat.o(130819);
  }
  
  public final int getType()
  {
    return 619;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130818);
    ae.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    com.tencent.mm.plugin.soter.d.m.AXk = paramString;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
      if (this.tsD != null)
      {
        this.tsD.ex(new e.b(true));
        AppMethodBeat.o(130818);
      }
    }
    else
    {
      ae.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
      if (this.tsD != null) {
        this.tsD.ex(new e.b(false));
      }
    }
    AppMethodBeat.o(130818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.f
 * JD-Core Version:    0.7.0.1
 */