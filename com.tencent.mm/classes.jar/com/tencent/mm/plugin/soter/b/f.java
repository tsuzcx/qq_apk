package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.soter.a.f.e.b;

public final class f
  extends n
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  private com.tencent.soter.a.f.b<e.b> sli = null;
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.sli = paramb;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(130817);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(130817);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130819);
    ac.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
    com.tencent.mm.kernel.g.agi().a(this, 0);
    AppMethodBeat.o(130819);
  }
  
  public final int getType()
  {
    return 619;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130818);
    ac.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    com.tencent.mm.plugin.soter.d.m.znN = paramString;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
      if (this.sli != null)
      {
        this.sli.er(new e.b(true));
        AppMethodBeat.o(130818);
      }
    }
    else
    {
      ac.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
      if (this.sli != null) {
        this.sli.er(new e.b(false));
      }
    }
    AppMethodBeat.o(130818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.f
 * JD-Core Version:    0.7.0.1
 */