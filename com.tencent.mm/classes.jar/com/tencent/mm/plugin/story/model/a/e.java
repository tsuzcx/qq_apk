package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e
  extends m
  implements k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  public static final e.a sxf;
  private f callback;
  private int cpG;
  private String qFq;
  private boolean rew;
  private long rex;
  private long rey;
  private long rfK;
  private String rfa;
  private b rr;
  private long sxe;
  public String userName;
  
  static
  {
    AppMethodBeat.i(109220);
    sxf = new e.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(109220);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109219);
    this.userName = paramString1;
    this.rex = 0L;
    this.qFq = paramString2;
    this.rfa = "";
    if (this.rex == 0L) {
      ab.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.h.a.sFV;
      this.cpG = com.tencent.mm.plugin.story.h.a.cDO();
      paramString1 = new b.a();
      paramString1.a((com.tencent.mm.bv.a)new chc());
      paramString1.b((com.tencent.mm.bv.a)new chd());
      paramString1.rl("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.kT(529);
      paramString1.kU(0);
      paramString1.kV(0);
      paramString1 = paramString1.ado();
      j.p(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.adm();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(109219);
      throw paramString1;
      ab.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (chc)paramString1;
    paramString1.jJA = this.userName;
    paramString1.xOl = this.rex;
    try
    {
      paramString2 = bo.dtS();
      j.p(paramString2, "Util.getTimeZoneOffset()");
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
    paramString1.lGX = i;
    paramString1.xRQ = this.qFq;
    if (this.rex == 0L) {
      bool = true;
    }
    this.rew = bool;
    this.sxe = this.rex;
    ab.i(TAG, "req.mUserName:" + paramString1.jJA + " req.MaxId:" + paramString1.xOl + " req.TimeZone:" + paramString1.lGX + " req.Date:" + paramString1.xRQ);
    AppMethodBeat.o(109219);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(109217);
    j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(109217);
    return i;
  }
  
  public final int getType()
  {
    return 529;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109218);
    ab.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.adn();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(109218);
      throw paramString;
    }
    paramq = (chd)paramq;
    this.rfK = paramq.xRS;
    ab.i(TAG, "objCount: " + paramq.xRy + ", expiredTime: " + paramq.wlc);
    if (paramq.xRR.isEmpty())
    {
      ab.d(TAG, "error: server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109218);
      return;
    }
    paramArrayOfByte = n.svx;
    n.a.b(this.userName, (List)paramq.xRR, this.cpG);
    if (this.rex == 0L)
    {
      paramq = paramq.xRR;
      j.p(paramq, "resp.StoryList");
      this.rex = ((chs)paramq.getFirst()).Id;
    }
    ab.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.rex), Long.valueOf(this.rey) });
    paramq = this.callback;
    if (paramq == null) {
      j.ays("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
    AppMethodBeat.o(109218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.e
 * JD-Core Version:    0.7.0.1
 */