package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends j<a>
{
  public com.tencent.mm.sdk.e.e db;
  public com.tencent.mm.b.f<String, a> wBy;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.b> wBz;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = parame;
    this.wBy = new c(20);
    this.wBz = new c(10);
    AppMethodBeat.o(63172);
  }
  
  public final a B(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.O(paramf);
    a locala = atW(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.ijZ;
      locala.field_musicType = paramf.ijX;
      locala.field_appId = paramf.ikm;
      if (bu.isNullOrNil(locala.field_appId)) {
        locala.field_appId = com.tencent.mm.plugin.music.model.e.z(paramf);
      }
      locala.field_songAlbum = paramf.ikd;
      locala.field_songAlbumType = paramf.ikn;
      locala.field_songWifiUrl = paramf.ikf;
      locala.field_songName = paramf.ikb;
      locala.field_songSinger = paramf.ikc;
      locala.field_songWapLinkUrl = paramf.ikg;
      locala.field_songWebUrl = paramf.ikh;
      locala.field_songAlbumLocalPath = paramf.ikj;
      locala.field_songMediaId = paramf.ikp;
      locala.field_songSnsAlbumUser = paramf.ikr;
      locala.field_songAlbumUrl = paramf.ike;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.iki))) {
        locala.field_songLyric = paramf.iki;
      }
      locala.field_songSnsShareUser = paramf.ikt;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!bu.isNullOrNil(paramf.ikq))) {
        locala.field_songHAlbumUrl = paramf.ikq;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.U(paramf);
        locala.field_songId = paramf.iko;
      }
      if (locala.field_songMId == null) {
        locala.field_songMId = com.tencent.mm.plugin.music.h.e.aui(com.tencent.mm.plugin.music.h.e.S(paramf));
      }
      if (((bu.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!bu.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.ijX == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.ijZ).intValue();
        label348:
        locala.field_hideBanner = paramf.ikv;
        locala.field_jsWebUrlDomain = paramf.ikw;
        locala.field_startTime = paramf.dez;
        locala.ikx = paramf.ikx;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.iky;
        locala.field_musicbar_url = paramf.ikz;
        locala.field_srcUsername = paramf.dIt;
        locala.field_playbackRate = paramf.hOB;
        locala.hOJ = paramf.hOJ;
        if (i != 0)
        {
          ae.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.wBy.put(str, locala);
          AppMethodBeat.o(63177);
          return locala;
          ae.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
          insert(locala);
        }
      }
      catch (Exception localException)
      {
        break label348;
      }
    }
  }
  
  public final com.tencent.mm.plugin.music.model.b a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63174);
    if (this.wBz.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.wBz.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = b(parama, paramBoolean, true);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final a at(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    ae.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = atW(paramString);
    if (locala == null)
    {
      ae.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.wBy.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final a atW(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.wBy.get(paramString) != null)
    {
      paramString = (a)this.wBy.get(paramString);
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
      this.wBy.put(paramString, locala);
      AppMethodBeat.o(63173);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63173);
    return null;
  }
  
  public final com.tencent.mm.plugin.music.model.b b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(220684);
    com.tencent.mm.plugin.music.model.b localb = com.tencent.mm.plugin.music.model.b.a(parama.field_songLyric, ak.getContext().getString(2131761476), parama.field_songSnsShareUser, com.tencent.mm.plugin.music.model.e.a(parama), parama.field_songSinger, paramBoolean1, paramBoolean2);
    this.wBz.put(parama.field_musicId, localb);
    AppMethodBeat.o(220684);
    return localb;
  }
  
  public final com.tencent.mm.plugin.music.model.b h(a parama)
  {
    AppMethodBeat.i(220683);
    if (this.wBz.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.wBz.get(parama.field_musicId);
      AppMethodBeat.o(220683);
      return parama;
    }
    parama = b(parama, false, false);
    AppMethodBeat.o(220683);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */