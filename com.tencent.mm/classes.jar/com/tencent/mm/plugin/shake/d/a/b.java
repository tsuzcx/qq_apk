package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  private String qOR;
  public com.tencent.mm.ai.b rr;
  private int scene;
  
  public b(String paramString, int paramInt)
  {
    this.qOR = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24604);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new aql();
    paramf.fsY = new aqm();
    paramf.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramf.funcId = 552;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    paramf = (aql)this.rr.fsV.fta;
    paramf.xfU = this.qOR;
    paramf.Scene = this.scene;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24604);
    return i;
  }
  
  public final int getType()
  {
    return 552;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24606);
    ab.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24606);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(24605);
    paramq = (aql)((com.tencent.mm.ai.b)paramq).fsV.fta;
    if ((paramq.Scene < 0) || (paramq.xfU == null) || (paramq.xfU.length() <= 0))
    {
      ab.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = m.b.ftv;
      AppMethodBeat.o(24605);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(24605);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */