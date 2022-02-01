package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class n
  extends w
{
  public sq OiY;
  private com.tencent.mm.am.h callback;
  private c nao;
  
  public n(eh parameh, String paramString)
  {
    AppMethodBeat.i(67857);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new sp();
    ((c.a)localObject).otF = new sq();
    ((c.a)localObject).funcId = 2702;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.nao = ((c.a)localObject).bEF();
    localObject = (sp)c.b.b(this.nao.otB);
    ((sp)localObject).YXl = parameh;
    ((sp)localObject).YXE = paramString;
    com.tencent.mm.plugin.report.service.h.OAn.kJ(886, 0);
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { parameh.YGt, parameh.Oln, Integer.valueOf(parameh.YGv) });
    AppMethodBeat.o(67857);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(67858);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67858);
    return i;
  }
  
  public final int getType()
  {
    return 2702;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288827);
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.OiY = ((sq)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.OiY.wuz), this.OiY.wuA });
    com.tencent.mm.plugin.report.service.h.OAn.kJ(886, 1);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.n
 * JD-Core Version:    0.7.0.1
 */