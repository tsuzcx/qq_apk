package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends j<a>
{
  public com.tencent.mm.sdk.e.e db;
  public com.tencent.mm.b.f<String, a> tXI;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.b> tXJ;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = parame;
    this.tXI = new c(20);
    this.tXJ = new c(10);
    AppMethodBeat.o(63172);
  }
  
  public final a A(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.N(paramf);
    a locala = aiP(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.hnp;
      locala.field_musicType = paramf.hnn;
      locala.field_appId = paramf.hnC;
      if (bt.isNullOrNil(locala.field_appId)) {
        locala.field_appId = com.tencent.mm.plugin.music.model.e.y(paramf);
      }
      locala.field_songAlbum = paramf.hnt;
      locala.field_songAlbumType = paramf.hnD;
      locala.field_songWifiUrl = paramf.hnv;
      locala.field_songName = paramf.hnr;
      locala.field_songSinger = paramf.hns;
      locala.field_songWapLinkUrl = paramf.hnw;
      locala.field_songWebUrl = paramf.hnx;
      locala.field_songAlbumLocalPath = paramf.hnz;
      locala.field_songMediaId = paramf.hnF;
      locala.field_songSnsAlbumUser = paramf.hnH;
      locala.field_songAlbumUrl = paramf.hnu;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.hny))) {
        locala.field_songLyric = paramf.hny;
      }
      locala.field_songSnsShareUser = paramf.hnJ;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!bt.isNullOrNil(paramf.hnG))) {
        locala.field_songHAlbumUrl = paramf.hnG;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.S(paramf);
        locala.field_songId = paramf.hnE;
      }
      if (((bt.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!bt.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.hnn == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.hnp).intValue();
        label330:
        locala.field_hideBanner = paramf.hnL;
        locala.field_jsWebUrlDomain = paramf.hnM;
        locala.field_startTime = paramf.cUL;
        locala.hnN = paramf.hnN;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.hnO;
        locala.field_musicbar_url = paramf.hnP;
        locala.field_srcUsername = paramf.dxz;
        locala.field_playbackRate = paramf.gSR;
        locala.gSZ = paramf.gSZ;
        if (i != 0)
        {
          ad.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.tXI.put(str, locala);
          AppMethodBeat.o(63177);
          return locala;
          ad.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
          insert(locala);
        }
      }
      catch (Exception localException)
      {
        break label330;
      }
    }
  }
  
  public final a aiP(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.tXI.get(paramString) != null)
    {
      paramString = (a)this.tXI.get(paramString);
      AppMethodBeat.o(63173);
      return paramString;
    }
    Object localObject = String.format("Select * From Music Where musicId=?", new Object[0]);
    localObject = this.db.a((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      this.tXI.put(paramString, locala);
      AppMethodBeat.o(63173);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63173);
    return null;
  }
  
  public final a ap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    ad.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = aiP(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.tXI.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final com.tencent.mm.plugin.music.model.b b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63174);
    if (this.tXJ.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.tXJ.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = c(parama, paramBoolean);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final com.tencent.mm.plugin.music.model.b c(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63175);
    com.tencent.mm.plugin.music.model.b localb = com.tencent.mm.plugin.music.model.b.a(parama.field_songLyric, aj.getContext().getString(2131761476), parama.field_songSnsShareUser, com.tencent.mm.plugin.music.model.e.a(parama), parama.field_songSinger, paramBoolean);
    this.tXJ.put(parama.field_musicId, localb);
    AppMethodBeat.o(63175);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */