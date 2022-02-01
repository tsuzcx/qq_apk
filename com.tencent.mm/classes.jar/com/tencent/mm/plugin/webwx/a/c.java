package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b hdD;
  
  public c(String paramString)
  {
    AppMethodBeat.i(30172);
    b.a locala = new b.a();
    aei localaei = new aei();
    aej localaej = new aej();
    locala.gUU = localaei;
    locala.gUV = localaej;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localaei.Dex = paramString;
    this.hdD = locala.atI();
    AppMethodBeat.o(30172);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30173);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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