package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends b
{
  public drm IfM;
  private final String TAG;
  private i callback;
  private d rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(67382);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    d.a locala = new d.a();
    locala.lBU = new drl();
    locala.lBV = new drm();
    locala.funcId = 1579;
    locala.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((drl)d.b.b(this.rr.lBR)).Saj = paramString;
    Log.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[] { paramString });
    AppMethodBeat.o(67382);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67384);
    Log.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IfM = ((drm)d.c.b(((d)params).lBS));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67384);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67383);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67383);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(278044);
    params = (drm)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(278044);
  }
  
  public final int getType()
  {
    return 1579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.l
 * JD-Core Version:    0.7.0.1
 */