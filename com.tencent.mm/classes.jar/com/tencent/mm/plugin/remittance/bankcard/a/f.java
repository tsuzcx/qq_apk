package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends b
{
  private final String TAG;
  private com.tencent.mm.ai.f callback;
  public String qfK;
  public ya qfO;
  private com.tencent.mm.ai.b rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(44455);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    b.a locala = new b.a();
    locala.fsX = new xz();
    locala.fsY = new ya();
    locala.funcId = 1395;
    locala.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((xz)this.rr.fsV.fta).qgu = paramString;
    this.qfK = paramString;
    AppMethodBeat.o(44455);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44457);
    ab.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfO = ((ya)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfO.cnK), this.qfO.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44457);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(44456);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44456);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (ya)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1395;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.f
 * JD-Core Version:    0.7.0.1
 */