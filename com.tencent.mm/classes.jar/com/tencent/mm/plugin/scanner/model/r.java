package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends p
  implements m
{
  private h callback;
  private String productId;
  public c rr;
  private int scene;
  private String xbs;
  
  public r(String paramString1, int paramInt, String paramString2)
  {
    this.productId = paramString1;
    this.scene = paramInt;
    this.xbs = paramString2;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(51620);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new pq();
    paramh.otF = new pr();
    paramh.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramh.funcId = 1063;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    paramh = (pq)c.b.b(this.rr.otB);
    paramh.ProductID = this.productId;
    paramh.IJG = this.scene;
    paramh.YTb = this.xbs;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(51621);
    params = (pq)c.b.b(((c)params).otB);
    if ((params.IJG < 0) || (params.ProductID == null) || (params.ProductID.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(params.IJG) });
      params = p.b.oui;
      AppMethodBeat.o(51621);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(51621);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.r
 * JD-Core Version:    0.7.0.1
 */