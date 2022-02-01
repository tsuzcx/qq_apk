package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  public a AkC;
  public bth AkU;
  public boolean AkV;
  public boolean AkW;
  private i callback;
  private d iUB;
  
  public b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219850);
    this.AkC = parama;
    this.AkV = paramBoolean1;
    this.AkW = paramBoolean2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new btg();
    ((d.a)localObject).iLO = new bth();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((d.a)localObject).funcId = 520;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (btg)this.iUB.iLK.iLR;
    ((btg)localObject).jfk = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((btg)localObject).LZR = z.aC(parama.field_songWebUrl.getBytes());
    }
    if (parama.field_songMId != null) {
      ((btg)localObject).LZU = z.aC(parama.field_songMId.getBytes());
    }
    if (e.bem())
    {
      i = 0;
      ((btg)localObject).LZS = i;
      if (!e.bel()) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      ((btg)localObject).LZT = i;
      Log.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((btg)localObject).LZS), Integer.valueOf(((btg)localObject).LZT) });
      AppMethodBeat.o(219850);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63098);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
    this.AkU = ((bth)this.iUB.iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */