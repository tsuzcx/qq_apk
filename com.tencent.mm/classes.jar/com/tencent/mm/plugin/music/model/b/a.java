package com.tencent.mm.plugin.music.model.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ph;
import com.tencent.mm.protocal.c.pi;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private f dmL;
  private b esv;
  public ph mzG;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    b.a locala = new b.a();
    locala.ecG = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.ecH = new ph();
    locala.ecI = new pi();
    this.esv = locala.Kt();
    this.mzG = ((ph)this.esv.ecE.ecN);
    this.mzG.pyo = paramInt;
    this.mzG.euK = parama.field_appId;
    this.mzG.sMY = parama.field_songAlbumUrl;
    this.mzG.sMZ = parama.field_songHAlbumUrl;
    this.mzG.sNb = parama.field_songWifiUrl;
    this.mzG.sNc = parama.field_songWapLinkUrl;
    this.mzG.sNa = parama.field_songWebUrl;
    this.mzG.bGw = parama.field_songName;
    this.mzG.eux = parama.field_musicId;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 940;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */