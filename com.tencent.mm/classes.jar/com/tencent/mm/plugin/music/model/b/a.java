package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  private b fBd;
  public sl oZM;
  
  public a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(104962);
    b.a locala = new b.a();
    locala.funcId = 940;
    locala.uri = "/cgi-bin/micromsg-bin/checkmusic";
    locala.fsX = new sl();
    locala.fsY = new sm();
    this.fBd = locala.ado();
    this.oZM = ((sl)this.fBd.fsV.fta);
    this.oZM.Scene = paramInt;
    this.oZM.fKw = parama.field_appId;
    this.oZM.wKO = parama.field_songAlbumUrl;
    this.oZM.wKP = parama.field_songHAlbumUrl;
    this.oZM.wKR = parama.field_songWifiUrl;
    this.oZM.wKS = parama.field_songWapLinkUrl;
    this.oZM.wKQ = parama.field_songWebUrl;
    this.oZM.Title = parama.field_songName;
    this.oZM.fKj = parama.field_musicId;
    AppMethodBeat.o(104962);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(104963);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(104963);
    return i;
  }
  
  public final int getType()
  {
    return 940;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104964);
    ab.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b.a
 * JD-Core Version:    0.7.0.1
 */