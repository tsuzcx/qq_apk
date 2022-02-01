package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.ddq;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
  public static final d.a ztp;
  private g callback;
  private b rr;
  private int sourceType;
  public String userName;
  private String xRS;
  private boolean xRn;
  private long xRo;
  private long xRp;
  private long xSH;
  private String xpb;
  private long zto;
  
  static
  {
    AppMethodBeat.i(118807);
    ztp = new d.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.xRo = 0L;
    this.xpb = paramString2;
    this.xRS = "";
    if (this.xRo == 0L) {
      ac.i(TAG, "fp mUserName " + this.userName);
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.i.a.zBQ;
      this.sourceType = com.tencent.mm.plugin.story.i.a.dYi();
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bw.a)new ddq());
      paramString1.d((com.tencent.mm.bw.a)new ddr());
      paramString1.Am("/cgi-bin/micromsg-bin/mmstorydatedetail");
      paramString1.op(529);
      paramString1.or(0);
      paramString1.os(0);
      paramString1 = paramString1.aAz();
      d.g.b.k.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aBC();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      ac.i(TAG, "np mUserName " + this.userName);
    }
    paramString1 = (ddq)paramString1;
    paramString1.ncR = this.userName;
    paramString1.FJn = this.xRo;
    try
    {
      paramString2 = bs.eWc();
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
    paramString1.pAT = i;
    paramString1.EvH = this.xpb;
    if (this.xRo == 0L) {
      bool = true;
    }
    this.xRn = bool;
    this.zto = this.xRo;
    ac.i(TAG, "req.mUserName:" + paramString1.ncR + " req.MaxId:" + paramString1.FJn + " req.TimeZone:" + paramString1.pAT + " req.Date:" + paramString1.EvH);
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
    ac.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramq = this.rr.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    paramq = (ddr)paramq;
    this.xSH = paramq.FNn;
    ac.i(TAG, "objCount: " + paramq.FMU + ", expiredTime: " + paramq.DLH);
    if (paramq.FNm.isEmpty())
    {
      ac.d(TAG, "error: server give size zero");
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118805);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.story.f.n.zsw;
    n.a.b(this.userName, (List)paramq.FNm, this.sourceType);
    if (this.xRo == 0L)
    {
      paramq = paramq.FNm;
      d.g.b.k.g(paramq, "resp.StoryList");
      this.xRo = ((def)paramq.getFirst()).Id;
    }
    ac.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.xRo), Long.valueOf(this.xRp) });
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aVY("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
    AppMethodBeat.o(118805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.d
 * JD-Core Version:    0.7.0.1
 */