package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;

public final class z
  extends n
  implements k
{
  private f gCo;
  public final b rr;
  
  public z(String paramString)
  {
    AppMethodBeat.i(78921);
    b.a locala = new b.a();
    locala.hQF = new cot();
    locala.hQG = new cou();
    locala.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
    locala.funcId = 2543;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cot)this.rr.hQD.hQJ).HqI = paramString;
    AppMethodBeat.o(78921);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78923);
    this.gCo = paramf;
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
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.z
 * JD-Core Version:    0.7.0.1
 */