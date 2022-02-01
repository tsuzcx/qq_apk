package com.tencent.mm.plugin.nearby.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  public String MoA;
  private h callback;
  public String pss;
  private final c rr;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dhh();
    ((c.a)localObject).otF = new dhi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((c.a)localObject).funcId = 376;
    ((c.a)localObject).otG = 183;
    ((c.a)localObject).respCmdId = 1000000183;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dhh)c.b.b(this.rr.otB);
    ((dhh)localObject).YIq = 1;
    ((dhh)localObject).ZaG = paramFloat1;
    ((dhh)localObject).ZaH = paramFloat2;
    ((dhh)localObject).Zyl = paramInt;
    ((dhh)localObject).Zym = paramString1;
    ((dhh)localObject).Zyn = paramString2;
    ((dhh)localObject).Zyo = 0;
    Log.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dhh();
    ((c.a)localObject).otF = new dhi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((c.a)localObject).funcId = 376;
    ((c.a)localObject).otG = 183;
    ((c.a)localObject).respCmdId = 1000000183;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dhh)c.b.b(this.rr.otB);
    ((dhh)localObject).ZaG = 0.0F;
    ((dhh)localObject).ZaH = 0.0F;
    ((dhh)localObject).Zyl = 0;
    ((dhh)localObject).Zyo = 0;
    ((dhh)localObject).Zym = "";
    ((dhh)localObject).Zyn = "";
    ((dhh)localObject).YIq = 2;
    ((dhh)localObject).oPp = paramString;
    ((dhh)localObject).aaME = paramInt1;
    ((dhh)localObject).aaMD = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int bIO()
  {
    AppMethodBeat.i(262804);
    int i = ((dhh)c.b.b(this.rr.otB)).YIq;
    AppMethodBeat.o(262804);
    return i;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(89771);
    this.callback = paramh;
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
    Log.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + bIO());
    paramArrayOfByte = (dhi)c.c.b(((c)params).otC);
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (bIO() == 1)
    {
      this.pss = paramArrayOfByte.oPp;
      this.MoA = paramArrayOfByte.aaMF;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (bIO() == 2)
    {
      b.aPM(((dhh)c.b.b(((c)params).otB)).oPp);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.model.d
 * JD-Core Version:    0.7.0.1
 */