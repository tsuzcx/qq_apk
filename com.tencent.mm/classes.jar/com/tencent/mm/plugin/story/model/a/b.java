package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryAudioReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "feedbackList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicFeedback;", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends m
  implements k
{
  private static final String TAG = "MicroMsg.NetSceneStoryAudioReport";
  public static final b.a swZ;
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(109208);
    swZ = new b.a((byte)0);
    TAG = "MicroMsg.NetSceneStoryAudioReport";
    AppMethodBeat.o(109208);
  }
  
  public b(long paramLong, List<? extends bsp> paramList)
  {
    AppMethodBeat.i(109207);
    Object localObject = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject).a((a)new bum());
    ((com.tencent.mm.ai.b.a)localObject).b((a)new bun());
    ((com.tencent.mm.ai.b.a)localObject).rl("/cgi-bin/micromsg-bin/reportrecommendedmusicfeedback");
    ((com.tencent.mm.ai.b.a)localObject).kT(298);
    localObject = ((com.tencent.mm.ai.b.a)localObject).ado();
    j.p(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ai.b)localObject);
    localObject = this.rr.adm();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ReportRecommendedMusicFeedbackRequest");
      AppMethodBeat.o(109207);
      throw paramList;
    }
    localObject = (bum)localObject;
    ((bum)localObject).swu = paramLong;
    ((bum)localObject).xHH.addAll((Collection)paramList);
    ab.i(TAG, "LogStory: report music " + paramLong + ' ' + paramList.size());
    AppMethodBeat.o(109207);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(109205);
    j.q(parame, "dispatcher");
    j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(109205);
    return i;
  }
  
  public final int getType()
  {
    return 298;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109206);
    ab.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109206);
      return;
    }
    AppMethodBeat.o(109206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.b
 * JD-Core Version:    0.7.0.1
 */