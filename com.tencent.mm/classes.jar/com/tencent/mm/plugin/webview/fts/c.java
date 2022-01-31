package com.tencent.mm.plugin.webview.fts;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cct;

public final class c
  extends a
  implements k
{
  public int cCT;
  private f callback;
  private b fBd;
  cct uPa;
  
  public c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(155680);
    this.cCT = -1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ccs();
    ((b.a)localObject).fsY = new cct();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((b.a)localObject).funcId = 2999;
    this.fBd = ((b.a)localObject).ado();
    localObject = (ccs)this.fBd.fsV.fta;
    ((ccs)localObject).Md5 = paramString1;
    ((ccs)localObject).wzS = paramInt1;
    ((ccs)localObject).xqX = paramString2;
    ((ccs)localObject).wqN = paramString3;
    ((ccs)localObject).xNi = paramInt2;
    ((ccs)localObject).xHX = paramString4;
    ((ccs)localObject).xqT = aa.Jf(0);
    ((ccs)localObject).Scene = paramInt3;
    ((ccs)localObject).xqU = aa.acv();
    ((ccs)localObject).AesKey = paramString6;
    ((ccs)localObject).xNj = paramString5;
    d.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(155680);
  }
  
  public final String act()
  {
    return null;
  }
  
  public final int acu()
  {
    return 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(153075);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(153075);
    return i;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(153074);
    d.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uPa = ((cct)this.fBd.fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(153074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */