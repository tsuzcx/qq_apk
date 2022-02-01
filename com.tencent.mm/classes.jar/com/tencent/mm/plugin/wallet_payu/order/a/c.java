package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.protobuf.ecz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;

public final class c
  extends w
{
  public eco Wdx;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72062);
    this.Wdx = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ecy();
    ((c.a)localObject).otF = new ecz();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((c.a)localObject).funcId = 1520;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ecy)c.b.b(this.rr.otB);
    if (!Util.isNullOrNil(paramString)) {
      ((ecy)localObject).MEX = paramString;
    }
    AppMethodBeat.o(72062);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72063);
    this.callback = paramh;
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
      paramString = (ecz)c.c.b(((com.tencent.mm.am.c)params).otC);
      this.Wdx = paramString.abin;
      if (paramString.abin != null)
      {
        Log.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.abin.MEX);
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