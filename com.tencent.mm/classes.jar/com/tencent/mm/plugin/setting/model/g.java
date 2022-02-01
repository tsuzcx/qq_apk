package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  public btz CXL;
  private i callback;
  private final d rr;
  
  public g()
  {
    AppMethodBeat.i(256459);
    d.a locala = new d.a();
    locala.iLN = new bty();
    locala.iLO = new btz();
    locala.funcId = 2745;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisstatus";
    this.rr = locala.aXF();
    AppMethodBeat.o(256459);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(256460);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(256460);
    return i;
  }
  
  public final int getType()
  {
    return 2745;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256461);
    Log.w("MicroMsg.NetSceneGetReceipAssistStatus", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.CXL = ((btz)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(256461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */