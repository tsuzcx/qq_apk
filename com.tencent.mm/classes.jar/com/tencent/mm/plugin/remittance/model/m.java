package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public rf IlH;
  private i callback;
  private d kwO;
  
  public m(ds paramds, String paramString)
  {
    AppMethodBeat.i(67857);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new re();
    ((d.a)localObject).lBV = new rf();
    ((d.a)localObject).funcId = 2702;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.kwO = ((d.a)localObject).bgN();
    localObject = (re)d.b.b(this.kwO.lBR);
    ((re)localObject).RZn = paramds;
    ((re)localObject).RZF = paramString;
    h.IzE.el(886, 0);
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { paramds.RJf, paramds.InV, Integer.valueOf(paramds.RJi) });
    AppMethodBeat.o(67857);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67858);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.IlH = ((rf)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IlH.tqa), this.IlH.tqb });
    h.IzE.el(886, 1);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */