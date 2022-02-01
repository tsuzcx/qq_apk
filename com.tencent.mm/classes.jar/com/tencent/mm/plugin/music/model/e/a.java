package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.c.ey;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class a
  extends ey
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String lVR;
  public boolean lVV = false;
  public boolean lVW = true;
  public boolean lVX;
  public String lzT;
  public String playUrl;
  
  static
  {
    AppMethodBeat.i(63171);
    info = ey.aoY();
    AppMethodBeat.o(63171);
  }
  
  public final boolean F(int[] paramArrayOfInt)
  {
    return (this.field_songBgColor == paramArrayOfInt[0]) && (this.field_songLyricColor == paramArrayOfInt[1]);
  }
  
  public final boolean fff()
  {
    return (this.field_songBgColor != 0) && (this.field_songLyricColor != 0);
  }
  
  public final boolean ffg()
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
  
  public final f ffh()
  {
    AppMethodBeat.i(63170);
    f localf = new f();
    localf.lVt = this.field_originMusicId;
    localf.lVr = this.field_musicType;
    localf.lVG = this.field_appId;
    localf.lVx = this.field_songAlbum;
    localf.lVH = this.field_songAlbumType;
    localf.lVy = this.field_songAlbumUrl;
    localf.lVK = this.field_songHAlbumUrl;
    localf.lVC = this.field_songLyric;
    localf.lVz = this.field_songWifiUrl;
    localf.lVv = this.field_songName;
    localf.lVw = this.field_songSinger;
    localf.lVA = this.field_songWapLinkUrl;
    localf.lVB = this.field_songWebUrl;
    localf.lVD = this.field_songAlbumLocalPath;
    localf.lVJ = this.field_songMediaId;
    localf.lVL = this.field_songSnsAlbumUser;
    localf.lVN = this.field_songSnsShareUser;
    localf.lVP = this.field_hideBanner;
    localf.lVQ = this.field_jsWebUrlDomain;
    localf.fod = this.field_startTime;
    localf.lVR = this.lVR;
    localf.protocol = this.field_protocol;
    localf.lVS = this.field_barBackToWebView;
    localf.lVT = this.field_musicbar_url;
    localf.playUrl = this.playUrl;
    localf.fUd = this.field_srcUsername;
    localf.lzL = this.field_playbackRate;
    localf.lzT = this.lzT;
    localf.lVX = this.lVX;
    localf.lVV = this.lVV;
    localf.lVW = this.lVW;
    AppMethodBeat.o(63170);
    return localf;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.a
 * JD-Core Version:    0.7.0.1
 */