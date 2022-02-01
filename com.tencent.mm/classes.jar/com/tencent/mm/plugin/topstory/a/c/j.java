package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class j
  extends n
  implements k
{
  public dpa BIY;
  private f callback;
  public b rr;
  private long szi;
  
  public j(dpa paramdpa, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.szi = System.currentTimeMillis();
    this.BIY = paramdpa;
    paramdpa = new b.a();
    paramdpa.funcId = getType();
    paramdpa.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramdpa.hQF = new doq();
    paramdpa.hQG = new dor();
    this.rr = paramdpa.aDS();
    paramdpa = (doq)this.rr.hQD.hQJ;
    paramdpa.Hvr = paramString1;
    paramdpa.HVx = "";
    paramdpa.gvx = paramInt1;
    paramdpa.Hvt = paramString2;
    paramdpa.hFS = "";
    paramdpa.Scene = paramInt2;
    paramdpa.HkY = paramString3;
    paramdpa.FQm = paramInt3;
    paramdpa.oxM = paramString4;
    paramdpa.HGj = paramString5;
    paramdpa.ucK = 1;
    ae.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramdpa.Hvr, paramdpa.HVx, Integer.valueOf(paramdpa.gvx), paramdpa.Hvt, paramdpa.hFS, Integer.valueOf(paramdpa.Scene), paramdpa.HkY, Integer.valueOf(paramdpa.FQm), paramdpa.oxM, paramdpa.HGj });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((b.a)localObject).hQF = new doq();
    ((b.a)localObject).hQG = new dor();
    this.rr = ((b.a)localObject).aDS();
    localObject = (doq)this.rr.hQD.hQJ;
    ((doq)localObject).Hvr = paramJSONObject.optString("docId", "");
    ((doq)localObject).HVx = paramJSONObject.optString("commentId", "");
    ((doq)localObject).gvx = paramJSONObject.optInt("opType", 0);
    ((doq)localObject).Hvt = paramJSONObject.optString("requestId", "");
    ((doq)localObject).hFS = paramJSONObject.optString("content", "");
    ((doq)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((doq)localObject).HkY = paramJSONObject.optString("searchId", "");
    ((doq)localObject).FQm = paramJSONObject.optInt("subScene", 0);
    ((doq)localObject).oxM = paramJSONObject.optString("vid", "");
    ((doq)localObject).HGj = paramJSONObject.optString("byPass", "");
    ((doq)localObject).ucK = 0;
    ae.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((doq)localObject).Hvr, ((doq)localObject).HVx, Integer.valueOf(((doq)localObject).gvx), ((doq)localObject).Hvt, ((doq)localObject).hFS, Integer.valueOf(((doq)localObject).Scene), ((doq)localObject).HkY, Integer.valueOf(((doq)localObject).FQm), ((doq)localObject).oxM, ((doq)localObject).HGj });
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
  
  public final dor esG()
  {
    return (dor)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    ae.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */