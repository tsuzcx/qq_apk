package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends b
{
  public biy CiO;
  private final String TAG;
  private i callback;
  public String md5;
  private d rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67367);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    d.a locala = new d.a();
    locala.iLN = new bix();
    locala.iLO = new biy();
    locala.funcId = 1542;
    locala.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bix)this.rr.iLK.iLR).LiQ = paramString1;
    this.md5 = paramString2;
    AppMethodBeat.o(67367);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67369);
    Log.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiO = ((biy)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiO.dDN), this.CiO.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67369);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(67368);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67368);
    return i;
  }
  
  public final void e(s params)
  {
    params = (biy)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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