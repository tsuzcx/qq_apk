package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends b
{
  private final String TAG;
  private f callback;
  public String oZN;
  private com.tencent.mm.al.b rr;
  public aed xRS;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67361);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    b.a locala = new b.a();
    locala.hNM = new aec();
    locala.hNN = new aed();
    locala.funcId = 1737;
    locala.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((aec)this.rr.hNK.hNQ).FMk = paramString;
    this.oZN = paramString;
    AppMethodBeat.o(67361);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67363);
    ad.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRS = ((aed)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRS.dlw), this.xRS.paA });
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
    paramq = (aed)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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