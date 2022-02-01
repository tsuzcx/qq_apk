package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  private g callback;
  private b rr;
  private dmq zpa;
  
  public f(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(149305);
    this.callback = null;
    this.rr = null;
    ac.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    b.a locala = new b.a();
    locala.hvt = new dmq();
    locala.hvu = new dmr();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
    locala.funcId = 1261;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.zpa = ((dmq)this.rr.hvr.hvw);
    this.zpa.cIZ = paramString1;
    this.zpa.dda = paramString2;
    this.zpa.FUl = paramInt1;
    this.zpa.FUm = paramInt2;
    this.zpa.bRK = paramInt3;
    this.zpa.FUn = String.valueOf(l.dUm());
    this.zpa.FUp = paramString3;
    this.zpa.FUs = paramInt4;
    AppMethodBeat.o(149305);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(149306);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(149306);
    return i;
  }
  
  public final int getType()
  {
    return 1261;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149307);
    ac.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.f
 * JD-Core Version:    0.7.0.1
 */