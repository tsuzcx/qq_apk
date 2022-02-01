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
  public com.tencent.mm.b.f<String, a> wlP;
  public com.tencent.mm.b.f<String, com.tencent.mm.plugin.music.model.b> wlQ;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "Music", null);
    AppMethodBeat.i(63172);
    this.db = parame;
    this.wlP = new c(20);
    this.wlQ = new c(10);
    AppMethodBeat.o(63172);
  }
  
  public final a B(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63177);
    String str = com.tencent.mm.plugin.music.h.b.O(paramf);
    a locala = asJ(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = paramf.ihg;
      locala.field_musicType = paramf.ihe;
      locala.field_appId = paramf.iht;
      if (bt.isNullOrNil(locala.field_appId)) {
        locala.field_appId = com.tencent.mm.plugin.music.model.e.z(paramf);
      }
      locala.field_songAlbum = paramf.ihk;
      locala.field_songAlbumType = paramf.ihu;
      locala.field_songWifiUrl = paramf.ihm;
      locala.field_songName = paramf.ihi;
      locala.field_songSinger = paramf.ihj;
      locala.field_songWapLinkUrl = paramf.ihn;
      locala.field_songWebUrl = paramf.iho;
      locala.field_songAlbumLocalPath = paramf.ihq;
      locala.field_songMediaId = paramf.ihw;
      locala.field_songSnsAlbumUser = paramf.ihy;
      locala.field_songAlbumUrl = paramf.ihl;
      if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.ihp))) {
        locala.field_songLyric = paramf.ihp;
      }
      locala.field_songSnsShareUser = paramf.ihA;
      if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!bt.isNullOrNil(paramf.ihx))) {
        locala.field_songHAlbumUrl = paramf.ihx;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.U(paramf);
        locala.field_songId = paramf.ihv;
      }
      if (locala.field_songMId == null) {
        locala.field_songMId = com.tencent.mm.plugin.music.h.e.asV(com.tencent.mm.plugin.music.h.e.S(paramf));
      }
      if (((bt.isNullOrNil(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!bt.isNullOrNil(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (paramf.ihe == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(paramf.ihg).intValue();
        label348:
        locala.field_hideBanner = paramf.ihC;
        locala.field_jsWebUrlDomain = paramf.ihD;
        locala.field_startTime = paramf.ddx;
        locala.ihE = paramf.ihE;
        locala.field_protocol = paramf.protocol;
        locala.field_barBackToWebView = paramf.ihF;
        locala.field_musicbar_url = paramf.ihG;
        locala.field_srcUsername = paramf.dHo;
        locala.field_playbackRate = paramf.hLI;
        locala.hLQ = paramf.hLQ;
        if (i != 0)
        {
          ad.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          update(locala, new String[0]);
        }
        for (;;)
        {
          this.wlP.put(str, locala);
          AppMethodBeat.o(63177);
          return locala;
          ad.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
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
    if (this.wlQ.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.wlQ.get(parama.field_musicId);
      AppMethodBeat.o(63174);
      return parama;
    }
    parama = b(parama, paramBoolean, true);
    AppMethodBeat.o(63174);
    return parama;
  }
  
  public final a as(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63176);
    ad.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = asJ(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      AppMethodBeat.o(63176);
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    update(locala, new String[] { "songBgColor", "songLyricColor" });
    this.wlP.put(paramString, locala);
    AppMethodBeat.o(63176);
    return locala;
  }
  
  public final a asJ(String paramString)
  {
    AppMethodBeat.i(63173);
    if (this.wlP.get(paramString) != null)
    {
      paramString = (a)this.wlP.get(paramString);
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
      this.wlP.put(paramString, locala);
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
    AppMethodBeat.i(192471);
    com.tencent.mm.plugin.music.model.b localb = com.tencent.mm.plugin.music.model.b.a(parama.field_songLyric, aj.getContext().getString(2131761476), parama.field_songSnsShareUser, com.tencent.mm.plugin.music.model.e.a(parama), parama.field_songSinger, paramBoolean1, paramBoolean2);
    this.wlQ.put(parama.field_musicId, localb);
    AppMethodBeat.o(192471);
    return localb;
  }
  
  public final com.tencent.mm.plugin.music.model.b h(a parama)
  {
    AppMethodBeat.i(192470);
    if (this.wlQ.get(parama.field_musicId) != null)
    {
      parama = (com.tencent.mm.plugin.music.model.b)this.wlQ.get(parama.field_musicId);
      AppMethodBeat.o(192470);
      return parama;
    }
    parama = b(parama, false, false);
    AppMethodBeat.o(192470);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */