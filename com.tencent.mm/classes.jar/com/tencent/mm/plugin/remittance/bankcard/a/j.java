package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends b
{
  private final String TAG;
  private f callback;
  public String iTM;
  private com.tencent.mm.al.b rr;
  public String xRP;
  public cau xRX;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67376);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cat();
    ((b.a)localObject).hNN = new cau();
    ((b.a)localObject).funcId = 1590;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cat)this.rr.hNK.hNQ;
    ((cat)localObject).xSz = paramString1;
    ((cat)localObject).xSC = paramString2;
    this.xRP = paramString1;
    this.iTM = paramString2;
    AppMethodBeat.o(67376);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67378);
    ad.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRX = ((cau)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRX.dlw), this.xRX.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67378);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67377);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67377);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cau)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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