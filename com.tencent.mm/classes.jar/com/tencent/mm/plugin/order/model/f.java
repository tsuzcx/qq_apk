package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class f
  extends w
{
  private h callback;
  private c rr;
  
  public f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(66683);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aof();
    ((c.a)localObject).otF = new aog();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/evaluateorder";
    ((c.a)localObject).funcId = 583;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aof)c.b.b(this.rr.otB);
    ((aof)localObject).ZvJ = paramString1;
    ((aof)localObject).oOI = paramString2;
    ((aof)localObject).OzH = paramInt;
    ((aof)localObject).Zbi = k.iis();
    AppMethodBeat.o(66683);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(66685);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66685);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66684);
    Log.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      c.c.b(((c)params).otC);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.f
 * JD-Core Version:    0.7.0.1
 */