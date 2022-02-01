package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "uin", "businessId", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "(JJJLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class c
  extends n
  implements k
{
  public static final a BHf;
  private static final String TAG = "MicroMsg.NetSceneVideoReport";
  private kx BHd;
  private kz BHe;
  private f callback;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(110966);
    BHf = new a((byte)0);
    TAG = "MicroMsg.NetSceneVideoReport";
    AppMethodBeat.o(110966);
  }
  
  public c(long paramLong1, long paramLong2, long paramLong3, List<? extends kw> paramList)
  {
    AppMethodBeat.i(110965);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new kx());
    ((b.a)localObject).d((a)new kz());
    ((b.a)localObject).Dl("/cgi-bin/spr-bin/behaviorvlog");
    ((b.a)localObject).oP(3525);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogReq");
      AppMethodBeat.o(110965);
      throw paramList;
    }
    this.BHd = ((kx)localObject);
    localObject = new ky();
    ((ky)localObject).FDe = paramLong1;
    ((ky)localObject).uin = paramLong2;
    ((ky)localObject).FDf = paramLong3;
    ((ky)localObject).FDg.addAll((Collection)paramList);
    this.BHd.FDd = ((ky)localObject);
    ad.i(TAG, "LogVlog: report vlog " + paramLong1 + ' ' + paramList.size());
    AppMethodBeat.o(110965);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110963);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
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
    ad.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    this.BHe = ((kz)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110964);
      return;
    }
    AppMethodBeat.o(110964);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */