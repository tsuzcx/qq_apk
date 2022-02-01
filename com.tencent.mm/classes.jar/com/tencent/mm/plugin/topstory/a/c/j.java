package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class j
  extends n
  implements k
{
  private g callback;
  public b rr;
  public ddb yLU;
  private long yLW;
  
  public j(ddb paramddb, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.yLW = System.currentTimeMillis();
    this.yLU = paramddb;
    paramddb = new b.a();
    paramddb.funcId = getType();
    paramddb.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramddb.gUU = new dcr();
    paramddb.gUV = new dcs();
    this.rr = paramddb.atI();
    paramddb = (dcr)this.rr.gUS.gUX;
    paramddb.DUZ = paramString1;
    paramddb.Eud = "";
    paramddb.fVE = paramInt1;
    paramddb.DVb = paramString2;
    paramddb.gKr = "";
    paramddb.Scene = paramInt2;
    paramddb.DLH = paramString3;
    paramddb.CzZ = paramInt3;
    paramddb.nlK = paramString4;
    paramddb.Efu = paramString5;
    paramddb.rNz = 1;
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramddb.DUZ, paramddb.Eud, Integer.valueOf(paramddb.fVE), paramddb.DVb, paramddb.gKr, Integer.valueOf(paramddb.Scene), paramddb.DLH, Integer.valueOf(paramddb.CzZ), paramddb.nlK, paramddb.Efu });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.yLW = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((b.a)localObject).gUU = new dcr();
    ((b.a)localObject).gUV = new dcs();
    this.rr = ((b.a)localObject).atI();
    localObject = (dcr)this.rr.gUS.gUX;
    ((dcr)localObject).DUZ = paramJSONObject.optString("docId", "");
    ((dcr)localObject).Eud = paramJSONObject.optString("commentId", "");
    ((dcr)localObject).fVE = paramJSONObject.optInt("opType", 0);
    ((dcr)localObject).DVb = paramJSONObject.optString("requestId", "");
    ((dcr)localObject).gKr = paramJSONObject.optString("content", "");
    ((dcr)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((dcr)localObject).DLH = paramJSONObject.optString("searchId", "");
    ((dcr)localObject).CzZ = paramJSONObject.optInt("subScene", 0);
    ((dcr)localObject).nlK = paramJSONObject.optString("vid", "");
    ((dcr)localObject).Efu = paramJSONObject.optString("byPass", "");
    ((dcr)localObject).rNz = 0;
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dcr)localObject).DUZ, ((dcr)localObject).Eud, Integer.valueOf(((dcr)localObject).fVE), ((dcr)localObject).DVb, ((dcr)localObject).gKr, Integer.valueOf(((dcr)localObject).Scene), ((dcr)localObject).DLH, Integer.valueOf(((dcr)localObject).CzZ), ((dcr)localObject).nlK, ((dcr)localObject).Efu });
    AppMethodBeat.o(88488);
  }
  
  public final dcs dOh()
  {
    return (dcs)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(88490);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88490);
    return i;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    ad.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.yLW) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */