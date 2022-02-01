package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/net/NetSceneGetLensList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "plugin-sticker_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public b()
  {
    AppMethodBeat.i(105980);
    this.TAG = "MicroMsg.NetSceneGetLensList";
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ayz());
    ((b.a)localObject).d((a)new aza());
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/getlenslist");
    ((b.a)localObject).op(3847);
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    AppMethodBeat.o(105980);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(105978);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(105978);
    return i;
  }
  
  public final int getType()
  {
    return 3847;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105977);
    ac.i(this.TAG, "onGYNetEnd: " + paramInt2 + ", " + paramInt3);
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    if ((paramInt2 == 4) && (paramInt3 == 2))
    {
      paramString = this.rr.aBC();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListRequest");
        AppMethodBeat.o(105977);
        throw paramString;
      }
      paramString = (ayz)paramString;
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListResponse");
        AppMethodBeat.o(105977);
        throw paramString;
      }
      paramq = (aza)paramq;
      if (paramq.EQy != null)
      {
        paramString.EQy = paramq.EQy;
        doScene(dispatcher(), this.callback);
      }
    }
    AppMethodBeat.o(105977);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(105979);
    d.g.b.k.h(paramq, "rr");
    paramq = n.b.hwa;
    AppMethodBeat.o(105979);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.b.b
 * JD-Core Version:    0.7.0.1
 */