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
import com.tencent.mm.protocal.protobuf.fnv;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f
  extends p
  implements m
{
  private h callback;
  private long hlB;
  public c rr;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((c.a)localObject).otE = new fnv();
    ((c.a)localObject).otF = new fnw();
    this.rr = ((c.a)localObject).bEF();
    localObject = (fnv)c.b.b(this.rr.otB);
    paramf = paramf.hMU();
    ((fnv)localObject).aaye = paramf.aaye;
    ((fnv)localObject).abgw = paramf.abgw;
    ((fnv)localObject).nUB = paramf.nUB;
    ((fnv)localObject).abNO = paramf.abNO;
    ((fnv)localObject).abNP = paramf.abNP;
    ((fnv)localObject).aaiG = paramf.aaiG;
    ((fnv)localObject).hAP = paramf.hAP;
    ((fnv)localObject).aayf = paramf.aayf;
    ((fnv)localObject).IJG = paramf.IJG;
    ((fnv)localObject).YIc = paramf.YIc;
    ((fnv)localObject).vYo = paramf.vYo;
    ((fnv)localObject).abuT = paramf.abuT;
    ((fnv)localObject).IcB = paramf.IcB;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((fnv)localObject).aaye, ((fnv)localObject).abgw, ((fnv)localObject).nUB, ((fnv)localObject).abNO, ((fnv)localObject).abNP, ((fnv)localObject).aaiG, ((fnv)localObject).hAP, ((fnv)localObject).aayf, Integer.valueOf(((fnv)localObject).IJG), Integer.valueOf(((fnv)localObject).YIc) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((c.a)localObject).otE = new fnv();
    ((c.a)localObject).otF = new fnw();
    this.rr = ((c.a)localObject).bEF();
    localObject = (fnv)c.b.b(this.rr.otB);
    ((fnv)localObject).aaye = paramString1;
    ((fnv)localObject).abgw = paramString2;
    ((fnv)localObject).nUB = paramString3;
    ((fnv)localObject).abNO = paramString4;
    ((fnv)localObject).abNP = paramString5;
    ((fnv)localObject).aaiG = paramString6;
    ((fnv)localObject).hAP = paramString7;
    ((fnv)localObject).aayf = paramString8;
    ((fnv)localObject).IJG = paramInt1;
    ((fnv)localObject).YIc = paramInt2;
    ((fnv)localObject).vYo = paramString9;
    ((fnv)localObject).abuT = paramString10;
    ((fnv)localObject).IcB = 1;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((fnv)localObject).aaye, ((fnv)localObject).abgw, ((fnv)localObject).nUB, ((fnv)localObject).abNO, ((fnv)localObject).abNP, ((fnv)localObject).aaiG, ((fnv)localObject).hAP, ((fnv)localObject).aayf, Integer.valueOf(((fnv)localObject).IJG), Integer.valueOf(((fnv)localObject).YIc) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.hlB = System.currentTimeMillis();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((c.a)localObject).otE = new fnv();
    ((c.a)localObject).otF = new fnw();
    this.rr = ((c.a)localObject).bEF();
    localObject = (fnv)c.b.b(this.rr.otB);
    ((fnv)localObject).aaye = paramJSONObject.optString("requestId", "");
    ((fnv)localObject).abgw = paramJSONObject.optString("docId", "");
    ((fnv)localObject).nUB = paramJSONObject.optString("content", "");
    ((fnv)localObject).abNO = paramJSONObject.optString("replyId", "");
    ((fnv)localObject).abNP = paramJSONObject.optString("subReplyId", "");
    ((fnv)localObject).aaiG = paramJSONObject.optString("docUrl", "");
    ((fnv)localObject).hAP = paramJSONObject.optString("title", "");
    ((fnv)localObject).aayf = paramJSONObject.optString("searchId", "");
    ((fnv)localObject).IJG = paramJSONObject.optInt("scene", 0);
    ((fnv)localObject).YIc = paramJSONObject.optInt("subScene", 0);
    ((fnv)localObject).vYo = paramJSONObject.optString("vid", "");
    ((fnv)localObject).abuT = paramJSONObject.optString("byPass", "");
    ((fnv)localObject).IcB = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((fnv)localObject).aaye, ((fnv)localObject).abgw, ((fnv)localObject).nUB, ((fnv)localObject).abNO, ((fnv)localObject).abNP, ((fnv)localObject).aaiG, ((fnv)localObject).hAP, ((fnv)localObject).aayf, Integer.valueOf(((fnv)localObject).IJG), Integer.valueOf(((fnv)localObject).YIc) });
    AppMethodBeat.o(88483);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(88486);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88486);
    return i;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final fnw hMT()
  {
    AppMethodBeat.i(271667);
    fnw localfnw = (fnw)c.c.b(this.rr.otC);
    AppMethodBeat.o(271667);
    return localfnw;
  }
  
  public final fnv hMU()
  {
    AppMethodBeat.i(271669);
    fnv localfnv = (fnv)c.b.b(this.rr.otB);
    AppMethodBeat.o(271669);
    return localfnv;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */