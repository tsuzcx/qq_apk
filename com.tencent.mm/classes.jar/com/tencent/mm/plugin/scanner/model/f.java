package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private int cnU;
  private int eBd = 1;
  private byte[] qum;
  private String qun = "en";
  private String quo = "zh_CN";
  public b rr;
  
  public f(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt)
  {
    this.qum = paramArrayOfByte;
    this.eBd = 1;
    this.qun = paramString1;
    this.quo = paramString2;
    this.cnU = paramInt;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(80840);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new bgm();
    paramf.fsY = new bgn();
    paramf.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
    paramf.funcId = 392;
    paramf.reqCmdId = 199;
    paramf.respCmdId = 1000000199;
    this.rr = paramf.ado();
    paramf = (bgm)this.rr.fsV.fta;
    paramf.wzP = ((int)bo.aoy() & 0x7FFFFFFF);
    paramf.wzQ = new SKBuiltinBuffer_t().setBuffer(this.qum);
    paramf.wzT = this.eBd;
    paramf.xvM = this.qun;
    paramf.xvN = this.quo;
    paramf.wzU = this.cnU;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(80840);
    return i;
  }
  
  public final int getType()
  {
    return 392;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80842);
    ab.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80842);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(80841);
    paramq = (bgm)((b)paramq).fsV.fta;
    if ((paramq.wzP <= 0) || (bo.isNullOrNil(paramq.xvN)) || (bo.isNullOrNil(paramq.xvM)) || (paramq.wzT < 0) || (paramq.wzQ == null) || (paramq.wzQ.getILen() <= 0))
    {
      ab.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
      paramq = m.b.ftv;
      AppMethodBeat.o(80841);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(80841);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.f
 * JD-Core Version:    0.7.0.1
 */