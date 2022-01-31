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
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.cpg;

public final class h
  extends m
  implements k
{
  private f callback;
  private final String cwc;
  public final String qEF;
  public final int qEG;
  private final int scene;
  
  public h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.cwc = paramString1;
    this.qEF = paramString2;
    this.qEG = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(126855);
    this.callback = paramf;
    paramf = new b.a();
    ben localben = new ben();
    localben.cwc = this.cwc;
    localben.xtZ = this.qEF;
    localben.xua = this.qEG;
    paramf.fsX = localben;
    paramf.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramf.fsY = new beo();
    paramf.funcId = getType();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.ado(), this);
    AppMethodBeat.o(126855);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126854);
    paramString = (beo)((b)paramq).fsW.fta;
    this.callback.onSceneEnd(paramInt2, paramString.wPc.csV, paramString.wPc.csW, this);
    AppMethodBeat.o(126854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.h
 * JD-Core Version:    0.7.0.1
 */