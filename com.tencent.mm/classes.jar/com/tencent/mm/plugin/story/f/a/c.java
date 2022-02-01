package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  public static final a ygn;
  public g callback;
  public final b rr;
  private cxy ygl;
  public final com.tencent.mm.plugin.story.f.b.a ygm;
  
  static
  {
    AppMethodBeat.i(118803);
    ygn = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, cxy paramcxy, String paramString2, com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.ygl = paramcxy;
    this.ygm = parama;
    paramcxy = new b.a();
    paramcxy.c((com.tencent.mm.bx.a)new cya());
    paramcxy.d((com.tencent.mm.bx.a)new cyb());
    paramcxy.wg("/cgi-bin/micromsg-bin/mmstorycomment");
    paramcxy.nB(354);
    paramcxy.nD(0);
    paramcxy.nE(0);
    paramcxy = paramcxy.atI();
    d.g.b.k.g(paramcxy, "builder.buildInstance()");
    this.rr = paramcxy;
    paramcxy = this.rr.auL();
    if (paramcxy == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    paramcxy = (cya)paramcxy;
    paramcxy.gKn = paramString1;
    paramcxy.Eqf = this.ygl;
    paramString1 = h.ynv;
    paramcxy.Eqh = ((int)h.dJj().QS());
    paramString1 = h.ynv;
    paramcxy.Eqi = ((int)h.dJj().QT());
    paramcxy.CzY = paramString2;
    ad.i(TAG, "ClientId " + paramcxy.gKn + " PreviewEnterScene " + paramcxy.Eqh + " sessionID: " + paramcxy.CzY + ' ');
    AppMethodBeat.o(118802);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(118800);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
      paramq = (CharSequence)this.ygl.gKr;
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
        paramq = com.tencent.mm.plugin.story.h.e.ymV;
        com.tencent.mm.plugin.story.h.e.dJc();
        if (paramInt2 == 4)
        {
          paramq = com.tencent.mm.plugin.story.h.e.ymV;
          com.tencent.mm.plugin.story.h.e.dJe();
        }
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(118801);
      return;
      paramq = com.tencent.mm.plugin.story.h.e.ymV;
      com.tencent.mm.plugin.story.h.e.dJd();
      if (paramInt2 == 4)
      {
        paramq = com.tencent.mm.plugin.story.h.e.ymV;
        com.tencent.mm.plugin.story.h.e.dJf();
        continue;
        paramq = (CharSequence)this.ygl.gKr;
        if ((paramq == null) || (paramq.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          paramq = com.tencent.mm.plugin.story.h.e.ymV;
          com.tencent.mm.plugin.story.h.e.dJa();
          break;
        }
        label233:
        paramq = com.tencent.mm.plugin.story.h.e.ymV;
        com.tencent.mm.plugin.story.h.e.dJb();
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */