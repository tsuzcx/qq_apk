package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.czs;
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
    ((d.a)localObject).iLN = new czr();
    ((d.a)localObject).iLO = new czs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((d.a)localObject).funcId = 389;
    ((d.a)localObject).iLP = 187;
    ((d.a)localObject).respCmdId = 1000000187;
    this.rr = ((d.a)localObject).aXF();
    localObject = (czr)this.rr.iLK.iLR;
    ((czr)localObject).MEV = 1;
    if (!Util.isNullOrNil(paramString1)) {
      ((czr)localObject).AOT = paramString1;
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((czr)localObject).APl = paramString2;
    }
    ((czr)localObject).Lcc = k.fQy();
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
  
  public final int eBi()
  {
    return ((czr)this.rr.iLK.iLR).MEV;
  }
  
  public final String eBj()
  {
    return ((czr)this.rr.iLK.iLR).AOT;
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