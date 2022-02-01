package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.c.em;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends em
{
  public static c.a info;
  public String hOJ;
  public String ikx;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = em.VD();
    AppMethodBeat.o(63171);
  }
  
  public final boolean C(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public final boolean dwE()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean dwF()
  {
    AppMethodBeat.i(63168);
    if (!bu.isNullOrNil(this.field_songHAlbumUrl))
    {
      AppMethodBeat.o(63168);
      return true;
    }
    AppMethodBeat.o(63168);
    return false;
  }
  
  public final f dwG()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.ijZ = this.field_originMusicId;
    localf.ijX = this.field_musicType;
    localf.ikm = this.field_appId;
    localf.ikd = this.field_songAlbum;
    localf.ikn = this.field_songAlbumType;
    localf.ike = this.field_songAlbumUrl;
    localf.ikq = this.field_songHAlbumUrl;
    localf.iki = this.field_songLyric;
    localf.ikf = this.field_songWifiUrl;
    localf.ikb = this.field_songName;
    localf.ikc = this.field_songSinger;
    localf.ikg = this.field_songWapLinkUrl;
    localf.ikh = this.field_songWebUrl;
    localf.ikj = this.field_songAlbumLocalPath;
    localf.ikp = this.field_songMediaId;
    localf.ikr = this.field_songSnsAlbumUser;
    localf.ikt = this.field_songSnsShareUser;
    localf.ikv = this.field_hideBanner;
    localf.ikw = this.field_jsWebUrlDomain;
    localf.dez = this.field_startTime;
    localf.ikx = this.ikx;
    localf.protocol = this.field_protocol;
    localf.iky = this.field_barBackToWebView;
    localf.ikz = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.dIt = this.field_srcUsername;
    localf.hOB = this.field_playbackRate;
    localf.hOJ = this.hOJ;
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