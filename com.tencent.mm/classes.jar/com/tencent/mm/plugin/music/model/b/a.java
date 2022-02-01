package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  private b hEg;
  public vn vfI;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63093);
    b.a locala = new b.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.hvt = new vn();
    locala.hvu = new vo();
    this.hEg = locala.aAz();
    this.vfI = ((vn)this.hEg.hvr.hvw);
    this.vfI.Scene = paramInt;
    this.vfI.hOf = parama.field_appId;
    this.vfI.EpM = parama.field_songAlbumUrl;
    this.vfI.EpN = parama.field_songHAlbumUrl;
    this.vfI.EpP = parama.field_songWifiUrl;
    this.vfI.EpQ = parama.field_songWapLinkUrl;
    this.vfI.EpO = parama.field_songWebUrl;
    this.vfI.Title = parama.field_songName;
    this.vfI.hNS = parama.field_musicId;
    AppMethodBeat.o(63093);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63094);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */