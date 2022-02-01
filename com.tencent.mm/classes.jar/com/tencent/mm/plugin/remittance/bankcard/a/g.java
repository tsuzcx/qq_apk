package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends b
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  public String md5;
  private com.tencent.mm.ak.b rr;
  public ata wEn;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67367);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    b.a locala = new b.a();
    locala.hvt = new asz();
    locala.hvu = new ata();
    locala.funcId = 1542;
    locala.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((asz)this.rr.hvr.hvw).Eos = paramString1;
    this.md5 = paramString2;
    AppMethodBeat.o(67367);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67369);
    ac.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEn = ((ata)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEn.dae), this.wEn.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67369);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(67368);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67368);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (ata)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.g
 * JD-Core Version:    0.7.0.1
 */