package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends m
  implements k
{
  private f eGj;
  private long lhz;
  private byte[] liD;
  private String liF;
  private int lio;
  private final com.tencent.mm.ai.b rr;
  int uOn;
  boolean uOo;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5658);
    this.liD = null;
    this.uOn = -1;
    this.uOo = true;
    this.lhz = 0L;
    b.a locala = new b.a();
    locala.fsX = new bxk();
    locala.fsY = new bxl();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lio = paramInt1;
    this.liF = paramString;
    this.liD = paramArrayOfByte;
    this.uOn = paramInt2;
    this.lhz = paramLong;
    AppMethodBeat.o(5658);
  }
  
  public final bxl dax()
  {
    if (this.rr == null) {
      return null;
    }
    return (bxl)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5659);
    this.eGj = paramf;
    bxk localbxk = (bxk)this.rr.fsV.fta;
    if (!bo.ce(this.liD))
    {
      localbxk.xaZ = aa.ac(this.liD);
      this.uOo = false;
      localbxk.xbc = this.lhz;
      if (localbxk.xaZ != null) {
        break label136;
      }
    }
    label136:
    for (paramf = "Buf is NULL";; paramf = localbxk.xaZ.toString())
    {
      ab.d("MicroMsg.emoji.NetSceneSearchEmotion", paramf);
      localbxk.ReqType = this.lio;
      localbxk.xba = this.liF;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(5659);
      return i;
      localbxk.xaZ = new SKBuiltinBuffer_t();
      this.uOo = true;
      break;
    }
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5660);
    ab.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.b
 * JD-Core Version:    0.7.0.1
 */