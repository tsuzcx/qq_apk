package com.tencent.mm.plugin.music.model.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.av.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private f dmL;
  private com.tencent.mm.ah.b esv;
  public ajj mzH;
  public boolean mzI;
  public a mzx;
  
  public b(a parama, boolean paramBoolean)
  {
    this.mzx = parama;
    this.mzI = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aji();
    ((b.a)localObject).ecI = new ajj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((b.a)localObject).ecG = 520;
    this.esv = ((b.a)localObject).Kt();
    localObject = (aji)this.esv.ecE.ecN;
    ((aji)localObject).euM = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((aji)localObject).tfU = aa.I(parama.field_songWebUrl.getBytes());
    }
    if (d.PD())
    {
      i = 0;
      ((aji)localObject).tfV = i;
      if (!d.PC()) {
        break label201;
      }
    }
    label201:
    for (int i = 1;; i = 0)
    {
      ((aji)localObject).tfW = i;
      y.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((aji)localObject).tfV), Integer.valueOf(((aji)localObject).tfW) });
      return;
      i = 1;
      break;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.mzH = ((ajj)this.esv.ecF.ecN);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */