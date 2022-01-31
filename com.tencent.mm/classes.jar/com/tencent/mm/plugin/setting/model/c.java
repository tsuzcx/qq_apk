package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.protocal.protobuf.xm;

public final class c
  extends m
  implements k
{
  public final String appId;
  private f callback;
  private final int scene;
  
  public c(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(126842);
    this.callback = paramf;
    paramf = new b.a();
    xl localxl = new xl();
    localxl.cwc = this.appId;
    localxl.cHp = this.scene;
    paramf.fsX = localxl;
    paramf.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    paramf.fsY = new xm();
    paramf.funcId = getType();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.ado(), this);
    AppMethodBeat.o(126842);
    return i;
  }
  
  public final int getType()
  {
    return 1127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126843);
    paramString = (xm)((b)paramq).fsW.fta;
    this.callback.onSceneEnd(paramInt2, paramString.wPc.csV, paramString.wPc.csW, this);
    AppMethodBeat.o(126843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.c
 * JD-Core Version:    0.7.0.1
 */