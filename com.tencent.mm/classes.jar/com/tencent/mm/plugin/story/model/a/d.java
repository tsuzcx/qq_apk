package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d
  extends m
  implements k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
  public static final d.a sxd;
  public com.tencent.mm.ai.f callback;
  public final b rr;
  private cgw sxb;
  public final com.tencent.mm.plugin.story.model.b.a sxc;
  
  static
  {
    AppMethodBeat.i(109216);
    sxd = new d.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(109216);
  }
  
  public d(String paramString1, cgw paramcgw, String paramString2, com.tencent.mm.plugin.story.model.b.a parama)
  {
    AppMethodBeat.i(138749);
    this.sxb = paramcgw;
    this.sxc = parama;
    paramcgw = new b.a();
    paramcgw.a((com.tencent.mm.bv.a)new cgy());
    paramcgw.b((com.tencent.mm.bv.a)new cgz());
    paramcgw.rl("/cgi-bin/micromsg-bin/mmstorycomment");
    paramcgw.kT(354);
    paramcgw.kU(0);
    paramcgw.kV(0);
    paramcgw = paramcgw.ado();
    j.p(paramcgw, "builder.buildInstance()");
    this.rr = paramcgw;
    paramcgw = this.rr.adm();
    if (paramcgw == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(138749);
      throw paramString1;
    }
    paramcgw = (cgy)paramcgw;
    paramcgw.pIw = paramString1;
    paramcgw.xRL = this.sxb;
    paramString1 = i.sFa;
    paramcgw.xRN = ((int)i.cDo().FF());
    paramString1 = i.sFa;
    paramcgw.xRO = ((int)i.cDo().FG());
    paramcgw.wqN = paramString2;
    ab.i(TAG, "ClientId " + paramcgw.pIw + " PreviewEnterScene " + paramcgw.xRN + " sessionID: " + paramcgw.wqN + ' ');
    AppMethodBeat.o(138749);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(109213);
    j.q(parame, "dispatcher");
    j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(109213);
    return i;
  }
  
  public final int getType()
  {
    return 354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(109214);
    ab.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = (CharSequence)this.sxb.ntu;
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
        paramq = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.cCW();
        if (paramInt2 == 4)
        {
          paramq = com.tencent.mm.plugin.story.g.f.sEx;
          com.tencent.mm.plugin.story.g.f.cCY();
        }
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109214);
      return;
      paramq = com.tencent.mm.plugin.story.g.f.sEx;
      com.tencent.mm.plugin.story.g.f.cCX();
      if (paramInt2 == 4)
      {
        paramq = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.cCZ();
        continue;
        paramq = (CharSequence)this.sxb.ntu;
        if ((paramq == null) || (paramq.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label233;
          }
          paramq = com.tencent.mm.plugin.story.g.f.sEx;
          com.tencent.mm.plugin.story.g.f.cCU();
          break;
        }
        label233:
        paramq = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.cCV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.d
 * JD-Core Version:    0.7.0.1
 */