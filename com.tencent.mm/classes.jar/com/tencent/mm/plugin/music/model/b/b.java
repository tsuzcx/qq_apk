package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.aw.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  public a LMB;
  public cqi LMV;
  public boolean LMW;
  public boolean LMX;
  private h callback;
  private c oDw;
  
  public b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(271271);
    this.LMB = parama;
    this.LMW = paramBoolean1;
    this.LMX = paramBoolean2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cqh();
    ((c.a)localObject).otF = new cqi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((c.a)localObject).funcId = 520;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (cqh)c.b.b(this.oDw.otB);
    ((cqh)localObject).oOK = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((cqh)localObject).aawN = w.aN(parama.field_songWebUrl.getBytes());
    }
    if (parama.field_songMId != null) {
      ((cqh)localObject).aawQ = w.aN(parama.field_songMId.getBytes());
    }
    if (e.bLu())
    {
      i = 0;
      ((cqh)localObject).aawO = i;
      if (!e.bLt()) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      ((cqh)localObject).aawP = i;
      Log.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((cqh)localObject).aawO), Integer.valueOf(((cqh)localObject).aawP) });
      AppMethodBeat.o(271271);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63098);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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
    this.LMV = ((cqi)c.c.b(this.oDw.otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */