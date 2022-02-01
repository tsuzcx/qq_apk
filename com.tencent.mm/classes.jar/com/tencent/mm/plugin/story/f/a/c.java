package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.h.e;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.protocal.protobuf.edi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends q
  implements m
{
  public static final a FnC;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  private edf FnA;
  public final com.tencent.mm.plugin.story.f.b.a FnB;
  public i callback;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(118803);
    FnC = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, edf paramedf, String paramString2, com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.FnA = paramedf;
    this.FnB = parama;
    paramedf = new d.a();
    paramedf.c((com.tencent.mm.bw.a)new edh());
    paramedf.d((com.tencent.mm.bw.a)new edi());
    paramedf.MB("/cgi-bin/micromsg-bin/mmstorycomment");
    paramedf.sG(354);
    paramedf.sI(0);
    paramedf.sJ(0);
    paramedf = paramedf.aXF();
    p.g(paramedf, "builder.buildInstance()");
    this.rr = paramedf;
    paramedf = this.rr.aYJ();
    if (paramedf == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    paramedf = (edh)paramedf;
    paramedf.izX = paramString1;
    paramedf.NdH = this.FnA;
    paramString1 = h.FuH;
    paramedf.NdJ = ((int)h.fqi().ahw());
    paramString1 = h.FuH;
    paramedf.NdK = ((int)h.fqi().ahx());
    paramedf.SessionId = paramString2;
    Log.i(TAG, "ClientId " + paramedf.izX + " PreviewEnterScene " + paramedf.NdJ + " sessionID: " + paramedf.SessionId + ' ');
    AppMethodBeat.o(118802);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118800);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
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
      params = (CharSequence)this.FnA.iAc;
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
        params = e.Fuh;
        e.fqb();
        if (paramInt2 == 4)
        {
          params = e.Fuh;
          e.fqd();
        }
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118801);
      return;
      params = e.Fuh;
      e.fqc();
      if (paramInt2 == 4)
      {
        params = e.Fuh;
        e.fqe();
        continue;
        params = (CharSequence)this.FnA.iAc;
        if ((params == null) || (params.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          params = e.Fuh;
          e.fpZ();
          break;
        }
        label233:
        params = e.Fuh;
        e.fqa();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */