package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends b
{
  private final String TAG;
  private f callback;
  public String pgr;
  private com.tencent.mm.ak.b rr;
  public aem yhL;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67361);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    b.a locala = new b.a();
    locala.hQF = new ael();
    locala.hQG = new aem();
    locala.funcId = 1737;
    locala.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((ael)this.rr.hQD.hQJ).GeJ = paramString;
    this.pgr = paramString;
    AppMethodBeat.o(67361);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67363);
    ae.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhL = ((aem)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhL.dmy), this.yhL.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67363);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67362);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67362);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (aem)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1737;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.e
 * JD-Core Version:    0.7.0.1
 */