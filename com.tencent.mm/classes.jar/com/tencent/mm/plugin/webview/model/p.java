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
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;

public final class p
  extends n
  implements k
{
  private g gfX;
  public final b rr;
  
  public p(String paramString)
  {
    AppMethodBeat.i(78885);
    b.a locala = new b.a();
    locala.hvt = new bcs();
    locala.hvu = new bct();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
    locala.funcId = 2785;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((bcs)this.rr.hvr.hvw).djj = paramString;
    AppMethodBeat.o(78885);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78887);
    this.gfX = paramg;
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
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.p
 * JD-Core Version:    0.7.0.1
 */