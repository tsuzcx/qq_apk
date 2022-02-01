package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  public static final a ygp;
  private g callback;
  private b rr;
  private int sourceType;
  public String userName;
  private boolean wES;
  private long wET;
  private long wEU;
  private String wFy;
  private long wGn;
  private String wdN;
  private long ygo;
  
  static
  {
    AppMethodBeat.i(118807);
    ygp = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.wET = 0L;
    this.wdN = paramString2;
    this.wFy = "";
    if (this.wET == 0L) {
      ad.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.i.a.yor;
      this.sourceType = com.tencent.mm.plugin.story.i.a.dJH();
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bx.a)new cye());
      paramString1.d((com.tencent.mm.bx.a)new cyf());
      paramString1.wg("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.nB(529);
      paramString1.nD(0);
      paramString1.nE(0);
      paramString1 = paramString1.atI();
      d.g.b.k.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.auL();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      ad.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (cye)paramString1;
    paramString1.mAQ = this.userName;
    paramString1.Emo = this.wET;
    try
    {
      paramString2 = bt.eGH();
      d.g.b.k.g(paramString2, "Util.getTimeZoneOffset()");
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
    paramString1.oXI = i;
    paramString1.DcA = this.wdN;
    if (this.wET == 0L) {
      bool = true;
    }
    this.wES = bool;
    this.ygo = this.wET;
    ad.i(TAG, "req.mUserName:" + paramString1.mAQ + " req.MaxId:" + paramString1.Emo + " req.TimeZone:" + paramString1.oXI + " req.Date:" + paramString1.DcA);
    AppMethodBeat.o(118806);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(118804);
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    paramq = this.rr.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    paramq = (cyf)paramq;
    this.wGn = paramq.Eql;
    ad.i(TAG, "objCount: " + paramq.EpS + ", expiredTime: " + paramq.Ctq);
    if (paramq.Eqk.isEmpty())
    {
      ad.d(TAG, "error: server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118805);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.n.yfw;
    n.a.b(this.userName, (List)paramq.Eqk, this.sourceType);
    if (this.wET == 0L)
    {
      paramq = paramq.Eqk;
      d.g.b.k.g(paramq, "resp.StoryList");
      this.wET = ((cyt)paramq.getFirst()).Id;
    }
    ad.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.wET), Long.valueOf(this.wEU) });
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aPZ("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
    AppMethodBeat.o(118805);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.d
 * JD-Core Version:    0.7.0.1
 */