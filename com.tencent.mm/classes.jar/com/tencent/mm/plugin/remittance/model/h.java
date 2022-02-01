package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends n
  implements k
{
  private g callback;
  private b gvE;
  public oy wKl;
  
  public h(dj paramdj, String paramString)
  {
    AppMethodBeat.i(67846);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ox();
    ((b.a)localObject).hvu = new oy();
    ((b.a)localObject).funcId = 1241;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gvE = ((b.a)localObject).aAz();
    localObject = (ox)this.gvE.hvr.hvw;
    ((ox)localObject).EeP = paramdj;
    ((ox)localObject).EeQ = paramString;
    ac.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { paramdj.DQs, paramdj.DQt, Integer.valueOf(paramdj.DQw), a.a(paramdj) });
    AppMethodBeat.o(67846);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67847);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67847);
    return i;
  }
  
  public final int getType()
  {
    return 1241;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67848);
    ac.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKl = ((oy)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKl.nWx), this.wKl.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */