package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.eyw;

public final class k
  extends q
  implements m
{
  public final String Jdu;
  public final int Jdv;
  private final String appid;
  private i callback;
  private final int scene;
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.appid = paramString1;
    this.Jdu = paramString2;
    this.Jdv = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73777);
    this.callback = parami;
    parami = new d.a();
    cza localcza = new cza();
    localcza.appid = this.appid;
    localcza.TGV = this.Jdu;
    localcza.TGW = this.Jdv;
    parami.lBU = localcza;
    parami.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    parami.lBV = new czb();
    parami.funcId = getType();
    parami.lBW = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.bgN(), this);
    AppMethodBeat.o(73777);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73776);
    paramString = (czb)d.c.b(((d)params).lBS);
    this.callback.onSceneEnd(paramInt2, paramString.SrP.fBP, paramString.SrP.errmsg, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */