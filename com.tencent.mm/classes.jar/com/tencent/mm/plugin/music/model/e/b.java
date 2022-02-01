package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends MAutoStorage<a>
{
  public com.tencent.mm.b.f<String, a> LNJ;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.e> LNK;
  public ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = paramISQLiteDatabase;
    this.LNJ = new c(20);
    this.LNK = new c(10);
    AppMethodBeat.o(63172);
  }
  
  public final a K(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.Y(paramf);
    a locala = aPg(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.oOv;
      locala.field_musicType = paramf.oOt;
      locala.field_appId = paramf.oOI;
      if (Util.isNullOrNil(locala.field_appId)) {
        locala.field_appId = m.I(paramf);
      }
      locala.field_songAlbum = paramf.oOz;
      locala.field_songAlbumType = paramf.oOJ;
      locala.field_songWifiUrl = paramf.oOB;
      locala.field_songName = paramf.oOx;
      locala.field_songSinger = paramf.oOy;
      locala.field_songWapLinkUrl = paramf.oOC;
      locala.field_songWebUrl = paramf.oOD;
      locala.field_songAlbumLocalPath = paramf.oOF;
      locala.field_songMediaId = paramf.oOL;
      locala.field_songSnsAlbumUser = paramf.oON;
      locala.field_songAlbumUrl = paramf.oOA;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.oOE))) {
        locala.field_songLyric = paramf.oOE;
      }
      locala.field_songSnsShareUser = paramf.oOP;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!Util.isNullOrNil(paramf.oOM))) {
        locala.field_songHAlbumUrl = paramf.oOM;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.ae(paramf);
        locala.field_songId = paramf.oOK;
      }
      if (locala.field_songMId == null) {
        locala.field_songMId = com.tencent.mm.plugin.music.h.e.aPu(com.tencent.mm.plugin.music.h.e.ac(paramf));
      }
      if (((Util.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!Util.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.oOt == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.oOv).intValue();
        label348:
        locala.field_hideBanner = paramf.oOR;
        locala.field_jsWebUrlDomain = paramf.oOS;
        locala.field_startTime = paramf.startTime;
        locala.oOT = paramf.oOT;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.oOU;
        locala.field_musicbar_url = paramf.oOV;
        locala.field_srcUsername = paramf.iaa;
        locala.field_playbackRate = paramf.orm;
        locala.oru = paramf.oru;
        locala.oPa = paramf.oPa;
        locala.oOX = paramf.oOX;
        locala.oOY = paramf.oOY;
        locala.field_mid = paramf.oOZ;
        if (i != 0)
        {
          Log.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.LNJ.put(str, locala);
          AppMethodBeat.o(63177);
          return locala;
          Log.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
          insert(locala);
        }
      }
      catch (Exception localException)
      {
        break label348;
      }
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63174);
    if (this.LNK.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.e)this.LNK.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = b(parama, paramBoolean, true);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final a aG(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    Log.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = aPg(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.LNJ.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final a aPg(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.LNJ.get(paramString) != null)
    {
      paramString = (a)this.LNJ.get(paramString);
      AppMethodBeat.o(63173);
      return paramString;
    }
    Object localObject = String.format("Select * From Music Where musicId=?", new Object[0]);
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      this.LNJ.put(paramString, locala);
      AppMethodBeat.o(63173);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63173);
    return null;
  }
  
  public final a b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(271114);
    a locala = aPg(paramString1);
    if (locala == null)
    {
      Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramString1 });
      AppMethodBeat.o(271114);
      return null;
    }
    if (!Util.isNullOrNil(paramString2)) {
      locala.field_songAlbumUrl = paramString2;
    }
    locala.field_songHAlbumUrl = paramString3;
    if (!TextUtils.isEmpty(paramString4)) {
      locala.field_songLyric = paramString4;
    }
    update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
    this.LNJ.put(paramString1, locala);
    b(locala, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(271114);
    return locala;
  }
  
  public final com.tencent.mm.plugin.music.model.e b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(271109);
    com.tencent.mm.plugin.music.model.e locale = com.tencent.mm.plugin.music.model.e.a(parama.field_songLyric, MMApplicationContext.getContext().getString(a.h.music_prefix), parama.field_songSnsShareUser, m.a(parama), parama.field_songSinger, paramBoolean1, paramBoolean2);
    this.LNK.put(parama.field_musicId, locale);
    AppMethodBeat.o(271109);
    return locale;
  }
  
  public final List<a> gor()
  {
    AppMethodBeat.i(271140);
    Object localObject = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ?  order by updateTime DESC limit 10", new Object[] { "Music" });
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localObject = this.db.rawQuery((String)localObject, new String[] { String.valueOf(l - 604800000L), "6" });
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localArrayList.add(locala);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(271140);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */