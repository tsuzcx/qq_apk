package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class i
  extends w
{
  public cym VxA;
  private h callback;
  private final c rr;
  
  public i()
  {
    AppMethodBeat.i(301119);
    c.a locala = new c.a();
    cyl localcyl = new cyl();
    localcyl.timestamp = cn.bDv();
    locala.otE = localcyl;
    locala.otF = new cym();
    locala.funcId = 6855;
    locala.uri = "/cgi-bin/mmpay-bin/hkpayplugin";
    this.rr = locala.bEF();
    AppMethodBeat.o(301119);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(301122);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(301122);
    return i;
  }
  
  public final int getType()
  {
    return 6855;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(301124);
    Log.w("MicroMsg.NetSceneGetPayHKPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.VxA = ((cym)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(301124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */