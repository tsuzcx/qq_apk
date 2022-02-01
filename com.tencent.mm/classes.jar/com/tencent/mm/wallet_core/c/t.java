package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

public final class t
  extends w
{
  private i callback;
  private d rr;
  
  public t(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(72794);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new das();
    ((d.a)localObject).iLO = new dat();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((d.a)localObject).funcId = 421;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).routeInfo = f.bpA(paramString2);
    this.rr = ((d.a)localObject).aXF();
    localObject = (das)this.rr.iLK.iLR;
    ((das)localObject).MFU = paramString1;
    ((das)localObject).Lcc = k.fQy();
    ((das)localObject).MFV = paramString3;
    if (!Util.isNullOrNil(paramString2)) {
      ((das)localObject).MFW = new b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((das)localObject).LbX = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((das)localObject).KCx = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((das)localObject).MFX = paramInt3;
    }
    AppMethodBeat.o(72794);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72795);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */