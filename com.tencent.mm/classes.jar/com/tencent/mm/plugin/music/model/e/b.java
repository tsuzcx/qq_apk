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
  public com.tencent.mm.b.f<String, a> FSN;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.e> FSO;
  public ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = paramISQLiteDatabase;
    this.FSN = new c(20);
    this.FSO = new c(10);
    AppMethodBeat.o(63172);
  }
  
  private com.tencent.mm.plugin.music.model.e b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(260044);
    com.tencent.mm.plugin.music.model.e locale = com.tencent.mm.plugin.music.model.e.a(parama.field_songLyric, MMApplicationContext.getContext().getString(a.h.music_prefix), parama.field_songSnsShareUser, m.a(parama), parama.field_songSinger, paramBoolean1, paramBoolean2);
    this.FSO.put(parama.field_musicId, locale);
    AppMethodBeat.o(260044);
    return locale;
  }
  
  public final a F(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.S(paramf);
    a locala = aSm(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.lVt;
      locala.field_musicType = paramf.lVr;
      locala.field_appId = paramf.lVG;
      if (Util.isNullOrNil(locala.field_appId)) {
        locala.field_appId = m.D(paramf);
      }
      locala.field_songAlbum = paramf.lVx;
      locala.field_songAlbumType = paramf.lVH;
      locala.field_songWifiUrl = paramf.lVz;
      locala.field_songName = paramf.lVv;
      locala.field_songSinger = paramf.lVw;
      locala.field_songWapLinkUrl = paramf.lVA;
      locala.field_songWebUrl = paramf.lVB;
      locala.field_songAlbumLocalPath = paramf.lVD;
      locala.field_songMediaId = paramf.lVJ;
      locala.field_songSnsAlbumUser = paramf.lVL;
      locala.field_songAlbumUrl = paramf.lVy;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.lVC))) {
        locala.field_songLyric = paramf.lVC;
      }
      locala.field_songSnsShareUser = paramf.lVN;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!Util.isNullOrNil(paramf.lVK))) {
        locala.field_songHAlbumUrl = paramf.lVK;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.Y(paramf);
        locala.field_songId = paramf.lVI;
      }
      if (locala.field_songMId == null) {
        locala.field_songMId = com.tencent.mm.plugin.music.h.e.aSA(com.tencent.mm.plugin.music.h.e.W(paramf));
      }
      if (((Util.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!Util.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.lVr == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.lVt).intValue();
        label348:
        locala.field_hideBanner = paramf.lVP;
        locala.field_jsWebUrlDomain = paramf.lVQ;
        locala.field_startTime = paramf.fod;
        locala.lVR = paramf.lVR;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.lVS;
        locala.field_musicbar_url = paramf.lVT;
        locala.field_srcUsername = paramf.fUd;
        locala.field_playbackRate = paramf.lzL;
        locala.lzT = paramf.lzT;
        locala.lVX = paramf.lVX;
        locala.lVV = paramf.lVV;
        locala.lVW = paramf.lVW;
        if (i != 0)
        {
          Log.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.FSN.put(str, locala);
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
    if (this.FSO.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.e)this.FSO.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = b(parama, paramBoolean, true);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final a aSm(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.FSN.get(paramString) != null)
    {
      paramString = (a)this.FSN.get(paramString);
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
      this.FSN.put(paramString, locala);
      AppMethodBeat.o(63173);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63173);
    return null;
  }
  
  public final a az(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    Log.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = aSm(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.FSN.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final a b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(260046);
    a locala = aSm(paramString1);
    if (locala == null)
    {
      Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramString1 });
      AppMethodBeat.o(260046);
      return null;
    }
    if (!Util.isNullOrNil(paramString2)) {
      locala.field_songAlbumUrl = paramString2;
    }
    locala.field_songHAlbumUrl = paramString3;
    locala.field_songLyric = paramString4;
    update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
    this.FSN.put(paramString1, locala);
    b(locala, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(260046);
    return locala;
  }
  
  public final List<a> ffi()
  {
    AppMethodBeat.i(260055);
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
    AppMethodBeat.o(260055);
    return localArrayList;
  }
  
  public final com.tencent.mm.plugin.music.model.e i(a parama)
  {
    AppMethodBeat.i(260041);
    if (this.FSO.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.e)this.FSO.get(parama.field_musicId);
      AppMethodBeat.o(260041);
      return parama;
    }
    parama = b(parama, false, false);
    AppMethodBeat.o(260041);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */