package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.c.em;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends em
{
  public static c.a info;
  public String hLQ;
  public String ihE;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = em.Vv();
    AppMethodBeat.o(63171);
  }
  
  public final boolean B(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public final boolean dtp()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean dtq()
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
  
  public final f dtr()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.ihg = this.field_originMusicId;
    localf.ihe = this.field_musicType;
    localf.iht = this.field_appId;
    localf.ihk = this.field_songAlbum;
    localf.ihu = this.field_songAlbumType;
    localf.ihl = this.field_songAlbumUrl;
    localf.ihx = this.field_songHAlbumUrl;
    localf.ihp = this.field_songLyric;
    localf.ihm = this.field_songWifiUrl;
    localf.ihi = this.field_songName;
    localf.ihj = this.field_songSinger;
    localf.ihn = this.field_songWapLinkUrl;
    localf.iho = this.field_songWebUrl;
    localf.ihq = this.field_songAlbumLocalPath;
    localf.ihw = this.field_songMediaId;
    localf.ihy = this.field_songSnsAlbumUser;
    localf.ihA = this.field_songSnsShareUser;
    localf.ihC = this.field_hideBanner;
    localf.ihD = this.field_jsWebUrlDomain;
    localf.ddx = this.field_startTime;
    localf.ihE = this.ihE;
    localf.protocol = this.field_protocol;
    localf.ihF = this.field_barBackToWebView;
    localf.ihG = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.dHo = this.field_srcUsername;
    localf.hLI = this.field_playbackRate;
    localf.hLQ = this.hLQ;
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