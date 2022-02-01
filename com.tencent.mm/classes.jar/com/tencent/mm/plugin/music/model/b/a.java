package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private b hZD;
  public xp wAM;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63093);
    b.a locala = new b.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.hQF = new xp();
    locala.hQG = new xq();
    this.hZD = locala.aDS();
    this.wAM = ((xp)this.hZD.hQD.hQJ);
    this.wAM.Scene = paramInt;
    this.wAM.ikm = parama.field_appId;
    this.wAM.Gpw = parama.field_songAlbumUrl;
    this.wAM.Gpx = parama.field_songHAlbumUrl;
    this.wAM.Gpz = parama.field_songWifiUrl;
    this.wAM.GpA = parama.field_songWapLinkUrl;
    this.wAM.Gpy = parama.field_songWebUrl;
    this.wAM.Title = parama.field_songName;
    this.wAM.ijZ = parama.field_musicId;
    AppMethodBeat.o(63093);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63094);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */