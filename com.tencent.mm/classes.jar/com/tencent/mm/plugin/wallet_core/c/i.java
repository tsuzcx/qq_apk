package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  public ckh Dgn;
  private f callback;
  private final b rr;
  
  public i()
  {
    AppMethodBeat.i(69905);
    b.a locala = new b.a();
    ckg localckg = new ckg();
    localckg.timestamp = ch.aDb();
    locala.hQF = localckg;
    locala.hQG = new ckh();
    locala.funcId = 1820;
    locala.uri = "/cgi-bin/mmpay-bin/getpayplugin";
    this.rr = locala.aDS();
    AppMethodBeat.o(69905);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69906);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69906);
    return i;
  }
  
  public final int getType()
  {
    return 1820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69907);
    ae.w("MicroMsg.NetSceneGetPayPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Dgn = ((ckh)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */