package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fdf;
import com.tencent.mm.protocal.protobuf.fjw;
import com.tencent.mm.protocal.protobuf.fjx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class k
  extends w
{
  public String MQY;
  private h callback;
  private c rr;
  
  public k(fdf paramfdf, String paramString)
  {
    AppMethodBeat.i(66906);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fjw();
    ((c.a)localObject).otF = new fjx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/submitmallorder";
    ((c.a)localObject).funcId = 556;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fjw)c.b.b(this.rr.otB);
    ((fjw)localObject).abKq = paramfdf;
    ((fjw)localObject).abKs = paramString;
    AppMethodBeat.o(66906);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(66907);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66907);
    return i;
  }
  
  public final int getType()
  {
    return 556;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66908);
    params = (fjx)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + params.abKr);
      this.MQY = params.abKr;
    }
    Log.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.k
 * JD-Core Version:    0.7.0.1
 */