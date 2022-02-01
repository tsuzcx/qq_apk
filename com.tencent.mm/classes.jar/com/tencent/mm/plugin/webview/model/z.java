package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.coa;

public final class z
  extends n
  implements k
{
  private f gzH;
  public final b rr;
  
  public z(String paramString)
  {
    AppMethodBeat.i(78921);
    b.a locala = new b.a();
    locala.hNM = new cnz();
    locala.hNN = new coa();
    locala.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
    locala.funcId = 2543;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((cnz)this.rr.hNK.hNQ).GXi = paramString;
    AppMethodBeat.o(78921);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78923);
    this.gzH = paramf;
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
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.z
 * JD-Core Version:    0.7.0.1
 */