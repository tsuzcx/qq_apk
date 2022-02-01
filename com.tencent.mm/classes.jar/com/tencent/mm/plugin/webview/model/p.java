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
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bgz;

public final class p
  extends n
  implements k
{
  private f gzH;
  public final b rr;
  
  public p(String paramString)
  {
    AppMethodBeat.i(78885);
    b.a locala = new b.a();
    locala.hNM = new bgy();
    locala.hNN = new bgz();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
    locala.funcId = 2785;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((bgy)this.rr.hNK.hNQ).duW = paramString;
    AppMethodBeat.o(78885);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78887);
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78887);
    return i;
  }
  
  public final int getType()
  {
    return 2785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78886);
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.p
 * JD-Core Version:    0.7.0.1
 */