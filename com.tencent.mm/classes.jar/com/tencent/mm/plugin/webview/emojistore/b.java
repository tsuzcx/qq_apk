package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends n
  implements k
{
  int ANR;
  boolean ANS;
  private g gbr;
  private long oxB;
  private byte[] oyG;
  private String oyI;
  private int oyr;
  private final com.tencent.mm.al.b rr;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.oyG = null;
    this.ANR = -1;
    this.ANS = true;
    this.oxB = 0L;
    b.a locala = new b.a();
    locala.gUU = new cno();
    locala.gUV = new cnp();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyr = paramInt1;
    this.oyI = paramString;
    this.oyG = paramArrayOfByte;
    this.ANR = paramInt2;
    this.oxB = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(77869);
    this.gbr = paramg;
    cno localcno = (cno)this.rr.gUS.gUX;
    if (!bt.cw(this.oyG))
    {
      localcno.Dta = z.am(this.oyG);
      this.ANS = false;
      localcno.Dtd = this.oxB;
      if (localcno.Dta != null) {
        break label134;
      }
    }
    label134:
    for (paramg = "Buf is NULL";; paramg = localcno.Dta.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneSearchEmotion", paramg);
      localcno.ReqType = this.oyr;
      localcno.Dtb = this.oyI;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localcno.Dta = new SKBuiltinBuffer_t();
      this.ANS = true;
      break;
    }
  }
  
  public final cnp ejM()
  {
    if (this.rr == null) {
      return null;
    }
    return (cnp)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    ad.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */