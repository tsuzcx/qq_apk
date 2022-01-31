package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  public int bMU;
  private b dmK;
  private f dmL;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new xp();
    ((b.a)localObject).ecI = new xq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((b.a)localObject).ecG = 653;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (xp)this.dmK.ecE.ecN;
    this.bMU = paramInt1;
    ((xp)localObject).ssq = paramInt1;
    ((xp)localObject).sUm = paramString1;
    ((xp)localObject).sRr = paramString2;
    ((xp)localObject).sGJ = paramFloat2;
    ((xp)localObject).sGK = paramFloat1;
    ((xp)localObject).sUn = paramInt2;
    if (!bk.bl(paramString3)) {
      ((xp)localObject).sUo = paramString3;
    }
    if (!bk.bl(paramString4)) {
      ((xp)localObject).sUp = paramString4;
    }
    ((xp)localObject).sUq = paramInt3;
    y.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    com.tencent.mm.modelstat.o.a(2007, paramFloat2, paramFloat1, paramInt2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.bMU == 0)
    {
      paramq = bta();
      if (paramq != null)
      {
        paramq = paramq.svo;
        if (paramq != null)
        {
          long l = System.currentTimeMillis();
          int i = paramq.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            xr localxr = (xr)paramq.get(paramInt1);
            h localh = new h();
            if (!bk.bl(localxr.hPY)) {}
            for (localh.username = localxr.hPY;; localh.username = localxr.sUr)
            {
              y.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localxr.hPY, localxr.sRZ });
              localh.ebS = localxr.sRZ;
              localh.bK(true);
              paramArrayOfByte.add(localh);
              paramInt1 += 1;
              break;
            }
          }
          com.tencent.mm.ag.o.Kh().Q(paramArrayOfByte);
          y.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
        }
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final xq bta()
  {
    return (xq)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.a.a
 * JD-Core Version:    0.7.0.1
 */