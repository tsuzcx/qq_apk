package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fn;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class a
  extends fn
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String oOT;
  public boolean oOX = false;
  public boolean oOY = true;
  public boolean oPa;
  public String oru;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = fn.aJm();
    AppMethodBeat.o(63171);
  }
  
  public final boolean J(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean goo()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean gop()
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
  
  public final f goq()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.oOv = this.field_originMusicId;
    localf.oOt = this.field_musicType;
    localf.oOI = this.field_appId;
    localf.oOz = this.field_songAlbum;
    localf.oOJ = this.field_songAlbumType;
    localf.oOA = this.field_songAlbumUrl;
    localf.oOM = this.field_songHAlbumUrl;
    localf.oOE = this.field_songLyric;
    localf.oOB = this.field_songWifiUrl;
    localf.oOx = this.field_songName;
    localf.oOy = this.field_songSinger;
    localf.oOC = this.field_songWapLinkUrl;
    localf.oOD = this.field_songWebUrl;
    localf.oOF = this.field_songAlbumLocalPath;
    localf.oOL = this.field_songMediaId;
    localf.oON = this.field_songSnsAlbumUser;
    localf.oOP = this.field_songSnsShareUser;
    localf.oOR = this.field_hideBanner;
    localf.oOS = this.field_jsWebUrlDomain;
    localf.startTime = this.field_startTime;
    localf.oOT = this.oOT;
    localf.protocol = this.field_protocol;
    localf.oOU = this.field_barBackToWebView;
    localf.oOV = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.iaa = this.field_srcUsername;
    localf.orm = this.field_playbackRate;
    localf.oru = this.oru;
    localf.oPa = this.oPa;
    localf.oOX = this.oOX;
    localf.oOY = this.oOY;
    localf.oOZ = this.field_mid;
    AppMethodBeat.o(63170);
    return localf;
  }
  
  public final boolean i(a parama)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */