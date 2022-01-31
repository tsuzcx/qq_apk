package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends j<a>
{
  public com.tencent.mm.sdk.e.e db;
  public f<String, a> pax;
  public f<String, com.tencent.mm.plugin.music.model.a> pay;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "Music", null);
    AppMethodBeat.i(105034);
    this.db = parame;
    this.pax = new c(20);
    this.pay = new c(10);
    AppMethodBeat.o(105034);
  }
  
  public final a VC(String paramString)
  {
    AppMethodBeat.i(105035);
    if (this.pax.get(paramString) != null)
    {
      paramString = (a)this.pax.get(paramString);
      AppMethodBeat.o(105035);
      return paramString;
    }
    Object localObject = String.format("Select * From Music Where musicId=?", new Object[0]);
    localObject = this.db.a((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      this.pax.put(paramString, locala);
      AppMethodBeat.o(105035);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(105035);
    return null;
  }
  
  public final a ap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105038);
    ab.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = VC(paramString);
    if (locala == null)
    {
      ab.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(105038);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.pax.put(paramString, locala);
    AppMethodBeat.o(105038);
    return locala;
  }
  
  public final com.tencent.mm.plugin.music.model.a b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(105036);
    if (this.pay.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.a)this.pay.get(parama.field_musicId);
      AppMethodBeat.o(105036);
      return parama;
    }
    parama = c(parama, paramBoolean);
    AppMethodBeat.o(105036);
    return parama;
  }
  
  public final com.tencent.mm.plugin.music.model.a c(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(105037);
    com.tencent.mm.plugin.music.model.a locala = com.tencent.mm.plugin.music.model.a.a(parama.field_songLyric, ah.getContext().getString(2131301731), parama.field_songSnsShareUser, d.a(parama), parama.field_songSinger, paramBoolean);
    this.pay.put(parama.field_musicId, locala);
    AppMethodBeat.o(105037);
    return locala;
  }
  
  public final a x(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(105039);
    String str = com.tencent.mm.plugin.music.h.b.K(parame);
    a locala = VC(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = parame.fKj;
      locala.field_musicType = parame.fKh;
      locala.field_appId = parame.fKw;
      if (bo.isNullOrNil(locala.field_appId)) {
        locala.field_appId = d.v(parame);
      }
      locala.field_songAlbum = parame.fKn;
      locala.field_songAlbumType = parame.fKx;
      locala.field_songWifiUrl = parame.fKp;
      locala.field_songName = parame.fKl;
      locala.field_songSinger = parame.fKm;
      locala.field_songWapLinkUrl = parame.fKq;
      locala.field_songWebUrl = parame.fKr;
      locala.field_songAlbumLocalPath = parame.fKt;
      locala.field_songMediaId = parame.fKz;
      locala.field_songSnsAlbumUser = parame.fKB;
      locala.field_songAlbumUrl = parame.fKo;
      locala.field_songSnsShareUser = parame.fKD;
      if (!bo.isNullOrNil(parame.fKA)) {
        locala.field_songHAlbumUrl = parame.fKA;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.P(parame);
        locala.field_songId = parame.fKy;
      }
      if (((bo.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!bo.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (parame.fKh == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(parame.fKj).intValue();
        label292:
        locala.field_hideBanner = parame.fKF;
        locala.field_jsWebUrlDomain = parame.fKG;
        locala.field_startTime = parame.startTime;
        locala.fKH = parame.fKH;
        locala.field_protocol = parame.protocol;
        locala.field_barBackToWebView = parame.fKI;
        locala.field_musicbar_url = parame.fKJ;
        if (i != 0)
        {
          ab.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.pax.put(str, locala);
          AppMethodBeat.o(105039);
          return locala;
          ab.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
          insert(locala);
        }
      }
      catch (Exception localException)
      {
        break label292;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */