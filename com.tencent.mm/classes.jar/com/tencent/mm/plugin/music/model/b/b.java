package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b hWL;
  public a wkU;
  public bgt wle;
  public boolean wlf;
  public boolean wlg;
  
  public b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192469);
    this.wkU = parama;
    this.wlf = paramBoolean1;
    this.wlg = paramBoolean2;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bgs();
    ((b.a)localObject).hNN = new bgt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((b.a)localObject).funcId = 520;
    this.hWL = ((b.a)localObject).aDC();
    localObject = (bgs)this.hWL.hNK.hNQ;
    ((bgs)localObject).ihv = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((bgs)localObject).GBX = z.al(parama.field_songWebUrl.getBytes());
    }
    if (parama.field_songMId != null) {
      ((bgs)localObject).GCa = z.al(parama.field_songMId.getBytes());
    }
    if (com.tencent.mm.az.e.aJQ())
    {
      i = 0;
      ((bgs)localObject).GBY = i;
      if (!com.tencent.mm.az.e.aJP()) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      ((bgs)localObject).GBZ = i;
      ad.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((bgs)localObject).GBY), Integer.valueOf(((bgs)localObject).GBZ) });
      AppMethodBeat.o(192469);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63098);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    this.wle = ((bgt)this.hWL.hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */