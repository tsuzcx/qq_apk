package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b gvE;
  public pe wKq;
  
  public k(dj paramdj, String paramString)
  {
    AppMethodBeat.i(67857);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new pd();
    ((b.a)localObject).hvu = new pe();
    ((b.a)localObject).funcId = 2702;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gvE = ((b.a)localObject).aAz();
    localObject = (pd)this.gvE.hvr.hvw;
    ((pd)localObject).EeP = paramdj;
    ((pd)localObject).Efh = paramString;
    h.wUl.dB(886, 0);
    ac.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { paramdj.DQs, paramdj.DQt, Integer.valueOf(paramdj.DQw) });
    AppMethodBeat.o(67857);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67858);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67858);
    return i;
  }
  
  public final int getType()
  {
    return 2702;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67859);
    ac.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKq = ((pe)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKq.nWx), this.wKq.nWy });
    h.wUl.dB(886, 1);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */