package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  public btx HPJ;
  private i callback;
  private final d rr;
  
  public k()
  {
    AppMethodBeat.i(214160);
    d.a locala = new d.a();
    btw localbtw = new btw();
    localbtw.timestamp = cl.aWz();
    locala.iLN = localbtw;
    locala.iLO = new btx();
    locala.funcId = 2860;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisplugin";
    this.rr = locala.aXF();
    AppMethodBeat.o(214160);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(214161);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(214161);
    return i;
  }
  
  public final int getType()
  {
    return 2860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214162);
    Log.w("MicroMsg.NetSceneGetReceipAssistPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HPJ = ((btx)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(214162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */