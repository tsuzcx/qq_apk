package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e.b;

public final class e
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private f callback;
  private com.tencent.soter.a.f.b<e.b> mGF = null;
  private com.tencent.mm.ai.b rr;
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.mGF = paramb;
  }
  
  public final void bzB()
  {
    AppMethodBeat.i(59306);
    ab.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.mGF != null) {
      this.mGF.cW(new e.b(false));
    }
    AppMethodBeat.o(59306);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(59305);
    ab.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.mGF != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mGF.cW(new e.b(true));
        AppMethodBeat.o(59305);
        return;
      }
      this.mGF.cW(new e.b(false));
    }
    AppMethodBeat.o(59305);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(59304);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(59304);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(59308);
    g.Rc().a(this, 0);
    AppMethodBeat.o(59308);
  }
  
  public final int getType()
  {
    return 1185;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(59307);
    ab.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(59307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.e
 * JD-Core Version:    0.7.0.1
 */