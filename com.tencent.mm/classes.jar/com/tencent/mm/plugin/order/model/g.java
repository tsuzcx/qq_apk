package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    ((b.a)localObject).hNM = new cip();
    ((b.a)localObject).hNN = new ciq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((b.a)localObject).funcId = 389;
    ((b.a)localObject).hNO = 187;
    ((b.a)localObject).respCmdId = 1000000187;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cip)this.rr.hNK.hNQ;
    ((cip)localObject).Hcw = 1;
    if (!bt.isNullOrNil(paramString1)) {
      ((cip)localObject).wDo = paramString1;
    }
    if (!bt.isNullOrNil(paramString2)) {
      ((cip)localObject).wDG = paramString2;
    }
    ((cip)localObject).FPa = k.eFo();
    AppMethodBeat.o(66686);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66688);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66688);
    return i;
  }
  
  public final int dyh()
  {
    return ((cip)this.rr.hNK.hNQ).Hcw;
  }
  
  public final String dyi()
  {
    return ((cip)this.rr.hNK.hNQ).wDo;
  }
  
  public final int getType()
  {
    return 389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66687);
    ad.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */