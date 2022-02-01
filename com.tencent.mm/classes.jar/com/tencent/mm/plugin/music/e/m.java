package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.mw.b;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.network.d.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.zb;
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
  implements com.tencent.mm.ak.i, e
{
  private int AjF;
  private List<String> AjG;
  private com.tencent.mm.plugin.music.model.notification.b AjH;
  private com.tencent.mm.plugin.music.model.b.b AjI;
  private com.tencent.mm.plugin.music.model.b.a AjJ;
  private com.tencent.mm.plugin.music.model.b.c AjK;
  private boolean AjL;
  private Object lockObj;
  private int mode;
  
  public m()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.AjG = new ArrayList();
    this.AjH = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void eum()
  {
    AppMethodBeat.i(62980);
    ThreadPool.post(new a((byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final void Pl(int paramInt)
  {
    AppMethodBeat.i(62979);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.AjL)
      {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.AjG.size() <= 1) {
        eum();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.at(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        localmx = new mx();
        localmx.dSE.action = 5;
        EventCenter.instance.publish(localmx);
      }
    }
    this.mode = 1;
    mx localmx = new mx();
    localmx.dSE.action = 5;
    EventCenter.instance.publish(localmx);
    com.tencent.mm.plugin.music.model.d.e.at(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final void SO(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.AjG.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.AjG.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.AjG.size();
    }
    if (paramInt != this.AjF)
    {
      this.AjF = paramInt;
      this.Ajw.s(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final void a(com.tencent.mm.ay.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.euK();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219817);
    if (parama == null)
    {
      AppMethodBeat.o(219817);
      return;
    }
    if (this.AjI != null)
    {
      com.tencent.mm.kernel.g.aAg().hqi.a(this.AjI);
      this.AjI = null;
    }
    if ((parama.field_songId <= 0) && (TextUtils.isEmpty(parama.field_songMId)))
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10911, "1");
      AppMethodBeat.o(219817);
      return;
    }
    this.AjI = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.AjI, 0);
    AppMethodBeat.o(219817);
  }
  
  public final URL aHK(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new d.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a aHL(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = o.euD().aHW(paramString);
    if (locala != null)
    {
      this.AjG.add(paramString);
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final String aiK(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.b.aiK(paramString);
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.aHS(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final com.tencent.mm.ay.f etU()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.AjG.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.AjG.size() <= this.AjF)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.AjG.get(this.AjF);
      localObject2 = o.euD().aHW((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).euO();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e.a etY()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.AjG.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.AjG.size() <= this.AjF)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.AjG.get(this.AjF);
      localObject2 = o.euD().aHW((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean etZ()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = etY();
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
  
  public final List<String> eua()
  {
    return this.AjG;
  }
  
  public final void eub()
  {
    this.mode = 1;
  }
  
  public final void euc()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.AjF += 1;
    this.AjF %= this.AjG.size();
    this.Ajw.sl(true);
    this.Ajw.s(null);
    AppMethodBeat.o(62982);
  }
  
  public final void eud()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.AjF = (this.AjF + this.AjG.size() - 1);
    this.AjF %= this.AjG.size();
    this.Ajw.sl(true);
    this.Ajw.s(null);
    AppMethodBeat.o(62983);
  }
  
  public final int eue()
  {
    return this.AjF;
  }
  
  public final void euf()
  {
    AppMethodBeat.i(62984);
    if (!this.Ajw.etW().bec())
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean eug()
  {
    AppMethodBeat.i(62985);
    if ((this.AjG.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(62985);
      return true;
    }
    AppMethodBeat.o(62985);
    return false;
  }
  
  public final boolean gEZ()
  {
    AppMethodBeat.i(258337);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("musicplayer", "useQQMusicPlayer")), 0) == 1)
    {
      AppMethodBeat.o(258337);
      return true;
    }
    AppMethodBeat.o(258337);
    return false;
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final void i(List<com.tencent.mm.ay.f> paramList, boolean paramBoolean)
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
          this.AjG.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.ay.f localf = (com.tencent.mm.ay.f)paramList.next();
            this.AjG.add(com.tencent.mm.plugin.music.h.b.S(localf));
            o.euD().F(localf);
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
  
  public final boolean i(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62969);
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(62969);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = etY();
    if ((locala == null) || (!com.tencent.mm.plugin.music.model.m.b(locala)))
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.Ajw.u(paramf);
      AppMethodBeat.o(62969);
      return false;
    }
    if (locala.field_isBlock == 1)
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.Ajw.u(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (this.AjJ != null) {
      com.tencent.mm.kernel.g.aAg().hqi.a(this.AjJ);
    }
    com.tencent.mm.kernel.g.aAg().hqi.a(940, this);
    this.AjJ = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.AjJ, 0);
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
        if (this.AjK != null)
        {
          com.tencent.mm.kernel.g.aAg().hqi.a(this.AjK);
          this.AjK = null;
        }
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.AjK = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.g.aAg().hqi.a(this.AjK, 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.g.aAg().hqi.a(520, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.AjH;
    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.lEl = new b.1(localb);
    localb.lEl.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.ay.f j(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.S(paramf);
    for (;;)
    {
      synchronized (this.lockObj)
      {
        if (this.AjG == null) {
          break label226;
        }
        i = 0;
        if (i >= this.AjG.size()) {
          break label221;
        }
        if (str.equals(this.AjG.get(i)))
        {
          this.AjF = i;
          i = 1;
          j = i;
          if (this.AjG.size() > 1)
          {
            j = i;
            if (paramf.jfq)
            {
              this.mode = 2;
              j = i;
            }
          }
          if (j != 0)
          {
            ??? = etU();
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
        this.AjG.clear();
        this.AjG.add(com.tencent.mm.plugin.music.h.b.S(paramf));
        this.AjF = 0;
        o.euD().F(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        eum();
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
    if ((paramf == null) && (this.AjG.size() == 0))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = etU();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.AjG.clear();
        this.AjG.add(com.tencent.mm.plugin.music.h.b.S(paramf));
        this.AjF = 0;
        o.euD().F(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        eum();
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
        this.AjG.clear();
        this.AjG.add(com.tencent.mm.plugin.music.h.b.S(paramf));
        this.AjF = 0;
        o.euD().F(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void m(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(219816);
    super.m(paramf);
    o.euD().F(paramf);
    AppMethodBeat.o(219816);
  }
  
  public final void n(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62989);
    super.n(paramf);
    com.tencent.mm.plugin.music.model.d.e.euK();
    com.tencent.mm.plugin.music.model.d.e.iJF = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.g(etY());
    AppMethodBeat.o(62989);
  }
  
  public final void o(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62990);
    super.o(paramf);
    com.tencent.mm.plugin.music.model.d.e.iJF = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    if ((paramq instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.aAg().hqi.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramq = ((com.tencent.mm.plugin.music.model.b.a)paramq).AkT;
        if ((etY() != null) && (paramq.jeV.equals(etY().field_musicId))) {
          this.Ajw.bea();
        }
        paramString = o.euD();
        paramq = paramq.jeV;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.db.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramq });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.AlG.get(paramq);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { etY().field_musicId });
        AppMethodBeat.o(62995);
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.plugin.music.model.b.b))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(62995);
          return;
        }
        paramString = (com.tencent.mm.plugin.music.model.b.b)paramq;
        localObject1 = paramString.AkU;
        final String str = paramString.AkC.field_musicId;
        if ((localObject1 != null) && (str != null))
        {
          Object localObject2 = this.AjG.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramq = (String)((Iterator)localObject2).next();
            if (paramq.equals(str))
            {
              str = z.b(((bth)localObject1).LZW);
              localObject2 = z.b(((bth)localObject1).LZX);
              localObject1 = z.b(((bth)localObject1).LZV);
              com.tencent.f.h.RTc.aX(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(219815);
                  o.euD().b(paramq, str, this.AjN, this.AjO, paramString.AkV, paramString.AkW);
                  AppMethodBeat.o(219815);
                }
              });
              Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { str, localObject2, localObject1 });
              if (!Util.isNullOrNil((String)localObject2))
              {
                paramq = new mx();
                paramq.dSE.action = 6;
                paramq.dSE.dSF = paramString.AkC.field_musicId;
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
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.AkY });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(558L, 214L, 1L, true);
        }
        for (;;)
        {
          paramq = etY();
          if ((paramq == null) || (TextUtils.isEmpty(paramq.playUrl)) || (!paramq.playUrl.equalsIgnoreCase(paramString.playUrl))) {
            break;
          }
          Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
          this.Ajw.t(paramq.euO());
          AppMethodBeat.o(62995);
          return;
          com.tencent.mm.plugin.music.model.a.b.ja(paramString.playUrl, paramString.AkY);
        }
        if (paramq != null) {
          Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramq.playUrl, paramString.playUrl });
        }
      }
    }
    AppMethodBeat.o(62995);
  }
  
  public final void p(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62991);
    super.p(paramf);
    com.tencent.mm.plugin.music.model.d.e.bdY();
    AppMethodBeat.o(62991);
  }
  
  public final void q(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62992);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.euK();
    AppMethodBeat.o(62992);
  }
  
  public final void r(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62993);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.euK();
    if ((this.mode == 2) && ((this.AjF < this.AjG.size() - 1) || (paramf.jfq)))
    {
      paramf = new mx();
      paramf.dSE.action = 15;
      paramf.dSE.state = "";
      EventCenter.instance.asyncPublish(paramf, Looper.getMainLooper());
      euc();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.AjG.clear();
    com.tencent.mm.kernel.g.aAg().hqi.b(520, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(940, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.AjH;
    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), MMMusicPlayerService.class);
    MMApplicationContext.getContext().stopService(localIntent);
    localb.AkZ = null;
    localb.lEl.dead();
    AppMethodBeat.o(62968);
  }
  
  public final com.tencent.mm.ay.f y(List<com.tencent.mm.ay.f> paramList, int paramInt)
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
      this.AjG.clear();
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject2 = (com.tencent.mm.ay.f)paramList.get(i);
        this.AjG.add(com.tencent.mm.plugin.music.h.b.S((com.tencent.mm.ay.f)localObject2));
        o.euD().F((com.tencent.mm.ay.f)localObject2);
        i += 1;
      }
      this.AjF = paramInt;
      this.mode = 2;
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.AjF) });
      paramList = etU();
      if (paramList.dvv > 0)
      {
        ??? = com.tencent.mm.plugin.music.h.b.S(paramList);
        localObject2 = o.euD();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("startTime", Integer.valueOf(0));
        ((com.tencent.mm.plugin.music.model.e.b)localObject2).db.update("Music", localContentValues, "musicId=?", new String[] { ??? });
        ??? = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject2).AlG.get(???);
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
      Object localObject1 = m.this.etU();
      ArrayList localArrayList = new ArrayList();
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.ay.f)localObject1).jeT) });
      int i;
      label118:
      Object localObject2;
      switch (((com.tencent.mm.ay.f)localObject1).jeT)
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
          Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break label118;
        localObject1 = new hb();
        ((hb)localObject1).dLm.type = 18;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((hb)localObject1).dLn.dLA;
        break;
        localObject1 = new mw();
        ((mw)localObject1).dSw.action = -4;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((mw)localObject1).dSx.dLA;
        break;
        localObject1 = new mw();
        ((mw)localObject1).dSw.action = -5;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = ((mw)localObject1).dSx.dLA;
        break;
        localObject2 = new mw();
        ((mw)localObject2).dSw.action = -6;
        ((mw)localObject2).dSw.dSy = ((com.tencent.mm.ay.f)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        localObject1 = ((mw)localObject2).dSx.dLA;
        break;
        o.euD().F((com.tencent.mm.ay.f)localObject2);
        localArrayList.add(com.tencent.mm.plugin.music.h.b.S((com.tencent.mm.ay.f)localObject2));
      }
      label360:
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      m.a(m.this, false);
      localObject1 = new m.b(m.this, (byte)0);
      ((m.b)localObject1).AjR = localArrayList;
      MMHandlerThread.postToMainThread((Runnable)localObject1);
      AppMethodBeat.o(62964);
    }
  }
  
  final class b
    implements Runnable
  {
    List<String> AjR;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(62965);
      Object localObject1 = com.tencent.mm.plugin.music.h.b.S(m.this.etU());
      int j = m.a(m.this);
      int i = 0;
      int k = 0;
      while (i < this.AjR.size())
      {
        if (((String)this.AjR.get(i)).equals(localObject1))
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
          while (i < this.AjR.size())
          {
            m.c(m.this).add(this.AjR.get(i));
            i += 1;
            continue;
            while (i < j)
            {
              m.c(m.this).add(this.AjR.get(i));
              i += 1;
            }
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.c(m.this).size()), Integer.valueOf(m.a(m.this)) });
            localObject1 = new mx();
            ((mx)localObject1).dSE.action = 5;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */