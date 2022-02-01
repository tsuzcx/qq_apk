package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends ec
{
  public static c.a info;
  public String hOq;
  public String hty;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = ec.Th();
    AppMethodBeat.o(63171);
  }
  
  public final boolean B(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public final boolean djd()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean dje()
  {
    AppMethodBeat.i(63168);
    if (!bs.isNullOrNil(this.field_songHAlbumUrl))
    {
      AppMethodBeat.o(63168);
      return true;
    }
    AppMethodBeat.o(63168);
    return false;
  }
  
  public final f djf()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.hNS = this.field_originMusicId;
    localf.hNQ = this.field_musicType;
    localf.hOf = this.field_appId;
    localf.hNW = this.field_songAlbum;
    localf.hOg = this.field_songAlbumType;
    localf.hNX = this.field_songAlbumUrl;
    localf.hOj = this.field_songHAlbumUrl;
    localf.hOb = this.field_songLyric;
    localf.hNY = this.field_songWifiUrl;
    localf.hNU = this.field_songName;
    localf.hNV = this.field_songSinger;
    localf.hNZ = this.field_songWapLinkUrl;
    localf.hOa = this.field_songWebUrl;
    localf.hOc = this.field_songAlbumLocalPath;
    localf.hOi = this.field_songMediaId;
    localf.hOk = this.field_songSnsAlbumUser;
    localf.hOm = this.field_songSnsShareUser;
    localf.hOo = this.field_hideBanner;
    localf.hOp = this.field_jsWebUrlDomain;
    localf.cSh = this.field_startTime;
    localf.hOq = this.hOq;
    localf.protocol = this.field_protocol;
    localf.hOr = this.field_barBackToWebView;
    localf.hOs = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.dvl = this.field_srcUsername;
    localf.htq = this.field_playbackRate;
    localf.hty = this.hty;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */