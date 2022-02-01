package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private wh CoL;
  private i callback;
  private d hJu;
  
  public o(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67865);
    d.a locala = new d.a();
    locala.iLN = new wh();
    locala.iLO = new wi();
    locala.funcId = 1273;
    locala.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.CoL = ((wh)this.hJu.iLK.iLR);
    this.CoL.KHM = paramString1;
    this.CoL.KHN = paramString2;
    this.CoL.Lhy = paramString3;
    this.CoL.Lhz = paramString4;
    this.CoL.yRL = paramInt;
    Log.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67865);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67866);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67866);
    return i;
  }
  
  public final int getType()
  {
    return 1273;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67867);
    Log.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.o
 * JD-Core Version:    0.7.0.1
 */