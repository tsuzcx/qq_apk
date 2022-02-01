package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends j<a>
{
  public com.tencent.mm.sdk.e.e db;
  public com.tencent.mm.b.f<String, a> vgu;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.b> vgv;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = parame;
    this.vgu = new c(20);
    this.vgv = new c(10);
    AppMethodBeat.o(63172);
  }
  
  public final a B(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.O(paramf);
    a locala = anK(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.hNS;
      locala.field_musicType = paramf.hNQ;
      locala.field_appId = paramf.hOf;
      if (bs.isNullOrNil(locala.field_appId)) {
        locala.field_appId = com.tencent.mm.plugin.music.model.e.z(paramf);
      }
      locala.field_songAlbum = paramf.hNW;
      locala.field_songAlbumType = paramf.hOg;
      locala.field_songWifiUrl = paramf.hNY;
      locala.field_songName = paramf.hNU;
      locala.field_songSinger = paramf.hNV;
      locala.field_songWapLinkUrl = paramf.hNZ;
      locala.field_songWebUrl = paramf.hOa;
      locala.field_songAlbumLocalPath = paramf.hOc;
      locala.field_songMediaId = paramf.hOi;
      locala.field_songSnsAlbumUser = paramf.hOk;
      locala.field_songAlbumUrl = paramf.hNX;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.hOb))) {
        locala.field_songLyric = paramf.hOb;
      }
      locala.field_songSnsShareUser = paramf.hOm;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!bs.isNullOrNil(paramf.hOj))) {
        locala.field_songHAlbumUrl = paramf.hOj;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.U(paramf);
        locala.field_songId = paramf.hOh;
      }
      if (locala.field_songMId == null) {
        locala.field_songMId = com.tencent.mm.plugin.music.h.e.anW(com.tencent.mm.plugin.music.h.e.S(paramf));
      }
      if (((bs.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!bs.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.hNQ == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.hNS).intValue();
        label348:
        locala.field_hideBanner = paramf.hOo;
        locala.field_jsWebUrlDomain = paramf.hOp;
        locala.field_startTime = paramf.cSh;
        locala.hOq = paramf.hOq;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.hOr;
        locala.field_musicbar_url = paramf.hOs;
        locala.field_srcUsername = paramf.dvl;
        locala.field_playbackRate = paramf.htq;
        locala.hty = paramf.hty;
        if (i != 0)
        {
          ac.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.vgu.put(str, locala);
          AppMethodBeat.o(63177);
          return locala;
          ac.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
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
    if (this.vgv.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.vgv.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = b(parama, paramBoolean, true);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final a anK(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.vgu.get(paramString) != null)
    {
      paramString = (a)this.vgu.get(paramString);
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
      this.vgu.put(paramString, locala);
      AppMethodBeat.o(63173);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63173);
    return null;
  }
  
  public final a ao(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    ac.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = anK(paramString);
    if (locala == null)
    {
      ac.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.vgu.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final com.tencent.mm.plugin.music.model.b b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195613);
    com.tencent.mm.plugin.music.model.b localb = com.tencent.mm.plugin.music.model.b.a(parama.field_songLyric, ai.getContext().getString(2131761476), parama.field_songSnsShareUser, com.tencent.mm.plugin.music.model.e.a(parama), parama.field_songSinger, paramBoolean1, paramBoolean2);
    this.vgv.put(parama.field_musicId, localb);
    AppMethodBeat.o(195613);
    return localb;
  }
  
  public final com.tencent.mm.plugin.music.model.b h(a parama)
  {
    AppMethodBeat.i(195612);
    if (this.vgv.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.vgv.get(parama.field_musicId);
      AppMethodBeat.o(195612);
      return parama;
    }
    parama = b(parama, false, false);
    AppMethodBeat.o(195612);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */