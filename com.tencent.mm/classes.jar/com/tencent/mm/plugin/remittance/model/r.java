package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends p
  implements m
{
  private yb Oje;
  private h callback;
  private c nao;
  
  public r(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67865);
    c.a locala = new c.a();
    locala.otE = new yb();
    locala.otF = new yc();
    locala.funcId = 1273;
    locala.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.Oje = ((yb)c.b.b(this.nao.otB));
    this.Oje.YGt = paramString1;
    this.Oje.Oln = paramString2;
    this.Oje.ZgS = paramString3;
    this.Oje.ZgT = paramString4;
    this.Oje.amount = paramInt;
    Log.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67865);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67866);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67866);
    return i;
  }
  
  public final int getType()
  {
    return 1273;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67867);
    Log.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.r
 * JD-Core Version:    0.7.0.1
 */