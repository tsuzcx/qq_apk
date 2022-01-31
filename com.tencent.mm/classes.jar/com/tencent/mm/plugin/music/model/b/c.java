package com.tencent.mm.plugin.music.model.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private f dmL;
  private b esv;
  private akg mzJ;
  public String mzK = "";
  public String playUrl = "";
  
  public c(String paramString)
  {
    b.a locala = new b.a();
    locala.ecG = 769;
    locala.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
    locala.ecH = new akg();
    locala.ecI = new akh();
    this.esv = locala.Kt();
    this.mzJ = ((akg)this.esv.ecE.ecN);
    this.mzJ.tgN = paramString;
    this.playUrl = paramString;
    y.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[] { paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (akh)this.esv.ecF.ecN;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq != null)
    {
      this.mzK = paramq.tgN;
      y.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[] { this.mzK });
      return;
    }
    y.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
  }
  
  public final int getType()
  {
    return 769;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.c
 * JD-Core Version:    0.7.0.1
 */