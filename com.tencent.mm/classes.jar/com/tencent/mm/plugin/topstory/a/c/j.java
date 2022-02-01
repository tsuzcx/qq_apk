package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class j
  extends n
  implements k
{
  public dod Brz;
  private f callback;
  public b rr;
  private long soX;
  
  public j(dod paramdod, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.soX = System.currentTimeMillis();
    this.Brz = paramdod;
    paramdod = new b.a();
    paramdod.funcId = getType();
    paramdod.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramdod.hNM = new dnt();
    paramdod.hNN = new dnu();
    this.rr = paramdod.aDC();
    paramdod = (dnt)this.rr.hNK.hNQ;
    paramdod.HbR = paramString1;
    paramdod.HBK = "";
    paramdod.gsV = paramInt1;
    paramdod.HbT = paramString2;
    paramdod.hDa = "";
    paramdod.Scene = paramInt2;
    paramdod.GRx = paramString3;
    paramdod.FxO = paramInt3;
    paramdod.orq = paramString4;
    paramdod.HmJ = paramString5;
    paramdod.tRT = 1;
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramdod.HbR, paramdod.HBK, Integer.valueOf(paramdod.gsV), paramdod.HbT, paramdod.hDa, Integer.valueOf(paramdod.Scene), paramdod.GRx, Integer.valueOf(paramdod.FxO), paramdod.orq, paramdod.HmJ });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((b.a)localObject).hNM = new dnt();
    ((b.a)localObject).hNN = new dnu();
    this.rr = ((b.a)localObject).aDC();
    localObject = (dnt)this.rr.hNK.hNQ;
    ((dnt)localObject).HbR = paramJSONObject.optString("docId", "");
    ((dnt)localObject).HBK = paramJSONObject.optString("commentId", "");
    ((dnt)localObject).gsV = paramJSONObject.optInt("opType", 0);
    ((dnt)localObject).HbT = paramJSONObject.optString("requestId", "");
    ((dnt)localObject).hDa = paramJSONObject.optString("content", "");
    ((dnt)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((dnt)localObject).GRx = paramJSONObject.optString("searchId", "");
    ((dnt)localObject).FxO = paramJSONObject.optInt("subScene", 0);
    ((dnt)localObject).orq = paramJSONObject.optString("vid", "");
    ((dnt)localObject).HmJ = paramJSONObject.optString("byPass", "");
    ((dnt)localObject).tRT = 0;
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dnt)localObject).HbR, ((dnt)localObject).HBK, Integer.valueOf(((dnt)localObject).gsV), ((dnt)localObject).HbT, ((dnt)localObject).hDa, Integer.valueOf(((dnt)localObject).Scene), ((dnt)localObject).GRx, Integer.valueOf(((dnt)localObject).FxO), ((dnt)localObject).orq, ((dnt)localObject).HmJ });
    AppMethodBeat.o(88488);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(88490);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88490);
    return i;
  }
  
  public final dnu eoZ()
  {
    return (dnu)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */