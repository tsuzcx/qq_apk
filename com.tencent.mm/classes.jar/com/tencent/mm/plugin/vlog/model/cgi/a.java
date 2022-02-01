package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqId", "", "uin", "businessId", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "serverConf", "Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;", "reqNum", "reqOffset", "debugNeeded", "", "sid", "fid", "(JJILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;IIZII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  public static final a yZG;
  private g callback;
  private b iaa;
  private anx yZE;
  public anz yZF;
  
  static
  {
    AppMethodBeat.i(110958);
    yZG = new a((byte)0);
    AppMethodBeat.o(110958);
  }
  
  public a(long paramLong1, long paramLong2, LinkedList<bpb> paramLinkedList, cqb paramcqb, int paramInt)
  {
    AppMethodBeat.i(110957);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bx.a)new anx());
    ((b.a)localObject).d((com.tencent.mm.bx.a)new anz());
    ((b.a)localObject).nB(1469);
    ((b.a)localObject).wg("/cgi-bin/spr-bin/generatevlog");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nD(0);
    ad.d("MicroMsg.NetSceneGenerateVlog", "GenerateVlog with reqId: " + paramLong1 + ", uin: " + paramLong2 + ", businessId: 1, materials: " + paramLinkedList.size() + ", sid: " + paramInt + ", fid: 0");
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramLinkedList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogReq");
      AppMethodBeat.o(110957);
      throw paramLinkedList;
    }
    this.yZE = ((anx)localObject);
    localObject = new any();
    ((any)localObject).CFi = paramLong1;
    ((any)localObject).uin = paramLong2;
    ((any)localObject).CFj = 1L;
    ((any)localObject).zcd = paramLinkedList;
    ((any)localObject).Dpb = paramcqb;
    ((any)localObject).Dpc = 10L;
    ((any)localObject).Dpd = 0L;
    ((any)localObject).CFl = true;
    ((any)localObject).Dpf = paramInt;
    ((any)localObject).Dpg = 0L;
    this.yZE.Dpa = ((any)localObject);
    this.yZE.setBaseRequest(com.tencent.mm.protocal.l.a(this.iaa.getReqObj()));
    AppMethodBeat.o(110957);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(110955);
    ad.i("MicroMsg.NetSceneGenerateVlog", "do scene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
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
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    this.yZF = ((anz)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110956);
      return;
    }
    AppMethodBeat.o(110956);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */