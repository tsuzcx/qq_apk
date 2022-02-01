package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;

public final class c
  extends w
{
  public bzr AzR;
  private g callback;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72062);
    this.AzR = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cab();
    ((b.a)localObject).gUV = new cac();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((b.a)localObject).funcId = 1520;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cab)this.rr.gUS.gUX;
    if (!bt.isNullOrNil(paramString)) {
      ((cab)localObject).uoY = paramString;
    }
    AppMethodBeat.o(72062);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72063);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72063);
    return i;
  }
  
  public final int getType()
  {
    return 1520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72064);
    ad.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (cac)((b)paramq).gUT.gUX;
      this.AzR = paramString.DWD;
      if (paramString.DWD != null)
      {
        ad.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.DWD.uoY);
        AppMethodBeat.o(72064);
        return;
      }
      ad.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
    }
    AppMethodBeat.o(72064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.c
 * JD-Core Version:    0.7.0.1
 */