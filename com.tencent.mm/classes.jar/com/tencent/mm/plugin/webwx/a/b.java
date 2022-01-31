package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  public int bMC;
  private f dmL;
  private final com.tencent.mm.ah.b esv;
  
  public b(int paramInt)
  {
    this.bMC = paramInt;
    b.a locala = new b.a();
    wk localwk = new wk();
    wl localwl = new wl();
    locala.ecH = localwk;
    locala.ecI = localwl;
    locala.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
    locala.ecG = 792;
    locala.ecJ = 0;
    locala.ecK = 0;
    localwk.kTS = paramInt;
    localwk.sTm = 1;
    this.esv = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 792;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.b
 * JD-Core Version:    0.7.0.1
 */