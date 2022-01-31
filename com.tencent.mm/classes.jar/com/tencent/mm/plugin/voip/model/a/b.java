package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ced;
import com.tencent.mm.protocal.c.cee;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends n<ced, cee>
{
  String TAG = "MicroMsg.NetSceneVoipAnswer";
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new ced();
    ((b.a)localObject1).ecI = new cee();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((b.a)localObject1).ecG = 172;
    ((b.a)localObject1).ecJ = 65;
    ((b.a)localObject1).ecK = 1000000065;
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (ced)this.dmK.ecE.ecN;
    ((ced)localObject1).tSU = paramInt1;
    ((ced)localObject1).sST = paramInt3;
    ((ced)localObject1).sNU = paramInt2;
    Object localObject2 = new cfp();
    ((cfp)localObject2).hQR = 2;
    bmk localbmk = new bmk();
    localbmk.bs(paramArrayOfByte1);
    ((cfp)localObject2).szp = localbmk;
    ((ced)localObject1).tSF = ((cfp)localObject2);
    paramArrayOfByte1 = new cfp();
    paramArrayOfByte1.hQR = 3;
    localObject2 = new bmk();
    ((bmk)localObject2).bs(paramArrayOfByte2);
    paramArrayOfByte1.szp = ((bmk)localObject2);
    ((ced)localObject1).tSG = paramArrayOfByte1;
    ((ced)localObject1).sSU = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((ced)localObject1).tSV = paramInt1;
      }
    }
    else
    {
      ((ced)localObject1).tSJ = System.currentTimeMillis();
      paramInt1 = ((a)g.r(a.class)).bih();
      y.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label291;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((ced)localObject1).tSK = paramInt1;
      return;
      paramInt1 = 0;
      break;
      label291:
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final f bRy()
  {
    return new b.1(this);
  }
  
  public final int getType()
  {
    return 172;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */