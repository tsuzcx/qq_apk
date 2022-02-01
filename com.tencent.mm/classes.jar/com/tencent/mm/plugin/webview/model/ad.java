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
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ddn;

public final class ad
  extends n
  implements k
{
  private g gbr;
  public final b rr;
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78934);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ddm();
    ((b.a)localObject).gUV = new ddn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/transid";
    ((b.a)localObject).funcId = 1142;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ddm)this.rr.gUS.gUX;
    ((ddm)localObject).dlB = paramString1;
    ((ddm)localObject).CzP = paramString2;
    AppMethodBeat.o(78934);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78936);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
    this.gbr = paramg;
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
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */