package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private axd Dgu;
  public axe Dgv;
  private f callback;
  private b gRX;
  public long vlr;
  
  public m(String paramString, long paramLong)
  {
    AppMethodBeat.i(69914);
    b.a locala = new b.a();
    locala.hQF = new axd();
    locala.hQG = new axe();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.funcId = 2948;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.Dgu = ((axd)this.gRX.hQD.hQJ);
    this.Dgu.GOA = paramString;
    this.vlr = paramLong;
    ae.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(69914);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69915);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(69915);
    return i;
  }
  
  public final int getType()
  {
    return 2948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69916);
    ae.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Dgv = ((axe)((b)paramq).hQE.hQJ);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ae.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.Dgv.oGt), this.Dgv.oGu, Integer.valueOf(this.Dgv.GOB), this.Dgv.GOC, this.Dgv.GOD });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */