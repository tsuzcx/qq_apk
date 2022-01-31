package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axu;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.cca;

public final class h
  extends m
  implements k
{
  private final String bOL;
  private f dmL;
  public final String nQI;
  public final int nQJ;
  private final int scene;
  
  public h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.bOL = paramString1;
    this.nQI = paramString2;
    this.nQJ = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    axu localaxu = new axu();
    localaxu.bOL = this.bOL;
    localaxu.ttX = this.nQI;
    localaxu.ttY = this.nQJ;
    paramf.ecH = localaxu;
    paramf.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramf.ecI = new axv();
    paramf.ecG = 1144;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    return a(parame, paramf.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramString = (axv)((b)paramq).ecF.ecN;
    this.dmL.onSceneEnd(paramInt2, paramString.sQB.bLB, paramString.sQB.bLC, this);
  }
  
  public final int getType()
  {
    return 1144;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.h
 * JD-Core Version:    0.7.0.1
 */