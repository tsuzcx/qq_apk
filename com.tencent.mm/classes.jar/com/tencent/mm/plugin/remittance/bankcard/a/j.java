package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends b
{
  public String CiJ;
  public cqq CiR;
  private final String TAG;
  private i callback;
  public String remark;
  private d rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67376);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cqp();
    ((d.a)localObject).iLO = new cqq();
    ((d.a)localObject).funcId = 1590;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cqp)this.rr.iLK.iLR;
    ((cqp)localObject).Cjt = paramString1;
    ((cqp)localObject).Cjw = paramString2;
    this.CiJ = paramString1;
    this.remark = paramString2;
    AppMethodBeat.o(67376);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67378);
    Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiR = ((cqq)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiR.dDN), this.CiR.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67378);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67377);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67377);
    return i;
  }
  
  public final void e(s params)
  {
    params = (cqq)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.j
 * JD-Core Version:    0.7.0.1
 */