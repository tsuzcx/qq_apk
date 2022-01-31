package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cdz;
import com.tencent.mm.protocal.c.cea;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends n<cdz, cea>
{
  String TAG = "MicroMsg.NetSceneVoipAck";
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cdz();
    ((b.a)localObject).ecI = new cea();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((b.a)localObject).ecG = 305;
    ((b.a)localObject).ecJ = 123;
    ((b.a)localObject).ecK = 1000000123;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cdz)this.dmK.ecE.ecN;
    ((cdz)localObject).sST = paramInt1;
    ((cdz)localObject).sSU = paramLong;
    ((cdz)localObject).tSI = paramInt2;
    if (paramInt2 != 1)
    {
      ((cdz)localObject).tSE = 0;
      return;
    }
    ((cdz)localObject).tSH = paramString;
    paramString = new cfp();
    paramString.hQR = 2;
    bmk localbmk = new bmk();
    localbmk.bs(paramArrayOfByte1);
    paramString.szp = localbmk;
    ((cdz)localObject).tSF = paramString;
    paramArrayOfByte1 = new cfp();
    paramArrayOfByte1.hQR = 3;
    paramString = new bmk();
    paramString.bs(paramArrayOfByte2);
    paramArrayOfByte1.szp = paramString;
    ((cdz)localObject).tSG = paramArrayOfByte1;
    ((cdz)localObject).tSJ = System.currentTimeMillis();
    ((cdz)localObject).tSE = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)g.r(com.tencent.mm.plugin.misc.a.a.class)).bih();
    y.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((cdz)localObject).tSK = paramInt1;
      return;
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final f bRy()
  {
    return new a.1(this);
  }
  
  public final int getType()
  {
    return 305;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a
 * JD-Core Version:    0.7.0.1
 */