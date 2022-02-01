package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
{
  private f callback;
  private b rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66686);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cjj();
    ((b.a)localObject).hQG = new cjk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((b.a)localObject).funcId = 389;
    ((b.a)localObject).hQH = 187;
    ((b.a)localObject).respCmdId = 1000000187;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cjj)this.rr.hQD.hQJ;
    ((cjj)localObject).HvW = 1;
    if (!bu.isNullOrNil(paramString1)) {
      ((cjj)localObject).wSZ = paramString1;
    }
    if (!bu.isNullOrNil(paramString2)) {
      ((cjj)localObject).wTr = paramString2;
    }
    ((cjj)localObject).Ghz = k.eIV();
    AppMethodBeat.o(66686);
  }
  
  public final int dBx()
  {
    return ((cjj)this.rr.hQD.hQJ).HvW;
  }
  
  public final String dBy()
  {
    return ((cjj)this.rr.hQD.hQJ).wSZ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66688);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */