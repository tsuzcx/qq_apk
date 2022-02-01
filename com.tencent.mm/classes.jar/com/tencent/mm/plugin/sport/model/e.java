package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.protocal.protobuf.ftd;
import com.tencent.mm.protocal.protobuf.fte;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends com.tencent.mm.am.p
  implements m
{
  private ftd SbD;
  private h callback;
  private c rr;
  
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(149305);
    this.callback = null;
    this.rr = null;
    Log.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    c.a locala = new c.a();
    locala.otE = new ftd();
    locala.otF = new fte();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
    locala.funcId = 1261;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.SbD = ((ftd)c.b.b(this.rr.otB));
    this.SbD.hEl = paramString1;
    this.SbD.hEr = paramString2;
    this.SbD.abRl = paramInt1;
    this.SbD.abRm = paramInt2;
    this.SbD.abHt = paramInt3;
    this.SbD.abRn = String.valueOf(p.huu());
    this.SbD.abRp = paramString3;
    this.SbD.abRs = paramInt4;
    AppMethodBeat.o(149305);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(149306);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(149306);
    return i;
  }
  
  public final int getType()
  {
    return 1261;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149307);
    Log.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    l.kK(10, 12);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */