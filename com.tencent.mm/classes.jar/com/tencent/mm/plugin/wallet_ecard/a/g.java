package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  public dhb IpY;
  private i callback;
  private d rr;
  
  public g()
  {
    AppMethodBeat.i(71701);
    d.a locala = new d.a();
    locala.iLN = new dha();
    locala.iLO = new dhb();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dha)this.rr.iLK.iLR).MLx = 1L;
    AppMethodBeat.o(71701);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(71702);
    Log.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IpY = ((dhb)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IpY.pTZ), this.IpY.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(71702);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(71703);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71703);
    return i;
  }
  
  public final void e(s params)
  {
    params = (dhb)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
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