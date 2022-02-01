package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.lm.b;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.network.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.al.g, e
{
  private Object lockObj;
  private int mode;
  private int tWn;
  private List<String> tWo;
  private com.tencent.mm.plugin.music.model.notification.b tWp;
  private com.tencent.mm.plugin.music.model.b.b tWq;
  private com.tencent.mm.plugin.music.model.b.a tWr;
  private com.tencent.mm.plugin.music.model.b.c tWs;
  private boolean tWt;
  
  public m()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.tWo = new ArrayList();
    this.tWp = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void cVl()
  {
    AppMethodBeat.i(62980);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final void Ft(int paramInt)
  {
    AppMethodBeat.i(62979);
    h.vKh.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.tWt)
      {
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.tWo.size() <= 1) {
        cVl();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.al(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        localln = new ln();
        localln.dql.action = 5;
        com.tencent.mm.sdk.b.a.ESL.l(localln);
      }
    }
    this.mode = 1;
    ln localln = new ln();
    localln.dql.action = 5;
    com.tencent.mm.sdk.b.a.ESL.l(localln);
    com.tencent.mm.plugin.music.model.d.e.al(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final boolean HJ(int paramInt)
  {
    AppMethodBeat.i(62986);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.HJ(paramInt);
    AppMethodBeat.o(62986);
    return bool;
  }
  
  public final void HL(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.tWo.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.tWo.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.tWo.size();
    }
    if (paramInt != this.tWn)
    {
      this.tWn = paramInt;
      this.tWe.s(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final void a(com.tencent.mm.az.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.cVv();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(62996);
    if (parama == null)
    {
      AppMethodBeat.o(62996);
      return;
    }
    if (this.tWq != null)
    {
      com.tencent.mm.kernel.g.afA().gcy.a(this.tWq);
      this.tWq = null;
    }
    if (parama.field_songId <= 0)
    {
      ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId ");
      h.vKh.kvStat(10911, "1");
      AppMethodBeat.o(62996);
      return;
    }
    this.tWq = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean);
    com.tencent.mm.kernel.g.afA().gcy.a(this.tWq, 0);
    AppMethodBeat.o(62996);
  }
  
  public final String aiG(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.b.aiG(paramString);
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.aiL(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final URL aiH(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new b.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a aiI(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = com.tencent.mm.plugin.music.model.f.cVn().aiP(paramString);
    if (locala != null)
    {
      this.tWo.add(paramString);
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final com.tencent.mm.az.f cUT()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.tWo.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.tWo.size() <= this.tWn)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.tWo.get(this.tWn);
      localObject2 = com.tencent.mm.plugin.music.model.f.cVn().aiP((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).cVz();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e.a cUX()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.tWo.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.tWo.size() <= this.tWn)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.tWo.get(this.tWn);
      localObject2 = com.tencent.mm.plugin.music.model.f.cVn().aiP((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean cUY()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = cUX();
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
  
  public final List<String> cUZ()
  {
    return this.tWo;
  }
  
  public final void cVa()
  {
    this.mode = 1;
  }
  
  public final void cVb()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.tWn += 1;
    this.tWn %= this.tWo.size();
    this.tWe.nJ(true);
    this.tWe.s(null);
    AppMethodBeat.o(62982);
  }
  
  public final void cVc()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.tWn = (this.tWn + this.tWo.size() - 1);
    this.tWn %= this.tWo.size();
    this.tWe.nJ(true);
    this.tWe.s(null);
    AppMethodBeat.o(62983);
  }
  
  public final int cVd()
  {
    return this.tWn;
  }
  
  public final void cVe()
  {
    AppMethodBeat.i(62984);
    if (!this.tWe.cUV().azF())
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean cVf()
  {
    AppMethodBeat.i(62985);
    if ((this.tWo.size() > 0) && (this.mode == 2))
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
          this.tWo.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.az.f localf = (com.tencent.mm.az.f)paramList.next();
            this.tWo.add(com.tencent.mm.plugin.music.h.b.N(localf));
            com.tencent.mm.plugin.music.model.f.cVn().A(localf);
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
    com.tencent.mm.plugin.music.model.e.a locala = cUX();
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
      this.tWe.u(paramf);
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
      this.tWe.u(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (this.tWr != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(this.tWr);
    }
    com.tencent.mm.kernel.g.afA().gcy.a(940, this);
    this.tWr = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.g.afA().gcy.a(this.tWr, 0);
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
        if (this.tWs != null)
        {
          com.tencent.mm.kernel.g.afA().gcy.a(this.tWs);
          this.tWs = null;
        }
        ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.tWs = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.g.afA().gcy.a(this.tWs, 0);
        h.vKh.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.g.afA().gcy.a(520, this);
    com.tencent.mm.kernel.g.afA().gcy.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.tWp;
    ad.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.jBI = new b.1(localb);
    localb.jBI.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.az.f j(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.N(paramf);
    for (;;)
    {
      synchronized (this.lockObj)
      {
        if (this.tWo == null) {
          break label226;
        }
        i = 0;
        if (i >= this.tWo.size()) {
          break label221;
        }
        if (str.equals(this.tWo.get(i)))
        {
          this.tWn = i;
          i = 1;
          j = i;
          if (this.tWo.size() > 1)
          {
            j = i;
            if (paramf.hnK)
            {
              this.mode = 2;
              j = i;
            }
          }
          if (j != 0)
          {
            ??? = cUT();
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
        this.tWo.clear();
        this.tWo.add(com.tencent.mm.plugin.music.h.b.N(paramf));
        this.tWn = 0;
        com.tencent.mm.plugin.music.model.f.cVn().A(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        cVl();
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
    if ((paramf == null) && (this.tWo.size() == 0))
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = cUT();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.tWo.clear();
        this.tWo.add(com.tencent.mm.plugin.music.h.b.N(paramf));
        this.tWn = 0;
        com.tencent.mm.plugin.music.model.f.cVn().A(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        cVl();
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
        this.tWo.clear();
        this.tWo.add(com.tencent.mm.plugin.music.h.b.N(paramf));
        this.tWn = 0;
        com.tencent.mm.plugin.music.model.f.cVn().A(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void n(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62989);
    super.n(paramf);
    com.tencent.mm.plugin.music.model.d.e.cVv();
    com.tencent.mm.plugin.music.model.d.e.gSP = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.f(cUX());
    AppMethodBeat.o(62989);
  }
  
  public final void o(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62990);
    super.o(paramf);
    com.tencent.mm.plugin.music.model.d.e.gSP = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.afA().gcy.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = ((com.tencent.mm.plugin.music.model.b.a)paramn).tWX;
        if ((cUX() != null) && (paramn.hnp.equals(cUX().field_musicId))) {
          this.tWe.azD();
        }
        paramString = com.tencent.mm.plugin.music.model.f.cVn();
        paramn = paramn.hnp;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.db.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramn });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.tXI.get(paramn);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { cUX().field_musicId });
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
        Object localObject3 = paramString.tWY;
        localObject1 = paramString.tWO.field_musicId;
        if ((localObject3 != null) && (localObject1 != null))
        {
          Object localObject2 = this.tWo.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramn = (String)((Iterator)localObject2).next();
            if (paramn.equals(localObject1))
            {
              localObject1 = z.b(((ayx)localObject3).Dxn);
              localObject2 = z.b(((ayx)localObject3).Dxo);
              localObject3 = z.b(((ayx)localObject3).Dxm);
              com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.f.cVn();
              boolean bool = paramString.tWZ;
              com.tencent.mm.plugin.music.model.e.a locala = localb.aiP(paramn);
              if (locala == null) {
                ad.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramn });
              }
              for (;;)
              {
                ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject1, localObject2, localObject3 });
                if (bt.isNullOrNil((String)localObject2)) {
                  break;
                }
                paramn = new ln();
                paramn.dql.action = 6;
                paramn.dql.dqm = paramString.tWO.field_musicId;
                com.tencent.mm.sdk.b.a.ESL.a(paramn, Looper.getMainLooper());
                AppMethodBeat.o(62995);
                return;
                if (!bt.isNullOrNil((String)localObject1)) {
                  locala.field_songAlbumUrl = ((String)localObject1);
                }
                locala.field_songHAlbumUrl = ((String)localObject2);
                locala.field_songLyric = ((String)localObject3);
                localb.update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
                localb.tXI.put(paramn, locala);
                localb.c(locala, bool);
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
        ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.tXb });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          h.vKh.idkeyStat(558L, 214L, 1L, true);
        }
        for (;;)
        {
          paramn = cUX();
          if ((paramn == null) || (TextUtils.isEmpty(paramn.playUrl)) || (!paramn.playUrl.equalsIgnoreCase(paramString.playUrl))) {
            break;
          }
          ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
          this.tWe.t(paramn.cVz());
          AppMethodBeat.o(62995);
          return;
          com.tencent.mm.plugin.music.model.a.b.hF(paramString.playUrl, paramString.tXb);
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
    com.tencent.mm.plugin.music.model.d.e.azB();
    AppMethodBeat.o(62991);
  }
  
  public final void q(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62992);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.cVv();
    AppMethodBeat.o(62992);
  }
  
  public final com.tencent.mm.az.f r(List<com.tencent.mm.az.f> paramList, int paramInt)
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
      this.tWo.clear();
      int i = 0;
      while (i < paramList.size())
      {
        com.tencent.mm.az.f localf = (com.tencent.mm.az.f)paramList.get(i);
        this.tWo.add(com.tencent.mm.plugin.music.h.b.N(localf));
        com.tencent.mm.plugin.music.model.f.cVn().A(localf);
        i += 1;
      }
      this.tWn = paramInt;
      this.mode = 2;
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.tWn) });
      paramList = cUT();
      AppMethodBeat.o(62972);
      return paramList;
    }
  }
  
  public final void r(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(62993);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.cVv();
    if ((this.mode == 2) && ((this.tWn < this.tWo.size() - 1) || (paramf.hnK)))
    {
      paramf = new ln();
      paramf.dql.action = 15;
      paramf.dql.state = "";
      com.tencent.mm.sdk.b.a.ESL.a(paramf, Looper.getMainLooper());
      cVb();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.tWo.clear();
    com.tencent.mm.kernel.g.afA().gcy.b(520, this);
    com.tencent.mm.kernel.g.afA().gcy.b(940, this);
    com.tencent.mm.kernel.g.afA().gcy.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.tWp;
    ad.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(aj.getContext(), MMMusicPlayerService.class);
    aj.getContext().stopService(localIntent);
    localb.tXc = null;
    localb.jBI.dead();
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
      Object localObject1 = m.this.cUT();
      ArrayList localArrayList = new ArrayList();
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.az.f)localObject1).hnn) });
      int i;
      label118:
      Object localObject2;
      switch (((com.tencent.mm.az.f)localObject1).hnn)
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
        localObject2 = (com.tencent.mm.az.f)((List)localObject1).get(i);
        if (localObject2 == null) {
          ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break label118;
        localObject1 = new gs();
        ((gs)localObject1).dkc.type = 18;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((gs)localObject1).dkd.dkq;
        break;
        localObject1 = new lm();
        ((lm)localObject1).dqd.action = -4;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((lm)localObject1).dqe.dkq;
        break;
        localObject1 = new lm();
        ((lm)localObject1).dqd.action = -5;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((lm)localObject1).dqe.dkq;
        break;
        localObject2 = new lm();
        ((lm)localObject2).dqd.action = -6;
        ((lm)localObject2).dqd.dqf = ((com.tencent.mm.az.f)localObject1);
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject1 = ((lm)localObject2).dqe.dkq;
        break;
        com.tencent.mm.plugin.music.model.f.cVn().A((com.tencent.mm.az.f)localObject2);
        localArrayList.add(com.tencent.mm.plugin.music.h.b.N((com.tencent.mm.az.f)localObject2));
      }
      label360:
      ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      m.a(m.this, false);
      localObject1 = new m.b(m.this, (byte)0);
      ((m.b)localObject1).tWv = localArrayList;
      aq.f((Runnable)localObject1);
      AppMethodBeat.o(62964);
    }
  }
  
  final class b
    implements Runnable
  {
    List<String> tWv;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(62965);
      Object localObject1 = com.tencent.mm.plugin.music.h.b.N(m.this.cUT());
      int j = m.a(m.this);
      int i = 0;
      int k = 0;
      while (i < this.tWv.size())
      {
        if (((String)this.tWv.get(i)).equals(localObject1))
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
          while (i < this.tWv.size())
          {
            m.c(m.this).add(this.tWv.get(i));
            i += 1;
            continue;
            while (i < j)
            {
              m.c(m.this).add(this.tWv.get(i));
              i += 1;
            }
            ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(m.this).size()), Integer.valueOf(m.a(m.this)) });
            localObject1 = new ln();
            ((ln)localObject1).dql.action = 5;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */