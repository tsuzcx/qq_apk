package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  public rm CoF;
  private i callback;
  private d hJu;
  
  public k(du paramdu, String paramString)
  {
    AppMethodBeat.i(67857);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new rl();
    ((d.a)localObject).iLO = new rm();
    ((d.a)localObject).funcId = 2702;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hJu = ((d.a)localObject).aXF();
    localObject = (rl)this.hJu.iLK.iLR;
    ((rl)localObject).KYe = paramdu;
    ((rl)localObject).KYw = paramString;
    h.CyF.dN(886, 0);
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { paramdu.KHM, paramdu.KHN, Integer.valueOf(paramdu.KHQ) });
    AppMethodBeat.o(67857);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67858);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67858);
    return i;
  }
  
  public final int getType()
  {
    return 2702;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67859);
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.CoF = ((rm)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.CoF.pTZ), this.CoF.pUa });
    h.CyF.dN(886, 1);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */