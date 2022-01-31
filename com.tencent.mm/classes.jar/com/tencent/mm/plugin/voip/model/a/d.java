package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cfb;
import com.tencent.mm.protocal.c.cfc;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends n<cfb, cfc>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cfb();
    ((b.a)localObject).ecI = new cfc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((b.a)localObject).ecG = 249;
    ((b.a)localObject).ecJ = 249;
    ((b.a)localObject).ecK = 1000000249;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cfb)this.dmK.ecE.ecN;
    ((cfb)localObject).sST = paramInt1;
    ((cfb)localObject).sSU = paramLong;
    ((cfb)localObject).tAN = paramInt2;
    ((cfb)localObject).tTI = paramInt3;
    ((cfb)localObject).tTJ = paramInt4;
    ((cfb)localObject).tTK = paramInt5;
    ((cfb)localObject).tTL = paramInt6;
    ((cfb)localObject).tTM = 1;
    ((cfb)localObject).szp = new bmk().T(paramArrayOfByte, paramInt7);
  }
  
  public final f bRy()
  {
    return new d.1(this);
  }
  
  public final void em(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cfc localcfc = (cfc)bRC();
      if (localcfc != null) {
        y.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localcfc.sST), Long.valueOf(localcfc.sSU), Integer.valueOf(localcfc.tAN) });
      }
      return;
    }
    y.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
  }
  
  public final int getType()
  {
    return 249;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */