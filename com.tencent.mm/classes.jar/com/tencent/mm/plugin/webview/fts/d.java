package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends a
  implements k
{
  dfg Ecn;
  private f callback;
  public int dDY;
  private b hZD;
  
  public d(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.dDY = -1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dff();
    ((b.a)localObject).hQG = new dfg();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((b.a)localObject).funcId = 2999;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (dff)this.hZD.hQD.hQJ;
    ((dff)localObject).Md5 = paramString1;
    ((dff)localObject).GeT = paramInt1;
    ((dff)localObject).HkY = paramString2;
    ((dff)localObject).FQl = paramString3;
    ((dff)localObject).HMr = paramInt2;
    ((dff)localObject).Hvt = paramString4;
    ((dff)localObject).GWA = ad.WL(0);
    ((dff)localObject).Scene = paramInt3;
    ((dff)localObject).HkU = ad.bOD();
    ((dff)localObject).AesKey = paramString6;
    ((dff)localObject).HMs = paramString5;
    ae.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77925);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final String ePw()
  {
    return null;
  }
  
  public final int ePx()
  {
    return 0;
  }
  
  public final dfg eRO()
  {
    return this.Ecn;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    ae.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Ecn = ((dfg)this.hZD.hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */