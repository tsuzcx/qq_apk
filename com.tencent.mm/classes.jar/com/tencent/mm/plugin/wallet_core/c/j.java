package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  public String COJ;
  public boolean COK;
  private f callback;
  private com.tencent.mm.al.b rr;
  
  public j()
  {
    AppMethodBeat.i(69908);
    this.COJ = "";
    this.COK = false;
    b.a locala = new b.a();
    locala.hNM = new bfy();
    locala.hNN = new bfz();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(69908);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69909);
    this.callback = paramf;
    com.tencent.mm.plugin.u.a.b.dyr();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69909);
    return i;
  }
  
  public final int getType()
  {
    return 2541;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69910);
    ad.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69910);
      return;
    }
    paramq = (bfz)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.COJ = paramq.COJ;
    this.COK = paramq.COK;
    ad.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.COJ, Boolean.valueOf(this.COK) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */