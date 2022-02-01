package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
  extends w
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  public t(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72794);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cer();
    ((b.a)localObject).hvu = new ces();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((b.a)localObject).funcId = 421;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aSQ(paramString2);
    this.rr = ((b.a)localObject).aAz();
    localObject = (cer)this.rr.hvr.hvw;
    ((cer)localObject).Fto = paramString1;
    ((cer)localObject).EhT = k.ero();
    ((cer)localObject).Ftp = paramString3;
    if (!bs.isNullOrNil(paramString2)) {
      ((cer)localObject).Ftq = new com.tencent.mm.bw.b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((cer)localObject).EhO = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((cer)localObject).DLC = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((cer)localObject).Ftr = paramInt3;
    }
    AppMethodBeat.o(72794);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(72795);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetScenePaySubscribe", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */