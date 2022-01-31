package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.protocal.c.bvf;
import com.tencent.mm.protocal.c.cfv;
import com.tencent.mm.protocal.c.cfw;

public final class k
  extends n<cfv, cfw>
{
  public k(bvf parambvf)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cfv();
    ((b.a)localObject).ecI = new cfw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((b.a)localObject).ecG = 765;
    ((b.a)localObject).ecJ = 765;
    ((b.a)localObject).ecK = 1000000765;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cfv)this.dmK.ecE.ecN;
    ((cfv)localObject).sST = parambvf.sST;
    ((cfv)localObject).tLL = parambvf.tLL;
    ((cfv)localObject).sNU = parambvf.sNU;
    ((cfv)localObject).tLM = parambvf.tLM;
    ((cfv)localObject).tLN = parambvf.tLN;
    ((cfv)localObject).tLO = parambvf.tLO;
    ((cfv)localObject).tLP = parambvf.tLP;
    ((cfv)localObject).tLQ = parambvf.tLQ;
    ((cfv)localObject).tLR = parambvf.tLR;
    ((cfv)localObject).tLS = parambvf.tLS;
    ((cfv)localObject).tLT = parambvf.tLT;
    ((cfv)localObject).tLU = parambvf.tLU;
    ((cfv)localObject).tLV = parambvf.tLV;
  }
  
  public final f bRy()
  {
    return new k.1(this);
  }
  
  public final int getType()
  {
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */