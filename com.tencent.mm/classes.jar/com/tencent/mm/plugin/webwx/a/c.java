package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.aig;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b hZD;
  
  public c(String paramString)
  {
    AppMethodBeat.i(30172);
    b.a locala = new b.a();
    aif localaif = new aif();
    aig localaig = new aig();
    locala.hQF = localaif;
    locala.hQG = localaig;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.hQH = 0;
    locala.respCmdId = 0;
    localaif.GxR = paramString;
    this.hZD = locala.aDS();
    AppMethodBeat.o(30172);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30173);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(30173);
    return i;
  }
  
  public final int getType()
  {
    return 973;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30174);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.c
 * JD-Core Version:    0.7.0.1
 */