package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.soter.a.f.e.b;

public final class e
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  private com.tencent.soter.a.f.b<e.b> sli = null;
  
  public final void Fn(int paramInt)
  {
    AppMethodBeat.i(130814);
    ac.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(130814);
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.sli = paramb;
  }
  
  public final void cHM()
  {
    AppMethodBeat.i(130813);
    ac.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.sli != null) {
      this.sli.er(new e.b(false));
    }
    AppMethodBeat.o(130813);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(130812);
    ac.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.sli != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sli.er(new e.b(true));
        AppMethodBeat.o(130812);
        return;
      }
      this.sli.er(new e.b(false));
    }
    AppMethodBeat.o(130812);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(130811);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(130811);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130815);
    com.tencent.mm.kernel.g.agi().a(this, 0);
    AppMethodBeat.o(130815);
  }
  
  public final int getType()
  {
    return 1185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.e
 * JD-Core Version:    0.7.0.1
 */