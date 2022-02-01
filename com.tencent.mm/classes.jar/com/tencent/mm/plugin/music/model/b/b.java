package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b hEg;
  public bcp vfJ;
  public boolean vfK;
  public boolean vfL;
  public a vfz;
  
  public b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195611);
    this.vfz = parama;
    this.vfK = paramBoolean1;
    this.vfL = paramBoolean2;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bco();
    ((b.a)localObject).hvu = new bcp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((b.a)localObject).funcId = 520;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (bco)this.hEg.hvr.hvw;
    ((bco)localObject).hOh = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((bco)localObject).ESE = z.al(parama.field_songWebUrl.getBytes());
    }
    if (parama.field_songMId != null) {
      ((bco)localObject).ESH = z.al(parama.field_songMId.getBytes());
    }
    if (com.tencent.mm.ay.e.aGF())
    {
      i = 0;
      ((bco)localObject).ESF = i;
      if (!com.tencent.mm.ay.e.aGE()) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      ((bco)localObject).ESG = i;
      ac.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((bco)localObject).ESF), Integer.valueOf(((bco)localObject).ESG) });
      AppMethodBeat.o(195611);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(63098);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63097);
      return;
    }
    this.vfJ = ((bcp)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */