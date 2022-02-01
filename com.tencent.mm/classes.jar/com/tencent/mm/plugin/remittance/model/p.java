package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.ae;

public final class p
  extends n
  implements k
{
  private f callback;
  private b gRX;
  private ul ynW;
  public um ynX;
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    b.a locala = new b.a();
    locala.hQF = new ul();
    locala.hQG = new um();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.ynW = ((ul)this.gRX.hQD.hQJ);
    this.ynW.FOf = paramString1;
    this.ynW.FOg = paramString2;
    this.ynW.vxx = paramInt1;
    this.ynW.yoN = paramString3;
    this.ynW.yoM = paramString4;
    this.ynW.channel = paramInt2;
    this.ynW.yns = paramInt3;
    this.ynW.Gmg = paramString5;
    this.ynW.Gmh = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67869);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynX = ((um)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ynX.dmy), this.ynX.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.p
 * JD-Core Version:    0.7.0.1
 */