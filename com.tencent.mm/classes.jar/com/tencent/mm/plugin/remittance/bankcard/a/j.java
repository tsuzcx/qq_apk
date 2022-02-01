package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends b
{
  private final String TAG;
  private g callback;
  public String iAC;
  private com.tencent.mm.ak.b rr;
  public String wEi;
  public bwe wEq;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67376);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bwd();
    ((b.a)localObject).hvu = new bwe();
    ((b.a)localObject).funcId = 1590;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bwd)this.rr.hvr.hvw;
    ((bwd)localObject).wES = paramString1;
    ((bwd)localObject).wEV = paramString2;
    this.wEi = paramString1;
    this.iAC = paramString2;
    AppMethodBeat.o(67376);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67378);
    ac.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEq = ((bwe)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEq.dae), this.wEq.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67378);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67377);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67377);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (bwe)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.j
 * JD-Core Version:    0.7.0.1
 */