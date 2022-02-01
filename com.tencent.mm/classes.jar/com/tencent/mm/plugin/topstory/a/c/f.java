package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public b rr;
  private long szi;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hQF = new doo();
    ((b.a)localObject).hQG = new dop();
    this.rr = ((b.a)localObject).aDS();
    localObject = (doo)this.rr.hQD.hQJ;
    paramf = paramf.esF();
    ((doo)localObject).Hvt = paramf.Hvt;
    ((doo)localObject).Hvr = paramf.Hvr;
    ((doo)localObject).hFS = paramf.hFS;
    ((doo)localObject).HVv = paramf.HVv;
    ((doo)localObject).HVw = paramf.HVw;
    ((doo)localObject).GKx = paramf.GKx;
    ((doo)localObject).Title = paramf.Title;
    ((doo)localObject).HkY = paramf.HkY;
    ((doo)localObject).Scene = paramf.Scene;
    ((doo)localObject).FQm = paramf.FQm;
    ((doo)localObject).oxM = paramf.oxM;
    ((doo)localObject).HGj = paramf.HGj;
    ((doo)localObject).ucK = paramf.ucK;
    ae.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((doo)localObject).Hvt, ((doo)localObject).Hvr, ((doo)localObject).hFS, ((doo)localObject).HVv, ((doo)localObject).HVw, ((doo)localObject).GKx, ((doo)localObject).Title, ((doo)localObject).HkY, Integer.valueOf(((doo)localObject).Scene), Integer.valueOf(((doo)localObject).FQm) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hQF = new doo();
    ((b.a)localObject).hQG = new dop();
    this.rr = ((b.a)localObject).aDS();
    localObject = (doo)this.rr.hQD.hQJ;
    ((doo)localObject).Hvt = paramString1;
    ((doo)localObject).Hvr = paramString2;
    ((doo)localObject).hFS = paramString3;
    ((doo)localObject).HVv = paramString4;
    ((doo)localObject).HVw = paramString5;
    ((doo)localObject).GKx = paramString6;
    ((doo)localObject).Title = paramString7;
    ((doo)localObject).HkY = paramString8;
    ((doo)localObject).Scene = paramInt1;
    ((doo)localObject).FQm = paramInt2;
    ((doo)localObject).oxM = paramString9;
    ((doo)localObject).HGj = paramString10;
    ((doo)localObject).ucK = 1;
    ae.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((doo)localObject).Hvt, ((doo)localObject).Hvr, ((doo)localObject).hFS, ((doo)localObject).HVv, ((doo)localObject).HVw, ((doo)localObject).GKx, ((doo)localObject).Title, ((doo)localObject).HkY, Integer.valueOf(((doo)localObject).Scene), Integer.valueOf(((doo)localObject).FQm) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hQF = new doo();
    ((b.a)localObject).hQG = new dop();
    this.rr = ((b.a)localObject).aDS();
    localObject = (doo)this.rr.hQD.hQJ;
    ((doo)localObject).Hvt = paramJSONObject.optString("requestId", "");
    ((doo)localObject).Hvr = paramJSONObject.optString("docId", "");
    ((doo)localObject).hFS = paramJSONObject.optString("content", "");
    ((doo)localObject).HVv = paramJSONObject.optString("replyId", "");
    ((doo)localObject).HVw = paramJSONObject.optString("subReplyId", "");
    ((doo)localObject).GKx = paramJSONObject.optString("docUrl", "");
    ((doo)localObject).Title = paramJSONObject.optString("title", "");
    ((doo)localObject).HkY = paramJSONObject.optString("searchId", "");
    ((doo)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((doo)localObject).FQm = paramJSONObject.optInt("subScene", 0);
    ((doo)localObject).oxM = paramJSONObject.optString("vid", "");
    ((doo)localObject).HGj = paramJSONObject.optString("byPass", "");
    ((doo)localObject).ucK = 0;
    ae.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((doo)localObject).Hvt, ((doo)localObject).Hvr, ((doo)localObject).hFS, ((doo)localObject).HVv, ((doo)localObject).HVw, ((doo)localObject).GKx, ((doo)localObject).Title, ((doo)localObject).HkY, Integer.valueOf(((doo)localObject).Scene), Integer.valueOf(((doo)localObject).FQm) });
    AppMethodBeat.o(88483);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(88486);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88486);
    return i;
  }
  
  public final dop esE()
  {
    return (dop)this.rr.hQE.hQJ;
  }
  
  public final doo esF()
  {
    return (doo)this.rr.hQD.hQJ;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */