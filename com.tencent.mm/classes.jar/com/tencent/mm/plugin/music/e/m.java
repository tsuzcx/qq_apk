package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.network.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.al.f, e
{
  private Object lockObj;
  private int mode;
  private int wks;
  private List<String> wkt;
  private com.tencent.mm.plugin.music.model.notification.b wku;
  private com.tencent.mm.plugin.music.model.b.b wkv;
  private com.tencent.mm.plugin.music.model.b.a wkw;
  private com.tencent.mm.plugin.music.model.b.c wkx;
  private boolean wky;
  
  public m()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.wkt = new ArrayList();
    this.wku = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void dtd()
  {
    AppMethodBeat.i(62980);
    com.tencent.mm.sdk.g.b.c(new m.a(this, (byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final void IK(int paramInt)
  {
    AppMethodBeat.i(62979);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.wky)
      {
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.wkt.size() <= 1) {
        dtd();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.an(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        localmf = new mf();
        localmf.dzK.action = 5;
        com.tencent.mm.sdk.b.a.IbL.l(localmf);
      }
    }
    this.mode = 1;
    mf localmf = new mf();
    localmf.dzK.action = 5;
    com.tencent.mm.sdk.b.a.IbL.l(localmf);
    com.tencent.mm.plugin.music.model.d.e.an(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final boolean Lk(int paramInt)
  {
    AppMethodBeat.i(62986);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.Lk(paramInt);
    AppMethodBeat.o(62986);
    return bool;
  }
  
  public final void Lm(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.wkt.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.wkt.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.wkt.size();
    }
    if (paramInt != this.wks)
    {
      this.wks = paramInt;
      this.wkj.s(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final void a(com.tencent.mm.az.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.dtn();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192454);
    if (parama == null)
    {
      AppMethodBeat.o(192454);
      return;
    }
    if (this.wkv != null)
    {
      com.tencent.mm.kernel.g.ajB().gAO.a(this.wkv);
      this.wkv = null;
    }
    if ((parama.field_songId <= 0) && (TextUtils.isEmpty(parama.field_songMId)))
    {
      ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10911, "1");
      AppMethodBeat.o(192454);
      return;
    }
    this.wkv = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.wkv, 0);
    AppMethodBeat.o(192454);
  }
  
  public final String asA(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.b.asA(paramString);
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.asF(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final URL asB(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new b.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a asC(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = com.tencent.mm.plugin.music.model.f.dtf().asJ(paramString);
    if (locala != null)
    {
      this.wkt.add(paramString);
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final com.tencent.mm.az.f dsL()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.wkt.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.wkt.size() <= this.wks)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.wkt.get(this.wks);
      localObject2 = com.tencent.mm.plugin.music.model.f.dtf().asJ((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).dtr();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e.a dsP()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.wkt.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.wkt.size() <= this.wks)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.wkt.get(this.wks);
      localObject2 = com.tencent.mm.plugin.music.model.f.dtf().asJ((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean dsQ()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = dsP();
    if (locala != null) {}
    switch (locala.field_musicType)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    default: 
      AppMethodBeat.o(62978);
      return false;
    }
    AppMethodBeat.o(62978);
    return true;
  }
  
  public final List<String> dsR()
  {
    return this.wkt;
  }
  
  public final void dsS()
  {
    this.mode = 1;
  }
  
  public final void dsT()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.wks += 1;
    this.wks %= this.wkt.size();
    this.wkj.pc(true);
    this.wkj.s(null);
    AppMethodBeat.o(62982);
  }
  
  public final void dsU()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.wks = (this.wks + this.wkt.size() - 1);
    this.wks %= this.wkt.size();
    this.wkj.pc(true);
    this.wkj.s(null);
    AppMethodBeat.o(62983);
  }
  
  public final int dsV()
  {
    return this.wks;
  }
  
  public final void dsW()
  {
    AppMethodBeat.i(62984);
    if (!this.wkj.dsN().aJG())
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean dsX()
  {
    AppMethodBeat.i(62985);
    if ((this.wkt.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(62985);
      return true;
    }
    AppMethodBeat.o(62985);
    return false;
  }
  
  public final void e(List<com.tencent.mm.az.f> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(62974);
        if ((paramList == null) || (paramList.size() == 0))
        {
          ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
          AppMethodBeat.o(62974);
          return;
        }
        localObject = this.lockObj;
        if (paramBoolean) {}
        try
        {
          this.wkt.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.az.f localf = (com.tencent.mm.az.f)paramList.next();
            this.wkt.add(com.tencent.mm.plugin.music.h.b.O(localf));
            com.tencent.mm.plugin.music.model.f.dtf().B(localf);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          AppMethodBeat.o(62974);
        }
      }
      finally {}
      AppMethodBeat.o(62974);
    }
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final boolean i(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62969);
    if (paramf == null)
    {
      ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(62969);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = dsP();
    int i;
    if (locala != null)
    {
      if (locala != null) {
        break label71;
      }
      i = 0;
    }
    while (i == 0)
    {
      ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.wkj.u(paramf);
      AppMethodBeat.o(62969);
      return false;
      label71:
      if ((TextUtils.isEmpty(locala.field_songWifiUrl)) && (TextUtils.isEmpty(locala.field_songWapLinkUrl)) && (TextUtils.isEmpty(locala.field_songWebUrl))) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if (locala.field_isBlock == 1)
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.wkj.u(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (this.wkw != null) {
      com.tencent.mm.kernel.g.ajB().gAO.a(this.wkw);
    }
    com.tencent.mm.kernel.g.ajB().gAO.a(940, this);
    this.wkw = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.wkw, 0);
    if (com.tencent.mm.plugin.music.model.a.b.b(locala))
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
      paramf = locala.playUrl;
      if (TextUtils.isEmpty(paramf)) {
        ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
      }
      for (;;)
      {
        AppMethodBeat.o(62969);
        return false;
        if (this.wkx != null)
        {
          com.tencent.mm.kernel.g.ajB().gAO.a(this.wkx);
          this.wkx = null;
        }
        ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.wkx = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.g.ajB().gAO.a(this.wkx, 0);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.g.ajB().gAO.a(520, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.wku;
    ad.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.kwD = new b.1(localb);
    localb.kwD.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.az.f j(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.O(paramf);
    for (;;)
    {
      synchronized (this.lockObj)
      {
        if (this.wkt == null) {
          break label226;
        }
        i = 0;
        if (i >= this.wkt.size()) {
          break label221;
        }
        if (str.equals(this.wkt.get(i)))
        {
          this.wks = i;
          i = 1;
          j = i;
          if (this.wkt.size() > 1)
          {
            j = i;
            if (paramf.ihB)
            {
              this.mode = 2;
              j = i;
            }
          }
          if (j != 0)
          {
            ??? = dsL();
            AppMethodBeat.o(62970);
            return ???;
          }
        }
        else
        {
          i += 1;
        }
      }
      synchronized (this.lockObj)
      {
        this.wkt.clear();
        this.wkt.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.wks = 0;
        com.tencent.mm.plugin.music.model.f.dtf().B(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        dtd();
        ??? = paramf;
      }
      label221:
      int i = 0;
      continue;
      label226:
      int j = 0;
    }
  }
  
  public final com.tencent.mm.az.f k(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62971);
    if ((paramf == null) && (this.wkt.size() == 0))
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = dsL();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.wkt.clear();
        this.wkt.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.wks = 0;
        com.tencent.mm.plugin.music.model.f.dtf().B(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        dtd();
        ??? = paramf;
      }
    }
  }
  
  public final void l(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62973);
    if (paramf != null) {
      synchronized (this.lockObj)
      {
        this.wkt.clear();
        this.wkt.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.wks = 0;
        com.tencent.mm.plugin.music.model.f.dtf().B(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void m(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(221210);
    super.m(paramf);
    com.tencent.mm.plugin.music.model.f.dtf().B(paramf);
    AppMethodBeat.o(221210);
  }
  
  public final void n(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62989);
    super.n(paramf);
    com.tencent.mm.plugin.music.model.d.e.dtn();
    com.tencent.mm.plugin.music.model.d.e.hLG = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.f(dsP());
    AppMethodBeat.o(62989);
  }
  
  public final void o(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62990);
    super.o(paramf);
    com.tencent.mm.plugin.music.model.d.e.hLG = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.ajB().gAO.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = ((com.tencent.mm.plugin.music.model.b.a)paramn).wld;
        if ((dsP() != null) && (paramn.ihg.equals(dsP().field_musicId))) {
          this.wkj.aJE();
        }
        paramString = com.tencent.mm.plugin.music.model.f.dtf();
        paramn = paramn.ihg;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.db.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramn });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.wlP.get(paramn);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { dsP().field_musicId });
        AppMethodBeat.o(62995);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.music.model.b.b))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(62995);
          return;
        }
        paramString = (com.tencent.mm.plugin.music.model.b.b)paramn;
        Object localObject3 = paramString.wle;
        localObject1 = paramString.wkU.field_musicId;
        if ((localObject3 != null) && (localObject1 != null))
        {
          Object localObject2 = this.wkt.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramn = (String)((Iterator)localObject2).next();
            if (paramn.equals(localObject1))
            {
              localObject1 = z.b(((bgt)localObject3).GCc);
              localObject2 = z.b(((bgt)localObject3).GCd);
              localObject3 = z.b(((bgt)localObject3).GCb);
              com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.f.dtf();
              boolean bool1 = paramString.wlf;
              boolean bool2 = paramString.wlg;
              com.tencent.mm.plugin.music.model.e.a locala = localb.asJ(paramn);
              if (locala == null) {
                ad.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramn });
              }
              for (;;)
              {
                ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject1, localObject2, localObject3 });
                if (bt.isNullOrNil((String)localObject2)) {
                  break;
                }
                paramn = new mf();
                paramn.dzK.action = 6;
                paramn.dzK.dzL = paramString.wkU.field_musicId;
                com.tencent.mm.sdk.b.a.IbL.a(paramn, Looper.getMainLooper());
                AppMethodBeat.o(62995);
                return;
                if (!bt.isNullOrNil((String)localObject1)) {
                  locala.field_songAlbumUrl = ((String)localObject1);
                }
                locala.field_songHAlbumUrl = ((String)localObject2);
                locala.field_songLyric = ((String)localObject3);
                localb.update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
                localb.wlP.put(paramn, locala);
                localb.b(locala, bool1, bool2);
              }
            }
          }
        }
        AppMethodBeat.o(62995);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.music.model.b.c))
      {
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.music.model.b.c)paramn;
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.wli });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(558L, 214L, 1L, true);
        }
        for (;;)
        {
          paramn = dsP();
          if ((paramn == null) || (TextUtils.isEmpty(paramn.playUrl)) || (!paramn.playUrl.equalsIgnoreCase(paramString.playUrl))) {
            break;
          }
          ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
          this.wkj.t(paramn.dtr());
          AppMethodBeat.o(62995);
          return;
          com.tencent.mm.plugin.music.model.a.b.ij(paramString.playUrl, paramString.wli);
        }
        if (paramn != null) {
          ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramn.playUrl, paramString.playUrl });
        }
      }
    }
    AppMethodBeat.o(62995);
  }
  
  public final void p(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62991);
    super.p(paramf);
    com.tencent.mm.plugin.music.model.d.e.aJC();
    AppMethodBeat.o(62991);
  }
  
  public final void q(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62992);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.dtn();
    AppMethodBeat.o(62992);
  }
  
  public final void r(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62993);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.dtn();
    if ((this.mode == 2) && ((this.wks < this.wkt.size() - 1) || (paramf.ihB)))
    {
      paramf = new mf();
      paramf.dzK.action = 15;
      paramf.dzK.state = "";
      com.tencent.mm.sdk.b.a.IbL.a(paramf, Looper.getMainLooper());
      dsT();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.wkt.clear();
    com.tencent.mm.kernel.g.ajB().gAO.b(520, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(940, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.wku;
    ad.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(aj.getContext(), MMMusicPlayerService.class);
    aj.getContext().stopService(localIntent);
    localb.wlj = null;
    localb.kwD.dead();
    AppMethodBeat.o(62968);
  }
  
  public final com.tencent.mm.az.f t(List<com.tencent.mm.az.f> paramList, int paramInt)
  {
    AppMethodBeat.i(62972);
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
      AppMethodBeat.o(62972);
      return null;
    }
    synchronized (this.lockObj)
    {
      this.wkt.clear();
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject2 = (com.tencent.mm.az.f)paramList.get(i);
        this.wkt.add(com.tencent.mm.plugin.music.h.b.O((com.tencent.mm.az.f)localObject2));
        com.tencent.mm.plugin.music.model.f.dtf().B((com.tencent.mm.az.f)localObject2);
        i += 1;
      }
      this.wks = paramInt;
      this.mode = 2;
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.wks) });
      paramList = dsL();
      if (paramList.ddx > 0)
      {
        ??? = com.tencent.mm.plugin.music.h.b.O(paramList);
        localObject2 = com.tencent.mm.plugin.music.model.f.dtf();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("startTime", Integer.valueOf(0));
        ((com.tencent.mm.plugin.music.model.e.b)localObject2).db.update("Music", localContentValues, "musicId=?", new String[] { ??? });
        ??? = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject2).wlP.get(???);
        if (??? != null) {
          ((com.tencent.mm.plugin.music.model.e.a)???).field_startTime = 0;
        }
      }
      AppMethodBeat.o(62972);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */