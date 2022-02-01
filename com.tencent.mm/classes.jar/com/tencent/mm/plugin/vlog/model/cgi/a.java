package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.v;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqId", "", "uin", "businessId", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "serverConf", "Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;", "reqNum", "reqOffset", "debugNeeded", "", "sid", "fid", "(JJILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;IIZII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class a
  extends n
  implements k
{
  public static final a BGZ;
  private aux BGX;
  public auz BGY;
  private f callback;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(110958);
    BGZ = new a((byte)0);
    AppMethodBeat.o(110958);
  }
  
  public a(long paramLong1, long paramLong2, LinkedList<byf> paramLinkedList, dau paramdau, int paramInt)
  {
    AppMethodBeat.i(110957);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bx.a)new aux());
    ((b.a)localObject).d((com.tencent.mm.bx.a)new auz());
    ((b.a)localObject).oP(1469);
    ((b.a)localObject).Dl("/cgi-bin/spr-bin/generatevlog");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oR(0);
    ad.d("MicroMsg.NetSceneGenerateVlog", "GenerateVlog with reqId: " + paramLong1 + ", uin: " + paramLong2 + ", businessId: 1, materials: " + paramLinkedList.size() + ", sid: " + paramInt + ", fid: 0");
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramLinkedList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogReq");
      AppMethodBeat.o(110957);
      throw paramLinkedList;
    }
    this.BGX = ((aux)localObject);
    localObject = new auy();
    ((auy)localObject).FDe = paramLong1;
    ((auy)localObject).uin = paramLong2;
    ((auy)localObject).FDf = 1L;
    ((auy)localObject).BGy = paramLinkedList;
    ((auy)localObject).Gtd = paramdau;
    ((auy)localObject).Gte = 10L;
    ((auy)localObject).Gtf = 0L;
    ((auy)localObject).FDh = true;
    ((auy)localObject).Gth = paramInt;
    ((auy)localObject).Gti = 0L;
    this.BGX.Gtc = ((auy)localObject);
    this.BGX.setBaseRequest(com.tencent.mm.protocal.l.a(this.gPp.getReqObj()));
    AppMethodBeat.o(110957);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110955);
    ad.i("MicroMsg.NetSceneGenerateVlog", "do scene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
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
    ad.i("MicroMsg.NetSceneGenerateVlog", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    this.BGY = ((auz)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110956);
      return;
    }
    AppMethodBeat.o(110956);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */