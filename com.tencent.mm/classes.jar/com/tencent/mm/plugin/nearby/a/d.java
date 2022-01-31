package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public String ePR;
  public String mCz;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new atv();
    ((b.a)localObject).ecI = new atw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).ecG = 376;
    ((b.a)localObject).ecJ = 183;
    ((b.a)localObject).ecK = 1000000183;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (atv)this.dmK.ecE.ecN;
    ((atv)localObject).ssq = 1;
    ((atv)localObject).sGJ = paramFloat1;
    ((atv)localObject).sGK = paramFloat2;
    ((atv)localObject).sUn = paramInt;
    ((atv)localObject).sUo = paramString1;
    ((atv)localObject).sUp = paramString2;
    ((atv)localObject).sUq = 0;
    y.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new atv();
    ((b.a)localObject).ecI = new atw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).ecG = 376;
    ((b.a)localObject).ecJ = 183;
    ((b.a)localObject).ecK = 1000000183;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (atv)this.dmK.ecE.ecN;
    ((atv)localObject).sGJ = 0.0F;
    ((atv)localObject).sGK = 0.0F;
    ((atv)localObject).sUn = 0;
    ((atv)localObject).sUq = 0;
    ((atv)localObject).sUo = "";
    ((atv)localObject).sUp = "";
    ((atv)localObject).ssq = 2;
    ((atv)localObject).evE = paramString;
    ((atv)localObject).tpy = paramInt1;
    ((atv)localObject).tpx = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + rN());
    paramArrayOfByte = (atw)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramInt2 != 0) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      if (rN() == 1)
      {
        this.ePR = paramArrayOfByte.evE;
        this.mCz = paramArrayOfByte.tpz;
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    } while (rN() != 2);
    b.JO(((atv)((com.tencent.mm.ah.b)paramq).ecE.ecN).evE);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 376;
  }
  
  public final int rN()
  {
    return ((atv)this.dmK.ecE.ecN).ssq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */