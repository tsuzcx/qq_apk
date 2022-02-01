package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private g callback;
  private b gvE;
  private td wKw;
  
  public o(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67865);
    b.a locala = new b.a();
    locala.hvt = new td();
    locala.hvu = new te();
    locala.funcId = 1273;
    locala.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.wKw = ((td)this.gvE.hvr.hvw);
    this.wKw.DQs = paramString1;
    this.wKw.DQt = paramString2;
    this.wKw.Enm = paramString3;
    this.wKw.Enn = paramString4;
    this.wKw.uiK = paramInt;
    ac.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67865);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67866);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67866);
    return i;
  }
  
  public final int getType()
  {
    return 1273;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67867);
    ac.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.o
 * JD-Core Version:    0.7.0.1
 */