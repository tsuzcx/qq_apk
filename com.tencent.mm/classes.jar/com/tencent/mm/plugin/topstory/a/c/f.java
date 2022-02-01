package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f
  extends q
  implements m
{
  private i callback;
  public d rr;
  private long uOV;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((d.a)localObject).iLN = new eik();
    ((d.a)localObject).iLO = new eil();
    this.rr = ((d.a)localObject).aXF();
    localObject = (eik)this.rr.iLK.iLR;
    paramf = paramf.fyd();
    ((eik)localObject).Mba = paramf.Mba;
    ((eik)localObject).MEq = paramf.MEq;
    ((eik)localObject).iAc = paramf.iAc;
    ((eik)localObject).NhF = paramf.NhF;
    ((eik)localObject).NhG = paramf.NhG;
    ((eik)localObject).LOr = paramf.LOr;
    ((eik)localObject).Title = paramf.Title;
    ((eik)localObject).Mbb = paramf.Mbb;
    ((eik)localObject).Scene = paramf.Scene;
    ((eik)localObject).KJS = paramf.KJS;
    ((eik)localObject).pLq = paramf.pLq;
    ((eik)localObject).MRt = paramf.MRt;
    ((eik)localObject).xub = paramf.xub;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((eik)localObject).Mba, ((eik)localObject).MEq, ((eik)localObject).iAc, ((eik)localObject).NhF, ((eik)localObject).NhG, ((eik)localObject).LOr, ((eik)localObject).Title, ((eik)localObject).Mbb, Integer.valueOf(((eik)localObject).Scene), Integer.valueOf(((eik)localObject).KJS) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((d.a)localObject).iLN = new eik();
    ((d.a)localObject).iLO = new eil();
    this.rr = ((d.a)localObject).aXF();
    localObject = (eik)this.rr.iLK.iLR;
    ((eik)localObject).Mba = paramString1;
    ((eik)localObject).MEq = paramString2;
    ((eik)localObject).iAc = paramString3;
    ((eik)localObject).NhF = paramString4;
    ((eik)localObject).NhG = paramString5;
    ((eik)localObject).LOr = paramString6;
    ((eik)localObject).Title = paramString7;
    ((eik)localObject).Mbb = paramString8;
    ((eik)localObject).Scene = paramInt1;
    ((eik)localObject).KJS = paramInt2;
    ((eik)localObject).pLq = paramString9;
    ((eik)localObject).MRt = paramString10;
    ((eik)localObject).xub = 1;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((eik)localObject).Mba, ((eik)localObject).MEq, ((eik)localObject).iAc, ((eik)localObject).NhF, ((eik)localObject).NhG, ((eik)localObject).LOr, ((eik)localObject).Title, ((eik)localObject).Mbb, Integer.valueOf(((eik)localObject).Scene), Integer.valueOf(((eik)localObject).KJS) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((d.a)localObject).iLN = new eik();
    ((d.a)localObject).iLO = new eil();
    this.rr = ((d.a)localObject).aXF();
    localObject = (eik)this.rr.iLK.iLR;
    ((eik)localObject).Mba = paramJSONObject.optString("requestId", "");
    ((eik)localObject).MEq = paramJSONObject.optString("docId", "");
    ((eik)localObject).iAc = paramJSONObject.optString("content", "");
    ((eik)localObject).NhF = paramJSONObject.optString("replyId", "");
    ((eik)localObject).NhG = paramJSONObject.optString("subReplyId", "");
    ((eik)localObject).LOr = paramJSONObject.optString("docUrl", "");
    ((eik)localObject).Title = paramJSONObject.optString("title", "");
    ((eik)localObject).Mbb = paramJSONObject.optString("searchId", "");
    ((eik)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((eik)localObject).KJS = paramJSONObject.optInt("subScene", 0);
    ((eik)localObject).pLq = paramJSONObject.optString("vid", "");
    ((eik)localObject).MRt = paramJSONObject.optString("byPass", "");
    ((eik)localObject).xub = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((eik)localObject).Mba, ((eik)localObject).MEq, ((eik)localObject).iAc, ((eik)localObject).NhF, ((eik)localObject).NhG, ((eik)localObject).LOr, ((eik)localObject).Title, ((eik)localObject).Mbb, Integer.valueOf(((eik)localObject).Scene), Integer.valueOf(((eik)localObject).KJS) });
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
  
  public final eil fyc()
  {
    return (eil)this.rr.iLL.iLR;
  }
  
  public final eik fyd()
  {
    return (eik)this.rr.iLK.iLR;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */