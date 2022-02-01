package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e.b;

public final class e
  extends d
  implements com.tencent.soter.a.f.e
{
  private b<e.b> Bzg = null;
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public final void Sl(int paramInt)
  {
    AppMethodBeat.i(130814);
    Log.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(130814);
  }
  
  public final void a(b<e.b> paramb)
  {
    this.Bzg = paramb;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(130812);
    Log.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.Bzg != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Bzg.eH(new e.b(true));
        AppMethodBeat.o(130812);
        return;
      }
      this.Bzg.eH(new e.b(false));
    }
    AppMethodBeat.o(130812);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(130811);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(130811);
    return i;
  }
  
  public final void epa()
  {
    AppMethodBeat.i(130813);
    Log.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.Bzg != null) {
      this.Bzg.eH(new e.b(false));
    }
    AppMethodBeat.o(130813);
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130815);
    h.aGY().a(this, 0);
    AppMethodBeat.o(130815);
  }
  
  public final int getType()
  {
    return 1185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.e
 * JD-Core Version:    0.7.0.1
 */