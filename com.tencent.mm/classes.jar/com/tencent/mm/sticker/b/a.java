package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
  implements m
{
  private final String TAG;
  private h callback;
  public final c rr;
  
  public a()
  {
    AppMethodBeat.i(105976);
    this.TAG = "MicroMsg.NetSceneGetLensInfo";
    Object localObject = new cmc();
    ((cmc)localObject).LensId = "com.tencent.xin.lens.lens_test1";
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    locala.otF = ((com.tencent.mm.bx.a)new cmd());
    locala.uri = "/cgi-bin/micromsg-bin/getlensinfo";
    locala.funcId = 3903;
    localObject = locala.bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    AppMethodBeat.o(105976);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(105974);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(105974);
    return i;
  }
  
  public final int getType()
  {
    return 3903;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105975);
    Log.i(this.TAG, "onGYNetEnd: " + paramInt2 + ", " + paramInt3);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(105975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.b.a
 * JD-Core Version:    0.7.0.1
 */