package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.b;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.network.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.ak.g, e
{
  private Object lockObj;
  private int mode;
  private int veX;
  private List<String> veY;
  private com.tencent.mm.plugin.music.model.notification.b veZ;
  private com.tencent.mm.plugin.music.model.b.b vfa;
  private com.tencent.mm.plugin.music.model.b.a vfb;
  private com.tencent.mm.plugin.music.model.b.c vfc;
  private boolean vfd;
  
  public m()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.veY = new ArrayList();
    this.veZ = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void diR()
  {
    AppMethodBeat.i(62980);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final void Ho(int paramInt)
  {
    AppMethodBeat.i(62979);
    h.wUl.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.vfd)
      {
        ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.veY.size() <= 1) {
        diR();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.an(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        locallw = new lw();
        locallw.dnW.action = 5;
        com.tencent.mm.sdk.b.a.GpY.l(locallw);
      }
    }
    this.mode = 1;
    lw locallw = new lw();
    locallw.dnW.action = 5;
    com.tencent.mm.sdk.b.a.GpY.l(locallw);
    com.tencent.mm.plugin.music.model.d.e.an(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final boolean JI(int paramInt)
  {
    AppMethodBeat.i(62986);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.JI(paramInt);
    AppMethodBeat.o(62986);
    return bool;
  }
  
  public final void JK(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.veY.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.veY.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.veY.size();
    }
    if (paramInt != this.veX)
    {
      this.veX = paramInt;
      this.veO.s(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final void a(com.tencent.mm.ay.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.djb();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195596);
    if (parama == null)
    {
      AppMethodBeat.o(195596);
      return;
    }
    if (this.vfa != null)
    {
      com.tencent.mm.kernel.g.agQ().ghe.a(this.vfa);
      this.vfa = null;
    }
    if ((parama.field_songId <= 0) && (TextUtils.isEmpty(parama.field_songMId)))
    {
      ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
      h.wUl.kvStat(10911, "1");
      AppMethodBeat.o(195596);
      return;
    }
    this.vfa = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.vfa, 0);
    AppMethodBeat.o(195596);
  }
  
  public final String anB(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.b.anB(paramString);
    ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.anG(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final URL anC(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new b.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a anD(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = com.tencent.mm.plugin.music.model.f.diT().anK(paramString);
    if (locala != null)
    {
      this.veY.add(paramString);
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e.a diD()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.veY.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.veY.size() <= this.veX)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.veY.get(this.veX);
      localObject2 = com.tencent.mm.plugin.music.model.f.diT().anK((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean diE()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = diD();
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
  
  public final List<String> diF()
  {
    return this.veY;
  }
  
  public final void diG()
  {
    this.mode = 1;
  }
  
  public final void diH()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.veX += 1;
    this.veX %= this.veY.size();
    this.veO.oD(true);
    this.veO.s(null);
    AppMethodBeat.o(62982);
  }
  
  public final void diI()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.veX = (this.veX + this.veY.size() - 1);
    this.veX %= this.veY.size();
    this.veO.oD(true);
    this.veO.s(null);
    AppMethodBeat.o(62983);
  }
  
  public final int diJ()
  {
    return this.veX;
  }
  
  public final void diK()
  {
    AppMethodBeat.i(62984);
    if (!this.veO.diB().aGv())
    {
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean diL()
  {
    AppMethodBeat.i(62985);
    if ((this.veY.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(62985);
      return true;
    }
    AppMethodBeat.o(62985);
    return false;
  }
  
  public final com.tencent.mm.ay.f diz()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.veY.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.veY.size() <= this.veX)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.veY.get(this.veX);
      localObject2 = com.tencent.mm.plugin.music.model.f.diT().anK((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).djf();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final void e(List<com.tencent.mm.ay.f> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(62974);
        if ((paramList == null) || (paramList.size() == 0))
        {
          ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
          AppMethodBeat.o(62974);
          return;
        }
        localObject = this.lockObj;
        if (paramBoolean) {}
        try
        {
          this.veY.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.ay.f localf = (com.tencent.mm.ay.f)paramList.next();
            this.veY.add(com.tencent.mm.plugin.music.h.b.O(localf));
            com.tencent.mm.plugin.music.model.f.diT().B(localf);
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
  
  public final boolean i(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62969);
    if (paramf == null)
    {
      ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(62969);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = diD();
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
      ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.veO.u(paramf);
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
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.veO.u(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (this.vfb != null) {
      com.tencent.mm.kernel.g.agQ().ghe.a(this.vfb);
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(940, this);
    this.vfb = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.vfb, 0);
    if (com.tencent.mm.plugin.music.model.a.b.b(locala))
    {
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
      paramf = locala.playUrl;
      if (TextUtils.isEmpty(paramf)) {
        ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
      }
      for (;;)
      {
        AppMethodBeat.o(62969);
        return false;
        if (this.vfc != null)
        {
          com.tencent.mm.kernel.g.agQ().ghe.a(this.vfc);
          this.vfc = null;
        }
        ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.vfc = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.g.agQ().ghe.a(this.vfc, 0);
        h.wUl.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.g.agQ().ghe.a(520, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.veZ;
    ac.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.kce = new b.1(localb);
    localb.kce.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.ay.f j(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.O(paramf);
    for (;;)
    {
      synchronized (this.lockObj)
      {
        if (this.veY == null) {
          break label226;
        }
        i = 0;
        if (i >= this.veY.size()) {
          break label221;
        }
        if (str.equals(this.veY.get(i)))
        {
          this.veX = i;
          i = 1;
          j = i;
          if (this.veY.size() > 1)
          {
            j = i;
            if (paramf.hOn)
            {
              this.mode = 2;
              j = i;
            }
          }
          if (j != 0)
          {
            ??? = diz();
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
        this.veY.clear();
        this.veY.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.veX = 0;
        com.tencent.mm.plugin.music.model.f.diT().B(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        diR();
        ??? = paramf;
      }
      label221:
      int i = 0;
      continue;
      label226:
      int j = 0;
    }
  }
  
  public final com.tencent.mm.ay.f k(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62971);
    if ((paramf == null) && (this.veY.size() == 0))
    {
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = diz();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.veY.clear();
        this.veY.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.veX = 0;
        com.tencent.mm.plugin.music.model.f.diT().B(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        diR();
        ??? = paramf;
      }
    }
  }
  
  public final void l(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62973);
    if (paramf != null) {
      synchronized (this.lockObj)
      {
        this.veY.clear();
        this.veY.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.veX = 0;
        com.tencent.mm.plugin.music.model.f.diT().B(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void n(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62989);
    super.n(paramf);
    com.tencent.mm.plugin.music.model.d.e.djb();
    com.tencent.mm.plugin.music.model.d.e.hto = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.f(diD());
    AppMethodBeat.o(62989);
  }
  
  public final void o(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62990);
    super.o(paramf);
    com.tencent.mm.plugin.music.model.d.e.hto = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.agQ().ghe.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = ((com.tencent.mm.plugin.music.model.b.a)paramn).vfI;
        if ((diD() != null) && (paramn.hNS.equals(diD().field_musicId))) {
          this.veO.aGt();
        }
        paramString = com.tencent.mm.plugin.music.model.f.diT();
        paramn = paramn.hNS;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.db.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramn });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.vgu.get(paramn);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { diD().field_musicId });
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
        Object localObject3 = paramString.vfJ;
        localObject1 = paramString.vfz.field_musicId;
        if ((localObject3 != null) && (localObject1 != null))
        {
          Object localObject2 = this.veY.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramn = (String)((Iterator)localObject2).next();
            if (paramn.equals(localObject1))
            {
              localObject1 = z.b(((bcp)localObject3).ESJ);
              localObject2 = z.b(((bcp)localObject3).ESK);
              localObject3 = z.b(((bcp)localObject3).ESI);
              com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.f.diT();
              boolean bool1 = paramString.vfK;
              boolean bool2 = paramString.vfL;
              com.tencent.mm.plugin.music.model.e.a locala = localb.anK(paramn);
              if (locala == null) {
                ac.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramn });
              }
              for (;;)
              {
                ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject1, localObject2, localObject3 });
                if (bs.isNullOrNil((String)localObject2)) {
                  break;
                }
                paramn = new lw();
                paramn.dnW.action = 6;
                paramn.dnW.dnX = paramString.vfz.field_musicId;
                com.tencent.mm.sdk.b.a.GpY.a(paramn, Looper.getMainLooper());
                AppMethodBeat.o(62995);
                return;
                if (!bs.isNullOrNil((String)localObject1)) {
                  locala.field_songAlbumUrl = ((String)localObject1);
                }
                locala.field_songHAlbumUrl = ((String)localObject2);
                locala.field_songLyric = ((String)localObject3);
                localb.update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
                localb.vgu.put(paramn, locala);
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
        ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.music.model.b.c)paramn;
        ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.vfN });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          h.wUl.idkeyStat(558L, 214L, 1L, true);
        }
        for (;;)
        {
          paramn = diD();
          if ((paramn == null) || (TextUtils.isEmpty(paramn.playUrl)) || (!paramn.playUrl.equalsIgnoreCase(paramString.playUrl))) {
            break;
          }
          ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
          this.veO.t(paramn.djf());
          AppMethodBeat.o(62995);
          return;
          com.tencent.mm.plugin.music.model.a.b.hY(paramString.playUrl, paramString.vfN);
        }
        if (paramn != null) {
          ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramn.playUrl, paramString.playUrl });
        }
      }
    }
    AppMethodBeat.o(62995);
  }
  
  public final void p(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62991);
    super.p(paramf);
    com.tencent.mm.plugin.music.model.d.e.aGr();
    AppMethodBeat.o(62991);
  }
  
  public final void q(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62992);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.djb();
    AppMethodBeat.o(62992);
  }
  
  public final com.tencent.mm.ay.f r(List<com.tencent.mm.ay.f> paramList, int paramInt)
  {
    AppMethodBeat.i(62972);
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
      AppMethodBeat.o(62972);
      return null;
    }
    synchronized (this.lockObj)
    {
      this.veY.clear();
      int i = 0;
      while (i < paramList.size())
      {
        com.tencent.mm.ay.f localf = (com.tencent.mm.ay.f)paramList.get(i);
        this.veY.add(com.tencent.mm.plugin.music.h.b.O(localf));
        com.tencent.mm.plugin.music.model.f.diT().B(localf);
        i += 1;
      }
      this.veX = paramInt;
      this.mode = 2;
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.veX) });
      paramList = diz();
      AppMethodBeat.o(62972);
      return paramList;
    }
  }
  
  public final void r(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62993);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.djb();
    if ((this.mode == 2) && ((this.veX < this.veY.size() - 1) || (paramf.hOn)))
    {
      paramf = new lw();
      paramf.dnW.action = 15;
      paramf.dnW.state = "";
      com.tencent.mm.sdk.b.a.GpY.a(paramf, Looper.getMainLooper());
      diH();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.veY.clear();
    com.tencent.mm.kernel.g.agQ().ghe.b(520, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(940, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.veZ;
    ac.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(ai.getContext(), MMMusicPlayerService.class);
    ai.getContext().stopService(localIntent);
    localb.vfO = null;
    localb.kce.dead();
    AppMethodBeat.o(62968);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(62964);
      long l = System.currentTimeMillis();
      m.a(m.this, true);
      Object localObject1 = m.this.diz();
      ArrayList localArrayList = new ArrayList();
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.ay.f)localObject1).hNQ) });
      int i;
      label118:
      Object localObject2;
      switch (((com.tencent.mm.ay.f)localObject1).hNQ)
      {
      case 2: 
      case 3: 
      case 5: 
      case 7: 
      default: 
        localObject1 = null;
        if (localObject1 == null) {
          break label360;
        }
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label360;
        }
        localObject2 = (com.tencent.mm.ay.f)((List)localObject1).get(i);
        if (localObject2 == null) {
          ac.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break label118;
        localObject1 = new gt();
        ((gt)localObject1).dhx.type = 18;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((gt)localObject1).dhy.dhL;
        break;
        localObject1 = new lv();
        ((lv)localObject1).dnO.action = -4;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((lv)localObject1).dnP.dhL;
        break;
        localObject1 = new lv();
        ((lv)localObject1).dnO.action = -5;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((lv)localObject1).dnP.dhL;
        break;
        localObject2 = new lv();
        ((lv)localObject2).dnO.action = -6;
        ((lv)localObject2).dnO.dnQ = ((com.tencent.mm.ay.f)localObject1);
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject1 = ((lv)localObject2).dnP.dhL;
        break;
        com.tencent.mm.plugin.music.model.f.diT().B((com.tencent.mm.ay.f)localObject2);
        localArrayList.add(com.tencent.mm.plugin.music.h.b.O((com.tencent.mm.ay.f)localObject2));
      }
      label360:
      ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      m.a(m.this, false);
      localObject1 = new m.b(m.this, (byte)0);
      ((m.b)localObject1).vff = localArrayList;
      ap.f((Runnable)localObject1);
      AppMethodBeat.o(62964);
    }
  }
  
  final class b
    implements Runnable
  {
    List<String> vff;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(62965);
      Object localObject1 = com.tencent.mm.plugin.music.h.b.O(m.this.diz());
      int j = m.a(m.this);
      int i = 0;
      int k = 0;
      while (i < this.vff.size())
      {
        if (((String)this.vff.get(i)).equals(localObject1))
        {
          j = i;
          k = 1;
        }
        i += 1;
      }
      if (k == 0)
      {
        AppMethodBeat.o(62965);
        return;
      }
      localObject1 = m.b(m.this);
      for (i = j + 1;; i = 0) {
        try
        {
          while (i < this.vff.size())
          {
            m.c(m.this).add(this.vff.get(i));
            i += 1;
            continue;
            while (i < j)
            {
              m.c(m.this).add(this.vff.get(i));
              i += 1;
            }
            ac.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(m.this).size()), Integer.valueOf(m.a(m.this)) });
            localObject1 = new lw();
            ((lw)localObject1).dnW.action = 5;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            AppMethodBeat.o(62965);
            return;
          }
        }
        finally
        {
          AppMethodBeat.o(62965);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */