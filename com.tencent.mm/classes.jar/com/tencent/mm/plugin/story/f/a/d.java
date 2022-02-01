package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends q
  implements m
{
  public static final a LHG;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  private String Hma;
  private String JVL;
  private boolean JVe;
  private long JVf;
  private long JVg;
  private long JWB;
  private long LHF;
  private i callback;
  private com.tencent.mm.an.d rr;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118807);
    LHG = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.JVf = 0L;
    this.Hma = paramString2;
    this.JVL = "";
    if (this.JVf == 0L) {
      Log.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.i.a.LPG;
      this.sourceType = com.tencent.mm.plugin.story.i.a.gfc();
      paramString1 = new com.tencent.mm.an.d.a();
      paramString1.c((com.tencent.mm.cd.a)new enm());
      paramString1.d((com.tencent.mm.cd.a)new enn());
      paramString1.TW("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.vD(529);
      paramString1.vF(0);
      paramString1.vG(0);
      paramString1 = paramString1.bgN();
      p.j(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.bhX();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      Log.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (enm)paramString1;
    paramString1.UserName = this.userName;
    paramString1.UlB = this.JVf;
    try
    {
      paramString2 = Util.getTimeZoneOffset();
      p.j(paramString2, "Util.getTimeZoneOffset()");
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
    paramString1.vhG = i;
    paramString1.SsO = this.Hma;
    if (this.JVf == 0L) {
      bool = true;
    }
    this.JVe = bool;
    this.LHF = this.JVf;
    Log.i(TAG, "req.mUserName:" + paramString1.UserName + " req.MaxId:" + paramString1.UlB + " req.TimeZone:" + paramString1.vhG + " req.Date:" + paramString1.SsO);
    AppMethodBeat.o(118806);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118804);
    p.k(parami, "callback");
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
    params = this.rr.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    params = (enn)params;
    this.JWB = params.Uqk;
    Log.i(TAG, "objCount: " + params.UpR + ", expiredTime: " + params.SXb);
    if (params.Uqj.isEmpty())
    {
      Log.d(TAG, "error: server give size zero");
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118805);
      return;
    }
    paramArrayOfByte = n.LGO;
    n.a.c(this.userName, (List)params.Uqj, this.sourceType);
    if (this.JVf == 0L)
    {
      params = params.Uqj;
      p.j(params, "resp.StoryList");
      this.JVf = ((eob)params.getFirst()).Id;
    }
    Log.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.JVf), Long.valueOf(this.JVg) });
    params = this.callback;
    if (params == null) {
      p.bGy("callback");
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    AppMethodBeat.o(118805);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.d
 * JD-Core Version:    0.7.0.1
 */