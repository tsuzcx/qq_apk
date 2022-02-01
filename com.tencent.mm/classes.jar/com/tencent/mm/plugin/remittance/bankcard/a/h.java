package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  public axa xRV;
  
  public h()
  {
    AppMethodBeat.i(67370);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    b.a locala = new b.a();
    locala.hNM = new awz();
    locala.hNN = new axa();
    locala.funcId = 1399;
    locala.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(67370);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67372);
    ad.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRV = ((axa)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRV.dlw), this.xRV.paA });
    if ((!this.pbG) && (this.xRV.dlw != 0)) {
      this.pbH = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67372);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67371);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67371);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (axa)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1399;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.h
 * JD-Core Version:    0.7.0.1
 */