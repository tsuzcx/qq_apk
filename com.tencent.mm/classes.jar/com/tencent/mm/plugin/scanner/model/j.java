package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  private i callback;
  private String productId;
  public d rr;
  private int scene;
  private String tXZ;
  
  public j(String paramString1, int paramInt, String paramString2)
  {
    this.productId = paramString1;
    this.scene = paramInt;
    this.tXZ = paramString2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(51620);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new oh();
    parami.lBV = new oi();
    parami.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    parami.funcId = 1063;
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    parami = (oh)d.b.b(this.rr.lBR);
    parami.ProductID = this.productId;
    parami.CPw = this.scene;
    parami.RVx = this.tXZ;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(51620);
    return i;
  }
  
  public final int getType()
  {
    return 1063;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51622);
    Log.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51622);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(51621);
    params = (oh)d.b.b(((d)params).lBR);
    if ((params.CPw < 0) || (params.ProductID == null) || (params.ProductID.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(params.CPw) });
      params = q.b.lCy;
      AppMethodBeat.o(51621);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(51621);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.j
 * JD-Core Version:    0.7.0.1
 */