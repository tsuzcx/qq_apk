package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.protocal.c.cas;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Date;
import java.util.TimeZone;

public final class f
  extends m
  implements k
{
  private b dmK = null;
  private com.tencent.mm.ah.f dmL = null;
  private car pts;
  
  public f(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4)
  {
    y.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    b.a locala = new b.a();
    locala.ecH = new car();
    locala.ecI = new cas();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
    locala.ecG = 1261;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.pts = ((car)this.dmK.ecE.ecN);
    this.pts.bwK = paramString1;
    this.pts.bJp = paramString2;
    this.pts.tPJ = paramInt1;
    this.pts.tPK = paramInt2;
    this.pts.bba = paramInt3;
    paramString1 = this.pts;
    paramString2 = TimeZone.getDefault();
    paramInt2 = paramString2.getRawOffset() / 1000;
    if ((paramString2.useDaylightTime()) && (paramString2.inDaylightTime(new Date(System.currentTimeMillis())))) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.tPL = String.valueOf(paramInt1 + paramInt2 / 3600);
      this.pts.tPN = paramString3;
      this.pts.tPQ = paramInt4;
      return;
    }
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1261;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.f
 * JD-Core Version:    0.7.0.1
 */