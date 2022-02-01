package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public bhz Dgq;
  private f callback;
  private final b rr;
  
  public k()
  {
    AppMethodBeat.i(190159);
    b.a locala = new b.a();
    bhy localbhy = new bhy();
    localbhy.timestamp = ch.aDb();
    locala.hQF = localbhy;
    locala.hQG = new bhz();
    locala.funcId = 2860;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisplugin";
    this.rr = locala.aDS();
    AppMethodBeat.o(190159);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(190160);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(190160);
    return i;
  }
  
  public final int getType()
  {
    return 2860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190161);
    ae.w("MicroMsg.NetSceneGetReceipAssistPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Dgq = ((bhz)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(190161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */