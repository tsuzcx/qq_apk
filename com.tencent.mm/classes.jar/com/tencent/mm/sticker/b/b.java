package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/net/NetSceneGetLensList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  private final String TAG;
  private h callback;
  private final c rr;
  
  public b()
  {
    AppMethodBeat.i(105980);
    this.TAG = "MicroMsg.NetSceneGetLensList";
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new cme());
    ((c.a)localObject).otF = ((a)new cmf());
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getlenslist";
    ((c.a)localObject).funcId = 3847;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    AppMethodBeat.o(105980);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(105978);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(105978);
    return i;
  }
  
  public final int getType()
  {
    return 3847;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105977);
    Log.i(this.TAG, "onGYNetEnd: " + paramInt2 + ", " + paramInt3);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    if ((paramInt2 == 4) && (paramInt3 == 2))
    {
      paramString = c.b.b(this.rr.otB);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListRequest");
        AppMethodBeat.o(105977);
        throw paramString;
      }
      paramString = (cme)paramString;
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListResponse");
        AppMethodBeat.o(105977);
        throw paramString;
      }
      params = (cmf)params;
      if (params.aaui != null)
      {
        paramString.aaui = params.aaui;
        doScene(dispatcher(), this.callback);
      }
    }
    AppMethodBeat.o(105977);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(105979);
    kotlin.g.b.s.u(params, "rr");
    params = p.b.ouh;
    AppMethodBeat.o(105979);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.b.b
 * JD-Core Version:    0.7.0.1
 */