package com.tencent.mm.plugin.recordvideo.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/cgi/NetSceneStoryAudioReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "feedbackList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-recordvideo_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.NetSceneStoryAudioReport";
  public static final a vjm;
  private g callback;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(75450);
    vjm = new a((byte)0);
    TAG = "MicroMsg.NetSceneStoryAudioReport";
    AppMethodBeat.o(75450);
  }
  
  public a(long paramLong, List<? extends bnz> paramList)
  {
    AppMethodBeat.i(75449);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bx.a)new boc());
    ((b.a)localObject).d((com.tencent.mm.bx.a)new bod());
    ((b.a)localObject).wg("/cgi-bin/spr-bin/mmsprreportrecommendedmusicfeedback");
    ((b.a)localObject).nB(3822);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMSPRReportRecommendedMusicFeedbackRequest");
      AppMethodBeat.o(75449);
      throw paramList;
    }
    localObject = (boc)localObject;
    ((boc)localObject).viE = paramLong;
    ((boc)localObject).DLx.addAll((Collection)paramList);
    ad.i(TAG, "LogStory: report music " + paramLong + ' ' + paramList.size());
    AppMethodBeat.o(75449);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(75447);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    ad.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(75448);
      return;
    }
    AppMethodBeat.o(75448);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/cgi/NetSceneStoryAudioReport$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a.a
 * JD-Core Version:    0.7.0.1
 */