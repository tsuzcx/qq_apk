package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class l
  extends w
  implements k
{
  private g callback;
  private b rr;
  public String vFa;
  
  public l(czk paramczk, String paramString)
  {
    AppMethodBeat.i(66906);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dfb();
    ((b.a)localObject).hvu = new dfc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitmallorder";
    ((b.a)localObject).funcId = 556;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dfb)this.rr.hvr.hvw;
    ((dfb)localObject).FOr = paramczk;
    ((dfb)localObject).FOt = paramString;
    AppMethodBeat.o(66906);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66907);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66907);
    return i;
  }
  
  public final int getType()
  {
    return 556;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66908);
    paramq = (dfc)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + paramq.FOs);
      this.vFa = paramq.FOs;
    }
    ac.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.l
 * JD-Core Version:    0.7.0.1
 */