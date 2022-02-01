package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public b rr;
  private long soX;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hNM = new dnr();
    ((b.a)localObject).hNN = new dns();
    this.rr = ((b.a)localObject).aDC();
    localObject = (dnr)this.rr.hNK.hNQ;
    paramf = paramf.eoY();
    ((dnr)localObject).HbT = paramf.HbT;
    ((dnr)localObject).HbR = paramf.HbR;
    ((dnr)localObject).hDa = paramf.hDa;
    ((dnr)localObject).HBI = paramf.HBI;
    ((dnr)localObject).HBJ = paramf.HBJ;
    ((dnr)localObject).GqZ = paramf.GqZ;
    ((dnr)localObject).Title = paramf.Title;
    ((dnr)localObject).GRx = paramf.GRx;
    ((dnr)localObject).Scene = paramf.Scene;
    ((dnr)localObject).FxO = paramf.FxO;
    ((dnr)localObject).orq = paramf.orq;
    ((dnr)localObject).HmJ = paramf.HmJ;
    ((dnr)localObject).tRT = paramf.tRT;
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dnr)localObject).HbT, ((dnr)localObject).HbR, ((dnr)localObject).hDa, ((dnr)localObject).HBI, ((dnr)localObject).HBJ, ((dnr)localObject).GqZ, ((dnr)localObject).Title, ((dnr)localObject).GRx, Integer.valueOf(((dnr)localObject).Scene), Integer.valueOf(((dnr)localObject).FxO) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hNM = new dnr();
    ((b.a)localObject).hNN = new dns();
    this.rr = ((b.a)localObject).aDC();
    localObject = (dnr)this.rr.hNK.hNQ;
    ((dnr)localObject).HbT = paramString1;
    ((dnr)localObject).HbR = paramString2;
    ((dnr)localObject).hDa = paramString3;
    ((dnr)localObject).HBI = paramString4;
    ((dnr)localObject).HBJ = paramString5;
    ((dnr)localObject).GqZ = paramString6;
    ((dnr)localObject).Title = paramString7;
    ((dnr)localObject).GRx = paramString8;
    ((dnr)localObject).Scene = paramInt1;
    ((dnr)localObject).FxO = paramInt2;
    ((dnr)localObject).orq = paramString9;
    ((dnr)localObject).HmJ = paramString10;
    ((dnr)localObject).tRT = 1;
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dnr)localObject).HbT, ((dnr)localObject).HbR, ((dnr)localObject).hDa, ((dnr)localObject).HBI, ((dnr)localObject).HBJ, ((dnr)localObject).GqZ, ((dnr)localObject).Title, ((dnr)localObject).GRx, Integer.valueOf(((dnr)localObject).Scene), Integer.valueOf(((dnr)localObject).FxO) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hNM = new dnr();
    ((b.a)localObject).hNN = new dns();
    this.rr = ((b.a)localObject).aDC();
    localObject = (dnr)this.rr.hNK.hNQ;
    ((dnr)localObject).HbT = paramJSONObject.optString("requestId", "");
    ((dnr)localObject).HbR = paramJSONObject.optString("docId", "");
    ((dnr)localObject).hDa = paramJSONObject.optString("content", "");
    ((dnr)localObject).HBI = paramJSONObject.optString("replyId", "");
    ((dnr)localObject).HBJ = paramJSONObject.optString("subReplyId", "");
    ((dnr)localObject).GqZ = paramJSONObject.optString("docUrl", "");
    ((dnr)localObject).Title = paramJSONObject.optString("title", "");
    ((dnr)localObject).GRx = paramJSONObject.optString("searchId", "");
    ((dnr)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((dnr)localObject).FxO = paramJSONObject.optInt("subScene", 0);
    ((dnr)localObject).orq = paramJSONObject.optString("vid", "");
    ((dnr)localObject).HmJ = paramJSONObject.optString("byPass", "");
    ((dnr)localObject).tRT = 0;
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dnr)localObject).HbT, ((dnr)localObject).HbR, ((dnr)localObject).hDa, ((dnr)localObject).HBI, ((dnr)localObject).HBJ, ((dnr)localObject).GqZ, ((dnr)localObject).Title, ((dnr)localObject).GRx, Integer.valueOf(((dnr)localObject).Scene), Integer.valueOf(((dnr)localObject).FxO) });
    AppMethodBeat.o(88483);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(88486);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88486);
    return i;
  }
  
  public final dns eoX()
  {
    return (dns)this.rr.hNL.hNQ;
  }
  
  public final dnr eoY()
  {
    return (dnr)this.rr.hNK.hNQ;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */