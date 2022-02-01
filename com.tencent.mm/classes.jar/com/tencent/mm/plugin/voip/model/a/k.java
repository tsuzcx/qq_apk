package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.protocal.protobuf.fgu;
import com.tencent.mm.protocal.protobuf.gbn;
import com.tencent.mm.protocal.protobuf.gbo;

public final class k
  extends n<gbn, gbo>
{
  public k(fgu paramfgu)
  {
    AppMethodBeat.i(115250);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gbn();
    ((c.a)localObject).otF = new gbo();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((c.a)localObject).funcId = 765;
    ((c.a)localObject).otG = 765;
    ((c.a)localObject).respCmdId = 1000000765;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gbn)c.b.b(this.rr.otB);
    ((gbn)localObject).Zvz = paramfgu.Zvz;
    ((gbn)localObject).abGP = paramfgu.abGP;
    ((gbn)localObject).ZkT = paramfgu.ZkT;
    ((gbn)localObject).abGQ = paramfgu.abGQ;
    ((gbn)localObject).abGR = paramfgu.abGR;
    ((gbn)localObject).abGS = paramfgu.abGS;
    ((gbn)localObject).abGT = paramfgu.abGT;
    ((gbn)localObject).abGU = paramfgu.abGU;
    ((gbn)localObject).abGV = paramfgu.abGV;
    ((gbn)localObject).abGW = paramfgu.abGW;
    ((gbn)localObject).abGX = paramfgu.abGX;
    ((gbn)localObject).abGY = paramfgu.abGY;
    ((gbn)localObject).abGZ = paramfgu.abGZ;
    AppMethodBeat.o(115250);
  }
  
  public final int getType()
  {
    return 765;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115251);
    k.1 local1 = new k.1(this);
    AppMethodBeat.o(115251);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */