package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class b
  extends n
  implements k
{
  public static final a BHc;
  private azi BHa;
  public azj BHb;
  private f callback;
  private com.tencent.mm.al.b gPp;
  
  static
  {
    AppMethodBeat.i(110962);
    BHc = new a((byte)0);
    AppMethodBeat.o(110962);
  }
  
  public b()
  {
    AppMethodBeat.i(110961);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((a)new azi());
    ((com.tencent.mm.al.b.a)localObject).d((a)new azj());
    ((com.tencent.mm.al.b.a)localObject).oP(2972);
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/spr-bin/getclientconffromserver");
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((com.tencent.mm.al.b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerReq");
      AppMethodBeat.o(110961);
      throw ((Throwable)localObject);
    }
    this.BHa = ((azi)localObject);
    AppMethodBeat.o(110961);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110959);
    ad.i("MicroMsg.NetSceneGetClientConfFromServer", "do scene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
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
    ad.i("MicroMsg.NetSceneGetClientConfFromServer", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    this.BHb = ((azj)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110960);
      return;
    }
    AppMethodBeat.o(110960);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */