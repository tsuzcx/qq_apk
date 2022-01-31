package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aw.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  private com.tencent.mm.ai.b fBd;
  public a oZD;
  public aoq oZN;
  public boolean oZO;
  
  public b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(104965);
    this.oZD = parama;
    this.oZO = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aop();
    ((b.a)localObject).fsY = new aoq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((b.a)localObject).funcId = 520;
    this.fBd = ((b.a)localObject).ado();
    localObject = (aop)this.fBd.fsV.fta;
    ((aop)localObject).fKy = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((aop)localObject).xet = aa.ac(parama.field_songWebUrl.getBytes());
    }
    if (d.aiG())
    {
      i = 0;
      ((aop)localObject).xeu = i;
      if (!d.aiF()) {
        break label211;
      }
    }
    label211:
    for (int i = 1;; i = 0)
    {
      ((aop)localObject).xev = i;
      ab.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((aop)localObject).xeu), Integer.valueOf(((aop)localObject).xev) });
      AppMethodBeat.o(104965);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(104967);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(104967);
    return i;
  }
  
  public final int getType()
  {
    return 520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104966);
    ab.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104966);
      return;
    }
    this.oZN = ((aoq)this.fBd.fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */