package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dni;

public final class k
  extends n<dnh, dni>
{
  public k(cww paramcww)
  {
    AppMethodBeat.i(115250);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dnh();
    ((b.a)localObject).gUV = new dni();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((b.a)localObject).funcId = 765;
    ((b.a)localObject).reqCmdId = 765;
    ((b.a)localObject).respCmdId = 1000000765;
    this.rr = ((b.a)localObject).atI();
    localObject = (dnh)this.rr.gUS.gUX;
    ((dnh)localObject).DdZ = paramcww.DdZ;
    ((dnh)localObject).EoJ = paramcww.EoJ;
    ((dnh)localObject).CYi = paramcww.CYi;
    ((dnh)localObject).EoK = paramcww.EoK;
    ((dnh)localObject).EoL = paramcww.EoL;
    ((dnh)localObject).EoM = paramcww.EoM;
    ((dnh)localObject).EoN = paramcww.EoN;
    ((dnh)localObject).EoO = paramcww.EoO;
    ((dnh)localObject).EoP = paramcww.EoP;
    ((dnh)localObject).EoQ = paramcww.EoQ;
    ((dnh)localObject).EoR = paramcww.EoR;
    ((dnh)localObject).EoS = paramcww.EoS;
    ((dnh)localObject).EoT = paramcww.EoT;
    AppMethodBeat.o(115250);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115251);
    k.1 local1 = new k.1(this);
    AppMethodBeat.o(115251);
    return local1;
  }
  
  public final int getType()
  {
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */