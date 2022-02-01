package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends b
{
  private final String TAG;
  private f callback;
  public String md5;
  private com.tencent.mm.al.b rr;
  public awy xRU;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67367);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    b.a locala = new b.a();
    locala.hNM = new awx();
    locala.hNN = new awy();
    locala.funcId = 1542;
    locala.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((awx)this.rr.hNK.hNQ).FVE = paramString1;
    this.md5 = paramString2;
    AppMethodBeat.o(67367);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67369);
    ad.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRU = ((awy)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRU.dlw), this.xRU.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67369);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67368);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67368);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (awy)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.g
 * JD-Core Version:    0.7.0.1
 */