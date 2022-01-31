package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jl;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new jl();
    ((b.a)localObject).ecI = new jm();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((b.a)localObject).ecG = 1064;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (jl)this.dmK.ecE.ecN;
    ((jl)localObject).sEc = d.soV;
    ((jl)localObject).sEd = d.soU;
    ((jl)localObject).sEe = d.soX;
    ((jl)localObject).sEf = d.soY;
    ((jl)localObject).sEg = x.cqJ();
    ((jl)localObject).nFr = 11294;
    ((jl)localObject).sEh = null;
    ((jl)localObject).nGH = paramString1;
    ((jl)localObject).nGG = paramString2;
    ((jl)localObject).type = paramInt1;
    ((jl)localObject).value = paramString3;
    ((jl)localObject).count = paramInt2;
    ((jl)localObject).mLS = paramInt3;
    y.v("MircoMsg.NetSceneScanProductReport", "statid:" + paramString2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1064;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.i
 * JD-Core Version:    0.7.0.1
 */