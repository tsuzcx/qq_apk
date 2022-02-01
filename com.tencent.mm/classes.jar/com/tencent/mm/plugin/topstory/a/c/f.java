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
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private g callback;
  public b rr;
  private long yLW;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.yLW = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).gUU = new dcp();
    ((b.a)localObject).gUV = new dcq();
    this.rr = ((b.a)localObject).atI();
    localObject = (dcp)this.rr.gUS.gUX;
    paramf = paramf.dOg();
    ((dcp)localObject).DVb = paramf.DVb;
    ((dcp)localObject).DUZ = paramf.DUZ;
    ((dcp)localObject).gKr = paramf.gKr;
    ((dcp)localObject).Eub = paramf.Eub;
    ((dcp)localObject).Euc = paramf.Euc;
    ((dcp)localObject).Dni = paramf.Dni;
    ((dcp)localObject).Title = paramf.Title;
    ((dcp)localObject).DLH = paramf.DLH;
    ((dcp)localObject).Scene = paramf.Scene;
    ((dcp)localObject).CzZ = paramf.CzZ;
    ((dcp)localObject).nlK = paramf.nlK;
    ((dcp)localObject).Efu = paramf.Efu;
    ((dcp)localObject).rNz = paramf.rNz;
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dcp)localObject).DVb, ((dcp)localObject).DUZ, ((dcp)localObject).gKr, ((dcp)localObject).Eub, ((dcp)localObject).Euc, ((dcp)localObject).Dni, ((dcp)localObject).Title, ((dcp)localObject).DLH, Integer.valueOf(((dcp)localObject).Scene), Integer.valueOf(((dcp)localObject).CzZ) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.yLW = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).gUU = new dcp();
    ((b.a)localObject).gUV = new dcq();
    this.rr = ((b.a)localObject).atI();
    localObject = (dcp)this.rr.gUS.gUX;
    ((dcp)localObject).DVb = paramString1;
    ((dcp)localObject).DUZ = paramString2;
    ((dcp)localObject).gKr = paramString3;
    ((dcp)localObject).Eub = paramString4;
    ((dcp)localObject).Euc = paramString5;
    ((dcp)localObject).Dni = paramString6;
    ((dcp)localObject).Title = paramString7;
    ((dcp)localObject).DLH = paramString8;
    ((dcp)localObject).Scene = paramInt1;
    ((dcp)localObject).CzZ = paramInt2;
    ((dcp)localObject).nlK = paramString9;
    ((dcp)localObject).Efu = paramString10;
    ((dcp)localObject).rNz = 1;
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dcp)localObject).DVb, ((dcp)localObject).DUZ, ((dcp)localObject).gKr, ((dcp)localObject).Eub, ((dcp)localObject).Euc, ((dcp)localObject).Dni, ((dcp)localObject).Title, ((dcp)localObject).DLH, Integer.valueOf(((dcp)localObject).Scene), Integer.valueOf(((dcp)localObject).CzZ) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.yLW = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).gUU = new dcp();
    ((b.a)localObject).gUV = new dcq();
    this.rr = ((b.a)localObject).atI();
    localObject = (dcp)this.rr.gUS.gUX;
    ((dcp)localObject).DVb = paramJSONObject.optString("requestId", "");
    ((dcp)localObject).DUZ = paramJSONObject.optString("docId", "");
    ((dcp)localObject).gKr = paramJSONObject.optString("content", "");
    ((dcp)localObject).Eub = paramJSONObject.optString("replyId", "");
    ((dcp)localObject).Euc = paramJSONObject.optString("subReplyId", "");
    ((dcp)localObject).Dni = paramJSONObject.optString("docUrl", "");
    ((dcp)localObject).Title = paramJSONObject.optString("title", "");
    ((dcp)localObject).DLH = paramJSONObject.optString("searchId", "");
    ((dcp)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((dcp)localObject).CzZ = paramJSONObject.optInt("subScene", 0);
    ((dcp)localObject).nlK = paramJSONObject.optString("vid", "");
    ((dcp)localObject).Efu = paramJSONObject.optString("byPass", "");
    ((dcp)localObject).rNz = 0;
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dcp)localObject).DVb, ((dcp)localObject).DUZ, ((dcp)localObject).gKr, ((dcp)localObject).Eub, ((dcp)localObject).Euc, ((dcp)localObject).Dni, ((dcp)localObject).Title, ((dcp)localObject).DLH, Integer.valueOf(((dcp)localObject).Scene), Integer.valueOf(((dcp)localObject).CzZ) });
    AppMethodBeat.o(88483);
  }
  
  public final dcq dOf()
  {
    return (dcq)this.rr.gUT.gUX;
  }
  
  public final dcp dOg()
  {
    return (dcp)this.rr.gUS.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(88486);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88486);
    return i;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.yLW) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */