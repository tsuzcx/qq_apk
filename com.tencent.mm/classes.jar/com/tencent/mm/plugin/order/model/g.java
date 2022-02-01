package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;

public final class g
  extends w
{
  private h callback;
  private c rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66686);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ebp();
    ((c.a)localObject).otF = new ebq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((c.a)localObject).funcId = 389;
    ((c.a)localObject).otG = 187;
    ((c.a)localObject).respCmdId = 1000000187;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ebp)c.b.b(this.rr.otB);
    ((ebp)localObject).abhg = 1;
    if (!Util.isNullOrNil(paramString1)) {
      ((ebp)localObject).MEX = paramString1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((ebp)localObject).MFp = paramString2;
    }
    ((ebp)localObject).Zbi = k.iis();
    AppMethodBeat.o(66686);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(66688);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66688);
    return i;
  }
  
  public final int getType()
  {
    return 389;
  }
  
  public final int gxD()
  {
    AppMethodBeat.i(262778);
    int i = ((ebp)c.b.b(this.rr.otB)).abhg;
    AppMethodBeat.o(262778);
    return i;
  }
  
  public final String gxE()
  {
    AppMethodBeat.i(262780);
    String str = ((ebp)c.b.b(this.rr.otB)).MEX;
    AppMethodBeat.o(262780);
    return str;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66687);
    Log.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */