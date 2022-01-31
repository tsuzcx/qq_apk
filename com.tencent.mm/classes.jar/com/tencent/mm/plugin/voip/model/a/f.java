package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.cff;
import com.tencent.mm.protocal.c.cfg;

public final class f
  extends n<cff, cfg>
{
  String TAG = "MicroMsg.NetSceneVoipHeartBeat";
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cff();
    ((b.a)localObject).ecI = new cfg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((b.a)localObject).ecG = 178;
    ((b.a)localObject).ecJ = 81;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cff)this.dmK.ecE.ecN;
    ((cff)localObject).sST = paramInt1;
    ((cff)localObject).sSU = paramLong;
    ((cff)localObject).tSJ = System.currentTimeMillis();
    ((cff)localObject).tTQ = paramInt2;
  }
  
  public final com.tencent.mm.ah.f bRy()
  {
    return new f.1(this);
  }
  
  public final int getType()
  {
    return 178;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f
 * JD-Core Version:    0.7.0.1
 */