package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.protocal.c.cfd;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends n<cfd, cfe>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cfd();
    ((b.a)localObject).ecI = new cfe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((b.a)localObject).ecG = 303;
    ((b.a)localObject).ecJ = 119;
    ((b.a)localObject).ecK = 1000000119;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cfd)this.dmK.ecE.ecN;
    ((cfd)localObject).sST = paramInt;
    ((cfd)localObject).sSU = paramLong;
    ((cfd)localObject).tTO = paramString;
    ((cfd)localObject).hQR = 1;
    ((cfd)localObject).tSJ = System.currentTimeMillis();
  }
  
  public final f bRy()
  {
    return new e.1(this);
  }
  
  public final void em(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cfe localcfe = (cfe)bRC();
      if (localcfe != null) {
        y.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localcfe.sST), Long.valueOf(localcfe.sSU), Integer.valueOf(localcfe.dne), Integer.valueOf(localcfe.tTG) });
      }
      return;
    }
    y.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
  }
  
  public final int getType()
  {
    return 303;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */