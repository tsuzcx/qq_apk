package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.flv;
import com.tencent.mm.protocal.protobuf.flw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends f
{
  private final String Kgc;
  private h callback;
  private final c rr;
  private int sceneType;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(29564);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new flv();
    ((c.a)localObject).otF = new flw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((c.a)localObject).funcId = 335;
    ((c.a)localObject).otG = 149;
    ((c.a)localObject).respCmdId = 1000000149;
    this.rr = ((c.a)localObject).bEF();
    localObject = (flv)c.b.b(this.rr.otB);
    ((flv)localObject).Zvz = paramInt1;
    ((flv)localObject).ZvA = paramLong;
    ((flv)localObject).YFv = ((int)Util.nowSecond());
    this.Kgc = paramString;
    ((flv)localObject).IJG = paramInt2;
    AppMethodBeat.o(29564);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29565);
    Log.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29565);
    return i;
  }
  
  public final int getType()
  {
    return 335;
  }
  
  public final String hCL()
  {
    return this.Kgc;
  }
  
  public final int hCM()
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