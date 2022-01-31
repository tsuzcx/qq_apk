package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cev;
import com.tencent.mm.protocal.c.cew;
import com.tencent.mm.protocal.c.cfx;

public final class c
  extends n<cev, cew>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cev();
    ((b.a)localObject).ecI = new cew();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((b.a)localObject).ecG = 171;
    ((b.a)localObject).ecJ = 64;
    ((b.a)localObject).ecK = 1000000064;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cev)this.dmK.ecE.ecN;
    ((cev)localObject).sST = paramInt1;
    ((cev)localObject).sSU = paramLong;
    ((cev)localObject).kWm = paramString1;
    ((cev)localObject).tAC = paramInt2;
    paramString1 = new cfx();
    bml localbml = new bml();
    localbml.YI(paramString2);
    paramString1.tNi = localbml;
    ((cev)localObject).tTF = paramString1;
    ((cev)localObject).tSJ = System.currentTimeMillis();
  }
  
  public final f bRy()
  {
    return new c.1(this);
  }
  
  public final int bRz()
  {
    cev localcev = (cev)bRD();
    if ((localcev.sST == 0) && (localcev.tAC == 0)) {
      return -1;
    }
    return 0;
  }
  
  public final int getType()
  {
    return 171;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */