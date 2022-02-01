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
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private g callback;
  public b rr;
  private long rxC;
  
  public f(f paramf)
  {
    AppMethodBeat.i(88485);
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hvt = new dic();
    ((b.a)localObject).hvu = new did();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dic)this.rr.hvr.hvw;
    paramf = paramf.ecH();
    ((dic)localObject).FrP = paramf.FrP;
    ((dic)localObject).FrN = paramf.FrN;
    ((dic)localObject).hkR = paramf.hkR;
    ((dic)localObject).FRc = paramf.FRc;
    ((dic)localObject).FRd = paramf.FRd;
    ((dic)localObject).EIi = paramf.EIi;
    ((dic)localObject).Title = paramf.Title;
    ((dic)localObject).FhW = paramf.FhW;
    ((dic)localObject).Scene = paramf.Scene;
    ((dic)localObject).DSv = paramf.DSv;
    ((dic)localObject).nOK = paramf.nOK;
    ((dic)localObject).FCu = paramf.FCu;
    ((dic)localObject).sVo = paramf.sVo;
    ac.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dic)localObject).FrP, ((dic)localObject).FrN, ((dic)localObject).hkR, ((dic)localObject).FRc, ((dic)localObject).FRd, ((dic)localObject).EIi, ((dic)localObject).Title, ((dic)localObject).FhW, Integer.valueOf(((dic)localObject).Scene), Integer.valueOf(((dic)localObject).DSv) });
    AppMethodBeat.o(88485);
  }
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(88484);
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hvt = new dic();
    ((b.a)localObject).hvu = new did();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dic)this.rr.hvr.hvw;
    ((dic)localObject).FrP = paramString1;
    ((dic)localObject).FrN = paramString2;
    ((dic)localObject).hkR = paramString3;
    ((dic)localObject).FRc = paramString4;
    ((dic)localObject).FRd = paramString5;
    ((dic)localObject).EIi = paramString6;
    ((dic)localObject).Title = paramString7;
    ((dic)localObject).FhW = paramString8;
    ((dic)localObject).Scene = paramInt1;
    ((dic)localObject).DSv = paramInt2;
    ((dic)localObject).nOK = paramString9;
    ((dic)localObject).FCu = paramString10;
    ((dic)localObject).sVo = 1;
    ac.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dic)localObject).FrP, ((dic)localObject).FrN, ((dic)localObject).hkR, ((dic)localObject).FRc, ((dic)localObject).FRd, ((dic)localObject).EIi, ((dic)localObject).Title, ((dic)localObject).FhW, Integer.valueOf(((dic)localObject).Scene), Integer.valueOf(((dic)localObject).DSv) });
    AppMethodBeat.o(88484);
  }
  
  public f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88483);
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
    ((b.a)localObject).hvt = new dic();
    ((b.a)localObject).hvu = new did();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dic)this.rr.hvr.hvw;
    ((dic)localObject).FrP = paramJSONObject.optString("requestId", "");
    ((dic)localObject).FrN = paramJSONObject.optString("docId", "");
    ((dic)localObject).hkR = paramJSONObject.optString("content", "");
    ((dic)localObject).FRc = paramJSONObject.optString("replyId", "");
    ((dic)localObject).FRd = paramJSONObject.optString("subReplyId", "");
    ((dic)localObject).EIi = paramJSONObject.optString("docUrl", "");
    ((dic)localObject).Title = paramJSONObject.optString("title", "");
    ((dic)localObject).FhW = paramJSONObject.optString("searchId", "");
    ((dic)localObject).Scene = paramJSONObject.optInt("scene", 0);
    ((dic)localObject).DSv = paramJSONObject.optInt("subScene", 0);
    ((dic)localObject).nOK = paramJSONObject.optString("vid", "");
    ((dic)localObject).FCu = paramJSONObject.optString("byPass", "");
    ((dic)localObject).sVo = 0;
    ac.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[] { ((dic)localObject).FrP, ((dic)localObject).FrN, ((dic)localObject).hkR, ((dic)localObject).FRc, ((dic)localObject).FRd, ((dic)localObject).EIi, ((dic)localObject).Title, ((dic)localObject).FhW, Integer.valueOf(((dic)localObject).Scene), Integer.valueOf(((dic)localObject).DSv) });
    AppMethodBeat.o(88483);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(88486);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88486);
    return i;
  }
  
  public final did ecG()
  {
    return (did)this.rr.hvs.hvw;
  }
  
  public final dic ecH()
  {
    return (dic)this.rr.hvr.hvw;
  }
  
  public final int getType()
  {
    return 2906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88487);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.f
 * JD-Core Version:    0.7.0.1
 */