package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  public zf FRZ;
  private i callback;
  private d lKU;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63093);
    d.a locala = new d.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.lBU = new zf();
    locala.lBV = new zg();
    this.lKU = locala.bgN();
    this.FRZ = ((zf)d.b.b(this.lKU.lBR));
    this.FRZ.CPw = paramInt;
    this.FRZ.lVG = parama.field_appId;
    this.FRZ.Slp = parama.field_songAlbumUrl;
    this.FRZ.Slq = parama.field_songHAlbumUrl;
    this.FRZ.Sls = parama.field_songWifiUrl;
    this.FRZ.Slt = parama.field_songWapLinkUrl;
    this.FRZ.Slr = parama.field_songWebUrl;
    this.FRZ.fwr = parama.field_songName;
    this.FRZ.lVt = parama.field_musicId;
    this.FRZ.Slw = parama.field_songSinger;
    AppMethodBeat.o(63093);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63094);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */