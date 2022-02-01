package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b hWL;
  
  public c(String paramString)
  {
    AppMethodBeat.i(30172);
    b.a locala = new b.a();
    ahv localahv = new ahv();
    ahw localahw = new ahw();
    locala.hNM = localahv;
    locala.hNN = localahw;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.hNO = 0;
    locala.respCmdId = 0;
    localahv.Gfj = paramString;
    this.hWL = locala.aDC();
    AppMethodBeat.o(30172);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30173);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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