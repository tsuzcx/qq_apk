package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends f
{
  private g callback;
  private final b rr;
  private final String sSF;
  private int sceneType;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(29564);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dbc();
    ((b.a)localObject).gUV = new dbd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((b.a)localObject).funcId = 335;
    ((b.a)localObject).reqCmdId = 149;
    ((b.a)localObject).respCmdId = 1000000149;
    this.rr = ((b.a)localObject).atI();
    localObject = (dbc)this.rr.gUS.gUX;
    ((dbc)localObject).DdZ = paramInt1;
    ((dbc)localObject).Dea = paramLong;
    ((dbc)localObject).Cxn = ((int)bt.aGK());
    this.sSF = paramString;
    ((dbc)localObject).Scene = paramInt2;
    AppMethodBeat.o(29564);
  }
  
  public final String dNh()
  {
    return this.sSF;
  }
  
  public final int dNi()
  {
    return this.sceneType;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(29565);
    ad.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29565);
    return i;
  }
  
  public final int getType()
  {
    return 335;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29566);
    ad.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29566);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.e
 * JD-Core Version:    0.7.0.1
 */