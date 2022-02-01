package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  public qz IlC;
  private i callback;
  private d kwO;
  
  public j(ds paramds, String paramString)
  {
    AppMethodBeat.i(67846);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new qy();
    ((d.a)localObject).lBV = new qz();
    ((d.a)localObject).funcId = 1241;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.kwO = ((d.a)localObject).bgN();
    localObject = (qy)d.b.b(this.kwO.lBR);
    ((qy)localObject).RZn = paramds;
    ((qy)localObject).RZo = paramString;
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { paramds.RJf, paramds.InV, Integer.valueOf(paramds.RJi), a.a(paramds) });
    AppMethodBeat.o(67846);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67847);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.IlC = ((qz)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IlC.tqa), this.IlC.tqb });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.j
 * JD-Core Version:    0.7.0.1
 */