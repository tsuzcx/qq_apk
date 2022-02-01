package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b gvE;
  public os wKe;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.mm.bw.b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new or();
    ((b.a)localObject).hvu = new os();
    ((b.a)localObject).funcId = 1680;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gvE = ((b.a)localObject).aAz();
    localObject = (or)this.gvE.hvr.hvw;
    ((or)localObject).wLu = paramString3;
    ((or)localObject).DQs = paramString1;
    ((or)localObject).DQt = paramString2;
    ((or)localObject).DQw = paramInt;
    ((or)localObject).EeD = paramb;
    ((or)localObject).DQu = paramString4;
    ac.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67841);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67842);
    ac.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKe = ((os)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKe.nWx), this.wKe.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */