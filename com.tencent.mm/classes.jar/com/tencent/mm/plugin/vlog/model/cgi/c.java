package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "uin", "businessId", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "(JJJLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  private static final String TAG;
  public static final a Ubs;
  private mf Ubt;
  private mh Ubu;
  private h callback;
  private com.tencent.mm.am.c nao;
  
  static
  {
    AppMethodBeat.i(110966);
    Ubs = new a((byte)0);
    TAG = "MicroMsg.NetSceneVideoReport";
    AppMethodBeat.o(110966);
  }
  
  public c(long paramLong1, long paramLong2, long paramLong3, List<? extends me> paramList)
  {
    AppMethodBeat.i(110965);
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = ((a)new mf());
    ((com.tencent.mm.am.c.a)localObject).otF = ((a)new mh());
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/spr-bin/behaviorvlog";
    ((com.tencent.mm.am.c.a)localObject).funcId = 3525;
    localObject = ((com.tencent.mm.am.c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((com.tencent.mm.am.c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogReq");
      AppMethodBeat.o(110965);
      throw paramList;
    }
    this.Ubt = ((mf)localObject);
    localObject = new mg();
    ((mg)localObject).YNz = paramLong1;
    ((mg)localObject).uin = paramLong2;
    ((mg)localObject).YNA = paramLong3;
    ((mg)localObject).YNB.addAll((Collection)paramList);
    this.Ubt.YNy = ((mg)localObject);
    Log.i(TAG, "LogVlog: report vlog " + paramLong1 + ' ' + paramList.size());
    AppMethodBeat.o(110965);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(110963);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(110963);
    return i;
  }
  
  public final int getType()
  {
    return 3525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110964);
    Log.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    params = c.c.b(((com.tencent.mm.am.c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    this.Ubu = ((mh)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(110964);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */