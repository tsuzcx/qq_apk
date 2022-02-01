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
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
  extends n
  implements k
{
  private g callback;
  private b gvE;
  private so wKx;
  public sp wKy;
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    b.a locala = new b.a();
    locala.hvt = new so();
    locala.hvu = new sp();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.wKx = ((so)this.gvE.hvr.hvw);
    this.wKx.DQs = paramString1;
    this.wKx.DQt = paramString2;
    this.wKx.uiK = paramInt1;
    this.wKx.wLo = paramString3;
    this.wKx.wLn = paramString4;
    this.wKx.channel = paramInt2;
    this.wKx.wJT = paramInt3;
    this.wKx.Emy = paramString5;
    this.wKx.Emz = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67869);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67869);
    return i;
  }
  
  public final int getType()
  {
    return 2773;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67870);
    ac.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKy = ((sp)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKy.dae), this.wKy.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.p
 * JD-Core Version:    0.7.0.1
 */