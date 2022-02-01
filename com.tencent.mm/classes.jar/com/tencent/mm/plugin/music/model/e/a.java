package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.c.et;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends et
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String iJP;
  public String jft;
  public boolean jfx;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = et.ajs();
    AppMethodBeat.o(63171);
  }
  
  public final boolean G(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public final boolean euM()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean euN()
  {
    AppMethodBeat.i(63168);
    if (!Util.isNullOrNil(this.field_songHAlbumUrl))
    {
      AppMethodBeat.o(63168);
      return true;
    }
    AppMethodBeat.o(63168);
    return false;
  }
  
  public final f euO()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.jeV = this.field_originMusicId;
    localf.jeT = this.field_musicType;
    localf.jfi = this.field_appId;
    localf.jeZ = this.field_songAlbum;
    localf.jfj = this.field_songAlbumType;
    localf.jfa = this.field_songAlbumUrl;
    localf.jfm = this.field_songHAlbumUrl;
    localf.jfe = this.field_songLyric;
    localf.jfb = this.field_songWifiUrl;
    localf.jeX = this.field_songName;
    localf.jeY = this.field_songSinger;
    localf.jfc = this.field_songWapLinkUrl;
    localf.jfd = this.field_songWebUrl;
    localf.jff = this.field_songAlbumLocalPath;
    localf.jfl = this.field_songMediaId;
    localf.jfn = this.field_songSnsAlbumUser;
    localf.jfp = this.field_songSnsShareUser;
    localf.jfr = this.field_hideBanner;
    localf.jfs = this.field_jsWebUrlDomain;
    localf.dvv = this.field_startTime;
    localf.jft = this.jft;
    localf.protocol = this.field_protocol;
    localf.jfu = this.field_barBackToWebView;
    localf.jfv = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.eag = this.field_srcUsername;
    localf.iJH = this.field_playbackRate;
    localf.iJP = this.iJP;
    localf.jfx = this.jfx;
    AppMethodBeat.o(63170);
    return localf;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean h(a parama)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */