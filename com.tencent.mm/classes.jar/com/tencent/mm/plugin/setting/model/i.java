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
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.cpg;

public final class i
  extends m
  implements k
{
  private f callback;
  private String cnv;
  public byte[] qEE;
  public bye qEH;
  
  public i(String paramString)
  {
    this.cnv = paramString;
  }
  
  public i(byte[] paramArrayOfByte)
  {
    this.qEE = paramArrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(126856);
    this.callback = paramf;
    paramf = new b.a();
    byd localbyd = new byd();
    localbyd.cnv = this.cnv;
    if (this.qEE != null) {
      localbyd.xgp = aa.ac(this.qEE).getBuffer();
    }
    paramf.fsX = localbyd;
    paramf.fsY = new bye();
    paramf.funcId = getType();
    paramf.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.ado(), this);
    AppMethodBeat.o(126856);
    return i;
  }
  
  public final int getType()
  {
    return 1169;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126857);
    this.qEH = ((bye)((b)paramq).fsW.fta);
    if (this.qEH.wPc != null)
    {
      paramInt3 = this.qEH.wPc.csV;
      paramString = this.qEH.wPc.csW;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */