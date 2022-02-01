package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends dy
{
  public static c.a info;
  public String gSZ;
  public String hnN;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = dy.So();
    AppMethodBeat.o(63171);
  }
  
  public final boolean B(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public final boolean cVx()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean cVy()
  {
    AppMethodBeat.i(63168);
    if (!bt.isNullOrNil(this.field_songHAlbumUrl))
    {
      AppMethodBeat.o(63168);
      return true;
    }
    AppMethodBeat.o(63168);
    return false;
  }
  
  public final f cVz()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.hnp = this.field_originMusicId;
    localf.hnn = this.field_musicType;
    localf.hnC = this.field_appId;
    localf.hnt = this.field_songAlbum;
    localf.hnD = this.field_songAlbumType;
    localf.hnu = this.field_songAlbumUrl;
    localf.hnG = this.field_songHAlbumUrl;
    localf.hny = this.field_songLyric;
    localf.hnv = this.field_songWifiUrl;
    localf.hnr = this.field_songName;
    localf.hns = this.field_songSinger;
    localf.hnw = this.field_songWapLinkUrl;
    localf.hnx = this.field_songWebUrl;
    localf.hnz = this.field_songAlbumLocalPath;
    localf.hnF = this.field_songMediaId;
    localf.hnH = this.field_songSnsAlbumUser;
    localf.hnJ = this.field_songSnsShareUser;
    localf.hnL = this.field_hideBanner;
    localf.hnM = this.field_jsWebUrlDomain;
    localf.cUL = this.field_startTime;
    localf.hnN = this.hnN;
    localf.protocol = this.field_protocol;
    localf.hnO = this.field_barBackToWebView;
    localf.hnP = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.dxz = this.field_srcUsername;
    localf.gSR = this.field_playbackRate;
    localf.gSZ = this.gSZ;
    AppMethodBeat.o(63170);
    return localf;
  }
  
  public final boolean g(a parama)
  {
    AppMethodBeat.i(63169);
    if (parama == null)
    {
      AppMethodBeat.o(63169);
      return false;
    }
    boolean bool = this.field_musicId.equals(parama.field_musicId);
    AppMethodBeat.o(63169);
    return bool;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */