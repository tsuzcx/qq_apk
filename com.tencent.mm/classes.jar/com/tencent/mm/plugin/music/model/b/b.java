package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b hZD;
  public a wAD;
  public bhj wAN;
  public boolean wAO;
  public boolean wAP;
  
  public b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(220682);
    this.wAD = parama;
    this.wAO = paramBoolean1;
    this.wAP = paramBoolean2;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bhi();
    ((b.a)localObject).hQG = new bhj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
    ((b.a)localObject).funcId = 520;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (bhi)this.hZD.hQD.hQJ;
    ((bhi)localObject).iko = parama.field_songId;
    if (parama.field_songWebUrl != null) {
      ((bhi)localObject).GVx = z.al(parama.field_songWebUrl.getBytes());
    }
    if (parama.field_songMId != null) {
      ((bhi)localObject).GVA = z.al(parama.field_songMId.getBytes());
    }
    if (com.tencent.mm.ay.e.aKj())
    {
      i = 0;
      ((bhi)localObject).GVy = i;
      if (!com.tencent.mm.ay.e.aKi()) {
        break label243;
      }
    }
    label243:
    for (int i = 1;; i = 0)
    {
      ((bhi)localObject).GVz = i;
      ae.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[] { Integer.valueOf(parama.field_songId), parama.field_songWebUrl, Integer.valueOf(((bhi)localObject).GVy), Integer.valueOf(((bhi)localObject).GVz) });
      AppMethodBeat.o(220682);
      return;
      i = 1;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63098);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63097);
      return;
    }
    this.wAN = ((bhj)this.hZD.hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.b
 * JD-Core Version:    0.7.0.1
 */