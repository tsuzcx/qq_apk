package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private String PBo;
  private h callback;
  public com.tencent.mm.am.c rr;
  private int scene;
  
  public c(String paramString, int paramInt)
  {
    this.PBo = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28274);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new ctf();
    paramh.otF = new ctg();
    paramh.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramh.funcId = 552;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    paramh = (ctf)c.b.b(this.rr.otB);
    paramh.aazg = this.PBo;
    paramh.IJG = this.scene;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(28275);
    params = (ctf)c.b.b(((com.tencent.mm.am.c)params).otB);
    if ((params.IJG < 0) || (params.aazg == null) || (params.aazg.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(params.IJG) });
      params = p.b.oui;
      AppMethodBeat.o(28275);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(28275);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */