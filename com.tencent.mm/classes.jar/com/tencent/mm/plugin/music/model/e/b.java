package com.tencent.mm.plugin.music.model.e;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.model.a.a;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
  extends i<a>
{
  public com.tencent.mm.sdk.e.e dXw;
  public f<String, a> mAr;
  public f<String, com.tencent.mm.plugin.music.model.a> mAs;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.buS, "Music", null);
    this.dXw = parame;
    this.mAr = new f(20);
    this.mAs = new f(10);
  }
  
  public final a JE(String paramString)
  {
    if (this.mAr.get(paramString) != null) {
      return (a)this.mAr.get(paramString);
    }
    Object localObject = String.format("Select * From Music Where musicId=?", new Object[0]);
    localObject = this.dXw.a((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      a locala = new a();
      locala.d((Cursor)localObject);
      ((Cursor)localObject).close();
      this.mAr.put(paramString, locala);
      return locala;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    return null;
  }
  
  public final a Y(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a locala = JE(paramString);
    if (locala == null)
    {
      y.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[] { paramString });
      return null;
    }
    locala.field_songBgColor = paramInt1;
    locala.field_songLyricColor = paramInt2;
    c(locala, new String[] { "songBgColor", "songLyricColor" });
    this.mAr.put(paramString, locala);
    return locala;
  }
  
  public final com.tencent.mm.plugin.music.model.a b(a parama, boolean paramBoolean)
  {
    String str2 = parama.field_songLyric;
    String str1 = ae.getContext().getString(a.f.music_prefix);
    String str3 = parama.field_songSnsShareUser;
    boolean bool = d.a(parama);
    Object localObject1 = parama.field_songSinger;
    com.tencent.mm.plugin.music.model.a locala = new com.tencent.mm.plugin.music.model.a();
    long l = bk.UZ();
    if (!bk.bl(str2)) {
      if (str2 == null)
      {
        y.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        y.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { str2 });
        y.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(locala.mzk.size()) });
        label110:
        if (!bk.bl(str3)) {
          break label1027;
        }
        y.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        label125:
        if (!bk.bl(str2))
        {
          if (!bk.bl(str1)) {
            break label1187;
          }
          y.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      y.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
      this.mAs.put(parama.field_musicId, locala);
      return locala;
      localObject1 = str2.replaceAll("\n", " ").replaceAll("\r", " ");
      Matcher localMatcher1 = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher((CharSequence)localObject1);
      while (localMatcher1.find())
      {
        String str4 = localMatcher1.group();
        localMatcher1.start();
        localMatcher1.end();
        if (str4 == null)
        {
          y.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
        }
        else if (str4.startsWith("[ti:"))
        {
          locala.title = com.tencent.mm.plugin.music.model.a.ee(str4, "[ti:");
        }
        else if (str4.startsWith("[ar:"))
        {
          locala.giq = com.tencent.mm.plugin.music.model.a.ee(str4, "[ar:");
        }
        else if (str4.startsWith("[al:"))
        {
          locala.album = com.tencent.mm.plugin.music.model.a.ee(str4, "[al:");
        }
        else if (str4.startsWith("[by:"))
        {
          locala.mzm = com.tencent.mm.plugin.music.model.a.ee(str4, "[by:");
        }
        else if (str4.startsWith("[offset:"))
        {
          locala.pj = bk.getLong(com.tencent.mm.plugin.music.model.a.ee(str4, "[offset:"), 0L);
        }
        else if (str4.startsWith("[re:"))
        {
          locala.mzn = com.tencent.mm.plugin.music.model.a.ee(str4, "[re:");
        }
        else if (str4.startsWith("[ve:"))
        {
          locala.mzo = com.tencent.mm.plugin.music.model.a.ee(str4, "[ve:");
        }
        else
        {
          Pattern localPattern = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
          Matcher localMatcher2 = localPattern.matcher(str4);
          a.a locala1 = new a.a();
          label476:
          if (localMatcher2.find())
          {
            if (localMatcher2.groupCount() > 0) {
              locala1.timestamp = com.tencent.mm.plugin.music.model.a.Jy(localMatcher2.group(1));
            }
            localObject1 = localPattern.split(str4);
            if ((localObject1 != null) && (localObject1.length > 0))
            {
              localObject2 = localObject1[(localObject1.length - 1)];
              localObject1 = localObject2;
              if (localObject2 != null) {
                localObject1 = ((String)localObject2).trim();
              }
              localObject2 = localObject1;
              if (bk.bl((String)localObject1)) {
                localObject2 = " ";
              }
              locala1.content = ((String)localObject2);
              i = 0;
            }
            for (;;)
            {
              if (i < locala.mzl.size())
              {
                localObject1 = new a.a();
                ((a.a)localObject1).timestamp = ((Long)locala.mzl.get(i)).longValue();
                ((a.a)localObject1).content = locala1.content;
                ((a.a)localObject1).mzq = true;
                i += 1;
                continue;
                locala.mzl.add(Long.valueOf(locala1.timestamp));
                break;
              }
            }
            locala.mzl.clear();
            i = locala.mzk.size() - 1;
          }
          for (;;)
          {
            if ((i >= 0) && (((a.a)locala.mzk.get(i)).timestamp != locala1.timestamp))
            {
              if (((a.a)locala.mzk.get(i)).timestamp < locala1.timestamp) {
                locala.mzk.add(i + 1, locala1);
              }
            }
            else
            {
              if (i >= 0) {
                break label476;
              }
              locala.mzk.add(0, locala1);
              break label476;
              break;
            }
            i -= 1;
          }
        }
      }
      y.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[] { Long.valueOf(locala.pj) });
      if (locala.pj != 0L)
      {
        i = 0;
        while (i < locala.mzk.size())
        {
          localObject1 = (a.a)locala.mzk.get(i);
          ((a.a)localObject1).timestamp += locala.pj;
          i += 1;
        }
        locala.pj = 0L;
      }
      int i = 0;
      while (i < locala.mzk.size() - 1)
      {
        localObject1 = (a.a)locala.mzk.get(i);
        if ((((a.a)localObject1).mzq) && (((a.a)localObject1).content.equals(((a.a)locala.mzk.get(i + 1)).content))) {
          ((a.a)localObject1).content = " ";
        }
        i += 1;
      }
      break;
      Object localObject2 = new a.a();
      ((a.a)localObject2).timestamp = 0L;
      if (paramBoolean) {
        ((a.a)localObject2).content = ((String)localObject1);
      }
      for (;;)
      {
        if (((a.a)localObject2).content == null) {
          break label1025;
        }
        locala.mzk.add(localObject2);
        break;
        if (!bool) {
          ((a.a)localObject2).content = ae.getContext().getString(a.f.no_licence_lyric_wording);
        } else {
          ((a.a)localObject2).content = ae.getContext().getString(a.f.no_lyric_wording);
        }
      }
      label1025:
      break label110;
      label1027:
      localObject1 = new a.a();
      ((a.a)localObject1).timestamp = 0L;
      ((a.a)localObject1).content = ae.getContext().getString(a.f.user_share_music, new Object[] { r.gV(str3) });
      if (locala.mzk.isEmpty())
      {
        locala.mzk.add(localObject1);
        break label125;
      }
      if (locala.mzk.size() == 1)
      {
        locala.mzk.add(0, localObject1);
        ((a.a)locala.mzk.get(1)).timestamp = 5000L;
        break label125;
      }
      locala.mzk.add(0, localObject1);
      ((a.a)locala.mzk.get(1)).timestamp = (3L * (((a.a)locala.mzk.get(2)).timestamp >> 2));
      break label125;
      label1187:
      localObject1 = new a.a();
      ((a.a)localObject1).timestamp = 0L;
      ((a.a)localObject1).content = str1;
      if (locala.mzk.isEmpty())
      {
        locala.mzk.add(localObject1);
      }
      else if (locala.mzk.size() == 1)
      {
        locala.mzk.add(0, localObject1);
        ((a.a)locala.mzk.get(1)).timestamp = 5000L;
      }
      else
      {
        locala.mzk.add(0, localObject1);
        ((a.a)locala.mzk.get(1)).timestamp = (3L * (((a.a)locala.mzk.get(2)).timestamp >> 2));
      }
    }
  }
  
  public final a x(com.tencent.mm.av.e parame)
  {
    String str = com.tencent.mm.plugin.music.h.b.K(parame);
    a locala = JE(str);
    if (locala == null) {
      locala = new a();
    }
    for (int i = 0;; i = 1)
    {
      locala.field_musicId = str;
      locala.field_originMusicId = parame.eux;
      locala.field_musicType = parame.euv;
      locala.field_appId = parame.euK;
      if (bk.bl(locala.field_appId)) {
        locala.field_appId = d.v(parame);
      }
      locala.field_songAlbum = parame.euB;
      locala.field_songAlbumType = parame.euL;
      locala.field_songWifiUrl = parame.euD;
      locala.field_songName = parame.euz;
      locala.field_songSinger = parame.euA;
      locala.field_songWapLinkUrl = parame.euE;
      locala.field_songWebUrl = parame.euF;
      locala.field_songAlbumLocalPath = parame.euH;
      locala.field_songMediaId = parame.euN;
      locala.field_songSnsAlbumUser = parame.euP;
      locala.field_songAlbumUrl = parame.euC;
      locala.field_songSnsShareUser = parame.euR;
      if (!bk.bl(parame.euO)) {
        locala.field_songHAlbumUrl = parame.euO;
      }
      locala.field_updateTime = System.currentTimeMillis();
      if (locala.field_songId == 0)
      {
        com.tencent.mm.plugin.music.h.e.N(parame);
        locala.field_songId = parame.euM;
      }
      if (((bk.bl(locala.field_songWapLinkUrl)) || (locala.field_songWapLinkUrl.equals(locala.field_songWebUrl))) && (!bk.bl(locala.field_songWifiUrl))) {
        locala.field_songWapLinkUrl = locala.field_songWifiUrl;
      }
      if ((locala.field_songId == 0) && (parame.euv == 4)) {}
      try
      {
        locala.field_songId = Integer.valueOf(parame.eux).intValue();
        label287:
        locala.field_hideBanner = parame.euT;
        locala.field_jsWebUrlDomain = parame.euU;
        locala.field_startTime = parame.startTime;
        locala.euV = parame.euV;
        locala.field_protocol = parame.protocol;
        locala.field_barBackToWebView = parame.euW;
        locala.field_musicbar_url = parame.euX;
        if (i != 0)
        {
          y.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[] { str });
          c(locala, new String[0]);
        }
        for (;;)
        {
          this.mAr.put(str, locala);
          return locala;
          y.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[] { str });
          b(locala);
        }
      }
      catch (Exception localException)
      {
        break label287;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.b
 * JD-Core Version:    0.7.0.1
 */