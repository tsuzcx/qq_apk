package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
  extends w
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  
  public t(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72794);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ckk();
    ((b.a)localObject).hQG = new ckl();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((b.a)localObject).funcId = 421;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.f.bas(paramString2);
    this.rr = ((b.a)localObject).aDS();
    localObject = (ckk)this.rr.hQD.hQJ;
    ((ckk)localObject).HwU = paramString1;
    ((ckk)localObject).Ghz = k.eIV();
    ((ckk)localObject).HwV = paramString3;
    if (!bu.isNullOrNil(paramString2)) {
      ((ckk)localObject).HwW = new com.tencent.mm.bw.b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((ckk)localObject).Ghu = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((ckk)localObject).FJf = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((ckk)localObject).HwX = paramInt3;
    }
    AppMethodBeat.o(72794);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(72795);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72795);
    return i;
  }
  
  public final int getType()
  {
    return 421;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72796);
    ae.d("MicroMsg.NetScenePaySubscribe", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */