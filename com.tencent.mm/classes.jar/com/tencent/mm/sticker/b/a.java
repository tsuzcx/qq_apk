package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-sticker_release"})
public final class a
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  public final d rr;
  
  public a()
  {
    AppMethodBeat.i(105976);
    this.TAG = "MicroMsg.NetSceneGetLensInfo";
    Object localObject = new bpf();
    ((bpf)localObject).Lso = "com.tencent.xin.lens.lens_test1";
    d.a locala = new d.a();
    locala.c((com.tencent.mm.bw.a)localObject);
    locala.d((com.tencent.mm.bw.a)new bpg());
    locala.MB("/cgi-bin/micromsg-bin/getlensinfo");
    locala.sG(3903);
    localObject = locala.aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    AppMethodBeat.o(105976);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(105974);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(105974);
    return i;
  }
  
  public final int getType()
  {
    return 3903;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105975);
    Log.i(this.TAG, "onGYNetEnd: " + paramInt2 + ", " + paramInt3);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
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