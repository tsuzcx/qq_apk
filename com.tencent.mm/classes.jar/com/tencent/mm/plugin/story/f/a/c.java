package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.h.e;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.eni;
import com.tencent.mm.protocal.protobuf.enj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends q
  implements m
{
  public static final a LHE;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  private eng LHC;
  public final com.tencent.mm.plugin.story.f.b.a LHD;
  public i callback;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(118803);
    LHE = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, eng parameng, String paramString2, com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.LHC = parameng;
    this.LHD = parama;
    parameng = new d.a();
    parameng.c((com.tencent.mm.cd.a)new eni());
    parameng.d((com.tencent.mm.cd.a)new enj());
    parameng.TW("/cgi-bin/micromsg-bin/mmstorycomment");
    parameng.vD(354);
    parameng.vF(0);
    parameng.vG(0);
    parameng = parameng.bgN();
    p.j(parameng, "builder.buildInstance()");
    this.rr = parameng;
    parameng = this.rr.bhX();
    if (parameng == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    parameng = (eni)parameng;
    parameng.lps = paramString1;
    parameng.Uqe = this.LHC;
    paramString1 = h.LOJ;
    parameng.Uqg = ((int)h.geE().amS());
    paramString1 = h.LOJ;
    parameng.Uqh = ((int)h.geE().amT());
    parameng.SessionId = paramString2;
    Log.i(TAG, "ClientId " + parameng.lps + " PreviewEnterScene " + parameng.Uqg + " sessionID: " + parameng.SessionId + ' ');
    AppMethodBeat.o(118802);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118800);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(118800);
    return i;
  }
  
  public final int getType()
  {
    return 354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(118801);
    Log.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = (CharSequence)this.LHC.lpy;
      if (params != null)
      {
        paramInt1 = i;
        if (params.length() != 0) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        params = e.LOi;
        e.gex();
        if (paramInt2 == 4)
        {
          params = e.LOi;
          e.gez();
        }
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118801);
      return;
      params = e.LOi;
      e.gey();
      if (paramInt2 == 4)
      {
        params = e.LOi;
        e.geA();
        continue;
        params = (CharSequence)this.LHC.lpy;
        if ((params == null) || (params.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          params = e.LOi;
          e.gev();
          break;
        }
        label233:
        params = e.LOi;
        e.gew();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */