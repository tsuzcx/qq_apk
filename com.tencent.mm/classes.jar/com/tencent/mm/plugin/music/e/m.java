package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.nn.b;
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.np;
import com.tencent.mm.network.d.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.an.i, e
{
  private int FQD;
  private List<String> FQE;
  private com.tencent.mm.plugin.music.model.notification.b FQF;
  private com.tencent.mm.plugin.music.model.b.b FQG;
  private com.tencent.mm.plugin.music.model.b.a FQH;
  private com.tencent.mm.plugin.music.model.b.c FQI;
  private boolean FQJ;
  private Object lockObj;
  private int mode;
  
  public m()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.FQE = new ArrayList();
    this.FQF = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void few()
  {
    AppMethodBeat.i(62980);
    ThreadPool.post(new a((byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final void Vu(int paramInt)
  {
    AppMethodBeat.i(62979);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.FQJ)
      {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.FQE.size() <= 1) {
        few();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.ax(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        localnp = new np();
        localnp.fMc.action = 5;
        EventCenter.instance.publish(localnp);
      }
    }
    this.mode = 1;
    np localnp = new np();
    localnp.fMc.action = 5;
    EventCenter.instance.publish(localnp);
    com.tencent.mm.plugin.music.model.d.e.ax(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final void Zk(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.FQE.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.FQE.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.FQE.size();
    }
    if (paramInt != this.FQD)
    {
      this.FQD = paramInt;
      this.FQu.s(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final void a(com.tencent.mm.bb.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.ffd();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(259908);
    if (parama == null)
    {
      AppMethodBeat.o(259908);
      return;
    }
    if (this.FQG != null)
    {
      com.tencent.mm.kernel.h.aHF().kcd.a(this.FQG);
      this.FQG = null;
    }
    if ((parama.field_songId <= 0) && (TextUtils.isEmpty(parama.field_songMId)))
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10911, "1");
      AppMethodBeat.o(259908);
      return;
    }
    this.FQG = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.FQG, 0);
    AppMethodBeat.o(259908);
  }
  
  public final URL aRZ(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new d.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a aSa(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = o.feW().aSm(paramString);
    if (locala != null)
    {
      this.FQE.add(paramString);
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final String aqw(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.b.aqw(paramString);
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.aSi(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final com.tencent.mm.bb.f fed()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.FQE.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.FQE.size() <= this.FQD)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.FQE.get(this.FQD);
      localObject2 = o.feW().aSm((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).ffh();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final boolean fee()
  {
    AppMethodBeat.i(259903);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.fee();
    AppMethodBeat.o(259903);
    return bool;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a fei()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.FQE.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.FQE.size() <= this.FQD)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.FQE.get(this.FQD);
      localObject2 = o.feW().aSm((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean fej()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = fei();
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
  
  public final List<String> fek()
  {
    return this.FQE;
  }
  
  public final void fel()
  {
    this.mode = 1;
  }
  
  public final void fem()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.FQD += 1;
    this.FQD %= this.FQE.size();
    this.FQu.vq(true);
    this.FQu.s(null);
    AppMethodBeat.o(62982);
  }
  
  public final void fen()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.FQD = (this.FQD + this.FQE.size() - 1);
    this.FQD %= this.FQE.size();
    this.FQu.vq(true);
    this.FQu.s(null);
    AppMethodBeat.o(62983);
  }
  
  public final int feo()
  {
    return this.FQD;
  }
  
  public final void fep()
  {
    AppMethodBeat.i(62984);
    if (!this.FQu.feg().bnx())
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean feq()
  {
    AppMethodBeat.i(62985);
    if ((this.FQE.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(62985);
      return true;
    }
    AppMethodBeat.o(62985);
    return false;
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final boolean i(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62969);
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(62969);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = fei();
    if ((locala == null) || (!com.tencent.mm.plugin.music.model.m.b(locala)))
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.FQu.u(paramf);
      AppMethodBeat.o(62969);
      return false;
    }
    if (locala.field_isBlock == 1)
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.FQu.u(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (this.FQH != null) {
      com.tencent.mm.kernel.h.aHF().kcd.a(this.FQH);
    }
    com.tencent.mm.kernel.h.aHF().kcd.a(940, this);
    this.FQH = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.FQH, 0);
    if (com.tencent.mm.plugin.music.model.a.b.c(locala))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
      paramf = locala.playUrl;
      if (TextUtils.isEmpty(paramf)) {
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
      }
      for (;;)
      {
        AppMethodBeat.o(62969);
        return false;
        if (this.FQI != null)
        {
          com.tencent.mm.kernel.h.aHF().kcd.a(this.FQI);
          this.FQI = null;
        }
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.FQI = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.h.aHF().kcd.a(this.FQI, 0);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.h.aHF().kcd.a(520, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.FQF;
    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.ozM = new b.1(localb);
    localb.ozM.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.bb.f j(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.S(paramf);
    for (;;)
    {
      int i;
      synchronized (this.lockObj)
      {
        if (this.FQE == null) {
          break label226;
        }
        i = 0;
        if (i < this.FQE.size()) {
          if (str.equals(this.FQE.get(i)))
          {
            this.FQD = i;
            i = 1;
            j = i;
            if (this.FQE.size() > 1)
            {
              j = i;
              if (paramf.lVO)
              {
                this.mode = 2;
                j = i;
              }
            }
            if (j != 0)
            {
              ??? = fed();
              AppMethodBeat.o(62970);
              return ???;
            }
          }
          else
          {
            i += 1;
          }
        }
      }
      synchronized (this.lockObj)
      {
        this.FQE.clear();
        this.FQE.add(com.tencent.mm.plugin.music.h.b.S(paramf));
        this.FQD = 0;
        o.feW().F(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        few();
        ??? = paramf;
      }
      label226:
      int j = 0;
    }
  }
  
  public final void j(List<com.tencent.mm.bb.f> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(62974);
        if ((paramList == null) || (paramList.size() == 0))
        {
          Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
          AppMethodBeat.o(62974);
          return;
        }
        localObject = this.lockObj;
        if (paramBoolean) {}
        try
        {
          this.FQE.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.bb.f localf = (com.tencent.mm.bb.f)paramList.next();
            this.FQE.add(com.tencent.mm.plugin.music.h.b.S(localf));
            o.feW().F(localf);
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
  
  public final com.tencent.mm.bb.f k(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62971);
    if ((paramf == null) && (this.FQE.size() == 0))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = fed();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.FQE.clear();
        this.FQE.add(com.tencent.mm.plugin.music.h.b.S(paramf));
        this.FQD = 0;
        o.feW().F(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        few();
        ??? = paramf;
      }
    }
  }
  
  public final void l(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62973);
    if (paramf != null) {
      synchronized (this.lockObj)
      {
        this.FQE.clear();
        this.FQE.add(com.tencent.mm.plugin.music.h.b.S(paramf));
        this.FQD = 0;
        o.feW().F(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void m(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(259898);
    super.m(paramf);
    o.feW().F(paramf);
    AppMethodBeat.o(259898);
  }
  
  public final void n(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62989);
    super.n(paramf);
    com.tencent.mm.plugin.music.model.d.e.ffd();
    com.tencent.mm.plugin.music.model.d.e.lzJ = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.g(fei());
    AppMethodBeat.o(62989);
  }
  
  public final void o(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62990);
    super.o(paramf);
    com.tencent.mm.plugin.music.model.d.e.lzJ = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.h.aHF().kcd.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0)
        {
          localObject1 = ((com.tencent.mm.plugin.music.model.b.a)paramq).FRZ;
          if ((fei() != null) && (((zf)localObject1).lVt.equals(fei().field_musicId))) {
            this.FQu.bnv();
          }
          paramq = o.feW();
          localObject1 = ((zf)localObject1).lVt;
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("isBlock", Integer.valueOf(1));
          paramq.db.update("Music", (ContentValues)localObject2, "musicId=?", new String[] { localObject1 });
          paramq = (com.tencent.mm.plugin.music.model.e.a)paramq.FSN.get(localObject1);
          if (paramq != null) {
            paramq.field_isBlock = 1;
          }
          Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { fei().field_musicId });
          paramq = new no();
          paramq.fMb.errCode = paramInt2;
          paramq.fMb.errMsg = paramString;
          EventCenter.instance.publish(paramq);
        }
        AppMethodBeat.o(62995);
        return;
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.music.model.b.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(62995);
        return;
      }
      paramString = (com.tencent.mm.plugin.music.model.b.b)paramq;
      localObject1 = paramString.FSa;
      localObject2 = paramString.FRG.field_musicId;
      if ((localObject1 != null) && (localObject2 != null))
      {
        Object localObject3 = this.FQE.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          paramq = (String)((Iterator)localObject3).next();
          if (paramq.equals(localObject2))
          {
            localObject2 = z.b(((caz)localObject1).Tjp);
            localObject3 = z.b(((caz)localObject1).Tjq);
            localObject1 = z.b(((caz)localObject1).Tjo);
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(259910);
                o.feW().b(paramq, this.FQK, this.FQL, this.FQM, paramString.FSb, paramString.FSc);
                AppMethodBeat.o(259910);
              }
            });
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject2, localObject3, localObject1 });
            if (!Util.isNullOrNil((String)localObject3))
            {
              paramq = new np();
              paramq.fMc.action = 6;
              paramq.fMc.fMd = paramString.FRG.field_musicId;
              EventCenter.instance.asyncPublish(paramq, Looper.getMainLooper());
              AppMethodBeat.o(62995);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(62995);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.music.model.b.c))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (com.tencent.mm.plugin.music.model.b.c)paramq;
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.FSe });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(558L, 214L, 1L, true);
      }
      for (;;)
      {
        paramq = fei();
        if ((paramq == null) || (TextUtils.isEmpty(paramq.playUrl)) || (!paramq.playUrl.equalsIgnoreCase(paramString.playUrl))) {
          break;
        }
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
        this.FQu.t(paramq.ffh());
        AppMethodBeat.o(62995);
        return;
        com.tencent.mm.plugin.music.model.a.b.jk(paramString.playUrl, paramString.FSe);
      }
      if (paramq != null) {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramq.playUrl, paramString.playUrl });
      }
    }
    AppMethodBeat.o(62995);
  }
  
  public final void p(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62991);
    super.p(paramf);
    com.tencent.mm.plugin.music.model.d.e.bnt();
    AppMethodBeat.o(62991);
  }
  
  public final void q(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62992);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.ffd();
    AppMethodBeat.o(62992);
  }
  
  public final void r(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(62993);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.ffd();
    if ((this.mode == 2) && ((this.FQD < this.FQE.size() - 1) || (paramf.lVO)))
    {
      paramf = new np();
      paramf.fMc.action = 15;
      paramf.fMc.state = "";
      EventCenter.instance.asyncPublish(paramf, Looper.getMainLooper());
      fem();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.FQE.clear();
    com.tencent.mm.kernel.h.aHF().kcd.b(520, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(940, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.FQF;
    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), MMMusicPlayerService.class);
    MMApplicationContext.getContext().stopService(localIntent);
    localb.FSg = null;
    localb.ozM.dead();
    AppMethodBeat.o(62968);
  }
  
  public final com.tencent.mm.bb.f z(List<com.tencent.mm.bb.f> paramList, int paramInt)
  {
    AppMethodBeat.i(62972);
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
      AppMethodBeat.o(62972);
      return null;
    }
    synchronized (this.lockObj)
    {
      this.FQE.clear();
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject2 = (com.tencent.mm.bb.f)paramList.get(i);
        this.FQE.add(com.tencent.mm.plugin.music.h.b.S((com.tencent.mm.bb.f)localObject2));
        o.feW().F((com.tencent.mm.bb.f)localObject2);
        i += 1;
      }
      this.FQD = paramInt;
      this.mode = 2;
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.FQD) });
      paramList = fed();
      if (paramList.fod > 0)
      {
        ??? = com.tencent.mm.plugin.music.h.b.S(paramList);
        localObject2 = o.feW();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("startTime", Integer.valueOf(0));
        ((com.tencent.mm.plugin.music.model.e.b)localObject2).db.update("Music", localContentValues, "musicId=?", new String[] { ??? });
        ??? = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject2).FSN.get(???);
        if (??? != null) {
          ((com.tencent.mm.plugin.music.model.e.a)???).field_startTime = 0;
        }
      }
      AppMethodBeat.o(62972);
      return paramList;
    }
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
      Object localObject1 = m.this.fed();
      ArrayList localArrayList = new ArrayList();
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.bb.f)localObject1).lVr) });
      int i;
      label118:
      Object localObject2;
      switch (((com.tencent.mm.bb.f)localObject1).lVr)
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
        localObject2 = (com.tencent.mm.bb.f)((List)localObject1).get(i);
        if (localObject2 == null) {
          Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break label118;
        localObject1 = new hi();
        ((hi)localObject1).fEb.type = 18;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((hi)localObject1).fEc.fEp;
        break;
        localObject1 = new nn();
        ((nn)localObject1).fLT.action = -4;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((nn)localObject1).fLU.fEp;
        break;
        localObject1 = new nn();
        ((nn)localObject1).fLT.action = -5;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((nn)localObject1).fLU.fEp;
        break;
        localObject2 = new nn();
        ((nn)localObject2).fLT.action = -6;
        ((nn)localObject2).fLT.fLV = ((com.tencent.mm.bb.f)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        localObject1 = ((nn)localObject2).fLU.fEp;
        break;
        o.feW().F((com.tencent.mm.bb.f)localObject2);
        localArrayList.add(com.tencent.mm.plugin.music.h.b.S((com.tencent.mm.bb.f)localObject2));
      }
      label360:
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      m.a(m.this, false);
      localObject1 = new m.b(m.this, (byte)0);
      ((m.b)localObject1).FQP = localArrayList;
      MMHandlerThread.postToMainThread((Runnable)localObject1);
      AppMethodBeat.o(62964);
    }
  }
  
  final class b
    implements Runnable
  {
    List<String> FQP;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(62965);
      Object localObject1 = com.tencent.mm.plugin.music.h.b.S(m.this.fed());
      int j = m.a(m.this);
      int i = 0;
      int k = 0;
      while (i < this.FQP.size())
      {
        if (((String)this.FQP.get(i)).equals(localObject1))
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
          while (i < this.FQP.size())
          {
            m.c(m.this).add(this.FQP.get(i));
            i += 1;
            continue;
            while (i < j)
            {
              m.c(m.this).add(this.FQP.get(i));
              i += 1;
            }
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(m.this).size()), Integer.valueOf(m.a(m.this)) });
            localObject1 = new np();
            ((np)localObject1).fMc.action = 5;
            EventCenter.instance.publish((IEvent)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */