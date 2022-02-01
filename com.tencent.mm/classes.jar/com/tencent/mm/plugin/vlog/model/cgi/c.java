package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "uin", "businessId", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "(JJJLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  public static final c.a App;
  private static final String TAG = "MicroMsg.NetSceneVideoReport";
  private ko Apn;
  private kq Apo;
  private g callback;
  private b gvE;
  
  static
  {
    AppMethodBeat.i(110966);
    App = new c.a((byte)0);
    TAG = "MicroMsg.NetSceneVideoReport";
    AppMethodBeat.o(110966);
  }
  
  public c(long paramLong1, long paramLong2, long paramLong3, List<? extends kn> paramList)
  {
    AppMethodBeat.i(110965);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ko());
    ((b.a)localObject).d((a)new kq());
    ((b.a)localObject).Am("/cgi-bin/spr-bin/behaviorvlog");
    ((b.a)localObject).op(3525);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogReq");
      AppMethodBeat.o(110965);
      throw paramList;
    }
    this.Apn = ((ko)localObject);
    localObject = new kp();
    ((kp)localObject).DXI = paramLong1;
    ((kp)localObject).uin = paramLong2;
    ((kp)localObject).DXJ = paramLong3;
    ((kp)localObject).DXK.addAll((Collection)paramList);
    this.Apn.DXH = ((kp)localObject);
    ac.i(TAG, "LogVlog: report vlog " + paramLong1 + ' ' + paramList.size());
    AppMethodBeat.o(110965);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(110963);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
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
    ac.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    this.Apo = ((kq)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110964);
      return;
    }
    AppMethodBeat.o(110964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */