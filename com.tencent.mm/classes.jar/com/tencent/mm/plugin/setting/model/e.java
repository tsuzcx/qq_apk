package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.fup;

public final class e
  extends p
  implements m
{
  private boolean PnC;
  public final String appId;
  private h callback;
  private final int scene;
  
  public e(String paramString)
  {
    this(paramString, 1);
    this.PnC = true;
  }
  
  public e(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = 1;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73764);
    this.callback = paramh;
    paramh = new c.a();
    ajb localajb = new ajb();
    localajb.appid = this.appId;
    localajb.iaK = this.scene;
    localajb.ZqT = this.PnC;
    paramh.otE = localajb;
    paramh.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    paramh.otF = new ajc();
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    int i = dispatch(paramg, paramh.bEF(), this);
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
    params = (ajc)c.c.b(((c)params).otC);
    if (params.ZqU != null)
    {
      paramInt3 = params.ZqU.hGE;
      paramString = params.ZqU.errmsg;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(73765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */