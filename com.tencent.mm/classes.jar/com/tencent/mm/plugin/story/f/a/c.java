package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends n
  implements k
{
  public static final c.a BcK;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  private djs BcI;
  public final com.tencent.mm.plugin.story.f.b.a BcJ;
  public f callback;
  public final b rr;
  
  static
  {
    AppMethodBeat.i(118803);
    BcK = new c.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, djs paramdjs, String paramString2, com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.BcI = paramdjs;
    this.BcJ = parama;
    paramdjs = new b.a();
    paramdjs.c((com.tencent.mm.bw.a)new dju());
    paramdjs.d((com.tencent.mm.bw.a)new djv());
    paramdjs.DN("/cgi-bin/micromsg-bin/mmstorycomment");
    paramdjs.oS(354);
    paramdjs.oU(0);
    paramdjs.oV(0);
    paramdjs = paramdjs.aDS();
    p.g(paramdjs, "builder.buildInstance()");
    this.rr = paramdjs;
    paramdjs = this.rr.aEU();
    if (paramdjs == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    paramdjs = (dju)paramdjs;
    paramdjs.hFO = paramString1;
    paramdjs.HRD = this.BcI;
    paramString1 = h.BjR;
    paramdjs.HRF = ((int)h.enI().TH());
    paramString1 = h.BjR;
    paramdjs.HRG = ((int)h.enI().TI());
    paramdjs.FQl = paramString2;
    ae.i(TAG, "ClientId " + paramdjs.hFO + " PreviewEnterScene " + paramdjs.HRF + " sessionID: " + paramdjs.FQl + ' ');
    AppMethodBeat.o(118802);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(118800);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(118800);
    return i;
  }
  
  public final int getType()
  {
    return 354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(118801);
    ae.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = (CharSequence)this.BcI.hFS;
      if (paramq != null)
      {
        paramInt1 = i;
        if (paramq.length() != 0) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        paramq = com.tencent.mm.plugin.story.h.e.Bjr;
        com.tencent.mm.plugin.story.h.e.enB();
        if (paramInt2 == 4)
        {
          paramq = com.tencent.mm.plugin.story.h.e.Bjr;
          com.tencent.mm.plugin.story.h.e.enD();
        }
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(118801);
      return;
      paramq = com.tencent.mm.plugin.story.h.e.Bjr;
      com.tencent.mm.plugin.story.h.e.enC();
      if (paramInt2 == 4)
      {
        paramq = com.tencent.mm.plugin.story.h.e.Bjr;
        com.tencent.mm.plugin.story.h.e.enE();
        continue;
        paramq = (CharSequence)this.BcI.hFS;
        if ((paramq == null) || (paramq.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          paramq = com.tencent.mm.plugin.story.h.e.Bjr;
          com.tencent.mm.plugin.story.h.e.enz();
          break;
        }
        label233:
        paramq = com.tencent.mm.plugin.story.h.e.Bjr;
        com.tencent.mm.plugin.story.h.e.enA();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */