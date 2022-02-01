package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

public final class t
  extends w
{
  private h callback;
  private c rr;
  
  public t(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72794);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ecq();
    ((c.a)localObject).otF = new ecr();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((c.a)localObject).funcId = 421;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).routeInfo = i.bEV(paramString2);
    this.rr = ((c.a)localObject).bEF();
    localObject = (ecq)c.b.b(this.rr.otB);
    ((ecq)localObject).abif = paramString1;
    ((ecq)localObject).Zbi = k.iis();
    ((ecq)localObject).abig = paramString3;
    if (!Util.isNullOrNil(paramString2)) {
      ((ecq)localObject).abih = new b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((ecq)localObject).Zbd = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((ecq)localObject).YJZ = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((ecq)localObject).abii = paramInt3;
    }
    AppMethodBeat.o(72794);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72795);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72795);
    return i;
  }
  
  public final int getType()
  {
    return 421;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72796);
    Log.d("MicroMsg.NetScenePaySubscribe", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */