package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class k
  extends w
{
  public sk Oiz;
  private h callback;
  private c nao;
  
  public k(eh parameh, String paramString)
  {
    AppMethodBeat.i(67846);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new sj();
    ((c.a)localObject).otF = new sk();
    ((c.a)localObject).funcId = 1241;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.nao = ((c.a)localObject).bEF();
    localObject = (sj)c.b.b(this.nao.otB);
    ((sj)localObject).YXl = parameh;
    ((sj)localObject).YXm = paramString;
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { parameh.YGt, parameh.Oln, Integer.valueOf(parameh.YGv), b.a(parameh) });
    AppMethodBeat.o(67846);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67847);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67847);
    return i;
  }
  
  public final int getType()
  {
    return 1241;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288819);
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Oiz = ((sk)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Oiz.wuz), this.Oiz.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */