package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b hdD;
  public a tWO;
  public ayx tWY;
  public boolean tWZ;
  
  public b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63096);
    this.tWO = parama;
    this.tWZ = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ayw();
    ((b.a)localObject).gUV = new ayx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((b.a)localObject).funcId = 520;
    this.hdD = ((b.a)localObject).atI();
    localObject = (ayw)this.hdD.gUS.gUX;
    ((ayw)localObject).hnE = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((ayw)localObject).Dxj = z.am(parama.field_songWebUrl.getBytes());
    }
    if (com.tencent.mm.az.e.azP())
    {
      i = 0;
      ((ayw)localObject).Dxk = i;
      if (!com.tencent.mm.az.e.azO()) {
        break label211;
      }
    }
    label211:
    for (int i = 1;; i = 0)
    {
      ((ayw)localObject).Dxl = i;
      ad.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((ayw)localObject).Dxk), Integer.valueOf(((ayw)localObject).Dxl) });
      AppMethodBeat.o(63096);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(63098);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(63098);
    return i;
  }
  
  public final int getType()
  {
    return 520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63097);
    ad.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63097);
      return;
    }
    this.tWY = ((ayx)this.hdD.gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */