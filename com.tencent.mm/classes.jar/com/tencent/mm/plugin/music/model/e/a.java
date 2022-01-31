package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.c.dg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends dg
{
  public static c.a info;
  public String fKH;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(105033);
    info = dg.Hm();
    AppMethodBeat.o(105033);
  }
  
  public final boolean bVW()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean bVX()
  {
    AppMethodBeat.i(105030);
    if (!bo.isNullOrNil(this.field_songHAlbumUrl))
    {
      AppMethodBeat.o(105030);
      return true;
    }
    AppMethodBeat.o(105030);
    return false;
  }
  
  public final e bVY()
  {
    AppMethodBeat.i(105032);
    e locale = new e();
    locale.fKj = this.field_originMusicId;
    locale.fKh = this.field_musicType;
    locale.fKw = this.field_appId;
    locale.fKn = this.field_songAlbum;
    locale.fKx = this.field_songAlbumType;
    locale.fKo = this.field_songAlbumUrl;
    locale.fKp = this.field_songWifiUrl;
    locale.fKl = this.field_songName;
    locale.fKm = this.field_songSinger;
    locale.fKq = this.field_songWapLinkUrl;
    locale.fKr = this.field_songWebUrl;
    locale.fKt = this.field_songAlbumLocalPath;
    locale.fKz = this.field_songMediaId;
    locale.fKB = this.field_songSnsAlbumUser;
    locale.fKD = this.field_songSnsShareUser;
    locale.fKF = this.field_hideBanner;
    locale.fKG = this.field_jsWebUrlDomain;
    locale.startTime = this.field_startTime;
    locale.fKH = this.fKH;
    locale.protocol = this.field_protocol;
    locale.fKI = this.field_barBackToWebView;
    locale.fKJ = this.field_musicbar_url;
    locale.playUrl = this.playUrl;
    AppMethodBeat.o(105032);
    return locale;
  }
  
  public final boolean g(a parama)
  {
    AppMethodBeat.i(105031);
    if (parama == null)
    {
      AppMethodBeat.o(105031);
      return false;
    }
    boolean bool = this.field_musicId.equals(parama.field_musicId);
    AppMethodBeat.o(105031);
    return bool;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean y(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */