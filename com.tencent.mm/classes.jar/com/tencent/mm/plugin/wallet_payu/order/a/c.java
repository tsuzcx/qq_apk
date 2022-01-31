package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class c
  extends u
{
  private f callback;
  private b rr;
  public blp uCL;
  
  public c(String paramString)
  {
    AppMethodBeat.i(48421);
    this.uCL = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new blz();
    ((b.a)localObject).fsY = new bma();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((b.a)localObject).funcId = 1520;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (blz)this.rr.fsV.fta;
    if (!bo.isNullOrNil(paramString)) {
      ((blz)localObject).ppY = paramString;
    }
    AppMethodBeat.o(48421);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48422);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48422);
    return i;
  }
  
  public final int getType()
  {
    return 1520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142600);
    ab.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (bma)((b)paramq).fsW.fta;
      this.uCL = paramString.xAu;
      if (paramString.xAu != null)
      {
        ab.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.xAu.ppY);
        AppMethodBeat.o(142600);
        return;
      }
      ab.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
    }
    AppMethodBeat.o(142600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.c
 * JD-Core Version:    0.7.0.1
 */