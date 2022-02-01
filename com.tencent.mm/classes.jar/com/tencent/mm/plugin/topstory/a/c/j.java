package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eso;
import com.tencent.mm.protocal.protobuf.esp;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends q
  implements m
{
  public esy MWs;
  private i callback;
  private long fhq;
  public d rr;
  
  public j(esy paramesy, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.fhq = System.currentTimeMillis();
    this.MWs = paramesy;
    paramesy = new d.a();
    paramesy.funcId = getType();
    paramesy.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramesy.lBU = new eso();
    paramesy.lBV = new esp();
    this.rr = paramesy.bgN();
    paramesy = (eso)d.b.b(this.rr.lBR);
    paramesy.TPZ = paramString1;
    paramesy.Uun = "";
    paramesy.jUk = paramInt1;
    paramesy.Tkx = paramString2;
    paramesy.lpy = "";
    paramesy.CPw = paramInt2;
    paramesy.Tky = paramString3;
    paramesy.RKI = paramInt3;
    paramesy.sSY = paramString4;
    paramesy.Udz = paramString5;
    paramesy.Cqs = 1;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramesy.TPZ, paramesy.Uun, Integer.valueOf(paramesy.jUk), paramesy.Tkx, paramesy.lpy, Integer.valueOf(paramesy.CPw), paramesy.Tky, Integer.valueOf(paramesy.RKI), paramesy.sSY, paramesy.Udz });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.fhq = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((d.a)localObject).lBU = new eso();
    ((d.a)localObject).lBV = new esp();
    this.rr = ((d.a)localObject).bgN();
    localObject = (eso)d.b.b(this.rr.lBR);
    ((eso)localObject).TPZ = paramJSONObject.optString("docId", "");
    ((eso)localObject).Uun = paramJSONObject.optString("commentId", "");
    ((eso)localObject).jUk = paramJSONObject.optInt("opType", 0);
    ((eso)localObject).Tkx = paramJSONObject.optString("requestId", "");
    ((eso)localObject).lpy = paramJSONObject.optString("content", "");
    ((eso)localObject).CPw = paramJSONObject.optInt("scene", 0);
    ((eso)localObject).Tky = paramJSONObject.optString("searchId", "");
    ((eso)localObject).RKI = paramJSONObject.optInt("subScene", 0);
    ((eso)localObject).sSY = paramJSONObject.optString("vid", "");
    ((eso)localObject).Udz = paramJSONObject.optString("byPass", "");
    ((eso)localObject).Cqs = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((eso)localObject).TPZ, ((eso)localObject).Uun, Integer.valueOf(((eso)localObject).jUk), ((eso)localObject).Tkx, ((eso)localObject).lpy, Integer.valueOf(((eso)localObject).CPw), ((eso)localObject).Tky, Integer.valueOf(((eso)localObject).RKI), ((eso)localObject).sSY, ((eso)localObject).Udz });
    AppMethodBeat.o(88488);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(88490);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88490);
    return i;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final esp gqa()
  {
    AppMethodBeat.i(261971);
    esp localesp = (esp)d.c.b(this.rr.lBS);
    AppMethodBeat.o(261971);
    return localesp;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.fhq) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */