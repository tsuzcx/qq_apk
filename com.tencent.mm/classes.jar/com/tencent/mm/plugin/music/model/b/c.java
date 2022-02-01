package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  private b hdD;
  public String playUrl;
  private bag tXa;
  public String tXb;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63099);
    this.tXb = "";
    this.playUrl = "";
    b.a locala = new b.a();
    locala.funcId = 769;
    locala.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
    locala.gUU = new bag();
    locala.gUV = new bah();
    this.hdD = locala.atI();
    this.tXa = ((bag)this.hdD.gUS.gUX);
    this.tXa.Dyp = paramString;
    this.playUrl = paramString;
    ad.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[] { paramString });
    AppMethodBeat.o(63099);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63100);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(63100);
    return i;
  }
  
  public final int getType()
  {
    return 769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63101);
    ad.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(63101);
      return;
    }
    paramq = (bah)this.hdD.gUT.gUX;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq != null)
    {
      this.tXb = paramq.Dyp;
      ad.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[] { this.tXb });
      AppMethodBeat.o(63101);
      return;
    }
    ad.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
    AppMethodBeat.o(63101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.c
 * JD-Core Version:    0.7.0.1
 */