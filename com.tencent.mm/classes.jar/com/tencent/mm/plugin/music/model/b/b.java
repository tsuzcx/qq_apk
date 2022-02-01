package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.bb.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  public a FRG;
  public caz FSa;
  public boolean FSb;
  public boolean FSc;
  private i callback;
  private d lKU;
  
  public b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(260301);
    this.FRG = parama;
    this.FSb = paramBoolean1;
    this.FSc = paramBoolean2;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cay();
    ((d.a)localObject).lBV = new caz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((d.a)localObject).funcId = 520;
    this.lKU = ((d.a)localObject).bgN();
    localObject = (cay)d.b.b(this.lKU.lBR);
    ((cay)localObject).lVI = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((cay)localObject).Tjk = z.aN(parama.field_songWebUrl.getBytes());
    }
    if (parama.field_songMId != null) {
      ((cay)localObject).Tjn = z.aN(parama.field_songMId.getBytes());
    }
    if (e.bnH())
    {
      i = 0;
      ((cay)localObject).Tjl = i;
      if (!e.bnG()) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      ((cay)localObject).Tjm = i;
      Log.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((cay)localObject).Tjl), Integer.valueOf(((cay)localObject).Tjm) });
      AppMethodBeat.o(260301);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63098);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(63098);
    return i;
  }
  
  public final int getType()
  {
    return 520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63097);
    Log.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63097);
      return;
    }
    this.FSa = ((caz)d.c.b(this.lKU.lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */