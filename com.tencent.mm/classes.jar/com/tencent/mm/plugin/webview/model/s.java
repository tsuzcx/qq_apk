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
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.sdk.platformtools.ac;

public final class s
  extends n
  implements k
{
  private g gfX;
  public final b rr;
  
  public s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78894);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bme();
    ((b.a)localObject).hvu = new bmf();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
    ((b.a)localObject).funcId = 1566;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bme)this.rr.hvr.hvw;
    ((bme)localObject).ncR = paramString2;
    ((bme)localObject).hOf = paramString1;
    AppMethodBeat.o(78894);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78896);
    ac.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
    this.gfX = paramg;
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
    ac.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.s
 * JD-Core Version:    0.7.0.1
 */