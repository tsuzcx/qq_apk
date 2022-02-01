package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends n
  implements k
{
  public boh AGm;
  private int AGn;
  public int businessType;
  private g callback;
  public String dnB;
  public int dtt;
  private b hdD;
  public int scene;
  
  public v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(117638);
    this.scene = paramInt1;
    this.AGn = paramInt3;
    this.dtt = paramInt4;
    this.businessType = paramInt2;
    this.dnB = paramString2;
    ad.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    paramString2 = new b.a();
    paramString2.funcId = 1048;
    paramString2.uri = "/cgi-bin/mmsearch-bin/searchguide";
    paramString2.gUU = new bog();
    paramString2.gUV = new boh();
    this.hdD = paramString2.atI();
    paramString2 = (bog)this.hdD.gUS.gUX;
    paramString2.Scene = paramInt1;
    paramString2.DLD = paramInt3;
    paramString2.DLE = aa.bCk();
    paramString2.CCp = paramInt2;
    paramString2.oXs = paramString1;
    paramString2.DLF = paramLong;
    AppMethodBeat.o(117638);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117639);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
    ad.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.AGm = ((boh)this.hdD.gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.v
 * JD-Core Version:    0.7.0.1
 */