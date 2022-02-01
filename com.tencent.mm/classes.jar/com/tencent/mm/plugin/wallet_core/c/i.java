package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  public dap HPG;
  private com.tencent.mm.ak.i callback;
  private final d rr;
  
  public i()
  {
    AppMethodBeat.i(69905);
    d.a locala = new d.a();
    dao localdao = new dao();
    localdao.timestamp = cl.aWz();
    locala.iLN = localdao;
    locala.iLO = new dap();
    locala.funcId = 1820;
    locala.uri = "/cgi-bin/mmpay-bin/getpayplugin";
    this.rr = locala.aXF();
    AppMethodBeat.o(69905);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(69906);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69906);
    return i;
  }
  
  public final int getType()
  {
    return 1820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69907);
    Log.w("MicroMsg.NetSceneGetPayPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HPG = ((dap)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */