package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66686);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cdq();
    ((b.a)localObject).hvu = new cdr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((b.a)localObject).funcId = 389;
    ((b.a)localObject).reqCmdId = 187;
    ((b.a)localObject).respCmdId = 1000000187;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cdq)this.rr.hvr.hvw;
    ((cdq)localObject).Fsq = 1;
    if (!bs.isNullOrNil(paramString1)) {
      ((cdq)localObject).vxU = paramString1;
    }
    if (!bs.isNullOrNil(paramString2)) {
      ((cdq)localObject).vym = paramString2;
    }
    ((cdq)localObject).EhT = k.ero();
    AppMethodBeat.o(66686);
  }
  
  public final int dnP()
  {
    return ((cdq)this.rr.hvr.hvw).Fsq;
  }
  
  public final String dnQ()
  {
    return ((cdq)this.rr.hvr.hvw).vxU;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(66688);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66688);
    return i;
  }
  
  public final int getType()
  {
    return 389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66687);
    ac.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */