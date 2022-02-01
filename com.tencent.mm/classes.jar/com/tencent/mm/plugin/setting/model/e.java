package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private f callback;
  private final b rr;
  public bhl yCO;
  
  public e()
  {
    AppMethodBeat.i(220929);
    b.a locala = new b.a();
    locala.hNM = new bhk();
    locala.hNN = new bhl();
    locala.funcId = 2745;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisstatus";
    this.rr = locala.aDC();
    AppMethodBeat.o(220929);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(220930);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(220930);
    return i;
  }
  
  public final int getType()
  {
    return 2745;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220931);
    ad.w("MicroMsg.NetSceneGetReceipAssistStatus", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.yCO = ((bhl)((b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(220931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */