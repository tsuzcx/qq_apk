package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.av.e;
import com.tencent.mm.h.c.cv;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
  extends cv
{
  public static c.a buS = ;
  public String euV;
  public String playUrl;
  
  public final boolean bnA()
  {
    return !bk.bl(this.field_songHAlbumUrl);
  }
  
  public final e bnB()
  {
    e locale = new e();
    locale.eux = this.field_originMusicId;
    locale.euv = this.field_musicType;
    locale.euK = this.field_appId;
    locale.euB = this.field_songAlbum;
    locale.euL = this.field_songAlbumType;
    locale.euC = this.field_songAlbumUrl;
    locale.euD = this.field_songWifiUrl;
    locale.euz = this.field_songName;
    locale.euA = this.field_songSinger;
    locale.euE = this.field_songWapLinkUrl;
    locale.euF = this.field_songWebUrl;
    locale.euH = this.field_songAlbumLocalPath;
    locale.euN = this.field_songMediaId;
    locale.euP = this.field_songSnsAlbumUser;
    locale.euR = this.field_songSnsShareUser;
    locale.euT = this.field_hideBanner;
    locale.euU = this.field_jsWebUrlDomain;
    locale.startTime = this.field_startTime;
    locale.euV = this.euV;
    locale.protocol = this.field_protocol;
    locale.euW = this.field_barBackToWebView;
    locale.euX = this.field_musicbar_url;
    locale.playUrl = this.playUrl;
    return locale;
  }
  
  public final boolean bnz()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean o(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */