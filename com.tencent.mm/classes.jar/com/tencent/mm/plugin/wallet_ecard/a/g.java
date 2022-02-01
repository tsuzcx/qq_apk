package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  public coi Dpg;
  private f callback;
  private b rr;
  
  public g()
  {
    AppMethodBeat.i(71701);
    b.a locala = new b.a();
    locala.hNM = new coh();
    locala.hNN = new coi();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((coh)this.rr.hNK.hNQ).Hhm = 1L;
    AppMethodBeat.o(71701);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71702);
    ad.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Dpg = ((coi)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Dpg.ozR), this.Dpg.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(71702);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71703);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71703);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (coi)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
  }
  
  public final int getType()
  {
    return 2931;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.g
 * JD-Core Version:    0.7.0.1
 */