package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cne;

public final class ab
  extends n
  implements k
{
  private g gbr;
  public final b rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(187891);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cnd();
    ((b.a)localObject).gUV = new cne();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((b.a)localObject).funcId = 1388;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cnd)this.rr.gUS.gUX;
    ((cnd)localObject).dlB = paramString1;
    ((cnd)localObject).scope = paramString2;
    ((cnd)localObject).state = paramString3;
    ((cnd)localObject).EhL = paramString6;
    ((cnd)localObject).EhM = paramString4;
    ((cnd)localObject).EhN = paramString5;
    AppMethodBeat.o(187891);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78929);
    this.gbr = paramg;
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
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */