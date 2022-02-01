package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "uin", "businessId", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "(JJJLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/BehaviorVlogResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class c
  extends q
  implements m
{
  public static final a GAl;
  private static final String TAG = "MicroMsg.NetSceneVideoReport";
  private lo GAj;
  private lq GAk;
  private i callback;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(110966);
    GAl = new a((byte)0);
    TAG = "MicroMsg.NetSceneVideoReport";
    AppMethodBeat.o(110966);
  }
  
  public c(long paramLong1, long paramLong2, long paramLong3, List<? extends ln> paramList)
  {
    AppMethodBeat.i(110965);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new lo());
    ((d.a)localObject).d((a)new lq());
    ((d.a)localObject).MB("/cgi-bin/spr-bin/behaviorvlog");
    ((d.a)localObject).sG(3525);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogReq");
      AppMethodBeat.o(110965);
      throw paramList;
    }
    this.GAj = ((lo)localObject);
    localObject = new lp();
    ((lp)localObject).KPk = paramLong1;
    ((lp)localObject).uin = paramLong2;
    ((lp)localObject).KPl = paramLong3;
    ((lp)localObject).KPm.addAll((Collection)paramList);
    this.GAj.KPj = ((lp)localObject);
    Log.i(TAG, "LogVlog: report vlog " + paramLong1 + ' ' + paramList.size());
    AppMethodBeat.o(110965);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(110963);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(110963);
    return i;
  }
  
  public final int getType()
  {
    return 3525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110964);
    Log.i(TAG, "onGYNetEnd " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString);
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BehaviorVlogResp");
      AppMethodBeat.o(110964);
      throw paramString;
    }
    this.GAk = ((lq)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(110964);
      return;
    }
    AppMethodBeat.o(110964);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneVlogReport$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */