package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends f
{
  public int actionType;
  private g callback;
  private final b rr;
  private final String sSF;
  private int sceneType;
  public int yJp;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29561);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dba();
    ((b.a)localObject).gUV = new dbb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((b.a)localObject).funcId = 334;
    ((b.a)localObject).reqCmdId = 146;
    ((b.a)localObject).respCmdId = 1000000146;
    this.rr = ((b.a)localObject).atI();
    localObject = (dba)this.rr.gUS.gUX;
    ((dba)localObject).DdZ = paramInt1;
    ((dba)localObject).Dea = paramLong;
    ((dba)localObject).CKO = paramInt2;
    ((dba)localObject).Cxn = ((int)bt.aGK());
    this.actionType = paramInt2;
    this.sSF = paramString;
    ((dba)localObject).Scene = paramInt3;
    AppMethodBeat.o(29561);
  }
  
  public final String dNh()
  {
    return this.sSF;
  }
  
  public final int dNi()
  {
    return this.sceneType;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29562);
    ad.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29562);
    return i;
  }
  
  public final int getType()
  {
    return 334;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29563);
    ad.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29563);
      return;
    }
    this.yJp = ((dbb)this.rr.gUT.gUX).Deb;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */