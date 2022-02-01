package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
  implements m
{
  dym IOA;
  private i callback;
  public int dVL;
  private com.tencent.mm.ak.d iUB;
  
  public d(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.dVL = -1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dyl();
    ((d.a)localObject).iLO = new dym();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((d.a)localObject).funcId = 2999;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (dyl)this.iUB.iLK.iLR;
    ((dyl)localObject).Md5 = paramString1;
    ((dyl)localObject).KZk = paramInt1;
    ((dyl)localObject).Mbb = paramString2;
    ((dyl)localObject).SessionId = paramString3;
    ((dyl)localObject).MYb = paramInt2;
    ((dyl)localObject).Mba = paramString4;
    ((dyl)localObject).MaY = ai.aft(0);
    ((dyl)localObject).Scene = paramInt3;
    ((dyl)localObject).MlQ = ai.clJ();
    ((dyl)localObject).AesKey = paramString6;
    ((dyl)localObject).MYc = paramString5;
    ((dyl)localObject).MlR = ai.fYd();
    Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77925);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final String fXC()
  {
    return null;
  }
  
  public final int fXD()
  {
    return 0;
  }
  
  public final dym gay()
  {
    return this.IOA;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IOA = ((dym)this.iUB.iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */