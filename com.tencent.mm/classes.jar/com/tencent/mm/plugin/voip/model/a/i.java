package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cfr;
import com.tencent.mm.protocal.c.cfs;
import com.tencent.mm.protocal.c.cfx;

public final class i
  extends n<cfr, cfs>
{
  String TAG = "MicroMsg.NetSceneVoipShutDown";
  
  public i(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cfr();
    ((b.a)localObject).ecI = new cfs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((b.a)localObject).ecG = 173;
    ((b.a)localObject).ecJ = 66;
    ((b.a)localObject).ecK = 1000000066;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cfr)this.dmK.ecE.ecN;
    ((cfr)localObject).sST = paramInt;
    ((cfr)localObject).sSU = paramLong;
    cfx localcfx = new cfx();
    bml localbml = new bml();
    localbml.YI(paramString);
    localcfx.tNi = localbml;
    ((cfr)localObject).tTF = localcfx;
    ((cfr)localObject).tSJ = System.currentTimeMillis();
  }
  
  public final f bRy()
  {
    return new i.1(this);
  }
  
  public final int getType()
  {
    return 173;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */