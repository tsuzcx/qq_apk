package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends b
{
  public rr CiK;
  private final String TAG;
  private i callback;
  private d rr;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67355);
    this.TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new rq();
    ((d.a)localObject).iLO = new rr();
    ((d.a)localObject).funcId = 1340;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (rq)this.rr.iLK.iLR;
    ((rq)localObject).KZa = paramString1;
    ((rq)localObject).CpP = paramString2;
    AppMethodBeat.o(67355);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67357);
    Log.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiK = ((rr)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiK.dDN), this.CiK.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67357);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67356);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67356);
    return i;
  }
  
  public final void e(s params)
  {
    params = (rr)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1340;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.c
 * JD-Core Version:    0.7.0.1
 */