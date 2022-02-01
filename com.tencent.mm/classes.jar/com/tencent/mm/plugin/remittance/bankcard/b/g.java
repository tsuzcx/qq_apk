package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends b
{
  public cey Ocg;
  private final String TAG;
  private h callback;
  public String md5;
  private c rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67367);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    c.a locala = new c.a();
    locala.otE = new cex();
    locala.otF = new cey();
    locala.funcId = 1542;
    locala.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cex)c.b.b(this.rr.otB)).Ziq = paramString1;
    this.md5 = paramString2;
    AppMethodBeat.o(67367);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67369);
    Log.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ocg = ((cey)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Ocg.hAV), this.Ocg.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67369);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(67368);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67368);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288700);
    params = (cey)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288700);
  }
  
  public final int getType()
  {
    return 1542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.g
 * JD-Core Version:    0.7.0.1
 */