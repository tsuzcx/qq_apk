package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.protocal.c.bzb;
import java.util.List;

public final class e
  extends m
  implements k
{
  public float bgU;
  private b dmK;
  private f dmL;
  public int igH;
  public List<bzb> nGT;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    aza localaza = new aza();
    localaza.sDV = paramInt1;
    localaza.tuN = paramInt2;
    localaza.tuS = paramString1;
    localaza.tuT = paramString2;
    locala.ecH = localaza;
    locala.ecI = new azb();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.ecG = 294;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.igH = paramInt1;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.bgU = ((azb)((b)paramq).ecF.ecN).tuU;
    this.nGT = ((azb)((b)paramq).ecF.ecN).tec;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final String bxg()
  {
    return ((azb)this.dmK.ecF.ecN).nGW;
  }
  
  public final int getType()
  {
    return 294;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.e
 * JD-Core Version:    0.7.0.1
 */