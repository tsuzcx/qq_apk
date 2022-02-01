package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/net/NetSceneGetLensList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "plugin-sticker_release"})
public final class b
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  private final d rr;
  
  public b()
  {
    AppMethodBeat.i(105980);
    this.TAG = "MicroMsg.NetSceneGetLensList";
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bph());
    ((d.a)localObject).d((a)new bpi());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/getlenslist");
    ((d.a)localObject).sG(3847);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    AppMethodBeat.o(105980);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(105978);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(105978);
    return i;
  }
  
  public final int getType()
  {
    return 3847;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105977);
    Log.i(this.TAG, "onGYNetEnd: " + paramInt2 + ", " + paramInt3);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    if ((paramInt2 == 4) && (paramInt3 == 2))
    {
      paramString = this.rr.aYJ();
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListRequest");
        AppMethodBeat.o(105977);
        throw paramString;
      }
      paramString = (bph)paramString;
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListResponse");
        AppMethodBeat.o(105977);
        throw paramString;
      }
      params = (bpi)params;
      if (params.LXB != null)
      {
        paramString.LXB = params.LXB;
        doScene(dispatcher(), this.callback);
      }
    }
    AppMethodBeat.o(105977);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(105979);
    p.h(params, "rr");
    params = q.b.iMq;
    AppMethodBeat.o(105979);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.b.b
 * JD-Core Version:    0.7.0.1
 */