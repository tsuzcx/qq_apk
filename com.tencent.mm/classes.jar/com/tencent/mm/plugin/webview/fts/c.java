package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a
  implements k
{
  cto AOS;
  private g callback;
  public int dtt;
  private b hdD;
  
  public c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.dtt = -1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ctn();
    ((b.a)localObject).gUV = new cto();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((b.a)localObject).funcId = 2999;
    this.hdD = ((b.a)localObject).atI();
    localObject = (ctn)this.hdD.gUS.gUX;
    ((ctn)localObject).Md5 = paramString1;
    ((ctn)localObject).CNt = paramInt1;
    ((ctn)localObject).DLH = paramString2;
    ((ctn)localObject).CzY = paramString3;
    ((ctn)localObject).Eli = paramInt2;
    ((ctn)localObject).DVb = paramString4;
    ((ctn)localObject).DLD = aa.Sb(0);
    ((ctn)localObject).Scene = paramInt3;
    ((ctn)localObject).DLE = aa.bCk();
    ((ctn)localObject).AesKey = paramString6;
    ((ctn)localObject).Elj = paramString5;
    ad.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(77925);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final String ehF()
  {
    return null;
  }
  
  public final int ehG()
  {
    return 0;
  }
  
  public final cto ejT()
  {
    return this.AOS;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    ad.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.AOS = ((cto)this.hdD.gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */