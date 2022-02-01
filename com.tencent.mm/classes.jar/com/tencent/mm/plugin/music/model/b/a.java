package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  public zb AkT;
  private i callback;
  private d iUB;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63093);
    d.a locala = new d.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.iLN = new zb();
    locala.iLO = new zc();
    this.iUB = locala.aXF();
    this.AkT = ((zb)this.iUB.iLK.iLR);
    this.AkT.Scene = paramInt;
    this.AkT.jfi = parama.field_appId;
    this.AkT.Lki = parama.field_songAlbumUrl;
    this.AkT.Lkj = parama.field_songHAlbumUrl;
    this.AkT.Lkl = parama.field_songWifiUrl;
    this.AkT.Lkm = parama.field_songWapLinkUrl;
    this.AkT.Lkk = parama.field_songWebUrl;
    this.AkT.Title = parama.field_songName;
    this.AkT.jeV = parama.field_musicId;
    AppMethodBeat.o(63093);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63094);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(63094);
    return i;
  }
  
  public final int getType()
  {
    return 940;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63095);
    Log.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(63095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */