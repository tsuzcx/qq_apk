package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;

public final class c
  extends w
{
  public cjo DsG;
  private f callback;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72062);
    this.DsG = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cjy();
    ((b.a)localObject).hNN = new cjz();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((b.a)localObject).funcId = 1520;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cjy)this.rr.hNK.hNQ;
    if (!bt.isNullOrNil(paramString)) {
      ((cjy)localObject).wDo = paramString;
    }
    AppMethodBeat.o(72062);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72063);
    this.callback = paramf;
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
      paramString = (cjz)((b)paramq).hNL.hNQ;
      this.DsG = paramString.HdB;
      if (paramString.HdB != null)
      {
        ad.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.HdB.wDo);
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