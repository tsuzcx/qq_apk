package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.protocal.protobuf.cf;

public final class i
  extends n
  implements k
{
  private f gzH;
  public final com.tencent.mm.al.b rr;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78865);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ce();
    ((b.a)localObject).hNN = new cf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).funcId = 2500;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ce)this.rr.hNK.hNQ;
    ((ce)localObject).duW = paramString1;
    ((ce)localObject).nickname = paramString2;
    ((ce)localObject).fileid = paramString3;
    ((ce)localObject).FuF = 1;
    AppMethodBeat.o(78865);
  }
  
  public i(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78864);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ce();
    ((b.a)localObject).hNN = new cf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).funcId = 2500;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ce)this.rr.hNK.hNQ;
    ((ce)localObject).duW = paramString1;
    ((ce)localObject).nickname = paramString2;
    ((ce)localObject).FuE = new com.tencent.mm.bx.b(paramArrayOfByte);
    ((ce)localObject).FuF = 0;
    AppMethodBeat.o(78864);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78867);
    this.gzH = paramf;
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
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */