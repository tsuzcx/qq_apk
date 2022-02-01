package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.flt;
import com.tencent.mm.protocal.protobuf.flu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends f
{
  private final String Kgc;
  public int SNS;
  public int actionType;
  private h callback;
  private final c rr;
  private int sceneType;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29561);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new flt();
    ((c.a)localObject).otF = new flu();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((c.a)localObject).funcId = 334;
    ((c.a)localObject).otG = 146;
    ((c.a)localObject).respCmdId = 1000000146;
    this.rr = ((c.a)localObject).bEF();
    localObject = (flt)c.b.b(this.rr.otB);
    ((flt)localObject).Zvz = paramInt1;
    ((flt)localObject).ZvA = paramLong;
    ((flt)localObject).YVh = paramInt2;
    ((flt)localObject).YFv = ((int)Util.nowSecond());
    this.actionType = paramInt2;
    this.Kgc = paramString;
    ((flt)localObject).IJG = paramInt3;
    AppMethodBeat.o(29561);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29562);
    Log.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29562);
    return i;
  }
  
  public final int getType()
  {
    return 334;
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
    AppMethodBeat.i(29563);
    Log.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29563);
      return;
    }
    this.SNS = ((flu)c.c.b(this.rr.otC)).ZvB;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */