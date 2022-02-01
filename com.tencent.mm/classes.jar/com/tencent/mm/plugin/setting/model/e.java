package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public bdf xoj;
  
  public e()
  {
    AppMethodBeat.i(190966);
    b.a locala = new b.a();
    locala.hvt = new bde();
    locala.hvu = new bdf();
    locala.funcId = 2745;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisstatus";
    this.rr = locala.aAz();
    AppMethodBeat.o(190966);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(190967);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(190967);
    return i;
  }
  
  public final int getType()
  {
    return 2745;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190968);
    ac.w("MicroMsg.NetSceneGetReceipAssistStatus", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.xoj = ((bdf)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(190968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */