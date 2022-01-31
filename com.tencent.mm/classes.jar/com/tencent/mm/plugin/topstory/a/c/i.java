package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class i
  extends m
  implements k
{
  private f callback;
  public b rr;
  public ckx tfm;
  private long tfo;
  
  public i(ckx paramckx, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(65515);
    this.tfo = System.currentTimeMillis();
    this.tfm = paramckx;
    paramckx = new b.a();
    paramckx.funcId = getType();
    paramckx.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramckx.fsX = new cks();
    paramckx.fsY = new ckt();
    this.rr = paramckx.ado();
    paramckx = (cks)this.rr.fsV.fta;
    paramckx.xHJ = paramString1;
    paramckx.xUF = "";
    paramckx.nrS = paramInt1;
    paramckx.xHX = paramString2;
    paramckx.ntu = "";
    paramckx.Scene = paramInt2;
    paramckx.xqX = paramString3;
    paramckx.wqO = paramInt3;
    paramckx.wNY = paramString4;
    paramckx.xIg = paramString5;
    paramckx.niK = 1;
    ab.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramckx.xHJ, paramckx.xUF, Integer.valueOf(paramckx.nrS), paramckx.xHX, paramckx.ntu, Integer.valueOf(paramckx.Scene), paramckx.xqX, Integer.valueOf(paramckx.wqO), paramckx.wNY, paramckx.xIg });
    AppMethodBeat.o(65515);
  }
  
  public i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65514);
    this.tfo = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((b.a)localObject).fsX = new cks();
    ((b.a)localObject).fsY = new ckt();
    this.rr = ((b.a)localObject).ado();
    localObject = (cks)this.rr.fsV.fta;
    ((cks)localObject).xHJ = paramJSONObject.optString("docId", "");
    ((cks)localObject).xUF = paramJSONObject.optString("commentId", "");
    ((cks)localObject).nrS = paramJSONObject.optInt("opType", 0);
    ((cks)localObject).xHX = paramJSONObject.optString("requestId", "");
    ((cks)localObject).ntu = paramJSONObject.optString("content", "");
    ((cks)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((cks)localObject).xqX = paramJSONObject.optString("searchId", "");
    ((cks)localObject).wqO = paramJSONObject.optInt("subScene", 0);
    ((cks)localObject).wNY = paramJSONObject.optString("vid", "");
    ((cks)localObject).xIg = paramJSONObject.optString("byPass", "");
    ((cks)localObject).niK = 0;
    ab.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((cks)localObject).xHJ, ((cks)localObject).xUF, Integer.valueOf(((cks)localObject).nrS), ((cks)localObject).xHX, ((cks)localObject).ntu, Integer.valueOf(((cks)localObject).Scene), ((cks)localObject).xqX, Integer.valueOf(((cks)localObject).wqO), ((cks)localObject).wNY, ((cks)localObject).xIg });
    AppMethodBeat.o(65514);
  }
  
  public final ckt cIG()
  {
    return (ckt)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65516);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(65516);
    return i;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65517);
    ab.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.tfo) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(65517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.i
 * JD-Core Version:    0.7.0.1
 */