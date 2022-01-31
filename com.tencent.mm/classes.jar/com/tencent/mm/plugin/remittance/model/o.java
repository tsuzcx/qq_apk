package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends m
  implements k
{
  private f callback;
  private b goo;
  private pt qjr;
  public pu qjs;
  
  public o(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(44755);
    b.a locala = new b.a();
    locala.fsX = new pt();
    locala.fsY = new pu();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.qjr = ((pt)this.goo.fsV.fta);
    this.qjr.wpp = paramString1;
    this.qjr.wpq = paramString2;
    this.qjr.okH = paramInt1;
    this.qjr.qkh = paramString3;
    this.qjr.qkg = paramString4;
    this.qjr.cCy = paramInt2;
    this.qjr.qiP = paramInt3;
    this.qjr.wIb = paramString5;
    this.qjr.wIc = paramString6;
    AppMethodBeat.o(44755);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44756);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(44756);
    return i;
  }
  
  public final int getType()
  {
    return 2773;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44757);
    ab.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qjs = ((pu)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.qjs.cnK), this.qjs.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(44757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.o
 * JD-Core Version:    0.7.0.1
 */