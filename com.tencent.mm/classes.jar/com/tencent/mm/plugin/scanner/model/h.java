package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends m
  implements k
{
  private f callback;
  private int cnU;
  private int eBd = 1;
  private int fsd;
  private int offset;
  private byte[] qum;
  public b rr;
  
  public h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.qum = paramArrayOfByte;
    this.eBd = 1;
    this.fsd = paramInt1;
    this.offset = 0;
    this.cnU = paramInt2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(80847);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new lm();
    paramf.fsY = new ln();
    paramf.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
    paramf.funcId = 1062;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    paramf = (lm)this.rr.fsV.fta;
    paramf.wzP = ((int)bo.aoy() & 0x7FFFFFFF);
    paramf.wzQ = new SKBuiltinBuffer_t().setBuffer(this.qum);
    paramf.wzR = this.fsd;
    paramf.wzS = this.offset;
    if (this.offset + this.qum.length < this.fsd) {}
    for (paramf.fKi = 0;; paramf.fKi = 1)
    {
      paramf.wzT = this.eBd;
      paramf.wzU = this.cnU;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(80847);
      return i;
    }
  }
  
  public final int getType()
  {
    return 1062;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80849);
    ab.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80849);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(80848);
    paramq = (lm)((b)paramq).fsV.fta;
    if ((paramq.wzP <= 0) || (paramq.wzT < 0) || (paramq.wzQ == null) || (paramq.wzQ.getILen() <= 0) || (paramq.wzR <= 0) || (paramq.wzS < 0) || (paramq.wzS + paramq.wzQ.getILen() > paramq.wzR))
    {
      ab.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", new Object[] { Integer.valueOf(paramq.wzT), Integer.valueOf(paramq.wzR), Integer.valueOf(paramq.wzS) });
      if (paramq.wzQ != null) {
        ab.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", new Object[] { Integer.valueOf(paramq.wzQ.getILen()) });
      }
      paramq = m.b.ftv;
      AppMethodBeat.o(80848);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(80848);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */