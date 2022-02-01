package com.tencent.mm.plugin.story.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.story.g.e;
import com.tencent.mm.protocal.protobuf.fie;
import com.tencent.mm.protocal.protobuf.fig;
import com.tencent.mm.protocal.protobuf.fih;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "clientId", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  public static final c.a Sle;
  private static final String TAG;
  private fie Slf;
  public final com.tencent.mm.plugin.story.model.b.a Slg;
  public com.tencent.mm.am.h callback;
  public final com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(118803);
    Sle = new c.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryComment";
    AppMethodBeat.o(118803);
  }
  
  public c(String paramString1, fie paramfie, String paramString2, com.tencent.mm.plugin.story.model.b.a parama)
  {
    AppMethodBeat.i(118802);
    this.Slf = paramfie;
    this.Slg = parama;
    paramfie = new com.tencent.mm.am.c.a();
    paramfie.otE = ((com.tencent.mm.bx.a)new fig());
    paramfie.otF = ((com.tencent.mm.bx.a)new fih());
    paramfie.uri = "/cgi-bin/micromsg-bin/mmstorycomment";
    paramfie.funcId = 354;
    paramfie.otG = 0;
    paramfie.respCmdId = 0;
    paramfie = paramfie.bEF();
    kotlin.g.b.s.s(paramfie, "builder.buildInstance()");
    this.rr = paramfie;
    paramfie = c.b.b(this.rr.otB);
    if (paramfie == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
      AppMethodBeat.o(118802);
      throw paramString1;
    }
    paramfie = (fig)paramfie;
    paramfie.nUv = paramString1;
    paramfie.abJd = this.Slf;
    paramString1 = com.tencent.mm.plugin.story.g.h.SqZ;
    paramfie.abJf = ((int)com.tencent.mm.plugin.story.g.h.hxW().jjn);
    paramString1 = com.tencent.mm.plugin.story.g.h.SqZ;
    paramfie.abJg = ((int)com.tencent.mm.plugin.story.g.h.hxW().jkC);
    paramfie.SessionId = paramString2;
    Log.i(TAG, "ClientId " + paramfie.nUv + " PreviewEnterScene " + paramfie.abJf + " sessionID: " + paramfie.SessionId + ' ');
    AppMethodBeat.o(118802);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(118800);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    kotlin.g.b.s.u(paramh, "<set-?>");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(118800);
    return i;
  }
  
  public final int getType()
  {
    return 354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(118801);
    Log.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = (CharSequence)this.Slf.nUB;
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
        params = e.SqW;
        e.hxP();
        if (paramInt2 == 4)
        {
          params = e.SqW;
          e.hxR();
        }
        params = this.callback;
        if (params == null) {
          break label241;
        }
      }
    }
    for (;;)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(118801);
      return;
      params = e.SqW;
      e.hxQ();
      if (paramInt2 != 4) {
        break;
      }
      params = e.SqW;
      e.hxS();
      break;
      params = (CharSequence)this.Slf.nUB;
      if ((params == null) || (params.length() == 0)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label230;
        }
        params = e.SqW;
        e.hxN();
        break;
      }
      label230:
      params = e.SqW;
      e.hxO();
      break;
      label241:
      kotlin.g.b.s.bIx("callback");
      params = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.c
 * JD-Core Version:    0.7.0.1
 */