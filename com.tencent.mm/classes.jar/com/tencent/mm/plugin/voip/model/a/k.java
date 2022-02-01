package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;

public final class k
  extends n<dsy, dsz>
{
  public k(dci paramdci)
  {
    AppMethodBeat.i(115250);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dsy();
    ((b.a)localObject).hvu = new dsz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((b.a)localObject).funcId = 765;
    ((b.a)localObject).reqCmdId = 765;
    ((b.a)localObject).respCmdId = 1000000765;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dsy)this.rr.hvr.hvw;
    ((dsy)localObject).Exf = paramdci.Exf;
    ((dsy)localObject).FLI = paramdci.FLI;
    ((dsy)localObject).EqS = paramdci.EqS;
    ((dsy)localObject).FLJ = paramdci.FLJ;
    ((dsy)localObject).FLK = paramdci.FLK;
    ((dsy)localObject).FLL = paramdci.FLL;
    ((dsy)localObject).FLM = paramdci.FLM;
    ((dsy)localObject).FLN = paramdci.FLN;
    ((dsy)localObject).FLO = paramdci.FLO;
    ((dsy)localObject).FLP = paramdci.FLP;
    ((dsy)localObject).FLQ = paramdci.FLQ;
    ((dsy)localObject).FLR = paramdci.FLR;
    ((dsy)localObject).FLS = paramdci.FLS;
    AppMethodBeat.o(115250);
  }
  
  public final g eks()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */