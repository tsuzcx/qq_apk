package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-sticker_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public final b rr;
  
  public a()
  {
    AppMethodBeat.i(105976);
    this.TAG = "MicroMsg.NetSceneGetLensInfo";
    Object localObject = new avr();
    ((avr)localObject).Dds = "com.tencent.xin.lens.lens_test1";
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)localObject);
    locala.d((com.tencent.mm.bx.a)new avs());
    locala.wg("/cgi-bin/micromsg-bin/getlensinfo");
    locala.nB(3903);
    localObject = locala.atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    AppMethodBeat.o(105976);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(105974);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(105974);
    return i;
  }
  
  public final int getType()
  {
    return 3903;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105975);
    ad.i(this.TAG, "onGYNetEnd: " + paramInt2 + ", " + paramInt3);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(105975);
      return;
    }
    AppMethodBeat.o(105975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.b.a
 * JD-Core Version:    0.7.0.1
 */