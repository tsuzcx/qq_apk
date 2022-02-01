package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.fup;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  public final String PnJ;
  public final int PnK;
  private final String appid;
  private h callback;
  private final int scene;
  
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.appid = paramString1;
    this.PnJ = paramString2;
    this.PnK = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73777);
    this.callback = paramh;
    paramh = new c.a();
    dqh localdqh = new dqh();
    localdqh.appid = this.appid;
    localdqh.aaWD = this.PnJ;
    localdqh.aaWE = this.PnK;
    paramh.otE = localdqh;
    paramh.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramh.otF = new dqi();
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    int i = dispatch(paramg, paramh.bEF(), this);
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
    paramString = (dqi)c.c.b(((c)params).otC);
    this.callback.onSceneEnd(paramInt2, paramString.ZqU.hGE, paramString.ZqU.errmsg, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.m
 * JD-Core Version:    0.7.0.1
 */