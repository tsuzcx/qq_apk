package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.network.b.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.ai.f, e
{
  private Object lockObj;
  private int mode;
  private int oZh;
  private List<String> oZi;
  private com.tencent.mm.plugin.music.model.notification.b oZj;
  private com.tencent.mm.plugin.music.model.b.b oZk;
  private com.tencent.mm.plugin.music.model.b.a oZl;
  private com.tencent.mm.plugin.music.model.b.c oZm;
  private boolean oZn;
  
  public m()
  {
    AppMethodBeat.i(104840);
    this.mode = 1;
    this.oZi = new ArrayList();
    this.oZj = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(104840);
  }
  
  private void bVK()
  {
    AppMethodBeat.i(104853);
    com.tencent.mm.sdk.g.d.post(new m.a(this, (byte)0), "music_get_list_task");
    AppMethodBeat.o(104853);
  }
  
  public final boolean Af(int paramInt)
  {
    AppMethodBeat.i(104859);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.Af(paramInt);
    AppMethodBeat.o(104859);
    return bool;
  }
  
  public final void Ah(int paramInt)
  {
    AppMethodBeat.i(104854);
    if (this.oZi.size() == 0)
    {
      AppMethodBeat.o(104854);
      return;
    }
    int i = (paramInt - 100000) % this.oZi.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.oZi.size();
    }
    if (paramInt != this.oZh)
    {
      this.oZh = paramInt;
      this.oYX.p(null);
    }
    AppMethodBeat.o(104854);
  }
  
  public final String Vu(String paramString)
  {
    AppMethodBeat.i(104860);
    paramString = com.tencent.mm.plugin.music.model.a.b.Vu(paramString);
    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.Vy(paramString);
    AppMethodBeat.o(104860);
    return paramString;
  }
  
  public final URL Vv(String paramString)
  {
    AppMethodBeat.i(104861);
    paramString = new b.b(paramString).url;
    AppMethodBeat.o(104861);
    return paramString;
  }
  
  public final void a(com.tencent.mm.aw.e parame, int paramInt)
  {
    AppMethodBeat.i(104867);
    super.a(parame, paramInt);
    com.tencent.mm.plugin.music.model.d.e.bVU();
    AppMethodBeat.o(104867);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(104869);
    if (parama == null)
    {
      AppMethodBeat.o(104869);
      return;
    }
    if (this.oZk != null)
    {
      com.tencent.mm.kernel.g.RK().eHt.a(this.oZk);
      this.oZk = null;
    }
    if (parama.field_songId <= 0)
    {
      ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId ");
      h.qsU.kvStat(10911, "1");
      AppMethodBeat.o(104869);
      return;
    }
    this.oZk = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean);
    com.tencent.mm.kernel.g.RK().eHt.a(this.oZk, 0);
    AppMethodBeat.o(104869);
  }
  
  public final void bVA()
  {
    AppMethodBeat.i(104855);
    if (this.mode == 1)
    {
      AppMethodBeat.o(104855);
      return;
    }
    this.oZh += 1;
    this.oZh %= this.oZi.size();
    this.oYX.jL(true);
    this.oYX.p(null);
    AppMethodBeat.o(104855);
  }
  
  public final void bVB()
  {
    AppMethodBeat.i(104856);
    if (this.mode == 1)
    {
      AppMethodBeat.o(104856);
      return;
    }
    this.oZh = (this.oZh + this.oZi.size() - 1);
    this.oZh %= this.oZi.size();
    this.oYX.jL(true);
    this.oYX.p(null);
    AppMethodBeat.o(104856);
  }
  
  public final int bVC()
  {
    return this.oZh;
  }
  
  public final void bVD()
  {
    AppMethodBeat.i(104857);
    if (!this.oYX.bVu().aiw())
    {
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(104857);
  }
  
  public final boolean bVE()
  {
    AppMethodBeat.i(104858);
    if ((this.oZi.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(104858);
      return true;
    }
    AppMethodBeat.o(104858);
    return false;
  }
  
  public final com.tencent.mm.aw.e bVs()
  {
    AppMethodBeat.i(104850);
    synchronized (this.lockObj)
    {
      if (this.oZi.size() == 0)
      {
        AppMethodBeat.o(104850);
        return null;
      }
      if (this.oZi.size() <= this.oZh)
      {
        AppMethodBeat.o(104850);
        return null;
      }
      Object localObject2 = (String)this.oZi.get(this.oZh);
      localObject2 = com.tencent.mm.plugin.music.model.e.bVM().VC((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).bVY();
        AppMethodBeat.o(104850);
        return localObject2;
      }
      AppMethodBeat.o(104850);
      return null;
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e.a bVw()
  {
    AppMethodBeat.i(104849);
    synchronized (this.lockObj)
    {
      if (this.oZi.size() == 0)
      {
        AppMethodBeat.o(104849);
        return null;
      }
      if (this.oZi.size() <= this.oZh)
      {
        AppMethodBeat.o(104849);
        return null;
      }
      Object localObject2 = (String)this.oZi.get(this.oZh);
      localObject2 = com.tencent.mm.plugin.music.model.e.bVM().VC((String)localObject2);
      AppMethodBeat.o(104849);
      return localObject2;
    }
  }
  
  public final boolean bVx()
  {
    AppMethodBeat.i(104851);
    com.tencent.mm.plugin.music.model.e.a locala = bVw();
    if (locala != null) {}
    switch (locala.field_musicType)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    default: 
      AppMethodBeat.o(104851);
      return false;
    }
    AppMethodBeat.o(104851);
    return true;
  }
  
  public final List<String> bVy()
  {
    return this.oZi;
  }
  
  public final void bVz()
  {
    this.mode = 1;
  }
  
  public final void d(List<com.tencent.mm.aw.e> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(104848);
        if ((paramList == null) || (paramList.size() == 0))
        {
          ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
          AppMethodBeat.o(104848);
          return;
        }
        localObject = this.lockObj;
        if (paramBoolean) {}
        try
        {
          this.oZi.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.aw.e locale = (com.tencent.mm.aw.e)paramList.next();
            this.oZi.add(com.tencent.mm.plugin.music.h.b.K(locale));
            com.tencent.mm.plugin.music.model.e.bVM().x(locale);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          AppMethodBeat.o(104848);
        }
      }
      finally {}
      AppMethodBeat.o(104848);
    }
  }
  
  public final boolean g(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104843);
    if (parame == null)
    {
      ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(104843);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = bVw();
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
      ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.oYX.r(parame);
      AppMethodBeat.o(104843);
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
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.oYX.r(parame);
      com.tencent.mm.plugin.music.model.d.e.a(parame, true);
      AppMethodBeat.o(104843);
      return false;
    }
    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = parame.playUrl;
    if (this.oZl != null) {
      com.tencent.mm.kernel.g.RK().eHt.a(this.oZl);
    }
    com.tencent.mm.kernel.g.RK().eHt.a(940, this);
    this.oZl = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.g.RK().eHt.a(this.oZl, 0);
    if (com.tencent.mm.plugin.music.model.a.b.b(locala))
    {
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
      parame = locala.playUrl;
      if (TextUtils.isEmpty(parame)) {
        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
      }
      for (;;)
      {
        AppMethodBeat.o(104843);
        return false;
        if (this.oZm != null)
        {
          com.tencent.mm.kernel.g.RK().eHt.a(this.oZm);
          this.oZm = null;
        }
        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { parame });
        this.oZm = new com.tencent.mm.plugin.music.model.b.c(parame);
        com.tencent.mm.kernel.g.RK().eHt.a(this.oZm, 0);
        h.qsU.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(104843);
    return true;
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final com.tencent.mm.aw.e h(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104844);
    String str = com.tencent.mm.plugin.music.h.b.K(parame);
    for (;;)
    {
      synchronized (this.lockObj)
      {
        if (this.oZi == null) {
          break label226;
        }
        i = 0;
        if (i >= this.oZi.size()) {
          break label221;
        }
        if (str.equals(this.oZi.get(i)))
        {
          this.oZh = i;
          i = 1;
          j = i;
          if (this.oZi.size() > 1)
          {
            j = i;
            if (parame.fKE)
            {
              this.mode = 2;
              j = i;
            }
          }
          if (j != 0)
          {
            ??? = bVs();
            AppMethodBeat.o(104844);
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
        this.oZi.clear();
        this.oZi.add(com.tencent.mm.plugin.music.h.b.K(parame));
        this.oZh = 0;
        com.tencent.mm.plugin.music.model.e.bVM().x(parame);
        ??? = parame;
        if (this.mode != 2) {
          continue;
        }
        bVK();
        ??? = parame;
      }
      label221:
      int i = 0;
      continue;
      label226:
      int j = 0;
    }
  }
  
  public final com.tencent.mm.aw.e i(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104845);
    if ((parame == null) && (this.oZi.size() == 0))
    {
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(104845);
      return null;
    }
    if (parame == null) {
      ??? = bVs();
    }
    for (;;)
    {
      AppMethodBeat.o(104845);
      return ???;
      synchronized (this.lockObj)
      {
        this.oZi.clear();
        this.oZi.add(com.tencent.mm.plugin.music.h.b.K(parame));
        this.oZh = 0;
        com.tencent.mm.plugin.music.model.e.bVM().x(parame);
        ??? = parame;
        if (this.mode != 2) {
          continue;
        }
        bVK();
        ??? = parame;
      }
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(104841);
    super.init();
    com.tencent.mm.kernel.g.RK().eHt.a(520, this);
    com.tencent.mm.kernel.g.RK().eHt.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.oZj;
    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.hCe = new b.1(localb);
    localb.hCe.alive();
    AppMethodBeat.o(104841);
  }
  
  public final void j(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104847);
    if (parame != null) {
      synchronized (this.lockObj)
      {
        this.oZi.clear();
        this.oZi.add(com.tencent.mm.plugin.music.h.b.K(parame));
        this.oZh = 0;
        com.tencent.mm.plugin.music.model.e.bVM().x(parame);
        AppMethodBeat.o(104847);
        return;
      }
    }
    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(104847);
  }
  
  public final void k(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104862);
    super.k(parame);
    com.tencent.mm.plugin.music.model.d.e.bVU();
    com.tencent.mm.plugin.music.model.d.e.fqZ = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.f(bVw());
    AppMethodBeat.o(104862);
  }
  
  public final void l(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104863);
    super.l(parame);
    com.tencent.mm.plugin.music.model.d.e.fqZ = System.currentTimeMillis();
    AppMethodBeat.o(104863);
  }
  
  public final com.tencent.mm.aw.e m(List<com.tencent.mm.aw.e> paramList, int paramInt)
  {
    AppMethodBeat.i(104846);
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
      AppMethodBeat.o(104846);
      return null;
    }
    synchronized (this.lockObj)
    {
      this.oZi.clear();
      int i = 0;
      while (i < paramList.size())
      {
        com.tencent.mm.aw.e locale = (com.tencent.mm.aw.e)paramList.get(i);
        this.oZi.add(com.tencent.mm.plugin.music.h.b.K(locale));
        com.tencent.mm.plugin.music.model.e.bVM().x(locale);
        i += 1;
      }
      this.oZh = paramInt;
      this.mode = 2;
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.oZh) });
      paramList = bVs();
      AppMethodBeat.o(104846);
      return paramList;
    }
  }
  
  public final void m(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104864);
    super.m(parame);
    com.tencent.mm.plugin.music.model.d.e.KP();
    AppMethodBeat.o(104864);
  }
  
  public final void n(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104865);
    super.n(parame);
    com.tencent.mm.plugin.music.model.d.e.bVU();
    AppMethodBeat.o(104865);
  }
  
  public final void o(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104866);
    super.o(parame);
    com.tencent.mm.plugin.music.model.d.e.bVU();
    if (this.mode == 2) {
      bVA();
    }
    AppMethodBeat.o(104866);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(104868);
    Object localObject1;
    if ((paramm instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.RK().eHt.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramm = ((com.tencent.mm.plugin.music.model.b.a)paramm).oZM;
        if ((bVw() != null) && (paramm.fKj.equals(bVw().field_musicId))) {
          this.oYX.aiu();
        }
        paramString = com.tencent.mm.plugin.music.model.e.bVM();
        paramm = paramm.fKj;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.db.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramm });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.pax.get(paramm);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { bVw().field_musicId });
        AppMethodBeat.o(104868);
      }
    }
    else
    {
      if ((paramm instanceof com.tencent.mm.plugin.music.model.b.b))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(104868);
          return;
        }
        paramString = (com.tencent.mm.plugin.music.model.b.b)paramm;
        Object localObject3 = paramString.oZN;
        localObject1 = paramString.oZD.field_musicId;
        if ((localObject3 != null) && (localObject1 != null))
        {
          Object localObject2 = this.oZi.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramm = (String)((Iterator)localObject2).next();
            if (paramm.equals(localObject1))
            {
              localObject1 = aa.b(((aoq)localObject3).xex);
              localObject2 = aa.b(((aoq)localObject3).xey);
              localObject3 = aa.b(((aoq)localObject3).xew);
              com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.e.bVM();
              boolean bool = paramString.oZO;
              com.tencent.mm.plugin.music.model.e.a locala = localb.VC(paramm);
              if (locala == null) {
                ab.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramm });
              }
              for (;;)
              {
                ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject1, localObject2, localObject3 });
                if (bo.isNullOrNil((String)localObject2)) {
                  break;
                }
                paramm = new ki();
                paramm.cAc.action = 6;
                paramm.cAc.cAd = paramString.oZD.field_musicId;
                com.tencent.mm.sdk.b.a.ymk.a(paramm, Looper.getMainLooper());
                AppMethodBeat.o(104868);
                return;
                if (!bo.isNullOrNil((String)localObject1)) {
                  locala.field_songAlbumUrl = ((String)localObject1);
                }
                locala.field_songHAlbumUrl = ((String)localObject2);
                locala.field_songLyric = ((String)localObject3);
                localb.update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
                localb.pax.put(paramm, locala);
                localb.c(locala, bool);
              }
            }
          }
        }
        AppMethodBeat.o(104868);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.music.model.b.c))
      {
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.music.model.b.c)paramm;
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.oZQ });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          h.qsU.idkeyStat(558L, 214L, 1L, true);
        }
        for (;;)
        {
          paramm = bVw();
          if ((paramm == null) || (TextUtils.isEmpty(paramm.playUrl)) || (!paramm.playUrl.equalsIgnoreCase(paramString.playUrl))) {
            break;
          }
          ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
          this.oYX.q(paramm.bVY());
          AppMethodBeat.o(104868);
          return;
          com.tencent.mm.plugin.music.model.a.b.fz(paramString.playUrl, paramString.oZQ);
        }
        if (paramm != null) {
          ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramm.playUrl, paramString.playUrl });
        }
      }
    }
    AppMethodBeat.o(104868);
  }
  
  public final void release()
  {
    AppMethodBeat.i(104842);
    this.oZi.clear();
    com.tencent.mm.kernel.g.RK().eHt.b(520, this);
    com.tencent.mm.kernel.g.RK().eHt.b(940, this);
    com.tencent.mm.kernel.g.RK().eHt.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.oZj;
    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(ah.getContext(), MMMusicPlayerService.class);
    ah.getContext().stopService(localIntent);
    localb.oZR = null;
    localb.hCe.dead();
    AppMethodBeat.o(104842);
  }
  
  public final void xR(int paramInt)
  {
    AppMethodBeat.i(104852);
    h.qsU.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.oZn)
      {
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(104852);
        return;
      }
      this.mode = 2;
      if (this.oZi.size() <= 1) {
        bVK();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.ac(1, 2, paramInt);
        AppMethodBeat.o(104852);
        return;
        localki = new ki();
        localki.cAc.action = 5;
        com.tencent.mm.sdk.b.a.ymk.l(localki);
      }
    }
    this.mode = 1;
    ki localki = new ki();
    localki.cAc.action = 5;
    com.tencent.mm.sdk.b.a.ymk.l(localki);
    com.tencent.mm.plugin.music.model.d.e.ac(2, 1, paramInt);
    AppMethodBeat.o(104852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */