package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(126844);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afd();
    ((b.a)localObject).fsY = new afe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((b.a)localObject).funcId = 177;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (afd)this.rr.fsV.fta;
    ((afd)localObject).SetType = 1;
    ((afd)localObject).wXY = paramString;
    AppMethodBeat.o(126844);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(126845);
    ab.d("MicroMsg.NetSceneGeneralSet", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(126845);
    return i;
  }
  
  public final int getType()
  {
    return 177;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126846);
    ab.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */