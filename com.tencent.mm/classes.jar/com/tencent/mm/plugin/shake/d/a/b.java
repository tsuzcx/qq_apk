package com.tencent.mm.plugin.shake.d.a;

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
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private String Joq;
  private i callback;
  public d rr;
  private int scene;
  
  public b(String paramString, int paramInt)
  {
    this.Joq = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28274);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new cdp();
    parami.lBV = new cdq();
    parami.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    parami.funcId = 552;
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    parami = (cdp)d.b.b(this.rr.lBR);
    parami.Tlw = this.Joq;
    parami.CPw = this.scene;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28274);
    return i;
  }
  
  public final int getType()
  {
    return 552;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28276);
    Log.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28276);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(28275);
    params = (cdp)d.b.b(((d)params).lBR);
    if ((params.CPw < 0) || (params.Tlw == null) || (params.Tlw.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(params.CPw) });
      params = q.b.lCy;
      AppMethodBeat.o(28275);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(28275);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */