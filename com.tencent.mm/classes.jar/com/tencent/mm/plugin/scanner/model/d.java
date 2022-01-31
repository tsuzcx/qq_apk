package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  private String cqx;
  private String kQd;
  public b rr;
  private int scene;
  
  public d(String paramString1, int paramInt, String paramString2)
  {
    this.cqx = paramString1;
    this.scene = paramInt;
    this.kQd = paramString2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(80834);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new lb();
    paramf.fsY = new lc();
    paramf.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramf.funcId = 1063;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    paramf = (lb)this.rr.fsV.fta;
    paramf.ProductID = this.cqx;
    paramf.Scene = this.scene;
    paramf.wyN = this.kQd;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(80834);
    return i;
  }
  
  public final int getType()
  {
    return 1063;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80836);
    ab.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80836);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(80835);
    paramq = (lb)((b)paramq).fsV.fta;
    if ((paramq.Scene < 0) || (paramq.ProductID == null) || (paramq.ProductID.length() <= 0))
    {
      ab.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = m.b.ftv;
      AppMethodBeat.o(80835);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(80835);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */