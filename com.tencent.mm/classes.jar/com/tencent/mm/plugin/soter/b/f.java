package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e.b;

public final class f
  extends m
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ai.f callback;
  private com.tencent.soter.a.f.b<e.b> mGF = null;
  private com.tencent.mm.ai.b rr;
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.mGF = paramb;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(59310);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(59310);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(59312);
    ab.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
    g.Rc().a(this, 0);
    AppMethodBeat.o(59312);
  }
  
  public final int getType()
  {
    return 619;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59311);
    ab.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
      if (this.mGF != null)
      {
        this.mGF.cW(new e.b(true));
        AppMethodBeat.o(59311);
      }
    }
    else
    {
      ab.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
      if (this.mGF != null) {
        this.mGF.cW(new e.b(false));
      }
    }
    AppMethodBeat.o(59311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.f
 * JD-Core Version:    0.7.0.1
 */