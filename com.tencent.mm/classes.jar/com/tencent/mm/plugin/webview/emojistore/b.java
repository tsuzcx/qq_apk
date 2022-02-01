package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends n
  implements k
{
  int Ebk;
  boolean Ebl;
  private f gCo;
  private long pLp;
  private int pMf;
  private byte[] pMu;
  private String pMw;
  private final com.tencent.mm.ak.b rr;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.pMu = null;
    this.Ebk = -1;
    this.Ebl = true;
    this.pLp = 0L;
    b.a locala = new b.a();
    locala.hQF = new cyz();
    locala.hQG = new cza();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pMf = paramInt1;
    this.pMw = paramString;
    this.pMu = paramArrayOfByte;
    this.Ebk = paramInt2;
    this.pLp = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77869);
    this.gCo = paramf;
    cyz localcyz = (cyz)this.rr.hQD.hQJ;
    if (!bu.cF(this.pMu))
    {
      localcyz.GQI = z.al(this.pMu);
      this.Ebl = false;
      localcyz.GQL = this.pLp;
      if (localcyz.GQI != null) {
        break label134;
      }
    }
    label134:
    for (paramf = "Buf is NULL";; paramf = localcyz.GQI.toString())
    {
      ae.d("MicroMsg.emoji.NetSceneSearchEmotion", paramf);
      localcyz.ReqType = this.pMf;
      localcyz.GQJ = this.pMw;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localcyz.GQI = new SKBuiltinBuffer_t();
      this.Ebl = true;
      break;
    }
  }
  
  public final cza eRH()
  {
    if (this.rr == null) {
      return null;
    }
    return (cza)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    ae.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */