package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.protocal.protobuf.fco;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
  implements m
{
  public fco WBd;
  private h callback;
  public int hVk;
  private c oDw;
  
  public d(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.hVk = -1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fcn();
    ((c.a)localObject).otF = new fco();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((c.a)localObject).funcId = 2999;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (fcn)c.b.b(this.oDw.otB);
    ((fcn)localObject).Md5 = paramString1;
    ((fcn)localObject).YYs = paramInt1;
    ((fcn)localObject).aayf = paramString2;
    ((fcn)localObject).SessionId = paramString3;
    ((fcn)localObject).aWI = paramInt2;
    ((fcn)localObject).aaye = paramString4;
    ((fcn)localObject).aayc = aj.asY(0);
    ((fcn)localObject).IJG = paramInt3;
    ((fcn)localObject).aaLr = aj.dch();
    ((fcn)localObject).AesKey = paramString6;
    ((fcn)localObject).abCc = paramString5;
    ((fcn)localObject).aaLs = aj.iqa();
    Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(77925);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final String ipG()
  {
    return null;
  }
  
  public final int ipH()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.WBd = ((fco)c.c.b(this.oDw.otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */