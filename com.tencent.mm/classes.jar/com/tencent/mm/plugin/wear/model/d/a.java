package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.aov;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  public String bJp;
  public String bwK;
  private f dmL;
  private com.tencent.mm.ah.b esv;
  
  public a(String paramString1, String paramString2)
  {
    this.bwK = paramString1;
    this.bJp = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).ecG = 1091;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((b.a)localObject).ecH = new aou();
    ((b.a)localObject).ecI = new aov();
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.esv = ((b.a)localObject).Kt();
    localObject = (aou)this.esv.ecE.ecN;
    ((aou)localObject).sAk = new com.tencent.mm.bv.b(paramString1.getBytes());
    ((aou)localObject).sAm = new com.tencent.mm.bv.b(paramString2.getBytes());
    ((aou)localObject).tkK = new com.tencent.mm.bv.b("5".getBytes());
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1091;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.a
 * JD-Core Version:    0.7.0.1
 */