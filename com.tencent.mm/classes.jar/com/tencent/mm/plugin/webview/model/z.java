package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;

public final class z
  extends n
  implements k
{
  private g gfX;
  public final b rr;
  
  public z(String paramString)
  {
    AppMethodBeat.i(78921);
    b.a locala = new b.a();
    locala.hvt = new ciz();
    locala.hvu = new cja();
    locala.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
    locala.funcId = 2543;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((ciz)this.rr.hvr.hvw).Fnz = paramString;
    AppMethodBeat.o(78921);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78923);
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78923);
    return i;
  }
  
  public final int getType()
  {
    return 2543;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78922);
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.z
 * JD-Core Version:    0.7.0.1
 */