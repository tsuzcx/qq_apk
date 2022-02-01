package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

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
    ((d.a)localObject).lBU = new dkg();
    ((d.a)localObject).lBV = new dkh();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((d.a)localObject).funcId = 421;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.g.bCx(paramString2);
    this.rr = ((d.a)localObject).bgN();
    localObject = (dkg)d.b.b(this.rr.lBR);
    ((dkg)localObject).TRG = paramString1;
    ((dkg)localObject).Sdp = k.gJe();
    ((dkg)localObject).TRH = paramString3;
    if (!Util.isNullOrNil(paramString2)) {
      ((dkg)localObject).TRI = new b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((dkg)localObject).Sdk = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((dkg)localObject).RML = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((dkg)localObject).TRJ = paramInt3;
    }
    AppMethodBeat.o(72794);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */