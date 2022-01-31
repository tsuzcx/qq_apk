package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private b rr;
  private cnx spG;
  
  public f(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(93663);
    this.callback = null;
    this.rr = null;
    ab.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    b.a locala = new b.a();
    locala.fsX = new cnx();
    locala.fsY = new cny();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
    locala.funcId = 1261;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.spG = ((cnx)this.rr.fsV.fta);
    this.spG.bYu = paramString1;
    this.spG.cqJ = paramString2;
    this.spG.xWE = paramInt1;
    this.spG.xWF = paramInt2;
    this.spG.brG = paramInt3;
    this.spG.xWG = String.valueOf(n.cyZ());
    this.spG.xWI = paramString3;
    this.spG.xWL = paramInt4;
    AppMethodBeat.o(93663);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(93664);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(93664);
    return i;
  }
  
  public final int getType()
  {
    return 1261;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93665);
    ab.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(93665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.f
 * JD-Core Version:    0.7.0.1
 */