package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends com.tencent.mm.al.n
  implements k
{
  public static final d.a ALj;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  private long ALi;
  private f callback;
  private b rr;
  private int sourceType;
  public String userName;
  private String xbO;
  private String zhM;
  private boolean zhh;
  private long zhi;
  private long zhj;
  private long ziB;
  
  static
  {
    AppMethodBeat.i(118807);
    ALj = new d.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.zhi = 0L;
    this.xbO = paramString2;
    this.zhM = "";
    if (this.zhi == 0L) {
      ad.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.i.a.ATp;
      this.sourceType = com.tencent.mm.plugin.story.i.a.ekx();
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bx.a)new djd());
      paramString1.d((com.tencent.mm.bx.a)new dje());
      paramString1.Dl("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.oP(529);
      paramString1.oR(0);
      paramString1.oS(0);
      paramString1 = paramString1.aDC();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aEE();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      ad.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (djd)paramString1;
    paramString1.nDo = this.userName;
    paramString1.HtV = this.zhi;
    try
    {
      paramString2 = bt.flM();
      p.g(paramString2, "Util.getTimeZoneOffset()");
      float f = Float.parseFloat(paramString2);
      i = (int)f;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    paramString1.qey = i;
    paramString1.Gdd = this.xbO;
    if (this.zhi == 0L) {
      bool = true;
    }
    this.zhh = bool;
    this.ALi = this.zhi;
    ad.i(TAG, "req.mUserName:" + paramString1.nDo + " req.MaxId:" + paramString1.HtV + " req.TimeZone:" + paramString1.qey + " req.Date:" + paramString1.Gdd);
    AppMethodBeat.o(118806);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(118804);
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(118804);
    return i;
  }
  
  public final int getType()
  {
    return 529;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118805);
    ad.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    paramq = (dje)paramq;
    this.ziB = paramq.HxY;
    ad.i(TAG, "objCount: " + paramq.HxF + ", expiredTime: " + paramq.FqM);
    if (paramq.HxX.isEmpty())
    {
      ad.d(TAG, "error: server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118805);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.n.AKq;
    n.a.b(this.userName, (List)paramq.HxX, this.sourceType);
    if (this.zhi == 0L)
    {
      paramq = paramq.HxX;
      p.g(paramq, "resp.StoryList");
      this.zhi = ((djs)paramq.getFirst()).Id;
    }
    ad.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.zhi), Long.valueOf(this.zhj) });
    paramq = this.callback;
    if (paramq == null) {
      p.bcb("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
    AppMethodBeat.o(118805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.d
 * JD-Core Version:    0.7.0.1
 */