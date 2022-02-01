package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;

public final class i
  extends n
  implements k
{
  private g gbr;
  public final com.tencent.mm.al.b rr;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78865);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cc();
    ((b.a)localObject).gUV = new cd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).funcId = 2500;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cc)this.rr.gUS.gUX;
    ((cc)localObject).dlB = paramString1;
    ((cc)localObject).nickname = paramString2;
    ((cc)localObject).fileid = paramString3;
    ((cc)localObject).CwZ = 1;
    AppMethodBeat.o(78865);
  }
  
  public i(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78864);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cc();
    ((b.a)localObject).gUV = new cd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).funcId = 2500;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cc)this.rr.gUS.gUX;
    ((cc)localObject).dlB = paramString1;
    ((cc)localObject).nickname = paramString2;
    ((cc)localObject).CwY = new com.tencent.mm.bx.b(paramArrayOfByte);
    ((cc)localObject).CwZ = 0;
    AppMethodBeat.o(78864);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78867);
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78867);
    return i;
  }
  
  public final int getType()
  {
    return 2500;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78866);
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */