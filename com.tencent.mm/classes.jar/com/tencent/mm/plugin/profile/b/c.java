package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(23287);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cao();
    ((b.a)localObject).fsY = new cap();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((b.a)localObject).funcId = 1363;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cao)this.rr.fsV.fta;
    ((cao)localObject).wyh = paramString;
    ((cao)localObject).xLS = paramInt;
    ((cao)localObject).xLT = 4;
    AppMethodBeat.o(23287);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23289);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23289);
    return i;
  }
  
  public final int getType()
  {
    return 1363;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23288);
    ab.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.c
 * JD-Core Version:    0.7.0.1
 */