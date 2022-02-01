package com.tencent.mm.plugin.music.logic;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ow;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.network.d.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.model.notification.MMMusicNotificationHelper.1;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends f
  implements com.tencent.mm.am.h, e
{
  private List<String> LLA;
  private com.tencent.mm.plugin.music.model.notification.b LLB;
  public b LLC;
  private com.tencent.mm.plugin.music.model.b.b LLD;
  private com.tencent.mm.plugin.music.model.b.a LLE;
  private com.tencent.mm.plugin.music.model.b.c LLF;
  private com.tencent.mm.plugin.music.model.b.d LLG;
  private boolean LLH;
  private int LLz;
  private Object lockObj;
  private int mode;
  
  public l()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.LLA = new ArrayList();
    this.LLB = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void gnz()
  {
    AppMethodBeat.i(62980);
    ThreadPool.post(new l.a(this, (byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final com.tencent.mm.aw.f S(List<com.tencent.mm.aw.f> paramList, int paramInt)
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
      this.LLA.clear();
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject2 = (com.tencent.mm.aw.f)paramList.get(i);
        this.LLA.add(com.tencent.mm.plugin.music.h.b.Y((com.tencent.mm.aw.f)localObject2));
        o.god().K((com.tencent.mm.aw.f)localObject2);
        i += 1;
      }
      this.LLz = paramInt;
      this.mode = 2;
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.LLz) });
      paramList = gng();
      if (paramList.startTime > 0)
      {
        ??? = com.tencent.mm.plugin.music.h.b.Y(paramList);
        localObject2 = o.god();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("startTime", Integer.valueOf(0));
        ((com.tencent.mm.plugin.music.model.e.b)localObject2).db.update("Music", localContentValues, "musicId=?", new String[] { ??? });
        ??? = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject2).LNJ.get(???);
        if (??? != null) {
          ((com.tencent.mm.plugin.music.model.e.a)???).field_startTime = 0;
        }
      }
      AppMethodBeat.o(62972);
      return paramList;
    }
  }
  
  public final void Zp(int paramInt)
  {
    AppMethodBeat.i(62979);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.LLH)
      {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.LLA.size() <= 1) {
        gnz();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.aV(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        localox = new ox();
        localox.hRN.action = 5;
        localox.publish();
      }
    }
    this.mode = 1;
    ox localox = new ox();
    localox.hRN.action = 5;
    localox.publish();
    com.tencent.mm.plugin.music.model.d.e.aV(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final void a(com.tencent.mm.aw.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.gom();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(271068);
    if (parama == null)
    {
      AppMethodBeat.o(271068);
      return;
    }
    if (this.LLD != null)
    {
      com.tencent.mm.kernel.h.baD().mCm.a(this.LLD);
      this.LLD = null;
    }
    if ((parama.field_songId <= 0) && (TextUtils.isEmpty(parama.field_songMId)))
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10911, "1");
      AppMethodBeat.o(271068);
      return;
    }
    this.LLD = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.h.baD().mCm.a(this.LLD, 0);
    AppMethodBeat.o(271068);
  }
  
  public final URL aOR(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new d.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a aOS(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = o.god().aPg(paramString);
    if (locala != null)
    {
      this.LLA.add(paramString);
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final boolean adu(int paramInt)
  {
    AppMethodBeat.i(271078);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    case 11: 
    case 13: 
    default: 
      boolean bool = super.adu(paramInt);
      AppMethodBeat.o(271078);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zib, 0) == 1)
    {
      AppMethodBeat.o(271078);
      return true;
    }
    AppMethodBeat.o(271078);
    return false;
  }
  
  public final void adw(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.LLA.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.LLA.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.LLA.size();
    }
    if (paramInt != this.LLz)
    {
      this.LLz = paramInt;
      this.LLq.w(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final String ajV(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.c.ajV(paramString);
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.c.aPc(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final String gmU()
  {
    AppMethodBeat.i(271072);
    String str = y.n("wcf://QQMusicCache/", true);
    AppMethodBeat.o(271072);
    return str;
  }
  
  public final void gnA()
  {
    if (this.LLC != null) {
      this.LLC = null;
    }
  }
  
  public final com.tencent.mm.aw.f gng()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.LLA.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.LLA.size() <= this.LLz)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.LLA.get(this.LLz);
      localObject2 = o.god().aPg((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).goq();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final boolean gnh()
  {
    AppMethodBeat.i(270965);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.gnh();
    AppMethodBeat.o(270965);
    return bool;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a gnl()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.LLA.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.LLA.size() <= this.LLz)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.LLA.get(this.LLz);
      localObject2 = o.god().aPg((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean gnm()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = gnl();
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
  
  public final List<String> gnn()
  {
    return this.LLA;
  }
  
  public final void gno()
  {
    this.mode = 1;
  }
  
  public final void gnp()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.LLz += 1;
    this.LLz %= this.LLA.size();
    this.LLq.zI(true);
    this.LLq.w(null);
    AppMethodBeat.o(62982);
  }
  
  public final void gnq()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.LLz = (this.LLz + this.LLA.size() - 1);
    this.LLz %= this.LLA.size();
    this.LLq.zI(true);
    this.LLq.w(null);
    AppMethodBeat.o(62983);
  }
  
  public final int gnr()
  {
    return this.LLz;
  }
  
  public final void gns()
  {
    AppMethodBeat.i(62984);
    if (!this.LLq.gnj().bLk())
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean gnt()
  {
    AppMethodBeat.i(62985);
    if ((this.LLA.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(62985);
      return true;
    }
    AppMethodBeat.o(62985);
    return false;
  }
  
  public final boolean i(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62969);
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(62969);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = gnl();
    if ((locala == null) || (!m.b(locala)))
    {
      Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.LLq.y(paramf);
      AppMethodBeat.o(62969);
      return false;
    }
    if (locala.field_isBlock == 1)
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.LLq.y(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (com.tencent.mm.plugin.music.model.a.c.d(locala))
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
        if (this.LLF != null)
        {
          com.tencent.mm.kernel.h.baD().mCm.a(this.LLF);
          this.LLF = null;
        }
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.LLF = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.h.baD().mCm.a(this.LLF, 0);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(558L, 213L, 1L, true);
      }
    }
    Object localObject = com.tencent.mm.plugin.music.model.a.b.LMO;
    if (com.tencent.mm.plugin.music.model.a.b.c(locala))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get music new url to play");
      if (Util.isNullOrNil(locala.field_mid)) {
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicNewUrl, mid is null");
      }
      for (;;)
      {
        AppMethodBeat.o(62969);
        return false;
        if (this.LLG != null)
        {
          com.tencent.mm.kernel.h.baD().mCm.a(this.LLG);
          this.LLG = null;
        }
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicNewUrl, appid:%s, mid: %s, web_url:%s", new Object[] { locala.field_appId, locala.field_mid, locala.field_songWebUrl });
        paramf = new LinkedList();
        localObject = new dsn();
        ((dsn)localObject).appid = locala.field_appId;
        ((dsn)localObject).oOZ = locala.field_mid;
        ((dsn)localObject).xmo = locala.field_songWebUrl;
        paramf.add(localObject);
        this.LLG = new com.tencent.mm.plugin.music.model.b.d(paramf);
        com.tencent.mm.kernel.h.baD().mCm.a(this.LLG, 0);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(558L, 220L, 1L, true);
      }
    }
    paramf.playUrl = locala.playUrl;
    if (this.LLE != null) {
      com.tencent.mm.kernel.h.baD().mCm.a(this.LLE);
    }
    com.tencent.mm.kernel.h.baD().mCm.a(940, this);
    this.LLE = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.h.baD().mCm.a(this.LLE, 0);
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.h.baD().mCm.a(520, this);
    com.tencent.mm.kernel.h.baD().mCm.a(769, this);
    com.tencent.mm.kernel.h.baD().mCm.a(6473, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.LLB;
    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.rDF = new MMMusicNotificationHelper.1(localb, com.tencent.mm.app.f.hfK);
    localb.rDF.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.aw.f j(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.Y(paramf);
    for (;;)
    {
      int i;
      synchronized (this.lockObj)
      {
        if (this.LLA == null) {
          break label226;
        }
        i = 0;
        if (i < this.LLA.size()) {
          if (str.equals(this.LLA.get(i)))
          {
            this.LLz = i;
            i = 1;
            j = i;
            if (this.LLA.size() > 1)
            {
              j = i;
              if (paramf.oOQ)
              {
                this.mode = 2;
                j = i;
              }
            }
            if (j != 0)
            {
              ??? = gng();
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
        this.LLA.clear();
        this.LLA.add(com.tencent.mm.plugin.music.h.b.Y(paramf));
        this.LLz = 0;
        o.god().K(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        gnz();
        ??? = paramf;
      }
      label226:
      int j = 0;
    }
  }
  
  public final com.tencent.mm.aw.f k(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62971);
    if ((paramf == null) && (this.LLA.size() == 0))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = gng();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.LLA.clear();
        this.LLA.add(com.tencent.mm.plugin.music.h.b.Y(paramf));
        this.LLz = 0;
        o.god().K(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        gnz();
        ??? = paramf;
      }
    }
  }
  
  public final void l(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62973);
    if (paramf != null) {
      synchronized (this.lockObj)
      {
        this.LLA.clear();
        this.LLA.add(com.tencent.mm.plugin.music.h.b.Y(paramf));
        this.LLz = 0;
        o.god().K(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void m(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(270916);
    super.m(paramf);
    o.god().K(paramf);
    AppMethodBeat.o(270916);
  }
  
  public final void n(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(270977);
    super.n(paramf);
    com.tencent.mm.plugin.music.f.a.X(paramf);
    com.tencent.mm.plugin.music.f.a.goE();
    com.tencent.mm.plugin.music.f.a.goH();
    AppMethodBeat.o(270977);
  }
  
  public final void o(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(270981);
    super.o(paramf);
    com.tencent.mm.plugin.music.f.a.goF();
    AppMethodBeat.o(270981);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.h.baD().mCm.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0)
        {
          localObject1 = ((com.tencent.mm.plugin.music.model.b.a)paramp).LMU;
          if ((gnl() != null) && (((abc)localObject1).oOv.equals(gnl().field_musicId))) {
            this.LLq.bLi();
          }
          paramp = o.god();
          localObject1 = ((abc)localObject1).oOv;
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("isBlock", Integer.valueOf(1));
          paramp.db.update("Music", (ContentValues)localObject2, "musicId=?", new String[] { localObject1 });
          paramp = (com.tencent.mm.plugin.music.model.e.a)paramp.LNJ.get(localObject1);
          if (paramp != null) {
            paramp.field_isBlock = 1;
          }
          Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { gnl().field_musicId });
          paramp = new ow();
          paramp.hRM.errCode = paramInt2;
          paramp.hRM.errMsg = paramString;
          paramp.publish();
        }
        AppMethodBeat.o(62995);
        return;
      }
    }
    Object localObject3;
    if ((paramp instanceof com.tencent.mm.plugin.music.model.b.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(62995);
        return;
      }
      paramString = (com.tencent.mm.plugin.music.model.b.b)paramp;
      localObject1 = paramString.LMV;
      localObject2 = paramString.LMB.field_musicId;
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = this.LLA.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          paramp = (String)((Iterator)localObject3).next();
          if (paramp.equals(localObject2))
          {
            localObject2 = w.b(((cqi)localObject1).aawS);
            localObject3 = w.b(((cqi)localObject1).aawT);
            localObject1 = w.b(((cqi)localObject1).aawR);
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(270902);
                o.god().b(paramp, this.LLI, this.LLJ, this.LLK, paramString.LMW, paramString.LMX);
                AppMethodBeat.o(270902);
              }
            });
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject2, localObject3, localObject1 });
            if (!Util.isNullOrNil((String)localObject3))
            {
              paramp = new ox();
              paramp.hRN.action = 6;
              paramp.hRN.musicId = paramString.LMB.field_musicId;
              paramp.asyncPublish(Looper.getMainLooper());
              AppMethodBeat.o(62995);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(62995);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.music.model.b.c))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (com.tencent.mm.plugin.music.model.b.c)paramp;
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.LMZ });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(558L, 214L, 1L, true);
      }
      for (;;)
      {
        paramp = gnl();
        if ((paramp == null) || (TextUtils.isEmpty(paramp.playUrl)) || (!paramp.playUrl.equalsIgnoreCase(paramString.playUrl))) {
          break;
        }
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
        this.LLq.x(paramp.goq());
        AppMethodBeat.o(62995);
        return;
        com.tencent.mm.plugin.music.model.a.c.kz(paramString.playUrl, paramString.LMZ);
      }
      if (paramp != null) {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramp.playUrl, paramString.playUrl });
      }
      AppMethodBeat.o(62995);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.music.model.b.d))
    {
      Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "MusicLiveGetLink onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      localObject2 = (com.tencent.mm.plugin.music.model.b.d)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(558L, 221L, 1L, true);
        localObject3 = gnl();
        paramString = com.tencent.mm.plugin.music.model.a.b.LMO;
        localObject1 = com.tencent.mm.plugin.music.model.a.b.ajV(((com.tencent.mm.plugin.music.model.e.a)localObject3).field_mid);
        if (localObject1 == null) {
          Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "why cacheUrl is null after get new url.");
        }
        if (localObject3 == null) {
          break label1003;
        }
        paramString = ((com.tencent.mm.plugin.music.model.e.a)localObject3).playUrl;
        label819:
        if (localObject1 == null) {
          break label1008;
        }
      }
      label1003:
      label1008:
      for (paramp = (p)localObject1;; paramp = paramString)
      {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "change music url: old Url:%s, new url:%s", new Object[] { paramString, paramp });
        ((com.tencent.mm.plugin.music.model.e.a)localObject3).playUrl = paramp;
        if ((((com.tencent.mm.plugin.music.model.b.d)localObject2).gok() != null) && (((com.tencent.mm.plugin.music.model.b.d)localObject2).gok().get(0) != null))
        {
          localObject2 = (dsp)((com.tencent.mm.plugin.music.model.b.d)localObject2).gok().get(0);
          if ((((dsp)localObject2).Mcq != null) && (((dsp)localObject2).Mcq.length() > 0) && (this.LLC != null)) {
            this.LLC.onCallback(((dsp)localObject2).Mcq);
          }
        }
        this.LLq.x(((com.tencent.mm.plugin.music.model.e.a)localObject3).goq());
        if ((Util.isNullOrNil(paramp)) || (!paramp.equals(paramString))) {
          break label1014;
        }
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, url:%s", new Object[] { ((com.tencent.mm.plugin.music.model.e.a)localObject3).playUrl });
        AppMethodBeat.o(62995);
        return;
        paramString = com.tencent.mm.plugin.music.model.a.b.LMO;
        com.tencent.mm.plugin.music.model.a.b.bG(((com.tencent.mm.plugin.music.model.b.d)localObject2).gok());
        break;
        paramString = null;
        break label819;
      }
      label1014:
      if (localObject3 != null) {
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { ((com.tencent.mm.plugin.music.model.e.a)localObject3).playUrl, localObject1 });
      }
    }
    AppMethodBeat.o(62995);
  }
  
  public final void p(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62989);
    super.p(paramf);
    com.tencent.mm.plugin.music.model.d.e.gom();
    com.tencent.mm.plugin.music.model.d.e.ork = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.h(gnl());
    com.tencent.mm.plugin.music.f.a.goG();
    AppMethodBeat.o(62989);
  }
  
  public final void q(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62990);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.ork = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void r(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62991);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.bLg();
    com.tencent.mm.plugin.music.f.a.onPaused();
    AppMethodBeat.o(62991);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.LLA.clear();
    com.tencent.mm.kernel.h.baD().mCm.b(520, this);
    com.tencent.mm.kernel.h.baD().mCm.b(940, this);
    com.tencent.mm.kernel.h.baD().mCm.b(769, this);
    com.tencent.mm.kernel.h.baD().mCm.b(6473, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.LLB;
    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), MMMusicPlayerService.class);
    MMApplicationContext.getContext().stopService(localIntent);
    localb.LNd = null;
    localb.rDF.dead();
    AppMethodBeat.o(62968);
  }
  
  public final void s(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62992);
    super.s(paramf);
    com.tencent.mm.plugin.music.model.d.e.gom();
    com.tencent.mm.plugin.music.f.a.onStop();
    AppMethodBeat.o(62992);
  }
  
  public final void t(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(62993);
    super.t(paramf);
    com.tencent.mm.plugin.music.model.d.e.gom();
    com.tencent.mm.plugin.music.f.a.onStop();
    if ((this.mode == 2) && ((this.LLz < this.LLA.size() - 1) || (paramf.oOQ)))
    {
      paramf = new ox();
      paramf.hRN.action = 15;
      paramf.hRN.state = "";
      paramf.asyncPublish(Looper.getMainLooper());
      gnp();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void u(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(271023);
    super.u(paramf);
    com.tencent.mm.plugin.music.f.a.goJ();
    AppMethodBeat.o(271023);
  }
  
  public final void v(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(271030);
    super.v(paramf);
    com.tencent.mm.plugin.music.f.a.goI();
    AppMethodBeat.o(271030);
  }
  
  public final void w(List<com.tencent.mm.aw.f> paramList, boolean paramBoolean)
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
          this.LLA.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.aw.f localf = (com.tencent.mm.aw.f)paramList.next();
            this.LLA.add(com.tencent.mm.plugin.music.h.b.Y(localf));
            o.god().K(localf);
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
  
  public static abstract interface b
  {
    public abstract void onCallback(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.l
 * JD-Core Version:    0.7.0.1
 */