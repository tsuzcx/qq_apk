package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private i callback;
  private String productId;
  private String qyZ;
  public d rr;
  private int scene;
  
  public l(String paramString1, int paramInt, String paramString2)
  {
    this.productId = paramString1;
    this.scene = paramInt;
    this.qyZ = paramString2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(51620);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new on();
    parami.iLO = new oo();
    parami.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    parami.funcId = 1063;
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    parami = (on)this.rr.iLK.iLR;
    parami.ProductID = this.productId;
    parami.Scene = this.scene;
    parami.KUs = this.qyZ;
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
    params = (on)((d)params).iLK.iLR;
    if ((params.Scene < 0) || (params.ProductID == null) || (params.ProductID.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(params.Scene) });
      params = q.b.iMr;
      AppMethodBeat.o(51621);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(51621);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.l
 * JD-Core Version:    0.7.0.1
 */