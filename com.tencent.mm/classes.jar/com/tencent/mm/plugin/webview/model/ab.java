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
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;

public final class ab
  extends n
  implements k
{
  private f gzH;
  public final b rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(207937);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxu();
    ((b.a)localObject).hNN = new cxv();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((b.a)localObject).funcId = 1388;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxu)this.rr.hNK.hNQ;
    ((cxu)localObject).duW = paramString1;
    ((cxu)localObject).scope = paramString2;
    ((cxu)localObject).state = paramString3;
    ((cxu)localObject).Hpd = paramString6;
    ((cxu)localObject).Hpj = paramString4;
    ((cxu)localObject).Hpk = paramString5;
    AppMethodBeat.o(207937);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78929);
    this.gzH = paramf;
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
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */