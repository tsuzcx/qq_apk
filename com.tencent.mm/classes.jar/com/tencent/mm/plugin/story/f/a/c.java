package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ddn;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  public static final c.a ztn;
  public g callback;
  public final b rr;
  private ddk ztl;
  public final com.tencent.mm.plugin.story.f.b.a ztm;
  
  static
  {
    AppMethodBeat.i(118803);
    ztn = new c.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, ddk paramddk, String paramString2, com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.ztl = paramddk;
    this.ztm = parama;
    paramddk = new b.a();
    paramddk.c((com.tencent.mm.bw.a)new ddm());
    paramddk.d((com.tencent.mm.bw.a)new ddn());
    paramddk.Am("/cgi-bin/micromsg-bin/mmstorycomment");
    paramddk.op(354);
    paramddk.or(0);
    paramddk.os(0);
    paramddk = paramddk.aAz();
    d.g.b.k.g(paramddk, "builder.buildInstance()");
    this.rr = paramddk;
    paramddk = this.rr.aBC();
    if (paramddk == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    paramddk = (ddm)paramddk;
    paramddk.hkN = paramString1;
    paramddk.FNh = this.ztl;
    paramString1 = h.zAU;
    paramddk.FNj = ((int)h.dXK().Ru());
    paramString1 = h.zAU;
    paramddk.FNk = ((int)h.dXK().Rv());
    paramddk.DSu = paramString2;
    ac.i(TAG, "ClientId " + paramddk.hkN + " PreviewEnterScene " + paramddk.FNj + " sessionID: " + paramddk.DSu + ' ');
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
    ac.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = (CharSequence)this.ztl.hkR;
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
        paramq = com.tencent.mm.plugin.story.h.e.zAu;
        com.tencent.mm.plugin.story.h.e.dXD();
        if (paramInt2 == 4)
        {
          paramq = com.tencent.mm.plugin.story.h.e.zAu;
          com.tencent.mm.plugin.story.h.e.dXF();
        }
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(118801);
      return;
      paramq = com.tencent.mm.plugin.story.h.e.zAu;
      com.tencent.mm.plugin.story.h.e.dXE();
      if (paramInt2 == 4)
      {
        paramq = com.tencent.mm.plugin.story.h.e.zAu;
        com.tencent.mm.plugin.story.h.e.dXG();
        continue;
        paramq = (CharSequence)this.ztl.hkR;
        if ((paramq == null) || (paramq.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          paramq = com.tencent.mm.plugin.story.h.e.zAu;
          com.tencent.mm.plugin.story.h.e.dXB();
          break;
        }
        label233:
        paramq = com.tencent.mm.plugin.story.h.e.zAu;
        com.tencent.mm.plugin.story.h.e.dXC();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */