package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.brf;
import com.tencent.mm.protocal.c.brg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class g
  extends e
{
  private final b dmK;
  private f dmL;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new brf();
    ((b.a)localObject).ecI = new brg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((b.a)localObject).ecG = 408;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (brf)this.dmK.ecE.ecN;
    ((brf)localObject).ndi = new bmk().bs(paramArrayOfByte);
    ((brf)localObject).tHO = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((brf)localObject).euw = paramInt2;
      ((brf)localObject).tHP = paramInt1;
      if (ab.bG(ae.getContext()))
      {
        paramInt1 = j;
        label152:
        ((brf)localObject).sNU = paramInt1;
        ((brf)localObject).swP = paramInt3;
      }
      try
      {
        au.Hx();
        f2 = bk.getFloat((String)c.Dz().get(ac.a.uoP, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          au.Hx();
          f1 = bk.getFloat((String)c.Dz().get(ac.a.uoQ, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            au.Hx();
            paramInt1 = bk.ZR((String)c.Dz().get(ac.a.urr, null));
            for (;;)
            {
              ((brf)localObject).sGK = f2;
              ((brf)localObject).tHQ = f1;
              o.a(2009, ((brf)localObject).tHQ, ((brf)localObject).sGK, paramInt1);
              return;
              paramInt2 = 0;
              break;
              paramInt1 = 2;
              break label152;
              paramArrayOfByte = paramArrayOfByte;
              f1 = 0.0F;
              f2 = 0.0F;
              paramInt1 = i;
              continue;
              paramArrayOfByte = paramArrayOfByte;
              f1 = 0.0F;
              paramInt1 = i;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            for (;;)
            {
              paramInt1 = i;
            }
          }
        }
      }
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    brf localbrf = (brf)this.dmK.ecE.ecN;
    y.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localbrf.tHO), Integer.valueOf(localbrf.ndi.tFK), Integer.valueOf(localbrf.euw), Float.valueOf(localbrf.tHP), Integer.valueOf(localbrf.sNU), Integer.valueOf(localbrf.swP) });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (brf)this.dmK.ecE.ecN;
    paramArrayOfByte = (brg)this.dmK.ecF.ecN;
    y.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.tHO), Integer.valueOf(paramArrayOfByte.euw) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.euw == 1)) {
      this.oaK = true;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bly bAx()
  {
    return (brg)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 408;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */