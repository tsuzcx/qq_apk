package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  public qo xRQ;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67355);
    this.TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new qn();
    ((b.a)localObject).hNN = new qo();
    ((b.a)localObject).funcId = 1340;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (qn)this.rr.hNK.hNQ;
    ((qn)localObject).FMk = paramString1;
    ((qn)localObject).xZh = paramString2;
    AppMethodBeat.o(67355);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67357);
    ad.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRQ = ((qo)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRQ.dlw), this.xRQ.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67357);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67356);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67356);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (qo)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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