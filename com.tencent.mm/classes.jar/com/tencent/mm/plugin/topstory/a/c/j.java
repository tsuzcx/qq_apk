package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class j
  extends n
  implements k
{
  private g callback;
  public b rr;
  private long rxC;
  public dio zZN;
  
  public j(dio paramdio, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(88489);
    this.rxC = System.currentTimeMillis();
    this.zZN = paramdio;
    paramdio = new b.a();
    paramdio.funcId = getType();
    paramdio.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    paramdio.hvt = new die();
    paramdio.hvu = new dif();
    this.rr = paramdio.aAz();
    paramdio = (die)this.rr.hvr.hvw;
    paramdio.FrN = paramString1;
    paramdio.FRe = "";
    paramdio.fZz = paramInt1;
    paramdio.FrP = paramString2;
    paramdio.hkR = "";
    paramdio.Scene = paramInt2;
    paramdio.FhW = paramString3;
    paramdio.DSv = paramInt3;
    paramdio.nOK = paramString4;
    paramdio.FCu = paramString5;
    paramdio.sVo = 1;
    ac.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { paramdio.FrN, paramdio.FRe, Integer.valueOf(paramdio.fZz), paramdio.FrP, paramdio.hkR, Integer.valueOf(paramdio.Scene), paramdio.FhW, Integer.valueOf(paramdio.DSv), paramdio.nOK, paramdio.FCu });
    AppMethodBeat.o(88489);
  }
  
  public j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88488);
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
    ((b.a)localObject).hvt = new die();
    ((b.a)localObject).hvu = new dif();
    this.rr = ((b.a)localObject).aAz();
    localObject = (die)this.rr.hvr.hvw;
    ((die)localObject).FrN = paramJSONObject.optString("docId", "");
    ((die)localObject).FRe = paramJSONObject.optString("commentId", "");
    ((die)localObject).fZz = paramJSONObject.optInt("opType", 0);
    ((die)localObject).FrP = paramJSONObject.optString("requestId", "");
    ((die)localObject).hkR = paramJSONObject.optString("content", "");
    ((die)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((die)localObject).FhW = paramJSONObject.optString("searchId", "");
    ((die)localObject).DSv = paramJSONObject.optInt("subScene", 0);
    ((die)localObject).nOK = paramJSONObject.optString("vid", "");
    ((die)localObject).FCu = paramJSONObject.optString("byPass", "");
    ((die)localObject).sVo = 0;
    ac.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((die)localObject).FrN, ((die)localObject).FRe, Integer.valueOf(((die)localObject).fZz), ((die)localObject).FrP, ((die)localObject).hkR, Integer.valueOf(((die)localObject).Scene), ((die)localObject).FhW, Integer.valueOf(((die)localObject).DSv), ((die)localObject).nOK, ((die)localObject).FCu });
    AppMethodBeat.o(88488);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(88490);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88490);
    return i;
  }
  
  public final dif ecI()
  {
    return (dif)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 2802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88491);
    ac.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */