package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends n
  implements k
{
  int DJm;
  boolean DJn;
  private f gzH;
  private long pEL;
  private int pFB;
  private byte[] pFQ;
  private String pFS;
  private final com.tencent.mm.al.b rr;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.pFQ = null;
    this.DJm = -1;
    this.DJn = true;
    this.pEL = 0L;
    b.a locala = new b.a();
    locala.hNM = new cyf();
    locala.hNN = new cyg();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFB = paramInt1;
    this.pFS = paramString;
    this.pFQ = paramArrayOfByte;
    this.DJm = paramInt2;
    this.pEL = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77869);
    this.gzH = paramf;
    cyf localcyf = (cyf)this.rr.hNK.hNQ;
    if (!bt.cC(this.pFQ))
    {
      localcyf.Gxi = z.al(this.pFQ);
      this.DJn = false;
      localcyf.Gxl = this.pEL;
      if (localcyf.Gxi != null) {
        break label134;
      }
    }
    label134:
    for (paramf = "Buf is NULL";; paramf = localcyf.Gxi.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneSearchEmotion", paramf);
      localcyf.ReqType = this.pFB;
      localcyf.Gxj = this.pFS;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localcyf.Gxi = new SKBuiltinBuffer_t();
      this.DJn = true;
      break;
    }
  }
  
  public final cyg eNW()
  {
    if (this.rr == null) {
      return null;
    }
    return (cyg)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    ad.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */