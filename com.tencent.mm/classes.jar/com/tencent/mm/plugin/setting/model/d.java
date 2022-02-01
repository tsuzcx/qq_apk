package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.eyw;

public final class d
  extends q
  implements m
{
  public final String appId;
  private i callback;
  private final int scene;
  
  public d(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73764);
    this.callback = parami;
    parami = new d.a();
    agm localagm = new agm();
    localagm.appid = this.appId;
    localagm.fUN = this.scene;
    parami.lBU = localagm;
    parami.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    parami.lBV = new agn();
    parami.funcId = getType();
    parami.lBW = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.bgN(), this);
    AppMethodBeat.o(73764);
    return i;
  }
  
  public final int getType()
  {
    return 1127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73765);
    paramString = (agn)d.c.b(((com.tencent.mm.an.d)params).lBS);
    this.callback.onSceneEnd(paramInt2, paramString.SrP.fBP, paramString.SrP.errmsg, this);
    AppMethodBeat.o(73765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */