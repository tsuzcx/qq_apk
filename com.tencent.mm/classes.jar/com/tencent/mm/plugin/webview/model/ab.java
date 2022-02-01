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
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csl;

public final class ab
  extends n
  implements k
{
  private g gfX;
  public final b rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(188318);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new csk();
    ((b.a)localObject).hvu = new csl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((b.a)localObject).funcId = 1388;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (csk)this.rr.hvr.hvw;
    ((csk)localObject).djj = paramString1;
    ((csk)localObject).scope = paramString2;
    ((csk)localObject).state = paramString3;
    ((csk)localObject).FEJ = paramString6;
    ((csk)localObject).FEK = paramString4;
    ((csk)localObject).FEL = paramString5;
    AppMethodBeat.o(188318);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78929);
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78929);
    return i;
  }
  
  public final int getType()
  {
    return 1388;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78928);
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */