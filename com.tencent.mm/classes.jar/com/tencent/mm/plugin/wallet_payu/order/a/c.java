package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class c
  extends w
{
  public daq ItB;
  private i callback;
  private d rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72062);
    this.ItB = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dba();
    ((d.a)localObject).iLO = new dbb();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((d.a)localObject).funcId = 1520;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dba)this.rr.iLK.iLR;
    if (!Util.isNullOrNil(paramString)) {
      ((dba)localObject).AOT = paramString;
    }
    AppMethodBeat.o(72062);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72063);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72063);
    return i;
  }
  
  public final int getType()
  {
    return 1520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72064);
    Log.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (dbb)((d)params).iLL.iLR;
      this.ItB = paramString.MGb;
      if (paramString.MGb != null)
      {
        Log.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.MGb.AOT);
        AppMethodBeat.o(72064);
        return;
      }
      Log.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
    }
    AppMethodBeat.o(72064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.c
 * JD-Core Version:    0.7.0.1
 */