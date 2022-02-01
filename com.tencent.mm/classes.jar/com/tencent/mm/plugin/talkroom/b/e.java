package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eqr;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends f
{
  private final String Enu;
  private i callback;
  private final d rr;
  private int sceneType;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(29564);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eqr();
    ((d.a)localObject).lBV = new eqs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((d.a)localObject).funcId = 335;
    ((d.a)localObject).lBW = 149;
    ((d.a)localObject).respCmdId = 1000000149;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eqr)d.b.b(this.rr.lBR);
    ((eqr)localObject).Svu = paramInt1;
    ((eqr)localObject).Svv = paramLong;
    ((eqr)localObject).RIt = ((int)Util.nowSecond());
    this.Enu = paramString;
    ((eqr)localObject).CPw = paramInt2;
    AppMethodBeat.o(29564);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29565);
    Log.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29565);
    return i;
  }
  
  public final int getType()
  {
    return 335;
  }
  
  public final String giK()
  {
    return this.Enu;
  }
  
  public final int giL()
  {
    return this.sceneType;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29566);
    Log.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
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