package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a
{
  private final String TAG;
  public ddz vxm;
  
  public c(String paramString)
  {
    AppMethodBeat.i(67628);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage";
    b.a locala = new b.a();
    locala.gUU = new ddy();
    locala.gUV = new ddz();
    locala.funcId = 1275;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonedelhisrcvr";
    this.rr = locala.atI();
    ((ddy)this.rr.gUS.gUX).EvC = paramString;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitDeleteRecord rcvr_id:%s ", new Object[] { paramString });
    AppMethodBeat.o(67628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67629);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vxm = ((ddz)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxm.ntx), this.vxm.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67629);
  }
  
  public final void e(q paramq)
  {
    paramq = (ddz)((b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
  }
  
  public final int getType()
  {
    return 1275;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.c
 * JD-Core Version:    0.7.0.1
 */