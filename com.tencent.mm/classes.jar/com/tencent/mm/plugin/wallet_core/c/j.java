package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  public String Dgo;
  public boolean Dgp;
  private f callback;
  private b rr;
  
  public j()
  {
    AppMethodBeat.i(69908);
    this.Dgo = "";
    this.Dgp = false;
    b.a locala = new b.a();
    locala.hQF = new bgo();
    locala.hQG = new bgp();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(69908);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69909);
    this.callback = paramf;
    c.dBH();
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
    ae.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69910);
      return;
    }
    paramq = (bgp)((b)paramq).hQE.hQJ;
    this.Dgo = paramq.Dgo;
    this.Dgp = paramq.Dgp;
    ae.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.Dgo, Boolean.valueOf(this.Dgp) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */