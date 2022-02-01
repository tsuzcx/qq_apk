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
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  public rg CoA;
  private i callback;
  private d hJu;
  
  public h(du paramdu, String paramString)
  {
    AppMethodBeat.i(67846);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new rf();
    ((d.a)localObject).iLO = new rg();
    ((d.a)localObject).funcId = 1241;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hJu = ((d.a)localObject).aXF();
    localObject = (rf)this.hJu.iLK.iLR;
    ((rf)localObject).KYe = paramdu;
    ((rf)localObject).KYf = paramString;
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { paramdu.KHM, paramdu.KHN, Integer.valueOf(paramdu.KHQ), a.a(paramdu) });
    AppMethodBeat.o(67846);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67847);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67847);
    return i;
  }
  
  public final int getType()
  {
    return 1241;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67848);
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.CoA = ((rg)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.CoA.pTZ), this.CoA.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */