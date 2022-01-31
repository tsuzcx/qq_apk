package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends m
  implements k
{
  private f callback;
  private b goo;
  public String sWB;
  private bpy ubH;
  public bpz ubI;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46518);
    b.a locala = new b.a();
    locala.fsX = new bpy();
    locala.fsY = new bpz();
    locala.funcId = 2710;
    locala.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.ubH = ((bpy)this.goo.fsV.fta);
    this.ubH.urI = paramString1;
    this.sWB = paramString2;
    ab.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(46518);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46519);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(46519);
    return i;
  }
  
  public final int getType()
  {
    return 2710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46520);
    ab.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ubI = ((bpz)((b)paramq).fsW.fta);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ab.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ubI.koj), this.ubI.kok });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(46520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */