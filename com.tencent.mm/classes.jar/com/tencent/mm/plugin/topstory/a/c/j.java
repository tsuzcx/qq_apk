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
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.ein;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends q
  implements m
{
  public eiw GjH;
  private i callback;
  public d rr;
  private long uOV;
  
  public j(eiw parameiw, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.uOV = System.currentTimeMillis();
    this.GjH = parameiw;
    parameiw = new d.a();
    parameiw.funcId = getType();
    parameiw.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    parameiw.iLN = new eim();
    parameiw.iLO = new ein();
    this.rr = parameiw.aXF();
    parameiw = (eim)this.rr.iLK.iLR;
    parameiw.MEq = paramString1;
    parameiw.NhH = "";
    parameiw.him = paramInt1;
    parameiw.Mba = paramString2;
    parameiw.iAc = "";
    parameiw.Scene = paramInt2;
    parameiw.Mbb = paramString3;
    parameiw.KJS = paramInt3;
    parameiw.pLq = paramString4;
    parameiw.MRt = paramString5;
    parameiw.xub = 1;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { parameiw.MEq, parameiw.NhH, Integer.valueOf(parameiw.him), parameiw.Mba, parameiw.iAc, Integer.valueOf(parameiw.Scene), parameiw.Mbb, Integer.valueOf(parameiw.KJS), parameiw.pLq, parameiw.MRt });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((d.a)localObject).iLN = new eim();
    ((d.a)localObject).iLO = new ein();
    this.rr = ((d.a)localObject).aXF();
    localObject = (eim)this.rr.iLK.iLR;
    ((eim)localObject).MEq = paramJSONObject.optString("docId", "");
    ((eim)localObject).NhH = paramJSONObject.optString("commentId", "");
    ((eim)localObject).him = paramJSONObject.optInt("opType", 0);
    ((eim)localObject).Mba = paramJSONObject.optString("requestId", "");
    ((eim)localObject).iAc = paramJSONObject.optString("content", "");
    ((eim)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((eim)localObject).Mbb = paramJSONObject.optString("searchId", "");
    ((eim)localObject).KJS = paramJSONObject.optInt("subScene", 0);
    ((eim)localObject).pLq = paramJSONObject.optString("vid", "");
    ((eim)localObject).MRt = paramJSONObject.optString("byPass", "");
    ((eim)localObject).xub = 0;
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((eim)localObject).MEq, ((eim)localObject).NhH, Integer.valueOf(((eim)localObject).him), ((eim)localObject).Mba, ((eim)localObject).iAc, Integer.valueOf(((eim)localObject).Scene), ((eim)localObject).Mbb, Integer.valueOf(((eim)localObject).KJS), ((eim)localObject).pLq, ((eim)localObject).MRt });
    AppMethodBeat.o(88488);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(88490);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88490);
    return i;
  }
  
  public final ein fye()
  {
    return (ein)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */