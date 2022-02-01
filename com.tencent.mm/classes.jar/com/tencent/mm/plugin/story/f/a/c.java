package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends n
  implements k
{
  public static final c.a ALh;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  private dix ALf;
  public final com.tencent.mm.plugin.story.f.b.a ALg;
  public f callback;
  public final b rr;
  
  static
  {
    AppMethodBeat.i(118803);
    ALh = new c.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, dix paramdix, String paramString2, com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.ALf = paramdix;
    this.ALg = parama;
    paramdix = new b.a();
    paramdix.c((com.tencent.mm.bx.a)new diz());
    paramdix.d((com.tencent.mm.bx.a)new dja());
    paramdix.Dl("/cgi-bin/micromsg-bin/mmstorycomment");
    paramdix.oP(354);
    paramdix.oR(0);
    paramdix.oS(0);
    paramdix = paramdix.aDC();
    p.g(paramdix, "builder.buildInstance()");
    this.rr = paramdix;
    paramdix = this.rr.aEE();
    if (paramdix == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    paramdix = (diz)paramdix;
    paramdix.hCW = paramString1;
    paramdix.HxS = this.ALf;
    paramString1 = h.ASt;
    paramdix.HxU = ((int)h.ejZ().TB());
    paramString1 = h.ASt;
    paramdix.HxV = ((int)h.ejZ().TC());
    paramdix.FxN = paramString2;
    ad.i(TAG, "ClientId " + paramdix.hCW + " PreviewEnterScene " + paramdix.HxU + " sessionID: " + paramdix.FxN + ' ');
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
    ad.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = (CharSequence)this.ALf.hDa;
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
        paramq = com.tencent.mm.plugin.story.h.e.ART;
        com.tencent.mm.plugin.story.h.e.ejS();
        if (paramInt2 == 4)
        {
          paramq = com.tencent.mm.plugin.story.h.e.ART;
          com.tencent.mm.plugin.story.h.e.ejU();
        }
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(118801);
      return;
      paramq = com.tencent.mm.plugin.story.h.e.ART;
      com.tencent.mm.plugin.story.h.e.ejT();
      if (paramInt2 == 4)
      {
        paramq = com.tencent.mm.plugin.story.h.e.ART;
        com.tencent.mm.plugin.story.h.e.ejV();
        continue;
        paramq = (CharSequence)this.ALf.hDa;
        if ((paramq == null) || (paramq.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          paramq = com.tencent.mm.plugin.story.h.e.ART;
          com.tencent.mm.plugin.story.h.e.ejQ();
          break;
        }
        label233:
        paramq = com.tencent.mm.plugin.story.h.e.ART;
        com.tencent.mm.plugin.story.h.e.ejR();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */