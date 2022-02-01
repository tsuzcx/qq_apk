package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
  implements m
{
  eim PKR;
  private i callback;
  public int fPp;
  private com.tencent.mm.an.d lKU;
  
  public d(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.fPp = -1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eil();
    ((d.a)localObject).lBV = new eim();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((d.a)localObject).funcId = 2999;
    this.lKU = ((d.a)localObject).bgN();
    localObject = (eil)d.b.b(this.lKU.lBR);
    ((eil)localObject).Md5 = paramString1;
    ((eil)localObject).Sat = paramInt1;
    ((eil)localObject).Tky = paramString2;
    ((eil)localObject).SessionId = paramString3;
    ((eil)localObject).Ukt = paramInt2;
    ((eil)localObject).Tkx = paramString4;
    ((eil)localObject).Tkv = ai.anh(0);
    ((eil)localObject).CPw = paramInt3;
    ((eil)localObject).TwK = ai.czn();
    ((eil)localObject).AesKey = paramString6;
    ((eil)localObject).Uku = paramString5;
    ((eil)localObject).TwL = ai.gQO();
    Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77925);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final String gQp()
  {
    return null;
  }
  
  public final int gQq()
  {
    return 0;
  }
  
  public final eim gTs()
  {
    return this.PKR;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.PKR = ((eim)d.c.b(this.lKU.lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */