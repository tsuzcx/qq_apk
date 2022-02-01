package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbu;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends n
  implements k
{
  public String Bou;
  public boolean Bov;
  private g callback;
  private b rr;
  
  public j()
  {
    AppMethodBeat.i(69908);
    this.Bou = "";
    this.Bov = false;
    b.a locala = new b.a();
    locala.hvt = new bbu();
    locala.hvu = new bbv();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(69908);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69909);
    this.callback = paramg;
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
    ac.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69910);
      return;
    }
    paramq = (bbv)((b)paramq).hvs.hvw;
    this.Bou = paramq.Bou;
    this.Bov = paramq.Bov;
    ac.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.Bou, Boolean.valueOf(this.Bov) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */