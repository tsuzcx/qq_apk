package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends b
{
  public dhw CiQ;
  private com.tencent.mm.ak.i callback;
  public int limit;
  private d rr;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67373);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dhv();
    ((d.a)localObject).iLO = new dhw();
    ((d.a)localObject).funcId = 1511;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dhv)this.rr.iLK.iLR;
    ((dhv)localObject).limit = paramInt1;
    ((dhv)localObject).offset = paramInt2;
    this.limit = paramInt1;
    Log.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(67373);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67375);
    Log.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiQ = ((dhw)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiQ.dDN), this.CiQ.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67375);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(67374);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67374);
    return i;
  }
  
  public final void e(s params)
  {
    params = (dhw)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1511;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.i
 * JD-Core Version:    0.7.0.1
 */