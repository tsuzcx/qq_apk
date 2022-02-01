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
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.protocal.protobuf.esn;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f
  extends q
  implements m
{
  private i callback;
  private long fhq;
  public d rr;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.fhq = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((d.a)localObject).lBU = new esm();
    ((d.a)localObject).lBV = new esn();
    this.rr = ((d.a)localObject).bgN();
    localObject = (esm)d.b.b(this.rr.lBR);
    paramf = paramf.gpY();
    ((esm)localObject).Tkx = paramf.Tkx;
    ((esm)localObject).TPZ = paramf.TPZ;
    ((esm)localObject).lpy = paramf.lpy;
    ((esm)localObject).Uul = paramf.Uul;
    ((esm)localObject).Uum = paramf.Uum;
    ((esm)localObject).SWP = paramf.SWP;
    ((esm)localObject).fwr = paramf.fwr;
    ((esm)localObject).Tky = paramf.Tky;
    ((esm)localObject).CPw = paramf.CPw;
    ((esm)localObject).RKI = paramf.RKI;
    ((esm)localObject).sSY = paramf.sSY;
    ((esm)localObject).Udz = paramf.Udz;
    ((esm)localObject).Cqs = paramf.Cqs;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((esm)localObject).Tkx, ((esm)localObject).TPZ, ((esm)localObject).lpy, ((esm)localObject).Uul, ((esm)localObject).Uum, ((esm)localObject).SWP, ((esm)localObject).fwr, ((esm)localObject).Tky, Integer.valueOf(((esm)localObject).CPw), Integer.valueOf(((esm)localObject).RKI) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.fhq = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((d.a)localObject).lBU = new esm();
    ((d.a)localObject).lBV = new esn();
    this.rr = ((d.a)localObject).bgN();
    localObject = (esm)d.b.b(this.rr.lBR);
    ((esm)localObject).Tkx = paramString1;
    ((esm)localObject).TPZ = paramString2;
    ((esm)localObject).lpy = paramString3;
    ((esm)localObject).Uul = paramString4;
    ((esm)localObject).Uum = paramString5;
    ((esm)localObject).SWP = paramString6;
    ((esm)localObject).fwr = paramString7;
    ((esm)localObject).Tky = paramString8;
    ((esm)localObject).CPw = paramInt1;
    ((esm)localObject).RKI = paramInt2;
    ((esm)localObject).sSY = paramString9;
    ((esm)localObject).Udz = paramString10;
    ((esm)localObject).Cqs = 1;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((esm)localObject).Tkx, ((esm)localObject).TPZ, ((esm)localObject).lpy, ((esm)localObject).Uul, ((esm)localObject).Uum, ((esm)localObject).SWP, ((esm)localObject).fwr, ((esm)localObject).Tky, Integer.valueOf(((esm)localObject).CPw), Integer.valueOf(((esm)localObject).RKI) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.fhq = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((d.a)localObject).lBU = new esm();
    ((d.a)localObject).lBV = new esn();
    this.rr = ((d.a)localObject).bgN();
    localObject = (esm)d.b.b(this.rr.lBR);
    ((esm)localObject).Tkx = paramJSONObject.optString("requestId", "");
    ((esm)localObject).TPZ = paramJSONObject.optString("docId", "");
    ((esm)localObject).lpy = paramJSONObject.optString("content", "");
    ((esm)localObject).Uul = paramJSONObject.optString("replyId", "");
    ((esm)localObject).Uum = paramJSONObject.optString("subReplyId", "");
    ((esm)localObject).SWP = paramJSONObject.optString("docUrl", "");
    ((esm)localObject).fwr = paramJSONObject.optString("title", "");
    ((esm)localObject).Tky = paramJSONObject.optString("searchId", "");
    ((esm)localObject).CPw = paramJSONObject.optInt("scene", 0);
    ((esm)localObject).RKI = paramJSONObject.optInt("subScene", 0);
    ((esm)localObject).sSY = paramJSONObject.optString("vid", "");
    ((esm)localObject).Udz = paramJSONObject.optString("byPass", "");
    ((esm)localObject).Cqs = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((esm)localObject).Tkx, ((esm)localObject).TPZ, ((esm)localObject).lpy, ((esm)localObject).Uul, ((esm)localObject).Uum, ((esm)localObject).SWP, ((esm)localObject).fwr, ((esm)localObject).Tky, Integer.valueOf(((esm)localObject).CPw), Integer.valueOf(((esm)localObject).RKI) });
    AppMethodBeat.o(88483);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(88486);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88486);
    return i;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final esn gpX()
  {
    AppMethodBeat.i(262130);
    esn localesn = (esn)d.c.b(this.rr.lBS);
    AppMethodBeat.o(262130);
    return localesn;
  }
  
  public final esm gpY()
  {
    AppMethodBeat.i(262131);
    esm localesm = (esm)d.b.b(this.rr.lBR);
    AppMethodBeat.o(262131);
    return localesm;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.fhq) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */