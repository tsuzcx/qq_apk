package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  public abc LMU;
  private h callback;
  private c oDw;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63093);
    c.a locala = new c.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.otE = new abc();
    locala.otF = new abd();
    this.oDw = locala.bEF();
    this.LMU = ((abc)c.b.b(this.oDw.otB));
    this.LMU.IJG = paramInt;
    this.LMU.oOI = parama.field_appId;
    this.LMU.Zjz = parama.field_songAlbumUrl;
    this.LMU.ZjA = parama.field_songHAlbumUrl;
    this.LMU.ZjC = parama.field_songWifiUrl;
    this.LMU.ZjD = parama.field_songWapLinkUrl;
    this.LMU.ZjB = parama.field_songWebUrl;
    this.LMU.hAP = parama.field_songName;
    this.LMU.oOv = parama.field_musicId;
    this.LMU.ZjG = parama.field_songSinger;
    AppMethodBeat.o(63093);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63094);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */