package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.cpg;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public arc qED;
  public byte[] qEE;
  
  public f(byte[] paramArrayOfByte)
  {
    this.qEE = paramArrayOfByte;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(126849);
    this.callback = paramf;
    paramf = new b.a();
    arb localarb = new arb();
    if (this.qEE != null) {
      localarb.xgp = aa.ac(this.qEE).getBuffer();
    }
    paramf.fsX = localarb;
    this.qED = new arc();
    paramf.fsY = this.qED;
    paramf.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramf.funcId = getType();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.ado(), this);
    AppMethodBeat.o(126849);
    return i;
  }
  
  public final int getType()
  {
    return 1146;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126850);
    this.qED = ((arc)((b)paramq).fsW.fta);
    if (this.qED.wPc != null)
    {
      paramInt3 = this.qED.wPc.csV;
      paramString = this.qED.wPc.csW;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */