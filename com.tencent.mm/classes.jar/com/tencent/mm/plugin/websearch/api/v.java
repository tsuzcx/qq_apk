package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.sdk.platformtools.ab;

public final class v
  extends m
  implements k
{
  public int businessType;
  public int cCT;
  private f callback;
  private b fBd;
  public String ohe;
  public int scene;
  public bbw uJb;
  private int uJc;
  
  public v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(124069);
    this.scene = paramInt1;
    this.uJc = paramInt3;
    this.cCT = paramInt4;
    this.businessType = paramInt2;
    this.ohe = paramString2;
    ab.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    paramString2 = new b.a();
    paramString2.funcId = 1048;
    paramString2.uri = "/cgi-bin/mmsearch-bin/searchguide";
    paramString2.fsX = new bbv();
    paramString2.fsY = new bbw();
    this.fBd = paramString2.ado();
    paramString2 = (bbv)this.fBd.fsV.fta;
    paramString2.Scene = paramInt1;
    paramString2.xqT = paramInt3;
    paramString2.xqU = aa.acv();
    paramString2.wsK = paramInt2;
    paramString2.lGH = paramString1;
    paramString2.xqV = paramLong;
    AppMethodBeat.o(124069);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124070);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(124070);
    return i;
  }
  
  public final int getType()
  {
    return 1048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124071);
    ab.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124071);
      return;
    }
    this.uJb = ((bbw)this.fBd.fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(124071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.v
 * JD-Core Version:    0.7.0.1
 */