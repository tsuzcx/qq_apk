package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65506);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmsearch-bin/getuserattrbyopenid";
    locala.fsX = new arl();
    locala.fsY = new arm();
    this.rr = locala.ado();
    ((arl)this.rr.fsV.fta).wys = paramString;
    AppMethodBeat.o(65506);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65507);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(65507);
    return i;
  }
  
  public final int getType()
  {
    return 2830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65508);
    ab.i("MicroMsg.TopStory.NetSceneTopStoryGetUsername", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(65508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.d
 * JD-Core Version:    0.7.0.1
 */