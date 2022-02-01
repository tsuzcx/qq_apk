package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.v;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqId", "", "uin", "businessId", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "serverConf", "Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;", "reqNum", "reqOffset", "debugNeeded", "", "sid", "fid", "(JJILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;IIZII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class a
  extends n
  implements k
{
  public static final a BYy;
  private avn BYw;
  public avp BYx;
  private f callback;
  private b gRX;
  
  static
  {
    AppMethodBeat.i(110958);
    BYy = new a((byte)0);
    AppMethodBeat.o(110958);
  }
  
  public a(long paramLong1, long paramLong2, LinkedList<byz> paramLinkedList, dbo paramdbo, int paramInt)
  {
    AppMethodBeat.i(110957);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new avn());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new avp());
    ((b.a)localObject).oS(1469);
    ((b.a)localObject).DN("/cgi-bin/spr-bin/generatevlog");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oU(0);
    ae.d("MicroMsg.NetSceneGenerateVlog", "GenerateVlog with reqId: " + paramLong1 + ", uin: " + paramLong2 + ", businessId: 1, materials: " + paramLinkedList.size() + ", sid: " + paramInt + ", fid: 0");
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramLinkedList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogReq");
      AppMethodBeat.o(110957);
      throw paramLinkedList;
    }
    this.BYw = ((avn)localObject);
    localObject = new avo();
    ((avo)localObject).FVz = paramLong1;
    ((avo)localObject).uin = paramLong2;
    ((avo)localObject).FVA = 1L;
    ((avo)localObject).BXX = paramLinkedList;
    ((avo)localObject).GMB = paramdbo;
    ((avo)localObject).GMC = 10L;
    ((avo)localObject).GMD = 0L;
    ((avo)localObject).FVC = true;
    ((avo)localObject).GMF = paramInt;
    ((avo)localObject).GMG = 0L;
    this.BYw.GMA = ((avo)localObject);
    this.BYw.setBaseRequest(com.tencent.mm.protocal.l.a(this.gRX.getReqObj()));
    AppMethodBeat.o(110957);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110955);
    ae.i("MicroMsg.NetSceneGenerateVlog", "do scene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(110955);
    return i;
  }
  
  public final int getType()
  {
    return 1469;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110956);
    ae.i("MicroMsg.NetSceneGenerateVlog", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    this.BYx = ((avp)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110956);
      return;
    }
    AppMethodBeat.o(110956);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */