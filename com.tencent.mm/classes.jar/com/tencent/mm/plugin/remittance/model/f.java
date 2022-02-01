package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  public ra Cot;
  private i callback;
  private d hJu;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new qz();
    ((d.a)localObject).iLO = new ra();
    ((d.a)localObject).funcId = 1680;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hJu = ((d.a)localObject).aXF();
    localObject = (qz)this.hJu.iLK.iLR;
    ((qz)localObject).CpJ = paramString3;
    ((qz)localObject).KHM = paramString1;
    ((qz)localObject).KHN = paramString2;
    ((qz)localObject).KHQ = paramInt;
    ((qz)localObject).KXS = paramb;
    ((qz)localObject).KHO = paramString4;
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67841);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67842);
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Cot = ((ra)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Cot.pTZ), this.Cot.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */