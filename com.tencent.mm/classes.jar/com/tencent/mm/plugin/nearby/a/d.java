package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  public String Azx;
  private i callback;
  public String jHa;
  private final com.tencent.mm.ak.d rr;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new chr();
    ((d.a)localObject).iLO = new chs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((d.a)localObject).funcId = 376;
    ((d.a)localObject).iLP = 183;
    ((d.a)localObject).respCmdId = 1000000183;
    this.rr = ((d.a)localObject).aXF();
    localObject = (chr)this.rr.iLK.iLR;
    ((chr)localObject).OpCode = 1;
    ((chr)localObject).LbC = paramFloat1;
    ((chr)localObject).LbD = paramFloat2;
    ((chr)localObject).LuT = paramInt;
    ((chr)localObject).LuU = paramString1;
    ((chr)localObject).LuV = paramString2;
    ((chr)localObject).LuW = 0;
    Log.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new chr();
    ((d.a)localObject).iLO = new chs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((d.a)localObject).funcId = 376;
    ((d.a)localObject).iLP = 183;
    ((d.a)localObject).respCmdId = 1000000183;
    this.rr = ((d.a)localObject).aXF();
    localObject = (chr)this.rr.iLK.iLR;
    ((chr)localObject).LbC = 0.0F;
    ((chr)localObject).LbD = 0.0F;
    ((chr)localObject).LuT = 0;
    ((chr)localObject).LuW = 0;
    ((chr)localObject).LuU = "";
    ((chr)localObject).LuV = "";
    ((chr)localObject).OpCode = 2;
    ((chr)localObject).jfM = paramString;
    ((chr)localObject).Mnc = paramInt1;
    ((chr)localObject).Mnb = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int Vj()
  {
    return ((chr)this.rr.iLK.iLR).OpCode;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(89771);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(89771);
    return i;
  }
  
  public final int getType()
  {
    return 376;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89772);
    Log.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + Vj());
    paramArrayOfByte = (chs)((com.tencent.mm.ak.d)params).iLL.iLR;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (Vj() == 1)
    {
      this.jHa = paramArrayOfByte.jfM;
      this.Azx = paramArrayOfByte.Mnd;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (Vj() == 2)
    {
      b.aIt(((chr)((com.tencent.mm.ak.d)params).iLK.iLR).jfM);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */