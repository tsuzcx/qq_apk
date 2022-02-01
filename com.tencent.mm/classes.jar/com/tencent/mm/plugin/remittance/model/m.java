package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public vr CoI;
  private vq CoJ;
  private i callback;
  private final d rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213730);
    d.a locala = new d.a();
    locala.iLN = new vq();
    locala.iLO = new vr();
    locala.funcId = 2850;
    locala.uri = "/cgi-bin/mmpay-bin/f2fminiprogramconfirmrcvr";
    this.rr = locala.aXF();
    this.CoJ = ((vq)this.rr.iLK.iLR);
    this.CoJ.Cqr = paramString1;
    this.CoJ.dNI = paramString2;
    AppMethodBeat.o(213730);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(213731);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(213731);
    return i;
  }
  
  public final int getType()
  {
    return 2850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213732);
    Log.i("MicroMsg.NetSceneF2FMinniProgramConfirm", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.CoI = ((vr)((d)params).iLL.iLR);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(213732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */