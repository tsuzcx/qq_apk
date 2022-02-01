package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.end;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private enc Fjr;
  private i callback;
  private d rr;
  
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(149305);
    this.callback = null;
    this.rr = null;
    Log.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    d.a locala = new d.a();
    locala.iLN = new enc();
    locala.iLO = new end();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
    locala.funcId = 1261;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.Fjr = ((enc)this.rr.iLK.iLR);
    this.Fjr.dGL = paramString1;
    this.Fjr.dGP = paramString2;
    this.Fjr.NkT = paramInt1;
    this.Fjr.NkU = paramInt2;
    this.Fjr.cmD = paramInt3;
    this.Fjr.NkV = String.valueOf(k.fmI());
    this.Fjr.NkX = paramString3;
    this.Fjr.Nla = paramInt4;
    AppMethodBeat.o(149305);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(149306);
    this.callback = parami;
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
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */