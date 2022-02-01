package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.bxk;

public final class y
  extends n
  implements k
{
  public bxk DBA;
  private int DBB;
  public int businessType;
  private f callback;
  public int dCT;
  public String dwW;
  private b hWL;
  public int scene;
  
  public y(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(217640);
    this.scene = paramInt1;
    this.DBB = paramInt3;
    this.dCT = paramInt4;
    this.businessType = paramInt2;
    this.dwW = paramString2;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    paramString2 = new b.a();
    paramString2.funcId = 1048;
    paramString2.uri = "/cgi-bin/mmsearch-bin/searchguide";
    paramString2.hNM = new bxj();
    paramString2.hNN = new bxk();
    this.hWL = paramString2.aDC();
    paramString2 = (bxj)this.hWL.hNK.hNQ;
    paramString2.Scene = paramInt1;
    paramString2.GDa = paramInt3;
    paramString2.GRt = ad.bNG();
    paramString2.FAh = paramInt2;
    paramString2.qei = paramString1;
    paramString2.GRu = paramLong;
    paramString2.FxN = paramString3;
    paramString2.GRv = paramString4;
    AppMethodBeat.o(217640);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117639);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.DBA = ((bxk)this.hWL.hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.y
 * JD-Core Version:    0.7.0.1
 */