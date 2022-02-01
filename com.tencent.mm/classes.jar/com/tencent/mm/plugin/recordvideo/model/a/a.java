package com.tencent.mm.plugin.recordvideo.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/cgi/NetSceneStoryAudioReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "feedbackList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-recordvideo_release"})
public final class a
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.NetSceneStoryAudioReport";
  public static final a xPL;
  private f callback;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(75450);
    xPL = new a((byte)0);
    TAG = "MicroMsg.NetSceneStoryAudioReport";
    AppMethodBeat.o(75450);
  }
  
  public a(long paramLong, List<? extends bxw> paramList)
  {
    AppMethodBeat.i(75449);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new bxz());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new bya());
    ((b.a)localObject).DN("/cgi-bin/spr-bin/mmsprreportrecommendedmusicfeedback");
    ((b.a)localObject).oS(3822);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMSPRReportRecommendedMusicFeedbackRequest");
      AppMethodBeat.o(75449);
      throw paramList;
    }
    localObject = (bxz)localObject;
    ((bxz)localObject).xPa = paramLong;
    ((bxz)localObject).HkP.addAll((Collection)paramList);
    ae.i(TAG, "LogStory: report music " + paramLong + ' ' + paramList.size());
    AppMethodBeat.o(75449);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(75447);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(75447);
    return i;
  }
  
  public final int getType()
  {
    return 3822;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75448);
    ae.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(75448);
      return;
    }
    AppMethodBeat.o(75448);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/cgi/NetSceneStoryAudioReport$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a.a
 * JD-Core Version:    0.7.0.1
 */