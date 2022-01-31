package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aou;

public final class o
  extends m
  implements k
{
  private f eGj;
  public final b rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(6604);
    b.a locala = new b.a();
    locala.fsX = new aot();
    locala.fsY = new aou();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
    locala.funcId = 2785;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((aot)this.rr.fsV.fta).cwc = paramString;
    AppMethodBeat.o(6604);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6606);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6606);
    return i;
  }
  
  public final int getType()
  {
    return 2785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6605);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.o
 * JD-Core Version:    0.7.0.1
 */