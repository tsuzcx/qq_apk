package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "uin", "businessId", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "(JJJLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class c
  extends n
  implements k
{
  public static final a BYE;
  private static final String TAG = "MicroMsg.NetSceneVideoReport";
  private kx BYC;
  private kz BYD;
  private f callback;
  private b gRX;
  
  static
  {
    AppMethodBeat.i(110966);
    BYE = new a((byte)0);
    TAG = "MicroMsg.NetSceneVideoReport";
    AppMethodBeat.o(110966);
  }
  
  public c(long paramLong1, long paramLong2, long paramLong3, List<? extends kw> paramList)
  {
    AppMethodBeat.i(110965);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new kx());
    ((b.a)localObject).d((a)new kz());
    ((b.a)localObject).DN("/cgi-bin/spr-bin/behaviorvlog");
    ((b.a)localObject).oS(3525);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogReq");
      AppMethodBeat.o(110965);
      throw paramList;
    }
    this.BYC = ((kx)localObject);
    localObject = new ky();
    ((ky)localObject).FVz = paramLong1;
    ((ky)localObject).uin = paramLong2;
    ((ky)localObject).FVA = paramLong3;
    ((ky)localObject).FVB.addAll((Collection)paramList);
    this.BYC.FVy = ((ky)localObject);
    ae.i(TAG, "LogVlog: report vlog " + paramLong1 + ' ' + paramList.size());
    AppMethodBeat.o(110965);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110963);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(110963);
    return i;
  }
  
  public final int getType()
  {
    return 3525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110964);
    ae.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    this.BYD = ((kz)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110964);
      return;
    }
    AppMethodBeat.o(110964);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */