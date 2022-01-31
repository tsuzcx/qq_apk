package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public b rr;
  private long tfo;
  
  public f(f paramf)
  {
    AppMethodBeat.i(65511);
    this.tfo = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).fsX = new ckq();
    ((b.a)localObject).fsY = new ckr();
    this.rr = ((b.a)localObject).ado();
    localObject = (ckq)this.rr.fsV.fta;
    paramf = paramf.cIF();
    ((ckq)localObject).xHX = paramf.xHX;
    ((ckq)localObject).xHJ = paramf.xHJ;
    ((ckq)localObject).ntu = paramf.ntu;
    ((ckq)localObject).xUC = paramf.xUC;
    ((ckq)localObject).xUD = paramf.xUD;
    ((ckq)localObject).xUE = paramf.xUE;
    ((ckq)localObject).Title = paramf.Title;
    ((ckq)localObject).xqX = paramf.xqX;
    ((ckq)localObject).Scene = paramf.Scene;
    ((ckq)localObject).wqO = paramf.wqO;
    ((ckq)localObject).wNY = paramf.wNY;
    ((ckq)localObject).xIg = paramf.xIg;
    ((ckq)localObject).niK = paramf.niK;
    ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((ckq)localObject).xHX, ((ckq)localObject).xHJ, ((ckq)localObject).ntu, ((ckq)localObject).xUC, ((ckq)localObject).xUD, ((ckq)localObject).xUE, ((ckq)localObject).Title, ((ckq)localObject).xqX, Integer.valueOf(((ckq)localObject).Scene), Integer.valueOf(((ckq)localObject).wqO) });
    AppMethodBeat.o(65511);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(65510);
    this.tfo = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).fsX = new ckq();
    ((b.a)localObject).fsY = new ckr();
    this.rr = ((b.a)localObject).ado();
    localObject = (ckq)this.rr.fsV.fta;
    ((ckq)localObject).xHX = paramString1;
    ((ckq)localObject).xHJ = paramString2;
    ((ckq)localObject).ntu = paramString3;
    ((ckq)localObject).xUC = paramString4;
    ((ckq)localObject).xUD = paramString5;
    ((ckq)localObject).xUE = paramString6;
    ((ckq)localObject).Title = paramString7;
    ((ckq)localObject).xqX = paramString8;
    ((ckq)localObject).Scene = paramInt1;
    ((ckq)localObject).wqO = paramInt2;
    ((ckq)localObject).wNY = paramString9;
    ((ckq)localObject).xIg = paramString10;
    ((ckq)localObject).niK = 1;
    ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((ckq)localObject).xHX, ((ckq)localObject).xHJ, ((ckq)localObject).ntu, ((ckq)localObject).xUC, ((ckq)localObject).xUD, ((ckq)localObject).xUE, ((ckq)localObject).Title, ((ckq)localObject).xqX, Integer.valueOf(((ckq)localObject).Scene), Integer.valueOf(((ckq)localObject).wqO) });
    AppMethodBeat.o(65510);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65509);
    this.tfo = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).fsX = new ckq();
    ((b.a)localObject).fsY = new ckr();
    this.rr = ((b.a)localObject).ado();
    localObject = (ckq)this.rr.fsV.fta;
    ((ckq)localObject).xHX = paramJSONObject.optString("requestId", "");
    ((ckq)localObject).xHJ = paramJSONObject.optString("docId", "");
    ((ckq)localObject).ntu = paramJSONObject.optString("content", "");
    ((ckq)localObject).xUC = paramJSONObject.optString("replyId", "");
    ((ckq)localObject).xUD = paramJSONObject.optString("subReplyId", "");
    ((ckq)localObject).xUE = paramJSONObject.optString("docUrl", "");
    ((ckq)localObject).Title = paramJSONObject.optString("title", "");
    ((ckq)localObject).xqX = paramJSONObject.optString("searchId", "");
    ((ckq)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((ckq)localObject).wqO = paramJSONObject.optInt("subScene", 0);
    ((ckq)localObject).wNY = paramJSONObject.optString("vid", "");
    ((ckq)localObject).xIg = paramJSONObject.optString("byPass", "");
    ((ckq)localObject).niK = 0;
    ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((ckq)localObject).xHX, ((ckq)localObject).xHJ, ((ckq)localObject).ntu, ((ckq)localObject).xUC, ((ckq)localObject).xUD, ((ckq)localObject).xUE, ((ckq)localObject).Title, ((ckq)localObject).xqX, Integer.valueOf(((ckq)localObject).Scene), Integer.valueOf(((ckq)localObject).wqO) });
    AppMethodBeat.o(65509);
  }
  
  public final ckr cIE()
  {
    return (ckr)this.rr.fsW.fta;
  }
  
  public final ckq cIF()
  {
    return (ckq)this.rr.fsV.fta;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(65512);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(65512);
    return i;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65513);
    ab.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.tfo) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(65513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */