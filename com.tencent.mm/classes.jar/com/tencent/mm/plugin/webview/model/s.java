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
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.sdk.platformtools.ae;

public final class s
  extends n
  implements k
{
  private f gCo;
  public final b rr;
  
  public s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78894);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bri();
    ((b.a)localObject).hQG = new brj();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
    ((b.a)localObject).funcId = 1566;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bri)this.rr.hQD.hQJ;
    ((bri)localObject).nIJ = paramString2;
    ((bri)localObject).ikm = paramString1;
    AppMethodBeat.o(78894);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78896);
    ae.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78896);
    return i;
  }
  
  public final int getType()
  {
    return 1566;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78895);
    ae.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.s
 * JD-Core Version:    0.7.0.1
 */