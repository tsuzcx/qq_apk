package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b hEg;
  
  public c(String paramString)
  {
    AppMethodBeat.i(30172);
    b.a locala = new b.a();
    afh localafh = new afh();
    afi localafi = new afi();
    locala.hvt = localafh;
    locala.hvu = localafi;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localafh.ExD = paramString;
    this.hEg = locala.aAz();
    AppMethodBeat.o(30172);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30173);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.c
 * JD-Core Version:    0.7.0.1
 */