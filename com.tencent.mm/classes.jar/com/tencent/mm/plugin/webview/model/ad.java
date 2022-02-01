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
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.dor;

public final class ad
  extends n
  implements k
{
  private f gzH;
  public final b rr;
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78934);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new doq();
    ((b.a)localObject).hNN = new dor();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/transid";
    ((b.a)localObject).funcId = 1142;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (doq)this.rr.hNK.hNQ;
    ((doq)localObject).duW = paramString1;
    ((doq)localObject).FxE = paramString2;
    AppMethodBeat.o(78934);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78936);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78936);
    return i;
  }
  
  public final int getType()
  {
    return 1142;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78935);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */