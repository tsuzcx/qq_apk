package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.dem;

public final class d
  extends a
  implements k
{
  dem DKp;
  private f callback;
  public int dCT;
  private b hWL;
  
  public d(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.dCT = -1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new del();
    ((b.a)localObject).hNN = new dem();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((b.a)localObject).funcId = 2999;
    this.hWL = ((b.a)localObject).aDC();
    localObject = (del)this.hWL.hNK.hNQ;
    ((del)localObject).Md5 = paramString1;
    ((del)localObject).FMu = paramInt1;
    ((del)localObject).GRx = paramString2;
    ((del)localObject).FxN = paramString3;
    ((del)localObject).HsO = paramInt2;
    ((del)localObject).HbT = paramString4;
    ((del)localObject).GDa = com.tencent.mm.plugin.websearch.api.ad.We(0);
    ((del)localObject).Scene = paramInt3;
    ((del)localObject).GRt = com.tencent.mm.plugin.websearch.api.ad.bNG();
    ((del)localObject).AesKey = paramString6;
    ((del)localObject).HsP = paramString5;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77925);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final String eLN()
  {
    return null;
  }
  
  public final int eLO()
  {
    return 0;
  }
  
  public final dem eOd()
  {
    return this.DKp;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.DKp = ((dem)this.hWL.hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */