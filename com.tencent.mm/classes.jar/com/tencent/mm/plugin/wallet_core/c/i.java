package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends n
  implements k
{
  public ceo Bot;
  private g callback;
  private final b rr;
  
  public i()
  {
    AppMethodBeat.i(69905);
    b.a locala = new b.a();
    cen localcen = new cen();
    localcen.timestamp = ce.azI();
    locala.hvt = localcen;
    locala.hvu = new ceo();
    locala.funcId = 1820;
    locala.uri = "/cgi-bin/mmpay-bin/getpayplugin";
    this.rr = locala.aAz();
    AppMethodBeat.o(69905);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69906);
    this.callback = paramg;
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
    ac.w("MicroMsg.NetSceneGetPayPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Bot = ((ceo)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */