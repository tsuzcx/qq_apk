package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.sdk.platformtools.ae;

public final class y
  extends n
  implements k
{
  public bye DTx;
  private int DTy;
  public int businessType;
  private f callback;
  public int dDY;
  public String dyb;
  private b hZD;
  public int scene;
  
  public y(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(188470);
    this.scene = paramInt1;
    this.DTy = paramInt3;
    this.dDY = paramInt4;
    this.businessType = paramInt2;
    this.dyb = paramString2;
    ae.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    paramString2 = new b.a();
    paramString2.funcId = 1048;
    paramString2.uri = "/cgi-bin/mmsearch-bin/searchguide";
    paramString2.hQF = new byd();
    paramString2.hQG = new bye();
    this.hZD = paramString2.aDS();
    paramString2 = (byd)this.hZD.hQD.hQJ;
    paramString2.Scene = paramInt1;
    paramString2.GWA = paramInt3;
    paramString2.HkU = ad.bOD();
    paramString2.uuz = paramInt2;
    paramString2.qkN = paramString1;
    paramString2.HkV = paramLong;
    paramString2.FQl = paramString3;
    paramString2.HkW = paramString4;
    AppMethodBeat.o(188470);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117639);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(117639);
    return i;
  }
  
  public final int getType()
  {
    return 1048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117640);
    ae.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.DTx = ((bye)this.hZD.hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.y
 * JD-Core Version:    0.7.0.1
 */