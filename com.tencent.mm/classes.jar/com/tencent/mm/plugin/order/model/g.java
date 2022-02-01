package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
{
  private i callback;
  private d rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66686);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new djf();
    ((d.a)localObject).lBV = new djg();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((d.a)localObject).funcId = 389;
    ((d.a)localObject).lBW = 187;
    ((d.a)localObject).respCmdId = 1000000187;
    this.rr = ((d.a)localObject).bgN();
    localObject = (djf)d.b.b(this.rr.lBR);
    ((djf)localObject).TQH = 1;
    if (!Util.isNullOrNil(paramString1)) {
      ((djf)localObject).GIh = paramString1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((djf)localObject).GIz = paramString2;
    }
    ((djf)localObject).Sdp = k.gJe();
    AppMethodBeat.o(66686);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(66688);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66688);
    return i;
  }
  
  public final int fmP()
  {
    AppMethodBeat.i(228295);
    int i = ((djf)d.b.b(this.rr.lBR)).TQH;
    AppMethodBeat.o(228295);
    return i;
  }
  
  public final String fmQ()
  {
    AppMethodBeat.i(228296);
    String str = ((djf)d.b.b(this.rr.lBR)).GIh;
    AppMethodBeat.o(228296);
    return str;
  }
  
  public final int getType()
  {
    return 389;
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