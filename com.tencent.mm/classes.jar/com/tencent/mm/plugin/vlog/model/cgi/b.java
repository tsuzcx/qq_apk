package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final a Apm;
  private avk Apk;
  public avl Apl;
  private g callback;
  private com.tencent.mm.ak.b gvE;
  
  static
  {
    AppMethodBeat.i(110962);
    Apm = new a((byte)0);
    AppMethodBeat.o(110962);
  }
  
  public b()
  {
    AppMethodBeat.i(110961);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((a)new avk());
    ((com.tencent.mm.ak.b.a)localObject).d((a)new avl());
    ((com.tencent.mm.ak.b.a)localObject).op(2972);
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/spr-bin/getclientconffromserver");
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerReq");
      AppMethodBeat.o(110961);
      throw ((Throwable)localObject);
    }
    this.Apk = ((avk)localObject);
    AppMethodBeat.o(110961);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(110959);
    ac.i("MicroMsg.NetSceneGetClientConfFromServer", "do scene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(110959);
    return i;
  }
  
  public final int getType()
  {
    return 2972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110960);
    ac.i("MicroMsg.NetSceneGetClientConfFromServer", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    this.Apl = ((avl)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110960);
      return;
    }
    AppMethodBeat.o(110960);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */