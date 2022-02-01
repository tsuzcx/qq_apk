package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fnx;
import com.tencent.mm.protocal.protobuf.fny;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends p
  implements m
{
  public foh TIW;
  private h callback;
  private long hlB;
  public c rr;
  
  public j(foh paramfoh, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.hlB = System.currentTimeMillis();
    this.TIW = paramfoh;
    paramfoh = new c.a();
    paramfoh.funcId = getType();
    paramfoh.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramfoh.otE = new fnx();
    paramfoh.otF = new fny();
    this.rr = paramfoh.bEF();
    paramfoh = (fnx)c.b.b(this.rr.otB);
    paramfoh.abgw = paramString1;
    paramfoh.abNQ = "";
    paramfoh.muC = paramInt1;
    paramfoh.aaye = paramString2;
    paramfoh.nUB = "";
    paramfoh.IJG = paramInt2;
    paramfoh.aayf = paramString3;
    paramfoh.YIc = paramInt3;
    paramfoh.vYo = paramString4;
    paramfoh.abuT = paramString5;
    paramfoh.IcB = 1;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramfoh.abgw, paramfoh.abNQ, Integer.valueOf(paramfoh.muC), paramfoh.aaye, paramfoh.nUB, Integer.valueOf(paramfoh.IJG), paramfoh.aayf, Integer.valueOf(paramfoh.YIc), paramfoh.vYo, paramfoh.abuT });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((c.a)localObject).otE = new fnx();
    ((c.a)localObject).otF = new fny();
    this.rr = ((c.a)localObject).bEF();
    localObject = (fnx)c.b.b(this.rr.otB);
    ((fnx)localObject).abgw = paramJSONObject.optString("docId", "");
    ((fnx)localObject).abNQ = paramJSONObject.optString("commentId", "");
    ((fnx)localObject).muC = paramJSONObject.optInt("opType", 0);
    ((fnx)localObject).aaye = paramJSONObject.optString("requestId", "");
    ((fnx)localObject).nUB = paramJSONObject.optString("content", "");
    ((fnx)localObject).IJG = paramJSONObject.optInt("scene", 0);
    ((fnx)localObject).aayf = paramJSONObject.optString("searchId", "");
    ((fnx)localObject).YIc = paramJSONObject.optInt("subScene", 0);
    ((fnx)localObject).vYo = paramJSONObject.optString("vid", "");
    ((fnx)localObject).abuT = paramJSONObject.optString("byPass", "");
    ((fnx)localObject).IcB = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((fnx)localObject).abgw, ((fnx)localObject).abNQ, Integer.valueOf(((fnx)localObject).muC), ((fnx)localObject).aaye, ((fnx)localObject).nUB, Integer.valueOf(((fnx)localObject).IJG), ((fnx)localObject).aayf, Integer.valueOf(((fnx)localObject).YIc), ((fnx)localObject).vYo, ((fnx)localObject).abuT });
    AppMethodBeat.o(88488);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(88490);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88490);
    return i;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final fny hMW()
  {
    AppMethodBeat.i(271661);
    fny localfny = (fny)c.c.b(this.rr.otC);
    AppMethodBeat.o(271661);
    return localfny;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */