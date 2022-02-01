package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends com.tencent.mm.ak.n
  implements k
{
  public static final a BcM;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  private long BcL;
  private f callback;
  private b rr;
  private int sourceType;
  public String userName;
  private String xrF;
  private boolean zxW;
  private long zxX;
  private long zxY;
  private String zyB;
  private long zzQ;
  
  static
  {
    AppMethodBeat.i(118807);
    BcM = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.zxX = 0L;
    this.xrF = paramString2;
    this.zyB = "";
    if (this.zxX == 0L) {
      ae.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.i.a.BkN;
      this.sourceType = com.tencent.mm.plugin.story.i.a.eog();
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bw.a)new djy());
      paramString1.d((com.tencent.mm.bw.a)new djz());
      paramString1.DN("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.oS(529);
      paramString1.oU(0);
      paramString1.oV(0);
      paramString1 = paramString1.aDS();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aEU();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      ae.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (djy)paramString1;
    paramString1.nIJ = this.userName;
    paramString1.HNy = this.zxX;
    try
    {
      paramString2 = bu.fpH();
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
    paramString1.qld = i;
    paramString1.GvK = this.xrF;
    if (this.zxX == 0L) {
      bool = true;
    }
    this.zxW = bool;
    this.BcL = this.zxX;
    ae.i(TAG, "req.mUserName:" + paramString1.nIJ + " req.MaxId:" + paramString1.HNy + " req.TimeZone:" + paramString1.qld + " req.Date:" + paramString1.GvK);
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
    ae.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    paramq = (djz)paramq;
    this.zzQ = paramq.HRJ;
    ae.i(TAG, "objCount: " + paramq.HRq + ", expiredTime: " + paramq.FJk);
    if (paramq.HRI.isEmpty())
    {
      ae.d(TAG, "error: server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118805);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.n.BbT;
    n.a.b(this.userName, (List)paramq.HRI, this.sourceType);
    if (this.zxX == 0L)
    {
      paramq = paramq.HRI;
      p.g(paramq, "resp.StoryList");
      this.zxX = ((dkn)paramq.getFirst()).Id;
    }
    ae.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.zxX), Long.valueOf(this.zxY) });
    paramq = this.callback;
    if (paramq == null) {
      p.bdF("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
    AppMethodBeat.o(118805);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.d
 * JD-Core Version:    0.7.0.1
 */