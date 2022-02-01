package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.dts;

public final class g
  extends n
  implements k
{
  private f callback;
  public bjt yCP;
  public byte[] yCQ;
  
  public g(byte[] paramArrayOfByte)
  {
    this.yCQ = paramArrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73771);
    this.callback = paramf;
    paramf = new b.a();
    bjs localbjs = new bjs();
    if (this.yCQ != null) {
      localbjs.GEh = z.al(this.yCQ).getBuffer();
    }
    paramf.hNM = localbjs;
    this.yCP = new bjt();
    paramf.hNN = this.yCP;
    paramf.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramf.funcId = getType();
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDC(), this);
    AppMethodBeat.o(73771);
    return i;
  }
  
  public final int getType()
  {
    return 1146;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73772);
    this.yCP = ((bjt)((b)paramq).hNL.hNQ);
    if (this.yCP.Gcg != null)
    {
      paramInt3 = this.yCP.Gcg.dqI;
      paramString = this.yCP.Gcg.dqJ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */