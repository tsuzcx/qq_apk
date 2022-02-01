package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ac;
import d.v;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqId", "", "uin", "businessId", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "serverConf", "Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;", "reqNum", "reqOffset", "debugNeeded", "", "sid", "fid", "(JJILjava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/ServerConfFromClient;IIZII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  public static final a Apj;
  private arb Aph;
  public ard Api;
  private g callback;
  private b gvE;
  
  static
  {
    AppMethodBeat.i(110958);
    Apj = new a((byte)0);
    AppMethodBeat.o(110958);
  }
  
  public a(long paramLong1, long paramLong2, LinkedList<btr> paramLinkedList, cvi paramcvi, int paramInt)
  {
    AppMethodBeat.i(110957);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new arb());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new ard());
    ((b.a)localObject).op(1469);
    ((b.a)localObject).Am("/cgi-bin/spr-bin/generatevlog");
    ((b.a)localObject).or(0);
    ((b.a)localObject).or(0);
    ac.d("MicroMsg.NetSceneGenerateVlog", "GenerateVlog with reqId: " + paramLong1 + ", uin: " + paramLong2 + ", businessId: 1, materials: " + paramLinkedList.size() + ", sid: " + paramInt + ", fid: 0");
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramLinkedList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogReq");
      AppMethodBeat.o(110957);
      throw paramLinkedList;
    }
    this.Aph = ((arb)localObject);
    localObject = new arc();
    ((arc)localObject).DXI = paramLong1;
    ((arc)localObject).uin = paramLong2;
    ((arc)localObject).DXJ = 1L;
    ((arc)localObject).AoH = paramLinkedList;
    ((arc)localObject).EKb = paramcvi;
    ((arc)localObject).EKc = 10L;
    ((arc)localObject).EKd = 0L;
    ((arc)localObject).DXL = true;
    ((arc)localObject).EKf = paramInt;
    ((arc)localObject).EKg = 0L;
    this.Aph.EKa = ((arc)localObject);
    this.Aph.setBaseRequest(com.tencent.mm.protocal.l.a(this.gvE.getReqObj()));
    AppMethodBeat.o(110957);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(110955);
    ac.i("MicroMsg.NetSceneGenerateVlog", "do scene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
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
    ac.i("MicroMsg.NetSceneGenerateVlog", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GenerateVlogResp");
      AppMethodBeat.o(110956);
      throw paramString;
    }
    this.Api = ((ard)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110956);
      return;
    }
    AppMethodBeat.o(110956);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGenerateVlog$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */