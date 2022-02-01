package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqId", "", "uin", "businessId", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "serverConf", "Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;", "reqNum", "reqOffset", "debugNeeded", "", "sid", "fid", "(JJILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;IIZII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class a
  extends q
  implements m
{
  public static final a GAf;
  private bgx GAd;
  public bgz GAe;
  private i callback;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(110958);
    GAf = new a((byte)0);
    AppMethodBeat.o(110958);
  }
  
  public a(long paramLong1, long paramLong2, LinkedList<cmt> paramLinkedList, dus paramdus, int paramInt)
  {
    AppMethodBeat.i(110957);
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new bgx());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new bgz());
    ((d.a)localObject).sG(1469);
    ((d.a)localObject).MB("/cgi-bin/spr-bin/generatevlog");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sI(0);
    Log.d("MicroMsg.NetSceneGenerateVlog", "GenerateVlog with reqId: " + paramLong1 + ", uin: " + paramLong2 + ", businessId: 1, materials: " + paramLinkedList.size() + ", sid: " + paramInt + ", fid: 0");
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramLinkedList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogReq");
      AppMethodBeat.o(110957);
      throw paramLinkedList;
    }
    this.GAd = ((bgx)localObject);
    localObject = new bgy();
    ((bgy)localObject).KPk = paramLong1;
    ((bgy)localObject).uin = paramLong2;
    ((bgy)localObject).KPl = 1L;
    ((bgy)localObject).GzC = paramLinkedList;
    ((bgy)localObject).LQH = paramdus;
    ((bgy)localObject).LQI = 10L;
    ((bgy)localObject).LQJ = 0L;
    ((bgy)localObject).KPn = true;
    ((bgy)localObject).LQL = paramInt;
    ((bgy)localObject).LQM = 0L;
    this.GAd.LQG = ((bgy)localObject);
    this.GAd.setBaseRequest(com.tencent.mm.protocal.l.a(this.hJu.getReqObj()));
    AppMethodBeat.o(110957);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(110955);
    Log.i("MicroMsg.NetSceneGenerateVlog", "do scene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(110955);
    return i;
  }
  
  public final int getType()
  {
    return 1469;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110956);
    Log.i("MicroMsg.NetSceneGenerateVlog", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    this.GAe = ((bgz)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(110956);
      return;
    }
    AppMethodBeat.o(110956);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */