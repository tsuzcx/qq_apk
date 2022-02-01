package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private final b rr;
  public bib yST;
  
  public f()
  {
    AppMethodBeat.i(190291);
    b.a locala = new b.a();
    locala.hQF = new bia();
    locala.hQG = new bib();
    locala.funcId = 2745;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisstatus";
    this.rr = locala.aDS();
    AppMethodBeat.o(190291);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(190292);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(190292);
    return i;
  }
  
  public final int getType()
  {
    return 2745;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190293);
    ae.w("MicroMsg.NetSceneGetReceipAssistStatus", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.yST = ((bib)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(190293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */