package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private b hWL;
  public xm wld;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63093);
    b.a locala = new b.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.hNM = new xm();
    locala.hNN = new xn();
    this.hWL = locala.aDC();
    this.wld = ((xm)this.hWL.hNK.hNQ);
    this.wld.Scene = paramInt;
    this.wld.iht = parama.field_appId;
    this.wld.FWX = parama.field_songAlbumUrl;
    this.wld.FWY = parama.field_songHAlbumUrl;
    this.wld.FXa = parama.field_songWifiUrl;
    this.wld.FXb = parama.field_songWapLinkUrl;
    this.wld.FWZ = parama.field_songWebUrl;
    this.wld.Title = parama.field_songName;
    this.wld.ihg = parama.field_musicId;
    AppMethodBeat.o(63093);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63094);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(63094);
    return i;
  }
  
  public final int getType()
  {
    return 940;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63095);
    ad.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */