package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  
  public c(String paramString, boolean paramBoolean)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bwk();
    ((b.a)localObject).ecI = new bwl();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/switchbrand";
    ((b.a)localObject).ecG = 1394;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bwk)this.dmK.ecE.ecN;
    ((bwk)localObject).sCO = paramString;
    ((bwk)localObject).tMS = paramBoolean;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final bwl bss()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (bwl)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final bwk bst()
  {
    if ((this.dmK != null) && (this.dmK.ecE.ecN != null)) {
      return (bwk)this.dmK.ecE.ecN;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1394;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.c
 * JD-Core Version:    0.7.0.1
 */