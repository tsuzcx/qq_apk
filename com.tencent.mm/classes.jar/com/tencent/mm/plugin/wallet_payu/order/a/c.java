package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.cez;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.w;

public final class c
  extends w
{
  public cep BSn;
  private g callback;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72062);
    this.BSn = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cez();
    ((b.a)localObject).hvu = new cfa();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((b.a)localObject).funcId = 1520;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cez)this.rr.hvr.hvw;
    if (!bs.isNullOrNil(paramString)) {
      ((cez)localObject).vxU = paramString;
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
    ac.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (cfa)((b)paramq).hvs.hvw;
      this.BSn = paramString.Ftv;
      if (paramString.Ftv != null)
      {
        ac.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.Ftv.vxU);
        AppMethodBeat.o(72064);
        return;
      }
      ac.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
    }
    AppMethodBeat.o(72064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.c
 * JD-Core Version:    0.7.0.1
 */