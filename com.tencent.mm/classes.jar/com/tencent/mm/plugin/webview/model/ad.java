package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.sdk.platformtools.ae;

public final class ad
  extends n
  implements k
{
  private f gCo;
  public final b rr;
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78934);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dpn();
    ((b.a)localObject).hQG = new dpo();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/transid";
    ((b.a)localObject).funcId = 1142;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dpn)this.rr.hQD.hQJ;
    ((dpn)localObject).dwb = paramString1;
    ((dpn)localObject).FQc = paramString2;
    AppMethodBeat.o(78934);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78936);
    ae.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
    this.gCo = paramf;
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
    ae.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */