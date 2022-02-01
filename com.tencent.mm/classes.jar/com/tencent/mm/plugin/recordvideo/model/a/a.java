package com.tencent.mm.plugin.recordvideo.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/cgi/NetSceneStoryAudioReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "feedbackList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-recordvideo_release"})
public final class a
  extends q
  implements m
{
  public static final a BPO;
  private static final String TAG = "MicroMsg.NetSceneStoryAudioReport";
  private i callback;
  private final d rr;
  
  static
  {
    AppMethodBeat.i(75450);
    BPO = new a((byte)0);
    TAG = "MicroMsg.NetSceneStoryAudioReport";
    AppMethodBeat.o(75450);
  }
  
  public a(long paramLong, List<? extends clo> paramList)
  {
    AppMethodBeat.i(75449);
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new clr());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new cls());
    ((d.a)localObject).MB("/cgi-bin/spr-bin/mmsprreportrecommendedmusicfeedback");
    ((d.a)localObject).sG(3822);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMSPRReportRecommendedMusicFeedbackRequest");
      AppMethodBeat.o(75449);
      throw paramList;
    }
    localObject = (clr)localObject;
    ((clr)localObject).BPd = paramLong;
    ((clr)localObject).Mrd.addAll((Collection)paramList);
    Log.i(TAG, "LogStory: report music " + paramLong + ' ' + paramList.size());
    AppMethodBeat.o(75449);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(75447);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(75447);
    return i;
  }
  
  public final int getType()
  {
    return 3822;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75448);
    Log.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(75448);
      return;
    }
    AppMethodBeat.o(75448);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/cgi/NetSceneStoryAudioReport$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a.a
 * JD-Core Version:    0.7.0.1
 */