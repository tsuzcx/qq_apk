package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.av.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.brb;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class f
  extends e
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new brb();
    ((b.a)localObject).ecI = new brc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((b.a)localObject).ecG = 367;
    ((b.a)localObject).ecJ = 177;
    ((b.a)localObject).ecK = 1000000177;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (brb)this.dmK.ecE.ecN;
    ((brb)localObject).ndi = new bmk().bs(paramArrayOfByte);
    ((brb)localObject).tHO = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((brb)localObject).euw = paramInt2;
      ((brb)localObject).tHP = paramInt1;
      if (!ab.bG(ae.getContext())) {
        break label302;
      }
      paramInt1 = 1;
      label151:
      ((brb)localObject).sNU = paramInt1;
      ((brb)localObject).swP = paramInt3;
    }
    for (;;)
    {
      try
      {
        au.Hx();
        f2 = bk.getFloat((String)c.Dz().get(ac.a.uoP, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        label302:
        f1 = 0.0F;
        float f2 = 0.0F;
      }
      try
      {
        au.Hx();
        f1 = bk.getFloat((String)c.Dz().get(ac.a.uoQ, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          f1 = 0.0F;
        }
      }
      try
      {
        au.Hx();
        paramInt1 = bk.ZR((String)c.Dz().get(ac.a.urr, null));
        ((brb)localObject).sGK = f2;
        ((brb)localObject).tHQ = f1;
        if (!d.PD()) {
          break label319;
        }
        paramInt2 = 0;
        ((brb)localObject).tfV = paramInt2;
        if (!d.PC()) {
          break label325;
        }
        paramInt2 = i;
        ((brb)localObject).tfW = paramInt2;
        o.a(2014, ((brb)localObject).tHQ, ((brb)localObject).sGK, paramInt1);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        break label314;
      }
      paramInt2 = 0;
      break;
      paramInt1 = 2;
      break label151;
      label314:
      paramInt1 = 0;
      continue;
      label319:
      paramInt2 = 1;
      continue;
      label325:
      paramInt2 = 0;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    brb localbrb = (brb)this.dmK.ecE.ecN;
    y.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localbrb.tHO), Integer.valueOf(localbrb.ndi.tFK), Integer.valueOf(localbrb.euw), Float.valueOf(localbrb.tHP), Integer.valueOf(localbrb.sNU), Integer.valueOf(localbrb.swP) });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (brb)this.dmK.ecE.ecN;
    paramArrayOfByte = (brc)this.dmK.ecF.ecN;
    y.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.tHO), Integer.valueOf(paramArrayOfByte.euw) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.euw == 1)) {
      this.oaK = true;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bly bAx()
  {
    return (brc)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 367;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */