package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public bdd Bow;
  private g callback;
  private final b rr;
  
  public k()
  {
    AppMethodBeat.i(207267);
    b.a locala = new b.a();
    bdc localbdc = new bdc();
    localbdc.timestamp = ce.azI();
    locala.hvt = localbdc;
    locala.hvu = new bdd();
    locala.funcId = 2860;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisplugin";
    this.rr = locala.aAz();
    AppMethodBeat.o(207267);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(207268);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(207268);
    return i;
  }
  
  public final int getType()
  {
    return 2860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207269);
    ac.w("MicroMsg.NetSceneGetReceipAssistPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Bow = ((bdd)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(207269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */