package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.edl;
import com.tencent.mm.protocal.protobuf.edm;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends q
  implements m
{
  public static final a FnE;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  private String BrH;
  private String DIL;
  private boolean DIe;
  private long DIf;
  private long DIg;
  private long DJB;
  private long FnD;
  private i callback;
  private com.tencent.mm.ak.d rr;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118807);
    FnE = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.DIf = 0L;
    this.BrH = paramString2;
    this.DIL = "";
    if (this.DIf == 0L) {
      Log.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.i.a.FvD;
      this.sourceType = com.tencent.mm.plugin.story.i.a.fqG();
      paramString1 = new com.tencent.mm.ak.d.a();
      paramString1.c((com.tencent.mm.bw.a)new edl());
      paramString1.d((com.tencent.mm.bw.a)new edm());
      paramString1.MB("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.sG(529);
      paramString1.sI(0);
      paramString1.sJ(0);
      paramString1 = paramString1.aXF();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aYJ();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      Log.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (edl)paramString1;
    paramString1.UserName = this.userName;
    paramString1.MZh = this.DIf;
    try
    {
      paramString2 = Util.getTimeZoneOffset();
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
    paramString1.rBY = i;
    paramString1.Lrr = this.BrH;
    if (this.DIf == 0L) {
      bool = true;
    }
    this.DIe = bool;
    this.FnD = this.DIf;
    Log.i(TAG, "req.mUserName:" + paramString1.UserName + " req.MaxId:" + paramString1.MZh + " req.TimeZone:" + paramString1.rBY + " req.Date:" + paramString1.Lrr);
    AppMethodBeat.o(118806);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118804);
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(118804);
    return i;
  }
  
  public final int getType()
  {
    return 529;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118805);
    Log.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    params = (edm)params;
    this.DJB = params.NdN;
    Log.i(TAG, "objCount: " + params.Ndu + ", expiredTime: " + params.KCC);
    if (params.NdM.isEmpty())
    {
      Log.d(TAG, "error: server give size zero");
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118805);
      return;
    }
    paramArrayOfByte = n.FmM;
    n.a.b(this.userName, (List)params.NdM, this.sourceType);
    if (this.DIf == 0L)
    {
      params = params.NdM;
      p.g(params, "resp.StoryList");
      this.DIf = ((eea)params.getFirst()).Id;
    }
    Log.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.DIf), Long.valueOf(this.DIg) });
    params = this.callback;
    if (params == null) {
      p.btv("callback");
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    AppMethodBeat.o(118805);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.d
 * JD-Core Version:    0.7.0.1
 */