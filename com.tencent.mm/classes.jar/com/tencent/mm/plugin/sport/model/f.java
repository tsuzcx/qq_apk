package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private dsh AGU;
  private com.tencent.mm.al.f callback;
  private b rr;
  
  public f(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(149305);
    this.callback = null;
    this.rr = null;
    ad.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    b.a locala = new b.a();
    locala.hNM = new dsh();
    locala.hNN = new dsi();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
    locala.funcId = 1261;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.AGU = ((dsh)this.rr.hNK.hNQ);
    this.AGU.cUi = paramString1;
    this.AGU.dow = paramString2;
    this.AGU.HEZ = paramInt1;
    this.AGU.HFa = paramInt2;
    this.AGU.cbX = paramInt3;
    this.AGU.HFb = String.valueOf(l.egA());
    this.AGU.HFd = paramString3;
    this.AGU.HFg = paramInt4;
    AppMethodBeat.o(149305);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(149306);
    this.callback = paramf;
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
    ad.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.f
 * JD-Core Version:    0.7.0.1
 */