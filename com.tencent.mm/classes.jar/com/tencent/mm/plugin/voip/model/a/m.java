package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.gak;
import com.tencent.mm.protocal.protobuf.gbt;
import com.tencent.mm.protocal.protobuf.gbu;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends n<gbt, gbu>
{
  public m(int paramInt1, gak paramgak, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gbt();
    ((c.a)localObject).otF = new gbu();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((c.a)localObject).funcId = 174;
    ((c.a)localObject).otG = 62;
    ((c.a)localObject).respCmdId = 1000000062;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gbt)c.b.b(this.rr.otB);
    ((gbt)localObject).Zvz = paramInt1;
    ((gbt)localObject).acae = paramgak;
    ((gbt)localObject).ZvA = paramLong;
    ((gbt)localObject).abnl = z.bAM();
    ((gbt)localObject).ZdC = paramInt2;
    ((gbt)localObject).ZdD = new gol().df(paramArrayOfByte);
    ((gbt)localObject).abWT = System.currentTimeMillis();
    Log.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((gbt)localObject).abWT);
    AppMethodBeat.o(115256);
  }
  
  public final int getType()
  {
    return 174;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115257);
    m.1 local1 = new m.1(this);
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int hYV()
  {
    AppMethodBeat.i(293388);
    int i = ((gbt)c.b.b(this.rr.otB)).ZdC;
    AppMethodBeat.o(293388);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */