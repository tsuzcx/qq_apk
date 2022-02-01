package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public com.tencent.mm.b.f<String, a> AlG;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.e> AlH;
  public ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = paramISQLiteDatabase;
    this.AlG = new c(20);
    this.AlH = new c(10);
    AppMethodBeat.o(63172);
  }
  
  private com.tencent.mm.plugin.music.model.e b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219853);
    com.tencent.mm.plugin.music.model.e locale = com.tencent.mm.plugin.music.model.e.a(parama.field_songLyric, MMApplicationContext.getContext().getString(2131763403), parama.field_songSnsShareUser, m.a(parama), parama.field_songSinger, paramBoolean1, paramBoolean2);
    this.AlH.put(parama.field_musicId, locale);
    AppMethodBeat.o(219853);
    return locale;
  }
  
  public final a F(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.S(paramf);
    a locala = aHW(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.jeV;
      locala.field_musicType = paramf.jeT;
      locala.field_appId = paramf.jfi;
      if (Util.isNullOrNil(locala.field_appId)) {
        locala.field_appId = m.D(paramf);
      }
      locala.field_songAlbum = paramf.jeZ;
      locala.field_songAlbumType = paramf.jfj;
      locala.field_songWifiUrl = paramf.jfb;
      locala.field_songName = paramf.jeX;
      locala.field_songSinger = paramf.jeY;
      locala.field_songWapLinkUrl = paramf.jfc;
      locala.field_songWebUrl = paramf.jfd;
      locala.field_songAlbumLocalPath = paramf.jff;
      locala.field_songMediaId = paramf.jfl;
      locala.field_songSnsAlbumUser = paramf.jfn;
      locala.field_songAlbumUrl = paramf.jfa;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.jfe))) {
        locala.field_songLyric = paramf.jfe;
      }
      locala.field_songSnsShareUser = paramf.jfp;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!Util.isNullOrNil(paramf.jfm))) {
        locala.field_songHAlbumUrl = paramf.jfm;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.Y(paramf);
        locala.field_songId = paramf.jfk;
      }
      if (locala.field_songMId == null) {
        locala.field_songMId = com.tencent.mm.plugin.music.h.e.aIk(com.tencent.mm.plugin.music.h.e.W(paramf));
      }
      if (((Util.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!Util.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.jeT == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.jeV).intValue();
        label348:
        locala.field_hideBanner = paramf.jfr;
        locala.field_jsWebUrlDomain = paramf.jfs;
        locala.field_startTime = paramf.dvv;
        locala.jft = paramf.jft;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.jfu;
        locala.field_musicbar_url = paramf.jfv;
        locala.field_srcUsername = paramf.eag;
        locala.field_playbackRate = paramf.iJH;
        locala.iJP = paramf.iJP;
        locala.jfx = paramf.jfx;
        if (i != 0)
        {
          Log.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.AlG.put(str, locala);
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
    if (this.AlH.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.e)this.AlH.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = b(parama, paramBoolean, true);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final a aHW(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.AlG.get(paramString) != null)
    {
      paramString = (a)this.AlG.get(paramString);
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
      this.AlG.put(paramString, locala);
      AppMethodBeat.o(63173);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63173);
    return null;
  }
  
  public final a aw(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    Log.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = aHW(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.AlG.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final a b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219854);
    a locala = aHW(paramString1);
    if (locala == null)
    {
      Log.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramString1 });
      AppMethodBeat.o(219854);
      return null;
    }
    if (!Util.isNullOrNil(paramString2)) {
      locala.field_songAlbumUrl = paramString2;
    }
    locala.field_songHAlbumUrl = paramString3;
    locala.field_songLyric = paramString4;
    update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
    this.AlG.put(paramString1, locala);
    b(locala, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(219854);
    return locala;
  }
  
  public final com.tencent.mm.plugin.music.model.e i(a parama)
  {
    AppMethodBeat.i(219852);
    if (this.AlH.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.e)this.AlH.get(parama.field_musicId);
      AppMethodBeat.o(219852);
      return parama;
    }
    parama = b(parama, false, false);
    AppMethodBeat.o(219852);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */