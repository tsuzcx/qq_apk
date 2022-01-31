package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(24607);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhp();
    ((b.a)localObject).fsY = new bhq();
    ((b.a)localObject).uri = "/cgi-bin/mmoctv/optvhist";
    ((b.a)localObject).funcId = 1740;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bhp)this.rr.fsV.fta;
    ((bhp)localObject).nrS = paramInt;
    ((bhp)localObject).xwI = paramString;
    AppMethodBeat.o(24607);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24609);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24609);
    return i;
  }
  
  public final int getType()
  {
    return 1740;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24608);
    ab.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.c
 * JD-Core Version:    0.7.0.1
 */