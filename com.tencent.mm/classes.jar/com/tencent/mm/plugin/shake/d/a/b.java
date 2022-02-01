package com.tencent.mm.plugin.shake.d.a;

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
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private String DiK;
  private i callback;
  public d rr;
  private int scene;
  
  public b(String paramString, int paramInt)
  {
    this.DiK = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28274);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new bvx();
    parami.iLO = new bvy();
    parami.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    parami.funcId = 552;
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    parami = (bvx)this.rr.iLK.iLR;
    parami.MbU = this.DiK;
    parami.Scene = this.scene;
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
    params = (bvx)((d)params).iLK.iLR;
    if ((params.Scene < 0) || (params.MbU == null) || (params.MbU.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(params.Scene) });
      params = q.b.iMr;
      AppMethodBeat.o(28275);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(28275);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */